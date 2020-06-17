package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.bankguru.AbstractPage;
import pageUI.bankGuru.ManagerPageUI;

public class ManagerPageObject extends AbstractPage {

	private WebDriver driver;

	public ManagerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isWelcomeMsgDisplayed() {
		return isControlDisplayed(driver, ManagerPageUI.WELCOME_MSG);
	}



}
