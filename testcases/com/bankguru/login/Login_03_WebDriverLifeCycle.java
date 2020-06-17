package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.bankguru.AbstractTest;
import pageObjects.bankGuru.AccountPageObject;
import pageObjects.bankGuru.CustomerPageObject;
import pageObjects.bankGuru.DepositPageObject;
import pageObjects.bankGuru.LoginPageObject;
import pageObjects.bankGuru.ManagerPageObject;
import pageObjects.bankGuru.PageFactoryManager;
import pageObjects.bankGuru.RegisterPageObject;
import pageObjects.bankGuru.WithdrawalPageObject;

public class Login_03_WebDriverLifeCycle extends AbstractTest {

	private WebDriver driver;
	private RegisterPageObject registerObject;
	private LoginPageObject loginObject;
	private ManagerPageObject managerObject;
	private CustomerPageObject customerObject;
	private DepositPageObject depositObject;
	private AccountPageObject accountOjbect;
	private WithdrawalPageObject withdrawObject;
	
	private String loginURL, userID, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginObject = PageFactoryManager.getLoginPage(driver);
		loginURL = loginObject.getPageByURL();
	}

	@Test
	public void TC_01_Register_BankGuru() {
		registerObject = loginObject.clickToHereLink();
		registerObject.enterEmail("van.tran" + getRandomNum() + "@gmail.com");
		registerObject.clickSubmitButton();

		userID = registerObject.getUserID();
		password = registerObject.getPassword();
		System.out.println(userID + " " + password);
		loginObject = registerObject.openLoginPage(loginURL);
	}

	@Test
	public void TC_02_Login_BankGuru() {
		loginObject.enterUserID(userID);
		loginObject.enterPassword(password);
		managerObject = loginObject.clickLoginButton();
		Assert.assertTrue(managerObject.isWelcomeMsgDisplayed());
	}
	
	@Test
	public void TC_03_NavigateToPage() {
		//Manager Page -> New Customer
		customerObject = managerObject.openCustomerPage(driver);
		
		//New Customer -> New Account
		accountOjbect = customerObject.openAccountPage(driver);
		
		//New Account -> Widthdrawal
		withdrawObject = accountOjbect.openWithdrawalPage(driver);
		
		//Withdrawal -> Manager Page
		managerObject = withdrawObject.openManagerPage(driver);
		
		//Manager Page -> Deposit Page
		depositObject = managerObject.openDepositPage(driver);
		
		//Deposit -> New Customer
		customerObject = depositObject.openCustomerPage(driver);
	}

	private int getRandomNum() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
	}

}
