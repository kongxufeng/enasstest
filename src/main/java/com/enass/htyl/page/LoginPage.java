package com.enass.htyl.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "shortAccount")
	WebElement name;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(css = "input[value='登 录']")
	WebElement longinbnt;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String name, String password) {
		this.name.sendKeys(name);
		this.password.sendKeys(password);
		longinbnt.click();
	}

	public void login2(String name, String password,String ocrResult) {
		driver.findElement(By.id("li1")).click();
		driver.findElement(By.id("orgSn")).sendKeys(name);
		driver.findElement(By.id("shortAccount_org")).sendKeys("system");
		driver.findElement(By.id("password_org")).sendKeys(password);
		driver.findElement(By.xpath("(//input[@value='登 录'])[2]")).click();

	}
	

}
