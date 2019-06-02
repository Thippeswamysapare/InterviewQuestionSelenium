package listerners;

import org.junit.Assert;
import org.testng.annotations.Test;

import analyzer.RetryAnalyzer;

public class MyTestCases 
{

	@Test  //(retryAnalyzer=analyzer.RetryAnalyzer.class)
	void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	void test2()
	{
		Assert.assertEquals(false, true);
	}
	
	
}
