package Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

public void selectByValue(WebElement element,String value) {
Select select =new Select(element);
select.selectByValue(value);	
}

public void selectByIndex(WebElement element,int index) {
Select select =new Select(element);
select.selectByIndex(index);	
}

public void selectByVisibleText(WebElement element,String text) {
Select select =new Select(element);
select.selectByVisibleText(text);
}
}





//assigning common method for performing Select class drop function eg called in class AdminUsersPage


//create all methods



















//utilities(package) -> collection of utility class,
//code reusability,maintainability