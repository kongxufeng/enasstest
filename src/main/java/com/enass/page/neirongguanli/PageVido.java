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
     * 使用页面工程构造自己
     * @param driver 传入webdriver对象
     */
    public PageVido(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * 操作步骤，添加信息保存流程
     */
    public void addinfo() throws Exception{

        //点击添加按钮
        add_btn.click();
        //上传图片
        pic_btn.sendKeys("C:\\Users\\kongxufeng\\Pictures\\照片资料\\155375405148249666.jpeg");

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
        biaoti_input.sendKeys("测试添加视频"+format);
        //输入URL
        url_input.sendKeys("url");
        //输入所需云币
        yunbi_input.sendKeys("100");
        //输入文字说明
        shuoming_input.sendKeys("文字说明");
        //点击保存
        save_btn.click();

    }

    /**
     * 操作步骤，编辑信息保存流程
     */
    public void editinfo() throws Exception{

        //点击编辑按钮
        edit_btn.click();

        //选择权限

        //编辑标题
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd HHmmss");// 设置日期格式
        String format = time.format(new Date());// new Date()为获取当前系统时间

        biaoti_input.sendKeys("测试添加视频"+format);
        //编辑URL
        url_input.clear();
        url_input.sendKeys("url111");
        //编辑所需云币
        yunbi_input.clear();
        yunbi_input.sendKeys("100111");
        //编辑文字说明
        shuoming_input.clear();
        shuoming_input.sendKeys("文字说明111");
        //点击保存
        save_btn.click();

    }

}
