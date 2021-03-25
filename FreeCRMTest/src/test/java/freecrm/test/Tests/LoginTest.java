package freecrm.test.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freecrm.qa.Base.Base;
import freecrm.qa.Page.HomePage;
import freecrm.qa.Page.LoginPage;

public class LoginTest extends Base {

	//declare common variables
	
	LoginPage loginPage;
	HomePage homePage=null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
	
	@BeforeMethod()
	public void setBase()
	{
		setApplication();
		
		loginPage = new LoginPage();
		
		
	}
	
	@Test(priority=3)
	public void loginTestPositive()
	{
		System.out.println("driver.gettitle at the beginning: " +  driver.getTitle());
		String sLoginPageTitle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		homePage = loginPage.clickLogin();
		String sHomePageTitle = driver.getTitle();
		if(sLoginPageTitle.equals(sHomePageTitle))
		{
					
			softAssert.fail();
		}
		else
		{
			
			softAssert.assertTrue(true);
		}
		
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void loginTest_InvalidUsernamePassword()
	{
		
		String sLoginPageTitle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		loginPage.enterUserName(prop.getProperty("username")+"ss");
		loginPage.enterPassword(prop.getProperty("password")+"ss");
		homePage = loginPage.clickLogin();
		String sHomePageTitle = driver.getTitle();
		System.out.println("driver.gettitle at the end: " +  driver.getTitle());
		if(sLoginPageTitle.equals(sHomePageTitle))
		{
			
			softAssert.assertTrue(true);
			
		}
		else
		{
				
			softAssert.fail();

		}
		softAssert.assertAll();
	}
	@Test(priority=1)
	public void loginTest_InvalidPassword()
	{
		
		String sLoginPageTitle = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password")+"ss");
		homePage = loginPage.clickLogin();
		String sHomePageTitle = driver.getTitle();
		
		if(sLoginPageTitle.equals(sHomePageTitle))
		{
			
			softAssert.assertTrue(true);
			
		}
		else
		{
					
			softAssert.fail();

		}
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown()
	{
		//tearDown();
		driver.close();
		driver.quit();
	}
}
