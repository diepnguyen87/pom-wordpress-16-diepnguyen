package pageObjects.bankGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
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
		return getTextElement(driver, RegisterPageUI.USERID);
	}

	public String getPassword() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD);
		return getTextElement(driver, RegisterPageUI.PASSWORD);
	}

	public void openPageByURL(String url) {
		driver.get(url);
	}

}
