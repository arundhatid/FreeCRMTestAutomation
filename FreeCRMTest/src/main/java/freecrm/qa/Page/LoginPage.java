package freecrm.qa.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import freecrm.qa.Base.Base;

public class LoginPage extends Base {

	@FindBy(css="input[name=username]")
	WebElement username;
	

	@FindBy(css="input[type=password]")
	WebElement password;

	@FindBy(css="input[type=submit][value=Login]")
	WebElement login;

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String enterUserName(String sUserName)
	{
		System.out.println("sUserName is : " + sUserName);
		username.sendKeys(sUserName);
		return username.getText();
	}
	public String enterPassword(String sPassword)
	{
		password.sendKeys(sPassword);
		return password.getText();
	}
	public HomePage clickLogin()
	{
		login.click();
		return new HomePage();
		
	}
}
