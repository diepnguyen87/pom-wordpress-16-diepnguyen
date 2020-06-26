package com.bankguru.user;

import org.testng.annotations.Test;

import com.bankguru.commons.Commons_Register;

import commons.bankguru.AbstractTest;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.ManagerPageObject;
import pageObjects.bankGuru.PageFactoryManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_03_DeleteUser extends AbstractTest {

	private LoginPageObject loginObject;
	private ManagerPageObject managerObject;
	private WebDriver driver;
	private String url = "http://demo.guru99.com/v4/";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://www.facebook.com/");
//		loginObject = PageFactoryManager.getLoginPage(driver);
//		loginObject.enterUserID(Register.userID);
//		loginObject.enterPassword(Register.password);
//		managerObject = loginObject.clickLoginButton();
//		Assert.assertTrue(managerObject.isWelcomeMsgDisplayed());
		Assert.assertTrue(false);
	}

	@Test
	public void TC_01() {
	}

	@Test
	public void TC_02() {
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
