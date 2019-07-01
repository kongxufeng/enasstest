package com.enass.utils;

import com.enass.comm.Constants;
import com.enass.htyl.page.LoginPage1;
import com.enass.page.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


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
        //点击工作站
        HomePage homepage = new HomePage(driver);
        homepage.click_gzz_link();
        // 2、登录
        LoginPage1 LoginPage1 = new LoginPage1(driver);
        LoginPage1.login(username, password);
    }

    public void loginFaileAss() {
        // 1、打开首页
        driver.get(Constants.BasicURL);
        // 2、登录
        LoginPage1 LoginPage1 = new LoginPage1(driver);
        LoginPage1.loginFaileAss();
    }


}
