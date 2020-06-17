package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pageUI.wordpress.MediaPageUI;

public class MediaPageObject extends AbstractPage {

	private WebDriver driver;


	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
	}


}
