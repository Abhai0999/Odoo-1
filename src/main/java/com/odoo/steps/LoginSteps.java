package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@Step("Enter Username")
	public void enterUN(String username)
	{
		driver.findElement(By.xpath(lp.unTxtBx)).sendKeys(username);
	}
	
	@Step("Enter Password")
	public void enterPwd(String password)
	{
		driver.findElement(By.xpath(lp.pwdTxtBx)).sendKeys(password);
	}
	
	@Step("Click LoginButton")
	public void clickLoginBtn()
	{
		driver.findElement(By.xpath(lp.loginBtn)).click();
	}
	
	@Step("Verify CRM")
	public void verifyCRM()
	{
		sl.iSleep(3);
		boolean flag = sl.eWaitForVisiblity(20, bp.Crm).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Step("Verify EmailID after logged in")
	public void verifyLoggedInEmailID(String username)
	{
		String actualEmailID = driver.findElement(By.xpath(bp.loggedInEmailID)).getText();
		System.out.println("*********"+actualEmailID);
		Assert.assertEquals(actualEmailID, username);
	}
	
}
