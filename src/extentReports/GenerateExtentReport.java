package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GenerateExtentReport 
{
	ExtentHtmlReporter reporter=new ExtentHtmlReporter("./extentreports/reports.html");
	ExtentReports extent=new ExtentReports();
	
}
 