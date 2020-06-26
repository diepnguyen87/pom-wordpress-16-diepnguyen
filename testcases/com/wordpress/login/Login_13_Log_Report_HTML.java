package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.wordpress.AbstractTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageFactoryManager;

public class Login_13_Log_Report_HTML extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-condition - Open browser");
		driver = getBrowserDriver(browserName);	
		
		log.info("Pre-condition - STEP 01: open login page");
		loginOjbect = PageFactoryManager.getLoginPage(driver);
		
		log.info("Pre-condition - STEP 02: input to 'Email' textbox");
		loginOjbect.enterEmail("automationeditor");
		
		log.info("Pre-condition - STEP 03: click 'Continue' button");
		loginOjbect.clickContinueButton();
		
		log.info("Pre-condition - STEP 04: input to 'Password' textbox");
		loginOjbect.enterPassword("automationfc");
		
		log.info("Pre-condition - STEP 05: click 'Login' button");
		dashboardObject = loginOjbect.clickLoginButton();
	}

	
	@Test
	public void TC_01_Element_Undisplayed_In_Dom() {
		log.info("Element_Undisplayed_In_Dom - STEP 01: click to 'Screen Options' button");
		dashboardObject.clickScreenOptions();		
		
		log.info("Element_Undisplayed_In_Dom - STEP 02: verify 'Activity' checkbox display");
		verifyFalse(dashboardObject.isActivityCheckBoxDisplayed());
		//failed
		
		log.info("Element_Undisplayed_In_Dom - STEP 03: click to 'Screen Options' button");
		dashboardObject.clickScreenOptions();
		
		log.info("Element_Undisplayed_In_Dom - STEP 04: verify 'Activity' checkbox is NOT displayed");
		verifyTrue(dashboardObject.isActivityCheckBoxDisplayed());
		//failed
	}
	
	@Test
	public void TC_02_Element_Undisplayed_Without_Dom() {
		log.info("Element_Undisplayed_Without_Dom - STEP 01: verify 'Plans' menu is NOT displayed");
		verifyFalse(dashboardObject.isPlansMenuUndisplayed());
		//failed
		
		log.info("Element_Undisplayed_Without_Dom - STEP 02: click to 'POST' menu");
		dashboardObject.clickPostsMenu();
	}
		
	@AfterClass
	public void afterClass() {
		log.info("Post-condition - close browser");
	}

}
