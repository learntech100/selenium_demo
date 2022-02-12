package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.LoginPage;
import utils.ImageHelper;

public class LoginTests extends BaseClass {

	@Test
	public void testValidLogin() throws IOException {
		ExtentTest test = extent.createTest("testValidLogin");

		try {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
		boolean actualValue= driver.getCurrentUrl().contains("inventory.html");
		Assert.assertEquals(actualValue, true );
		test.log(Status.PASS, "it passed!");
		test.addScreenCaptureFromPath(ImageHelper.getScreenshot(driver));
		ImageHelper.getScreenshot(driver);
		Thread.sleep(7000);
		} catch (Exception e) {
			ImageHelper.getScreenshot(driver);
			//throw e;
		}
	}
	
	@Test
	public void testInvalidLogin() throws IOException {
		ExtentTest test = extent.createTest("inValidLoginTest");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName("locked_out_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginButton();
		boolean actualValue= driver.getCurrentUrl().contains("inventory.html");
		Assert.assertEquals(actualValue, false );
		test.log(Status.PASS, "it passed!");
		test.addScreenCaptureFromPath(ImageHelper.getScreenshot(driver));
		ImageHelper.getScreenshot(driver);
	}

}
