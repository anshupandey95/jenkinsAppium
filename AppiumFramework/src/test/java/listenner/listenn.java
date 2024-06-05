package listenner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.FormPage;

public class listenn implements ITestListener{

	Logger loggger = LogManager.getLogger(listenn.class);
	ExtentTest test;
	
	  ExtentReports extent = ExtentReportt.getReport();

	public void onTestStart(ITestResult result) {
		//ExtentReportt.getReport();
		
		test = extent.createTest(result.getMethod().getMethodName());
	    
	  }

	
	  public void onTestSuccess(ITestResult result) {
		  test.log(Status.INFO, "Test Passed");
	    
	  }

	  
	  public void onTestFailure(ITestResult result) {
		 
		  test.fail(result.getThrowable());
		 
	    
	  }

	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	 
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	 
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public void onStart(ITestContext context) {
	   
	  }

	  
	  public void onFinish(ITestContext context) {
		  File logFile = new File("logs/application.log");
	        if (logFile.exists()) {
	            String logContent = null;
				try {
					logContent = FileUtils.readFileToString(logFile, "UTF-8");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	            // Append log content to Extent report
	            test.log(Status.INFO, "<pre>" + logContent + "</pre>");
	        } else {
	            test.log(Status.WARNING, "Log file not found");
	        }
		  extent.flush();
	    
	  }
}


