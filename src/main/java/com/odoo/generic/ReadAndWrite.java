package com.odoo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWrite {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File file = new File("./testdata/Odoodata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);

		Cell cl1 = wb.getSheet("Sheet1").getRow(1).getCell(0);
		String TeamLeadName = cl1.getStringCellValue();
		System.out.println(TeamLeadName);

		Cell cl2 = wb.getSheet("Sheet1").getRow(1).getCell(1);
		String emailID = cl2.getStringCellValue();
		System.out.println(emailID);

		Random rd = new Random();
		String[] str = TeamLeadName.split("-");
		TeamLeadName = str[0] + "-" + rd.nextInt(1000);
		System.out.println(TeamLeadName);

		String[] id = emailID.split("@");
		emailID = TeamLeadName + "@" + id[1];

	}
}
