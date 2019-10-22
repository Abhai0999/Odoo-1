package com.odoo.pageobjects;



public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	public String salesButton= "//ul[@class='o_menu_sections']//a[contains(text(),'Sales')]";
	public String clickCustmer= "//a[@role='menuitem']//span[text()='Customers']";
	public String configurationButton= "//a[contains(text(),'Configuration')]";
	public String lostReasonBtn= "//span[text()='Lost Reasons']";
//	public String myPipeline= "//div[@class='dropdown-menu show']//span[text()='My Pipeline']";
	public String salesteamBtn="//a//span[text()='Sales Teams']";
}
