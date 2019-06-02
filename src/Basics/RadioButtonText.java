package Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	public class RadioButtonText {

		public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		List<WebElement> radiobtn=driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		
		 for (int i=0;i<radiobtn.size();i++)
		 {
			 WebElement ele=radiobtn.get(i);
			 
			 String value=ele.getAttribute("value");
			// String color=ele.getCssValue("value");
			 System.out.println("radio button value ..."+value);

			 
			 
			 if(value.equalsIgnoreCase("JAVA"))
			 {
				 ele.click();
			}
		 }
		 
		 List<WebElement> checkbx=driver.findElements(By.xpath("//input[@type='checkbox']"));
		 
		 for (int i=0;i < checkbx.size() ;i++)
		 {
			 WebElement we=checkbx.get(i);
			 String chkbxid=we.getAttribute("id");
			 if(chkbxid.equalsIgnoreCase("code"))
			 {
				 we.click();
				 
				 break;
			 }
		 }

		 
	}

}
