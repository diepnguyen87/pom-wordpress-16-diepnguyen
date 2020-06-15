package pageFactory.bankGuru;

import org.openqa.selenium.WebDriver;

import pageFactory.bankGuru.LoginPageObject;
import pageFactory.bankGuru.ManagePageObject;
import pageFactory.bankGuru.RegisterPageObject;

public class PageFactoryManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static ManagePageObject getManagePage(WebDriver driver) {
		return new ManagePageObject(driver);
	}
	
}
