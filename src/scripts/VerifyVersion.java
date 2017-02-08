package scripts;

import generics.HRMLoginData;

import org.testng.annotations.Test;

import pom.HomePage;
import pom.LoginPage;

public class VerifyVersion extends BaseTest {
	
	@Test
	public void testVerifyVersion()
	{
		String username = HRMLoginData.getCellValue(XL_PATH, "VerifyVersion", 1, 0);
		String password = HRMLoginData.getCellValue(XL_PATH, "VerifyVersion", 1, 1);
		String version = HRMLoginData.getCellValue(XL_PATH, "VerifyVersion", 1, 2);
		LoginPage l = new LoginPage(driver);
		HomePage h = new HomePage(driver);
		
		//Enter username
		l.setUserName(username);
		
		//Enter Password
		l.setPassword(password);
		
		//click login
		l.clickLogin();
		
		//click user dropdown
		h.clickDropDown();
		
		//click about
		h.clickAbout();
		
		//verify version
		h.verifyVersion(version);
	}

}
