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

public class Login_11_Element_Undisplayed extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		loginOjbect = PageFactoryManager.getLoginPage(driver);
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("automationfc");
		dashboardObject = loginOjbect.clickLoginButton();
	}

	
	@Test
	public void TC_01_Element_Undisplayed_In_Dom() {
		dashboardObject.clickScreenOptions();		
		verifyFalse(dashboardObject.isActivityCheckBoxDisplayed());
		//sai
		dashboardObject.clickScreenOptions();
		verifyFalse(dashboardObject.isActivityCheckBoxDisplayed());
	}
	
	@Test
	public void TC_02_Element_Undisplayed_Without_Dom() {
		verifyTrue(dashboardObject.isPlansMenuUndisplayed());
		dashboardObject.clickPostsMenu();
		
		//sai
	}
		
	@AfterClass
	public void afterClass() {
	}

}
