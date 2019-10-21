package com.odoo.pageobjects;

public class SalesTeamPage 
{
	public String salesName="//input[@name='name']";
	public String teamLeader="//div[@name='user_id']//input";
	public String emailAlias="//input[@name='alias_name']";
	public String aliasContactDrpDwn="//select[@name='alias_contact']";
	public String assignTo="//div[@name='alias_user_id']//input";
	
	public String leaderEmail="//input[@name='login']";
	public String saveLeader="//span[text()='Save']";
}
