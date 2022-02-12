package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import utils.ExcelHelper;
import utils.ImageHelper;

public class RegressionTests extends BaseClass {
  @Test(dataProvider="orderData")
  public void orderCreationTest(String strUserName,String strPassword,String strFname,String strLname,String strZipcode) throws InterruptedException, IOException {
	 ExtentTest test = extent.createTest("Order_Creation");
	 

		
		
		//Declare all pages
		LoginPage loginPage = new LoginPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		
		
		//Login
		loginPage.enterUserName(strUserName);
		loginPage.enterPassword(strPassword);
		loginPage.clickLoginButton();
		
		//
		productsPage.selectBackPack();
		productsPage.openShoppingCart();
		
		//
		shoppingCartPage.clickCheckoutButton();
		
		//
		checkoutInfoPage.enterFirstName(strFname);
		checkoutInfoPage.enterLastName(strLname);
		checkoutInfoPage.enterPostalCode(strZipcode);
		Thread.sleep(3000);
		checkoutInfoPage.clickContinueButton();
		
		
		//
		checkoutOverviewPage.clickFinishButton();
		
		//Validation
		String actualMsg = checkoutCompletePage.getOrderSuccessMessage();
		System.out.println(actualMsg);
		String expectedMsg = "CHECKOUT: COMPLETE!";
		ImageHelper.getScreenshot(driver);
		Assert.assertEquals(actualMsg, expectedMsg );
		test.log(Status.PASS, "it passed!");
		test.addScreenCaptureFromPath(ImageHelper.getScreenshot(driver));
		Thread.sleep(5000);
		
		
  }
  
  
  @DataProvider(name="orderData")
  public Object[][] dataSet() throws IOException {
	  //get data from excel
	  return ExcelHelper.ReadTestData("orders.xls");
	  /*
	  return new Object[][] {
		  {"standard_user","secret_sauce","John","Smith","12344",},
		  {"standard_user","secret_sauce","Harry","Will","12345",},
		  {"standard_user","secret_sauce","Peter","Bill","12334",},
	  };
	  */
  }
  
  
 
}
