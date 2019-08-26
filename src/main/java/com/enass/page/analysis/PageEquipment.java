package com.enass.page.analysis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageEquipment {
    private WebDriver driver;

    /**
     * 添加按钮
     */
    @FindBy(id = "/statisticalAnalysisMenu")
    private WebElement add_btn;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public PageEquipment(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * 操作步骤，点击学习中心链接
     */
    public void click_xxzx_link() {

    }
}
