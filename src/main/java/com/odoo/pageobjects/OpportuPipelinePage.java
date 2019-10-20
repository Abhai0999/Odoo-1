package com.odoo.pageobjects;

public class OpportuPipelinePage {
	public String createPipeBtn="//button[contains(text(),'Create')]";
	public String opportuBtn="//input[@name='name']";
	public String selectCustBtn="//div[@name='partner_id']//input";
	public String expectedRevenue="//div[@name='planned_revenue']/input";
	public String addBtn="//div[@name='priority']/../../ancestor::div//div[@class='o_kanban_quick_create']//div/button[text()='Add']";

}
