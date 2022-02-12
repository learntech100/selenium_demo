package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class frames extends BaseClass {
  @Test
  public void frame() {
	  driver.get("http://webdriveruniversity.com/IFrame/index.html");
	  driver.switchTo().frame("frame");
	  driver.findElement(By.xpath("//*[@id='button-find-out-more']/b"));
  }
  
  @Test
  public void popup() {
	  driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
	  driver.findElement(By.xpath("//*[@id='button1']/p")).click();
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
}
