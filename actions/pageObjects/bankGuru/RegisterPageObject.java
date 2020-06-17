package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.wordpress.AbstractPage;
import pageUI.bankGuru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL);
		sendKeyToElement(driver, RegisterPageUI.EMAIL, email);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, RegisterPageUI.LOGIN_BUTTON);
		clickToElement(driver, RegisterPageUI.LOGIN_BUTTON);
	}

	public String getUserID() {
		waitForElementVisible(driver, RegisterPageUI.USERID);
		return getElementText(driver, RegisterPageUI.USERID);
	}

	public String getPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD);
		return getElementText(driver, RegisterPageUI.PASSWORD);
	}

	public LoginPageObject openLoginPage(String url) {
		driver.get(url);
		return new LoginPageObject(driver);
	}


}
