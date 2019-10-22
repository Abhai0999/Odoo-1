package com.odoo.pageobjects;

public class CustomersPage {
	public String create = "//button[contains(text(),'Create')]";

	public String customerslink = "//a[text()='Customers']";

	public String nameFeild = "//div/input[@placeholder='Name']";
	public String addressStreet = "//input[@name='street']";
	public String addressStreet2 = "//input[@name='street2']";
	public String addressCity = "//input[@name='city']";
	public String addressState = "//div[@name='state_id']//input";
	public String addressZip = "//div/input[@name='zip']";
	public String addressCountry = "//div[@name='country_id']//input";
	public String mobileTxtFeild = "//div/input[@name='mobile']";
	public String emailTxtFeild = "//div//input[@name='email']";
	public String saveBtn = "//div[@class='o_cp_buttons']//button[contains(text(),'Save')]";
	public String Action = "//button[contains(text(),'Action')]";
	public String DeleteBtn = "//div/a[contains(text(),'Delete')]";

	public String ConfOKBtn = "//button//span[text()='Ok']";

	public String photoframe = "//button[@title='Edit']";

	public String photoEdit = "//div[@class='o_form_image_controls']//button[@title='Edit']";

	public String allCustomerName = "//div[@class='o_content']/div//strong//span";

}
