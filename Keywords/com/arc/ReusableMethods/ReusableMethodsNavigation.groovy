package com.arc.ReusableMethods

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.google.common.base.Verify
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.keyword.builtin.VerifyMatchKeyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.builtin.VerifyTextPresentKeyword
import com.thoughtworks.selenium.webdriven.commands.SelectOption

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class ReusableMethodsNavigation {

	private String getMenuItemXpath(String menuName){
		return ".//*[@id='header']//a[text()='" + menuName + "']"
	}

	private TestObject getMenuTestObject(String menuName){
		TestObject menuItem = new TestObject(menuName);
		menuItem.addProperty("xpath", ConditionType.EQUALS, getMenuItemXpath(menuName), true)
		System.out.println("Xpath : " + getMenuItemXpath(menuName))
		return menuItem
	}

	@Keyword
	public void navigateToMenuItem(String menuName){
		TestObject menuItem = getMenuTestObject(menuName)
		WebUI.waitForElementVisible(menuItem, GlobalVariable.timeOut)
		WebUI.click(menuItem)
		WebUI.delay(1)
	}
	@Keyword
	public void navigateToBuilding() {
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ Buildings'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/a_ My Buildings'))
		WebUI.click(findTestObject('Object Repository/Page_Arc dashboard/i_fa fa-bars fa-lg'))
		print "Making Slider On"
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Page_Arc dashboard/span_My Buildings'))
		WebUI.verifyMatch(postNavigationLoginText,'My Buildings',true)
	}
	@Keyword
	public void clickAddProject() {
		WebUI.click(findTestObject('Object Repository/Add_Project_Details/button_ Add'))
		WebUI.delay(1)
		String postNavigationLoginText = WebUI.getText(findTestObject('Object Repository/Add_Project_Details/h1_Project Registration'))
		WebUI.verifyMatch(postNavigationLoginText,'Project Registration',true)
	}
	@Keyword
	public void navigateToCities(){
	}
}

