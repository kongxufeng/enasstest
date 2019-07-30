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

public class SearchVideo extends BaseTest {

    //查询视频测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void searchviode(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击内容管理-学习中心管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_viode_link();
        Thread.sleep(1000);

        //获取标题
        PageVido get = new PageVido(driver);
        String except = get.get_biaoti();

        //输入获取的预期标题并点击搜索
        get.searchinfo(except);

        //断言搜索结果显示的标题与搜索的预期标题是否不一致
        Thread.sleep(1000);
        String act = get.get_biaoti();
        assertNotEquals(act,except);

    }

}
