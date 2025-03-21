package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtilities;

public class ManageNewsTest extends ProjectBase{
@Test
public void verifyTheUserIsAccessManageNewsTab() throws IOException {
//String username = "admin";
//String password = "admin";
String username = ExcelUtilities.getStringData(1,0,"loginpage");//data read using excel sheet
String password = ExcelUtilities.getStringData(1,1,"loginpage");//data read using excel sheet
//String newsbuttonfielddata = "ManageNewsSampletext";
String newsbuttonfielddata = ExcelUtilities.getStringData(1,0,"managenews");//data read using excel sheet
LoginPage loginpage = new LoginPage(driver);
loginpage.enterUserName(username);
loginpage.enterPassword(password);
loginpage.clickSignIn();
ManageNewsPage managenewspage = new ManageNewsPage(driver);
//managenewspage.enterUserName(username);
//managenewspage.enterPassword(password);
//managenewspage.clickSignIn();
managenewspage.isManageNewsSelected();
managenewspage.isNewFieldSelected();
managenewspage.isDataFieldSelected(newsbuttonfielddata);
managenewspage.enableSave();
boolean checkalert = managenewspage.isAlertDisplayed();
Assert.assertTrue(checkalert,"manage news page check failed Alert warning is not shown");
}
}
