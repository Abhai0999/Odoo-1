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
	public String allOpportunity="//div[@role='feed']//span[@role='img']";// allOpportunity 
		
	public String clock1="//span[text()='New']/ancestor::div//a[@class='dropdown-toggle o-no-caret o_activity_btn']"; // new stage only
	public String clock2="//a[@role='button']";
	public String scheduleAct="//strong[text()='Schedule an activity']";
	public String actTypeDrpdwn="//div[@name='activity_type_id']//input";
	public String dueDateDrpDwn="//div[@name='date_deadline']//input";
	public String summaryInput="//input[@name='summary']";
	public String assignedToInput="//div[@name='user_id']//input";
	public String scheduleBtn="//span[text()='Schedule']/parent::button";
	public String openCalBtn="//span[text()='Open Calendar']/parent::button";
	public String nxtMonArrow="//a[@class='ui-datepicker-next ui-corner-all']";
	
	public String allDates="//table[@class='ui-datepicker-calendar']//td/a";
	public String dayBtn="//div/button[text()='Day']";
	public String timeSlot="//tr[@data-time='11:30:00']/td[@class='fc-widget-content']";
	public String crtActSummry="//input[@name='name']";
	public String actCreateBtn="//button/span[text()='Create']";
	public String doneMark="//li[@role='menuitem']//a";
	public String doneBtn="(//button[contains(text(),'Done')])[2]";
	
	public String pipelineTab="//li/a[text()='Pipeline']";
	public String activityName="//span[@title='Log']/following-sibling::strong";
}
