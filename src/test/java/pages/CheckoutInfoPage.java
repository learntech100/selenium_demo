package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='first-name']")
	WebElement firstName;

	@FindBy(xpath = "//*[@id='last-name']")
	WebElement lastName;

	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement postalCode;

	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueButton;

	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String strFirstName) {
		firstName.sendKeys(strFirstName);
	}
	
	public void enterLastName(String strLastName) {
		lastName.sendKeys(strLastName);
	}
	
	public void enterPostalCode(String strPostalCode) {
		postalCode.sendKeys(strPostalCode);
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}

}
