package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;	
	
	//driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
	//By userName = By.xpath("//*[@id=\"user-name\"]");
	@FindBy(xpath= "//*[@id='user-names']")
	WebElement userName;
	
	@FindBy(xpath= "//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath= "//*[@id='login-button']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // this line will initiate all my page objects
	}

	// regular method --> actions performed on the objects
	public void enterUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}

	public void enterPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void clickLoginButton() {
		loginButton.click();
	}


}
