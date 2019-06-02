package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 
{
	
    @Test
    void launchbrowser()
    {
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://www.google.com");
    	
    }
}
