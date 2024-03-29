package com.enass.page;


import com.enass.tt.Comm;
import org.openqa.selenium.By;
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
         * 未完成的评估链接
         */
        @FindBy(css = ".is-opened > ul:nth-child(2) > div:nth-child(2) > li:nth-child(1)")
        private WebElement wwcdpg_link;

        /**
         * 已完成的评估链接
         */
        @FindBy(css = ".is-opened > ul:nth-child(2) > div:nth-child(3) > li:nth-child(1)")
        private WebElement ywcdpg_link;

        /**
         * 本企业的评估链接
         */
        @FindBy(css = ".is-opened > ul:nth-child(2) > div:nth-child(4) > li:nth-child(1)")
        private WebElement bqydpg_link;

    /**
     * 内容管理链接
     */
    @FindBy(id = "#2")
    private WebElement nrgl_link;

        /**
         * 学习中心链接
         */
        @FindBy(id = "/learnManager")
        private WebElement xxzx_link;

        /**
         * 解决方案链接
         */
        @FindBy(id = "/solutionManager")
        private WebElement jjfa_link;

    /**
     * 统计分析
     */
    @FindBy(id = "/statisticalAnalysisMenu")
    private WebElement tongji_link;

    /**
     * 设备接入数据
     */
    @FindBy(id = "/navigationDetail")
    private WebElement shebei_link;

    /**
     * 实时统计
     */
    @FindBy(id = "/realtimeStatistics")
    private WebElement shishi_link;

    /**
     * 整体趋势
     */
    @FindBy(id = "/overallTrend")
    private WebElement zhengti_link;

    /**
     * 智造课堂
     */
    @FindBy(id = "/intellectualClassroom")
    private WebElement classroom_link;

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
     * 操作步骤，点击开始评估链接
     */
    public void click_kspg_link() {
        kspg_link.click();
    }

    /**
     * 操作步骤，点击未完成的评估链接
     */
    public void click_wwcdpg_link() { wwcdpg_link.click(); }

    /**
     * 操作步骤，点击已完成的评估链接
     */
    public void click_ywcdpg_link() { ywcdpg_link.click(); }

    /**
     * 操作步骤，点击本企业的评估链接
     */
    public void click_bqydpg_link() { bqydpg_link.click(); }

    /**
     * 操作步骤，点击评估诊断-开始评估链接
     */
    public void click_start_link() {
        pgzd_link.click();
        kspg_link.click();
    }

    /**
     * 操作步骤，点击评估诊断-未完成的评估链接
     */
    public void click_Unfinished_link() {
        pgzd_link.click();
        wwcdpg_link.click();
    }

    /**
     * 操作步骤，点击评估诊断-已完成的评估链接
     */
    public void click_Completed_link() {
        pgzd_link.click();
        ywcdpg_link.click();
    }

    /**
     * 操作步骤，点击评估诊断-本企业的评估链接
     */
    public void click_Benqiye_link() {
        pgzd_link.click();
        bqydpg_link.click();
    }

    /**
     * 操作步骤，点击内容管理链接
     */
    public void click_nrgl_link() {
        nrgl_link.click();
    }

    /**
     * 操作步骤，点击解决方案链接
     */
    public void click_jjfa_link() {

        jjfa_link.click();
    }

    /**
     * 操作步骤，点击学习中心链接
     */
    public void click_xxzx_link() {
        xxzx_link.click();
    }

    /**
     * 操作步骤，点击内容管理-学习中心链接
     */
    public void click_viode_link(){
        if (xxzx_link.isDisplayed()){
            xxzx_link.click();
        }else {
            nrgl_link.click();
            xxzx_link.click();
        }
    }

    /**
     * 操作步骤，点击内容管理-解决方案链接
     */
    public void click_file_link() {
        if (jjfa_link.isDisplayed()){
            jjfa_link.click();
        }else {
            nrgl_link.click();
            jjfa_link.click();
        }
    }

    /**
     * 操作步骤，点击统计分析-设备接入数据连接
     */
    public void click_shebei_link() {
        if (shebei_link.isDisplayed()){
            shebei_link.click();
        }else {
            tongji_link.click();
            shebei_link.click();
        }

    }

    /**
     * 操作步骤，点击统计分析-设备接入数据连接
     */
    public void click_shishi_link() {
        if (shishi_link.isDisplayed()){
            shishi_link.click();
        }else {
            tongji_link.click();
            shishi_link.click();
        }
    }

    /**
     * 操作步骤，点击统计分析-设备接入数据连接
     */
    public void click_zhengti_link() {
        if (zhengti_link.isDisplayed()){
            zhengti_link.click();
        }else {
            tongji_link.click();
            zhengti_link.click();
        }
    }

    /**
     * 操作步骤，点击智造课堂链接
     */
    public void click_classroom_link() {
        classroom_link.click();
    }

}
