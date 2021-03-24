package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fileInputStream;
	public static FileOutputStream fileOutputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static XSSFSheet getSheet(String XlFileName, String xlSheetName) throws IOException {
		
		fileInputStream = new FileInputStream(XlFileName);
		workbook = new XSSFWorkbook(fileInputStream);
		sheet= workbook.getSheet(xlSheetName);
		return sheet;
	}
	
	public static int getRowCount(String XlFileName, String xlSheetName) throws IOException {
		
		sheet = XLUtils.getSheet(XlFileName, xlSheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();
		return rowCount;
		
	}
	public static int getCellCount(String XlFileName, String xlSheetName, int rowCount ) throws IOException {
		
		sheet = XLUtils.getSheet(XlFileName, xlSheetName);
		row = sheet.getRow(rowCount);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInputStream.close();
		return cellCount;
	}
	public static String getCellData(String XlFileName,String xlSheetName,int rownum,int colnum) throws IOException  {
		sheet = XLUtils.getSheet(XlFileName, xlSheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			 DataFormatter formatter = new DataFormatter();
			 String cellData = formatter.formatCellValue(cell);
			 return cellData;
		} catch (Exception e) {
			data="";// TODO: handle exception
		}
		workbook.close();
		fileInputStream.close();
		return data;
		
		
	}
	public static String getCellData(String XlFileName,String xlSheetName,int rownum,int colnum,String data) throws IOException  {
		sheet = XLUtils.getSheet(XlFileName, xlSheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		fileOutputStream = new FileOutputStream(XlFileName);
		workbook.write(fileOutputStream);
		workbook.close();
		fileInputStream.close();
		fileOutputStream.close();
		return data;
		
	}
	

}
