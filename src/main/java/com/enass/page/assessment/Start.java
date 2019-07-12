package com.enass.page.assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Start {
    WebDriver driver;

    /**
     * 1.企业概况与战略
     */
    //联系方式
    @FindBy(css = "input[placeholder='公司联系电话或邮箱']")
    private WebElement phone_input;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */

    public Start(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤1.企业概况与战略-输入联系方式
     */
    public void sendKeys_phone_input() {
        phone_input.sendKeys();
    }


}
