package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v129.io.IO;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class Interaction_Object {

	public Interaction_Object() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public static synchronized Interaction_Object IO() {
		Interaction_Object ref = new Interaction_Object();
		return ref;
	}

	@FindBy(xpath = "//button[text()=' Interaction']")
	private WebElement Interaction_dropDown;

	@FindBy(xpath = "//a[text()=' Resizable']")
	private WebElement Resizable_dropDown;

	@FindBy(xpath = "//button[text()=' Widgets']")
	private WebElement Widgets_dropDown;

	@FindBy(xpath = "//a[text()=' Horizontal Scroll']")
	private WebElement horizontalScroll_dropDown;

	@FindBy(xpath = "//div[@class='horizan-scroll']")
	private WebElement horizontalScroll;

	@FindBy(xpath = "//a[text()=' Dragabble']")
	private WebElement draggable_Tab;

	@FindBy(xpath = "//button[text()='Axis Restricted']")
	private WebElement axis_Restricted_Tab;

	public WebElement getAxis_Restricted_Tab() {
		return axis_Restricted_Tab;
	}

	public void setAxis_Restricted_Tab(WebElement axis_Restricted_Tab) {
		this.axis_Restricted_Tab = axis_Restricted_Tab;
	}

	public WebElement getDraggable_Tab() {
		return draggable_Tab;
	}

	public WebElement getHorizontalScroll() {
		return horizontalScroll;
	}

	public WebElement getWidgets_dropDown() {
		return Widgets_dropDown;
	}

	public WebElement getHorizontalScroll_dropDown() {
		return horizontalScroll_dropDown;
	}

	public WebElement getInteraction_dropDown() {
		return Interaction_dropDown;
	}

	public WebElement getResizable_dropDown() {
		return Resizable_dropDown;
	}

}
