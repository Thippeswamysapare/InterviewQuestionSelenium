package Basics;

   
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggesions {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("selenium ");//entering search text
		
		List <WebElement> searchList=  driver.findElements(By.xpath("//ul/li[@role='presentation']"));
		 
		int count=searchList.size();
		System.out.println(searchList.get(3).getText());
		System.out.println("Total autosuggetions are "+count);
		 
		driver.quit();
	   	
	}

}
