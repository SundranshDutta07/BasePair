package com.pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.utils.*

public class Dashboard {
	private static final KeywordLogger logger = KeywordLogger.getInstance(Dashboard.class)
	Screenshot SS = new Screenshot()

	@Keyword
	def title_Dashboard(v_ScreenshotPath) {
		try {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboard Page/title_Dashboard'), 0)
			String Title = WebUI.getText(findTestObject('Object Repository/Dashboard Page/title_Dashboard'))
			return Title
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in title_Dashboard'+e.message)
		}
	}

	@Keyword
	def createNewProject_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Dashboard Page/button_CreateNewProject'))
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in createNewProject_Button'+e.message)
		}
	}

	@Keyword
	def projectName_Input(v_ProjectName, v_ScreenshotPath) {
		try {
			WebUI.sendKeys(findTestObject('Object Repository/Dashboard Page/input_ProjectName'), v_ProjectName)
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in projectName_Input'+e.message)
		}
	}

	@Keyword
	def create_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Dashboard Page/button_Create'))
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in create_Button'+e.message)
		}
	}

	@Keyword
	def projectCreated_Success(v_ScreenshotPath) {
		try {
			//WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboard Page/success_ProjectCreated'), 30)
			String success = WebUI.getText(findTestObject('Object Repository/Dashboard Page/success_ProjectCreated'))
			return success
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in projectCreated_Success'+e.message)
		}
	}

	@Keyword
	def project_List(v_ProjectName, v_ScreenshotPath) {
		try {
			String DynamicXpath= "(//div[@class='dashboard-content-header'])[1]/following::h1[contains(text(),'"+v_ProjectName+"')]"
			TestObject NewProject = new TestObject()
			NewProject.addProperty("xpath", ConditionType.EQUALS, DynamicXpath)
			boolean project = WebUI.waitForElementPresent(NewProject, 30)
			String Project = project.toString()
			return Project
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in project_List'+e.message)
		}
	}

	@Keyword
	def addSamples_Button(v_ProjectName,v_ScreenshotPath) {
		try {
			String DynamicXpath = "(//h1[contains(text(),'"+v_ProjectName+"')])[1]/following::button[@class='ant-btn ant-btn-link'][1]"
			TestObject AddSample = new TestObject()
			AddSample.addProperty("xpath", ConditionType.EQUALS, DynamicXpath)
			WebUI.click(AddSample)

			boolean toast = WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboard Page/toast_ProjectChanged'), 0)
			String Toast = toast.toString()
			return Toast
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in addSamples_Button'+e.message)
		}
	}

	@Keyword
	def logOut_Button(v_ScreenshotPath) {
		try {
			WebUI.mouseOver(findTestObject('Object Repository/Dashboard Page/icon_menu'))
			WebUI.click(findTestObject('Object Repository/Dashboard Page/button_Logout'))

			WebUI.waitForElementPresent(findTestObject('Object Repository/Login Page/title_Welcome'), 0)
			String Title = WebUI.getText(findTestObject('Object Repository/Login Page/title_Welcome'))
			return Title
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in logOut_Button'+e.message)
		}
	}
}