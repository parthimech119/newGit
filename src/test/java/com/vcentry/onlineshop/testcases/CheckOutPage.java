package com.vcentry.onlineshop.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vcentry.onlineshop.inputreader.InputReader;
import com.vcentry.onlineshop.intializer.Intializer;
import com.vcentry.onlineshop.intializer.Precondition;
import com.vcentry.onlineshop.report.ScreenshotGenerator;
import com.vcentry.onlinshop.pages.CheckoutPage;
import com.vcentry.onlinshop.pages.Loginpage;
@Test
public class CheckOutPage extends Intializer {

	@Test(dataProvider="CheckOutPage")
	public void validateCheckout(String tcname,String user,String password,String prod,String mobile,String email,String prodcat,String purchasename,String prodqty) throws IOException {

		initalize();

		// Step1 :
		// wd.findElement(By.linkText("Login")).click();
		// wd.findElement(By.name("username")).sendKeys("parthiban");
		// wd.findElement(By.name("password")).sendKeys("Partha@1234");
		// wd.findElement(By.name("password")).sendKeys(Keys.ENTER);
		// wd.get(envProp.getProperty("URL"));
		// wd.findElement(By.id("id0")).sendKeys("productA");
		// wd.findElement(By.id("id1")).sendKeys("22222");
		// wd.findElement(By.id("id2")).sendKeys("maila@mail.com");
		// WebElement element = wd.findElement(By.id("id3"));
		//
		// Select s = new Select(element);
		// s.selectByVisibleText("Electrical");
		// wd.findElement(By.id("id4")).sendKeys("12");
		// wd.findElement(By.id("id5")).sendKeys("purchaseA");
		// wd.findElement(By.id("idyes")).click();
		// wd.findElement(By.id("cod")).click();
		// wd.findElement(By.id("order")).click();
		//

		// wd.findElement(By.linkText(locatorProp.getProperty("LOGINPAGE_CLICK_LOGIN_LINKTEXT"))).click();
		// wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_USENAME_NAME"))).sendKeys("parthiban");
		// wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys("Partha@1234");
		// wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys(Keys.ENTER);
		// wd.get(envProp.getProperty("URL"));
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PRODUCT_ID"))).sendKeys("productA");
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_MOBILE_ID"))).sendKeys("22222");
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_MAILID_ID"))).sendKeys("maila@mail.com");
		// WebElement element =
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_SELECT_PRODCATS_ID")));
		// Select s = new Select(element);
		// s.selectByVisibleText("Electrical");
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PRODQTY_ID"))).sendKeys("12");
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PURCHASENAME_ID"))).sendKeys("purchaseA");
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_GST_ID"))).click();
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_COD_ID"))).click();
		// wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_PALCEORDER_ID"))).click();
		Precondition.loadUrl();
        Loginpage.clickLoginLink();
        Loginpage.enterUserName(user);
        Loginpage.enterPassword(password);
        Loginpage.clickLoginButton();
        Precondition.loadUrl();
        CheckoutPage.enterProdctName(prod);
        CheckoutPage.enterMobileNumber(mobile);
        CheckoutPage.enterEmail(email);
        CheckoutPage.selectProdCat(prodcat);
        CheckoutPage.enterPurchasername(purchasename);
        CheckoutPage.enterPrdQty(prodqty);
        CheckoutPage.clickGst();
        CheckoutPage.clickCOD();
        CheckoutPage.clickPlaceOrder();
        CheckoutPage.logout();
		log=reports.startTest(tcname+"validlogin----completed");

	}
	@DataProvider(name="CheckOutPage")
	public static Object[][] getCheckoutData() throws Exception{
		
		if(InputReader.runModeVerification("CheckOutPage")){
		
			Object[][] data=InputReader.selectSingleDataOrMulitiData("CheckOutPage");
//			Object[][] data=new Object[3][8];
//		
//		data[0][1]="parthiban";
//		data[0][2]="Partha@1234";
//		data[0][3]="productA";
//		data[0][4]="maila@mail.com";
//		data[0][5]="Electrical";
//		data[0][6]="purchaseA";
//		data[0][7]="12";
//		
//		
//		data[1][1]="parthiban";
//		data[1][2]="Partha@1234";
//		data[1][3]="productB";
//		data[1][4]="maila@mailB.com";
//		data[1][5]="Electrical";
//		data[1][6]="purchaseB";
//		data[1][7]="22";
//		
//		data[2][1]="parthiban";
//		data[2][2]="Partha@1234";
//		data[2][3]="productC";
//		data[2][4]="maila@mailC.com";
//		data[2][5]="Electrical";
//		data[2][6]="purchaseC";
//		data[2][7]="33";
		return data;
		
		}
		return null;



	}
	  @AfterMethod
	     public void teardown(ITestResult it) throws IOException{
	    	 
		 
		ScreenshotGenerator.generateScreenshot(it);

}
}
