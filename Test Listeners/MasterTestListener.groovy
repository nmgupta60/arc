import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.text.SimpleDateFormat

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.server.DefaultDriverFactory
import org.testng.annotations.BeforeMethod

import com.arc.BaseClass.BaseClass
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfPassed
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class MasterTestListener extends BaseClass {
	
	
	
	@SetUp
	void Setup() {		
			
	}
	
	@BeforeTestCase
	public void beforeTestListener(TestSuiteContext testSuite)
	{
				
	/***********Login by Remote MySQL Database environment stg , qas , dev ***********************************************/
     //    CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.LoginToArcWithRemoteDBMySQL'()
		
	/**********Login by global variable by change the environment stg , qas , dev **************************************/
		 CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.loginIntoArcWithGlobalVariable'()
		
	/*************Login by excel sheet by change the row number 1 stg , 2 qas , 3 dev , 4 prd only ********************/
	 //   CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.loginIntoArcWithExcelData'()
		
	/*************Login by enter URL & username & passowrd by parameter ************************************************/
	 //  CustomKeywords.'com.arc.ReusableMethods.ReusableMethodsLogin.loginIntoArcApplication'("http://www.stg.arconline.io/","Saurav@groupten.com","LEEDg10")
	}
	
	
	@BeforeTestSuite
	public void beforeTestSuiteListener(TestSuiteContext testSuite)
	{
	     KeywordUtil.markWarning("Before Test Suite Listener : " + testSuite.getTestSuiteId())
		 	
	
	}
	@BeforeMethod
	public void beforeTestMethod()
	{
		
		
	}
	
	@AfterTestCase
	public void afterTestCase(TestCaseContext testCase){
		//CustomKeywords.'com.helper.login.LoginHelper.logoutFromArcApplication'()
		WebUI.switchToDefaultContent()
		KeywordUtil.markWarning("Test Case Name : " + testCase.getTestCaseId())
		KeywordUtil.markWarning("Test Case Status : " + testCase.getTestCaseStatus())
		if("FAILED".equalsIgnoreCase(testCase.getTestCaseStatus())){
			println "Test case Fail taking Screenshot"	
		try {
				Date data = new Date(System.currentTimeMillis())
				SimpleDateFormat formatarDate = new SimpleDateFormat('yyyyMMddHHmmss')
				WebUI.takeScreenshot((BaseClass.screenShot + formatarDate.format(data)) + '.png')
			}
			catch (Exception e) {
				e.printStackTrace()
			}
		}
		/***Check if any new tab opens than uncomment this code **********
		 WebUI.switchToDefaultContent()
		 WebUI.closeWindowIndex(1)
		 WebUI.closeBrowser()
		 WebUI.switchToWindowIndex(0)*/
	//	 WebUI.closeBrowser()
	 
	}
	
	@AfterTestSuite
	public void afterTestSuite(TestSuiteContext testSuite){
		KeywordUtil.markWarning("After Test Suite Listener : " + testSuite.getTestSuiteId())
	}
	
	
	@TearDown
	void TearDown(){
		System.out.println("[--- This is Tear Down Method ---]")
		//WebUI.closeBrowser()
		
	}
	
	
	@TearDownIfPassed
	void TearDownOnPass(){
		System.out.println("[--- This is Tear Down Method on Pass ---]")
	}
	
	@TearDownIfError
	void TearDownOnError(){
		System.out.println("[--- This is Tear Down Method on Error ---]")
	}
	
	
}