package MadhaviPractice.SeleniumwithCucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import MadhaviPractice.SeleniumwithCucumberPages.BasePageObject;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
plugin = {"json:reports/cucumber/json/json-cucumber-report.json",
		"junit:reports/cucumber/junit/junit-cucumber-report.xml",
		"html:reports/cucumber/html"}, 
features = {//"C:\\Users\\SREE\\Testing\\SeleniumwithCucumber\\src\\main\\java\\MadhaviPractice\\SeleniumwithCucumber\\feature1.feature",
		"src\\main\\java\\MadhaviPractice\\SeleniumwithCucumber\\loginFeature.feature"},

glue = {"MadhaviPractice.SeleniumwithCucumberStep"}
		)
public class BDDRunner {
	
	@BeforeClass
	public static void setUp() throws InstantiationException, IllegalAccessException
	{
		BasePageObject.reportSetup();
	}
	
	@AfterClass
	public static void tearUp()
	{
		BasePageObject.close();
	}
	
}


