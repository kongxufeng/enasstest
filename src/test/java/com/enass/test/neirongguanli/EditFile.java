package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.neirongguanli.PageFile;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class EditFile extends BaseTest {

    //编辑解决方案测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void editfile(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击内容管理-解决方案管理
        UiLeft uileft = new UiLeft(driver);
        uileft.click_file_link();
        Thread.sleep(1000);

        //点击编辑，输入信息后提交
        PageFile edit = new PageFile(driver);
        edit.editfile();

        //断言保存成功的提示
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".el-message__content")));
        String act = driver.findElement(By.cssSelector(".el-message__content")).getText();
        assertEquals(act,"操作成功");

    }


}
