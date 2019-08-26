package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.neirongguanli.PageFile;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SearchFile {

    WebDriver driver;

    public SearchFile(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //搜索解决方案测试
    //@Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void searchfile() throws Exception{

        //登录
       // Longin Longin = new Longin(driver);
       // Longin.longin(username, password);

        //点击内容管理-解决方案管理
        //UiLeft uileft = new UiLeft(driver);
        //uileft.click_file_link();
        Thread.sleep(1000);

        //获取预期标题
        PageFile get = new PageFile(driver);
        String except = get.get_biaoti();

        //输入预期标题并点击搜索
        Thread.sleep(1000);
        get.searchinfo(except);

        //断言搜索结果显示的标题是否与预期标题一致
        String act = get.get_biaoti();
        assertEquals(act,except);
        Thread.sleep(1000);
    }


}
