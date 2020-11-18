package com.vcentry.onlinshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.vcentry.onlineshop.intializer.Intializer;

public class Loginpage extends Intializer{

	public static void clickLoginLink(){
		wd.findElement(By.linkText(locatorProp.getProperty("LOGINPAGE_CLICK_LOGIN_LINKTEXT"))).click();

	}
	
	public static void enterUserName(String user){
		wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_USENAME_NAME"))).sendKeys(user);

		
	}
	public static void enterPassword(String password){
		wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys(password);

	}
	public static void clickLoginButton(){
		wd.findElement(By.name(locatorProp.getProperty("LOGINPAGE_TYPE_PASSWORD_NAME"))).sendKeys(Keys.ENTER);
	}
	
}
