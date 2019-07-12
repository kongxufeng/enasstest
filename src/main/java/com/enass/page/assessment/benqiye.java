package com.enass.page.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class benqiye {

    WebDriver driver;

    /**
     * 查看报告按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(7) > div:nth-child(1) > button:nth-child(1)")
    private WebElement report_btn;

    /**
     * 查看详情按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(7) > div:nth-child(1) > button:nth-child(2)")
    private WebElement details_btn;


    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */

    public benqiye(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击查看报告按钮
     */
    public void click_report_btn() {
        report_btn.click();
    }

    /**
     * 操作步骤，点击查看详情按钮
     */
    public void click_details_btn() {
        details_btn.click();
    }

}
