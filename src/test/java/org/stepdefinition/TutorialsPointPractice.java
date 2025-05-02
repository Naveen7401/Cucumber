package org.stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Alert_Frame_windows_Objects;
import pageobject.TutorialPointPageObject;
import utils.BaseClass;

public class TutorialsPointPractice extends BaseClass {
	@When("Clicking the elements option")
	public void clicking_the_elements_option() {
		waitForElementClickable(TutorialPointPageObject.tp().getElementsTextDropdown());
	}

	@When("Clicking the Text Box")
	public void clicking_the_text_box() {
		waitForElementClickable(TutorialPointPageObject.tp().getTextBoxtextDropdown());
	}

	@When("Entering {string} and \"<Email>\"and\"<Current Address>\"and\"<Password>\"")
	public void entering_and_email_and_current_address_and_password(String string) {
		sendKeys(TutorialPointPageObject.tp().getFullnameElement(), "AbCd");
		sendKeys(TutorialPointPageObject.tp().getEmailElement(), "abcd@gmail.com");
		sendKeys(TutorialPointPageObject.tp().getAddressElement(), "Chennai");
		sendKeys(TutorialPointPageObject.tp().getPasswordElement(), "AbCd@123");

	}

	@Then("Clicking the Submit button")
	public void clicking_the_submit_button() {
		waitForElementClickable(TutorialPointPageObject.tp().getSubmitBtnTextBoxpage());
	}

	// CAse 2 CheckBox Selection
	@When("Clicking check Box Dropdown redirect to CheckBox Page")
	public void clicking_check_box_dropdown_redirect_to_check_box_page() {
		waitForElementClickable(TutorialPointPageObject.tp().getcheckBoxTextDropdown());
	}

	@When("Clicking the checkbox")
	public void clicking_the_checkbox() {
		waitForElementClickable(TutorialPointPageObject.tp().getcheckBox_first());
	}

	// 3rd Scenario

	@When("Clicking the Radio Button text in the dropdown")
	public void clicking_the_radio_button_text_in_the_dropdown() {
		waitForElementClickable(TutorialPointPageObject.tp().getRadioButton_Dropdowntext_first());
	}

	@When("Selecting the Radio Button")
	public void selecting_the_radio_button() {
		waitForElementClickable(TutorialPointPageObject.tp().getRadioButton_Yes_first());
	}

	// Alert frame window feature file

	@Given("Click on the Alert,frame & Windows tab")
	public void click_on_the_alert_frame_windows_tab() {
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getAlert_frame_windows_dropDownText());
	}

	@When("Clicking on the browser windows tab")
	public void clicking_on_the_browser_windows_tab() {
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getBrowserWindowTab());
	}

	@When("Clicking the New Tab")
	public void clicking_the_new_tab() {
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getNewTabButton());
	}

	@Then("Check the tab is opened")
	public void check_the_tab_is_opened() {

		switchingWindow();
		WebElement waitForElementVisible = waitForElementVisible(By.xpath("//h1[text()='New Tab']"));
		waitForElementVisible.isDisplayed();
		BaseClass.getDriver().close();
		switchingBack();
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getAlert_frame_windows_dropDownText());
	}

	// 2nd case

	@When("Clicking the New Window")
	public void clicking_the_new_window() {
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getNewWindowButton());
	}

	@Then("Check the New Window is opened")
	public void check_the_new_window_is_opened() {
		switchingWindow();
		WebElement waitForElementVisible = waitForElementVisible(By.xpath("//h1[text()='New Window']"));
		waitForElementVisible.isDisplayed();
		BaseClass.getDriver().close();
		switchingBack();
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getAlert_frame_windows_dropDownText());
	}

	// 3rd Case

	@When("Clicking the New Window Message button")
	public void clicking_the_new_window_message_button() {
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getNewWindowMessageButton());
	}

	@Then("Check the message is displayed")
	public void check_the_message_is_displayed() {
		switchingWindow();
		WebElement waitForElementVisible = waitForElementVisible(By.xpath("//h1[text()='New Window Message']"));
		waitForElementVisible.isDisplayed();
		BaseClass.getDriver().close();
		switchingBack();
		waitForElementClickable(Alert_Frame_windows_Objects.AFWO().getAlert_frame_windows_dropDownText());
	}

}
