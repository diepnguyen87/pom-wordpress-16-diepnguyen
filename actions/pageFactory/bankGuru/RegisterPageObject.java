package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage{

	private WebDriver driver;

	@FindBy(how=How.NAME, using = "emailid")
	private WebElement emailTextbox;
	
	@FindBy(how=How.NAME, using = "btnLogin")
	private WebElement loginButton;
	
	@FindBy(how = How.XPATH, using = "//td[text()='User ID :']/following-sibling::td")
	private WebElement userID;
	
	@FindBy(how = How.XPATH, using = "//td[text()='Password :']/following-sibling::td")
	private WebElement password;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, this.emailTextbox, email);
	}

	public void clickSubmitButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getUserID() {
		waitForElementVisible(driver, userID);
		return getElementText(driver, userID);
	}

	public String getPassword() {
		waitForElementVisible(driver, password);
		return getElementText(driver, password);
	}

	public LoginPageObject openLoginPage(String url) {
		openURL(driver, url);
		return PageFactoryManager.getLoginPage(driver);
	}

}
