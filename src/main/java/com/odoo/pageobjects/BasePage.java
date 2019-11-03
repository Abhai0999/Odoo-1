package com.odoo.pageobjects;

public class BasePage 
{
	public String crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	public String salesTab="//ul[@class='o_menu_sections']//a[contains(text(),'Sales')]";
	public String customersTab="//span[text()='Customers']";
	public String configurationTab="//a[contains(text(),'Configuration')]";
	public String SalesteamTab="//span[text()='Sales Teams']";
	public String MyPipelineTab="//a/span[text()='My Pipeline']";
	public String settingTab="//a/span[text()='Settings']";
}
