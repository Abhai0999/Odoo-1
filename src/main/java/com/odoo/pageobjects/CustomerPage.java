package com.odoo.pageobjects;



public class CustomerPage 
{

public String create="//button[contains(text(),'Create')]";
public String custName="//div[@name='name']//input";
public String street="//input[@name='street']";
public String city="//input[@name='city']";
public String state="//div[@name='state_id']//input";
public String zip="//input[@name='zip']";
public String country="//div[@name='country_id']//input";
public String mob="//input[@name='mobile']";
public String email="//input[@name='email']";

public String img="//img[@name='image']";
public String edit="//button[@title='Edit']";
public String save="//button[contains(text(),'Save')]";
public String actions="//button[contains(text(),'Action')]";
public String delete="//a[contains(text(),'Delete')]";
public String confrmOk="//span[text()='Ok']";

public String verifyCust="//span[@name='name']";

public String customerNames="//div[@class='oe_kanban_details']//strong//span";


	
	
	
}
