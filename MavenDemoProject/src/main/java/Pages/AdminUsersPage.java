package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtilities;
public class AdminUsersPage{
public WebDriver driver;
public AdminUsersPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver,this);
}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")private WebElement adminusers;
@FindBy(xpath="//a[@href=\"javascript:void(0)\" and @onclick='click_button(1)']")private WebElement manageusers;
@FindBy(xpath="//input[@id='username']")private WebElement adminusernamefield;
@FindBy(xpath="//input[@id='password']")private WebElement adminpasswordfield;
@FindBy(xpath="//select[@id='user_type']")private WebElement dropdown;
@FindBy(xpath="//button[@type='submit'  and @name='Create']")private WebElement save;
@FindBy(xpath="//i[@class='icon fas fa-check']")private WebElement pagealert;

public void isAdminUsersSelected(){
adminusers.click();
}
public void isNewSelected(){
manageusers.click();
}
public void isUsernameEntered(String adminusername){
adminusernamefield.sendKeys(adminusername);
}
public void isPasswordEntered(String adminpassword){
adminpasswordfield.sendKeys(adminpassword);
}
public void isDropDownValueSelected() {
//Select select = new Select(dropdown);
//select.selectByValue("partner");
PageUtilities pageutilities = new PageUtilities(); //calling another class for drop down function to be performed
//pageutilities.selectByValue(dropdown,"partner");
pageutilities.selectByIndex(dropdown, 2);
//pageutilities.selectByVisibleText(dropdown,"staff");
}
public void submitSave() {
save.click();
}
public boolean alertCheck() {
return pagealert.isDisplayed();
}
public String getAlertMessage() {
return pagealert.getText();
}
}