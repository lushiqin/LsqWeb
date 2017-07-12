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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class htsltk {
	WebDriver driver = new ChromeDriver();
//	WebDriver driver = new FirefoxDriver();
	Random random = new Random();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String time1 = df.format(new Date());
	
	
	@Before
	public void before() throws Exception{
		driver.manage().window().maximize();
		driver.get("http://examtest.newgs.net/index.php/Admin/Login/index");
		login();
	}
	
	@After
	public void after(){
		driver.close();
	}
	
	public void login() throws Exception{
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement vcode = driver.findElement(By.id("vcode"));
		WebElement submit = driver.findElement(By.id("submit"));
		username.clear();
		password.clear();
		username.sendKeys("13457718147");
		password.sendKeys("123456");
		vcode.sendKeys("1233");
		submit.click();
		Thread.sleep(1000);
	}
	
	
	
	@Test
	public void closexzt() throws Exception{
		closestatu();
	}
	
	@Test
	public void jxclose() throws Exception{
		closeJx();
	}
	
	@Test
	public void Createxzt() throws Exception{
		createXzt();
	}
	
	
	
	
	public void createXzt() throws Exception{
		WebElement nav = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a"));
		nav.click();
		Thread.sleep(1000);
		
		inputFile inf = new inputFile();
		String filename = "C:/Users/陆石勤/Desktop/sltk.xlsx";
		//应用文0，作文题1，概括题2，对策题3，分析题4
		Map<String, ArrayList<String>> map = inf.file(filename,1);
		ArrayList<String> list = new ArrayList<>();
		//题型1作文，2分析，3对策，4应用，5概括
		int s = 1;
		for (int i = 1; i < map.size()+1; i++) {
			list = map.get(""+i+"");
			String cl = list.get(0);String tm = list.get(1);String jx = list.get(2);
			System.out.println("第"+i+"道    "+list.size());
			
			//选项内容
			List<String> xz = new ArrayList<>();
			xz.add(list.get(3));xz.add(list.get(4));xz.add(list.get(5));
			xz.add(list.get(6));xz.add(list.get(7));xz.add(list.get(8));
			//正确项
			List<String> da = new ArrayList<>();
			da.add(list.get(9));da.add(list.get(10));da.add(list.get(11));
			da.add(list.get(12));da.add(list.get(13));da.add(list.get(14));
			//难度
			String nd1 = list.get(15);
			if (i > 101) {
				xzttrue(cl, tm,jx,xz,da,nd1,s);
			} else {
				continue;
			}
		}
	}
	
	private void xzttrue(String cl, String tm, String jx, List<String> xz, List<String> da, String nd1,int s) throws Exception {
		Thread.sleep(200);
		WebElement xzt = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/ul/li[3]/a"));
		xzt.click();
		Thread.sleep(500);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
		WebElement tjtm = driver.findElement(By.xpath(".//*[@id='top_act']/div[1]/a"));
		tjtm.click();
		Thread.sleep(200);
//		
//		((JavascriptExecutor) driver).executeScript("alert("+num+")");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		
		//题目内容
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/form/div[3]/div/div/div[2]/iframe")));
		WebElement tmnr = driver.findElement(By.xpath("/html/body"));
		tmnr.sendKeys(tm);
		driver.switchTo().parentFrame();
		Thread.sleep(200);
		
		//添加选项
		WebElement tjxx = driver.findElement(By.xpath("//*[@id='div_form']/form/div[5]/div/button"));
		for (int i = 0; i < xz.size(); i++) {
			if (!xz.get(i).equals("无")) {
				tjxx.click();
			}
		}
		List<WebElement> options = driver.findElements(By.xpath(".//*[@class='each_option row']"));
		int num = 1;
		for (int i = 0; i < options.size(); i++) {
			WebElement optionname = options.get(i).findElement(By.xpath("./div[1]/input"));
			WebElement optionlable = options.get(i).findElement(By.xpath("./div[2]/label/input[1]"));
			optionname.sendKeys(xz.get(i));
			for (int j = 0; j < da.size(); j++) {
				String val = da.get(j);
				if (val.equals(""+num+"") && !val.equals("无")) {
					Thread.sleep(100);
					optionlable.click();
				}
			}
			num++;
		}
		Thread.sleep(500);
		
		//材料内容
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/form/div[6]/div/div/div[2]/iframe")));
		WebElement clnr = driver.findElement(By.xpath("/html/body"));
		if (!cl.equals("无")) {
			clnr.sendKeys(cl);
		}
		driver.switchTo().parentFrame();
		
		//易错答案
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='div_form']/form/div[7]/div/div/div[2]/iframe")));
		WebElement wzdp = driver.findElement(By.xpath("/html/body"));
		wzdp.sendKeys(jx);
		driver.switchTo().parentFrame();
		
		//题型
		Select tx = new Select(driver.findElement(By.xpath("//*[@id='div_form']/form/div[8]/div/select")));
		tx.selectByIndex(s);
		
		//适应阶段
//		int k3 = random.nextInt(2)+1;
//		for (int i3 = 0; i3 < k3; i3++) {
//			WebElement syjd = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[9]/div/div/ul/li/input"));
//			syjd.click();
//			List<WebElement> s1 = driver.findElements(By.xpath(".//*[@id='div_form']/form/div[9]/div/div/div/ul/li"));
//			s1.get(i3).click();
//			Thread.sleep(200);
//		}
		//考试类型
		for (int i1 = 0; i1 < 2; i1++) {
			WebElement kslx = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[10]/div/div/ul/li/input"));
			kslx.click();
			List<WebElement> s2 = driver.findElements(By.xpath(".//*[@id='div_form']/form/div[10]/div/div/div/ul/li"));
			s2.get(i1).click();
			Thread.sleep(200);
		}
		
		//难度
		WebElement nd = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[11]/div/div/ul/li/input"));
		nd.click();
		List<WebElement> s3 = driver.findElements(By.xpath(".//*[@id='div_form']/form/div[11]/div/div/div/ul/li"));
		s3.get(Integer.parseInt(nd1)).click();
		Thread.sleep(200);
//		for (int i2 = 0; i2 < k2; i2++) {
//			WebElement nd = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[11]/div/div/ul/li/input"));
//			nd.click();
//			List<WebElement> s3 = driver.findElements(By.xpath(".//*[@id='div_form']/form/div[11]/div/div/div/ul/li"));
//			s3.get(i2).click();
//			Thread.sleep(200);
//		}
		
		WebElement zt = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[12]/div/label[1]/input"));
		zt.click();
		
		Thread.sleep(500);
		WebElement save = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[13]/div/button"));
		save.click();
		
		driver.switchTo().parentFrame();
	}

	public void closestatu() throws Exception{
		WebElement nav = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a"));
		nav.click();
		Thread.sleep(1000);
		for (int i = 0; i < 300; i++) {
			WebElement xzt = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/ul/li[3]/a"));
			xzt.click();
			Thread.sleep(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
			WebElement xgtm = driver.findElement(By.xpath(".//*[@id='common_table']/tbody/tr[2]/td[6]/a"));
			xgtm.click();
			Thread.sleep(100);
			
			WebElement statu = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[12]/div/label[2]"));
			statu.click();
			WebElement save = driver.findElement(By.xpath(".//*[@id='div_form']/form/div[13]/div/button"));
			save.click();
			Thread.sleep(2000);
			
			driver.switchTo().parentFrame();
		}
	}
	
	public void closeJx() throws Exception{
		WebElement nav = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/a"));
		nav.click();
		Thread.sleep(1000);
		int j = 2;
		int k = 1;
		WebElement sxlb = driver.findElement(By.xpath("//*[@id='side-menu']/li[9]/ul/li[5]"));
		sxlb.click();
		Thread.sleep(2000);
		for (int i = 0; i < 300; i++) {
			driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content-main']/iframe[2]")));
			Thread.sleep(200);
			List<WebElement> fy1 = driver.findElements(By.xpath("//*[@id='main_div']/div[3]/ul/li"));
			if (j < 16) {
				WebElement sxStatu = driver.findElement(By.xpath("//*[@id='common_table']/tbody/tr["+j+"]/td[6]/a"));
				System.out.println(sxStatu.getText());
				if (sxStatu.getText().equals("开启")) {
					sxStatu.click();
					Thread.sleep(2000);
				}
				j++;
			} else {
				j = 2;
				k++;
				WebElement fynum = fy1.get(k).findElement(By.xpath(".//a"));
				fynum.click();
			}
			driver.switchTo().parentFrame();
		}
	}
}