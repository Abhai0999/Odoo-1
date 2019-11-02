package com.odoo.pageobjects;

public class SalesTeamPage 
{
	public String create="//button[contains(text(),'Create')]";
	public String salesTeamName="//input[@name='name']";
	public String teamLeader="//div[@name='user_id']";
	public String createEdit="//a[text()='Create and Edit...']";
	public String TeamLeaderName="//label[text()='Name']/parent::div/h1//input";
	public String teamLeaderEmail="//input[@name='login']";
	public String teamLeadSave="//span[text()='Save']";
	public String aliseName="//input[@name='alias_name']";
	public String add="//button[contains(text(),'Add')]";
	public String checkbox1="(//div[@class='custom-control custom-checkbox']/input/following-sibling::label)[2]";//hardCode
	public String checkbox2="(//div[@class='custom-control custom-checkbox']/input/following-sibling::label)[3]";//hardCode
	public String selectBtn="//span[text()='Select']";
	public String saveBtn="//button[contains(text(),'Save')]";
	public String verifyTeamLead="//div[@class='oe_title']//h1//span";
	public String SalesTeam="//tbody[@class='ui-sortable']//td[@class='o_data_cell o_list_char o_required_modifier']";
	public String action="(//div[@class='btn-group o_dropdown']//button)[2]";
	public String dltBtn="//a[contains(text(),'Delete')]";
	public String confirm="//span[text()='Ok']";
	public String salesTeamBtn="//a[text()='Sales Teams']";

}
