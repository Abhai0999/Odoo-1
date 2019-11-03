package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	public String salesLink="//ul[@class='o_menu_sections']//a[contains(text(),'Sales')]";
	public String customerLink="//span[text()='Customers']";
	public String configuration="//a[contains(text(),'Configuration')]";
	public String salesTeamBtn="//span[text()='Sales Teams']";
	public String myPipeLine="//span[text()='My Pipeline']";
	
	
}
