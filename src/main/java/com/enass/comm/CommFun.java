package com.enass.comm;

import org.openqa.selenium.WebDriver;

public class CommFun {
	// 切换页签
	public static void switchToWindow(WebDriver driver) throws Exception {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			if (winHandle.equals(winHandleBefore)) {
				driver.close();
			} else {
				// 切换浏览器页签
				driver.switchTo().window(winHandle);
				break;
			}
		}
	}

}
