package Basics;

import org.openqa.selenium.WebDriver;

public class driver 
{
	public WebDriver driver;
	
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver.manage().window().maximize();
	}
}
