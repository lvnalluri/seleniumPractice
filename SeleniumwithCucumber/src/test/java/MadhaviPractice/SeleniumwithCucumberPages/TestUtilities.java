package MadhaviPractice.SeleniumwithCucumberPages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;


public class TestUtilities {

	public TestUtilities()
	{
		
	}
	
	public static String getScreenshot(WebDriver driver) {
		
		SimpleDateFormat  simpleDateformat = new SimpleDateFormat("yyyyMMddHHSS");
		Date date = new Date();
		String dateValue = simpleDateformat.format(date);
		File destFile = null;
		String filePath = System.getProperty("user.dir") + "\\reports\\currentExtentReportAndScreenshots\\Screenshot" + dateValue + ".png";
		
		try {
			File srcFile = (File)((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			destFile = new File(filePath);
			FileUtils.copyFile(srcFile,  destFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String fileName = destFile.getAbsoluteFile().toString();
		fileName = ".\\" + fileName.substring(fileName.lastIndexOf("\\"));
		return fileName;
	}
	public static void performclickAction(WebElement elementToClick, WebDriver driver) throws InterruptedException {
		
		try {
			
			elementToClick.sendKeys(new CharSequence[]{Keys.RETURN});
			Actions action = new Actions(driver);
			action.moveToElement(elementToClick).sendKeys(new CharSequence[]{Keys.RETURN}).click().perform();
			
	}
		catch(WebDriverException e)
		{
			e.printStackTrace();
		}
	}
}
