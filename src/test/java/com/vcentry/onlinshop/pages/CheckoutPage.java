package com.vcentry.onlinshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.vcentry.onlineshop.intializer.Intializer;

public class CheckoutPage extends Intializer {

	public static void enterProdctName(String product) {
		wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PRODUCT_ID"))).sendKeys(product);

	}

	public static void enterMobileNumber(String mobile) {
		wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_MOBILE_ID"))).sendKeys(mobile);

	}

	public static void enterEmail(String email) {
		wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_MAILID_ID"))).sendKeys(email);

}
	 public static void selectProdCat(String prodCat) {
			WebElement element = wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_SELECT_PRODCATS_ID")));
			Select s = new Select(element);
			s.selectByVisibleText(prodCat);
		}

		public static void enterPrdQty(String prdqty) {
			wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PRODQTY_ID"))).sendKeys(prdqty);

		}

		public static void enterPurchasername(String name) {
			wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_TYPE_PURCHASENAME_ID"))).sendKeys(name);
		}
	public static void clickGst() {
			wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_GST_ID"))).click();
	}
	public static void clickCOD() {
		wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_COD_ID"))).click();

	}

	public static void clickPlaceOrder() {
		wd.findElement(By.id(locatorProp.getProperty("CHECKOUTPAGE_CLICK_PALCEORDER_ID"))).click();

	}
	public static void logout(){
		wd.findElement(By.linkText(locatorProp.getProperty("CHECKOUTPAGE_CLICK_LOGOUT_LINKTEXT"))).click();
	}
	
	
		}
