package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUI.bankGuru.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageByURL() {
		return driver.getCurrentUrl();
	}

	public void clickToHereLink() {
		waitForElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}

	public void enterUserID(String userID) {
		waitForElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}


	
	
}
