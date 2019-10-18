package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


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
	//String[] value;
	
	public String[] readData(String sheetName, String testcaseID) 
	{
		String[] value=null;
		//value=null;
		
		
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
						
						Random rd=new Random();
							int num = rd.nextInt(100);
						if(j==3)
						{
							String spt = value[j];
							String[] arr = spt.split("-");
							String nval = arr[0]+"-{0}";
							Object[] obj={num};
							String optVal = MessageFormat.format(nval, obj);
							rw.getCell(j).setCellValue(optVal);
						}
						else if (j==5) {
							String spt = value[j];
							String[] arr = spt.split("-");
							String nval = arr[0]+"-{0}";
							Object[] obj={num};
							String optVal = MessageFormat.format(nval, obj);
							rw.getCell(j).setCellValue(optVal);
							
						}
						else
						{
							cl=rw.getCell(j);
							cl.setCellValue(value[j]);
						}
						FileOutputStream fos=new FileOutputStream(new File(filepath));
						wb.write(fos);
						
						
						
							
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
		
		//write code customer excel sheet.
		//Workbook wc=new XSSFWorkbook();
		//wc.createSheet(Sheet1);
						
		return value;
		
		
	}
	
	
	public void writeData(Sheet sh, int row, String title, int data)
	{
		sh.createRow(row).createCell(0).setCellValue(title);
		sh.getRow(row).createCell(1).setCellValue(data);
	}
	

}
