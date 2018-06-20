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

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsPayment extends BaseClass{

	@Keyword
	public void paymentByCC(String sheetName , int rowNum){

		/********************Fetching the data via Excel Sheet ******************************/
		String cardName   = data.getCellData(sheetName, "Card Name", rowNum);
		String cardNum    = data.getCellData(sheetName, "Card Number", rowNum);
		String cardDate   = data.getCellData(sheetName, "Date ", rowNum);
		String cardCvv    = data.getCellData(sheetName, "CVV", rowNum);
		String partyName  = data.getCellData(sheetName, "Party Name", rowNum);
		String partyEmail = data.getCellData(sheetName, "Party Email", rowNum);
		String address    = data.getCellData(sheetName, "Address", rowNum);
		String city       = data.getCellData(sheetName, "City", rowNum);
		String country    = data.getCellData(sheetName, "Country", rowNum);
		String state      = data.getCellData(sheetName, "State", rowNum);
		String zip        = data.getCellData(sheetName, "Zip", rowNum);

		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_name '),cardName)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_number'), cardNum)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_expiry'),cardDate)
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_CC_CVV'),cardCvv)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_party_name'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_party_name'),partyName)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_email'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_email'), partyEmail)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_street'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_street'), address)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_city'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_city'), city)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PaymenntLocator/select_AfghanistanAland Island'), country, false)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/PaymenntLocator/select_Select StateAlabamaAlas'),state , true)
		WebUI.clearText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'))
		WebUI.setText(findTestObject('Object Repository/PaymenntLocator/input_zip_code'),zip )
		WebUI.click(findTestObject('Object Repository/PaymenntLocator/button_Next'))
		WebUI.delay(10)
		String paymentSuccessText = WebUI.getText(findTestObject('Object Repository/PaymenntLocator/h2_Congratulations'))
		WebUI.verifyMatch(paymentSuccessText,'Congratulations!',true)
	}
}

