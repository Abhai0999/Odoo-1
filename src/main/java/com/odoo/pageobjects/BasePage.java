package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	
	public String salesDrpDwn="//li/a[contains(text(),'Sales')]";
	public String customerselect="//a[@role='menuitem']//span[text()='Customers']";
	 
	public String configuration="//a[contains(text(),'Configuration')]";
	
	public String selectpipeline="//a[@class='dropdown-item o_menu_entry_lvl_2']//span";
	public String salesteamoption="//span[text()='Sales Teams']";
	
}
