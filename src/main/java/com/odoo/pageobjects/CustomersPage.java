package com.odoo.pageobjects;

public class CustomersPage 
{
	public String create="//button[contains(text(),'Create')]";
	public String customerName="//div[@name='name']/input";
	public String street="//input[@name='street']";
	public String city="//input[@name='city']";
	public String state="//div[@name='state_id']//input";
	public String zip="//input[@name='zip']";
	public String country="//div[@name='country_id']//input";
	public String mobileNumber="//input[@name='mobile']";
	public String email="//input[@name='email']";
	public String save="(//button[contains(text(),'Save')])[1]";
}
