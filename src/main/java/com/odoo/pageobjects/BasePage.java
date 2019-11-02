package com.odoo.pageobjects;

public class BasePage 
{
	public String Crm="//div[text()='CRM']";
	public String loggedInEmailID="//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList="//li[@class='o_user_menu']/a";
	public String logout="//a[text()='Log out']";
	public String Sales="(//a[contains(text(),'Sales')])[1]";
	public String Customer="//span[text()='Customers']";
	public String configuration="//a[contains(text(),'Configuration')]";
	public String salesTeamBtn="//span[text()='Sales Teams']";
	public String MyPipleline= "//a/span[text()='My Pipeline']";
}
