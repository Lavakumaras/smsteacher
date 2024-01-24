package com.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerClass implements ITestListener  {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
	//test script execution strart from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+ "   ---> Execution started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+ "  Passed" );
		Reporter.log(MethodName+ "   ---> Executed successfully",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
	
		try {
			String path= WebDriverUtils.captureScreenshot(BaseClass.sdriver, MethodName);
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, MethodName+"  Failed");
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(MethodName+ " ---> Failed",true);
		
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"  skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+ " ---> Skipped",true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		//configure report
	ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\extentReport\\reprt.html");
	htmlReport.config().setDocumentTitle("SMS Project");
	htmlReport.config().setTheme(Theme.STANDARD);
	htmlReport.config().setReportName("SMS");
	
	report = new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base plotform", "OS");
	report.setSystemInfo("Base Browser", "Chrome");
	report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Student_Management_System/view/login.php");
	report.setSystemInfo("Reporter Name", "Lava Kumar");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
