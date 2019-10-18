package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.pageobjects.SalesTeamsPage;

public class CreateSalesTeamSteps {
	WebDriver driver;
	SalesTeamsPage stp;

	public CreateSalesTeamSteps(WebDriver driver) {
		this.driver = driver;
		stp = new SalesTeamsPage();
	}

	public void clickOnCreate() {
		driver.findElement(By.xpath(stp.CreateBtn)).click();
	}

	public void createSalTem(String[] salesTeamData) {
		driver.findElement(By.xpath(stp.SalesTeamTxtFeild)).sendKeys(salesTeamData[0]);
		driver.findElement(By.xpath(stp.TeamLeader)).sendKeys(salesTeamData[1]);
		driver.findElement(By.xpath(stp.EmailAlias)).sendKeys(salesTeamData[2]);
		driver.findElement(By.xpath(stp.SaveBtn)).click();
	}
}
