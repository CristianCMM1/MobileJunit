package utilidadesExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFiles {

	public WriteExcelFiles() {
		
	}
	@SuppressWarnings({"unused", "resource"})
	private void writeExcelFiles(String filepath, String sheetName, String[] dataToStrings) throws IOException 
	{
		File file= new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet= newWorkBook.getSheet(sheetName);
		int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();
		XSSFRow row = newSheet.getRow(0);
		XSSFRow newRow = newSheet.createRow(rowCount+1);
		for (int i=0; i<row.getLastCellNum();i++) {
			
			XSSFCell newCell = newRow.createCell(i);
			newCell.setCellValue(dataToStrings[i]);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkBook.write(outputStream);
		inputStream.close();
	}
	@SuppressWarnings({"unused", "resource"})
	private void writeExcelFiles(String filepath, String sheetName,int rowNumber, int cellNumber, String resultText) throws IOException {
		File file= new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet= newWorkBook.getSheet(sheetName);
		XSSFRow row= newSheet.getRow(rowNumber);
		XSSFCell firstCell = row.getCell(cellNumber-1);
		XSSFCell nextCell= row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkBook.write(outputStream);
		inputStream.close();
		
	}
}
