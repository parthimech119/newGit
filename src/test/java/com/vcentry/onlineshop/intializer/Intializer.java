package com.vcentry.onlineshop.intializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vcentry.onlineshop.report.ReportOptimizer;

public class Intializer {
	
	/**
	 * @author parthiban
	 * @created -24 oct 2020
	 * declare environment variable
	 */

	public static Properties envProp=null;
	/**
	 * @author parthiban
	 * @created -24 oct 2020
	 * declare environment variable
	 */

	public static Properties locatorProp=null;
	
	public static ExtentReports reports;
	public static ExtentTest log;
	public static boolean isReport=true;
	
	/**
	 * 
	 * @throws IOException
	 */
	public static WebDriver wd=null;
	public static void initalize() throws  IOException{
		
		if(isReport){
			ReportOptimizer.optimizeReport();
		reports=new ExtentReports("C:\\selenium workspace\\DDDTest\\report\\report.html");
		isReport=false;
		}
		
		 envProp=new Properties();
		 envProp.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"onlineshop"+File.separator+"config"+File.separator+"env.properties")));
		 
		 locatorProp=new Properties();
		 locatorProp.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"com"+File.separator+"vcentry"+File.separator+"onlineshop"+File.separator+"config"+File.separator+"locator.properties")));
		 
		 if(wd==null){
		 if(envProp.getProperty("BROWSER").equals("FIREFOX")){
			 
			 wd=new FirefoxDriver();
		 }
		 else if(envProp.getProperty("BROWSER").equals("CHROME")){
			 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"browser"+File.separator+"chromedriver.exe");
			 wd=new ChromeDriver();
		 }
		 wd.manage().window().maximize();
		 wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 wd.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	}
	
	
}
