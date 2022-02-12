package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='finish']")
	WebElement finishButton;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFinishButton() {
		finishButton.click();
	}

}
