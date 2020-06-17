package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageFactoryManager;
import pageUI.wordpress.PostsPageUI;

public class PostsPageObject extends AbstractPage {

	private WebDriver driver;


	public PostsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
