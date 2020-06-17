package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.wordpress.AbstractPage;

public class PagesPageObject extends AbstractPage {

	private WebDriver driver;

	public PagesPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
