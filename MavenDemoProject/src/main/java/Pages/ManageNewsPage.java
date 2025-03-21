package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtilities;

public class ManageNewsPage {
public WebDriver driver;
public ManageNewsPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@placeholder='Username']")private WebElement usernamefield;
@FindBy(xpath="//input[@placeholder='Password']")private WebElement passwordfield;
@FindBy(xpath="//button[text()='Sign In']")private WebElement signinbuttonfield;
//@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[1]")private WebElement managenewsselection;
//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")private WebElement managenewsselection;
@FindBy(xpath="(//i[@class='fas fa-arrow-circle-right'])[9]")private WebElement managenewsselection;
//@FindBy(xpath="//a[contains(@href, 'list-news') and contains(text(), 'More info')]")private WebElement managenewsselection;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")private WebElement newfieldselection;
@FindBy(xpath="//textarea[@id='news']")private WebElement dataspaceselection;
@FindBy(xpath="//button[text()='Save']")private WebElement savefeature;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement failedcasealertcheck;

public void enterUserName(String username) {
usernamefield.sendKeys(username);	
}
public void enterPassword(String password) {
passwordfield.sendKeys(password);	
}
public void clickSignIn() {
WaitUtilities waitutilities = new WaitUtilities(); //applying wait from method 'waitForElementToBeClickable' from class WaitUtilities
waitutilities.waitForElementToBeClickable(driver,signinbuttonfield);//applying wait from method 'waitForElementToBeClickable' from class WaitUtilities
signinbuttonfield.click();//explicit wait applied before click function
}
public void isManageNewsSelected() {
managenewsselection.click();
}
public void isNewFieldSelected() {
newfieldselection.click();
}
public void isDataFieldSelected(String newsbuttonfielddata) {
dataspaceselection.sendKeys(newsbuttonfielddata);
}
public void enableSave() {
savefeature.click();
}
public boolean isAlertDisplayed() {
return failedcasealertcheck.isDisplayed();
}
}


