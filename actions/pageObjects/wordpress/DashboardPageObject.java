package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
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

	public PostsPageObject clickToPostsMenu() {
		waitForElementClickable(driver, DashboardPageUI.POST_MENU);
		clickToElement(driver, DashboardPageUI.POST_MENU);
		return PageFactoryManager.getPostsPage(driver);
	}

}

