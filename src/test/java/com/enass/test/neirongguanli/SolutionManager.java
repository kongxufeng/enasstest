package com.enass.test.neirongguanli;

import com.enass.data.UserData;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.testng.annotations.Test;

//解决方案测试
public class SolutionManager extends BaseTest {

    //添加解决方案测试
    @Test(dataProvider = "auth", dataProviderClass = UserData.class)
    public void add(String username, String password ) throws Exception{

        //登录
        Longin Longin = new Longin(driver);
        Longin.longin(username, password);
        Thread.sleep(1000);

        //调用添加解决方案测试方法
        AddFile add = new AddFile(driver);
        add.addfile();
    }

    //编辑解决方案测试
    @Test()
    public void edit() throws Exception{

        EditFile edit = new EditFile(driver);
        edit.editfile();
    }

    //查询解决方案测试
    @Test()
    public void search() throws Exception{

        SearchFile search = new SearchFile(driver);
        search.searchfile();
    }

    //删除解决方案测试
    @Test()
    public void delete() throws Exception{
        DeleteFile delete = new DeleteFile(driver);
        delete.deletefile();

    }

}
