package com.odoo.features;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.LoginSteps;

public class LoginFeatures 
{
	LoginSteps ls;
	SeleniumLib lsls;
	
	public LoginFeatures(WebDriver driver)
	{
		ls=new LoginSteps(driver);
		lsls=new SeleniumLib(driver);
	}
	
	public void login(String username, String password)
	{
		lsls.iSleep(6);
		ls.enterUN(username);
		ls.enterPwd(password);
		ls.clickLoginBtn();
	}
	
	public void verifyValidLogin(String username)
	{
		ls.verifyCRM();
		ls.verifyLoggedInEmailID(username);
		Reporter.log("Login successfully done", true);
	}
	
}
