package com.odoo.pageobjects;

public class SalesTeamPage 
{
 public String createsalesbutton="//button[@accesskey='c']";
 public String salesteamname="//h1//input[@name='name']";
 public String teamleader="(//div//input[@class='o_input ui-autocomplete-input'])[1]";
 public String tmlemail="//input[@placeholder='email@yourcompany.com']";
 public String saveteamlead="//button[@type='button']//span[text()='Save']";
 public String emailalias="(//input[@name='alias_name'])";
 public String assignto="//div[@name='user_id']//input[@type='text']";
 public String add="//button[contains(text(),'Add')]";
 public String addmembercreate="//span[text()='Create']";
 public String teammembname="(//input[@name='name'])[2]";
 public String teammail="//input[@name='login']";
 public String teammammobile="//input[@name='mobile']";
 public String saveandclose="//span[text()='Save & Close']";
 public String finalsave="//button[@class='btn btn-primary o_form_button_save']";
 
}
