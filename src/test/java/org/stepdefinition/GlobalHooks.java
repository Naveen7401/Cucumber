package org.stepdefinition;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.BaseClass;

public class GlobalHooks extends BaseClass {
	
	
	 private static final String config = System.getProperty("user.dir") + "/src/test/resources/propertyFile/config.properties";

	    @BeforeAll
	    public static void setUpReport() {  // This method must be static and have no parameters
	        BaseClass.setUpReport();
	    }

	    @Before
	    public void beforeScenario(Scenario scenario) { // `@Before` methods CAN take Scenario as a parameter
	        beforeSce(scenario);
	        launchBrowser("Chrome");
	        try {
	            openUrl(getConfigProperty(config, "URL"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @After
	    public void failedCases(Scenario scenario) {
	        afterScenario(scenario);
	        tearDown();
	    }

	    @AfterAll
	    public static void tearDownReport() {  // `@AfterAll` methods must be static and have no parameter
	        flush();
	    }
//
//	private static final String config = /* C:\Users\naveensivamani\eclipse-workspace\UpdatedLaunch */System
//			.getProperty("user.dir") + "/src/test/resources/propertyFile/config.properties";
//
//	@Before
//	public static void beforeScenario(Scenario scenario) {
//		beforeSce(scenario);
//		launchBrowser("Chrome");
//		try {
//			openUrl(getConfigProperty(config, "URL"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@After
//	public void FailedCases(Scenario scenario) {
//		afterScenario(scenario);
//	}
//
//	// Screenshot captures
//	@BeforeAll
//	public static void capture() {
//		setUpReport();
//	}
//
//	@AfterAll
//	public static void afte(Scenario scenario) {
////		if (scenario.isFailed()) {
////			System.out.println("Failed Scenario");
////		}
//		tearDown();
//		flush();
//
//	}

}
