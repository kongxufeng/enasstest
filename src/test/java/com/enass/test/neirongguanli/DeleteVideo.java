package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.neirongguanli.PageVido;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DeleteVideo {
    WebDriver driver;

    public DeleteVideo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //删除视频测试
    //@Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void deleteviode() throws Exception{

        //登录
       // Longin Longin = new Longin(driver);
       // Longin.longin(username, password);

        //点击内容管理-学习中心管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_viode_link();
        Thread.sleep(1000);

        //获取标题
        PageVido get = new PageVido(driver);
        String except = get.get_biaoti();

        //点击删除并确认流程
        get.deleteinfo();

        //断言是否出现删除成功提示框
        Thread.sleep(1000);
        String act =  driver.findElement(By.cssSelector(".el-message__content")).getText();
        assertEquals(act,"操作成功");

        //确认删除成功
        get.close_delete();

        //断言列表删除的数据是否还存在
        String biaoti = get.get_biaoti();
        assertNotEquals(biaoti,except);
        Thread.sleep(1000);
    }

}
