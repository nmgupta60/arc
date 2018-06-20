package com.arc.BaseClass

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFName
import org.apache.poi.xssf.usermodel.XSSFRow
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class XlsWriteToNewFileNewFile {

	// Create Work book

	private XSSFWorkbook getWorkBook(){
		return new XSSFWorkbook();
	}

	//Create the Sheet
	private XSSFSheet getSheet(XSSFWorkbook workBook,String sheetName){
		return workBook.createSheet(sheetName);
	}

	//Keyword , which write the data to excel

	@Keyword
	public void writeTOExcelFile(String excelPath,String sheetName,String value,int rowNo,int colNo){
		XSSFWorkbook book = getWorkBook() // created the book
		XSSFSheet sheet = getSheet(book, sheetName) //created the sheet
		XSSFRow aRow = sheet.createRow(rowNo) // created the row-> index
		XSSFCell bCell = aRow.createCell(colNo) // created the col -> index
		bCell.setCellValue(value)
		writeToFileSystem(book,excelPath)
	}

	//Write the excel to the FS

	private void writeToFileSystem(XSSFWorkbook book,String excelPath){
		try {
			FileOutputStream aOut = new FileOutputStream(excelPath)
			book.write(aOut)
			aOut.close()
		} catch (Exception e) {
			KeywordUtil.markError(e.toString())
		}
	}
	/*@Keyword
	 public void demoKey(String name) throws IOException{
	 FileInputStream fis = new FileInputStream("D:\\ArcTest.xlsx")
	 XSSFWorkbook workbook = new XSSFWorkbook(fis)
	 XSSFSheet sheet = workbook.getSheet("NewBuildingProject")
	 println "Catch The Building data"
	 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()
	 Row row = sheet.createRow(rowCount+1)
	 Cell cell = row.createCell(0)
	 cell.setCellType(cell.CELL_TYPE_STRING)
	 cell.setCellValue(name)
	 FileOutputStream fos = new FileOutputStream("D:\\ArcTest.xlsx")
	 workbook.write(fos)
	 }*/
}






