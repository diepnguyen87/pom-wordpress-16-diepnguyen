package com.wordpress.login;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.wordpress.AbstractTest;
import pageObjects.wordpress.DashboardPageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageFactoryManager;
import pageUI.wordpress.AbstractPageUI;

public class Login_10_Upload_Multiple_File extends AbstractTest {

	private WebDriver driver;
	private LoginPageObject loginOjbect;
	private DashboardPageObject dashboardObject;
	private MediaPageObject mediaObject;
	private List<String> imgList = new ArrayList<String>();
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);	
		loginOjbect = PageFactoryManager.getLoginPage(driver);
		imgList.add("1.png");
		imgList.add("2.jpg");
		imgList.add("3.jpg");
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
	public void TC_02_UploadFile() {
		mediaObject = dashboardObject.clickToMediaMenu(driver);
		mediaObject.clickAddNewButton();
		mediaObject.uploadMultipleFiles(driver, imgList.get(0), imgList.get(1), imgList.get(2));
		Assert.assertTrue(mediaObject.areImagesLoaded(imgList));
	}

	@AfterClass
	public void afterClass() {
	}

}
