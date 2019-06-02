package datadrivenframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeScript2
{	
	WebDriver driver;
	
	@BeforeMethod
	void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}
	@Test(priority=2 ,enabled=false)
	void print1()
	{
		System.out.println("Priority is 2 for method Print-1");
		
	}
	@Test(priority=1  ,enabled=false)
	void print2()
	{
		System.out.println("Priority is 1 for print-2 method");
	}
	
	@Test(priority=1 )
	void print3()
	{
		System.out.println("Prioiry1 for group A");
	}
	
//	@Parameters({"slno", "name"})
//	@Test
//	void parametersTest(@org.testng.annotations.Optional String slno,@org.testng.annotations.Optional String name)
//	{
//		System.out.println("SLNo is "+slno);
//		System.out.println("Name is "+name);
//	}
//	
//	
	
	@Test(dataProvider="dataprovider")
	void dataFromDataProvider1( String slno, String countryName)
	{
		System.out.println("Slno is "+slno);
		System.out.println("Country name is "+countryName);
	}
	
	@Test(dataProvider="dataprovider")
	void dataFromDataProvider2( String slno, String countryName)
	{
		System.out.println("Slno is "+slno);
		System.out.println("Country name is "+countryName);
	}
	
	@DataProvider(name="dataprovider")
	public Object[][] getDataForDataProvider(Method m)
	{
		//Object[][]=null;
		if(m.getName().equalsIgnoreCase("dataFromDataProvider1"))
		{
		return new Object[][]
				{
					{"1","India"},{"2","Austrlia"}
				};
		}		
		else if(m.getName().equalsIgnoreCase("dataFromDataProvider2"))
		{
			return new Object[][]
					{
						{"3","India"},{"3","Austrlia"}
					}; 
		}
		return null;
		 
			
		
	}
	
	
	
	
	
	
	@AfterMethod
	void endTest()
	{
		driver.quit();
	}
	
}
