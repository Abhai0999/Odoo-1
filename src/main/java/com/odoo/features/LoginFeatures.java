package com.odoo.features;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.LoginSteps;

public class LoginFeatures 
{
	LoginSteps ls;
	SeleniumLib sl;
	CommonSteps cs;
	
	public LoginFeatures(WebDriver driver)
	{
		ls=new LoginSteps(driver);
	}
	
	public void login(String username, String password)
	{
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
