package datadrivenframework;

 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PracticeScripts
{
	WebDriver driver=new FirefoxDriver();
	@Test
	void selectItemsTesting()
	{
	
	WebElement ele=driver.findElement(By.xpath(""));
	Select selectItem=new Select(ele);
	List<WebElement> list=selectItem.getOptions();
	selectItem.selectByIndex(1);
	selectItem.selectByValue("value");
	selectItem.selectByVisibleText("Jan");
	
	for(WebElement ele1:list)
	{
		System.out.println(ele1.getText());
	}
	
	}
	
	
	
	@Test
	void selectItemBootStrapDD()
	{
		//first find the BootStrap DD element and then click on the element.
		//after this take all the list of DD items in List<WebElement>
	}
	
	
	@Test
	void selectRadioNutton()
	{
		List<WebElement> radiobtns=driver.findElements(By.xpath(""));
		
		for(WebElement radio:radiobtns)
		{
			if(radio.getText().contains("female"))
			{
				radio.click();
				break;
			}
		}
				
	}
	
	
	@Test
	void selectCheckBox()
	{
		List<WebElement> checkBox=driver.findElements(By.xpath(""));
		for(WebElement chkbox:checkBox)
		{
			if(chkbox.getText().contains("value"))
			{
				chkbox.click();
				break;
			}
		}
	}
	
	@Test
	void handiligAlerts()
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
		alt.dismiss();
		alt.sendKeys("abc");
		alt.getText();
	
	}
	
	@Test 
	void windowsHandling()
	{
		String parentBrowser=driver.getWindowHandle();
		
		Set<String> childBrowser=driver.getWindowHandles();
		int totalChildBrowser=childBrowser.size();
		
		for(String child :childBrowser)
		{
			if(!parentBrowser.equalsIgnoreCase(child))
			{
				driver.close();
			}
		}
		driver.switchTo().window(parentBrowser);
		
		// close any browser		
		Set<String> allChildBrowsers=driver.getWindowHandles();

		ArrayList<String> allChildBr=new ArrayList(allChildBrowsers);
	 
		driver.switchTo().window(allChildBr.get(1));
		driver.switchTo().window(allChildBr.get(0));//parent window
			
	}
	
	@Test 
	void mouseHoverHandling()  //we use Actions class
	{
		Actions act=new Actions(driver);
		act.click(null);
		act.contextClick();//right click
		act.doubleClick();
		act.dragAndDrop(null, null);
		
	}
	
	
	@Test
	void windowOperations()
	{
	driver.navigate().to("url");
	driver.navigate().refresh();
	driver.navigate().back();
	driver.navigate().forward();
	
	Dimension d=new Dimension(300,450);
	driver.manage().window().setSize(d);
	
	Point p=new Point(400,440);
	driver.manage().window().setPosition(p);
	
		
	
	
	}
	
	
	@Test
	void frames()
	{	WebElement ele=driver.findElement(By.xpath(""));
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame name");
		driver.switchTo().frame(ele); //web element
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();//frame to page
		
	}
	
	
	@Test
	void javaScriptExecutorExample() //it is an interface
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('someid').value='some value';");
		js.executeScript("document.getElementById('someid').value='';");
		js.executeScript("document.getElementById('someid'.click());");
		js.executeScript("document.getElementById('someid').checked=flase;" ); //handle check box
		js.executeScript("alert('Welcome to selenium');"); //alter msg
		js.executeScript("windows.location='https://google.com';"); // Navigate to diffrent page
		
		
	}

	@Test
	void takeScreenShot() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("d:\\driver");
		FileUtils.copyFile(src, dst);
		
	}
	
	@Test
	void DDFGetCellValue(String fileExtention,String sheetName) throws IOException
	{
		Workbook wb=null;
		Sheet sheet;
		File file=new File("D:\\PracticingSelenium\\InterviewQuestionSelenium\\excel\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(file);
		if(fileExtention.equalsIgnoreCase(".xlsx"))
		{
			wb=new XSSFWorkbook(fis);
			
		}
		else
		{
			wb=new HSSFWorkbook(fis);
		}
		
		sheet=wb.getSheet(sheetName);
		int totalRow=sheet.getLastRowNum();
		
		for(int i=1;i<=totalRow;i++)
		{
			Row r=sheet.getRow(i);
			long totalCells=r.getLastCellNum();
			
			for (int j=0;j<totalCells;j++)
			{
				Cell cellNum=r.getCell(j);
				String cellValue=cellNum.getStringCellValue();
				System.out.println(cellValue);
				
			}
		}
	}
	
	@Test
	void DDFWriteDataToCell() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("filepath");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("sheetname");
		Row r=sheet.createRow(0);
		Cell c=r.createCell(0);
		c.setCellValue("manager");
		FileOutputStream fos=new FileOutputStream("file path");
		wb.write(fos);
		wb.close();
		
	}
}
