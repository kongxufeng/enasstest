package com.enass.tt;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Demo1 {
	public static void main(String[] args) throws IOException {

		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:/Program Files (x86)/chromedriver.exe")).usingAnyFreePort().build();
		service.start();

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.quit();
		// 关闭 ChromeDriver 接口
		service.stop();
	}

}
