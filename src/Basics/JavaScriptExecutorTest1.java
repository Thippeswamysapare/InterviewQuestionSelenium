package Basics;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


 

public class JavaScriptExecutorTest1
{
	@Test
	void JavaScriptExecutortest() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	//driver.manage().window().maximize();
 	Dimension d=new Dimension(500,500);
 	driver.manage().window().setSize(d);
// 	Point p=new Point(400,500);
// 	driver.manage().window().setPosition(p);
 	Thread.sleep(2000);
 	Actions act=new Actions(driver);
 	
 	
 	act.clickAndHold();
 	act.moveByOffset(700, 900);
 	driver.navigate().to("");
 	WebElement ele=driver.findElement(By.xpath(""));
 	Select select=new Select(ele);
 	
 	
 	
 	JavascriptExecutor js=(JavascriptExecutor)driver;
 	js.executeScript("window.scrollBy(300,100);");
//	
 	}
}