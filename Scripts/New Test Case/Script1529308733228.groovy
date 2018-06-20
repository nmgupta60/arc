import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.click(findTestObject('Test/Page_Arc dashboard/a_ My Cities'))

WebUI.click(findTestObject('Test/Page_Arc dashboard/span_My Cities'))

WebUI.click(findTestObject('Test/Page_Arc dashboard/button_ Add'))

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_name'), 'Test')

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_Select a Project TypeCo'), 'string:city', true)

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_Select a Rating SystemL'), 'string:LEED-CT', true)

WebUI.click(findTestObject('Test/Page_Arc dashboard/html_.gm-style-pbctransitionop'))

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_Select Owner TypeBusine'), 'string:Educational: University, Private', 
    true)

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_organization'), 'h')

WebUI.click(findTestObject('Test/Page_Arc dashboard/span_H  G BUILDING AND DESIGN'))

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_owner_email'), 'saurav@groupten.com')

WebUI.click(findTestObject('Test/Page_Arc dashboard/html_.gm-style-pbctransitionop_1'))

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_AfghanistanAland Island'), 'US', true)

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_gross_area'), '5000')

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_occupancy'), '10000')

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_street'), 'Test')

WebUI.click(findTestObject('Test/Page_Arc dashboard/html_.gm-style-pbctransitionop_1'))

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_city'), 'Test')

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_AfghanistanAland Island_1'), 'US', true)

WebUI.selectOptionByValue(findTestObject('Test/Page_Arc dashboard/select_Select StateAlabamaAlas'), 'string:AK', true)

WebUI.setText(findTestObject('Test/Page_Arc dashboard/input_zip_code'), '12121')

WebUI.click(findTestObject('Test/Page_Arc dashboard/input_reg_agreement'))

WebUI.click(findTestObject('Test/Page_Arc dashboard/button_Next'))

WebUI.closeBrowser()

