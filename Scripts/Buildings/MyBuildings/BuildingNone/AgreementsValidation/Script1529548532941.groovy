import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.asserts.Assertion

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.arc.BaseClass.BaseClass
CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsSearch.searchProgram'(GlobalVariable.BuildingSheet, GlobalVariable.rowNumSeven)
WebUI.delay(3)

try{
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.verifyAgreement'()
	WebUI.delay(3)
	//String downloadpath ='C:\\Users\\ARJUN\\Downloads'
	String filename = 'Agreement.pdf'
	CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsManage.isFileDownloaded'(filename)
} catch(Throwable t){
	System.out.println(t.getLocalizedMessage())
	Error e1 = new Error(t.getMessage())
	e1.setStackTrace(t.getStackTrace())
	e1.printStackTrace()
}
/*Assert.assertTrue(isFileDownloaded(downloadpath,'Agreement.pdf'), 'Fail to download')

boolean isFileDownloaded(String downloadpath, String filename){
	boolean flag = false
	File dir = new File(downloadpath)
	File[] dir_contents = dir.listFiles()
	println dir_contents.length()
	
	for(int i=0;i<dir_contents.length;i++){
		println 'File Name at 0 is : '+dir_contents[i].getName()
		if(dir_contents[i].getName().equals(filename)){
			return flag =true
		}
	}
	return flag
}*/

