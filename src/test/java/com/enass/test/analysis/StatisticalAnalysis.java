package com.enass.test.analysis;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public  class  StatisticalAnalysis extends BaseTest {

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void checkEquipment(String username,String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击统计分析-设备接入数据
        UiLeft uileft = new UiLeft(driver);
        uileft.click_shebei_link();

        //获取入驻企业数
        Thread.sleep(5000);
        String orgcount = driver.findElement(By.id("org_count")).getText();
        //判断是否大于0

        Boolean flag = false;

        if (Integer.valueOf(orgcount) > 0 ){
             flag = true;
        }else {
             flag = false;
        }

        //断言
        assertTrue(flag);
        Thread.sleep(1000);
    }

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void checkshishi(String username,String password) throws Exception{

        //点击统计分析-实时统计
        UiLeft uileft = new UiLeft(driver);
        uileft.click_shishi_link();
        Thread.sleep(1000);

        //获取浏览次数
        String count = driver.findElement(By.cssSelector(".elmainh > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")).getText();

        //判断是否大于0
        Thread.sleep(5000);
        Boolean flag = false;

        if (Integer.valueOf(count) > 0 ){
            flag = true;
        }else {
            flag = false;
        }

        //断言
        assertTrue(flag);
        Thread.sleep(1000);
    }

    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void checkzhengti(String username,String password) throws Exception{

        //点击统计分析-整体趋势
        UiLeft uileft = new UiLeft(driver);
        uileft.click_zhengti_link();
        Thread.sleep(1000);

        //获取今天浏览次数
        String count = driver.findElement(By.cssSelector(".el-table--striped > div:nth-child(3) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).getText();

        //判断是否大于0
        Thread.sleep(5000);
        Boolean flag = false;

        if (Integer.valueOf(count) > 0 ){
            flag = true;
        }else {
            flag = false;
        }
        //断言
        assertTrue(flag);
        Thread.sleep(1000);
    }
}
