package com.odoo.pageobjects;

public class CustomersPage 
{
	public String createBtn="//button[contains(text(),'Create')]";
	
    public String custNameTxtBx="//div[@name='name']/input";
	public String streetTxtBx="//input[@name='street']";
	public String cityTxtBx="//input[@name='city']";
	public String stateTxtBx="//div[@name='state_id']//input";
	public String zipTxtbx="//input[@name='zip']";
	public String countryTxtBx="//div[@name='country_id']//input";
	public String mobTxtBx="//input[@name='mobile']";
	public String emailTxtBx="//input[@name='email']";
	public String image="//button[@title='Edit']";
	public String saveBtn="//div[@class='o_cp_buttons']//button[contains(text(),'Save')]";
	public String newCustName="//div[@class='oe_title']/h1/span";
	public String createdCustomer="//div[@class='oe_kanban_details']//strong//span";
	public String action="(//div[@class='btn-group o_dropdown']//button)[2]";
	public String delete="//a[contains(text(),'Delete')]";
	public String deleteConfirmation="//span[text()='Ok']";
	public String customerLink="//a[text()='Customers']";
	
	
}
