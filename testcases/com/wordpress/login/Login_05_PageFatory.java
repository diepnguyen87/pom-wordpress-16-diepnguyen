package com.wordpress.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.PageFactoryManager_Wordpress;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Login_05_PageFatory {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	private String actualErrorMsg;
	private String loginURL;
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://automationfc.wordpress.com/wp-admin");

		loginOjbect = PageFactoryManager_Wordpress.getLoginPage(driver);
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
		loginOjbect = loginOjbect.OpenLoginPage(loginURL);
	}

	@Test
	public void TC_05_PasswordLessThan6Chars() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("123");
		loginOjbect.clickLoginButton();
		actualErrorMsg = loginOjbect.getActualErrorMsg();
		Assert.assertEquals(actualErrorMsg, "Oops, that's not the right password. Please try again!");
		loginOjbect = loginOjbect.OpenLoginPage(loginURL);
	}
	
	@Test
	public void TC_06_ValidPassword() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("automationfc");
		dashboardObject = loginOjbect.clickLoginButton();
		Assert.assertTrue(dashboardObject.isDashboardPageDisplay());
	}
	
	@AfterClass
	public void afterClass() {
	}

}
