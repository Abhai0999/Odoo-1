package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.pageobjects.CustomersPage;

public class DeleteCustStpes {
	WebDriver driver;
	CustomersPage cp;

	public DeleteCustStpes(WebDriver driver) {
		this.driver = driver;
		cp=new CustomersPage();
	}
	public void selectCust(String name) {
		driver.findElement(By.xpath("//strong[contains(@class,'title')]/span[text()='" + name + "']")).click();
	}
	public void clickOnAction() {
		driver.findElement(By.xpath(cp.Action)).click();
	}
	public void clickOnDel() {
		driver.findElement(By.xpath(cp.DeleteBtn)).click();
	}
	
	public void confDel() {
		driver.findElement(By.xpath(cp.ConfOKBtn)).click();
	}
	
}
