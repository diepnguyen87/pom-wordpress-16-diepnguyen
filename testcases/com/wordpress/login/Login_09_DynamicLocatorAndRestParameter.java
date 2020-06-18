package com.wordpress.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.wordpress.AbstractTest;
import commons.wordpress.GlobalConstants;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageFactoryManager;
import pageObjects.wordpress.PagesPageObject;
import pageObjects.wordpress.PostsPageObject;

public class Login_09_DynamicLocatorAndRestParameter extends AbstractTest {

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
		loginOjbect.enterEmail(GlobalConstants.USERNAME);
		loginOjbect.clickContinueButton();
		loginOjbect.enterPassword(GlobalConstants.PASSWORD);
		dashboardObject = loginOjbect.clickLoginButton();
		Assert.assertTrue(dashboardObject.isDashboardPageDisplay());
	}
	
	@Test
	public void TC_02_NavigateToPage_LessMenu() {
		//Dashboard->Posts
		postObject = (PostsPageObject) dashboardObject.navigateToPage_LessMenu(driver, "post");
		
		//Post->Pages
		pageObject = (PagesPageObject) postObject.navigateToPage_LessMenu(driver, "page");
		
		//Page->Media
		mediaObject = (MediaPageObject) pageObject.navigateToPage_LessMenu(driver, "media");
		
		//Media->Post
		postObject = (PostsPageObject) mediaObject.navigateToPage_LessMenu(driver, "post");
		
		//Post->Media
		mediaObject = (MediaPageObject) postObject.navigateToPage_LessMenu(driver, "media");
		
		//Media->Dashboard
		dashboardObject = (DashboardPageObject) mediaObject.navigateToPage_LessMenu(driver, "dashboard");		
	}
	
	@Test
	public void TC_03_NavigateToPage_MoreMenu() {
		dashboardObject.navigateToPage_MoreMenu(driver, "post");
		postObject = PageFactoryManager.getPostsPage(driver);
		
		postObject.navigateToPage_MoreMenu(driver, "media");
		mediaObject = PageFactoryManager.getMediaPage(driver);
		
		mediaObject.navigateToPage_MoreMenu(driver, "page");
		pageObject = PageFactoryManager.getPagesPage(driver);
		
	}

	@AfterClass
	public void afterClass() {
	}

}
