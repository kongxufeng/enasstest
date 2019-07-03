package com.enass.ocr;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ocr {

	public static String ocrtest() {
		// 原始地址
		String originalImg = "D:\\ocr\\1.jpg";
		// 识别样本输出地址
		String ocrResult = "D:\\ocr\\2.jpg";
		// 去除噪点
		ImgUtils.removeBackground(originalImg, ocrResult);
		// ocr识别
		String code = ImgUtils.executeTess4J(ocrResult);
		// 输出识别结果
		System.out.println("ocr识别结果：" + code);
		return code;

	}

	// 截取验证码图片（id = imgcode）
	public static void snapshotAndSave(WebDriver driver) {

		WebElement ele = driver.findElement(By.id("imgcode"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {// Get entire page screenshot
			BufferedImage fullImg;
			fullImg = ImageIO.read(screenshot);
			Point point = ele.getLocation();
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);
			File screenshotLocation = new File("D:\\ocr\\1.jpg");
			FileUtils.copyFile(screenshot, screenshotLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
