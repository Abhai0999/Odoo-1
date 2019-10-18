package com.odoo.pageobjects;

public class CustomerPage {
	public String Create="//button[contains(text(),'Create')]";
	public String mohit="//span[text()='mohit']";
public String customerName="//input[@placeholder='Name']";
	
	public String Street="//input[@name='street']";
	public String City="//input[@name='city']";
	public String State="//input[@placeholder='S﻿t﻿a﻿t﻿e']";
	public String Zip="//input[@name='zip']";
	public String Country="//input[@placeholder='C﻿o﻿u﻿n﻿t﻿r﻿y']";
	public String Mobile="//input[@name='mobile']";
	public String Email="//input[@name='email']";
	public String edit="//button[@class='fa fa-pencil fa-lg float-left o_select_file_button']";
	public String Save="(//button[contains(text(),'Save')])[1]";
	
	public String ExistingCustomer="//strong[contains(@class,'o_kanban')]//span";
	public String Delete="////a[contains(text(),'Delete')]";
    public String Action="//button[contains(text(),'Action')]";
	
	
	
}
