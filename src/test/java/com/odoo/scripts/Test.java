package com.odoo.scripts;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) 
	{
		LocalDate date = LocalDate.now().plusDays(4);
	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String text = date.format(formatters);
	    System.out.println(text);
	    LocalDate parsedDate = LocalDate.parse(text, formatters);
		
	}

}
// mm/dd/yyyy