package MadhaviPractice.SeleniumwithCucumberPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;
//import MadhaviPractice.SeleniumwithCucumberPages.BasePageObject;

public class LoginPage extends BasePageObject {
	String screenshot;
	
	
	
	
	public void loadPage(String url)
	{
		
		WebDriver driver = Driver.getDriver();
		driver.get(url);
		
//		driver.manage().window().maximize();
		logger.log(LogStatus.PASS, "url launched");
		screenshot = TestUtilities.getScreenshot(driver);
//		test.log(LogStatus.PASS, "Navigated to the specified URL");
		logger.log(LogStatus.PASS, "url launched");
		logger.log(LogStatus.INFO, "Screen Shot Location :"+ this.screenshot, logger.addScreenCapture(this.screenshot));
		
		driver.get("https://www.google.com/");
		logger.log(LogStatus.PASS, "url launched");
		screenshot = TestUtilities.getScreenshot(driver);
//		test.log(LogStatus.PASS, "Navigated to the specified URL");
		logger.log(LogStatus.PASS, "url launched");
		logger.log(LogStatus.INFO, "Screen Shot Location :"+ this.screenshot, logger.addScreenCapture(this.screenshot));
		
		
		
	}

}
