package test;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import pojo.Browser;
import pom.SwagLabHomePage;
import pom.SwagLabLoginPage;
import utility.Reports;


@Listeners (test.Listeners.class)
public class SwagLabLoginTest extends BaseTest {
	
	 
	
	
	
	@BeforeMethod
	public void OpenBrowser() {
		driver =Browser.chrome("https://www.saucedemo.com/");
	}

	@Test
	public void loginWithValidCredentials() {
		test = reports.createTest("loginWithValidCredentials");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("standard_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		
		SwagLabHomePage swagLabHomePage = new SwagLabHomePage(driver);
		String url =driver.getCurrentUrl();
		SoftAssert softAsssert = new SoftAssert();
		softAsssert.assertEquals(url, "https://www.saucedemo.com/inventory");
		System.out.println("url validated successfully");
		boolean status =swagLabHomePage.isHeadingDisplayed();
		softAsssert.assertTrue(status);
		System.out.println("heading validated successfully");
		softAsssert.assertAll();
	
	}
	
	@Test (dependsOnMethods = "loginWithValidCredentials")
	public void loginWithLockedOutUser() {
		test = reports.createTest("loginWithLockedOutUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();

	}
	
	@Test
	public void loginWithProblemUser() {
		test = reports.createTest("loginWithProblemUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("problem_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void loginWithPerformanceGlitchUser() {
		test =reports.createTest("loginWithPerformanceGlitchUser");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUserName("performance_glitch_user	");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
	}
	
	@Test
	public void sample() {
		test =reports.createTest("sample");
		SwagLabLoginPage swagLabLoginPage = new SwagLabLoginPage(driver);
		boolean status =swagLabLoginPage.isLogoDisplayed();
		Assert.assertFalse(status);//Hard assertion
		System.out.println("Validation done ");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
	
	}
	
	

}
