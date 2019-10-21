package com.odoo.pageobjects;

public class PipelinePage 
{
	public String create="//button[contains(text(),'Create')]";
	public String oppName="//input[@name='name']";
	public String custName="//div[@name='partner_id']//input";
	public String expRevenue="//div[@name='planned_revenue']//input";
	public String priority="";
	public String add="(//button[text()='Add'])[1]";
	
	public String createCust="//span[text()='Create']";
	
	public String OppNames="//div[@role='article']//strong//span";

}
