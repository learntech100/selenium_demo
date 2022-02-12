package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.ImageHelper;

public class BaseClass {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	@BeforeSuite
	public void setupReports() {
		  extent = new ExtentReports();
		  spark = new ExtentSparkReporter("target/Spark.html");
		  extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void setupBrowser() {
		System.out.println("**********Before Method from Base Class*********");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);

		// Navigate to our app
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void quitBrowser() {
		System.out.println("**********After Method from Base Class*********");
		driver.quit();
	}
	
	@AfterSuite
	public void cleanupReports() {
		extent.flush();
	}

}
