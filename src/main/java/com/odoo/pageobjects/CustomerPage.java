package com.odoo.pageobjects;

public class CustomerPage {
	public String Create="//button[contains(text(),'Create')]";
	public String Sandy="//span[text()=''sandy'{0}'']";
	
    public String NameField="//input[@placeholder='Name']";
	public String Street="//input[@name='street']";
	public String City="//input[@name='city']";
	public String State="//input[@placeholder='S﻿t﻿a﻿t﻿e']";
	public String Zip="//input[@name='zip']";
	public String Country="//input[@placeholder='C﻿o﻿u﻿n﻿t﻿r﻿y']";
	public String Mobile="//input[@name='mobile']";
	public String Email="//input[@name='email']";
	public String photoUpload="//button[@title='Edit']";
	public String Save="(//button[contains(text(),'Save')])[1]";
	public String confirm="//button[@class='btn btn-primary']/span[text()='Ok']";
	
	public String delname="//div[@class='oe_kanban_details']/descendant::span";
	public String action="(//(//div[@class='btn-group o_dropdown'])[2]/button[contains(text(),'Action')]";
	public String delete="//a[contains(text(),'Delete')]";
	
	public String Import="//button[contains(text(),'Import')]";
	public String Load="//button[text()='Load File']";
	public String import_confirm="//button[text()='Import']";
	


}
