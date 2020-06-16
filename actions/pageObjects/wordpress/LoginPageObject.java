package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUI.wordpress.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}

	public void enterEmail(String emailOrUserName) {
		waitForElementVisible(driver, LoginPageUI.EMAILORUSERNAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAILORUSERNAME_TEXTBOX, emailOrUserName);
	}

	public void clickContinueButton() {
		waitForElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
	}

	public String getActualErrorMsg() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MSG);
		return getElementText(driver, LoginPageUI.ERROR_MSG);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}

	public void OpenLoginPage(String loginURL) {
		driver.get(loginURL);
	}
}
