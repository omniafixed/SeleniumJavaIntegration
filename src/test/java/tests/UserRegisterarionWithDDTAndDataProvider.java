package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisterationPage;
import data.LoadProperties;

public class UserRegisterarionWithDDTAndDataProvider extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firstname = LoadProperties.userData.getProperty("firstname");
	String lastname = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	//	@DataProvider
	//
	//	public static Object [][] userData()
	//	{
	//		return new Object[][] {
	//			{"Ahmed","Tarek","Ahmedtest51@gmail.com","123456789"},
	//			{"Moataz","Nabil","moataztest11@test.com","123456789"}
	//		};
	//	}


	@Test(priority = 1,alwaysRun = true)

	public void UserCanRegisterSuccessfully() 
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname, lastname,email, password);
		Assert.assertTrue(registerObject.sucessMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2,dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogout"},enabled = false)
	public void RegisteredUserCanLogin() 
	{
		loginObject = new LoginPage(driver);
		homeObject.openLoginPage();
		loginObject.userLogin("e3@test.com", "123456789");
	}

}
