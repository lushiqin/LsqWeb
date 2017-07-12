package seleniumJava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


public class 后台系统 {

	WebDriver driver;
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
	
	String name = "标批作文题3.2版本";

	@Before
	public void before() {
		login();
	}

	@After
	public void after() {
		driver.quit();
	}

	public void login() {
		// WebDriver driver = new FirefoxDriver();
		driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement vcode = driver.findElement(By.id("vcode"));
		WebElement submit = driver.findElement(By.id("submit"));
		username.sendKeys("ksadmin");
		password.sendKeys("ksadmin123");
		vcode.sendKeys("1233");
		submit.click();
	}
	
	@org.junit.Test
	public void 模块列表() throws InterruptedException {
		List<WebElement> nav = driver.findElements(By.cssSelector("#side-menu > li"));
		for (int i = 1; i < nav.size(); i++) {
			List<WebElement> tag = driver.findElements(By.cssSelector("#side-menu > li > ul > li"));
			switch (nav.get(i).getText()) {
			case "模考管理":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "运营审核":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "产品销售":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "运营试卷":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "教研模块":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "公客模块":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "权限模块":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			case "专题特卖":
				System.out.println(nav.get(i).getText());
				nav.get(i).click();
				Thread.sleep(3000);
				for (int j = 0; j < tag.size(); j++) {
					if (!tag.get(j).getText().equals("")) {
						System.out.println(j + "...." + tag.get(j).getText());
						tag.get(j).click();
						Thread.sleep(1000);
					}
				}
				break;
			default:
				break;
			}
		}
	}

