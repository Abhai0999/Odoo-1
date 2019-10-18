package com.odoo.pageobjects;

public class SaleTeamPage 
{
	public String createBtn="//button[contains(text(),'Create')]";
	public String salesTeamNam="//input[@name='name']";
	public String teamLeaderNam="//div[@name='user_id']//input";
	public String email="//input[@name='alias_name']";
	public String accptEmail="//select[@name='alias_contact']";
	public String assignDrpDwn="//div[@name='alias_user_id']//input";
	public String saveBtn="//button[contains(text(),'Save')]";
}
