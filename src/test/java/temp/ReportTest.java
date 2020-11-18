package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	
	public static ExtentReports reports;
	public static ExtentTest log;
	
	
	
	public static  WebDriver wd;
	
	@Test(priority=1)
	public void validateGoogle(){
		
		reports=new ExtentReports("C:\\selenium workspace\\DDDTest\\report\\report.html");
		wd=new FirefoxDriver();
		wd.get("https://www.google.co.in/");
		log=reports.startTest("validlogin----completed");
		
	}
	
	@Test(priority=2)
	public void validateGmail(){
		
		wd.get("https://www.google.com/intl/en/mail/help/about.html");
		log=reports.startTest("invalidlogin----completed");
	}

	
	@Test(priority=3)
	public void validateYahoo(){
		
		wd.get("https://in.yahoo.com/");
		log=reports.startTest("duplicatelogin----completed");
	}

     @AfterMethod
     public void teardown(ITestResult it) throws IOException{
    	 
    	 if(it.isSuccess())
    	 {
    	 String path=takeScreenshot(it.getName());
    	 
    	 log.log(LogStatus.PASS, "testcase pass", log.addScreenCapture(path));
    	 }else 
    	 {
        	 String path=takeScreenshot(it.getName());
        	 log.log(LogStatus.FAIL, "testcase failed", log.addScreenCapture(path));
          }
    	 reports.endTest(log);
    	 reports.flush();
     }
	
	public static String takeScreenshot(String name) throws IOException{
		File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		File dst=new File("C:\\selenium workspace\\DDDTest\\screenshot\\"+name+".jpg");
		FileUtils.copyFile(src, dst);
		return dst.toString();	
	}
}
