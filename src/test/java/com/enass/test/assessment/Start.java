package com.enass.test.assessment;

import static org.testng.Assert.assertEquals;
import java.util.Random;

import com.enass.page.Assessment;
import com.enass.page.HomePage;
import com.enass.page.UiLeft;
import com.enass.data.UserData;
import com.enass.utils.BaseTest;
import com.enass.utils.Longin;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class Start extends BaseTest {

	@Test(dataProvider = "pingguzhenduan", dataProviderClass = UserData.class)
	public void zhenduan(String username, String password,String flag,String except) throws Exception {
		//driver.get("http://39.98.238.23/#/serviceHome");// 打开指定的网站

		//登录
		Longin Longin = new Longin(driver);
		Longin.longin(username, password);

		//点击评估诊断-开始评估
		UiLeft uileft = new UiLeft(driver);
		uileft.click_kspg_link();
		Thread.sleep(1000);

		//判断预期成熟度等级
		//String flag ="3" ;
		String a = "nth-child(1)";//选择第一项
		String b = "last-child";//选择最后一项
		//String c = "贵公司已达到智能化一级成熟度";//预期评估结论
		switch(flag){//成熟度等级
		case "1"://1级
			a = "nth-child(1)";
			b = "last-child";
			//c = "贵公司已达到智能化一级成熟度，企业利用信息化技术进行业务数据的管理，部分核心业务具有一定信息化基础，部分设备的加工数据仍然通过手动传输，并未完全实现信息流与工作环节的关联。";
			break;
		case "2"://2级
			a = "nth-child(2)";
			b = "last-child";
			//c = "贵公司已达到智能化二级成熟度，利用管理系统进行各项业务的开展和管理，操作技术（OT）系统的各部分实现了连通性和互操作性，但是依旧未能达到IT层面和OT层面的完全整合。";
			break;
		case "3"://3级
			a = "last-child";
			b = "last-child";
			//c ="贵公司已达到智能化三级成熟度，企业核心业务间实现了集成，数据在企业范围内实现共享；基于传感器捕捉大量数据节点，实现工厂的最新数字模型，也就是“数字孪生”，并且以构建数字孪生为核心元素，使用工程知识对采集的数据进行分析并形成认识，挖掘事件发生原因。";
			break;
		case "4"://4级
			a = "last-child";
			b = "nth-child(1)";
			//c = "贵公司已达到智能化四级成熟度，达到预测能力阶段，进而实现持续适应能力。企业可以模拟不同的未来情景，并评估它们发生的可能性，确定最具可能性的情景。基于预测能力，实现持续的适应性，使企业能够向IT系统下放适当决策，以便IT系统尽快适应变化多端的经营环境。";
			break;
		
		}

		Random rand = new Random();
		int next1 = rand.nextInt(33)+1;//随机区域
		int next2 = rand.nextInt(30)+1;//随机行业

		//进行评估
		//1、企业概况与战略
		driver.findElement(By.cssSelector("input[placeholder='公司联系电话或邮箱']")).sendKeys("18630435218");//联系方式
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:nth-child(" + String.valueOf(next1) + ") > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:nth-child(" + String.valueOf(next2) + ") > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.6公司成立时间为多久？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.7公司制定的中长期（3-5年）数字化智能化战略规划实施状态如何？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(8) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.8公司近三年在自动化、智能化改造方面已投入的资金（含设备、技术及软件投资）为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(9) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.9公司主营的产品在所属行业中处于何种地位？
		driver.findElement(By.cssSelector("label.el-checkbox:" + b + " > span:nth-child(1)")).click();//1.10公司在哪些业务环节应用了信息化系统？(可多选)
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(11) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.11公司平均多久组织员工进行一次培训？
		Assessment next = new Assessment(driver);
		next.click_next_button();//下一页
		Thread.sleep(500);

		//2、研发设计相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.6公司成立时间为多久？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.7公司制定的中长期（3-5年）数字化智能化战略规划实施状态如何？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(8) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.8公司近三年在自动化、智能化改造方面已投入的资金（含设备、技术及软件投资）为多少？
		driver.findElement(By.cssSelector("label.el-checkbox:" + b + " > span:nth-child(1)")).click();//1.9公司主营的产品在所属行业中处于何种地位？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(10) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.10公司在哪些业务环节应用了信息化系统？(可多选)
		next.click_next_button();//下一页
		Thread.sleep(500);

		//3、生产管理相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.6公司成立时间为多久？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.7公司制定的中长期（3-5年）数字化智能化战略规划实施状态如何？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(8) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.8公司近三年在自动化、智能化改造方面已投入的资金（含设备、技术及软件投资）为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(9) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.9公司主营的产品在所属行业中处于何种地位？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(10) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.10公司在哪些业务环节应用了信息化系统？(可多选)
		next.click_next_button();//下一页
		Thread.sleep(500);

		//4、车间、产线及设备相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector("label.el-checkbox:" + b + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.6公司成立时间为多久？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.7公司制定的中长期（3-5年）数字化智能化战略规划实施状态如何？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(8) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.8公司近三年在自动化、智能化改造方面已投入的资金（含设备、技术及软件投资）为多少？
		next.click_next_button();//下一页
		Thread.sleep(500);

		//5、产品服务相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(6) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.6公司成立时间为多久？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(7) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.7公司制定的中长期（3-5年）数字化智能化战略规划实施状态如何？
		next.click_next_button();//下一页
		Thread.sleep(500);

		//6、企业经营管理相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + b + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector("label.el-checkbox:" + b + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？
		next.click_next_button();//下一页
		Thread.sleep(500);

		//7、供应链及物流配送相关
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.1贵公司属于哪个区域？？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.2贵公司属于何种行业类别？
		driver.findElement(By.cssSelector("label.el-checkbox:" + b + " > span:nth-child(1)")).click();//1.3公司属于何种企业规模？
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(4) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.4公司共有多少名员工
		driver.findElement(By.cssSelector(".el-main > div:nth-child(1) > div:nth-child(5) > ul:nth-child(1) > li:nth-child(5) > div:nth-child(2) > label:" + a + " > span:nth-child(1)")).click();//1.5公司年销售额为多少？

		//提交
		Assessment confirm = new Assessment(driver);
		confirm.click_auto_confirm();

		//断言
		Thread.sleep(2000);
		String actual = driver.findElement(By.cssSelector("div.assessR:nth-child(2) > p:nth-child(2)")).getText();

		assertEquals(actual,except);

	}

}
