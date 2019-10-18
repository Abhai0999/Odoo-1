package com.odoo.steps;

import java.util.Random;

public class Check {

	public static void main(String[] args) {
		Random rd=new Random();
		
		System.out.println(rd.nextInt(100));
		System.out.println(rd.nextInt(100));
		String s="name";
		String t=s+"{}";
		System.out.println(t);
		
	}

}
