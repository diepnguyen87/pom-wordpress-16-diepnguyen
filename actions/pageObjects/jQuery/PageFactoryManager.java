package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;


public class PageFactoryManager {

	public static DataTablePageObject getLoginPage(WebDriver driver) {
		return new DataTablePageObject(driver);
	}
	
}
