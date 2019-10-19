package com.odoo.pageobjects;

public class CustomerPage
{
	 public String create="//button[contains(text(),'Create')]";
	 public String customerlink= "//div[@class='o_control_panel']//a[text()='Customers']";
	 public String name =   "//input[@placeholder='Name']";
	 public String street = "//input[@name='street']";
	 public String city =   "//input[@name='city']";
	 public String state=   "//div[@name='state_id']//input";
	 public String phone=   "//input[@name='phone']";
	 public String email=   "//input[@name='email']";
	 public String save= "//button[contains(text(),'Save')]";
	 public String selectCust= "(//div[contains(@class,'oe_kanban_global_click')])[1]";
	// public String dynSelCust="//div[contains(@class,'oe_kanban_global_click')]//span[text()='"+namec+"']";
	 public String action= "//button[contains(text(),'Action')]";
	 public String delBtn= "//a[contains(text(),'Delete')]";
	 public String okBtn= "//span[text()='Ok']";	
	 public String editBtn= "//button[@title='Edit']";
	 public String imok= "(//button[@class='btn btn-primary']//span[text()='Ok'])[1]";
     public String verCus= "//span[@name='name']";
     public String importBtn= "//button[contains(text(),'Import')]";
     public String loadFilBtn= "//button[text()='Load File']";
     public String importBtn1= "//button[text()='Import']";
     public String rows= "(//td//a[@class='select2-choice'])[1]";
     public String selNam = "(//input[@role='combobox'])[9]";
     }
