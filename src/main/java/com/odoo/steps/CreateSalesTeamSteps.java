package com.odoo.steps;

import java.text.MessageFormat;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SalesTeamsPage;

public class CreateSalesTeamSteps {
	WebDriver driver;
	SalesTeamsPage stp;
	SeleniumLib sl;

	public CreateSalesTeamSteps(WebDriver driver) {
		this.driver = driver;
		stp = new SalesTeamsPage();
		sl = new SeleniumLib(driver);
	}

	public void clickOnCreate() {
		driver.findElement(By.xpath(stp.CreateBtn)).click();
	}

	public void createSalTem(String[] salesTeamData) {
		String name;
		Random rd = new Random();
		int randomvalue = rd.nextInt(1000);
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);

		String[] salesTeamName = eu.readData("Sheet1", "CreatingSalesTeam_ID");
		name = salesTeamName[3].concat(Integer.toString(randomvalue));
		eu.setCellValue("Sheet1", 5, 3, name);
		driver.findElement(By.xpath(stp.SalesTeamTxtFeild)).sendKeys(name);
		driver.findElement(By.xpath(stp.TeamLeader)).sendKeys(salesTeamData[4]);
		sl.enter();
		driver.findElement(By.xpath(stp.EmailAlias)).sendKeys(salesTeamData[5]);

		sl.iSleep(5);

		driver.findElement(By.xpath(stp.SaveBtn)).click();

	}

	public void clickOnSalesTeam() {
		driver.findElement(By.xpath(stp.SalesTeam)).click();
	}

}
