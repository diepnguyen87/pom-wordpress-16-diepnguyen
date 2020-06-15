package commons;

import org.openqa.selenium.WebDriver;

import pageFactory.LoginPageObject;
import pageFactory.ManagePageObject;
import pageFactory.RegisterPageObject;

public class PageFactoryManager_BankGuru {

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
