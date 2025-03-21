package testScript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.LoginPage;
import Utilities.FakerUtilities;

public class AdminUsersTest extends ProjectBase {
	@Test
	public void login() {
		String username = "admin";
		String password = "admin";
		FakerUtilities faker = new FakerUtilities();
		String adminusername = faker.creatARandomFirstName();
		String adminpassword = faker.creatARandomLastName();
        //String adminusername = "alexan";
		//String adminpassword = "passw0rd";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.isAdminUsersSelected();
		adminuserspage.isNewSelected();
		adminuserspage.isUsernameEntered(adminusername);
		adminuserspage.isPasswordEntered(adminpassword);
		adminuserspage.isDropDownValueSelected();
		adminuserspage.submitSave();
		boolean verify = adminuserspage.alertCheck();
		String message = adminuserspage.getAlertMessage();
		System.out.println("alert message is" + message);
		Assert.assertTrue(verify, "admin user page failed");
//String message = adminuserspage.getAlertMessage();
//System.out.println("alert message is"+message);
	}

}
