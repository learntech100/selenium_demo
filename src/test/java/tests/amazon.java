package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class amazon extends BaseClass{
  @Test
  public void f() throws InterruptedException {
	    driver.get("https://www.amazon.com/");
		// Perform login
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone x");
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		driver.findElement(By.linkText("Apple iPhone X, US Version, 64GB, Space Gray - Fully Unlocked (Renewed)")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		//Thread.sleep(5000);
		//Dropdown
		WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		Select selectObject = new Select(selectElement);
		selectObject.selectByVisibleText("5");
		Thread.sleep(5000);
		WebElement btn = new WebDriverWait(driver, 5)
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")));
		btn.click();
		
  }
}
