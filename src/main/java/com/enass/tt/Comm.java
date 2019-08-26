package com.enass.tt;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 通用
 */
public class Comm {
	// 页面跳转
	public static  void jump(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		String oldwindowHandle = driver.getWindowHandle();
		for (String handle : windowHandles) {
			if (!oldwindowHandle.equals(handle)) {
				continue;
			} else {
				driver.switchTo().window(handle);
				driver.close();
				driver.switchTo().window(oldwindowHandle);
			}
		}
	}

	// 显示等待
	public static void wait_z(WebDriver driver, By elem) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		// 查找id为"test"的元素
		wait.until(ExpectedConditions.presenceOfElementLocated(elem));

	}


	// 新建窗口
	public static void newwindow(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.open('" + url + "');");

	}

}
