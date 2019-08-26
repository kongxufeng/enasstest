package com.enass.test;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Classroom extends BaseTest {

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void checkvideo(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);
        Thread.sleep(1000);

        //点击智造课堂
        UiLeft room = new UiLeft(driver);
        room.click_classroom_link();

        //选择视频播放
        driver.findElement(By.cssSelector("div.v-main:nth-child(1) > div:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".el-dialog__body > div:nth-child(1)")).click();
        //断言播放成功

    }

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void viewsolution(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);
        Thread.sleep(1000);

        //点击智造课堂-解决方案
        UiLeft room = new UiLeft(driver);
        room.click_classroom_link();
        driver.findElement(By.cssSelector("a.learncenter:nth-child(2)")).click();
        //获取解决方案标题
        String expect = driver.findElement(By.cssSelector("#el-tooltip-999")).getText();
        //点击预览
        driver.findElement(By.cssSelector("div.s_main:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1)")).click();

        //获取预览的标题
        String act = driver.findElement(By.cssSelector("#title > span")).getText();
        boolean flag;
        if(act.contains(expect)){
            flag = true;
        }else {
            flag = false;
        }
        //断言
        assertTrue(flag);
    }

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void downloadsolution(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);
        Thread.sleep(1000);

        //点击智造课堂-解决方案

        //点击下载

        //断言下载成功

    }
}
