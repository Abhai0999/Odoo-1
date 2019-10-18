package com.odoo.pageobjects;

public class CustomersPage 
{
	public String create="(//button[contains(text(),'Create')])";
	public String nameTxtBX="//div[@name='name']/input";
	public String streetTxtBx="//input[@name='street']";
	public String cityTxtBx="//input[@name='city']";
	public String stateTxtBx="//div[@name='state_id']//input";
	public String zipTxtBx="//input[@name='zip']";
	public String  countryTxtBx="//div[@name='country_id']//input";
	public String mobTxtBx="//input[@name='mobile']";
	public String emailTxtBx="//input[@name='email']";
	public String  saveBtn="//button[contains(text(),'Save')]";
	
	public String cuslink="//a[text()='Customers']";
	public String actionDrpDwnlist="//div[@class='btn-group o_dropdown'][2]";
	public String deleteBtn="(//a[contains(text(),'Delete')])";
	public String okBtn="(//span[contains(text(),'Ok')])";
	
	public String image="//div[@name='image']/img";
	public String edit="//button[@title='Edit']";
	
	public String CustomersName="//div[@class='oe_kanban_details']//strong//span";
	
}
