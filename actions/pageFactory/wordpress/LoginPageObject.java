package pageFactory.wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageFactory.bankGuru.AbstractPage;

public class LoginPageObject extends AbstractPage {

	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "usernameOrEmail")
	private WebElement emailORUserNameTextbox;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Log In']")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'is-error')]/span")
	private WebElement errorMsg;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordTextBox;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String userNameOREmail) {
		waitForElementVisible(driver, emailORUserNameTextbox);
		sendKeyToElement(driver, emailORUserNameTextbox, userNameOREmail);
	}

	public DashboardPageObject clickLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		return PageFactoryManager.getDashboardPage(driver);
	}

	public String getActualErrorMsg() {
		waitForElementVisible(driver, errorMsg);
		return getElementText(driver, errorMsg);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, passwordTextBox);
		sendKeyToElement(driver, passwordTextBox, password);
	}

	public LoginPageObject OpenLoginPage(String url) {
		openURL(driver, url);
		return new LoginPageObject(driver);
	}

	public String getLoginPageURL() {
		return driver.getCurrentUrl();
	}

	public void clickContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

}
