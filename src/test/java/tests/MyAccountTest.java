package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.UserRegisterationPage;


public class MyAccountTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	MyAccountPage myAccountObject;
    String oldPassword = "123456789";
    String newPassword = "123456";
    String email = "oo@test.com";
    String fname = "Omnia";
    String lname = "Tarek";

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(fname, lname, email, oldPassword);
		Assert.assertTrue(registerObject.sucessMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserCanChangePassword() 
	{
		homeObject = new HomePage(driver);
		homeObject.openMyAccountPage();
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.changePasswordLink();
		myAccountObject.changePasswordForm(oldPassword, newPassword);
	}
}

