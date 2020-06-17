package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.wordpress.AbstractTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.PageFactoryManager;

public class Login_06_MultipleBrowser_Parallel extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	private String loginURL;
	private String actualErrorMsg;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		loginOjbect = PageFactoryManager.getLoginPage(driver);
		loginURL = loginOjbect.getLoginPageURL();
	}

	@Test
	public void TC_01_EmptyEmail() {
		loginOjbect.enterEmail("");
		loginOjbect.clickContinueButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Please enter a username or email address.");
	}
	
	@Test
	public void TC_02_InvalidEmail() {
		loginOjbect.enterEmail("123@123.123");
		loginOjbect.clickContinueButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Please log in using your WordPress.com username instead of your email address.");
	}

	@Test
	public void TC_03_EmailNotExist() {
		loginOjbect.enterEmail("diep96@gmail.com");
		loginOjbect.clickContinueButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "User does not exist. Would you like to create a new account?");
	}
	
	@Test
	public void TC_04_EmptyPasword() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("");
		loginOjbect.clickLoginButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Don't forget to enter your password.");
		loginOjbect.OpenLoginPage(loginURL);
		loginOjbect = new LoginPageObject(driver);
	}

	@Test
	public void TC_05_PasswordLessThan6Chars() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("123");
		loginOjbect.clickLoginButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Oops, that's not the right password. Please try again!");
		loginOjbect.OpenLoginPage(loginURL);
		loginOjbect = new LoginPageObject(driver);
	}
	
	@Test
	public void TC_06_ValidPassword() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("automationfc");
		loginOjbect.clickLoginButton();
		dashboardObject = new DashboardPageObject(driver);
		Assert.assertTrue(dashboardObject.isDashboardPageDisplay());
	}

	@AfterClass
	public void afterClass() {
	}

}
