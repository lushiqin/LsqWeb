package seleniumJava;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class 学员中心 {
	WebDriver driver;
	
	@Before
	public void before() throws Exception{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://examtest.newgs.net/index.php/Ewap/StudIndex/login");
		login();
		Thread.sleep(2000);
	}
	@After
	public void after(){
		driver.quit();
	}
	
	public void login(){
		WebElement 账号 = driver.findElement(By.xpath("//*[@id='login']/div[1]/div[2]/input"));
		WebElement 密码 = driver.findElement(By.xpath("//*[@id='login']/div[2]/div[2]/input"));
		账号.clear();
		密码.clear();
		账号.sendKeys("15012931651");
		密码.sendKeys("测试");
		WebElement 登陆 = driver.findElement(By.xpath("//*[@id='login']/div[3]/button"));
		登陆.click();
	}
	
	@Test
	public void 提交答案() throws Exception{
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
					Thread.sleep(1000);
				    
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
}
