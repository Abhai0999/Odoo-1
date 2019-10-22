package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;

public class CommonSteps {
	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	

	public CommonSteps(WebDriver driver) {
		this.driver = driver;
		bp = new BasePage();
		sl=new SeleniumLib(driver);
	}

	public void clickMenuDrpDwnList() {
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}

	public void clickLogout() {
		driver.findElement(By.xpath(bp.logout)).click();
	}

	public void clickOnCRM() {
		driver.findElement(By.xpath(bp.Crm)).click();
	}
	
	public void clickOnSales() {
		driver.findElement(By.xpath(bp.sales)).click();
	}
	
	
	public void clickOnCustomers() {
		driver.findElement(By.xpath(bp.customerBtn)).click();
	}
	public void clickOnConfiguration () {
		driver.findElement(By.xpath(bp.Configuration)).click();
	}
	public void clickOnSalesTeam() {
		sl.jsClick(driver.findElement(By.xpath(bp.salesTeamBtn)));
	}
	
	public void clickOnActivityType() {
		driver.findElement(By.xpath(bp.activityType)).click();
	}

}
