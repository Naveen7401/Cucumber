package org.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
//appFeature\\Login.feature
@SelectClasspathResource("appFeature")
@ConfigurationParameter(key = "cucumber.glue", value = "org.stepdefinition")
@ConfigurationParameter(key = "cucumber.plugin", value = "pretty, html:target/cucumber-reports/Cucumber.html, json:target/cucumber-reports/Cucumber.json, junit:target/cucumber-reports/Cucumber.xml")
@ConfigurationParameter(key = "cucumber.execution.parallel.enabled", value = "true")
@ConfigurationParameter(key = "cucumber.execution.parallel.config.fixed.parallelism", value = "4")
@ConfigurationParameter(key = "cucumber.execution.parallel.config.strategy", value = "fixed")
public class ParallelCucumberTest {

}
