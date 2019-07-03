package com.enass.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 左侧导航栏
 */
public class UiLeft {
    WebDriver driver;

    /**
     * 评估诊断链接
     */
    @FindBy(id = "/assessmentPage")
    private WebElement pgzd_link;

    /**
     * 开始评估链接
     */
    @FindBy(css = ".is-opened > ul:nth-child(2) > div:nth-child(1) > li:nth-child(1)")
    private WebElement kspg_link;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public UiLeft(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击评估诊断链接
     */
    public void click_pgzd_link() {
        pgzd_link.click();
    }

    /**
     * 操作步骤，点击评估诊断-开始评估链接
     */
    public void click_kspg_link() {
        pgzd_link.click();
        kspg_link.click();
    }

}
