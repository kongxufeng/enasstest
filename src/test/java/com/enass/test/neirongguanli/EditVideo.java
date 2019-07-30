package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.neirongguanli.PageVido;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class EditVideo extends BaseTest {

    //编辑视频测试
    @Test(dataProvider = "editvido", dataProviderClass = UserData.class)
    public void editviode(String username, String password,String biaoti ,String url ,String yunbi ,String shuoming) throws Exception{
        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击内容管理-学习中心管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_viode_link();
        Thread.sleep(1000);

        //点击编辑，输入信息后提交
        PageVido edit = new PageVido(driver);
        String except = edit.editinfo(biaoti,url,yunbi,shuoming);

        //断言
        Thread.sleep(1000);
        String act = driver.findElement(By.cssSelector("tr.el-table__row:nth-child(1) > td:nth-child(3) > div:nth-child(1)")).getText();
        assertEquals(act,except);

    }

}
