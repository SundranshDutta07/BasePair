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

public class Sample {
     private static final KeywordLogger logger = KeywordLogger.getInstance(Sample.class)
     Screenshot SS = new Screenshot()
	 
	 @Keyword
	 def newSample_Title(v_ScreenshotPath) {
		 try {			 
			 WebUI.waitForElementPresent(findTestObject('Object Repository/New Sample/title_NewSample'), 0)
			 String NewSample= WebUI.getText(findTestObject('Object Repository/New Sample/title_NewSample'))
			 return NewSample
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in newSample_Title'+e.message)
		 }
	 }
	 
	 @Keyword
	 def sampleFile_Input(v_filePath, v_ScreenshotPath) {
		 try {
			 WebUI.executeJavaScript("document.querySelector('input[type=file]').style.display='block';", null)
			 			 
			 WebUI.uploadFile(findTestObject('Object Repository/New Sample/input_UploadFile'), v_filePath)
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in sampleFile_Input'+e.message)
		 }
	 }

	 @Keyword
	 def sampleName_File(v_ScreenshotPath) {
		 try {
			 boolean sampleFile = WebUI.waitForElementPresent(findTestObject('Object Repository/New Sample/sampleName_File'), 0)
			 String SampleFile= sampleFile.toString()
			 return SampleFile
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in sampleName_File'+e.message)
		 }
	 }
	 
	 @Keyword
	 def sampleName_Input(v_SampleName, v_ScreenshotPath) {
		 try {
			 WebUI.sendKeys(findTestObject('Object Repository/New Sample/input_SampleName'), v_SampleName)
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in sampleName_Input'+e.message)
		 }
	 }
	 
	 @Keyword
	 def addTag_Button(v_ScreenshotPath) {
		 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_AddTag'))
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in addTag_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def project_Dropdown(v_ProjectName, v_ScreenshotPath) {
		 try {
			 WebUI.selectOptionByLabel(findTestObject('Object Repository/New Sample/dropdown_Project'), v_ProjectName, false)
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in project_Dropdown'+e.message)
		 }
	 }
	 
	 @Keyword
	 def addTag_Input(v_Key, v_Value, v_ScreenshotPath) {
		 try {
			 WebUI.sendKeys(findTestObject('Object Repository/New Sample/input_Key'), v_Key)
			 WebUI.sendKeys(findTestObject('Object Repository/New Sample/input_Value'), v_Value)
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in addTag_Input'+e.message)
		 }
	 }
	 
	 @Keyword
	 def save_Button(v_ScreenshotPath) {
		 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_Save'))
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in save_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def uploadSamples_Button(v_ScreenshotPath) {
		 try {
			 for(int i=0;i<6;i++) {
				 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_UploadSamples'))
				 }catch(Exception e) {
					 WebUI.scrollToElement(findTestObject('Object Repository/New Sample/button_UploadSamples'), 30)
				 }
				 }
			 WebUI.waitForElementPresent(findTestObject('Object Repository/Samples Page/success_SampleAdded'), 0)	 
			 String SuccessSample = WebUI.getText(findTestObject('Object Repository/Samples Page/success_SampleAdded'))
		     return SuccessSample
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in uploadSamples_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def resetForm_Button(v_ScreenshotPath) {
		 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_ResetForm'))
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in resetForm_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def cancelUpload_Button(v_ScreenshotPath) {
		 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_CancelUpload'))
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in cancelUpload_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def close_Button(v_ScreenshotPath) {
		 try {
			 WebUI.click(findTestObject('Object Repository/New Sample/button_Close'))
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in resetForm_Button'+e.message)
		 }
	 }
	 
	 @Keyword
	 def sampleName_Success(v_SampleName, v_ScreenshotPath) {
		 try {
			 String DynamicXpath = "(//a[contains(text(),'"+v_SampleName+"')])[1]"
			 TestObject Sample = new TestObject()
			 Sample.addProperty("xpath", ConditionType.EQUALS, DynamicXpath)
			 
			 boolean SuccessSample = WebUI.waitForElementPresent(Sample, 0)
			 String successSample = SuccessSample.toString()
			 return successSample
		 }catch(Exception e) {
			 ExceptionHandling EH = new ExceptionHandling()
			 EH.Exception_Handling(v_ScreenshotPath, e)
			 logger.logFailed('Error in sampleName_Success'+e.message)
		 }
	 }
}