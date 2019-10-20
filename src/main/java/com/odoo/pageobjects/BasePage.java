package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	
	public String sales="//li/a[contains(text(),'Sales')]";
	public String selectCustomers="//span[text()='Customers']";
	
	public String configurationBtn="//a[contains(text(),'Configuration')]";
	public String selSalesTeams="//span[text()='Sales Teams']";
}
