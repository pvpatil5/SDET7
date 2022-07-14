package com.VTiger.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String readDataFromExcel(String path,String sheet,int row,int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fileInputStream = new FileInputStream(path);
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		return	workbook.getSheet(sheet).getRow(row).getCell(cell).toString();

	}
	
	public int getLastRowcount(String path,String sheet) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fileInputStream = new FileInputStream(path);
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		return	workbook.getSheet(sheet).getLastRowNum();

	}

}
