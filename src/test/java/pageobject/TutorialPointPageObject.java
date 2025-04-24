package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class TutorialPointPageObject extends BaseClass {

	public TutorialPointPageObject() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public static synchronized TutorialPointPageObject tp() {
		TutorialPointPageObject tpo = new TutorialPointPageObject();
		return tpo;

	}

	@FindBy(xpath = "//*[text()=' Elements']")
	private WebElement ElementsTextDropdown;

	@FindBy(xpath = "//*[text()=' Text Box']")
	private WebElement TextBoxtextDropdown;

	@FindBy(name = "fullname")
	private WebElement fullnameElement;

	@FindBy(name = "email")
	private WebElement emailElement;

	@FindBy(name = "address")
	private WebElement addressElement;

	@FindBy(name = "password")
	private WebElement passwordElement;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtnTextBoxpage;

	@FindBy(xpath = "//*[text()=' Check Box']")
	private WebElement checkBoxTextDropdown;

	@FindBy(xpath = "//li[@id='bs_1']/span/following-sibling::input")
	private WebElement checkBox_first;

	@FindBy(xpath = "//a[text()=' Radio Button']")
	private WebElement RadioButton_Dropdowntext_first;

	@FindBy(xpath = "//label[text()='Yes']/preceding-sibling::input[@name='tab']")
	private WebElement RadioButton_Yes_first;

	public WebElement getFullnameElement() {
		return fullnameElement;
	}

	public WebElement getEmailElement() {
		return emailElement;
	}

	public WebElement getAddressElement() {
		return addressElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}

	public WebElement getTextBoxtextDropdown() {
		return TextBoxtextDropdown;
	}

	public WebElement getElementsTextDropdown() {
		return ElementsTextDropdown;
	}

	public WebElement getSubmitBtnTextBoxpage() {
		return submitBtnTextBoxpage;
	}

	public WebElement getcheckBoxTextDropdown() {
		return checkBoxTextDropdown;
	}

	public WebElement getcheckBox_first() {
		return checkBox_first;
	}

	public WebElement getRadioButton_Dropdowntext_first() {
		return RadioButton_Dropdowntext_first;
	}

	public WebElement getRadioButton_Yes_first() {
		return RadioButton_Yes_first;
	}
}
