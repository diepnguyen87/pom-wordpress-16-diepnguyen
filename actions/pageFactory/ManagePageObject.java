package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ManagePageObject extends AbstractPage {

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//marquee[contains(text(), 'Welcome To Manager')]")
	private WebElement welcomeMsg;

	public ManagePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isWelcomeMsgDisplayed() {
		return isControlDisplayed(driver, welcomeMsg);
	}
}
