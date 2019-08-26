package com.enass.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 频道页
 */
public class HomePage {
    WebDriver driver;

    /**
     * 工作站链接
     */
    @FindBy(css = "#app > div > div.pageHead > div > div.page_footer > div > div:nth-child(5)")
    private WebElement gzz_link;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击工作站链接
     */
    public void click_gzz_link() {
        gzz_link.click();
    }

}
