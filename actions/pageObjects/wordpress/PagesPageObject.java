package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pageUI.wordpress.PagesPageUI;

public class PagesPageObject extends AbstractPage {

	private WebDriver driver;


	public PagesPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
