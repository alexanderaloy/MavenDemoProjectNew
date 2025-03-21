package testScript;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenShotUtilities;
import Utilities.WaitUtilities;

public class ProjectBase {
	public WebDriver driver;
	public ScreenShotUtilities scrshot;
	@BeforeMethod(alwaysRun = true) //(alwaysRun = true) needs to provide for running Grouping.xml
	@Parameters("browser") //for identification of parameter " <parameter name = "browser" " from crossBrowserXML
	public void browserInitialization(String browser) throws Exception{ //inserts value = "chrome" from crossBrowserXML to String browser
	//public void browserInitialization(){
	if(browser.equalsIgnoreCase("chrome")) {
	driver = new ChromeDriver();	
	}else if(browser.equalsIgnoreCase("edge")){
	driver = new EdgeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
	driver = new FirefoxDriver();	
	}else {
	throw new Exception("driver is not available");
	//throw new NoSuchElementException("No data found.");
	}
	driver.get("https://groceryapp.uniqassosiates.com/admin"); //login to 7R Supermarket 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//assigned Implicit wait 
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));//assigned Implicit wait by calling from class WaitUtilities
	driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	
	public void driverQuitandClose() {
	driver.quit();	
	}
	 
	public void browserQuit(ITestResult iTestResult) throws IOException { 
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
 			scrshot = new ScreenShotUtilities(); 
 			scrshot.getScreenShot(driver, iTestResult.getName()); 
 		} 
  
 		 driver.quit(); 
 	}
 	
}


//crossbrowser testing -> testing in different browsers -> first execute one browser and then the next one
//multibrowser testing -> simultaneous execution of different browsers