package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.ActivityTypePage;
import com.odoo.pageobjects.BasePage;

public class ActivityTypeStep {
	WebDriver driver;
	BasePage bp;
	ActivityTypePage atp;
	SeleniumLib sl;

	public ActivityTypeStep(WebDriver driver) {
		this.driver = driver;
		bp = new BasePage();
		atp = new ActivityTypePage();
		sl = new SeleniumLib(driver);
	}

	public void CreateActivity(String[] activityData) {

		driver.findElement(By.xpath(atp.createBtn)).click();
		sl.iSleep(3);
		// sl.selectDrpDwnOption(driver.findElement(By.xpath()), optionText);
		driver.findElement(By.xpath(atp.nameFeild)).sendKeys(activityData[3]);
		sl.iSleep(5);
		sl.selectDrpDwnOption(driver.findElement(By.xpath(atp.ActPerDrpDwn)), activityData[6]);
		sl.iSleep(3);
		sl.selectDrpDwnOption(driver.findElement(By.xpath(atp.defUserDrpDwn)), activityData[4]);
		sl.iSleep(5);
		driver.findElement(By.xpath(atp.summTxtFeild)).sendKeys(activityData[5]);
		sl.iSleep(5);
		driver.findElement(By.xpath(atp.saveBtn)).click();
		Reporter.log(activityData[3] + " has been successfully Created", true);
	}

}
