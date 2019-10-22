package com.odoo.pageobjects;

public class BasePage {
	public String Crm = "//div[text()='CRM']";
	public String loggedInEmailID = "//ul[@role='menu']//li[@class='o_user_menu']//span";
	public String menuDrpDwnList = "//li[@class='o_user_menu']/a";
	public String logout = "//a[text()='Log out']";

	public String sales = "//li/a[contains(text(),'Sales')]";
	public String customerBtn = "//span[text()='Customers']";

	public String Configuration = "//a[contains(text(),'Configuration')]";

	public String salesTeamBtn = "//a//span[text()='Sales Teams']";
	public String activityType = "//span[text()='Activity Types']";

}
