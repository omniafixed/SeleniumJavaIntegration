package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FullName")
	private WebElement fullNameTXt;

	@FindBy(id="Email")
	private WebElement emailTxt;

	@FindBy(id="Enquiry")
	private WebElement enquiryTxt;

	@FindBy(css="input.button-1.contact-us-button")
	private WebElement submitBtn ;

	@FindBy(css="div.result")
	public WebElement successMessage;


	public void contactUsFormpage(String fullName , String email , String enquiry) 
	{
		setTextElementText(fullNameTXt, fullName);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryTxt, enquiry);
		clickButton(submitBtn);
	}
}
