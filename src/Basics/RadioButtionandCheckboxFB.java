package Basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtionandCheckboxFB {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		List<WebElement> radioButton=driver.findElements(By.xpath("//input[@type='radio']"));
		//System.out.println(femaleRadioButton.isDisplayed());
		//System.out.println(femaleRadioButton.isEnabled());
		//System.out.println(femaleRadioButton.isSelected());
	 
		for (int i=0;i<radioButton.size();i++)
		{
			WebElement ele=radioButton.get(i);
			System.out.println((ele.getAttribute("value")));
		}
		
		Thread.sleep(4000);
		driver.quit();

	}

}
