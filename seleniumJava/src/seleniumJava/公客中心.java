package seleniumJava;

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

public class 公客中心 {
	WebDriver driver = new ChromeDriver();
	SimpleDateFormat df1 = new SimpleDateFormat("MMddHHmmss");
	String time = df1.format(new Date());
	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	String date = df2.format(new Date());
	SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date1 = df3.format(new Date());
	SimpleDateFormat df4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String date2 = df4.format(new Date());
	Random random = new Random();
	Actions action = new Actions(driver);
	
	@Before
	public void before() throws InterruptedException{
		driver.manage().window().maximize();;
		driver.get("http://examtest.newgs.net/gkwap.php/GoogkerApi/WapGongker/login");
		login();
	}
	
	@After
	public void after() throws InterruptedException{
		Thread.sleep(8000);
		driver.quit();
	}
	public void login() throws InterruptedException{
		WebElement 登陆账号 = driver.findElement(By.cssSelector("#mobile"));
		WebElement 登陆密码 = driver.findElement(By.cssSelector("#pass"));
		WebElement 确认登陆 = driver.findElement(By.cssSelector("#login > div > div.fill_con.center-block > a"));
		登陆账号.clear();
		登陆账号.sendKeys("13457718147");
		登陆密码.clear();
		登陆密码.sendKeys("123456");
		确认登陆.click();
		Thread.sleep(2000);
	}
	
	
	@Test
	public void 批改任务() throws Exception{
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
	
	public void message(String msg) throws InterruptedException{
		((JavascriptExecutor) driver).executeScript("alert("+msg+")"); 
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
}
