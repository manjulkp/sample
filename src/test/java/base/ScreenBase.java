package base;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ScreenBase {

	public static WebDriver driver;
	public WebDriverWait wait;
	
	
	public ScreenBase(WebDriver driver) {
		ScreenBase.driver = driver;

	}

	
	public static boolean isElementPresent(WebElement webElement) {
		try {
			boolean isPresent = webElement.isDisplayed();
			
			return isPresent;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Click an element
	public static void clickAble(WebDriver driver, WebElement webElement) {
		try {
			if (isElementPresent(webElement)) {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();
			
			}
		} catch (StaleElementReferenceException sere) {
			// simply retry finding the element in the refreshed DOM
			if (isElementPresent(webElement)) {
			webElement.click();
			}
		}
	}

	

	// Enter any text
	public static void enterText(WebElement element, String text, WebDriver driver) {
		
		clickAble(driver, element);
		element.sendKeys(text);
	}

	// Retrieve the text
	public static String GetScreenTitle() {
		String title = driver.getTitle();
		return title;
	}

	// Element existence check
	public static boolean IsExists(WebElement element) {
		
		try {
			element.isDisplayed();
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	// Element enabled check
	public static boolean IsEnabled(WebElement element) {
		
		return (element.isEnabled()) ? true : false;
	}

	// Element selected check
	public static boolean IsSelected(WebElement element) {
		
		return (element.isSelected()) ? true : false;
	}

	// check for actual verses with expected
	public static void verifyScreen(String expected, WebElement ele) {
		String actual = ele.getText();

		Assert.assertEquals(actual, expected);
	}

	
}
