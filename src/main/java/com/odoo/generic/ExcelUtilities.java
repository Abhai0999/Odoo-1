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

public class ExcelUtilities {

	String filepath;
	SeleniumLib sl;

	public ExcelUtilities(String filepath) // read data

	{
		this.filepath = filepath;
		sl = new SeleniumLib();
	}

	public ExcelUtilities() // write data
	{

	}

	public String[] readData(String sheetName, String testcaseID) {
		String[] value = null;

		try {
			FileInputStream fis = new FileInputStream(new File(filepath));
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();

			for (int i = 1; i <= rowCount; i++) {
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testcaseID)) {
					int cellCount = rw.getLastCellNum();
					value = new String[cellCount];
					for (int j = 1; j < cellCount; j++) {
						Cell cl = rw.getCell(j);

						switch (cl.getCellType()) {
						case STRING:
							value[j] = cl.getStringCellValue();
							break;

						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cl)) {
								SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
								value[j] = sdf.format(cl.getDateCellValue());
							} else {
								long longValue = (long) cl.getNumericCellValue();
								value[j] = Long.toString(longValue);
							}
							break;

						case BOOLEAN:
							value[j] = Boolean.toString(cl.getBooleanCellValue());
							break;

						default:
							break;
						}

					} // end cell loop

					break;
				} // end if

			} // end of row loop
		} catch (EncryptedDocumentException e) {

		} catch (IOException e) {
		}

		return value;
	}

	public void writeData(Sheet sh, int row, String title, int data) {

		sh.createRow(row).createCell(0).setCellValue(title);
		sh.getRow(row).createCell(1).setCellValue(data);

	}

	public String readAndWriteData(String sheet, int row, int cell)

	{
		String customerName = null;

		try {
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			
			Cell cl1 = wb.getSheet(sheet).getRow(row).getCell(cell);
			String getValue1 = cl1.getStringCellValue();			
			   customerName = sl.randomNumber("'" + getValue1 + "-" + "'{0}");
			  
			

			cl1.setCellValue(customerName);
			 
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (EncryptedDocumentException e) 
		{

		} catch (IOException e) 
		{

		}
		 //return customerName;
		return customerName;

	}

	public String[] readAndWriteData(String sheet, String testCaseId, int clCount) {
		String[] value = null;
		try {
			File file = new File(filepath);
			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int rwCount = sh.getLastRowNum();
			for (int i = 1; i <= rwCount; i++) {
				Row rw = sh.getRow(i);
				if (rw.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseId)) {
					 //int clCount = rw.getLastCellNum();
					value = new String[clCount];
					for (int j = 3; j < clCount; j++) {
						Cell cl = rw.getCell(j);
						switch (cl.getCellType()) {
						case STRING:
							String stringValue = cl.getStringCellValue();
							value[j] = sl.randomNumber("'" + stringValue + "-" + "'{0}");

							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cl)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								String dateValue = sdf.format(cl.getDateCellValue());
								value[j] = sl.randomNumber("'" + dateValue + "-" + "'{0}");
							} else {
								long longValue = (long) cl.getNumericCellValue();
								String numericValue = Long.toString(longValue);
								value[j] = sl.randomNumber("'" + numericValue + "-" + "'{0}");
							}
							break;

						case BOOLEAN:
							String booleanValue = Boolean.toString(cl.getBooleanCellValue());
							value[j] = sl.randomNumber("'" + booleanValue + "-" + "'{0}");
							break;

						default:
							break;
						}
						cl.setCellValue(value[j]);
						FileOutputStream fos = new FileOutputStream(file);

						wb.write(fos);

					}

				}

			}

		} catch (EncryptedDocumentException e) {

		} catch (IOException e) {

		}
		return value;

	}

}
