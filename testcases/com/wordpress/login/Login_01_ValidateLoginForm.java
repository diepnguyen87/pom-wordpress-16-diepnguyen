package com.wordpress.login;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_01_ValidateLoginForm {

	WebDriver driver;
	By emailTextBoxBy = By.xpath("//input[@id='usernameOrEmail']");
	By passwordTextBoxBy = By.xpath("//input[@id='password']");
	By loginButtonBy = By.xpath("//div[@class='login__form-action']/button");
	By ErrorMessageBy = By.xpath("//div[@class='form-input-validation is-error']/span");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
	}
	
	@BeforeMethod
	private void BeforeMethod() {
		driver.get("https://automationfc.wordpress.com/wp-admin");
	}
	
	//@Test
	public void Validate_01_EmptyEmail() {
		driver.findElement(emailTextBoxBy).sendKeys("");
		driver.findElement(loginButtonBy).click();
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "Please enter a username or email address.");
	}
	
	//@Test
	public void Validate_02_InvalidEmail() {
		driver.findElement(emailTextBoxBy).sendKeys("123@123.123");
		driver.findElement(loginButtonBy).click();
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "Please log in using your WordPress.com username instead of your email address.");	
	}
	
	@Test
	public void Validate_03_EmailNotExist() {
		driver.findElement(emailTextBoxBy).sendKeys("automation" + getRandomNum() + "@gmail.com");
		driver.findElement(loginButtonBy).click();
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "User does not exist. Would you like to create a new account?");	
	
	}
	
	//@Test
	public void Validate_04_EmptyPassword() {
		driver.findElement(emailTextBoxBy).sendKeys("automationeditor");
		driver.findElement(loginButtonBy).click();
		driver.findElement(passwordTextBoxBy).sendKeys("");
		driver.findElement(loginButtonBy).click();
		
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "Don't forget to enter your password.");	

	}
	
	//@Test
	public void Validate_05_PasswordLessThan6Chars() {
		driver.findElement(emailTextBoxBy).sendKeys("automationeditor");
		driver.findElement(loginButtonBy).click();
		driver.findElement(passwordTextBoxBy).sendKeys("123");
		driver.findElement(loginButtonBy).click();
		
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "Oops, that's not the right password. Please try again!");	

	}
	
	
	public void Validate_06_IncorrectPassword() {
		driver.findElement(emailTextBoxBy).sendKeys("automationeditor");
		driver.findElement(loginButtonBy).click();
		driver.findElement(passwordTextBoxBy).sendKeys("123456");
		driver.findElement(loginButtonBy).click();
		
		Assert.assertEquals(driver.findElement(ErrorMessageBy).getText().trim(), "Oops, that's not the right password. Please try again!");	

	}
	
	//@Test
	public void Validate_07_ValidPassword() {
		driver.findElement(emailTextBoxBy).sendKeys("automationeditor");
		driver.findElement(loginButtonBy).click();
		driver.findElement(passwordTextBoxBy).sendKeys("automationfc");
		driver.findElement(loginButtonBy).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='dashboard-widgets-wrap']")).isDisplayed());	

	}
	
	private int getRandomNum() {
		Random random = new Random();
		return random.nextInt(9999);
	}
	
	@AfterClass
	public void afterClass() {
	}

}
