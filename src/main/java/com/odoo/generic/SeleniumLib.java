package com.odoo.generic;

import java.text.MessageFormat;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumLib 
{
	WebDriver driver;

	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	public SeleniumLib() {};

	public void mouseOver(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void click(WebElement ele) 
	{
		Actions act= new Actions(driver);
		act.click(ele).perform();
	}

	public void mouseOverClick(WebElement ele, String stateName) 
	{
		Actions act= new Actions(driver);
		act.sendKeys(ele, stateName).perform();
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
	} 

	public void jsClick(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", ele);
	}

	public void scrollIntoView(WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	public void selectDrpDwnOption(WebElement ele, String optionText)
	{
		Select sel=new Select(ele);
		sel.selectByVisibleText(optionText);
	}

	public void selectDrpDwnOption(WebElement ele, int index)
	{
		Select sel=new Select(ele);
		sel.deselectByIndex(index);
	}

	public void dragAndDrop(WebElement ele, int x, int y)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(ele).perform();
		act.dragAndDropBy(ele, x, y).perform();
		act.release(ele).perform();
	}

	public WebElement eWaitForElementPresent(int seconds, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		WebElement wb = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		return wb;
	}

	public WebElement eWaitForVisiblity(int seconds, WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		WebElement wb = wait.until(ExpectedConditions.visibilityOf(ele));

		return wb;
	}

	public WebElement eWaitForVisiblity(int seconds, String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		WebElement wb = wait.until
				(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		return wb;
	}

	public void iSleep(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

	public String randomNumber(String pattern) 
	{
		Random rd= new Random();
		int number = rd.nextInt(1000);
		Object[] obj= {number};
		String value = MessageFormat.format(pattern, obj);	
		return value;
	}

	public WebElement explicitlyWait(String xpath) 
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return ele;
	}

}