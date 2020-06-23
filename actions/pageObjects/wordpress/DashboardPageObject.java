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

	public void clickScreenOptions() {
		waitForElementVisible(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);
		clickToElement(driver, DashboardPageUI.SCREEN_OPTIONS_BUTTON);
		sleepInSecond(3);
	}

	public boolean isActivityCheckBoxDisplayed() {
		return isElementDisplayed(driver, DashboardPageUI.ACTIVITY_CHECKBOX);
	}

	public boolean isPlansMenuDisplayed() {
		return isElementDisplayed(driver, DashboardPageUI.PLANS_MENU);	
	}

	public boolean isPlansMenuUndisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.PLANS_MENU);
	}

	public void clickPostsMenu() {
		clickToElement(driver, DashboardPageUI.POST_MENU);	
	}

	public boolean isAddNewButtonUndisplayed() {
		return isElementUndisplayed(driver, DashboardPageUI.ADD_NEW_BUTTON);
	}

}

