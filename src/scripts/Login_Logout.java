package scripts;

import generics.HRMLoginData;

import org.testng.annotations.Test;

import pom.HomePage;
import pom.LoginPage;

public class Login_Logout extends BaseTest {
	
	@Test
	public void testLoginLogout() throws InterruptedException
	{
		String username = HRMLoginData.getCellValue(XL_PATH, "Login_Logout", 1, 0);
		String password = HRMLoginData.getCellValue(XL_PATH, "Login_Logout", 1, 1);
		String homepgTitle = HRMLoginData.getCellValue(XL_PATH, "Login_Logout", 1, 2);
		String loginpgTitle = HRMLoginData.getCellValue(XL_PATH, "Login_Logout", 1, 3);
		
		LoginPage l = new LoginPage(driver);
		HomePage h = new HomePage(driver);
		
		// Enter Valid UserName
		l.setUserName(username);
		
		// Enter Valid Password
		l.setPassword(password);
		
		// Click on Login button
		l.clickLogin();
		
		// Verify homepage title		
		h.verifyTitle(homepgTitle);
		
		// Click on user dropdown
		h.clickDropDown();
		Thread.sleep(1000);
		
		// Click Logout button
		h.clickLogout();			
			
		// Verify LoginPage Displayed
		l.verifyTitle(loginpgTitle);
	}

}
