package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
	
	private WebDriver driver;

	@FindBy(how=How.XPATH, using = "//a[contains(text(),'here')]")
	private WebElement hereLink;
	
	@FindBy(how=How.NAME, using = "uid")
	private WebElement userIDTextbox;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.NAME, using = "btnLogin")
	private WebElement loginButton;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageByURL() {
		return getCurrentURL(driver);
	}

	public RegisterPageObject clickToHereLink() {
		waitForElementClickable(driver, hereLink);
		clickToElement(driver, hereLink);
		return PageFactoryManager.getRegisterPage(driver);
	}

	public void enterUserID(String userID) {
		waitForElementVisible(driver, userIDTextbox);
		sendKeyToElement(driver, userIDTextbox, userID);
	}

	public void enterPassword(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public ManagePageObject clickLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		return PageFactoryManager.getManagePage(driver);
	}

}
