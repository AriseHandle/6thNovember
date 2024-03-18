package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {

@FindBy (xpath = "//button[text()='Add to cart']") private WebElement addToCart;
@FindBy (xpath = "//span[@class='title']")private WebElement heading;
	
	public SwagLabHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void addProductToCart() {
		addToCart.click();
	}
	
	public boolean isHeadingDisplayed() {
		return heading.isDisplayed();
	}
	
}
