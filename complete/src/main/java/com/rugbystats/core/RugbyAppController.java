package com.rugbystats.core;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RugbyAppController {

	@Autowired
	HistoricalResultsService historicalResultsService;
	@Autowired
	private IMatchService matchService;

	@GetMapping("/")
	public String index() throws IOException, SQLException {
		historicalResultsService.createResultsTable();
		return "index";
	}

	@GetMapping("/showResults")
	public String showResults(Model model) {
		var matches = matchService.findAll();

		model.addAttribute("matches", matches);
		return "showResults";
	}

}