	@org.junit.Test
	public void 添加学员() throws InterruptedException {
		WebElement 模考管理 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(2) > a"));
		模考管理.click();
		WebElement 学员列表 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(1) > a"));
		学员列表.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement 添加学员 = driver
				.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[1]/div[1]/a[1]/span"));
		添加学员.click();
		WebElement 姓名 = driver.findElement(By.cssSelector("#name"));
		WebElement 电话 = driver.findElement(By.cssSelector("#phone"));
		WebElement 邮箱 = driver.findElement(By.cssSelector("#email"));
		姓名.clear();
		电话.clear();
		邮箱.clear();
		姓名.sendKeys("姓名" + time);
		电话.sendKeys("1" + time);
		邮箱.sendKeys("123@qq.com");
		WebElement 确认 = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/button"));
		确认.click();
		Thread.sleep(1000);
		WebElement 查找 = driver.findElement(By.cssSelector(
				"#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div:nth-child(2) > div > input"));
		查找.clear();
		查找.sendKeys("1" + time);
		WebElement 搜索 = driver.findElement(By.cssSelector(
				"#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div:nth-child(2) > div > span > input"));
		搜索.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

	@org.junit.Test
	public void 添加分校() throws InterruptedException {
		WebElement 模考管理 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(2) > a"));
		模考管理.click();
		Thread.sleep(1000);
		WebElement 分校管理 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(2) > a"));
		分校管理.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		Thread.sleep(2000);
		WebElement 添加分校 = driver.findElement(By.cssSelector(
				"#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div > a > span"));
		添加分校.click();
		Thread.sleep(1000);
		WebElement 分校名称 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(2) > div > input"));
		分校名称.clear();
		分校名称.sendKeys("分校" + time);
		WebElement 状态 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(5) > div > label:nth-child(1)"));
		状态.click();
		WebElement 确认 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > button"));
		确认.click();
		driver.switchTo().defaultContent();
	}

	@org.junit.Test
	public void 添加模考() throws InterruptedException {
		WebElement 模考管理 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(2) > a"));
		模考管理.click();
		Thread.sleep(1000);
		WebElement 模考列表 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(3) > a"));
		模考列表.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(2)")));
		Thread.sleep(2000);
		WebElement 添加模考 = driver.findElement(By.cssSelector("#bodymain > div > div > div > div > div.ibox-content > div:nth-child(1) > div > a"));
		添加模考.click();
		Thread.sleep(1000);
		WebElement 分校名称 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(3) > div > div > a > span"));
		分校名称.click();
		WebElement 选择分校 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(3) > div > div > div > ul > li:nth-child(2)"));
		选择分校.click();
		WebElement 模考时间 = driver.findElement(By.cssSelector("#mock_time"));
		模考时间.sendKeys(date);
		WebElement 模考名称 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(5) > div > input"));
		模考名称.sendKeys("模考" + date1);
		WebElement 模考次序 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > div > a > span"));
		模考次序.click();
		int i = random.nextInt(5) + 2;
		WebElement 选择次序 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(6) > div > div > div > ul > li:nth-child(" + i + ")"));
		选择次序.click();
		WebElement 套餐类型 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(7) > div > div > a > span"));
		套餐类型.click();
		int j = random.nextInt(4) + 2;
		WebElement 选择类型 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(7) > div > div > div > ul > li:nth-child(" + j + ")"));
		选择类型.click();
		WebElement 选择标签 = driver.findElement(By.xpath(".//*[@id='mockSelectConTag_chosen']/ul/li/input"));
		选择标签.click();
		int k = random.nextInt(11) + 1;
		WebElement 标签 = driver.findElement(By.xpath(".//*[@id='mockSelectConTag_chosen']/div/ul/li[" + k + "]"));
		标签.click();
		WebElement 选择套餐 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(10) > div > div > a > span"));
		选择套餐.click();
		WebElement 套餐名称 = driver.findElement(By.xpath(".//*[@id='signupForm']/div[8]/div/div/div/ul/li[14]"));
		套餐名称.click();
		WebElement 状态 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(14) > div > label:nth-child(1)"));
		状态.click();
		WebElement 确认 = driver.findElement(By.cssSelector("#signupForm > div:nth-child(15) > div > button"));
		确认.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement 选择增值服务 = driver.findElement(By.xpath(".//*[@id='zzfw_product_id_chosen']/a/span"));
		选择增值服务.click();
		WebElement 增值服务 = driver.findElement(By.xpath(".//*[@id='zzfw_product_id_chosen']/div/ul/li[4]"));
		增值服务.click();
		Thread.sleep(1000);
		WebElement 确定 = driver.findElement(By.xpath(".//*[@id='do_add_zzfw']"));
		确定.click();
		WebElement sure = driver.findElement(By.xpath("//*[@id='xubox_layer1']/div[1]/span[2]/a[1]"));
		sure.click();
		Thread.sleep(2000);
		WebElement 负责人 = driver.findElement(By.xpath(".//*[@id='bodymain']/div[1]/div/div[1]/div/div/div[2]/div[3]/div[2]/div/button"));
		负责人.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement 姓名 = driver.findElement(By.xpath(".//*[@id='contacts_name']"));
		姓名.sendKeys("测试");
		WebElement 手机号码 = driver.findElement(By.xpath("//*[@id='contacts_mobile']"));
		手机号码.sendKeys("13000000000");
		WebElement 邮箱号码 = driver.findElement(By.xpath("//*[@id='contacts_email']"));
		邮箱号码.sendKeys("123@123.com");
		WebElement 保存 = driver.findElement(By.xpath("//*[@id='addContactsModalForm']/div/div[3]/button[2]"));
		保存.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(2)")));
		WebElement 返回 = driver.findElement(By.xpath("//*[@id='bodymain']/div[1]/div/div[1]/div/div/div[1]/button"));
		返回.click();
		driver.switchTo().defaultContent();
	}

	@org.junit.Test
	public void 运营试卷() throws InterruptedException {
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
		
		Thread.sleep(8000);
	}

	
	@org.junit.Test
	public void 产品销售() throws Exception{
		WebElement 产品销售 = driver.findElement(By.cssSelector("#side-menu > li:nth-child(4) > a"));
		产品销售.click();
		
		WebElement 套餐管理 = driver.findElement(By.cssSelector("#side-menu > li.active > ul > li:nth-child(1) > a"));
		套餐管理.click();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(2)")));
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
		driver.switchTo().frame(driver.findElement(By.cssSelector("#content-main > iframe:nth-child(3)")));
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
	
	@Test
	public void 运营审核() throws InterruptedException{
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
}
