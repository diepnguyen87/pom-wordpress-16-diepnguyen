package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageFactoryManager;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostsPageObject;

public class Login_08_WebDriverLifeCycle extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	private PostsPageObject postObject;
	private PagesPageObject pageObject;
	private MediaPageObject mediaObject;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		loginOjbect = PageFactoryManager.getLoginPage(driver);
	}

	
	@Test
	public void TC_01_ValidPassword() {
		loginOjbect.enterEmail("automationeditor");
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword("automationfc");
		dashboardObject = loginOjbect.clickLoginButton();
		Assert.assertTrue(dashboardObject.isDashboardPageDisplay());
	}
	
	@Test
	public void TC_02_NavigateToPage() {
		//Dashboard->Posts
		postObject = dashboardObject.clickToPostsMenu(driver);
		
		//Post->Pages
		pageObject = postObject.clickToPagesMenu(driver);
		
		//Page->Media
		mediaObject = pageObject.clickToMediaMenu(driver);
		
		//Media->Post
		postObject = mediaObject.clickToPostsMenu(driver);
		
		//Post->Media
		mediaObject = postObject.clickToMediaMenu(driver);
		
	}

	@AfterClass
	public void afterClass() {
	}

}
