package com.odoo.pageobjects;

public class CustomersPage {
	public String createCustomer="//button[contains(text(),'Create')]";
	public String customerName="//input[@placeholder='Name']";
	public String street1Address="//input[@name='street']";
	public String cityName="//input[@name='city']";
	public String stateName="//div[@name='state_id']//input";
	public String zipCode="//input[@name='zip']";
	public String countryName="//div[@name='country_id']//input";
	public String phoneNumber="//input[@name='phone']";
	public String emailId="//input[@name='email']";
	public String saveButton="//div[@class='o_form_buttons_edit']//button[contains(text(),'Save')]";
	public String uploadPhoto="//button[@title='Edit']";
	
	
    public String existingCustomername="//strong[contains(@class,'o_kanban')]//span"; 
    public String actionBtn="//button[contains(text(),'Action')]";
	public String deleteBtn="//a[contains(text(),'Delete')]";
	public String okBtn="//span[text()='Ok']";
	public String imgBtn="//div[@name='image']/img";
	public String editBtn="//button[contains(text(),'Edit')]";
	public String imgEditBtn="//button[@title='Edit']";
    
	public String CustomerLink="//a[text()='Customers']";
	
	public String titleName="//title[contains(text(),'Rakul')]";
    public String VerCus="//span[@name='name']";
    
    public String importBtn="//button[contains(text(),'Import')]";
    public String loadFile="//button[contains(text(),'Load File')]";
    public String  impBtn="//button[text()='Import']";
    
    public String VeryimportCust="//strong[contains(@class,'o_kanban')]//span[text()='Accenture, Rakul-1']";
    
    
	
    
}
