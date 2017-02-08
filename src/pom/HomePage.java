package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage
{
	
	@FindBy(linkText="Welcome Admin")
	private WebElement userDropdown;
	@FindBy(xpath=".//a[text()='Logout']")
	private WebElement logoutLink;
	@FindBy(linkText="About")
	private WebElement aboutLink;
	@FindBy(xpath="//p[contains(text(),'Version')]")
	private WebElement version;
	@FindBy(linkText="×")
	private WebElement closeButton;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickDropDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", userDropdown);
		userDropdown.click();
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public void clickAbout()
	{
		aboutLink.click();
	}
	
	public void verifyVersion(String eVersion)
	{
		String aVersion = version.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void clickClose()
	{
		closeButton.click();
	}

}
