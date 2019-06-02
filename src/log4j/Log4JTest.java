//log4j
package log4j;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import junit.framework.Assert;

public class Log4JTest {

	  WebDriver driver;
	  Logger log=Logger.getLogger(Log4JTest.class);
	@BeforeMethod
	void setUp()
	{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	log.info("********************************");
	log.info("<----------------------------------launchin chrome browser------------------------>");
	driver=new ChromeDriver();
	driver.get("https://google.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	
	@Test
	void test1()
	{
		log.info("<----------------------------getting title of the page---------------->");
		String title=driver.getTitle();
		log.info("verifiying page title---->");
		System.out.println("Title is "+title);
		Assert.assertEquals(title, "Google");
		

	}
	
	 
	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}
}

