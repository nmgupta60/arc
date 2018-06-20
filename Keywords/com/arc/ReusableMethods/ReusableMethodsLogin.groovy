package com.arc.ReusableMethods
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.*

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import java.sql.ResultSet

public class ReusableMethodsLogin extends BaseClass{

	@Keyword
	public void LoginToArcWithRemoteDBMySQL() {
		Class.forName("com.mysql.cj.jdbc.Driver")
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ArcTestData", "root", "")
		java.sql.Statement stmt = connection.createStatement()
		java.sql.ResultSet relsultSet = stmt.executeQuery("Select Url ,UserName , Password from LoginToArc where Env='stg'" )
		while(relsultSet.next()) {
			Object url = relsultSet.getObject('Url')
			println(url)
			Object userName = relsultSet.getObject('UserName')
			println(userName)
			Object password = relsultSet.getObject('Password')
			println(password)
			WebUI.openBrowser(url)
			WebUI.maximizeWindow()
			WebUI.waitForPageLoad(GlobalVariable.timeOut)
			WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
			WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
			WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
			WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
			WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
			WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
			WebUI.delay(5)
		}
	}

	@Keyword
	public void loginIntoArcApplication(String applicationUrl,String Username,String Password) {
		WebUI.openBrowser(applicationUrl)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
		WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'), Username)
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), Password)
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
	}

	@Keyword
	public void loginIntoArcWithGlobalVariable() {
		String url = GlobalVariable.url
		String userName= GlobalVariable.userName
		String password= GlobalVariable.password
		WebUI.openBrowser(url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
		WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'), userName)
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), password)
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(3)
	}

	@Keyword
	public void loginIntoArcWithExcelData() {
		/*** Please change/select row number 1 Stg & 2 Qas, 3 Dev , 4 Prd **********/


		TestData excelData = findTestData('Test Data')
		int row = 2;
		String url = excelData.getValue('ArcURL' , row)
		WebUI.openBrowser(url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		WebUI.click(findTestObject('Page_Home  Arc/button_ACCEPT AND CLOSE'))
		WebUI.click(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.setText(findTestObject('Page_Home  Arc/input_name'),excelData.getValue('UserName', row))
		WebUI.setText(findTestObject('Page_Home  Arc/input_pass'), excelData.getValue('Password', row))
		WebUI.click(findTestObject('Page_Home  Arc/input_field_policy_accept'))
		WebUI.click(findTestObject('Page_Home  Arc/button_Log in'))
		WebUI.delay(5)
		String postLoginText = WebUI.getText(findTestObject('Page_Arc dashboard/span_My Projects'))
		WebUI.verifyMatch(postLoginText, 'My Projects',true)
		WebUI.delay(2)
	}

	@Keyword
	public void logoutFromArcApplication() {
		WebUI.click(findTestObject('Page_Arc dashboard/b_caret'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Page_Arc dashboard/a_ Log Out'))
		WebUI.delay(2)
		WebUI.waitForPageLoad(GlobalVariable.timeOut)
		String Logintext = WebUI.getText(findTestObject('Page_Home  Arc/Click_Log in'))
		WebUI.verifyMatch(Logintext,'LOG IN',, false)
	}
}
