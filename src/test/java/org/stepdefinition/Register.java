package org.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	@Given("I am on the register page")
	public void i_am_on_the_register_page() {
	   System.out.println("Register 1");
	}

	@When("I enter valid data in all the fields")
	public void i_enter_valid_data_in_all_the_fields() {
		System.out.println("Register 2");
	}

	@Then("Account is created")
	public void account_is_created() {
		System.out.println("Register 3");
	}

}
