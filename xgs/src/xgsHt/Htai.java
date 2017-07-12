package xgsHt;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;

public class Htai {
	WebDriver driver = new ChromeDriver();
	
	@Before
	public void before() throws Exception{
		driver.manage().window().maximize();
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		Thread.sleep(1000);
	}
	@After
	public void after(){
		driver.close();
	}
	public void login() throws Exception{
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("xgstest");
		WebElement userpass = driver.findElement(By.id("password"));
		userpass.clear();
		userpass.sendKeys("123456");
		WebElement vcode = driver.findElement(By.id("vcode"));
		vcode.sendKeys("123");
		Thread.sleep(1000);
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		Thread.sleep(2000);
	}
	@Test
	public void Test() throws Exception{
		String name = "测试-标批4.0-";
		//登陆
		login();
		//套餐
		Tcan(name);
		//订单 ：1申论，2综合应用能力
		Ddan(1,name);
	}
	
	
	/**
	 * 套餐
	 * @throws Exception 
	 */
	public void Tcan(String name) throws Exception{
		WebElement meun = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun.click();
		Thread.sleep(200);
		WebElement tcan = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[1]/a"));
		tcan.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement addTc = driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[1]/div[1]/a"));
		addTc.click();
		WebElement tcName = driver.findElement(By.name("name"));
		tcName.sendKeys(name+"套餐");
		WebElement tcMain = driver.findElement(By.name("desc"));
		tcMain.sendKeys(name);
		WebElement closeTime = driver.findElement(By.id("close_time"));
		closeTime.sendKeys("2017-07-13 00:00:00");
		WebElement addOption = driver.findElement(By.linkText("新增试卷"));
		addOption.click();
		WebElement option = driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div/div[2]/div[1]/div/div"));
		option.click();
		WebElement optionName = driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div/div[2]/div[1]/div/div/div/div/input"));
		optionName.sendKeys("Lsq（测试标批4.0标签）-Lsq（测试标批4.0试卷）");
		WebElement optionSelect = driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div/div[2]/div[1]/div/div/div/ul/li"));
		optionSelect.click();
		WebElement optionSort = driver.findElement(By.name("exam_sort[]"));
		optionSort.sendKeys("1");
		WebElement addVideo = driver.findElement(By.linkText("新增视频"));
		addVideo.click();
		WebElement videoSort = driver.findElement(By.name("video_sort[]"));
		videoSort.sendKeys("2");
		WebElement submit = driver.findElement(By.xpath("//*[@id='signupForm']/div[17]/div/button"));
		submit.click();
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement meun1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun1.click();
		Thread.sleep(1000);
	}
	
	/**
	 * @param i
	 * @throws Exception
	 * 订单
	 */
	public void Ddan(int i,String name) throws Exception{
		WebElement meun = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun.click();
		Thread.sleep(1000);
		WebElement Ddan = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[2]"));
		Ddan.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement addDdan = driver.findElement(By.xpath("//*[@id='bodymain']/div/div/div/div/div[2]/div[1]/div/a[1]"));
		addDdan.click();
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("1000");
		Select code = new Select(driver.findElement(By.name("msg_tpl")));
		code.selectByIndex(i);
		WebElement orderNum = driver.findElement(By.name("order_id"));
		orderNum.sendKeys(name+"订单号");
		WebElement submit = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/button"));
		submit.click();
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		WebElement closeframe = driver.findElement(By.xpath("//*[@id='page-wrapper']/div[2]/nav/div/a[2]/i"));
		closeframe.click();
		WebElement meun1 = driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a"));
		meun1.click();
	}
}