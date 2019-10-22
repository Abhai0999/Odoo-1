package com.odoo.pageobjects;

public class SalesTeamPage 
{
	public String createBtn="//button[contains(text(),'Create')]";
	public String salesTeamNam="//input[@name='name']";
	public String teamLeaderNam="//div[@name='user_id']//input";  			
	public String clkAndEdt="//a[text()='Create and Edit...']";
	public String teamLeadNam="//main//input[@name='name']";
	public String teanLeadEmail="//input[@placeholder='email@yourcompany.com']";
	public String teamLeadSaveBtn="//footer//span[text()='Save']";
	public String email="//input[@name='alias_name']";
	public String saveBtn="//div//button[contains(text(),'Save')]";
	public String salesTeamName="//span[@name='name']";
	public String salesTeamTab="//li//a[text()='Sales Teams']";
	public String allSalesTeam="//td[@class='o_list_record_selector']";
	public String actionDrpDwn="//button[contains(text(),'Action')]";
	public String deleteBtn="//a[contains(text(),'Delete')]";
	public String okBtn="//span[text()='Ok']";
}