package Basics;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners (Basics.ListenerImplements.class)
class Listenerexample1 
{
	@Test(priority=2)
	void Print1()
	{
		System.out.println("Print 1 and priority 2");
	}
	@Test(priority=1)
	void print2()
	{
		System.out.println("Print 2 and priotity 1");
	}
	
	@Test(invocationCount=2 ,priority=3,dependsOnMethods="print2")
	void print3()
	{
		System.out.println("Print3 statement prints 2 times");
	}
	
	@Test(enabled=false)
	void enablePrint()
	{
		System.out.println("Skipped method.....");
	}
	
	@Parameters({"city","cityname"})
	@Test(priority=4)
	void parameterizedMethod(String city,String cityname) throws InterruptedException
	{
		Reporter.log("City is "+city,true);
		Reporter.log("city name is "+cityname,true);
	}
	
}
