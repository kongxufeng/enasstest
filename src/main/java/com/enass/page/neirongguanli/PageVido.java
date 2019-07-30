package com.enass.page.neirongguanli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.util.Date;


public class PageVido {

    private WebDriver driver;

    /**
     * 添加按钮
     */
    @FindBy(css = "div.btn:nth-child(3) > a:nth-child(1)")
    private WebElement add_btn;

    /**
     * 编辑按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(6) > div:nth-child(1) > button:nth-child(1)")
    private WebElement edit_btn;

    /**
     * 搜索按钮
     */
    @FindBy(css = "a.search")
    private WebElement search_btn;

    /**
     * 删除按钮
     */
    @FindBy(css = "tr.el-table__row:nth-child(1) > td:nth-child(6) > div:nth-child(1) > button:nth-child(2)")
    private WebElement delete_btn;

    /**
     * 确认删除按钮
     */
    @FindBy(css = "button.el-button--small:nth-child(2)")
    private WebElement confirmdelete_btn;

    /**
     * 删除成功提示
     */
    @FindBy(css = ".el-message-box__message > p:nth-child(1)")
    private WebElement Delete_success;

    /**
     * 关闭删除成功提示按钮
     */
    @FindBy(xpath = "/html/body/div[3]/div/div[3]/button")
    private WebElement close_success;

    /**
     * 搜索输入框
     */
    @FindBy(css = ".rightView > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement search_input;

    /**
     * 上传图片按钮
     */
    @FindBy(className = "uploadClass")
    private WebElement pic_btn;

    /**
     * 选取文件按钮
     */
    @FindBy(css= ".video-btn")
    private WebElement video_btn;

    /**
     * 标题输入框
     */
    @FindBy(css= "#app > div > section > section > main > div > div.el-dialog__wrapper > div > div.el-dialog__body > form > div:nth-child(4) > div > div > input")
    private WebElement biaoti_input;

    /**
     * URL输入框
     */
    @FindBy(css = "#app > div > section > section > main > div > div.el-dialog__wrapper > div > div.el-dialog__body > form > div:nth-child(5) > div > div > input")
    private WebElement url_input;

    /**
     * 所需云币输入框
     */
    @FindBy(css = "#app > div > section > section > main > div > div.el-dialog__wrapper > div > div.el-dialog__body > form > div:nth-child(6) > div > div > input")
    private WebElement yunbi_input;

    /**
     * 文字说明输入框
     */
    @FindBy(css = "#app > div > section > section > main > div > div.el-dialog__wrapper > div > div.el-dialog__body > form > div:nth-child(7) > div > div > textarea")
    private WebElement shuoming_input;

    /**
     * 保存按钮
     */
    @FindBy(css = ".dialog-footer > button:nth-child(1)")
    private WebElement save_btn;

    /**
     * 上传视频成功提示
     */
    @FindBy(css= "body > div.el-message.el-message--success.el-message-fade-leave-active.el-message-fade-leave-to > p")
    private WebElement tishi_text;

    /**
     * 培训资源列表标题
     */
    @FindBy(css= "tr.el-table__row:nth-child(1) > td:nth-child(3) > div:nth-child(1)")
    private WebElement biaoti_text;


    /**
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public PageVido(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * 操作步骤，获取标题
     * @return
     */

    public String get_biaoti() throws Exception{
        String except = biaoti_text.getText();
        return except;
    }

    /**
     * 操作步骤，点击删除按钮
     */

    public void click_delete() throws Exception{
        delete_btn.click();
    }

    /**
     * 操作步骤，关闭删除成功提示
     */

    public void close_delete() throws Exception{
        close_success.click();
    }

    /**
     * 操作步骤，添加信息保存流程
     * @return
     */
    public String addinfo(String biaoti, String url, String yunbi, String shuoming) throws Exception{

        //点击添加按钮
        add_btn.click();
        //上传图片
        pic_btn.sendKeys("D:\\workspace\\com\\src\\test\\resources\\图片canvas [5].png");
        //上传视频
        try {
            video_btn.click();
            Thread.sleep(2000);
            //实现文件上传。通过Runtime的静态方法获取Runtime对象
            Runtime runtime = Runtime.getRuntime();
            //通过Runtime对象调用exe方法
           runtime.exec("src\\test\\resources\\ChromFileUpload.exe");

        }catch (Exception e){
            e.printStackTrace();
        }

        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(tishi_text));
        //选择权限

        //输入标题
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
        String format = df.format(new Date());// new Date()为获取当前系统时间
        String except = biaoti+format;
        biaoti_input.sendKeys(except);
        //输入URL
        url_input.sendKeys(url);
        //输入所需云币
        yunbi_input.sendKeys(yunbi);
        //输入文字说明
        shuoming_input.sendKeys(shuoming);
        //点击保存
        save_btn.click();
        return except;
    }

    /**
     * 操作步骤，编辑信息保存流程
     * @return
     */
    public String editinfo(String biaoti ,String url ,String yunbi ,String shuoming) throws Exception{

        //点击编辑按钮
        edit_btn.click();

        //选择权限

        //编辑标题
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd-HHmmss");// 设置日期格式
        String format = time.format(new Date());// new Date()为获取当前系统时间
        String expect = biaoti+format;
        biaoti_input.clear();
        biaoti_input.sendKeys(expect);

        //编辑URL
        url_input.clear();
        url_input.sendKeys(url);
        //编辑所需云币
        yunbi_input.clear();
        yunbi_input.sendKeys(yunbi);
        //编辑文字说明
        shuoming_input.clear();
        shuoming_input.sendKeys(shuoming);
        //点击保存
        save_btn.click();
        return expect;
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
        delete_btn.click();
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(confirmdelete_btn));
        confirmdelete_btn.click();
    }

}
