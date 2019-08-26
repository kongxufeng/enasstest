package com.enass.page.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Complete {
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
     * 删除按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(7) > div:nth-child(1) > button:nth-child(3)")
    private WebElement delete_btn;

    /**
     * 删除确认按钮
     */
    @FindBy(css = "button.el-button--small:nth-child(2)")
    private WebElement confirm_btn;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */

    public Complete(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击查看报告按钮
     */
    public void click_report_btn() {
        //new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(report_btn));
        report_btn.click();
    }

    /**
     * 操作步骤，点击查看详情按钮
     */
    public void click_details_btn() {
        details_btn.click();
    }

    /**
     * 操作步骤，点击删除报告按钮
     */
    public void click_delete_btn() { delete_btn.click(); }

    /**
     * 操作步骤，点击删除确认按钮
     */
    public void click_confirm_btn() { confirm_btn.click(); }

    /**
     * 操作步骤，点击删除确认流程
     */
    public void click_deleteconfirm_btn() throws InterruptedException{
        delete_btn.click();
        Thread.sleep(500);
        confirm_btn.click();
    }

}
