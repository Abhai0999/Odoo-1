package com.odoo.pageobjects;

public class CustomerPage 
{
	public String createBtn= "//button[contains(text(),'Create')]";
	public String customerName="//div[@name='name']//input";
	public String streetName="//input[@placeholder='Street...']";
	public String cityName="//input[@placeholder='City']";
	public String stateName="//div[@name='state_id']//input";
	public String countryName="//div[@name='country_id']//input";
	public String zipCode="//input[@name='zip']";
	public String phoneNo="//input[@name='phone']";
	public String emailID="//input[@name='email']";
	public String image="//img[@name='image']";
	public String pencil="//div[@class='o_form_image_controls']//button";
	public String saveBtn="//div[@class='o_cp_buttons']//button[contains(text(),'Save')]";
	public String customers="//div[@class='oe_kanban_details']//strong//span";//list of customers
	public String actinDrpDwn="//button[contains(text(),'Action')]";
	public String deleteBtn="//a[contains(text(),'Delete')]";
	public String OkBtn="//span[text()='Ok']";
	public String newCustName="//div[@class='oe_title']/h1/span";
	public String customersTab="//li/a[text()='Customers']";
}