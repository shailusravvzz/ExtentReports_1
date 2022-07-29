package Rahulshettyacademy.ReportsReorts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo3 {
	ExtentReports extent;
	
	
	@BeforeTest
	public void config() {
	// ExtentReports (-main one), ExtentSparkReporter (-config files)
	
		//creation report with required data or config file
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
	    ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	    reporter.config().setReportName("Web Automation Reports");
	    reporter.config().setDocumentTitle("Test Results");
	    
	    //Attach the above data to reports
	    // ExtentReports extent= new ExtentReports(); -to report as global so that it can be access from other methods too
	    
	    extent= new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Tester", "Shailendar");
  		}
	

	
	@Test
	public void initialDemo() {
		
		extent.createTest("Initial Demo");   //linking extent report to method
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		driver.getTitle();
		
		driver.close();
		
		extent.flush();
		
	}
	
}
