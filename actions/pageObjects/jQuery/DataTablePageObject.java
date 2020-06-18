package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.jQuery.AbstractPage;
import pageUI.jQuery.DataTablePageUI;

public class DataTablePageObject extends AbstractPage{

	private WebDriver driver;
	
	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnByName(String columnName, String value) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, columnName);
		sendKeyToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, value, columnName);
		sendKeyboardToElement(driver, DataTablePageUI.DYNAMIC_HEADER_COLUMN_TEXT, Keys.ENTER, columnName);
	}

	public boolean isOnlyOneRowDisplayed(String value) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		int rowNumber = countElementNumber(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		boolean status = isElementDisplayed(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		return (rowNumber==1 & status);
	}

	public void clickToDynamicIconByCountryName(String icon, String countryName) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_ICON_BY_COUNTRY, countryName, icon);
		clickToElement(driver, DataTablePageUI.DYNAMIC_ICON_BY_COUNTRY, countryName, icon);
		sleepInSecond(5);
	}

	public void navigateToPageNumberByIndex(String pageIndex) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE_BY_INDEX, pageIndex);
		clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE_BY_INDEX, pageIndex);
	}

	public boolean isPageActivedByIndex(String pageIndex) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageIndex);
		return isElementDisplayed(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVED_BY_INDEX, pageIndex);
	}

	public void inputToDynamicTextboxAtRowNumber(String columnName, String rowNumber, String inputValue) {
		waitForElementVisible(driver, DataTablePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName);
		int columnPosition = countElementNumber(driver, DataTablePageUI.DYNAMIC_COLUMN_POSITION_INDEX, columnName) + 1;
		
		sendKeyToElement(driver, DataTablePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN, inputValue, rowNumber, String.valueOf(columnPosition));
	}
}
