package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
    @FindBy(xpath="//*[@id='add-to-cart-sauce-labs-backpack']")
    WebElement backPack;

   @FindBy(xpath="//*[@id='shopping_cart_container']/a")
    WebElement shoppingCart;


	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectBackPack() {
		backPack.click();
	}
	
	public void openShoppingCart() {
		shoppingCart.click();
	}

}
