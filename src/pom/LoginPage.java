package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage
{
	
	@FindBy(id="txtUsername")
	private WebElement unTextBox;
	@FindBy(id="txtPassword")
	private WebElement pwTextBox;
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	@FindBy(id="spanMessage")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTextBox.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTextBox.sendKeys(pw);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void verifyErrorMsg()
	{
		Assert.assertTrue(errMsg.isDisplayed());
	}
	
}
