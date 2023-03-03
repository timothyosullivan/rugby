package com.rugbystats.core;

import javax.sql.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.PGConnection;
import org.postgresql.copy.CopyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricalResultsService {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    public void createResultsTable() throws IOException, SQLException {
        
        // 1. check table doesn't already exist
        DataSource dataSource = dataSourceConfig.datasource(null);
        try (Statement stmt = dataSource.getConnection().createStatement()) {
		    
		    stmt.execute("SELECT COUNT(table_name) FROM information_schema.tables WHERE table_schema LIKE 'public' AND table_name = 'results';");
            ResultSet resultset = stmt.getResultSet();

            resultset.next(); // move to first and only row result
            if (resultset.getInt(1) == 0) {
                // table doesn't yet exist so create
                String sql = "CREATE TABLE results (id SERIAL, date DATE, home_team VARCHAR(50), away_team VARCHAR(50), home_score INTEGER, away_score INTEGER, competition VARCHAR(200), stadium VARCHAR(100), city VARCHAR(50), country VARCHAR(50), neutral BOOLEAN, world_cup BOOLEAN, PRIMARY KEY (id))";
                 stmt.execute(sql);

                // table now needs to be populated with csv dump
                System.out.println("Copying results from csv file");
                CopyManager copyManager = ((PGConnection) dataSource.getConnection()).getCopyAPI();
                InputStream inputStream = HistoricalResultsService.class.getClassLoader().getResourceAsStream("raw_data/results.csv");

                copyManager.copyIn("COPY results (date, home_team, away_team, home_score, away_score, competition, stadium, city, country, neutral, world_cup) FROM STDIN (Delimiter ',')", 
                        inputStream);
                System.out.println("Population of results table done.");
            }
        } catch (NullPointerException npException) {
            npException.printStackTrace(System.out);
        } finally {
            dataSource.getConnection().close();  // Multiple streams were opened. Only the last is closed.
        }
    }
}