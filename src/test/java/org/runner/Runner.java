package org.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\appFeature", glue = {
		"org.stepdefinition" }, dryRun = false, monochrome = true,
//tags = "@multipleLogin",
		plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html", // HTML report
				"json:target/cucumber-reports/Cucumber.json", // JSON report
				"junit:target/cucumber-reports/Cucumber.xml" // JUnit XML report
		})
public class Runner {

//	@RunWith(Cucumber.class)
//	@CucumberOptions(features = "src\\test\\resources\\appFeature\\Login.feature", glue = {
//			"org.stepdefinition" }, dryRun = false, monochrome = true,
//	//tags = "@multipleLogin",
//			plugin = { "pretty", "html:target/cucumber-reports/Cucumber.html", // HTML report
//					"json:target/cucumber-reports/Cucumber.json", // JSON report
//					"junit:target/cucumber-reports/Cucumber.xml" // JUnit XML report
//			})
}
