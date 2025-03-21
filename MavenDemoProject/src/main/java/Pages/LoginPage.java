package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;
public LoginPage(WebDriver driver){   //parameterized constructor 
this.driver = driver; //'this' keyword refers to current class instance variable driver
PageFactory.initElements(driver, this); //PageFactory class methods initElements -> webelements initialization (local driver , this(instance driver))
}
//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;  --> webelement locator using page factory /'@FindBy' is an anotation in POM
@FindBy(xpath="//input[@placeholder='Username']")private WebElement usernamefield;
@FindBy(xpath="//input[@placeholder='Password']")private WebElement passworfield;
@FindBy(xpath="//button[text()='Sign In']")private WebElement signinbuttonfield;
@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboardtile;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement failedcasealertcheck;

public void enterUserName(String username) {
usernamefield.sendKeys(username);
}

public void enterPassword(String password) {
passworfield.sendKeys(password);	
}
public void clickSignIn() {
signinbuttonfield.click();	
}
public boolean isHomePageDashboardLoaded() {
return dashboardtile.isDisplayed();
}
public boolean isAlertDisplayed() {
return failedcasealertcheck.isDisplayed();
}
}
