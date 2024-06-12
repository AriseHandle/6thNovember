package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.Browser;


public class HomePageTest extends BaseTest {

	@BeforeMethod
	public void OpenBrowser() {
		driver =Browser.chrome("https://www.saucedemo.com/");
	}

	@Test
	public void sampleTest() {
		System.out.println("Sample test added");
	}
	
}
