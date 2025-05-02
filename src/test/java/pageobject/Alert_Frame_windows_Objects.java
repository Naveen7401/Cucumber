package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

public class Alert_Frame_windows_Objects {

	public Alert_Frame_windows_Objects() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public static synchronized Alert_Frame_windows_Objects AFWO() {
		Alert_Frame_windows_Objects AFWObj = new Alert_Frame_windows_Objects();
		return AFWObj;
	}

	@FindBy(xpath = "//button[text()=' Alerts, Frames & Windows ']")
	private WebElement alert_frame_windows_dropDownText;

	@FindBy(xpath = "//a[text()=' Browser Windows']")
	private WebElement browserWindowTab;

	@FindBy(xpath = "//button[text()='New Tab']")
	private WebElement newTabButton;

	@FindBy(xpath = "//button[text()='New Window']")
	private WebElement newWindowButton;

	@FindBy(xpath = "//button[text()='New Window Message']")
	private WebElement newWindowMessageButton;

	public WebElement getAlert_frame_windows_dropDownText() {
		return alert_frame_windows_dropDownText;
	}

	public WebElement getBrowserWindowTab() {
		return browserWindowTab;
	}

	public WebElement getNewTabButton() {
		return newTabButton;
	}

	public WebElement getNewWindowButton() {
		return newWindowButton;
	}

	public WebElement getNewWindowMessageButton() {
		return newWindowMessageButton;
	}
}
