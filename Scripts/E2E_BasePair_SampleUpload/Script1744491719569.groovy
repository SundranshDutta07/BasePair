import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
	WebUI.comment('Navigating to the webpage')
	String LoginTitle=CustomKeywords.'com.pages.Login.naviagting_WebPage'(v_URL,v_ScreenshotPath)
	assert WebUI.verifyMatch(LoginTitle, v_LoginTitle, false)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	
	WebUI.comment('Enter Login details & Click on Login')
	CustomKeywords.'com.pages.Login.input_Login'(v_username,v_password, v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	CustomKeywords.'com.pages.Login.logIn_Button'(v_ScreenshotPath)	
	
	WebUI.comment('Verify Title at dashboard page')
	String DashboardTitle = CustomKeywords.'com.pages.Dashboard.title_Dashboard'( v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	assert WebUI.verifyMatch(DashboardTitle, v_DashboardTitle, false)
	
	WebUI.comment('Create New Project')
	CustomKeywords.'com.pages.Dashboard.createNewProject_Button'( v_ScreenshotPath)	
	CustomKeywords.'com.pages.Dashboard.projectName_Input'(v_ProjectName, v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	
	CustomKeywords.'com.pages.Dashboard.create_Button'(v_ScreenshotPath)
	
	WebUI.comment('Verify success Message for new project & Project from the Project List')
	String ProjectCreated_MSG = CustomKeywords.'com.pages.Dashboard.projectCreated_Success'( v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	assert WebUI.verifyMatch(ProjectCreated_MSG, v_ProjectCreated_MSG, false)
	
	String SuccessProjectCreated = CustomKeywords.'com.pages.Dashboard.project_List'(v_ProjectName, v_ScreenshotPath)
	assert WebUI.verifyMatch(SuccessProjectCreated, 'true', false)
	
	WebUI.comment('Click on Add Samples & Verify project changed message')
	String ProjectChanged = CustomKeywords.'com.pages.Dashboard.addSamples_Button'(v_ProjectName, v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	assert WebUI.verifyMatch(ProjectChanged, 'true', false)
	
	WebUI.comment('Verify New Sample form')
	String NewSample = CustomKeywords.'com.pages.Sample.newSample_Title'(v_ScreenshotPath)
//	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	assert WebUI.verifyMatch(NewSample, v_NewSample, false)
	
	WebUI.comment('Select file from the system & Verify if file is displayed in the form')
	CustomKeywords.'com.pages.Sample.sampleFile_Input'(v_filePath, v_ScreenshotPath)
	String sampleName_File = CustomKeywords.'com.pages.Sample.sampleName_File'(v_ScreenshotPath)
	assert WebUI.verifyMatch(sampleName_File, 'true', false)
	
	WebUI.comment('Input the sample file name')
	String NewSample = CustomKeywords.'com.pages.Sample.sampleName_Input'(v_SampleName, v_ScreenshotPath)
	
	WebUI.comment('Select project')
	String NewSample = CustomKeywords.'com.pages.Sample.project_Dropdown'(v_ProjectName, v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	
	WebUI.comment('Add Tag')
	CustomKeywords.'com.pages.Sample.addTag_Button'(v_ScreenshotPath)	
	CustomKeywords.'com.pages.Sample.addTag_Input'(v_Key, v_Value, v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	
	CustomKeywords.'com.pages.Sample.save_Button'(v_ScreenshotPath)
	
	WebUI.comment('Click on Upload Samples')
	String SuccessSample= CustomKeywords.'com.pages.Sample.uploadSamples_Button'(v_ScreenshotPath)
	CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
	assert WebUI.verifyMatch(SuccessSample, v_SuccessSample, false)
	
	WebUI.comment('Verify sample is displayed in the comment page')
	String VerifySample= CustomKeywords.'com.pages.Sample.sampleName_Success'(v_SampleName,v_ScreenshotPath)
	assert WebUI.verifyMatch(VerifySample, 'true', false)	
}

finally {
   WebUI.comment('Logout & close Browser')
   CustomKeywords.'com.pages.Dashboard.logOut_Button'(v_ScreenshotPath)
   CustomKeywords.'com.utils.Screenshot.captureScreenShot'(v_ScreenshotPath)
   WebUI.closeBrowser()
}