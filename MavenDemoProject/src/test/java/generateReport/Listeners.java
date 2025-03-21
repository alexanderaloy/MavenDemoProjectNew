package generateReport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtendReportUtilities;

public class Listeners implements ITestListener{  //ITestListener interface results 
	ExtentTest test; 
	  
 	ExtentReports extent = ExtendReportUtilities.createExtentReports(); //calling createExtentReports method using class ExtendReportUtilities since static method
 	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
  
 	public void onTestStart(ITestResult result) { //ITestResult is an interface methods name fetch and added in report
  
 		ITestListener.super.onTestStart(result); 
 		test = extent.createTest(result.getMethod().getMethodName()); 
 		extentTest.set(test); 
  
 	} 
  
 	public void onTestSuccess(ITestResult result) { //console is listedned and status is passed added in test report
  
 		ITestListener.super.onTestSuccess(result); 
 		extentTest.get().log(Status.PASS, "Test Passed"); 
  
 	} 
 	public void onTestFailure(ITestResult result) { //console is listedned and status is failure added in test report
  
 		ITestListener.super.onTestFailure(result); 
 		extentTest.get().log(Status.FAIL, "Test Failed"); 
 		extentTest.get().fail(result.getThrowable()); 
 		WebDriver driver = null; 
 		String testMethodName = result.getMethod().getMethodName(); 
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (IllegalArgumentException e) { 
  
 			e.printStackTrace(); 
 		} catch (IllegalAccessException e) { 
  
 			e.printStackTrace(); 
 		} catch (NoSuchFieldException e) { 
  
 			e.printStackTrace(); 
 		} catch (SecurityException e) { 
  
 			e.printStackTrace(); //print exception
 		} 
  
 		try { 
 			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver") 
 					.get(result.getInstance()); 
 		} catch (Exception e) { 
 		} 
 	} 
 public void onTestSkipped(ITestResult result) { //status of testcase skipped
 		ITestListener.super.onTestSkipped(result); 
 		extentTest.get().log(Status.SKIP, "Test Skipped"); 
 		String testMethodName = result.getMethod().getMethodName(); 
  
 	} 
  
 	public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
  
 		ITestListener.super.onTestFailedButWithinSuccessPercentage(result); 
 	} 
 public void onTestFailedWithTimeout(ITestResult result) { 
  
 		ITestListener.super.onTestFailedWithTimeout(result); 
 	} 
  
 	public void onStart(ITestContext context) { 
  
 		ITestListener.super.onStart(context); 
 	} 
  
 	public void onFinish(ITestContext context) { //flush method is called for report generation if not called only folder will be generated not included report
  
 		ITestListener.super.onFinish(context); 
 		extent.flush(); 
 	}
}



//all the above methods provided by ITest Listeners 
//adding JRE Latest version -> open JRE System library folder -> right click -> Build path -> configure Build path -> check for JRE librray version 
//-> if version less -> click add library -> click next -> click installed libraries select jdk latest version -> 
//run using XML file
