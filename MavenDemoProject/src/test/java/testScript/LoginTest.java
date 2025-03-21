package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExcelUtilities;




public class LoginTest extends ProjectBase{
@Test(groups={"Regression"},retryAnalyzer = retry.Retry.class,description ="verifyTheUserIsAbleToLoginUsingValidCredentials") 
//created (groups="Regression") for Grouping.xml run 
// retryAnalyzer = retry.Retry.class called for failed testcase re-running from Retry.java class
//description ="verifyTheUserIsAbleToLoginUsingValidCredentials" can be provided for each testcase
public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
//String username = "admin"; //direct data assign
//String password = "admin"; //direct data assign
//String username = ExcelUtilities.getStringData(1,0,"loginpage"); 
String username = ExcelUtilities.getStringData(1,0,"loginpage");
//String username = ExcelUtilities.getStringData(3,0,"loginpage");
//String username = ExcelUtilities.getStringData(4,0,"loginpage");
//data assign from excel doc
//calling excel file TestData with data "admin" under Username tab
//getStringData method is a static method so can be called using that corresponding class name ExcelUtilities
//String password = ExcelUtilities.getStringData(1,1,"loginpage");//calling excel file TestData with data "admin" under Username tab
String password = ExcelUtilities.getStringData(1,1,"loginpage");
//String password = ExcelUtilities.getStringData(3,1,"loginpage");
//String password = ExcelUtilities.getStringData(4,1,"loginpage");
LoginPage loginpage = new LoginPage(driver); //created object of loginpage in LoginTest --> calling parameterized constructor so called 
loginpage.enterUserName(username);
loginpage.enterPassword(password);
loginpage.clickSignIn();
boolean isloaded = loginpage.isHomePageDashboardLoaded();
Assert.assertTrue(isloaded,"Home page not loaded when user is entering valid credentials");
}
@Test(retryAnalyzer = retry.Retry.class) //retryAnalyzer = retry.Retry.class called for failed testcase re-running from Retry.java class
public void verifyTheUserIsNotAbleToLoginWithIncorrectPassword() {
String username = "admin";
String password = "admins";	
LoginPage loginpage = new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassword(password);
loginpage.clickSignIn();
boolean checkalert = loginpage.isAlertDisplayed();
Assert.assertTrue(checkalert,"login failed Alert warning is not shown");
}
@Test
public void verifyTheUserIsNotAbleToLoginWithIncorrectUsername() {
String username = "admins";
String password = "admin";	
LoginPage loginpage = new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassword(password);
loginpage.clickSignIn();
boolean checkalert = loginpage.isAlertDisplayed();
Assert.assertTrue(checkalert,"login failed Alert warning is not shown");
}
@Test
public void verifyTheUserIsNotAbleToLoginWithIncorrectUsernameAndPassword() {
String username = "admins";
String password = "admins";	
LoginPage loginpage = new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassword(password);
loginpage.clickSignIn();
boolean checkalert = loginpage.isAlertDisplayed();
Assert.assertTrue(checkalert,"login failed Alert warning is not shown");
}
}
//Design pattern --> POM(page object model) with Page factory ->Create page class(under SRC main java folder) and test class (Under SRC Test Java folder)
//class arrangement