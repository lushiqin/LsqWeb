package seleniumJava;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class merge {
	
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SimpleDateFormat df1 = new SimpleDateFormat("MMddHHmmss");
	String time = df1.format(new Date());
	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	String date = df2.format(new Date());
	SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date1 = df3.format(new Date());
	SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String date2 = df4.format(new Date());
	Random random = new Random();
	String name = "测试-Lsq:";
	@Before
	public void before(){
		driver.manage().window().maximize();
	}
	
	@Test
	public void All() throws Exception{
		后台系统();
		Thread.sleep(1000);
		学员中心();
		Thread.sleep(1000);
		运营审核();
		Thread.sleep(1000);
		公客中心();
	}
	
	public  void 后台系统() throws InterruptedException{
		// WebDriver driver = new EdgeDriver();
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement vcode = driver.findElement(By.id("vcode"));
		WebElement submit = driver.findElement(By.id("submit"));
		username.sendKeys("ksadmin");
		password.sendKeys("ksadmin123");
		vcode.sendKeys("1233");
		submit.click();
		
		Thread.sleep(2000);

		WebElement 运营试卷 = driver.findElement(By.xpath("//*[@id='side-menu']/li[5]/a"));
		运营试卷.click();
		Thread.sleep(1000);
		/**
		 * 添加标签
		 */
		 WebElement 标签 = driver.findElement(By.cssSelector("#side-menu >li.active > ul > li:nth-child(1) > a"));
		 标签.click();
		 driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main> iframe:nth-child(2)")));
		 WebElement 添加标签 = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(2) > div > a"));
		 添加标签.click();
		 Thread.sleep(2000);
		 WebElement 标签名称 = driver.findElement(By.cssSelector("#signupForm >div:nth-child(2) > div > input"));
		 标签名称.sendKeys(name+date1);
		 WebElement 标签确认 = driver.findElement(By.cssSelector("#signupForm >div:nth-child(3) > div > button"));
		 标签确认.click();
		 driver.switchTo().defaultContent();
		
		/**
		 * 添加题本
		 */
		 WebElement 题本 = driver.findElement(By.cssSelector("#side-menu >li.active > ul > li:nth-child(2) > a"));
		 题本.click();
		 driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[3]")));
		 WebElement 添加题本 = driver.findElement(By.cssSelector("#bodymain > div> div > div > div > div.ibox-content > div:nth-child(2) > div > a"));
		 添加题本.click();
		 WebElement 题本标题 = driver.findElement(By.cssSelector("#signupForm >div:nth-child(2) > div > input"));
		 题本标题.sendKeys(name+date1);
		 WebElement 新增材料 = driver.findElement(By.cssSelector("#signupForm >div:nth-child(4) > div > a"));
		 String clnr = "    1.材料六的内容材料六的内容材料六的内容材料六的内容材料六的内容材料六的内容材料六的内容材料六的内容材料六的内容。\n2.材料六的内容。";
		 for (int i = 1; i < 7; i++) {
			 新增材料.click();
			 Thread.sleep(500);		
			 WebElement 材料标题1 = driver.findElement(By.cssSelector("#cailiao > div:nth-child("+i+") > div:nth-child(1) > input"));
			 材料标题1.sendKeys("材料"+i+"-"+date1);
			 driver.switchTo().frame(driver.findElement(By.cssSelector("#cailiao > div:nth-child("+i+") > div:nth-child(2) > div > div.ke-edit > iframe")));
			 WebElement 材料内容1 = driver.findElement(By.cssSelector("body"));
			 材料内容1.sendKeys(clnr);
			 driver.switchTo().parentFrame();		 
		 }
			
		 WebElement 确认题本 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(5) > div > input.btn_b.a.btn.btn-primary"));
		 确认题本.click();
		 driver.switchTo().defaultContent();
		
		/**
		 * 添加题目
		 */
		WebElement 题目 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(3) > a"));
		题目.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(4)")));
		for (int i = 0; i < 5; i++) {
			Thread.sleep(3000);
			WebElement 添加题目 = driver.findElement(By.cssSelector(
					"#bodymain > div > div.row > div > div > div.ibox-content > div:nth-child(2) > div > a"));
			添加题目.click();
			Select 题目类型 = new Select(
					driver.findElement(By.cssSelector("#signupForm > div:nth-child(2) > div > select")));
			WebElement 题目名称 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(3) > div > input"));

			driver.switchTo().frame(driver
					.findElement(By.cssSelector("#signupForm > div:nth-child(5) > div > div > div.ke-edit > iframe")));
			WebElement 题目内容 = driver.findElement(By.cssSelector("body"));
			题目内容.sendKeys(name + date1);
			driver.switchTo().parentFrame();

			WebElement 字数限制 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > input"));
			字数限制.sendKeys("200");
			WebElement 阅卷标准 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(7) > div > textarea"));
			阅卷标准.sendKeys("阅卷标准" + date1);
			WebElement 诊断结论 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(8) > div > textarea"));
			诊断结论.sendKeys("诊断结论" + date1);
			WebElement 总分 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(9) > div > input"));

			switch (i) {
			case 0:
				题目类型.selectByIndex(0);
				题目名称.sendKeys(name+"概括题" + date1);
				WebElement 题目序号0 = driver.findElement(
						By.cssSelector("#signupForm > div:nth-child(4) > div > input[type='checkbox']:nth-child(1)"));
				题目序号0.click();
				总分.sendKeys("10");
				break;
			case 1:
				题目类型.selectByIndex(1);
				题目名称.sendKeys(name+"应用题" + date1);
				WebElement 题目序号1 = driver.findElement(
						By.cssSelector("#signupForm > div:nth-child(4) > div > input[type='checkbox']:nth-child(2)"));
				题目序号1.click();
				总分.sendKeys("20");
				break;
			case 2:
				题目类型.selectByIndex(2);
				题目名称.sendKeys(name+"分析题" + date1);
				WebElement 题目序号2 = driver.findElement(
						By.cssSelector("#signupForm > div:nth-child(4) > div > input[type='checkbox']:nth-child(3)"));
				题目序号2.click();
				总分.sendKeys("30");
				break;
			case 3:
				题目类型.selectByIndex(3);
				题目名称.sendKeys(name+"对策题" + date1);
				WebElement 题目序号3 = driver.findElement(
						By.cssSelector("#signupForm > div:nth-child(4) > div > input[type='checkbox']:nth-child(4)"));
				题目序号3.click();
				总分.sendKeys("20");
				break;
			default:
				题目类型.selectByIndex(4);
				题目名称.sendKeys(name+"作文题" + date1);
				WebElement 题目序号4 = driver.findElement(
						By.cssSelector("#signupForm > div:nth-child(4) > div > input[type='checkbox']:nth-child(5)"));
				题目序号4.click();
				总分.sendKeys("40");
				break;
			}

			WebElement 新增阅卷要点1 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(11) > div > a"));
			新增阅卷要点1.click();
			WebElement 阅卷要点1 = driver.findElement(
					By.cssSelector("#signupForm > div:nth-child(10) > div > div > div:nth-child(2) > div > textarea"));
			阅卷要点1.sendKeys("要点一 " + date1);
			WebElement 给分上限1 = driver.findElement(
					By.cssSelector("#signupForm > div:nth-child(10) > div > div > div:nth-child(4) > div > input"));
			给分上限1.sendKeys("20");
			//要点1
			WebElement 要点组合1 = driver.findElement(
					By.cssSelector("#signupForm > div:nth-child(10) > div > div > div:nth-child(7) > div > div > a"));
			要点组合1.click();
			Select 能力1 = new Select(driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(1) > div > div.col-sm-7 > div > select")));
			能力1.selectByIndex(5);
			WebElement 组合得分1 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(1) > div > div.col-sm-5 > div > input"));
			组合得分1.sendKeys("10");
			WebElement 诊断选项1 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(3) > div > button"));
			诊断选项1.click();
			WebElement 选项内容1 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(2) > div > div > div.col-sm-6 > div > input"));
			WebElement 选项得分1 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(2) > div > div > div.col-sm-4 > div > input"));
			选项内容1.sendKeys("选项内容1" + date1);
			选项得分1.sendKeys("5");
			诊断选项1.click();
			WebElement 选项内容12 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(2) > div > div:nth-child(2) > div.col-sm-6 > div > input"));
			WebElement 选项得分12 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div > div.panel-body.clearfix > div:nth-child(2) > div > div:nth-child(2) > div.col-sm-4 > div > input"));
			选项内容12.sendKeys("选项内容2" + date1);
			选项得分12.sendKeys("5");
			//要点2
			WebElement 要点组合2 = driver.findElement(
					By.cssSelector("#signupForm > div:nth-child(10) > div > div > div:nth-child(7) > div > div > a"));
			要点组合2.click();
			Select 能力2 = new Select(driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(1) > div > div.col-sm-7 > div > select")));
			能力2.selectByIndex(2);
			WebElement 组合得分2 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(1) > div > div.col-sm-5 > div > input"));
			组合得分2.sendKeys("10");
			WebElement 诊断选项2 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(3) > div > button"));
			诊断选项2.click();
			WebElement 选项内容2 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(2) > div > div > div.col-sm-6 > div > input"));
			WebElement 选项得分2 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(2) > div > div > div.col-sm-4 > div > input"));
			选项内容2.sendKeys("选项内容21" + date1);
			选项得分2.sendKeys("5");
			诊断选项2.click();
			WebElement 选项内容22 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(2) > div > div:nth-child(2) > div.col-sm-6 > div > input"));
			WebElement 选项得分22 = driver.findElement(By.cssSelector(
					"#signupForm > div:nth-child(10) > div > div > div:nth-child(6) > div > div:nth-child(2) > div.panel-body.clearfix > div:nth-child(2) > div > div:nth-child(2) > div.col-sm-4 > div > input"));
			选项内容22.sendKeys("选项内容22" + date1);
			选项得分22.sendKeys("5");

			WebElement 确认题目 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(13) > div > button"));
			确认题目.click();
		}
		driver.switchTo().defaultContent();
		
		/**
		 * 添加视频
		 */
		WebElement  视频 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(4) > a"));
		视频.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(5)")));
		WebElement 添加视频  = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(2) > div > a > span"));
		添加视频.click();
		WebElement 视频标题 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(4) > div > input"));
		WebElement 视频简介 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(5) > div > textarea"));
		WebElement 视频地址 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > input"));
		WebElement 视频开始时间 = driver.findElement(By.cssSelector("#signupForm > div.vedio_live_div > div:nth-child(1) > div > input"));
		WebElement 视频结束时间 = driver.findElement(By.cssSelector("#signupForm > div.vedio_live_div > div:nth-child(2) > div > input"));
		视频标题.sendKeys("视频标题"+date2);
		视频简介.sendKeys("视频简介"+date2);
		视频地址.sendKeys("视频地址"+date2);
		视频开始时间.click();
		WebElement 开始时间 = driver.findElement(By.cssSelector("body > div:nth-child(4) > div.datetimepicker-days > table > tbody > tr:nth-child(3) > td:nth-child(3)"));
		开始时间.click();	
		WebElement 开始时间1 = driver.findElement(By.cssSelector("body > div:nth-child(4) > div.datetimepicker-hours > table > tbody > tr > td > span:nth-child(18)"));
		开始时间1.click();
		WebElement 开始时间2 = driver.findElement(By.cssSelector("body > div:nth-child(4) > div.datetimepicker-minutes > table > tbody > tr > td > span:nth-child(12)"));
		开始时间2.click();
		视频结束时间.click();
		WebElement 结束时间 = driver.findElement(By.cssSelector("body > div:nth-child(5) > div.datetimepicker-days > table > tbody > tr:nth-child(6) > td:nth-child(6)"));
		结束时间.click();
		WebElement 结束时间1 = driver.findElement(By.cssSelector("body > div:nth-child(5) > div.datetimepicker-hours > table > tbody > tr > td > span:nth-child(24)"));
		结束时间1.click();
		WebElement 结束时间2 = driver.findElement(By.cssSelector("body > div:nth-child(5) > div.datetimepicker-minutes > table > tbody > tr > td > span:nth-child(11)"));
		结束时间2.click();
		WebElement 确认视频 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(9) > div > button"));
		确认视频.click();
		driver.switchTo().defaultContent();
		
		
		WebElement 试卷 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(5) > a"));
		试卷.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(6)")));
		WebElement 添加试卷 = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div:nth-child(1) > a > span"));
		添加试卷.click();
		WebElement 试卷名称  = driver.findElement(By.cssSelector("#signupForm > div:nth-child(2) > div > input"));
		试卷名称.sendKeys(name+date2);
		WebElement 试卷标签 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(7) > div > div > a > span"));
		试卷标签.click();
		List<WebElement> 试卷标签内容 = driver.findElements(By.cssSelector("#signupForm > div:nth-child(7) > div > div > div > ul>li"));
//		试卷标签内容.get(试卷标签内容.size()-1).click();
		试卷标签内容.get(0).click();
		WebElement 考试类型 = driver.findElement(By.cssSelector("#signupForm > div.form-group.exam_type > div > div > label:nth-child(2) > input[type='checkbox']"));
		考试类型.click();
		List<WebElement> 试卷题本 = driver.findElements(By.cssSelector("#signupForm > div:nth-child(9) > div > select > option"));
		试卷题本.get(试卷题本.size()-1).click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#signupForm > div:nth-child(10) > div > div > div.ke-edit > iframe")));
		WebElement 试卷注意事项 = driver.findElement(By.cssSelector("body"));
		试卷注意事项.sendKeys("1.试卷注意事项1。\n2.试卷注意事项2。");
		driver.switchTo().parentFrame();
		WebElement 新增试卷题目 = driver.findElement(By.cssSelector("#signupForm > div.row > div:nth-child(4) > div > a"));
		for (int i = 0; i < 4; i++) {
			Thread.sleep(1000);
			新增试卷题目.click();
		}
		WebElement 自动接单数量 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(19) > div.col-sm-2 > input"));
		自动接单数量.sendKeys("20");
		WebElement 自动接单状态 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(20) > div > label:nth-child(1)"));
		自动接单状态.click();
		WebElement 确认试卷 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(22) > div > button"));
		确认试卷.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		WebElement 产品销售 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(4) > a"));
		产品销售.click();
		
		WebElement 套餐管理 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(1) > a"));
		套餐管理.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(7)")));
		WebElement 添加套餐 = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div > a > span"));
		添加套餐.click();
		WebElement 套餐名称 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(2) > div > input"));
		套餐名称.sendKeys(name+"套餐"+date2);
		WebElement 套餐描述 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(3) > div > textarea"));
		套餐描述.sendKeys("套餐描述");
		for (int i = 0; i < 11; i++) {
			WebElement 套餐添加试卷 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(8) > div > a"));
			套餐添加试卷.click();
			Thread.sleep(1000);
		}
		int j=1;
		for ( j = 0; j < 11; j++) {
			int i = j+1;
			System.out.println("j = "+ j+"  ;  i = "+i);
			Select 套餐批改类型  = new Select(driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/div["+i+"]/div[2]/div/select")));
			套餐批改类型.selectByIndex(j);
			WebElement 套餐试卷标签 = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/div["+i+"]/div[4]/div/div/a/span"));
			套餐试卷标签.click();
//			List<WebElement> 套餐试卷标签1 = driver.findElements(By.xpath("//*[@id='signupForm']/div[6]/div/div["+i+"]/div[4]/div/div/div/ul/li"));
//			Thread.sleep(1000);
//			套餐试卷标签1.get(0).click();
			WebElement 套餐排序 = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/div["+i+"]/div[5]/div/input"));
			套餐排序.sendKeys(""+i+"");
			Thread.sleep(1000);
		}
		WebElement 确认套餐 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(16) > div > button"));
		确认套餐.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		WebElement 订单管理 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(2) > a"));
		订单管理.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(8)")));
		WebElement 添加订单 = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div > a:nth-child(1) > span"));
		添加订单.click();
		WebElement 电话号码 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(1) > div > input"));
		电话号码.sendKeys("15012931651");
		Select 短信模板 = new Select(driver.findElement(By.xpath("//*[@id='signupForm']/div[3]/div/select")));
		短信模板.selectByIndex(1);
		WebElement 订单号码 = driver.findElement(By.name("order_id"));
		订单号码.sendKeys(date);
		WebElement 确认订单 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > button"));
		确认订单.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
	}
	
	public void 学员中心() throws InterruptedException, IOException{
		driver.get("http://examtest.newgs.net/index.php/Ewap/StudIndex/login");
		WebElement 账号 = driver.findElement(By.xpath("//*[@id='login']/div[1]/div[2]/input"));
		WebElement 密码 = driver.findElement(By.xpath("//*[@id='login']/div[2]/div[2]/input"));
		账号.clear();
		密码.clear();
		账号.sendKeys("15012931651");
		密码.sendKeys("测试");
		WebElement 登陆 = driver.findElement(By.xpath("//*[@id='login']/div[3]/button"));
		登陆.click();
		
		Thread.sleep(2000);

		WebElement 进入套餐列表 = driver.findElement(By.xpath("//*[@id='stud_module']/div/div[1]/a"));
		进入套餐列表.click();
		Thread.sleep(1000);
		WebElement 选择套餐 = driver.findElement(By.xpath("//*[@id='order_list']/div/div[2]/a[1]/div"));
		选择套餐.click();
		//选择考试类型
		try {
			WebElement 考试类型 = driver.findElement(By.xpath("//*[@id='accordion']/div[2]/label[1]"));
			考试类型.click();
			Thread.sleep(1000);
			WebElement 确认选择 = driver.findElement(By.id("confirm_yes"));
			确认选择.click();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("失败");
		}
		//作答
		List<WebElement> 未答题数量 = driver.findElements(By.cssSelector("a[class = 'weui_btn weui_btn_mini btn_op_red  ']"));
		int sjsl = 未答题数量.size();
		for (int i = 0; i < sjsl; i++) {
			//提交答案
			List<WebElement> 未答题数量2 = driver.findElements(By.cssSelector("a[class = 'weui_btn weui_btn_mini btn_op_red  ']"));
			String text = 未答题数量2.get(0).getText();
			if (text.equals("提交答卷")) {
				Thread.sleep(1000);
				未答题数量2.get(0).click();
				Thread.sleep(200);
				List<WebElement> 答案 = driver.findElements(By.name("file"));
				int len = 答案.size();
				int j = 0;
				for (int k = 0; k < len ; k++) {
					j++;
					WebElement 选择图片 = driver.findElement(By.xpath("//*[@id='in_sub_da']/form[1]/div["+j+"]/div[2]/div/a"));
					选择图片.click();
					Thread.sleep(100);
					Runtime.getRuntime().exec("C:/Lsq/autolt.exe");
					Thread.sleep(2000);
					Thread.sleep(500);
					答案.get(k).sendKeys("C:\\Users\\陆石勤\\Desktop\\img\\"+k+".jpg");
					Thread.sleep(1000);
				}
				Thread.sleep(3000);
				WebElement 提交图片 = driver.findElement(By.id("do_sub_imgs"));
				提交图片.click();	
				Thread.sleep(3000);
				WebElement 返回 = driver.findElement(By.className("bk_click"));
				返回.click();
			} else {
				System.err.println("已经提交答案");
			}
		}
	}
	
	public void 公客中心() throws Exception{
		driver.get("http://examtest.newgs.net/gkwap.php/GoogkerApi/WapGongker/login");
		WebElement 登陆账号 = driver.findElement(By.cssSelector("#mobile"));
		WebElement 登陆密码 = driver.findElement(By.cssSelector("#pass"));
		WebElement 确认登陆 = driver.findElement(By.cssSelector("#login > div > div.fill_con.center-block > a"));
		登陆账号.clear();
		登陆账号.sendKeys("13457718147");
		登陆密码.clear();
		登陆密码.sendKeys("123456");
		确认登陆.click();
		Thread.sleep(2000);
		接单();
	
	}
	public void 接单() throws Exception{
		Thread.sleep(2000);
		List<WebElement> num = driver.findElements(By.cssSelector(".btn.btn-danger.a_cor"));
		for (int i = 0; i < num.size(); i++) {
			num.get(i).click();
			try {
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			try {
				WebElement 接受任务 = driver.findElement(By.cssSelector("#main > table > tbody > tr > td.col-md-10 > div > div > div.btn_div > button.btn.btn-info.btn_accept_task"));
				接受任务.click();
				Thread.sleep(3000);
				WebElement 确认接受 = driver.findElement(By.cssSelector("body > div.modal.fade.my_modal.in > div > div > div.modal-body > button.btn.btn-danger.do_accept_task"));
				确认接受.click();
				批改类型();
			} catch (Exception e) {
				批改类型();
			}
		}
	}
	
	/**
	 * 判断批改类型
	 * @throws Exception 
	 */
	public void 批改类型() throws Exception{
		Thread.sleep(2000);
		WebElement 批改类型 = driver.findElement(By.xpath("html/body/div[1]/div[3]/table/tbody/tr/td[1]/div[2]/div[2]/p[1]"));
		String name = 批改类型.getText();
		if (name.contains("精细诊断")) {
			System.out.println("精细诊断任务");
			List<WebElement> num = driver.findElements(By.className("text-left"));
			num.remove(0);
			for (int i = 0; i < num.size(); i++) {
				List<WebElement> num1 = driver.findElements(By.className("text-left"));
				num1.remove(0);
				String text = num1.get(i).getText();
				String t1 = text.replace(" ", "");
				if (num1.get(i).isEnabled()) {
					num1.get(i).click();
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("no alert");
					}
					Thread.sleep(1000);
					if (t1.endsWith("题")) {
						if (t1.startsWith("已完成")) {
							continue;
						} else {
							WebElement h5 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[1]/p"));
							String bb = h5.getText().substring(2);
							switch (bb) {
							case "要点诊断":
								精细普通题();
								break;
							case "标题诊断":
								精细作文题();
								break;
							}
						}
					} else if(t1.endsWith("综合点评")){
						try {
							本卷综合评估();
						} catch (Exception e) {
							i =0;
							continue;
						}
					}else {
						try {
							诊断报告();	
							} catch (Exception e) {
						}
					}
				} 
			}
			
		} else if(name.contains("标准批改")){
			System.out.println("精细诊断任务");
			List<WebElement> num = driver.findElements(By.className("text-left"));
			num.remove(0);
			for (int i = 0; i < num.size(); i++) {
				List<WebElement> num1 = driver.findElements(By.className("text-left"));
				num1.remove(0);
				String text = num1.get(i).getText();
				String t1 = text.replace(" ", "");
				if (num1.get(i).isEnabled()) {
					num1.get(i).click();
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("no alert");
					}
					Thread.sleep(1000);
					if (t1.endsWith("题")) {
						if (t1.startsWith("已完成")) {
							continue;
						} else {
							WebElement h5 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[2]/h5/strong"));
							String bb = h5.getText().substring(2);
							switch (bb) {
							case "各要点诊断":
								标准普通题();
								break;
							case "审题与中心论点诊断":
								标准作文题();
								break;
							}
						}
					} else if(t1.endsWith("综合点评")){
						try {
							本卷综合评估();
						} catch (Exception e) {
							i =0;
							continue;
						}
					}else if(t1.endsWith("诊断报告")){
						诊断报告();	
					}else {
						System.out.println("........");
					}
					
				} else {
					System.out.println("上一步批改未完成");
				}
			}
			
		}else {
			System.out.println("能力诊断任务");
			List<WebElement> num = driver.findElements(By.className("text-left"));
			num.remove(0);
			for (int i = 0; i < num.size(); i++) {
				List<WebElement> num1 = driver.findElements(By.className("text-left"));
				num1.remove(0);
				String text = num1.get(i).getText();
				String t1 = text.replace(" ", "");
				if (num1.get(i).isEnabled()) {
					num1.get(i).click();
					try {
						driver.switchTo().alert().accept();
					} catch (Exception e) {
						System.out.println("no alert");
					}
					Thread.sleep(1000);
					if (t1.endsWith("题")) {
						if (t1.startsWith("已完成")) {
							continue;
						} else {
							WebElement h5 = driver.findElement(By.cssSelector(".correct_point>h5>strong"));
							String bb = h5.getText().substring(2);
							switch (bb) {
							case "各要点诊断":
								能力普通题();
								break;
							case "文章综合诊断":
								能力作文题();
								break;
							}
						}
					} else if(t1.endsWith("综合点评")){
						try {
							本卷综合评估();
						} catch (Exception e) {
							i =0;
							continue;
						}
					}else if(t1.endsWith("诊断报告")){

						诊断报告();	
					
					}else {
						System.out.println("........");
					}
					
				} else {
					System.out.println("上一步批改未完成");
				}
			}
		}
	}
	
	public void 能力普通题() throws Exception{
		xzda();
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		Thread.sleep(1000);
		List<WebElement> num = driver.findElements(By.xpath("//*[@class='each_ability_block']/div/div[1]/div/input"));
		for (int i = 0; i < num.size(); i++) {
			num.get(i).sendKeys(""+(i+1)+"");
			Thread.sleep(500);
		}
		List<WebElement> nav = driver.findElements(By.xpath("//*[@class='each_ability_block']/div/div/div[2]/div[1]/input"));
		for (int i = 0; i < nav.size(); i++) {
			nav.get(i).click();
			Thread.sleep(500);
			List<WebElement> navt = nav.get(i).findElements(By.xpath("../../div[2]/table/tbody/tr/td[1]/div/a"));
			navt.get(0).click();
			Thread.sleep(800);
			WebElement navsub = nav.get(i).findElement(By.xpath("../../div[2]/table/tbody/tr/td[2]/button"));
			navsub.click();
		}
		WebElement save = driver.findElement(By.xpath("//*[@id='edit_subject']/div[1]/button[3]"));
		save.click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void 能力作文题() throws Exception{
		xzda();
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		Select sq = new Select(driver.findElement(By.id("typeId405")));
		List<WebElement> sq1 = sq.getOptions();
		int i = random.nextInt(sq1.size());
		if (sq1.get(i).getAttribute("value").equals("189")) {
			sq.selectByIndex(i);
			System.out.println("空白卷");
			WebElement save2 = driver.findElement(By.xpath("//*[@id='edit_subject']/div[1]/button[3]"));
			save2.click();
			Thread.sleep(8000);
		} else {
			Thread.sleep(200);
			sq.selectByIndex(i);
			能力作文题2();
		}
	
	}
	public void 能力作文题2() throws InterruptedException{
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		String main = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
		Thread.sleep(1000);
		WebElement in1 = driver.findElement(By.id("typeId406"));
		if (in1.getAttribute("readonly") == "readonly") {
		} else {
			in1.sendKeys("1、二、我");
		}
		WebElement in2 = driver.findElement(By.id("typeId407"));
		if (in2.getAttribute("readonly") == "readonly") {
		} else {
			in2.sendKeys(main);
		}
		WebElement in3 = driver.findElement(By.id("typeId408"));
		if (in3.getAttribute("readonly") == "readonly") {
		} else {
			in3.sendKeys(main);
		}
		Thread.sleep(100);
		Select in4 = new Select(driver.findElement(By.id("typeId409")));
		List<WebElement> in44 = in4.getOptions();
		in4.selectByIndex(in44.size()-1);
		Thread.sleep(100);
		Select in5 = new Select(driver.findElement(By.id("typeId411")));
		List<WebElement> in55 = in5.getOptions();
		in5.selectByIndex(in55.size()-1);
		Thread.sleep(100);
		Select in6 = new Select(driver.findElement(By.id("typeId412")));
		List<WebElement> in66 = in6.getOptions();
		in6.selectByIndex(in66.size()-1);
		Thread.sleep(100);
		Select in7 = new Select(driver.findElement(By.id("typeId414")));
		List<WebElement> in77 = in7.getOptions();
		in7.selectByIndex(in77.size()-1);
		Thread.sleep(100);
		Select in8 = new Select(driver.findElement(By.id("typeId415")));
		List<WebElement> in88 = in8.getOptions();
		in8.selectByIndex(in88.size()-1);
		Thread.sleep(100);
		WebElement in9 = driver.findElement(By.id("typeId416"));
		in9.sendKeys("1232");
		WebElement in10 = driver.findElement(By.id("typeId417"));
		in10.sendKeys("我呀");
		WebElement in11 = driver.findElement(By.id("typeId418"));
		in11.sendKeys(main);
		Thread.sleep(100);
		Select in12 = new Select(driver.findElement(By.id("typeId420")));
		List<WebElement> in122 = in12.getOptions();
		in12.selectByIndex(in122.size()-1);
		Thread.sleep(100);
		WebElement ddf = driver.findElement(By.xpath(".//*[@id='typeId421']/input"));
		ddf.click();
		Thread.sleep(100);
		List<WebElement> in13 = driver.findElements(By.xpath(".//*[@id='exam_corr_from']/div[5]/div/div[1]/div[2]/table/tbody/tr/td[1]/div/a"));
		int num = random.nextInt(in13.size());
		if (num == 0) {
			in13.get(1).click();
			Thread.sleep(100);
		} else {
			in13.get(num).click();
			Thread.sleep(100);
		}

		WebElement submit = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[5]/div/div[1]/div[2]/table/tbody/tr/td[2]/button"));
		submit.click();
		Thread.sleep(100);
		WebElement in14 = driver.findElement(By.id("typeId422"));
		in14.sendKeys("wer");
		WebElement in15 = driver.findElement(By.id("typeId423"));
		in15.sendKeys(main);
		WebElement in16 = driver.findElement(By.id("typeId424"));
		in16.sendKeys(main);
		Thread.sleep(100);
		Select in17 = new Select(driver.findElement(By.id("typeId427")));
		List<WebElement> in177 = in17.getOptions();
		in17.selectByIndex(in177.size()-1);
		Thread.sleep(100);
		WebElement save = driver.findElement(By.xpath("//*[@id='edit_subject']/div[1]/button[3]"));
		save.click();
		Thread.sleep(8000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void 精细普通题() throws Exception{
		xzda();
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		System.out.println("精细普通题");
		Actions action = new Actions(driver);
		String main = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
		List<WebElement> scorenum = driver.findElements(By.xpath(".//*[@id='exam_corr_from']/div[1]/div/div[1]/div/button"));
		int i = random.nextInt(scorenum.size());
		if (i == 0) {
			scorenum.get(1).click();
		} else {
			scorenum.get(i).click();
		}
		Thread.sleep(400);
		WebElement error1 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[1]/div/div[2]/eq/div[1]/input[2]"));
		error1.click();
		Thread.sleep(1000);
		WebElement error2 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[1]/div/div[2]/eq/div[2]/a[2]"));
		try {
			action.moveToElement(error2).click().perform();
		} catch (Exception e) {
			error2.click();
		}
		Thread.sleep(2000);
		List<WebElement> error3 = driver.findElements(By.xpath(".//*[@id='exam_corr_from']/div[1]/div/div[2]/eq/div[3]/a"));
		Thread.sleep(2000);
		try {
			action.moveToElement(error3.get(0)).click().perform();
		} catch (Exception e) {
			error3.get(0).click();
		}
		Thread.sleep(2000);

		WebElement t1 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[1]/div/div[3]/textarea"));
		t1.sendKeys(main);
		WebElement t2 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[3]/textarea"));
		t2.sendKeys(main);
		WebElement t3 = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[4]/textarea"));
		t3.sendKeys(main);
	
		WebElement sub = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		Thread.sleep(6000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void 精细作文题() throws Exception{
		xzda();
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		System.out.println("精细作文题");
		String main = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
		WebElement add = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[2]/p[2]/a"));
		for (int i = 0; i < 7; i++) {                
			add.click();
			Thread.sleep(200);
		}
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		Thread.sleep(3000);
		List<WebElement> img = driver.findElements(By.xpath(".//*[@class='btn open_cut_modal']"));
		img.remove(img.size()-1);
		for (int i = 0; i < img.size(); i++) {
			img.get(i).click();
			Thread.sleep(1000);
			for (int j = 0; j < 2; j++) {
				WebElement xz = driver.findElement(By.xpath(".//*[@id='main']/table/tbody/tr/td[2]/div/div[2]/div/div/div[3]/button[1]"));
				xz.click();
				Thread.sleep(500);
			}
			WebElement moremax = driver.findElement(By.xpath(".//*[@id='main']/table/tbody/tr/td[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div/div[3]/span[12]"));
			action.clickAndHold(moremax).moveByOffset(0, 100).perform();
			Thread.sleep(500);
			WebElement sav = driver.findElement(By.xpath(".//*[@class='btn btn-info cut']"));
			sav.click();
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
		
		Select score = new Select(driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[3]/div/div/div/select")));
		List<WebElement> s = score.getOptions();
		int f = random.nextInt(s.size());
		score.selectByIndex(f);
		
		List<WebElement> textarea = driver.findElements(By.tagName("textarea"));
		Thread.sleep(3000);
		for (int i = 0; i < textarea.size(); i++) {
			try {
				textarea.get(i).clear();
				textarea.get(i).sendKeys(main);
			} catch (Exception e) {
				continue;
			}
			
			Thread.sleep(2000);
		}
		
		WebElement sub = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		Thread.sleep(10000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void 标准普通题() throws Exception{
		xzda();
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		System.out.println("标准普通题");
		List<WebElement> scn = driver.findElements(By.cssSelector(".form-control.grap_code"));
		for (int i = 0; i < scn.size(); i++) {
			try {
				scn.get(i).sendKeys(""+(i+1)+"");
			} catch (Exception e) {
				continue;
			}
		}
		
		Select scnt = new Select(driver.findElement(By.cssSelector(".form-control.sel_id")));
		List<WebElement> scnts = scnt.getOptions();
		scnts.remove(0);
		int i1 = random.nextInt(scnts.size());
		scnts.get(i1).click();
		
		Thread.sleep(1000);
		
		WebElement scnum = driver.findElement(By.xpath(".//*[@id='exam_corr_from']/div[3]/div/div/input[4]"));
		scnum.sendKeys("3");
		
		List<WebElement> s1 = driver.findElements(By.cssSelector(".btn-group"));
		s1.remove(0);
		s1.remove(0);
		for (int i = 0; i < s1.size(); i++) {
			List<WebElement> ss = s1.get(i).findElements(By.tagName("button"));
			int i2 = random.nextInt(ss.size());
			ss.get(i2).click();
			Thread.sleep(300);
		}
		
		List<WebElement> scos  = driver.findElements(By.cssSelector(".form-control.select_short"));
		for (int i = 0; i < scos.size(); i++) {
			List<WebElement> scosoption = scos.get(i).findElements(By.tagName("option"));
			scosoption.remove(0);
			int i3 = random.nextInt(scosoption.size());
			scosoption.get(i3).click();
			Thread.sleep(300);
		}
		
		WebElement sub = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void 标准作文题() throws Exception{
		xzda();
		String main = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scrollTo(0,0)"); 
		List<WebElement> tag = driver.findElements(By.cssSelector(".form-control.readonly"));
		for (int i = 0; i < tag.size(); i++) {
			tag.get(i).click();
			Thread.sleep(100);
			List<WebElement> tags = tag.get(i).findElements(By.xpath("../../div[2]/table/tbody/tr/td[1]/div/a"));
			for (int j = 0; j < tags.size(); j++) {
				tags.get(j).click();
				Thread.sleep(100);
			}
			WebElement subf = tag.get(i).findElement(By.xpath("../../div[2]/table/tbody/tr/td[2]/button"));
			subf.click();
			Thread.sleep(1000);
		}
		
		List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
		for (int i = 0; i < textareas.size(); i++) {
			textareas.get(i).sendKeys(main);
			Thread.sleep(200);
		}
		Select scorenum = new Select(driver.findElement(By.cssSelector(".form-control.select_short")));
		List<WebElement> scs = scorenum.getOptions();
		int i = random.nextInt(scs.size());
		scorenum.selectByIndex(i);
		
		WebElement sub = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		Thread.sleep(6000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	public void 本卷综合评估() throws InterruptedException{
		System.out.println("本卷综合评估");
		Thread.sleep(5000);
		String te = "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试";
		WebElement main = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[3]/div/form/textarea"));
		main.sendKeys(te);
		WebElement sub = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}
	public void 诊断报告() throws Exception{
		System.out.println("诊断报告");
		Thread.sleep(2000);
		WebElement sub  = driver.findElement(By.xpath(".//*[@id='edit_subject']/div[1]/button[3]"));
		sub.click();
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		WebElement back = driver.findElement(By.xpath(".//*[@id='nav']/div[2]/ul/li/a"));
		back.click();
		try {
			Thread.sleep(200);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
		}
		Thread.sleep(2000);
		接单();
	}
	/**
	 * 旋转答案图片
	 * @throws Exception 
	 */
	public void xzda() throws Exception{
		String now = driver.getWindowHandle();
		WebElement xyda = driver.findElement(By.xpath(".//*[@class = 'btn btn-info btn-sm stud_answer']"));
		xyda.click();
		Thread.sleep(2000);
		Set<String> hands = driver.getWindowHandles();
		Iterator<String> it = hands.iterator();
		System.out.println("now = "+now);
		while (it.hasNext()) {
			String hand = it.next();
			if (hand.equals(now)) {
				System.out.println("sorry");
			}else {
				System.out.println("hand = "+hand);
				driver.switchTo().window(hand);
				WebElement cxjt = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[8]"));
				if (cxjt.isDisplayed()) {
					cxjt.click();
					Thread.sleep(1000);
					WebElement xz = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[2]"));
					xz.click();
					Thread.sleep(1000);
					WebElement save1 = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[1]"));
					save1.click();
					Thread.sleep(2000);
					WebElement xzd = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[2]/div[1]/div/div[3]/span[12]"));
					action.clickAndHold(xzd).moveByOffset(0, 100).perform();
					Thread.sleep(1000);
					WebElement save2 = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[7]"));
					save2.click();
					Thread.sleep(3000);
					driver.close();
					driver.switchTo().window(now);
				
				} else {
					Thread.sleep(1000);
					WebElement xz = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[2]"));
					xz.click();
					Thread.sleep(1000);
					WebElement save1 = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[1]"));
					save1.click();
					Thread.sleep(2000);
					WebElement xzd = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[2]/div[1]/div/div[3]/span[12]"));
					action.clickAndHold(xzd).moveByOffset(0, 100).perform();
					Thread.sleep(1000);
					WebElement save2 = driver.findElement(By.xpath(".//*[@id='show_imgs_page']/div[3]/button[7]"));
					save2.click();
					Thread.sleep(3000);
					driver.close();
					driver.switchTo().window(now);
				}
			}
		}
	}
	
	public void 运营审核() throws InterruptedException{
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement vcode = driver.findElement(By.id("vcode"));
		WebElement submit = driver.findElement(By.id("submit"));
		username.sendKeys("ksadmin");
		password.sendKeys("ksadmin123");
		vcode.sendKeys("1233");
		submit.click();
		
		Thread.sleep(2000);
		WebElement 运营审核 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(3)"));
		运营审核.click();
		Thread.sleep(200);
		WebElement 任务列表 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(1) > a"));
		任务列表.click();
		
		WebElement frame = driver.findElement(By.cssSelector("#content-main > iframe:nth-child(2)"));
		driver.switchTo().frame(frame);
		for (int i = 0; i < 20; i++) {
			List<WebElement> 查看 = driver.findElements(By.linkText("查看"));
			查看.get(i).click();
			Thread.sleep(1000);
			try {
				WebElement 手机号码 = driver.findElement(By.className("gooker_phone"));
				手机号码.sendKeys("13457718147");
				WebElement 分配 = driver.findElement(By.className("give_gooker"));
				分配.click();
				Thread.sleep(1000);
				WebElement 返回 = driver.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/div/button"));
				返回.click();
			} catch (Exception e) {
				System.out.println("不需要分配");
				WebElement 返回 = driver.findElement(By.xpath("//*[@id='bodymain']/div/div[1]/div[1]/div/div/button"));
				返回.click();
			}
			
		}
	
	}
	@After
	public void after(){
		driver.quit();
	}
}
