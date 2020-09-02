package com.Learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{
		File src=new File("./Testdata/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel data "+e.getMessage());
		} 
	}
	
	public String getStringData(String sheetname,int rowno,int colno)
	{
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getStringCellValue();
	}
	
	 
	public double getNumericData(String sheetname,int rowno,int colno)
	{
		return wb.getSheet(sheetname).getRow(rowno).getCell(colno).getNumericCellValue();
	}

}
