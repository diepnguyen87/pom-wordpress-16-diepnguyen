package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.jcip.annotations.ThreadSafe;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.ManagePageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_01_RegisterAndLogin {

	private WebDriver driver;
	private RegisterPageObject registerObject;
	private LoginPageObject loginObject;
	private ManagePageObject manageObject;
	private String homePage = "http://demo.guru99.com/v4/";
	private String loginURL, userID, password;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(homePage);

		loginObject = new LoginPageObject(driver);
		loginURL = loginObject.getPageByURL();
	}

	@Test
	public void TC_01_Register_BankGuru() {
		loginObject.clickToHereLink();
		registerObject = new RegisterPageObject(driver);

		registerObject.enterEmail("van.tran" + getRandomNum() + "@gmail.com");
		registerObject.clickSubmitButton();

		userID = registerObject.getUserID();
		password = registerObject.getPassword();
		System.out.println(userID + " " + password);
		registerObject.openPageByURL(loginURL);
		// loginObject = new LoginPageObject(driver);
	}

	@Test
	public void TC_02_Login_BankGuru() {
		loginObject.enterUserID(userID);
		loginObject.enterPassword(password);
		loginObject.clickLoginButton();
		manageObject = new ManagePageObject(driver);
		Assert.assertTrue(manageObject.isWelcomeMsgDisplayed());
	}

	private int getRandomNum() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
	}

}
