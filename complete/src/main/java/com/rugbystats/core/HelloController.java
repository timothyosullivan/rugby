package com.rugbystats.core;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HistoricalResultsService historicalResultsService;

	@GetMapping("/")
	public String index() throws IOException, PropertyVetoException, SQLException {
		historicalResultsService.createResultsTable();
		return "Hello World!";
	}

}
