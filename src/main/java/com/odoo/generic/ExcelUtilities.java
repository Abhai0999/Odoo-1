  package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities 
{
	String filepath;
	
	public ExcelUtilities(String filepath)  //read data
	{
		this.filepath=filepath;
	}
	
	public ExcelUtilities() //write data
	{
		
	}
	
	public String[] readData(String sheetName, String testcaseID) 
	{
		String[] value=null;
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();
			
			for (int i = 1; i <=rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) 
				{
				int cellCount = rw.getLastCellNum();
				value=new String[cellCount];
				for (int j = 0; j < cellCount; j++) 
				{
				Cell cl = rw.getCell(j);
						
				switch (cl.getCellType()) 
				{
				case STRING:
			    value[j]=cl.getStringCellValue();
				break;
							
				case NUMERIC:
				if (DateUtil.isCellDateFormatted(cl)) 
				{
				SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
				value[j]=sdf.format(cl.getDateCellValue());
				}
				else
				{
				long longValue=(long) cl.getNumericCellValue();
				value[j]=Long.toString(longValue);
				}
				break;
							
				case BOOLEAN:
				value[j]=Boolean.toString(cl.getBooleanCellValue());
				break;
							
				default:
				break;
				}
							
				} //end cell loop
					
					break;
				} //end if
				
			} //end of row loop
		}
		catch(EncryptedDocumentException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
		
		return value;
	}
	
	
	public void writeData(Sheet sh, int row, String title, int data)
	{
		sh.createRow(row).createCell(0).setCellValue(title);
		sh.getRow(row).createCell(1).setCellValue(data);
	}
	
	public void readAndWrite() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis=new FileInputStream(new File(filepath));
		Workbook wbe = WorkbookFactory.create(fis);
		Cell cl1 = wbe.getSheet("sheet1").getRow(2).getCell(3);		
		String namecustomer = cl1.getStringCellValue();
		System.out.println(namecustomer);
		
		Cell cl2 = wbe.getSheet("sheet1").getRow(2).getCell(8);	
		String emailID = cl2.getStringCellValue();
		System.out.println(emailID);
		
		Random rd=new Random();
		String[] str=namecustomer.split("-");
		namecustomer=str[0]+"-"+rd.nextInt(100);
		System.out.println(namecustomer);
		
		String[] id = emailID.split("@");
		emailID=namecustomer+"@"+id[1];
		System.out.println(emailID);
		
		cl1.setCellValue(namecustomer);
		cl2.setCellValue(emailID);
		
		FileOutputStream fost=new FileOutputStream(new File(filepath));
		wbe.write(fost);
		
	}
	public String verifyCustdata(String customername) throws EncryptedDocumentException, IOException
	 {
		String filepath= "./testdata/Odoodata.xlsx";
		FileInputStream fist=new FileInputStream(new File(filepath));
		Workbook wb = WorkbookFactory.create(fist);
		Cell cl1 = wb.getSheet("Sheet1").getRow(3).getCell(1);
		
		cl1.setCellValue(customername);
		FileOutputStream fos=new FileOutputStream(new File(filepath));
		wb.write(fos);	
		String cellv = cl1.getStringCellValue();
	    System.out.println(cellv);
			
		
		return cellv;
	     
		           
	}
	public void readandwrit(String sheetname,int row,int cell,int cell1) throws IOException
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	    FileInputStream fis=new FileInputStream(new File(filepath));
		Workbook wbe = WorkbookFactory.create(fis);
		Cell cl11 = wbe.getSheet(sheetname).getRow(row).getCell(cell);		
		String salesteamname = cl11.getStringCellValue();
		System.out.println(salesteamname);
		
		Cell cl12 = wbe.getSheet(sheetname).getRow(row).getCell(cell1);	
		String teamleadername = cl12.getStringCellValue();
		System.out.println(teamleadername);
		
		Random rd=new Random();
		String[] str=salesteamname.split("-");
		salesteamname=str[0]+"-"+rd.nextInt(100);
		System.out.println(salesteamname);
		
		String[] str1=teamleadername.split("-");
		teamleadername=str1[0]+"-"+rd.nextInt(100);
		System.out.println(teamleadername);
		
		cl11.setCellValue(salesteamname);
		cl12.setCellValue(teamleadername);
		
		FileOutputStream fost=new FileOutputStream(new File(filepath));
		wbe.write(fost);
		
 }

	}
	
