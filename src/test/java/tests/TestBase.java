package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase 
{
	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional ("chrome") String browserName )
	{
		if(browserName.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");
	} 

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

	@AfterMethod
	public void screenshoOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking ScreenShot ...");
			Helper.captureScreenshot(driver, result.getName());

		}
	}




}
