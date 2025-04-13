package com.utils

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.lang.System.Logger
import javax.imageio.ImageIO
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.logging.KeywordLogger

public class Screenshot {
	private static final KeywordLogger logger = KeywordLogger.getInstance(Screenshot.class)

	//Capture screenshots
	@Keyword
	def captureScreenShot(String v_ScreenshotPath) {
		WebUI.waitForPageLoad(10)
		try {
			WebUI.delay(2)
			WebUI.waitForPageLoad(10)
			Robot robot = new Robot()
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())
			WebUI.delay(2)
			BufferedImage screenCapture = robot.createScreenCapture(screenRect)
			String screenshotPath = WebUI.takeFullPageScreenshot(((v_ScreenshotPath + '/screenshot_name') + System.currentTimeMillis()) + '.png', FailureHandling.OPTIONAL)
			ImageIO.write(screenCapture, "png", new File(screenshotPath))
		} catch (Exception e) {
			logger.logFailed("Failed to capture screenshot : "+ e.getMessage())
		}
	}
}