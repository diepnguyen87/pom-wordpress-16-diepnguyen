package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.wordpress.AbstractPage;
import pageUI.wordpress.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {

	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardPageDisplay() {
		waitForElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER);
	}

}

