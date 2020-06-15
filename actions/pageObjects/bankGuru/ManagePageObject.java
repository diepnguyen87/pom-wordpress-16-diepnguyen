package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.bankGuru.ManagerPageUI;

public class ManagePageObject extends AbstractPage {

	private WebDriver driver;

	public ManagePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isWelcomeMsgDisplayed() {
		return isControlDisplayed(driver, ManagerPageUI.WELCOME_MSG);
	}
}
