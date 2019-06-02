package Basics;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingWindowHandles {

	public static void main(String[] args) throws InterruptedException {

		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		
		String parent=driver.getWindowHandle();
		System.out.println("parent window is "+parent);
		driver.findElement(By.xpath("//img[@src='https://company.naukri.com/banners2018/fis-p-120x45-30jan2018.gif']")).click();
		Set<String> allWindows=driver.getWindowHandles();
		Actions act=new Actions(driver);
		
		int numberOfOpendedWindows=allWindows.size();
		System.out.println("Total opended windows are "+numberOfOpendedWindows);
//		for(String child:allWindows)
//		{
//			if(!parent.equalsIgnoreCase(child))
//			{
//				driver.switchTo().window(child);
//				Thread.sleep(3000);
//				driver.close();
//			}
//		}
		
////		
//			ArrayList<String> list=new ArrayList(allWindows);
//			int count=list.size();
//			driver.switchTo().window(list.get(1));
//			driver.switchTo().window(list.get(2));
//			driver.switchTo().window(list.get(3));
		driver.switchTo().window(parent);
		System.out.println("title is "+driver.getTitle());
		driver.quit();
	}

}
