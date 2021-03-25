package freecrm.qa.Util;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freecrm.qa.Base.Base;

public class ExtentManager extends Base {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;
	
	
	public static ExtentReports createInstance()
	{
		String sFilePath = System.getProperty("user.dir") + "/Extent/Report";
		new File(sFilePath).mkdir();
		htmlReporter = new ExtentHtmlReporter(sFilePath+"/FreeCRMTestAutomationReport.html");
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Free CRM Test Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Browser", "Edge");
		extent.setSystemInfo("Website Under Test", "FreeCRM");
		
		
		return extent;
	}
	
}
