package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/iframe-practice-page");
		
		WebElement ifremeEle=driver.findElement(By.xpath("//iframe[@name='iframe1']"));
		Thread.sleep(3000);
		driver.switchTo().frame(ifremeEle);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abc");
		
		//List<WebElement> InteractionsLinks=driver.findElements(By.xpath("//aside[@class='widget']/h3[@text()='Interactions']/ul/li"));
		//System.out.println("Count is "+InteractionsLinks.size());
		
				Thread.sleep(3000);
		
		
		
		 

	}

}
