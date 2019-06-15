package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}


	@FindBy(linkText ="Register")
	WebElement registerLink;

	@FindBy(linkText ="Log in")
	WebElement loginLink;

	@FindBy(linkText ="My account")
	WebElement myAccountLInk;

	@FindBy(linkText="Contact us")
	WebElement contactUsLink;

	public void openRegisterationPage() 
	{
		clickButton(registerLink);
	}

	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	public void openMyAccountPage()
	{
		clickButton(myAccountLInk);
	}
	public void openContactUsPage() 
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}

}
