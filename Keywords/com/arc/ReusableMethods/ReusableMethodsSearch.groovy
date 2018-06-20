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
import com.sun.imageio.plugins.wbmp.WBMPImageReader

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsSearch extends BaseClass{
	/*************Search By Project ID **************************************/
	@Keyword
	public void searchProgram(String sheetName , int rowNum) {

		String projectId = data.getCellData(sheetName,"Project ID",rowNum)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))

		//	if(WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))!= null)
		//	WebUI.clearText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))


		WebUI.setText(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'), projectId)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/input_searchBar1'))
		WebUI.delay(3)
		String nuberOfProjects = WebUI.getText(findTestObject('Page_Arc dashboard/no_Project (1 project)'))
		println nuberOfProjects
		WebUI.verifyMatch(nuberOfProjects,'Project (1 project)', false)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/search_Result'))
		WebUI.delay(5)
	}
}

