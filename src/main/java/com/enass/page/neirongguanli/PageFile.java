package com.enass.page.neirongguanli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class PageFile {
    private WebDriver driver;

    /**
     * 添加按钮
     */
    @FindBy(css = "div.btn:nth-child(3) > a:nth-child(1)")
    private WebElement add_btn;

    /**
     * 编辑按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(7) > div:nth-child(1) > button:nth-child(1)")
    private WebElement edit_btn;

    /**
     * 删除按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(7) > div:nth-child(1) > button:nth-child(2)")
    private WebElement delete_btn;

    /**
     * 确认删除按钮
     */
    @FindBy(css = "button.el-button--small:nth-child(2)")
    private WebElement confirmdelete_btn;

    /**
     * 搜索标题输入框
     */
    @FindBy(css = ".rightView > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement search_input;

    /**
     * 搜索按钮
     */
    @FindBy(xpath = "//*[@id=\"app\"]/div/section/section/main/div/div[1]/div/div[4]/a")
    private WebElement search_btn;

    /**
     * 标题文本
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(3) > div:nth-child(1)")
    private WebElement biaoti_text;

    /**
     * 上传图片按钮
     */
    @FindBy(css = "div.el-form-item:nth-child(1) > div:nth-child(2) > span:nth-child(1) > input:nth-child(2)")
    private WebElement pic_btn;

    /**
     * 上传文件按钮
     */
    @FindBy(css = "#upload")
    private WebElement file_btn;

    /**
     * 标题输入框
     */
    @FindBy(css = "div.el-form-item:nth-child(4) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement biaoti_input;

    /**
     * 所需云币输入框
     */
    @FindBy(css = "div.el-form-item:nth-child(5) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
    private WebElement yunbi_input;

    /**
     * 描述输入框
     */
    @FindBy(css = ".el-textarea__inner")
    private WebElement miaoshu_input;

    /**
     * 保存按钮
     */
    @FindBy(css = ".dialog-footer > button:nth-child(1)")
    private WebElement save_btn;

    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public PageFile(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * 操作步骤，获取标题
     * @return
     */

    public String get_biaoti() throws Exception{
        //new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(biaoti_text));
        String except = biaoti_text.getText();
        return except;
    }

    /**
     * 操作步骤，点击添加解决方案流程
     */

    public void addfile() throws Exception{

        //点击添加按钮
        add_btn.click();
        //上传图片
        pic_btn.sendKeys("D:\\workspace\\com\\src\\test\\resources\\图片canvas [5].png");
        //上传文件
        file_btn.sendKeys("D:\\workspace\\com\\src\\test\\resources\\云路航天云网接口-设备数据v1.1(1)(1).docx");
        //标题
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
        String format = df.format(new Date());// new Date()为获取当前系统时间
        biaoti_input.sendKeys("添加解决方案测试"+format);
        //所需云币
        yunbi_input.sendKeys("100");
        //描述
        miaoshu_input.sendKeys("描述");
        //点击保存
        save_btn.click();

    }

    /**
     * 操作步骤，点击编辑解决方案流程
     */

    public void editfile() throws Exception{

        //点击编辑按钮
        edit_btn.click();
        //上传图片
        pic_btn.sendKeys("D:\\workspace\\com\\src\\test\\resources\\图片canvas [5].png");
        //上传文件
        file_btn.sendKeys("D:\\workspace\\com\\src\\test\\resources\\云路航天云网接口-设备数据v1.1(1)(1).docx");
        //标题
        biaoti_input.clear();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
        String format = df.format(new Date());// new Date()为获取当前系统时间
        biaoti_input.sendKeys("编辑解决方案测试111"+format);
        //所需云币
        yunbi_input.clear();
        yunbi_input.sendKeys("100111");
        //描述
        miaoshu_input.clear();
        miaoshu_input.sendKeys("描述111");
        //点击保存
        save_btn.click();
    }

    /**
     * 操作步骤，搜索标题流程
     */
    public void searchinfo(String except) throws Exception{

        //搜索框输入标题
        search_input.sendKeys(except);
        //点击搜索按钮
        search_btn.click();

    }

    /**
     * 操作步骤，删除流程
     */

    public void deleteinfo() throws Exception{
        //new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(delete_btn));
        delete_btn.click();
        Thread.sleep(1000);
        //new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(confirmdelete_btn));
        confirmdelete_btn.click();
    }

}
