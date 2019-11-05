package com.odoo.pageobjects;

public class PipeLinePage 
{
	public String create="//button[contains(text(),'Create')]";
	public String opportunityText="//input[@name='name']";
	public String custText="//div[@name='partner_id']//input[@class='o_input ui-autocomplete-input']";
	public String search="//a[text()='Search More...']";
	public String addCst="//div[@class='modal o_technical_modal show']//td[@class='o_data_cell o_list_char o_readonly_modifier']";			
	public String expRev="//div[@name='planned_revenue']//input";	
	public String addBtn="//div//button[text()='Discard']/preceding-sibling::button[text()='Add']";
	public String verifyOpportunity="//div[@class='oe_kanban_content']//strong//span";
	public String createdOpportunity="//div[@class='oe_kanban_content']//strong//span";
	public String action="(//div[@class='btn-group o_dropdown']//button)[2]";
	public String delete="//a[contains(text(),'Delete')]";
	public String deleteConfirmation="//span[text()='Ok']";
	public String clickPipeline="//a[text()='Pipeline']";
	public String clock="//div[@name='activity_ids']//a[@role='button']//span";				
	public String activity="//strong[text()='Schedule an activity']";		
	public String activityType="//div[@name='activity_type_id']//input";
	public String actSummury="//input[@name='summary']";
	public String openCalander="//span[text()='Open Calendar']";
	public String selectdate="//table[@class='ui-datepicker-calendar']//td/a";
	public String actdayWise="//button[text()='Day']";
	public String time="//tr[@data-time='12:00:00']//td[@class='fc-widget-content']";			
	public String creatActBtn="//button[@type='button']//span[text()='Create']";
	public String markDone="//a[@title='Mark as done']";
	public String feedBack="//textarea[@id='activity_feedback']";
	public String actCnfBtn="//button[@class='btn btn-sm btn-primary o_activity_popover_done']";
	public String verifyActdone="//div[@class='dropdown-menu o_activity show']//span";
	public String verifyQualifiedOpp="//div[@data-id='2']//strong//span";
	public String qualifiedClock="//div[@data-id='2']//div[@name='activity_ids']//a[@role='button']//span";
	public String dueDate="//input[@name='date_deadline']";
	public String assignTo="//div[@name='user_id']//input";
	public String scheduledBtn="//span[text()='Schedule']";
	public String verifySchdAct="//div[@name='activity_ids']//strong/following-sibling::strong";
	public String clickNext="//div[@class='o_calendar_sidebar_container d-none d-md-block']//a[@title='Next']";
	public String verifyPropositionOpp ="//div[@data-id='3']//strong//span";
	public String PropositioClock ="//div[@data-id='3']//div[@name='activity_ids']//a[@role='button']//span";
	public String verifyWonOpportunity ="//div[@data-id='4']//strong//span";







}
