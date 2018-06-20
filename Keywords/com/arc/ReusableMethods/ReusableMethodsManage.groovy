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
import java.text.DateFormat
import java.text.SimpleDateFormat
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsManage extends BaseClass {

	@Keyword
	public void verifyBillingDate() throws IOException, InterruptedException {
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String Month = new SimpleDateFormat("MMM").format(cal.getTime());
		String Curdate = dateFormat.format(date);
		int Year = Calendar.getInstance().get(Calendar.YEAR);
		CommonMethod.ArcSpecifictoggle("Manage");
		CommonMethod.scrolldowntoElement( "Billing");
		CommonMethod.testlog( "Pass", "Clicking on Billing");
		CommonMethod.click("Billing");
		System.out.println(Month + " " + Curdate + ", " + Year);
		CommonMethod.assertEqualsmessage( "BillingDate", Month + " " + Curdate + ", " + Year,
				"Billing Date is not correct in Billing page");
		CommonMethod.testlog( "Pass", "Verifying Billing date is correct");
	}

	@Keyword
	public void verifyProjectDetails(String sheetName , int rowNum) {
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
		String prjName 		= data.getCellData(sheetName, "Project Name", rowNum)

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))

		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Project/a_ Project'), 10)

		WebUI.click(findTestObject('Object Repository/Manage/Project/a_ Project'))

		//String Name = WebUI.getText(findTestObject('Manage/Project/input_Address'))
		//println Name
		String name = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_name'),'value' )
		println name
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/Page_Arc dashboard (1)/input_name'), prjName)
		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_name'), prjName, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Manage/Project/input_Address'), prjAddress, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_City'), prjCity, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_State'), prjState, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_Country'), prjCountry, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_ownerType'), ownerType, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_organization'), ownerOrg, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_OwnerCountry'), ownerCountry, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_grossArea'), prjArea, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public void modifyProjectDetails(String sheetName,int rowNum){

		String oprHrs = data.getCellData(sheetName, "opr_hrs2",rowNum)
		String occupancy = data.getCellData(sheetName,"occupancy",rowNum)

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))

		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Project/a_ Project'), 10)

		WebUI.click(findTestObject('Object Repository/Manage/Project/a_ Project'))

		WebUI.setText(findTestObject('Object Repository/Manage/Project/input_operatingHours'),'100')

		WebUI.setText(findTestObject('Object Repository/Manage/Project/input_Occupancy'), '100')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/Project/input_grossArea'))
		WebUI.delay(3)
		String opHrs = WebUI.getText(findTestObject('Object Repository/Manage/Project/input_operatingHours'))
		println opHrs
		WebUI.verifyMatch(opHrs, '100',true, FailureHandling.CONTINUE_ON_FAILURE)

		String ocpncy = WebUI.getText(findTestObject('Object Repository/Manage/Project/input_Occupancy'))
		println ocpncy
		WebUI.verifyMatch(ocpncy, '100', true, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void addTeamMember(String sheetName,int rowNum){

		String email = data.getCellData(sheetName, "BTeam",rowNum)

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		//WebUI.waitForElementNotVisible(findTestObject('Object Repository/Manage/Team/a_ Team'), 10)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Team/a_ Team'), 20)
		WebUI.click(findTestObject('Object Repository/Manage/Team/a_ Team'))
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Manage/Team/input_input'), email)

		WebUI.click(findTestObject('Object Repository/Manage/Team/button_Add Member'))

		WebUI.delay(3)

		WebUI.click(findTestObject('Object Repository/Manage/Team/button_Edit'))
	}

	@Keyword
	public void verifyScoreVersion(){

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))

		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Score Version/a_ Score Version'),20)

		WebUI.click(findTestObject('Object Repository/Manage/Score Version/a_ Score Version'))

		WebUI.delay(3)

		String scoreVersion = WebUI.getText(findTestObject('Object Repository/Manage/Score Version/h3_Arc score v2.0'))

		WebUI.verifyMatch(scoreVersion,'Arc score v2.0',true)
	}
}
