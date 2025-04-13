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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.utils.*

public class Login {
	private static final KeywordLogger logger = KeywordLogger.getInstance(Login.class)
	Screenshot SS = new Screenshot()
	
	@Keyword
	def naviagting_WebPage(v_URL,v_ScreenshotPath) {
		try {
			WebUI.openBrowser(v_URL)
			WebUI.maximizeWindow()
			
			WebUI.waitForElementPresent(findTestObject('Object Repository/Login Page/title_Welcome'), 0)
			String Title = WebUI.getText(findTestObject('Object Repository/Login Page/title_Welcome'))
			return Title
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in naviagting_WebPage'+e.message)
		}
	}
	
	@Keyword
	def logIn_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Login Page/button_LogIn'))
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in logIn_Button'+e.message)
		}
	}
	
	@Keyword
	def input_Login(v_username,v_password, v_ScreenshotPath) {
		try {
			WebUI.sendKeys(findTestObject('Object Repository/Login Page/input_Username'), v_username)
			WebUI.sendKeys(findTestObject('Object Repository/Login Page/input_Password'), v_password)
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in input_Login'+e.message)
		}
	}
	
	@Keyword
	def signUp_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Login Page/button_SignUp'))			
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in signIn_Button'+e.message)
		}
	}
	
	@Keyword
	def forgotPassword_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Login Page/button_ForgotPassword'))
			WebUI.waitForElementPresent(findTestObject('Object Repository/Login Page/title_ForgotPassword'), 0)
			String ForgotPassword = WebUI.getText(findTestObject('Object Repository/Login Page/title_ForgotPassword'))
			return ForgotPassword
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in forgotPassword_Button'+e.message)
		}
	}
	
	@Keyword
	def send_Button(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Login Page/button_Send'))
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in send_Button'+e.message)
		}
	}
	
	@Keyword
	def send_Cancel(v_ScreenshotPath) {
		try {
			WebUI.click(findTestObject('Object Repository/Login Page/button_Cancel'))
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in send_Cancel'+e.message)
		}
	}
	
	@Keyword
	def email_ForgotPassword(v_email, v_ScreenshotPath) {
		try {
			WebUI.sendKeys(findTestObject('Object Repository/Login Page/input_email'), v_email)
		}catch(Exception e) {
			ExceptionHandling EH = new ExceptionHandling()
			EH.Exception_Handling(v_ScreenshotPath, e)
			logger.logFailed('Error in email_ForgotPassword'+e.message)
		}
	}
}