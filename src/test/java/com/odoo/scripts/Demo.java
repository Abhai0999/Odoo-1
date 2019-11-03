package com.odoo.scripts;

import java.util.Random;

public class Demo 
{
	String st;
	Random rd;

	public void split() 
	{
		String[] newst=st.split(" ");
		rd=new Random();
		int num = rd.nextInt(100);
		System.out.println(newst[0]+"-"+num);
		System.out.println(newst[1]+"-"+num);
		System.out.println(newst[2]+"-"+num);
		System.out.println(newst[3]+"-"+num);
	}
	public static void main(String[] args) 
	{
		Demo dm=new Demo();
		dm.st="raman:- pradeep ka bhiaya";
		dm.split();

	}
}
