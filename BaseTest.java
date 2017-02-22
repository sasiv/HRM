package scripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements HRMConstants {
	
	public WebDriver driver;
	
	@Parameters({"remoteURL","browser"})
	
	@BeforeMethod
	public void preCondition(String remoteURL,String browser) throws MalformedURLException
	{
		//driver = new FirefoxDriver();
		URL ra = new URL(remoteURL);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		driver = new RemoteWebDriver(ra,dc);
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
