package dev.topani.html;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import dev.topani.functional.framework.TestBase;

public class HelloWorldTest extends TestBase{

	WebDriver driver;
	
	@Test()
	public void HelloWorldPage_verifyTitle() throws MalformedURLException {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "48.0");
		caps.setCapability("name", this.getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		driver = new RemoteWebDriver(new URL(sauceURL), caps);
		driver.get("http://localhost:8080/HelloWorld.html");
		assertEquals(driver.getTitle(), "Hello World", "Title did not match 'Hello World'");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(driver != null) {
			((JavascriptExecutor) driver).executeScript("sauce:job-result=" + result.isSuccess());
			driver.quit();
		}
	}
}
