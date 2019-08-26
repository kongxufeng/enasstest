package com.enass.utils;

import com.enass.comm.Constants;
import com.enass.htyl.page.LoginPage1;
import com.enass.page.HomePage;
import com.enass.tt.Comm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class Longin {
    private Logger logger = LogManager.getLogger();
    private WebDriver driver;

    public Longin(WebDriver driver) {
        this.driver = driver;
    }

    public void longin(String username, String password) {
        // 1、打开首页
        driver.get(Constants.BasicURL);
        logger.info("url = **********" + Constants.BasicURL );

        //等待工作站元素出现
        Comm.wait_z(driver, By.cssSelector("#app > div > div.pageHead > div > div.page_footer > div > div:nth-child(5)"));
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //点击工作站
        HomePage homepage = new HomePage(driver);
        homepage.click_gzz_link();

        // 2、登录
        LoginPage1 LoginPage1 = new LoginPage1(driver);
        LoginPage1.login(username, password);
        //等待进入工作站，如果没进入，再次点击工作站

        try{
            Comm.wait_z(driver,By.cssSelector("#\\/enterprise\\.2 > li:nth-child(1) > span:nth-child(2)"));
        }catch (Exception e){
            homepage.click_gzz_link();
        }
    }

    public void loginFaileAss() {
        // 1、打开首页
        driver.get(Constants.BasicURL);
        // 2、登录
        LoginPage1 LoginPage1 = new LoginPage1(driver);
        LoginPage1.loginFaileAss();
    }


}
