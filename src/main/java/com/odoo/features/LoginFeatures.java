package com.odoo.features;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.steps.LoginSteps;

import io.qameta.allure.Feature;

public class LoginFeatures 
{
	LoginSteps ls;
	
	public LoginFeatures(WebDriver driver)
	{
		ls=new LoginSteps(driver);
	}
	
	@Feature("Login Feture")
	public void login(String username, String password)
	{
		ls.enterUN(username);
		ls.enterPwd(password);
		ls.clickLoginBtn();
	}
	
	@Feature("verify Login Feature")
	public void verifyValidLogin(String username)
	{
		ls.verifyCRM();
		ls.verifyLoggedInEmailID(username);
		Reporter.log("Login successfully done", true);
	}
	
}
