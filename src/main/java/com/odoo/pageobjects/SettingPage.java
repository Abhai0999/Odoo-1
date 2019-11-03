package com.odoo.pageobjects;

public class SettingPage 
{
	public String generalSett="//div[@class='tab selected']/span[text()='General Settings']";
	public String mngUsers="//span[text()='Manage Users']";
	public String createBtn="//button[contains(text(),'Create')]";
	public String userName="//input[@name='name']";
	public String usserEmail="//input[@name='login']";
	public String saleDrpDwn="//label[text()='Sales']//ancestor::tr//select[@class='o_input o_field_widget']";
	public String adminDrpdwn="//label[text()='Administration']//ancestor::tr//select[@class='o_input o_field_widget']";
	public String saveBtn="//button[contains(text(),'Save')]";
}
