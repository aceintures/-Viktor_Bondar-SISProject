package com.neotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// we can specify which feature/features to run
		features = "src/test/resources/features/",

		// we can specify where the code for the above feature files is located
		glue = "com.neotech.steps",

		// if true, it does not run the java classes. Only checks the feature files
		// if they are glued to some java code
		dryRun = false,

		// tags can do the same thing groups on TestNG do
		tags = "@regression",

		// it shows the console format more clear by removing weird chars
		monochrome = true,

		plugin = {
				// print the gherkin steps into the console
				"pretty",
				// creates a basic html report on the target folder
				"html:target/cucumber-default-report.html",
				// stores every step/info of the execution on this json file
				"json:target/cucumber.json" })

public class TestRunner {

}