package com.enass.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


/**
 * 基本测试类，不含任何测试方法，主要用于被其他测试类继承
 *
 */

public class BaseTest {
	public WebDriver driver;
	private Logger logger = LogManager.getLogger();
	@AfterSuite
	public void closeService() {
		DriverUtils.stopService();
	}

	@BeforeMethod()
	// @Parameters({ "username", "password" })
	public void initDriver() {
		Config config = new Config("config.properties");
		System.setProperty("htyl.browser", config.getConfig("htyl.browser"));
		driver = DriverUtils.getDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("最大化窗口");
		driver.manage().window().maximize();
		// // 1、登录
		// Longin longin = new Longin(driver);
		// longin.longin(username, password);
	}


	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
}
