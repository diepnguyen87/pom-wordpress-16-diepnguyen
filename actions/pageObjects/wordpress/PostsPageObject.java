package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.wordpress.AbstractPage;

public class PostsPageObject extends AbstractPage {

	private WebDriver driver;

	public PostsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
