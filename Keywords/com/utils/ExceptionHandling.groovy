package com.utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import java.awt.AWTException
import java.awt.Desktop
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

public class ExceptionHandling {
	@Keyword
	def Exception_Handling(String v_ScreenshotPath,String e) {

		Robot robot = new Robot()
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
		BufferedImage screenCapture = robot.createScreenCapture(screenRect)
		String screenshotPath = WebUI.takeFullPageScreenshot(((v_ScreenshotPath + '/') + System.currentTimeMillis()) + 'Exception_Failure.png', FailureHandling.OPTIONAL)
		ImageIO.write(screenCapture, "png", new File(screenshotPath))

		println(e)

		throw new com.kms.katalon.core.exception.StepFailedException(e)
	}
}