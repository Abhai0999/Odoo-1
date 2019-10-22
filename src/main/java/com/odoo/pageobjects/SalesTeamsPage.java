package com.odoo.pageobjects;

public class SalesTeamsPage {

	public String CreateBtn = "//div//button[contains(text(),'Create')]";
	public String SalesTeamTxtFeild = "//div[@class='oe_title']//input[@type='text']";
	public String EmailAlias = "//input[@name='alias_name']";
	public String TeamLeader = "//div[@name='user_id']//input";
	public String SaveBtn = "//button[contains(text(),'Save')]";
	public String SalesTeam = "//div//a/span[text()='Sales Teams']";
	public String addBtn = "//button[contains(text(),'Add')]";
	public String chkBx = "(//div[@class='custom-control custom-checkbox']//label)[1]";
	public String selectBtn = "//span[text()='Select']";
	// public String membername = "//td[text()='" + membername + "']";
	public String createBtn = "//span[text()='Create']";
	public String SalesTeamRow = "//table//tr";
	public String SalesTeamRows = "//table//tr";
	public String TeamLeaderCol = "//table//tr[{0}]/td";
	public String SalesThirdCol = "//table//tr[{0}]/td[3]";
	public String SalesSecondCol = "//table//tr[{0}]/td[2]";

}
