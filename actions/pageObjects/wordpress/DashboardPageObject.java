package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.DashboardPageUI;

public class DashboardPageObject extends AbstractPage {

	private WebDriver driver;
	
	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardPageDisplay() {
		waitForElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER);
		return isControlDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER);
	}

	@Override
	public boolean isPageLoaded(String pageURL) {
		String actualURL = getCurrentURL(driver);
		return actualURL.endsWith(pageURL);
	}
}

