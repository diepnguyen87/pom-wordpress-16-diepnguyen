package com.wordpress.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;

public class Login_04_PageObjectPattern {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("automationfc.wordpress.com/wp-admin");
		
		//loginOjbect = new LoginPageObject(driver);
	}

	@Test
	public void TC_01_EmptyEmail() {
		//loginOjbect.enterEmail("");
		//loginOjbect.clickContinueButton();
//		actualErrorMsg = loginOjbect.getActualErrorMsg();
//		Assert.assertEquals(actualErrorMsg, "Please enter a username or email address.");
	}

	@AfterClass
	public void afterClass() {
	}

}
