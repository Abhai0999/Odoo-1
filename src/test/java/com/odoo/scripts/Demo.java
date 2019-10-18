package com.odoo.scripts;

public class Demo {

	public static void main(String[] args)
	{
		for(int i=0; i<10; i++)
		{
		 	System.out.println("i=" + i);
		    if(i==5)
		    {
		    	System.out.println("*****");
		    	 //break; 		    
		    }
		    break;
		}
	}
}
