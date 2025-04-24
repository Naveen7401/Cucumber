package org.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

public class Login extends BaseClass {

	// 1st case
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		System.out.println("I am on the login page");
	}

	@Then("I should be redirected to the dashboard")
	public void i_should_be_redirected_to_the_dashboard() {
		System.out.println("I am on the login page");
	}

	// 2nd case
	@When("I enter invalid credentials")
	public void i_enter_invalid_credentials() {

	}

	@Then("Error message should appear")
	public void error_message_should_appear() {

	}

	@Given("Redirected to login page") // 3rd case
	public void redirected_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I enter {string} and {string}")
	public void i_enter_and(String string, String string2) {
		System.out.println(string);
		System.out.println(string2);
	}

	@Then("I should see a welcome message")
	public void i_should_see_a_welcome_message() {
		// Write code here that turns the phrase above into concrete actions
	}

}
