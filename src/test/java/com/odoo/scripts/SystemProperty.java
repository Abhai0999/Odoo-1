package com.odoo.scripts;

public class SystemProperty 
{
	public static void main(String[] args) 
	{
		String key="browserName";
		String value="chrome";
		
		System.setProperty(key, value);
		
		String val = System.getProperty(key);
		
		System.out.println(val);
		
	}

}
