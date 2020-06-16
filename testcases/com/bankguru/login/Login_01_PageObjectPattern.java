package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.ManagePageObject;
import pageObjects.bankGuru.RegisterPageObject;

public class Login_01_PageObjectPattern {

	private WebDriver driver;
	private RegisterPageObject registerObject;
	private LoginPageObject loginObject;
	private ManagePageObject manageObject;
	private String homePage = "http://demo.guru99.com/v4/index.php";
	private String loginURL, userID, password;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		loginObject = new LoginPageObject(driver);
		loginObject.openURL(driver, homePage);
		Assert.assertTrue(loginObject.isPageLoaded("index.php"));
		loginURL = loginObject.getPageByURL();
		System.out.println(loginURL);
	}

	@Test
	public void TC_01_Register_BankGuru() {
		registerObject = loginObject.clickToHereLink();
		
		//Assert.assertTrue(registerObject.isPageLoaded("demo.guru99.com"));
		registerObject.enterEmail("van.tran" + getRandomNum() + "@gmail.com");
		registerObject.clickSubmitButton();
		userID = registerObject.getUserID();
		password = registerObject.getPassword();
		System.out.println(userID + " " + password);
		loginObject = registerObject.openLoginPage(loginURL);
		Assert.assertTrue(loginObject.isPageLoaded("index.php"));
	}

	@Test
	public void TC_02_Login_BankGuru() {
		loginObject.enterUserID(userID);
		loginObject.enterPassword(password);
		manageObject = loginObject.clickLoginButton();
		Assert.assertTrue(manageObject.isPageLoaded("Managerhomepage.php"));
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
