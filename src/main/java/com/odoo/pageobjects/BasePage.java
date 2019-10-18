package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	public String salesLink="//ul[@class='o_menu_sections']//a[contains(text(),'Sales')]";
	public String customerLink="//span[text()='Customers']";
	public String configurationLink="//a[contains(text(),'Configuration')]";
	public String salesTeam="//span[text()='Sales Teams']";
}
