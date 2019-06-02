package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


 
public class HiddenDivisionPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
		WebElement element =driver.findElement(By.xpath("//input[@id='DepartDate']"));
		element.click();
		Thread.sleep(3000);
		
		 //String dateVal="28-03-2019";
		 //JavascriptExecutor js=((JavascriptExecutor).driver);
		 
		//driver.quit();
		
	}

}
