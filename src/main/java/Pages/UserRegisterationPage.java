package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase 
{
	public UserRegisterationPage(WebDriver driver)  // Constructor
	{
		super(driver);
	}
	@FindBy(id ="gender-male")
	WebElement genderRdBtn;

	@FindBy(id="FirstName")
	WebElement fnTxtBox;

	@FindBy(id="LastName")
	WebElement lsTxtBox;

	@FindBy (id="Email")
	WebElement emailTxtBox ;

	@FindBy (id="Password")
	WebElement passwordTxtBox;

	@FindBy (id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy (id="register-button")
	WebElement registerBtn;
	
	@FindBy (linkText ="Log out")
	WebElement logoutLink;
	
	@FindBy (css= "div.result")
	public WebElement sucessMessage;

	public void userRegisteration(String firstName, String lastName, String email, String password) 
	{
		clickButton(genderRdBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lsTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);		
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}

}
