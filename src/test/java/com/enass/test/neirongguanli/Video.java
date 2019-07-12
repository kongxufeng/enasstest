package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.assessment.Complete;
import com.enass.page.assessment.Unfinishe;
import com.enass.page.neirongguanli.PageVido;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Video extends BaseTest {

    //添加视频测试
    @Test(dataProvider = "auth1", dataProviderClass = UserData.class)
    public void addviode(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击内容管理-学习中心管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_viode__link();
        Thread.sleep(1000);

        //点击添加，输入信息后提交
        PageVido add = new PageVido(driver);
        add.addinfo();

        //断言
        String act = driver.findElement(By.cssSelector("#app > div > section > section > main > div > div:nth-child(2) > div > div.el-table__body-wrapper.is-scrolling-none > table > tbody > tr:nth-child(1) > td.el-table_2_column_13 > div")).getText();
        assertEquals(act,"测试添加视频");

    }

    //编辑视频测试
    @Test()
    public void editviode() throws Exception{

        //点击编辑，输入信息后提交
        PageVido edit = new PageVido(driver);
        edit.editinfo();

        //断言
        String act = driver.findElement(By.cssSelector("#app > div > section > section > main > div > div:nth-child(2) > div > div.el-table__body-wrapper.is-scrolling-none > table > tbody > tr:nth-child(1) > td.el-table_2_column_13 > div")).getText();
        assertEquals(act,"测试添加视频");

    }

}
