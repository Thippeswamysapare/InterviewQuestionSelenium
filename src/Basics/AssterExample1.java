package Basics;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssterExample1 

{
	@Test(priority=2)
	void printSelenium1()
	{
		System.out.println("Priority 2");
	}
	
	@Test(priority=1)
	void printSelenium2()
	{
		System.out.println("Priority 1");
	}
	
	@Test
	void failesTestCase()
	{
		Assert.assertTrue(false, "abz");
		Reporter.log("test case failed.....");
	}
}
