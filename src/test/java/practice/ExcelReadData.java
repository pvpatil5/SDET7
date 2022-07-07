package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {


		FileInputStream fis = new  FileInputStream("../SDET7/SDET7.xlsx");

		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		int lastrow = sheet.getLastRowNum();

		for (int i = 1; i <= lastrow; i++)
		{
			String sal =  sheet.getRow(i).getCell(1).toString();

			System.out.println(sal);
		}
	}

}
