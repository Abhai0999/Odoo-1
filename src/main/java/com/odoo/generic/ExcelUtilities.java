package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities 
{
	WebDriver driver;
	SeleniumLib sl;
	String filepath;

	public ExcelUtilities(String filepath)  //read data
	{
		this.filepath=filepath;
		sl=new SeleniumLib();
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
					} 
					break;
				}
			} 
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
	public String readAndWriteData(String sheetName, String testcaseID) //redAndWrite(String Sheet, String IDnname)
	{
		String customerName=null;;
		try
		{
			File file=new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();
			System.out.println("************"+rowCount+"************");
			for (int i=1; i <=rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) 
				{
					System.out.println("************step************");
					Cell cl=rw.getCell(3);
					String InputValue=cl.getStringCellValue();
					customerName=sl.randomNumber("'"+InputValue+"-"+"'{0}");
					System.out.println("***********"+customerName+"***********");

					cl.setCellValue(customerName);
					FileOutputStream fos=new FileOutputStream(file);
					wb.write(fos);
					break;
				} 	
			}
		}
		catch(EncryptedDocumentException e)
		{

		}
		catch(IOException e)
		{

		}	
		return customerName;
	}
}