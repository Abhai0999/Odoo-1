package com.odoo.generic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumLib 
{
	WebDriver driver;
	
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void mouseOver(WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
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
	
	
}
