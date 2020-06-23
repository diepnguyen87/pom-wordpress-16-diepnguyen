package pageObjects.wordpress;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.wordpress.AbstractPage;
import pageUI.wordpress.AbstractPageUI;
import pageUI.wordpress.MediaPageUI;

public class MediaPageObject extends AbstractPage {

	private WebDriver driver;

	public MediaPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddNewButton() {
		waitForElementClickable(driver, MediaPageUI.ADD_NEW_LINK);
		clickToElement(driver, MediaPageUI.ADD_NEW_LINK);
	}

	public boolean areImagesLoaded(List<String> imgList) {
		waitForElementInvisible(driver, AbstractPageUI.MEDIA_PROGRESS_BAR);
		
		List<String> loadedImgSources = new ArrayList<String>();
		List<WebElement> elements = findElements(driver, AbstractPageUI.ALL_LOADED_IMG);
		int i=0;
		for(WebElement element : elements) {
			System.out.println(element.getAttribute("src"));
			loadedImgSources.add(element.getAttribute("src"));
			++i;
			if(i==imgList.size())break;
		}
		String imageSources = loadedImgSources.toString();
		for(String item : imgList) {
			if(!imageSources.contains(item.split("\\.")[0])) {
				return false;
			}
		}
		return true;
	}
}		
