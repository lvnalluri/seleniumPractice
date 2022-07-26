package MadhaviPractice.SeleniumwithCucumberPages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class Driver {
	
private static WebDriver driver;

public Driver() {
	
}
public static WebDriver getDriver() {
	if(driver == null)  {
		
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Projects\\SeleniumwithCucumber\\SeleniumwithCucumber\\ChromeDriver\\chromedriver.exe");
			System.out.println("Chrome Driver Path :" );
			
			String defaultDownloadDir = System.getProperty("user.dir") + "\\src\\test\\resources\\downloads";
			Map<String, Object> prefs = new HashMap();
			prefs.put("download.default_directory", prefs);
			
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments(new String[] {"test-type"});
			options.addArguments(new String[] {"start-maximized"});
			options.addArguments(new String[] {"--js-flags=--expose-gc"});
			options.addArguments(new String[] {"--enable-precise-memory-info"});
			options.addArguments(new String[] {"--disable-popup-blocking"});
			options.addArguments(new String[] {"--disable-default-apps"});
			options.addArguments(new String[] {"--enable-automation"});
			options.addArguments(new String[] {"test-type=browser"});
			options.addArguments(new String[] {"disable-infobars"});
			options.addArguments(new String[] {"disable-extensions"});
			options.addArguments(new String[] {"--incognito"});
			
			 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to get browser driver " + e.getMessage());
		}
	}
	return driver;
}

public static void setDriver(WebDriver driver) {
	
	Driver.driver = driver;
}

public static void close() {
	try {
		getDriver().close();
		driver = null;
	}
	catch (UnreachableBrowserException var)
	{
		System.out.println("Cannot close browser : unreachable browser " + var.getMessage());
	}
}

}

