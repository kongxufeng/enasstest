package com.enass.test.assessment;

import com.enass.data.UserData;
import com.enass.page.UiLeft;
import com.enass.page.assessment.Complete;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

//已完成的评估测试
public class Completed extends BaseTest {

    //查看报告测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void Report(String username, String password) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);

        //点击评估诊断-已完成的评估
        Thread.sleep(2000);
        UiLeft uileft = new UiLeft(driver);
        uileft.click_Completed_link();
        Thread.sleep(2000);

        //获取报告名称
        String except = driver.findElement(By.cssSelector("tr.el-table__row:nth-child(1) > td:nth-child(2) > div:nth-child(1)")).getText();

        //点击查看报告

        Complete report = new Complete(driver);
        report.click_report_btn();
        Thread.sleep(1000);

        //断言
        String act = driver.findElement(By.cssSelector(".addtop > p:nth-child(2)")).getText();
        assertEquals(act,except);

    }

    //查看详情测试
    @Test()
    public void Detail() throws Exception{

        //点击已完成的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_ywcdpg_link();
        Thread.sleep(2000);

        //点击查看详情
        Complete detail = new Complete(driver);
        detail.click_details_btn();
        Thread.sleep(2000);

        //断言
        String act = driver.findElement(By.className("headtitledes")).getText();
        assertEquals(act,"智能化水平评估");

    }

    //删除报告测试
    @Test()
    public void Delete() throws Exception{

        //点击已完成的评估
        UiLeft uileft = new UiLeft(driver);
        uileft.click_ywcdpg_link();
        Thread.sleep(2000);

        //获取要删除的报告诊断时间
        String  except = driver.findElement(By.cssSelector("tr.el-table__row:nth-child(1) > td:nth-child(6) > div:nth-child(1)")).getText();

        //点击删除报告
        Complete delete = new Complete(driver);
        delete.click_deleteconfirm_btn();
        Thread.sleep(1000);

        //断言删除成功提示框
        String  act = driver.findElement(By.className("el-message-box__message")).getText();
        assertEquals(act,"删除成功");

        //点击确认
        driver.findElement(By.cssSelector(".el-button--small")).click();

        //断言列表数据是否还存在
        String time = driver.findElement(By.cssSelector("tr.el-table__row:nth-child(1) > td:nth-child(6) > div:nth-child(1)")).getText();
        assertNotEquals(time,except);

    }

}
