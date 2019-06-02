package Basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserBasedAlerts {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		
		driver.findElement(By.xpath("//div/button[contains(.,'Try it')]")).click();
		
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		System.out.println("alert text : "+alert.getText());
		alert.accept();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//div/button[contains(.,'Try it')]")).click();
		//Thread.sleep(2000);
		//alert.dismiss();
		
		 
		 driver.quit();
	

	}

}
