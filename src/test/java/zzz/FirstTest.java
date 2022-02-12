package zzz;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

	@Test(priority = 1, description = "Verify Order Creation")
	public void orderCreation() throws InterruptedException {
		// Open Browser
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		// Navigate to our app
		driver.get("https://www.saucedemo.com/");
		// Perform login
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(3000);

		// Add items to cart
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(3000);

		// Checkout
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		Thread.sleep(3000);

		// add user details
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("john");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("smith");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("1234");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		Thread.sleep(3000);

		// Submit the order
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		
		//Verification
		String actualMsg = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText(); // get text 
		System.out.println(actualMsg);
		String expectedMsg = "CHECKOUT: Successful!";
		Assert.assertEquals(actualMsg, expectedMsg );
		Thread.sleep(5000);
		driver.quit();
	}
	
}
