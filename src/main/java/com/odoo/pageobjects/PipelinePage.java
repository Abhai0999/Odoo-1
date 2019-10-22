package com.odoo.pageobjects;

public class PipelinePage 
{
	public String createBtn="//button[contains(text(),'Create')]";
	public String opportunity="//td/input[@name='name']";
	public String customerDrpDwn="//div[@class='o_input_dropdown']";
	public String customerName="//li[@class='ui-menu-item']"; //list of all existing customers
	public String expcetedRevenue="//div[@name='planned_revenue']//input";
	public String addBtn="//div/button[text()='Add']";
	public String allOpprotunities="//div[@class='oe_kanban_content']//strong";
	public String newOpprotunity="//h1/span[@name='name']";
	public String srcEle="(//div[@class='o_kanban_header']/div/span[starts-with(@id,'#kanban_he')])[1]";
	public String destEle="(//div[@class='o_kanban_header']/div/span[starts-with(@id,'#kanban_he')])[2]";
	public String desireOppActivity="//span[text()='xxxx']//parent::strong//ancestor::div//a/span[@role='img']";//Dynamic X-path
	public String schdActivityField="//strong[text()='Schedule an activity']";
	public String acitivityType="//div[@name='activity_type_id']//input[@type='text']";
	public String dueDate="//input[@name='date_deadline']";// calenderHandling
	public String SummryField="//input[@name='summary']";
	public String AssignTo="//div[@name='user_id']//input";
	public String ScheduleBtn="//span[text()='Schedule']";
}
