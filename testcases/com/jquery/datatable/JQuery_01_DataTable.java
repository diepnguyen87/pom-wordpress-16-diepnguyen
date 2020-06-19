package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.jQuery.AbstractTest;
import pageObjects.jQuery.DataTablePageObject;

public class JQuery_01_DataTable extends AbstractTest {

	private WebDriver driver;
	private DataTablePageObject tableObject;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		tableObject = new DataTablePageObject(driver);
	}
	

	public void TC_01_inputToColumnByName() {
		tableObject.inputToColumnByName("Country", "Argentina");
		Assert.assertTrue(tableObject.isOnlyOneRowDisplayed("Argentina"));
		
		tableObject.refresh(driver);
		
		tableObject.inputToColumnByName("Total", "1504");
		Assert.assertTrue(tableObject.isOnlyOneRowDisplayed("1504"));
	}
	

	public void TC_02_editDeleteIconByCountryName() {
		tableObject.refresh(driver);
		
		tableObject.clickToDynamicIconByCountryName("remove", "Afghanistan");
		tableObject.clickToDynamicIconByCountryName("remove", "Angola");
		tableObject.clickToDynamicIconByCountryName("remove", "Argentina");
		
		tableObject.clickToDynamicIconByCountryName("edit", "Albania");	
	}
	
	public void TC_03_PagingByPageIndex() {
		tableObject.refresh(driver);
		tableObject.navigateToPageNumberByIndex("10");
		Assert.assertTrue(tableObject.isPageActivedByIndex("10"));
		
		tableObject.navigateToPageNumberByIndex("15");
		Assert.assertTrue(tableObject.isPageActivedByIndex("15"));
		
		tableObject.navigateToPageNumberByIndex("20");
		Assert.assertTrue(tableObject.isPageActivedByIndex("20"));
		
	}

	@Test
	public void TC_04() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		tableObject.inputToDynamicTextboxAtRowNumber("Company", "3", "KMS Technology");
		tableObject.inputToDynamicTextboxAtRowNumber("Contact Person", "2", "Viet Hung");
		tableObject.inputToDynamicTextboxAtRowNumber("Order Placed", "1", "28 Truong Son");
	}
	
	@AfterClass
	public void afterClass() {
	
	}
	
}
