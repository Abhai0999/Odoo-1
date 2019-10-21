package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	
	public String sales=" //ul[@role='menu']//a[contains(text(),' Sales')]";
	public String customers="//span[text()='Customers']";
	
	public String configuration="//a[contains(text(),'Configuration')]";
	public String salesTeam="//span[text()='Sales Teams']";
	public String create="//button[contains(text(),'Create')]";
	public String save="//button[contains(text(),'Save')]";
	
	

}
