package com.lsq.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class lsqApp {
	private AndroidDriver<WebElement> driver;
    private boolean isInstall = false; 
    TouchAction touch = new TouchAction(driver);
    /**
     * 启动APP
     * @throws Exception
     */
    public void app() throws Exception{
    	DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		//设备iOS、android
		capabilities.setCapability("device", "Android");
		//模拟器名称 Android Emulator
		capabilities.setCapability("deviceName", "127.0.0.1:21501");
		//测试平台
		capabilities.setCapability("platformName", "Android");
		//系统版本
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("appPackage", "com.naodong.xgs.test");
        capabilities.setCapability("appActivity", "com.naodong.xgs.presentation.ui.LaunchActivity");
		capabilities.setCapability("sessionOverride", true); // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
//		capabilities.setCapability("unicodeKeyboard", true); // 设置键盘
//		capabilities.setCapability("resetKeyboard", false); // 设置默认键盘为appium的键盘
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);  
	      
	        //如果真机设备已经安装，则不需要重新安装  
	       	if (isInstall) {  
	            File classpathRoot = new File(System.getProperty("user.dir"));  
	            File appDir = new File(classpathRoot, "apps");  
	            File app = new File(appDir, "newgs-4.4.2.apk");  
	            capabilities.setCapability("app", app.getAbsolutePath());  
	        }  
    }
    
	@Before
	public void before() throws Exception {
			app();
			Thread.sleep(5000);
	       	login();
	}
	@Test
	public void begin(){
		System.out.println("test begining");
	}
	
	@After
	public void after() throws Exception {
		loout();
		driver.quit();
	}
	/**
	 * 登录系统
	 * @throws InterruptedException
	 */
	public void login() throws InterruptedException{
		WebElement login = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ImageView[2]"));
		login.click();
		Thread.sleep(1000);
		WebElement phone = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]"));
		phone.click();
		Thread.sleep(1000);
		WebElement username = driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.LinearLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText[1]"));
		username.clear();
		username.sendKeys("13457718147");
		WebElement userpass = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText[1]"));
		userpass.sendKeys("123456");
		WebElement submit = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textContains(\"登录\")");
		submit.click();
		Thread.sleep(5000);
		goker();
	}
	
	/**
	 * 退出系统
	 * @throws InterruptedException
	 */
	public void loout() throws InterruptedException{
		Thread.sleep(3000);
		WebElement out = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.ImageView[2]"));
		out.click();
		WebElement set = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"设置\")");
		set.click();
		WebElement over = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textContains(\"退出登录\")");
		over.click();
		Thread.sleep(1000);
	}
	
	public void goker() throws InterruptedException {
		WebElement goker = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout[1]"));
		goker.click();
		Thread.sleep(1000);
		WebElement gokercenter = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[8]"));
		gokercenter.click();
		WebElement taskCenter = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"));
		taskCenter.click();
		Thread.sleep(4000);
		List<WebElement> tasks = driver.findElements(By.xpath("//android.widget.ListView/android.widget.LinearLayout"));
		tasks.get(0).click();
		try {
			order();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		WebElement back1 = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]"));
		back1.click();
		WebElement back2 = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]"));
		back2.click();
	}
	
	/**
	 * 接单
	 */
	public void order() throws InterruptedException{
		WebElement rotat = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.Button[1]"));
		rotat.click();
		Thread.sleep(2000);
		WebElement rotating = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
		for (int i = 0; i < 2; i++) {
			rotating.click();
			Thread.sleep(1000);
		}
		WebElement save = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"保存\")");
		save.click();
		Thread.sleep(2000);
		
		for (int i = 0; i < 10; i++) {
			try {
				swipeToUp(driver, 100);
				Thread.sleep(100);
			} catch (Exception e) {
			}
		}
		Thread.sleep(5000);
		WebElement accOrder = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\").textContains(\"接收任务\")");
		accOrder.click();
		WebElement ordersure = driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\"我检查N遍了\")");
		ordersure.click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	/*
	 * 鼠标滑动
	 */
	
    public void swipeToUp(AndroidDriver<WebElement> driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
        // wait for page loading
    }
    public void swipeToDown(AndroidDriver<WebElement> driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
        // wait for page loading
    }
    public void swipeToLeft(AndroidDriver<WebElement> driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
        // wait for page loading
    }
    public void swipeToRight(AndroidDriver<WebElement> driver, int during) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
        // wait for page loading
    }
}
