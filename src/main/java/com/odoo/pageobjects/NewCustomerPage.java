package com.odoo.pageobjects;

public class NewCustomerPage {
	public String NameField="//input[@placeholder='Name']";
	
	public String Street="//input[@name='street']";
	public String City="//input[@name='city']";
	public String State="//input[@placeholder='S﻿t﻿a﻿t﻿e']";
	public String Zip="//input[@name='zip']";
	public String Country="//input[@placeholder='C﻿o﻿u﻿n﻿t﻿r﻿y']";
	public String Mobile="//input[@name='mobile']";
	public String Email="//input[@name='email']";
	public String Save="(//button[contains(text(),'Save')])[1]";

}
