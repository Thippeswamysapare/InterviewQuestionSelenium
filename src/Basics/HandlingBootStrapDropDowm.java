package Basics;

 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootStrapDropDowm {

	public static void main(String[] args) throws InterruptedException
	{
	 

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/bootstrap/bootstrap_dropdowns.asp");
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		List <WebElement> ddlist=driver.findElements(By.xpath("//div[@class='dropdown open']//ul//a[@role='menuitem']"));
		
		for(WebElement element : ddlist)
		{
			System.out.println(element.getText());
			if(element.getText().contains("CSS"))
			{
				Thread.sleep(3000);
				element.click();
				break;
			}
		}
		
		driver.quit();
		
		
		
	}

}
