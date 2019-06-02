package Basics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplements  implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test execution starts...");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test executes sucessfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test execution failure");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test execution failed but percentage is reached");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test case execution is sucess and details are "+context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test case execution is finished and details are "+context.getName());
		
	}

}
  