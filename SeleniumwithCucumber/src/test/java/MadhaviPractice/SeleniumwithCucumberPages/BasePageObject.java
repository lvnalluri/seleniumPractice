package MadhaviPractice.SeleniumwithCucumberPages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePageObject {
	public static File sourceFolder;
	public static File destinationFolder;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Properties config = new Properties();
	private static Properties properties = System.getProperties();
	public static String filePath;
	public static ExtentTest test;

	public static void reportSetup() {

		sourceFolder = new File(System.getProperty("user.dir") + "\\reports\\currentExtentReportAndScreenshots");
		destinationFolder = new File(System.getProperty("user.dir") + "\\reports\\backupExtentReportAndScreenshots");

		
		  try { if(!destinationFolder.exists()) { destinationFolder.mkdirs(); }
		  if(sourceFolder.exists() && sourceFolder.isDirectory()) { File[] listOfFiles
		  = sourceFolder.listFiles(); if (listOfFiles != null) { File[] var4 =
		  listOfFiles; int var3 = listOfFiles.length;
		  
		  for(int var2 = 0; var2 < var3; ++var2) { File child = var4[var2];
		  child.renameTo(new File(destinationFolder + "\\" + child.getName()));
		  
		  }
		  
		  FileUtils.cleanDirectory(sourceFolder);
		  
		  } } } catch(Exception e) { e.printStackTrace(); }
		 

		SimpleDateFormat simpleDateFormate = new SimpleDateFormat("yyyyMMddHHMMSS");

		Date date = new Date();
		String dateValue = simpleDateFormate.format(date);

		filePath = System.getProperty("user.dir") + "\\reports\\currentExtentReportAndScreenshots\\"
				+ "TestExecutionReport" + dateValue + ".html";

		String workingDir = System.getProperty("user.dir");
		report = new ExtentReports(filePath, true, DisplayOrder.OLDEST_FIRST);
		report.loadConfig(new File(workingDir + "/src/test/resources/extent-config.xml"));
		logger = report.startTest("Regression Test Cases");
		// test = report.startTest("TestName");
		logger.log(LogStatus.INFO, "Execution Started");
		// test.log(LogStatus.PASS, "Report Started");

	}

	public static void close() {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat("yyyyMMddHHMMSS");

		Date date = new Date();
		String dateValue = simpleDateFormate.format(date);
		String EMAIL = "nmp117@gmail.com";
		String cucumberHTMLReport = System.getProperty("user.dir") + "/reports/cucumber/html/index.html";
		logger = report.startTest("Report & CleanUp");
		logger.log(LogStatus.INFO, "Cucumber HTML Report", cucumberHTMLReport);
		logger.log(LogStatus.PASS, "Close Browser", "Browser is closed");
		report.endTest(logger);
		report.flush();
		Driver.getDriver().close();
		test.log(LogStatus.PASS, "Report Started");

	}

}
