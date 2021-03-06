package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkoutButton;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckoutButton() {
		checkoutButton.click();
	}

}
