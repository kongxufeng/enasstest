package com.enass.test.assessment;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.assessment.Complete;
import com.enass.page.assessment.benqiye;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Benqiye extends BaseTest {

    //查看报告测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void Report(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击评估诊断-本企业的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_Benqiye_link();
        Thread.sleep(2000);

        //获取报告名称
        String except = driver.findElement(By.cssSelector("tr.el-table__row:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).getText();

        //点击查看报告
        benqiye report = new benqiye(driver);
        report.click_report_btn();
        Thread.sleep(1000);

        //断言
        String act = driver.findElement(By.cssSelector(".addtop > p:nth-child(2)")).getText();
        assertEquals(act,except);

    }

    //查看详情测试
    @Test()
    public void Detail() throws Exception{

        //点击本企业的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_bqydpg_link();
        Thread.sleep(2000);

        //点击查看详情
        benqiye detail = new benqiye(driver);
        detail.click_details_btn();
        Thread.sleep(1000);

        //断言
        String act = driver.findElement(By.className("headtitledes")).getText();
        assertEquals(act,"智能化水平评估");

    }

}
