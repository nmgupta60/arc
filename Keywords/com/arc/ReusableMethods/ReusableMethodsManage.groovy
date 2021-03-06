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

		//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Project/a_ Project'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Project/a_ Project'), 3)

		WebUI.click(findTestObject('Object Repository/Manage/Project/a_ Project'))
		WebUI.delay(3)
		//String Name = WebUI.getText(findTestObject('Manage/Project/input_Address'))
		//println Name
		String name = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_name'),'value')
		println name
		WebUI.verifyMatch(name, prjName,true)

		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_name'), prjName, FailureHandling.CONTINUE_ON_FAILURE)
		String space = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/select_Airport Control TowerAi'),'value')
		WebUI.verifyMatch(space, 'string:'+spaceType, true)

		String address = WebUI.getAttribute(findTestObject('Manage/Project/input_Address'), 'value')
		WebUI.verifyMatch(address, prjAddress,true)
		//WebUI.verifyElementText(findTestObject('Manage/Project/input_Address'), prjAddress, FailureHandling.CONTINUE_ON_FAILURE)

		String city = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_City'), 'value')
		WebUI.verifyMatch(city, prjCity,true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_City'), prjCity, FailureHandling.CONTINUE_ON_FAILURE)

		String state = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_State'), 'value')
		WebUI.verifyMatch(state,prjState, true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_State'), prjState, FailureHandling.CONTINUE_ON_FAILURE)

		String country = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_Country'), 'value')
		WebUI.verifyMatch(country, prjCountry,true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_Country'), prjCountry, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Project/input_ownerType'), 3)
		String type = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/select_Business Improvement Di'), 'value')
		println type
		WebUI.verifyMatch(type,'string:'+ ownerType, true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_ownerType'), ownerType, FailureHandling.CONTINUE_ON_FAILURE)

		String org = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_organization'),'value')
		WebUI.verifyMatch(org, ownerOrg, true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_organization'), ownerOrg, FailureHandling.CONTINUE_ON_FAILURE)

		String ocountry = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_OwnerCountry'), 'value')
		WebUI.verifyMatch(ocountry, ownerCountry, true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_OwnerCountry'), ownerCountry, FailureHandling.CONTINUE_ON_FAILURE)

		String area = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_grossArea'), 'value')
		WebUI.verifyMatch(area, prjArea, true)
		//WebUI.verifyElementText(findTestObject('Object Repository/Manage/Project/input_grossArea'), prjArea, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public void modifyProjectDetails(String sheetName,int rowNum){

		String oprHrs = data.getCellData(sheetName, "opr_hrs2",rowNum)
		String occupancy = data.getCellData(sheetName,"occupancy",rowNum)

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))

		//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Project/a_ Project'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Project/a_ Project'), 3)
		WebUI.click(findTestObject('Object Repository/Manage/Project/a_ Project'))
		WebUI.clearText(findTestObject('Object Repository/Manage/Project/input_operatingHours'))
		WebUI.setText(findTestObject('Object Repository/Manage/Project/input_operatingHours'),'100')
		WebUI.clearText(findTestObject('Object Repository/Manage/Project/input_Occupancy'))
		WebUI.setText(findTestObject('Object Repository/Manage/Project/input_Occupancy'), '100')
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Manage/Project/input_grossArea'))
		WebUI.delay(3)
		String opHrs = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_operatingHours'),'value')
		println opHrs
		WebUI.verifyMatch(opHrs, '100',true, FailureHandling.CONTINUE_ON_FAILURE)

		String ocpncy = WebUI.getAttribute(findTestObject('Object Repository/Manage/Project/input_Occupancy'),'value')
		println ocpncy
		WebUI.verifyMatch(ocpncy, '100', true, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public void addTeamMember(String sheetName,int rowNum){

		String email = data.getCellData(sheetName, "BTeam",rowNum)

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		//WebUI.waitForElementNotVisible(findTestObject('Object Repository/Manage/Team/a_ Team'), 10)
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Team/a_ Team'), 20)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Team/a_ Team'), 2)
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
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Score Version/a_ Score Version'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/Score Version/a_ Score Version'))

		WebUI.delay(3)

		String scoreVersion = WebUI.getText(findTestObject('Object Repository/Manage/Score Version/h3_Arc score v2.0'))

		WebUI.verifyMatch(scoreVersion,'Arc score v2.0',true)
	}

	@Keyword
	public void verifyCertifications(){

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Certification/a_ Certifications'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Certification/a_ Certifications'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/Certification/a_ Certifications'))
		String certificationType = WebUI.getText(findTestObject('Object Repository/Manage/Certification/td_none'))
		WebUI.verifyMatch(certificationType, 'None', true)
		String level = WebUI.getText(findTestObject('Object Repository/Manage/Certification/Level'))
		WebUI.verifyMatch(level, 'Pending', true)
		String certificationDate = WebUI.getText(findTestObject('Object Repository/Manage/Certification/CertificationDate'))
		WebUI.verifyMatch(certificationDate, 'Pending', true)
	}
	@Keyword
	public void verifyBilling(){

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Billing/a_ Billing'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Billing/a_ Billing'),2)
		WebUI.click(findTestObject('Object Repository/Manage/Billing/a_ Billing'))
		String date = WebUI.getText(findTestObject('Object Repository/Manage/Billing/Date'))
		WebUI.verifyMatch(date, 'Jun 19, 2018', true)
		String orderID = WebUI.getText(findTestObject('Object Repository/Manage/Billing/orderID'))
		WebUI.verifyMatch(orderID, '0011014125',true)
		String orderType = WebUI.getText(findTestObject('Object Repository/Manage/Billing/OrderType'))
		WebUI.verifyMatch(orderType,'REGISTRATION',true)
		String total = WebUI.getText(findTestObject('Object Repository/Manage/Billing/total'))
		//WebUI.verifyMatch(total,'$ 1500.00', true)
		String status = WebUI.getText(findTestObject('Object Repository/Manage/Billing/Status'))
		WebUI.verifyMatch(status, 'Completed', true)
		WebUI.click(findTestObject('Object Repository/Manage/Billing/button_Download'))
	}

	@Keyword
	public void verifyAgreement(){

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Agreements/a_ Agreements'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Agreements/a_ Agreements'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/Agreements/a_ Agreements'))
		String date = WebUI.getText(findTestObject('Object Repository/Manage/Agreements/span_Jun 19 2018'))
		WebUI.verifyMatch(date, 'Jun 19, 2018', true)
		String agreementType = WebUI.getText(findTestObject('Object Repository/Manage/Agreements/span_Registration'))
		WebUI.verifyMatch(agreementType, 'Registration', true)
		WebUI.click(findTestObject('Object Repository/Manage/Agreements/button_Download'))
	}

	@Keyword
	public void isFileDownloaded(String filename){
		File dir = new File(downloadPath)
		File[] dir_contents = dir.listFiles()
		println dir_contents.length
		for(int i=0;i<dir_contents.length;i++){
			println 'File Name at'+[i]+ 'is : '+dir_contents[i].getName()
			if(dir_contents[i].getName().equals(filename)){
				println true
			}
		}
	}

	@Keyword
	public void appsCheck(){

		WebUI.click(findTestObject('Object Repository/Manage/a_ Manage'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Manage/Apps/a_ Apps'), 10)
		WebUI.scrollToElement(findTestObject('Object Repository/Manage/Apps/a_ Apps'), 2)
		WebUI.click(findTestObject('Object Repository/Manage/Apps/a_ Apps'))
		WebUI.delay(3)
		String portfolioStart = WebUI.getText(findTestObject('Object Repository/Manage/Apps/PortfolioManager'))
		println portfolioStart
		WebUI.click(findTestObject('Object Repository/Manage/Apps/PortfolioManager'))
		WebUI.delay(3)
		String portfolioEnd = WebUI.getText(findTestObject('Object Repository/Manage/Apps/PortfolioManager'))
		println portfolioEnd

		String dropboxStart = WebUI.getText(findTestObject('Object Repository/Manage/Apps/DropBox'))
		println dropboxStart
		WebUI.click(findTestObject('Object Repository/Manage/Apps/DropBox'))
		WebUI.delay(2)
		String dropboxEnd = WebUI.getText(findTestObject('Object Repository/Manage/Apps/DropBox'))
		println dropboxEnd

		String onedriveStart = WebUI.getText(findTestObject('Object Repository/Manage/Apps/OneDrive'))
		println onedriveStart
		WebUI.click(findTestObject('Object Repository/Manage/Apps/OneDrive'))
		WebUI.delay(2)
		String onedriveEnd = WebUI.getText(findTestObject('Object Repository/Manage/Apps/OneDrive'))
		println onedriveEnd

		String googledriveStart = WebUI.getText(findTestObject('Object Repository/Manage/Apps/GoogleDrive'))
		println googledriveStart
		WebUI.click(findTestObject('Object Repository/Manage/Apps/GoogleDrive'))
		WebUI.delay(2)
		String googledriveEnd = WebUI.getText(findTestObject('Object Repository/Manage/Apps/GoogleDrive'))
		println googledriveEnd
	}
}
