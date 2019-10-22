package com.odoo.pageobjects;

public class PipelinePage {
	public String createBtn = "//button[contains(text(),'Create')]";
	public String OpportunityTxtFeild = "//input[@name='name']";
	public String customerTxtFeild = "//div[@name='partner_id']//input";
	public String customerDrpDwn = "//div[@name='partner_id']//a";
	public String expeReveTxtFeild = "//div[@name='planned_revenue']//input";
	public String addBtn = "//div/button[text()='Add']";
	public String OppTxt = "//strong[@class='o_kanban_record_title']/span";

}
