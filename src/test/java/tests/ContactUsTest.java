package tests;

import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase{

	ContactUsPage contactUsObject;
	HomePage homePageObject;
	String fullName = "Omnia Tarek";
	String email = "omniatarek@test.com";
	String enquiry = "test test test";



	@Test
	public void openContactUsPage() {
		contactUsObject = new ContactUsPage(driver);
		homePageObject = new HomePage(driver);
		homePageObject.openContactUsPage();
		contactUsObject.contactUsFormpage(fullName, email, enquiry);

	}
}
