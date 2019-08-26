package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;

import org.testng.annotations.Test;

//学习中心测试
public class learnManager extends BaseTest {

    //添加视频测试
    @Test(dataProvider = "addvido", dataProviderClass = UserData.class)
    public void add(String username, String password ,String biaoti ,String url ,String yunbi ,String shuoming) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);
        Thread.sleep(1000);

        //调用添加视频测试方法
        AddVideo add = new AddVideo(driver);
        add.addviode(biaoti ,url ,yunbi ,shuoming);
    }

    //编辑视频测试
    @Test(dataProvider = "editvido", dataProviderClass = UserData.class)
    public void edit(String username ,String password ,String biaoti ,String url ,String yunbi ,String shuoming) throws Exception{

        EditVideo edit = new EditVideo(driver);
        edit.editviode(biaoti ,url ,yunbi ,shuoming);
    }

    //查询视频测试
    @Test()
    public void search() throws Exception{

        SearchVideo search = new SearchVideo(driver);
        search.searchviode();
    }

    //删除视频测试
    @Test()
    public void delete() throws Exception{
        DeleteVideo delete = new DeleteVideo(driver);
        delete.deleteviode();

    }

}
