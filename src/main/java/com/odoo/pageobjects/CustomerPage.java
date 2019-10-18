package com.odoo.pageobjects;

public class CustomerPage 
{
public String createBtn="//button[contains(text(),'Create')]";
public String nameBx="//input[@placeholder='Name']";
public String streetBx1="//input[@name='street']";
public String streetBx2="//input[@name='street2']";
public String city="//input[@name='city']";
public String stateBx="//input[@placeholder='S﻿t﻿a﻿t﻿e']";
public String phone="//input[@name='phone']";
public String emailBx="//input[@name='email']";
public String saveBtn="//div[@class='o_form_buttons_edit']//button[contains(text(),'Save')]";
public String editbtn="//button[@title='Edit']";
public String custverf="//span[@name='name']";

public String selectdelcust="(//div[contains(@class,'oe_kanban_global_click ')])[1]";
public String clickonaction="//button[contains(text(),'Action')]";
public String clickondelete="//a[contains(text(),'Delete')]";
public String  ok="//span[text()='Ok']";
}
