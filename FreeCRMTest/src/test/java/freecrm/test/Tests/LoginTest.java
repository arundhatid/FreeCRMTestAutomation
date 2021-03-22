package freecrm.test.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import freecrm.qa.Base.Base;
import freecrm.qa.Page.HomePage;
import freecrm.qa.Page.LoginPage;

public class LoginTest extends Base {

	//declare common variables
	SoftAssert softAssert;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod()
	public void setBase()
	{
		setApplication();
		softAssert = new SoftAssert();
		loginPage = new LoginPage();
		
		
	}
	
	@Test
	public void loginTestPositive()
	{
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		homePage = loginPage.clickLogin();
	}
	
	/*@AfterMethod
	public void tearDown()
	{
		//tearDown();
		driver.close();
		driver.quit();
	}*/
}
