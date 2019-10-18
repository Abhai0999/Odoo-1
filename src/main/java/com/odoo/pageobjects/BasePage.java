package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	
	public String sales="(//a[contains(text(),'Sales')])[1]";
	public String customers="(//span[contains(text(),'Customers')])[1]";
	
	
}
