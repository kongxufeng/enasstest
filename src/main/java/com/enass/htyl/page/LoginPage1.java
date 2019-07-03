package com.enass.htyl.page;

import com.enass.ocr.ocr;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	private WebDriver driver;
	private Logger logger = LogManager.getLogger();

	boolean tag = true;
	@FindBy(id = "li0")
	WebElement phonelink;
	@FindBy(id = "shortAccount")
	WebElement name;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(css = "input[value='登 录']")
	WebElement longinbnt;
	@FindBy(id = "code0")
	WebElement tyyzm;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String name, String password) {
		int i = 0;
		while (tag && i < 20) {
			i++;
			//this.phonelink.click();
			this.name.sendKeys(name);
			logger.info("账户输入******************");
			this.password.sendKeys(password);
			logger.info("密码输入******************");
			//判断图片验证码是否存在
			if(tyyzm.isDisplayed())
			{
				logger.info("图片识别验证码******************");
				ocr.snapshotAndSave(driver);
				String yzm = ocr.ocrtest();
				yzm = yzm.replaceAll("[^a-zA-Z0-9]", "");
				this.tyyzm.sendKeys(yzm);
			}
			longinbnt.click();
			if(driver.getTitle().equals("企业上云服务站")) {
				tag = false;
			}
		}
	}

	public void loginFaileAss() {
		int i = 0;
		while (tag && i <50) {
			i++;
			this.phonelink.click();
			this.name.sendKeys("18612632139");
			//输入错误验证码
			this.password.sendKeys("12345678");
			//判断图片验证码是否存在
			if(tyyzm.isDisplayed())
			{
				ocr.snapshotAndSave(driver);
				String yzm = ocr.ocrtest();
				yzm = yzm.replaceAll("[^a-zA-Z0-9]", "");
				this.tyyzm.sendKeys(yzm);
			}
			longinbnt.click();
			String asstext = driver.findElement(By.className("errormessage")).getText();
			if(asstext.equals("登录失败次数过多，请30分钟后重试")) {
				tag = false;
			}

		}
	}
}
