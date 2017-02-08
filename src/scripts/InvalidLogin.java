package scripts;

import generics.HRMLoginData;

import org.testng.annotations.Test;

import pom.LoginPage;

public class InvalidLogin extends BaseTest {
	
	@Test
	public void testinvalidLogin()
	{
		LoginPage l = new LoginPage(driver);
		for(int i=1;i<=5;i++)
		{
			String username = HRMLoginData.getCellValue(XL_PATH, "InvalidLogin", i, 0);
			String password = HRMLoginData.getCellValue(XL_PATH, "InvalidLogin", i, 1);
			// Enter invalid username
			l.setUserName(username);
			// Enter invalid password
			l.setPassword(password);
			// Click on login button
			l.clickLogin();
			// Verify the error message
			l.verifyErrorMsg();
		}
		
	}

}
