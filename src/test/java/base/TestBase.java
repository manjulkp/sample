package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.CommonUtility;

public class TestBase {

	/*
	 * WebDriver - done Properties - done Logs - log4j jar, .log, Jenkins
	 */

	public static WebDriver driver;
	
	public static String browser;
	public static WebDriverWait wait;

	public void setUp() throws IOException {
		if (driver == null) {

			CommonUtility.loadUserConfigProp("Config.properties");
			browser = CommonUtility.BROWSER_NAME;

			

			if (CommonUtility.BROWSER_NAME.equals("firefox")) {
				driver = new FirefoxDriver();

			} else if (CommonUtility.BROWSER_NAME.equals("chrome")) 
			{
				
				ChromeOptions chromeOptions= new ChromeOptions();
				
				 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/test/resources/executable/chromedriver");
				 driver = new ChromeDriver(chromeOptions);
				 

			} 

			driver.get(CommonUtility.TESTURL);
			
			
            driver.manage().window().maximize();
			driver.manage()
					.timeouts()
					.implicitlyWait(
							Integer.parseInt(CommonUtility.IMPLICIT_WAIT_TIME),
							TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
		}

	}

	// close the browser
	public void tearDown() {
		 if (driver != null) {
		 driver.quit();
		 }

	}
}