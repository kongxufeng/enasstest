package com.enass.test.assessment;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.assessment.Unfinishe;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//未完成的评估测试
public class Unfinished extends BaseTest {

    //继续评估测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void Continue(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击评估诊断-未完成的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_Unfinished_link();
        Thread.sleep(1000);

        //点击继续评估
        Unfinishe Continue = new Unfinishe(driver);
        Continue.click_continue_btn();
        Thread.sleep(1000);

        //断言回显
        String act = driver.findElement(By.cssSelector("div.el-step:nth-child(1) > div:nth-child(2) > div:nth-child(1)")).getText();
        assertEquals(act,"1、企业概况与战略");

    }

    //查询评估测试
    @Test()
    public void Search() throws Exception{

        //点击未完成的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_wwcdpg_link();
        Thread.sleep(1000);

        //获取未完成的评估名称
        String except = driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).getText();

        //输入名称搜索
        Unfinishe search = new Unfinishe(driver);
        search.sendKeys_search_input(except);

        //断言搜索结果
        String act = driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).getText();
        assertEquals(act,except);

    }

    //删除评估测试
    @Test()
    public void Delete() throws Exception{

        //点击未完成的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_wwcdpg_link();
        Thread.sleep(1000);

        //点击删除评估
        Unfinishe delete = new Unfinishe(driver);
        delete.click_delete_btn();
        Thread.sleep(500);

        //点击删除确认按钮
        Unfinishe delconfirm = new Unfinishe(driver);
        delconfirm.click_delconfirm_btn();
        Thread.sleep(500);

        //断言是否出现删除成功提示
        String act = driver.findElement(By.cssSelector(".el-message__content")).getText();
        assertEquals(act,"删除成功");
    }




}
