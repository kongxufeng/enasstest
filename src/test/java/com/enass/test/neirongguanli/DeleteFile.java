package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.neirongguanli.PageFile;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DeleteFile {
    WebDriver driver;

    public DeleteFile(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //删除解决方案测试
    //@Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void deletefile() throws Exception{

        //登录
       // Longin Longin = new Longin(driver);
        //longin(username, password);

        //点击内容管理-解决方案管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_file_link();


        //获取预期标题
        Thread.sleep(1000);
        PageFile get = new PageFile(driver);
        String except = get.get_biaoti();

        //点击删除并确认
        Thread.sleep(1000);
        get.deleteinfo();

        //断言是否出现删除成功提示框
        //new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".el-message-box__message > p:nth-child(1)")));
        //String act =  driver.findElement(By.cssSelector(".el-message-box__message > p:nth-child(1)")).getText();
        //assertEquals(act,"删除成功");

        //确认删除成功
        //get.close_delete();

        //断言当前列表第一条数据标题是否与删除的标题一致
        Thread.sleep(1000);
        String biaoti = get.get_biaoti();
        assertNotEquals(biaoti,except);
        Thread.sleep(1000);

    }


}
