package seleniumJava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sltk {
	WebDriver driver = new ChromeDriver();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time1 = df.format(new Date());
	Random random = new Random();

	@Before
	public void before() throws Exception{
		driver.manage().window().maximize();
		driver.get("http://sltktest.newgs.net/admin/login");
		login();
	}
	
	@Test
	public void addjx() throws Exception{
		System.out.println("begin");
		dtjx();
	}
	
	@Test
	public void addvoid() throws Exception{
		CreatVoid();
	}
	
	@After
	public void after(){
		driver.close();
	}
	
	public void login() throws Exception{
		WebElement name = driver.findElement(By.xpath(".//*[@id='login_div']/form/div/div[2]/div/input"));
		WebElement pass = driver.findElement(By.xpath(".//*[@id='login_div']/form/div/div[3]/div/input"));
		name.clear();
		pass.clear();
		name.sendKeys("1340000");
		pass.sendKeys("123456");
		WebElement submit = driver.findElement(By.xpath(".//*[@id='login_div']/form/div/div[4]/button"));
		submit.click();
		Thread.sleep(2000);
		
	}
	
	public void CreatVoid() throws Exception{
		WebElement nav = driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a"));
		nav.click();
		Thread.sleep(1000);
		for (int i = 0; i < 1; i++) {
			inputFile infile = new inputFile();
			Map<String, ArrayList<String>> map = infile.file("C:/Users/陆石勤/Desktop/sltk.xlsx", 6);
			ArrayList<String> list = new ArrayList<>();
			String tx = "";String url = "";String nd = "";String bt = "";
			for (int j = 1; j < map.size(); j++) {
				list = map.get(""+j+"");
				tx = list.get(0);url = list.get(1);nd = list.get(2);bt = list.get(3);
				
				WebElement mp3 = driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/ul/li[3]/a"));
				mp3.click();
				
				Thread.sleep(1000);
				driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='content-main']/iframe[2]")));
				WebElement voidadd = driver.findElement(By.xpath("//*[@id='top_act']/div[1]/a"));
				voidadd.click();
				Thread.sleep(2000);
				
				//题型
				WebElement tx1 = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div[2]/form/div[2]/div/div/ul"));
				tx1.click();
				Thread.sleep(1000);
				List<WebElement> txnr = tx1.findElements(By.xpath("../div/ul/li"));
				txnr.get(Integer.parseInt(tx)).click();
				
				WebElement url1 = driver.findElement(By.xpath("//*[@id='video_link']"));
				url1.sendKeys(url);
				
				//考试类型
				WebElement kslx = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div[2]/form/div[5]/div/div/ul"));
				kslx.click();
				Thread.sleep(200);
				List<WebElement> kslxnr = kslx.findElements(By.xpath("../div/ul/li"));
				kslxnr.get(2).click();
				
				//难度
				WebElement nd1 = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div[2]/form/div[6]/div/div/ul"));
				nd1.click();
				Thread.sleep(200);
				List<WebElement> ndnr = nd1.findElements(By.xpath("../div/ul/li"));
				ndnr.get(Integer.parseInt(nd)-1).click();
				
				WebElement bt1 = driver.findElement(By.xpath("//*[@id='title']"));
				bt1.sendKeys(bt);
				
				Thread.sleep(1000);
				WebElement save = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div[2]/form/div[9]/div/button"));
				save.click();
				Thread.sleep(2000);
				driver.switchTo().parentFrame();
			}
		}
	}
	
	public void dtjx() throws Exception{
		WebElement nav = driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/a"));
		nav.click();
		Thread.sleep(1000);
		
		for(int jkl = 0;jkl < 1 ;jkl++){
			inputFile infile = new inputFile();
			//真题解析5
			Map<String, ArrayList<String>> map = infile.file("C:/Users/陆石勤/Desktop/sltk.xlsx", 5);
			ArrayList<String> list = new ArrayList<>();
			String bt1 = "";String tmnr1 = "";String clnr1 = ""; 
			String bzda1 = "";String pfxz1 = "";String ycda1 = "";
			String nd1 = "";String tx1 ="";String kslx1 = "";
			for (int i = 1; i < map.size()+1; i++) {
				if(i > 97){

					System.out.println(i);
					list = map.get(""+i+"");
					bt1 = list.get(0);tmnr1 = list.get(1);clnr1 = list.get(2);bzda1 = list.get(3);
					pfxz1 = list.get(4);ycda1 = list.get(5);nd1 = list.get(6);tx1 = list.get(7);
					kslx1 = list.get(8);
					
					WebElement dtjx = driver.findElement(By.xpath(".//*[@id='side-menu']/li[2]/ul/li[1]/a"));
					dtjx.click();
					
					Thread.sleep(1000);
					driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='content-main']/iframe[2]")));
					WebElement tjdtjx = driver.findElement(By.xpath(".//*[@id='top_act']/div/div/div/div/div[1]/a"));
					tjdtjx.click();
					Thread.sleep(2000);
					
					WebElement tjcl = driver.findElement(By.xpath(".//*[@id='div_form']/div/div/div/div[1]/form/div[1]/div/a"));
					tjcl.click();
					
					//材料标题
//					WebElement clbt = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[1]/div/ul/li/div[1]/div/input"));
//					clbt.sendKeys("材料");
					
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[1]/div/ul/li/div[2]/div/div[2]/iframe")));
					WebElement clnr = driver.findElement(By.xpath("/html/body"));
					clnr.sendKeys(clnr1);
					driver.switchTo().parentFrame();
					
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[2]/div/div/div/div[2]/iframe")));
					WebElement tmnr = driver.findElement(By.xpath("/html/body"));
					tmnr.sendKeys(tmnr1);
					driver.switchTo().parentFrame();
					
					//阅卷要点
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[3]/div/div/div[2]/iframe")));
					WebElement yjyd = driver.findElement(By.xpath("/html/body"));
					yjyd.sendKeys("标准答案 \n"+bzda1+" \n 评分细则 \n"+pfxz1);
					driver.switchTo().parentFrame();
					Thread.sleep(1000);
					
					//错题图片
//					WebElement dxctimg = driver.findElement(By.xpath("//*[@id='picker']/div[2]/input"));
//					dxctimg.sendKeys("C:/Users/陆石勤/Desktop/img/alc.png");
//					Thread.sleep(5000);
//					WebElement imgsub =driver.findElement(By.xpath("//*[@id='uploader']/button"));
//					imgsub.click();
//					Thread.sleep(3000);
					
					//典型错题富文本
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[5]/div/div/div/div[2]/iframe")));
					WebElement dxcttext = driver.findElement(By.xpath("/html/body"));
					dxcttext.sendKeys(ycda1);
					driver.switchTo().parentFrame();
					
					
					Thread.sleep(1000);
					WebElement txgl = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[6]/div/div/ul"));
					txgl.click();
					Thread.sleep(1000);
					List<WebElement> txnr = txgl.findElements(By.xpath("../div/ul/li"));
					txnr.get(Integer.parseInt(tx1)).click();
					Thread.sleep(1000);
					
					//适用阶段
//					WebElement syjd = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[7]/div/div/ul"));
//					syjd.click();
//					Thread.sleep(1000);
//					List<WebElement> syjdnr = syjd.findElements(By.xpath("../div/ul/li"));
//					int i2 = random.nextInt(3);
//					syjdnr.get(i2).click();
//					Thread.sleep(1000);
					
					WebElement kslx = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[8]/div/div/ul"));
					kslx.click();
					Thread.sleep(1000);
					List<WebElement> kslxnr = kslx.findElements(By.xpath("../div/ul/li"));
					kslxnr.get(Integer.parseInt(kslx1)).click();
					Thread.sleep(1000);
					
					WebElement nd = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[9]/div/div/ul"));
					nd.click();
					Thread.sleep(1000);
					List<WebElement> ndnr = nd.findElements(By.xpath("../div/ul/li"));
					ndnr.get(Integer.parseInt(nd1)).click();
					Thread.sleep(1000);
					
		//			上传语音
//					WebElement mp3 = driver.findElement(By.xpath(".//*[@id='voicePicker']/div[2]"));
//					mp3.click();
//					Runtime.getRuntime().exec("c:/lsq/sltk.exe");
//					boolean cheack = true;
//					do {
//						try {
//							WebElement cheackmp3 = driver.findElement(By.xpath(".//*[@class ='success text-right']"));
//							cheack = cheackmp3.isEnabled();
//						} catch (Exception e) {
//							cheack = false;
//						}
//						Thread.sleep(1000);
//					} while (!cheack);
					
					
					WebElement bt = driver.findElement(By.xpath("//*[@id='title']"));
					bt.sendKeys(bt1);
					
					//配图
//					WebElement pt = driver.findElement(By.xpath("//*[@id='imgPicker']/div[2]/input"));
//					pt.sendKeys("C:/Users/陆石勤/Desktop/img/alc.png");
//					((JavascriptExecutor) driver).executeScript("scrollTo(0,0)");
//					Thread.sleep(1000);
//					List<WebElement> imgclick = driver.findElements(By.xpath(".//*[@id='uploader']/button"));
//					imgclick.get(1).click();
//					Thread.sleep(3000);
					
					WebElement save = driver.findElement(By.xpath("//*[@id='div_form']/div/div/div/div/form/div[14]/div/button[1]"));
					save.click();
					Thread.sleep(5000);
					driver.switchTo().parentFrame();
				
				}
			}
		}
	}
}