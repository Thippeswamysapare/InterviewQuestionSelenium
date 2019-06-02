package Basics;

 import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownMenu {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		WebElement ele=driver.findElement(By.id("month"));
		Select selectMonth=new Select(ele);
		System.out.println(selectMonth.isMultiple());
		
		List <WebElement> ddlist=selectMonth.getOptions();
		int count=ddlist.size();
		//selectMonth.selectByIndex(8);
		//selectMonth.selectByValue(4);
		selectMonth.selectByVisibleText("Dec");
			
		for (WebElement element:ddlist)
		{
			String value=element.getText();
			System.out.println(value);
		}
		/*
		for (int i=0;i< count;i++)
		{
		System.out.println(ddlist.get(i).getText());
		}
		
		System.out.println();
		*/
		Thread.sleep(3000);
		driver.quit();
		 

	}
 
	

}
