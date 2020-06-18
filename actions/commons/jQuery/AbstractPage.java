package commons.jQuery;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.jQuery.DataTablePageObject;
import pageUI.wordpress.AbstractPageUI;

public abstract class AbstractPage {
	
	private String castToObject(String locator, String... xpathValues) {
		return String.format(locator, (Object[])xpathValues);
	}
	
	public AbstractPage navigateToPage_LessMenu(WebDriver driver, String pageName ) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE, pageName);
		return new DataTablePageObject(driver);
	}

	public void navigateToPage_MoreMenu(WebDriver driver, String pageName ) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE, pageName);
	}

	public boolean isPageLoaded(WebDriver driver, String pageURL) {
		String actualURL = getCurrentURL(driver);
		return actualURL.endsWith(pageURL);
	}
	
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void switchToWindowByID(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String currentWindow : allWindows) {
			driver.switchTo().window(currentWindow);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	private void closeAllWindowWithoutParent(WebDriver driver, String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String currentWindow : allWindows) {
			if (!currentWindow.equals(parentWindow)) {
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	public By byXpath(WebDriver driver, String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	public WebElement findElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(byXpath(driver, xpathLocator));
	}

	public List<WebElement> findElements(WebDriver driver, String xpathLocator) {
		return driver.findElements(byXpath(driver, xpathLocator));
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... xpathValues) {
		findElement(driver, castToObject(xpathLocator, xpathValues)).click();
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		findElement(driver, xpathLocator).click();
	}
	

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String value) {
		element = findElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String xpathLocator, String value, String... xpathValues) {
		element = findElement(driver, castToObject(xpathLocator, xpathValues));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String xpathLocator, String selectedText) {
		new Select(findElement(driver, xpathLocator)).selectByVisibleText(selectedText);
	}

	public WebElement getSelectedItemInDropdown(WebDriver driver, String xpathLocator) {
		return new Select(findElement(driver, xpathLocator)).getFirstSelectedOption();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		return new Select(findElement(driver, xpathLocator)).isMultiple();
	}

	public void selectItemInCustomDropdownList(WebDriver driver, String parentXpath, String childXpath, String selectedText) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);

		driver.findElement(By.xpath(parentXpath)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
		for (WebElement item : allItems) {
			if (item.getText().equals(selectedText)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				item.click();
				break;
			}
		}
	}

	public void getAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		findElement(driver, xpathLocator).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return findElement(driver, xpathLocator).getText().trim();
	}

	public int countElementNumber(WebDriver driver, String xpathLocator) {
		return findElements(driver, xpathLocator).size();
	}
	
	public int countElementNumber(WebDriver driver, String xpathLocator, String... xpathValues) {
		return findElements(driver, castToObject(xpathLocator, xpathValues)).size();
	}
	
	public void checkTheCheckbox(WebDriver driver, String xpathLocator) {
		element = findElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String xpathLocator) {
		element = findElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... xpathValues) {
		return findElement(driver, castToObject(xpathLocator, xpathValues)).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return findElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return findElement(driver, xpathLocator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return findElement(driver, xpathLocator).isEnabled();
	}

	public void switchToFrameOrIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(findElement(driver, xpathLocator));
	}

	public void switchToDefaulContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToEclement(WebDriver driver, String xpathLocator) {
		action = new Actions(driver);
		action.doubleClick(findElement(driver, xpathLocator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		action = new Actions(driver);
		action.moveToElement(findElement(driver, xpathLocator)).perform();
	}

	public void rightClick(WebDriver driver, String xpathLocator) {
		action = new Actions(driver);
		action.contextClick(findElement(driver, xpathLocator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceXpath, String targetXpath) {
		action = new Actions(driver);
		action.dragAndDrop(findElement(driver, sourceXpath), findElement(driver, targetXpath)).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElement(driver, xpathLocator), key).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key, String... xpathValues) {
		action = new Actions(driver);
		action.sendKeys(findElement(driver, castToObject(xpathLocator, xpathValues)), key).perform();
	}

	public Object executeJavaScriptToBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String expectedText) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + expectedText + "')[0]");
		return textActual.equals(expectedText);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String removedAttributeName) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + removedAttributeName + "');", element);
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = findElement(driver, xpathLocator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete &&" + "typeOf arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", element);
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementPresence(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(driver, xpathLocator)));
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(driver, xpathLocator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... xpathValues) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(driver, castToObject(xpathLocator, xpathValues))));
	}
	

	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... xpathValues) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(driver, castToObject(xpathLocator, xpathValues))));
	}
	
	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(driver, xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(driver, xpathLocator)));
	}

	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private WebDriverWait explicitWait;
	private WebElement element;
	private JavascriptExecutor jsExecutor;
	private Actions action;
}
