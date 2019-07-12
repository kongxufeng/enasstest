package com.enass.page.assessment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//未完成的评估
public class Unfinishe {

    WebDriver driver;

    /**
     * 继续评估按钮
     */
    @FindBy(css = ".el-main > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3)")
    private WebElement continue_btn;

    /**
     * 删除按钮
     */
    @FindBy(css = ".el-main > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(4)")
    private WebElement delete_btn;

    /**
     * 删除确认按钮
     */
    @FindBy(css = "body > div.el-message-box__wrapper > div > div.el-message-box__btns > button.el-button.el-button--default.el-button--small.el-button--primary")
    private WebElement delconfirm_btn;

    /**
     * 搜索输入框
     */
    @FindBy(className = "el-input__inner")
    private WebElement search_input;


    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public Unfinishe(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * 操作步骤，点击继续评估按钮
     */
    public void click_continue_btn() { continue_btn.click(); }

    /**
     * 操作步骤，点击删除按钮
     */
    public void click_delete_btn() { delete_btn.click(); }

    /**
     * 操作步骤，点击删除确认按钮
     */
    public void click_delconfirm_btn() { delconfirm_btn.click(); }

    /**
     * 操作步骤，点击删除确认按钮
     */
    public void sendKeys_search_input(String s) { search_input.sendKeys(); }

}
