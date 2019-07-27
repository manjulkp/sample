package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;

public class Login_Page extends ScreenBase {

	public Login_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_login_name")
	private WebElement enterEmail;

	@FindBy(id = "user_password")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement signInButton;
	
	@FindBy(linkText = "About")
	private WebElement About;
	
	@FindBy(linkText = "Recently added content")
	private WebElement recentlyAddedContent;
	
	public void isUserInWelcomeScreen() {
		Assert.assertTrue(isElementPresent(About), "The About  is not loaded");
		Assert.assertTrue(ScreenBase.GetScreenTitle().equals("Google"));
	}
	
	public void isUserInHomeScreen() {
		Assert.assertTrue(isElementPresent(recentlyAddedContent), "The user is not in HomeScreen");

	}
	
	

}
