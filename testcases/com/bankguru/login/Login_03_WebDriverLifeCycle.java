package com.bankguru.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
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
	public void TC_03_NavigateToPage_LessMenu() {
		//Manager Page -> New Customer
		customerObject = (CustomerPageObject) managerObject.openDynamicPage_LessMenu(driver, "addcustomerpage");
		
		//New Customer -> New Account
		accountOjbect = (AccountPageObject) customerObject.openDynamicPage_LessMenu(driver, "addAccount");
		
		//New Account -> Widthdrawal
		withdrawObject = (WithdrawalPageObject) accountOjbect.openDynamicPage_LessMenu(driver, "WithdrawalInput");
		
		//Withdrawal -> Manager Page
		managerObject = (ManagerPageObject) withdrawObject.openDynamicPage_LessMenu(driver, "Managerhomepage");
		
		//Manager Page -> Deposit Page
		depositObject = (DepositPageObject) managerObject.openDynamicPage_LessMenu(driver, "DepositInput");
		
		//Deposit -> New Customer
		customerObject = (CustomerPageObject) depositObject.openDynamicPage_LessMenu(driver, "addcustomerpage");
	}

	@Test
	public void TC_04_NavigateToPage_MoreMenu() {
		//New Customer -> New Account
		customerObject.openDynamicPage_MoreMenu(driver, "addAccount");
		accountOjbect = PageFactoryManager.getAccountPage(driver);
		
		//New Account -> Widthdrawal
		accountOjbect.openDynamicPage_MoreMenu(driver, "WithdrawalInput");
		withdrawObject = PageFactoryManager.getWithdrawalPage(driver);
		
		//Withdrawal -> Manager Page
		withdrawObject.openDynamicPage_MoreMenu(driver, "Managerhomepage");
		managerObject = PageFactoryManager.getManagerPage(driver);
		
		//Manager Page -> Deposit Page
		managerObject.openDynamicPage_MoreMenu(driver, "DepositInput");
		depositObject = PageFactoryManager.getDepositPage(driver);
		
		//Deposit -> New Customer
		depositObject.openDynamicPage_MoreMenu(driver, "addcustomerpage");
		customerObject = PageFactoryManager.getCustomerPage(driver);
	}

	private int getRandomNum() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
	}

}
