package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> extentest = new ThreadLocal<ExtentTest>();
	
	private ExtentReportManager() {
	}
	
	public static void initReports() {
		if(extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/testreports/Extentreport.html");
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
	}
	
	public static void createTest(String testname) {
		ExtentTest test = extent.createTest(testname);
		extentest.set(test);
	}
	public static ExtentTest getTest() {
		return extentest.get();
	}
	
	public static void flushReport() {
		if(extent!= null) {
			extent.flush();
		}
	}
}
