package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.LoginPage;

import io.qameta.allure.Step;

public class LoginSteps 
{
	WebDriver driver;
	LoginPage lp;
	BasePage bp;
	SeleniumLib sl;
	
	
	
	public LoginSteps(WebDriver driver)
	{
		this.driver=driver;
		lp=new LoginPage();
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	@Step
	public void enterUN(String username)
	{
		driver.findElement(By.xpath(lp.unTxtBx)).sendKeys(username);
	}
	
	@Step
	public void enterPwd(String password)
	{
		driver.findElement(By.xpath(lp.pwdTxtBx)).sendKeys(password);
	}
	
	@Step
	public void clickLoginBtn()
	{
		driver.findElement(By.xpath(lp.loginBtn)).click();
	}
	
	@Step
	public void verifyCRM()
	{
		
		sl.iSleep(5);
		
		boolean flag = sl.eWaitForVisiblity(30, bp.Crm).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Step
	public void verifyLoggedInEmailID(String username)
	{
		String actualEmailID = driver.findElement(By.xpath(bp.loggedInEmailID)).getText();
		System.out.println("*********"+actualEmailID);
		Assert.assertEquals(actualEmailID, username);
	}
	
}
