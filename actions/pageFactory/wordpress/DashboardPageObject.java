package pageFactory.wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageFactory.bankGuru.AbstractPage;

public class DashboardPageObject extends AbstractPage {

	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//h1[text()='Dashboard']")
	private WebElement dashboardHeader;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isDashboardPageDisplay() {
		waitForElementVisible(driver, dashboardHeader);
		return isControlDisplayed(driver, dashboardHeader);
	}
}
