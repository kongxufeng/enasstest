package com.enass.enass;


import java.util.concurrent.TimeUnit;

import com.enass.data.UserData;
import com.enass.htyl.page.LoginPage1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ClassroomCircularClick {
	public static WebDriver driver; // 新建一个WebDriver 的对象，但是new

	@Test(dataProvider = "auth", dataProviderClass = UserData.class)
	public void f(String username, String password) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");// chromedriver服务地址
		WebDriver driver = new ChromeDriver(); // 新建一个WebDriver 的对象，但是new
		driver.manage().window().maximize();//窗口最大化
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://39.98.238.23/#/serviceHome");// 打开指定的网站
		//点击工作站
		driver.findElement(By.cssSelector("ul[class~='el-menu-demo'] > li:last-child")).click();
		Thread.sleep(2000);
		LoginPage1 LoginPage1 = new LoginPage1(driver);
		LoginPage1.login(username, password);
		Thread.sleep(1000);
		//点击智造课堂，循环点击视频
		driver.findElement(By.id("/intellectualClassroom")).click();
		Thread.sleep(1000);
		for (int i=1;i<10000;i++){
			/*
			//要点击的关闭按钮
			WebElement close = driver.findElement(By.cssSelector("html body.el-popup-parent--hidden div#app div section.el-container.is-vertical section.el-container main.el-main div div.el-dialog__wrapper div.el-dialog div.el-dialog__header button.el-dialog__headerbtn i.el-dialog__close.el-icon.el-icon-close"));
			//掩盖的div元素
			WebElement ObscureDiv1 = driver.findElement(By.className("v_mainbg"));
			//使用显示等待，等待掩盖的div消失	  
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			wait1.until(ExpectedConditions.invisibilityOf(ObscureDiv1)); 
			//等待关闭按钮到可点击状态
			wait1.until(ExpectedConditions.elementToBeClickable(close));     	
			//之后再执行点击  
			close.click();
			
			//要点击的视频
			WebElement shipin = driver.findElement(By.className("v_mainbg"));
			//掩盖的div元素
			WebElement ObscureDiv = driver.findElement(By.className("el-loading-mask is-fullscreen el-loading-fade-enter el-loading-fade-enter-active"));
			//使用显示等待，等待掩盖的div消失
			WebDriverWait wait = new WebDriverWait(driver,1);
			wait.until(ExpectedConditions.invisibilityOf(ObscureDiv)); 
			//等待视频到可点击状态
			wait.until(ExpectedConditions.elementToBeClickable(shipin));     	
			//之后再执行点击  
			shipin.click();
			*/

			driver.findElement(By.className("v_mainbg")).click();
			Thread.sleep(500);
			driver.findElement(By.cssSelector("button[class='el-dialog__headerbtn']")).click();
			Thread.sleep(500);
		}
		driver.close();
		driver.quit();
	}

}