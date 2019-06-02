package Basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest 
{

	private static final int OutputType = 0;

	@Test
	void JSEText() throws InterruptedException, AWTException, IOException
	{
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://202.138.101.166/calllogsystem/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('txtuser').value='3693014';");
		js.executeScript("document.getElementById('txtpwd').value='Bhoomi@123';");
		//Thread.sleep(2000);
		//js.executeScript("document.getElementById('txtpwd').value='';" );
		Thread.sleep(3000);
		js.executeScript("document.getElementById('btnlgn').click();" );
		String pageTitle;
		pageTitle=js.executeScript("return document.title;").toString();
		String pageURL;
		pageURL=js.executeScript("return document.URL;").toString();
				
		System.out.println(pageTitle);
		System.out.println(pageURL);
		//driver.quit();
//		Robot r=new Robot();
//		Alert alt=driver.switchTo().alert(); 
		TakesScreenshot ts=((TakesScreenshot)driver); 
		File src=ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dst=new File("D:\\a.png");
		FileUtils.copyFile(src, dst);
		
		
		
		
		
		
//		r.keyPress(KeyEvent.VK_ALT);
//		r.keyPress(KeyEvent.VK_SPACE);
//		r.keyPress(KeyEvent.VK_N);
//		Thread.sleep(5000);
//		r.keyRelease(KeyEvent.VK_ALT);
//		r.keyRelease(KeyEvent.VK_SPACE);
//		r.keyRelease(KeyEvent.VK_N);
//		
		
	}
}