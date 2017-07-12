package seleniumJava;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SCRM{
	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);
	
	@Before
	public void openWeb(){
		driver.manage().window().maximize();
	}
	@After
	public void closeWeb(){
		driver.quit();
	}
	@Test
	public void Test() throws Exception{
		login();
	}
	
	public void login() throws Exception{
		String url = "http://scrmxgstest.newgs.net";
		driver.get(url);
		WebElement uname = driver.findElement(By.xpath("html/body/div[1]/form/div[1]/div/input"));
		WebElement upass = driver.findElement(By.xpath("html/body/div[1]/form/div[2]/div/input"));
		uname.clear();
		upass.clear();
		uname.sendKeys("admin@admin.com");
		upass.sendKeys("admin123");
		WebElement submit = driver.findElement(By.xpath("html/body/div[1]/form/div[4]/button"));
		submit.click();
		Thread.sleep(1000);
		hd();
	}
	/**
	 * 判断导航
	 * @throws Exception 
	 */
	public void check() throws Exception{
		List<WebElement> nav = driver.findElements(By.xpath(".//*[@id='navbar']/ul/li"));
		for (int i = 0 ;i < nav.size();i++) {
			action.moveToElement(nav.get(i));
			Thread.sleep(3000);
			String text = nav.get(i).getText();
			if (text.equals("工作台")) {
				gzt();
				Thread.sleep(2000);
			} else if (text.equals("客户管理")){
				khgl();
				Thread.sleep(2000);
			} else if(text.equals("督学管理")){
				dxgl();
				Thread.sleep(2000);
			} else if(text.equals("活动")){
				hd();
				Thread.sleep(2000);
			} else if(text.equals("销售目标")){
				xsmb();
				Thread.sleep(2000);
			} else if(text.equals("团队管理")){
				tdgl();
				Thread.sleep(2000);
			} else if(text.equals("推送")){
				ts();
				Thread.sleep(2000);
			} else{
				continue;
			}
		}
	}
	
	/**
	 * 工作台
	 */
	public void gzt(){
		System.out.println("工作台");
	}
	/**
	 * 客户管理
	 * @throws Exception 
	 */
	public void khgl() throws Exception{
		System.out.println("客户管理");
	}
	/**
	 * 督学管理
	 * @throws Exception 
	 */
	public void dxgl() throws Exception{
		System.out.println("督学管理");
	}	
	/**
	 * 活动管理
	 * @throws Exception 
	 */
	public void hd() throws Exception{
		System.out.println("活动管理");
		for (int i = 0; i < 2; i++) {
			driver.get("http://scrmxgstest.newgs.net/activity/create");
			Thread.sleep(1000);
			WebElement hdmc = driver.findElement(By.xpath("//*[@id='signupForm']/div[1]/div/input"));
			hdmc.sendKeys("活动名称"+i);
			WebElement begintime = driver.findElement(By.xpath("//*[@id='start_at']"));
			begintime.sendKeys("2017-06-26 16:11:11");
			WebElement endtime = driver.findElement(By.xpath("//*[@id='end_at']"));
			endtime.sendKeys("2017-06-28 16:11:11");
			WebElement hdnr = driver.findElement(By.xpath("//*[@id='signupForm']/div[5]/div/textarea"));
			hdnr.sendKeys("活动内容");
			WebElement hdgz = driver.findElement(By.xpath("//*[@id='signupForm']/div[6]/div/textarea"));
			hdgz.sendKeys("活动规则");
			Select sf = new Select(driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div[1]/select")));
			sf.selectByValue("2");
			Thread.sleep(500);
			Select cs = new Select(driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div[2]/select")));
			cs.selectByValue("52");
			Thread.sleep(500);
			Select dq = new Select(driver.findElement(By.xpath("//*[@id='signupForm']/div[7]/div/div[3]/select")));
			dq.selectByValue("500");
			WebElement xxdz = driver.findElement(By.xpath("//*[@id='signupForm']/div[8]/div/input"));
			xxdz.sendKeys("详细地址");
			WebElement hdtp = driver.findElement(By.xpath("//*[@id='add_pic']/img"));
			hdtp.click();
			WebElement schdtp = driver.findElement(By.xpath("//*[@id='thumb']"));
			schdtp.sendKeys("C:/Users/陆石勤/Desktop/img/adder.png");
			Thread.sleep(2000);
			WebElement qrtp = driver.findElement(By.xpath("//*[@id='addImage']"));
			qrtp.click();
			WebElement we1 = driver.findElement(By.xpath("//*[@id='groupQrcode']"));
			we1.sendKeys("C:/Users/陆石勤/Desktop/img/IMG_9488 2.JPG");
			Thread.sleep(2000);
			WebElement we2 = driver.findElement(By.xpath("//*[@id='adminQrcode']"));
			we2.sendKeys("C:/Users/陆石勤/Desktop/img/IMG_9357 2.JPG");
			Thread.sleep(2000);
			WebElement gzsm = driver.findElement(By.xpath("//*[@id='prize_rules']"));
			gzsm.sendKeys("规则说明");
			for (int j = 0; j < 8; j++) {
				int k = j+1;
				Thread.sleep(4000);
				WebElement tjjx = driver.findElement(By.xpath("//*[@id='signupForm']/div[16]/button"));
				tjjx.click();
				Thread.sleep(1000);
				WebElement jpmc = driver.findElement(By.xpath("//*[@id='input_gift_name']"));
				jpmc.clear();
				jpmc.sendKeys(k+"等奖");
				WebElement jptp = driver.findElement(By.xpath("//*[@id='prize_photo']"));
				jptp.clear();
				jptp.sendKeys("C:/Users/陆石勤/Desktop/img/顺序/"+k+".jpg");
				Thread.sleep(200);
				Select jplx = new Select(driver.findElement(By.xpath("//*[@id='invent']")));
				if (j >4) {
					jplx.selectByValue("1");
					WebElement xndz = driver.findElement(By.xpath("//*[@id='link']/input"));
					xndz.clear();
					xndz.sendKeys("www.baidu.com");
				} else {
					jplx.selectByValue("0");
				}
				
				WebElement jpsl = driver.findElement(By.xpath("//*[@id='prize']/div/div/div[2]/div[5]/input"));
				jpsl.clear();
				jpsl.sendKeys("1");
				
				WebElement tj = driver.findElement(By.xpath("//*[@id='addPrize']"));
				tj.click();
				Thread.sleep(5000);
			}
			
			WebElement sure = driver.findElement(By.xpath("//*[@id='signupForm']/div[18]/button"));
			sure.click();
			Thread.sleep(2000);
		}
	}
	/**
	 * 销售目标
	 */
	public void xsmb(){
		System.out.println("销售目标");
	}
	/**
	 * 团队管理
	 * @throws Exception 
	 */
	public void tdgl() throws Exception{
		System.out.println("团队管理");
	}
	/**
	 * 消息推送
	 * @throws InterruptedException 
	 */
	public void ts() throws InterruptedException{
		System.out.println("消息推送");
	}
}