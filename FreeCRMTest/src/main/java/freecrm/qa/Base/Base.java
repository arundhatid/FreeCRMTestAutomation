package freecrm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import freecrm.qa.Util.commonUtility;

public class Base {

	//declare public variables
	public static WebDriver driver;
	public static Properties prop;
	public FileInputStream fis;
	
	
	//read properties file
	public Base()
	{
		try {
			System.out.println(System.getProperty("user.dir") + commonUtility.sConfigPropertiesPath);
			fis = new FileInputStream(System.getProperty("user.dir") + commonUtility.sConfigPropertiesPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//set up driver and launch test application
	
	public void setApplication()
	{
		String sDriverPath="";
		switch(prop.getProperty("browser"))
		{
			case "chrome":
			{	
				sDriverPath = System.getProperty("user.dir") + prop.getProperty("chromepath");
				System.setProperty(prop.getProperty("chromekey"), sDriverPath);
				driver = new ChromeDriver();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				break;
			}
			case "edge":
			{
				sDriverPath = System.getProperty("user.dir") + prop.getProperty("edgepath");
				System.setProperty(prop.getProperty("edgekey"),sDriverPath);
				driver = new EdgeDriver();
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				edgeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				break;
			}
			case "ff":
			{
				sDriverPath = System.getProperty("user.dir") + prop.getProperty("geckopath");
				System.setProperty(prop.getProperty("geckodriver"), sDriverPath);
				driver = new FirefoxDriver();
				break;
				
			}
			default:
			{
				System.out.println("User needs to set the driver properties.");
				
			}
		}
		driver.manage().timeouts().implicitlyWait(commonUtility.iImplicitlyWaitTime, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(commonUtility.iPageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}	
	
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
}
