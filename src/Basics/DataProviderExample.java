package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExample 
{
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	void setUp(String browser)
	{
				 
		if(browser.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
			driver=new ChromeDriver();
		}
		driver.get("https://google.com");
	}
	
	 
	@Test(dataProvider="searchText")
	void getDataFromProvider(String searchKey)
	{
		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys(searchKey);
		String getValue=searchText.getAttribute("value");
		System.out.println("Get Value is "+getValue);
		Assert.assertTrue(getValue.contentEquals(searchKey));
	}
	
	
	
	@DataProvider(name="searchText")
	public Object[][] getData()
	{
		
		return new Object[][] 
		{
			{"Selenium"},{"Manual testing"}	
		};
				
		
	}
	
	@AfterMethod
	void endTesting()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.quit();
	}

}
