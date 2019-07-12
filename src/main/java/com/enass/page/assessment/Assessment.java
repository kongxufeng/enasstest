package com.enass.page.assessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Assessment {
    WebDriver driver;

    /**
     * 下一页按钮
     */
    @FindBy(css = "button.el-button:nth-last-child(2)")

    private WebElement next_button;

    /**
     * 答完题弹窗中的提交按钮
     */
    @FindBy(css = ".el-message-box__btns> button:nth-child(2)")
    private WebElement submit_button;

    /**
     * 提交后的确认按钮
     */
    @FindBy(css = ".el-message-box__btns> button:nth-child(2)")
    private WebElement confirm_button;

    /**
     * 保存按钮
     */
    @FindBy(css = "button.el-button--default:nth-child(1)")
    private WebElement save_button;

    /**
     * 保存后的确认按钮
     */
    @FindBy(css = "button.el-button--small:nth-child(2)")
    private WebElement getConfirm_button;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public Assessment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击下一页按钮
     */
    public void click_next_button() {
        next_button.click();
    }

    /**
     * 操作步骤，点击答完题弹窗中的提交按钮
     */
    public void click_submit_button() {
        submit_button.click();
    }

    /**
     * 操作步骤，点击提交后的确认按钮
     */
    public void click_confirm_button() { confirm_button.click(); }

    /**
     * 操作步骤，点击保存按钮
     */
    public void click_save_button() { save_button.click(); }

    /**
     * 操作步骤，点击保存后的确认按钮
     */
    public void click_getConfirm_button() { getConfirm_button.click(); }

    /**
     * 操作步骤，答题后自动提交
     */
    public void click_auto_confirm() throws InterruptedException {
        submit_button.click();
        Thread.sleep(500);
        confirm_button.click();
    }

    /**
     * 操作步骤，答题后自动提交
     */
    public void click_auto_save() throws InterruptedException {
        save_button.click();
        Thread.sleep(500);
        getConfirm_button.click();
    }

}
