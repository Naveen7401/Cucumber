package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.Interaction_Object;
import utils.BaseClass;

public class Interaction extends BaseClass {

	@Given("Clicking the interaction tab")
	public void clicking_the_interaction_tab() {
		waitForElementClickable(Interaction_Object.IO().getInteraction_dropDown());
	}

	@When("Cilcking the Resizeable")
	public void cilcking_the_resizeable() {
		waitForElementClickable(Interaction_Object.IO().getResizable_dropDown());
	}

	@When("Resizing the box")
	public void resizing_the_box() throws InterruptedException {
		WebElement resizableElement = getDriver().findElement(By.xpath("//div[@class='both selector']"));

		Actions a = new Actions(getDriver());
		Thread.sleep(2000);
		a.moveToElement(resizableElement, 90, 35).clickAndHold().moveByOffset(150, 75).release().perform();
		WebElement ele = getDriver().findElement(By.xpath("//div[@class='flex-']"));
//		Thread.sleep(2000);
		a.moveToElement(ele, 200, 100).clickAndHold().moveByOffset(300, 150).release().perform();
		Thread.sleep(5000);
	}

	// Case 2

	@Given("Clicking the widgets dropdown")
	public void clicking_the_widgets_dropdown() {
		waitForElementClickable(Interaction_Object.IO().getWidgets_dropDown());
	}

	@When("Clicking the horizontal scroll Dropdown")
	public void clicking_the_horizontal_scroll_dropdown() {
		waitForElementClickable(Interaction_Object.IO().getHorizontalScroll_dropDown());
	}

	@When("Scrolling horizontal action")
	public void scrolling_horizontal_action() throws InterruptedException {
		Actions a = new Actions(getDriver());// 982 633 930 583
		WebElement element = getDriver().findElement(By.xpath("//div[@class='horizan-scroll']"));
//		a.moveToElement(element, 100, 50).clickAndHold().moveByOffset(0, 0).release().perform();
//		Thread.sleep(5000);
	}

	// 3rd Case

	@When("Clicking Draggable tab")
	public void clicking_draggable_tab() {
		waitForElementClickable(Interaction_Object.IO().getDraggable_Tab());
	}

	@When("Clicking Axis Restricted")
	public void clicking_axis_restricted() {
		waitForElementClickable(Interaction_Object.IO().getAxis_Restricted_Tab());
	}

	@Then("Dragging the X Axis")
	public void dragging_the_x_axis() throws InterruptedException {
		WebElement findElement = getDriver().findElement(By.id("div_element"));
		Actions a = new Actions(getDriver());
		a.moveToElement(findElement).clickAndHold().moveByOffset(250, 0).release().perform();
	}

	@Then("Dragging the Y Axis")
	public void dragging_the_y_axis() throws InterruptedException {
		WebElement findElement = getDriver().findElement(By.id("div_elementy"));
		Actions a = new Actions(getDriver());
		a.moveToElement(findElement).clickAndHold().moveByOffset((int) 0.828, 220).release().perform();
	}
}
