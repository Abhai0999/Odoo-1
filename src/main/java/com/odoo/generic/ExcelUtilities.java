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
		catch(EncryptedDocumentException|IOException e)
		{e.printStackTrace();}
		return value;
	}

	public String[] readAndWriteData1(String sheetInput,String sheetOutput, String testcaseID, int row, int cell) 
	{
		String[] value=null;
		try
		{
			File file=new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetInput);
			int rowCount = sh.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) 
				{
					int cellCount=rw.getLastCellNum();
					for (int j = 3; j<cellCount; j++) 
					{
						Cell cl = rw.getCell(j);
						value=new String[cellCount];
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
							
						if(j<=3) 
						{
							String[] newValue = value[cell].split("_");
							FileOutputStream fos=new FileOutputStream(file);
							Sheet sh2 = wb.getSheet(sheetOutput);
							sh2.getRow(row).createCell(cell).setCellValue(sl.randomNumber("'"+newValue[0]+"-'{0}")+"-"+newValue[1]);
							wb.write(fos);
						}
					}
				break;
				} 	
			}
		}
		catch(EncryptedDocumentException|IOException e)
		{e.printStackTrace();}	
		return value;
	}
	
	public String[] readAndWriteData2(String sheetInput,String sheetOutput, String testcaseID, int row) 
	{
		String[] value=null;
		try
		{
			File file=new File(filepath);
			FileInputStream fis=new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetInput);
			int rowCount = sh.getLastRowNum();
			for (int i = 1; i <= rowCount; i++) 
			{
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) 
				{
					int cellCount=rw.getLastCellNum();
					for (int j = 3; j<cellCount; j++) 
					{
						Cell cl = rw.getCell(j);
						value=new String[cellCount];
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
							
						if(j<=3) 
						{
							String[] newValue = value[j].split("_");
							FileOutputStream fos=new FileOutputStream(file);
							Sheet sh2 = wb.getSheet(sheetOutput);
							sh2.getRow(row).createCell(j).setCellValue(sl.randomNumber("'"+newValue[0]+"-'{0}")+"-"+newValue[1]);
							wb.write(fos);
						}
					}
				break;
				} 	
			}
		}
		catch(EncryptedDocumentException|IOException e)
		{e.printStackTrace();}	
		return value;
	}

	public void writeData(Sheet sh, int row, String title, int data)
	{
		sh.createRow(row).createCell(0).setCellValue(title);
		sh.getRow(row).createCell(1).setCellValue(data);
	}
}