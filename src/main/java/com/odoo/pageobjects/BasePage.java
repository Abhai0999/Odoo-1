package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']//a";
	public String logout="//a[text()='Log out']";
	public String Sales="//li//a[contains(text(),'Sales')]";
	public String Customers="//a[@role='menuitem']//span[text()='Customers']";
	public String MyPipeline="//div//a//span[text()='My Pipeline']";
	public String Configuration="//a[contains(text(),'Configuration')]";
	public String salesTeamBtn="//a//span[text()='Sales Teams']";
			
}

