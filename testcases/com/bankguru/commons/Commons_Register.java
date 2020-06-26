package com.bankguru.commons;

import org.testng.annotations.Test;

import commons.bankguru.AbstractTest;
import pageObjects.bankGuru.PageFactoryManager;
import pageObjects.bankGuru.RegisterPageObject;
import pageObjects.bankGuru.LoginPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Commons_Register extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginObject;
	private RegisterPageObject registerObject;
	private String url = "http://demo.guru99.com/v4/";
	public static String userID, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName, url);
		loginObject = PageFactoryManager.getLoginPage(driver);
		registerObject = loginObject.clickToHereLink();
		registerObject.enterEmail("van.tran" + getRandomNum() + "@gmail.com");
		registerObject.clickSubmitButton();
		userID = registerObject.getUserID();
		password = registerObject.getPassword();
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
