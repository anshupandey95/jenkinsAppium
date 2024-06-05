package listenner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.util.concurrent.Service.Listener;

import Utils.CommonUtilForIOS_ANDROID;
import io.appium.java_client.AppiumDriver;

public class newListen extends CommonUtilForIOS_ANDROID implements ITestListener {
	  private ExtentReports extent = ExtentReportt.getReport();
	    private Logger logger = LogManager.getLogger(newListen.class);

	    public void onTestStart(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        logger.info("Test started: " + result.getMethod().getMethodName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        test.log(Status.PASS, "Test Passed");
	        logger.info("Test passed: " + result.getMethod().getMethodName());
	        appendLogsToReport(test); // Append logs to the extent report
	        extent.flush(); // Flush the extent report after logging the test result
	    }

	    public void onTestFailure(ITestResult result) {
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        test.log(Status.FAIL, "Test Failed");
	        test.fail(result.getThrowable());
	        logger.error("Test failed: " + result.getMethod().getMethodName());
	        appendLogsToReport(test); // Append logs to the extent report
	        extent.flush(); // Flush the extent report after logging the test result
	    }

	    public void onTestSkipped(ITestResult result) {
	        // Not implemented
	    }

	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not implemented
	    }

	    public void onTestFailedWithTimeout(ITestResult result) {
	        onTestFailure(result);
	    }

	    public void onStart(ITestContext context) {
	        // Not implemented
	    }

	    public void onFinish(ITestContext context) {
	        // Not implemented
	    }

	    private void appendLogsToReport(ExtentTest test) {
	        File logFile = new File("logs/application.log");
	        if (logFile.exists()) {
	            try {
	                String logContent = FileUtils.readFileToString(logFile, "UTF-8");
	                // Append log content to Extent report
	                test.log(Status.INFO, "<pre>" + logContent + "</pre>");
	            } catch (IOException e) {
	                logger.error("Error reading log file", e);
	            }
	        } else {
	            test.log(Status.WARNING, "Log file not found");
	        }
	    }
	}


