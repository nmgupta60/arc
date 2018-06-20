package com.arc.ReusableMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.arc.BaseClass.BaseClass
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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import java.text.SimpleDateFormat
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsAddNewProject extends BaseClass{
	ReusableMethodsNavigation navigation = new ReusableMethodsNavigation()
	@Keyword
	public void USBuildingAddNewProject(String sheetName , int rowNum) {
		/**************Reading data form excel sheet*************************/
		String prjType 		= data.getCellData(sheetName, "Project Type", rowNum);
		String prjRating 	= data.getCellData(sheetName, "Rating System", rowNum);
		String spaceType    = data.getCellData(sheetName, "Space Type", rowNum);
		String ownerOrg 	= data.getCellData(sheetName, "Owner Organization", rowNum);
		String ownerType 	= data.getCellData(sheetName, "Owner Type", rowNum);
		String ownerCountry = data.getCellData(sheetName, "Owner Country", rowNum);
		String ownerMail 	= data.getCellData(sheetName, "Owner Email", rowNum);
		String prjArea 		= data.getCellData(sheetName, "Area", rowNum);
		String prjAddress 	= data.getCellData(sheetName, "Address", rowNum);
		String prjCity 		= data.getCellData(sheetName, "City", rowNum);
		String prjCountry 	= data.getCellData(sheetName, "Country", rowNum);
		String prjState 	= data.getCellData(sheetName, "State", rowNum);
		String prjZip 		= data.getCellData(sheetName, "Zip", rowNum);

		Date date = new Date(System.currentTimeMillis())
		SimpleDateFormat formatarDate = new SimpleDateFormat('yyyyMMdd HHmmss')
		String ProjectName = "USBuiding" +prjRating +formatarDate.format(date)
		data.setCellData(sheetName,"Project Name", rowNum, ProjectName)
		navigation.clickAddProject()

		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_name'), ProjectName)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Project TypeCo'), prjType, true)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Add_Project_Details/select_Select a Rating SystemL'), prjRating, true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select space type'),spaceType,true)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select Owner Type'), ownerType, true)
		WebUI.setText(findTestObject('Object Repository/Add_Project_Details/input_organization'),ownerOrg)
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/input_organization'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Add_Project_Details/span_Habitat for Humanity'))
		WebUI.setText(findTestObject('Add_Project_Details/input_owner_email'),ownerMail)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_OwnerCountry'), ownerCountry,false)
		WebUI.setText(findTestObject('Add_Project_Details/input_gross_area'),prjArea )
		WebUI.setText(findTestObject('Add_Project_Details/input_street'), prjAddress)
		WebUI.setText(findTestObject('Add_Project_Details/input_city'), prjCity)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_AfghanistanAland Island (1)'), prjCountry, false)
		WebUI.selectOptionByLabel(findTestObject('Add_Project_Details/select_Select StateAlabamaAlas (1)'),prjState, true)
		WebUI.setText(findTestObject('Add_Project_Details/input_zip_code'), prjZip)
		WebUI.click(findTestObject('Add_Project_Details/input_reg_agreement'))
		WebUI.click(findTestObject('Add_Project_Details/button_Next'))
		WebUI.delay(5)
		String PaymentPageText = WebUI.getText(findTestObject('Add_Project_Details/VerifyPaymentPage_ text'))
		WebUI.verifyMatch(PaymentPageText,'Payment type',true)

		String Project_ID = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/td_BuildingID'))
		System.out.println(Project_ID)
		data.setCellData(sheetName,"Project ID", rowNum, Project_ID)
	}
}