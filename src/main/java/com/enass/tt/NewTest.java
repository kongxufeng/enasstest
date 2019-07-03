package com.enass.tt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {

		String chromePath = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.baidu.com");
		try {
			WebElement element = null; // 定义一个Web对象对象
			// element=driver.findElement(By.cssSelector(".s_ipt"));//CSS样式名称定位百度搜索输入框
			element = driver.findElement(By.cssSelector("#kw"));// CSSID定位百度搜索输入框
			element = driver.findElement(By.cssSelector("div,a"));// CSS定位所有div对象和a对象
			element = driver.findElement(By.cssSelector("div a"));// CSS定位div标签内所有的a对象
			element = driver.findElement(By.cssSelector("div>a"));// CSS定位父对象是div的所有a对象
			element = driver.findElement(By.cssSelector("div+a"));// CSS定位紧接在<div>
																	// 对象之后的所有<a>
																	// 对象
			element = driver.findElement(By.cssSelector("[target='_blank']"));// 选择target="_blank"
																				// 的所有对象。
			element = driver.findElement(By.cssSelector("a[name='tj_trnews'][class='mnav']"));// 定位A标签中name='tj_trnews'并且class='mnav'的对象
			element = driver.findElement(By.cssSelector("a[href^='http']"));// 选择a标签对象中href
																			// 属性值以"http"
																			// 开头的每个<a>
																			// 对象。
			element = driver.findElement(By.cssSelector("a[href$='.com']"));// 选择a标签对象中href属性值以".com"结尾的对象
			element = driver.findElement(By.cssSelector("a[href*='news']"));// 选择a标签对象中href属性值中包含news的对象
			element = driver.findElement(By.cssSelector("a:nth-last-child(2)"));// 选择属于其父对象的首个<a>
																				// 对象的每个<a>
																				// 对象。
			element = driver.findElement(By.cssSelector(
					"html body div#wrapper div#head div.head_wrapper div.s_form div.s_form_wrapper.soutu-env-nomac.soutu-env-index form#form.fm span.bg.s_ipt_wr.quickdelete-wrap input#kw.s_ipt"));// 通过css绝对路径定位
		} catch (Exception e) {
			System.out.println("定位失败");
		}
	}

}
