package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.xpath("//button[@id='menu1']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='menu']//li/a"));
		
		
		for(WebElement element:list)
		{
			String innerhtml=element.getAttribute("innerHTML");
			System.out.println("Links are "+innerhtml);
			if(innerhtml.contains("JavaScript"))
			{
				element.click();
				break;
			}
			  
		}
		
		 	
		//System.out.println("Links are "+innerhtml);
		driver.quit();
	}

}
