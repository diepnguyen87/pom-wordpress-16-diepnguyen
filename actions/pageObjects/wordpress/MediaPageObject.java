package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.wordpress.AbstractPage;

public class MediaPageObject extends AbstractPage {

	private WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
