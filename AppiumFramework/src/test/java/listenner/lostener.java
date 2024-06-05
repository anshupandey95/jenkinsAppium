package listenner;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.CommonUtilForIOS_ANDROID;
import io.appium.java_client.AppiumDriver;

public class lostener extends CommonUtilForIOS_ANDROID  implements   ITestListener{
	AppiumDriver driver;

	private Logger logger = LogManager.getLogger(listenn.class);
    private ExtentReports extent = ExtentReportt.getReport();
    private ExtentTest test;

    public void onTestStart(ITestResult result) {
    	
    	
    	
    	clearLogFile();
    	
        test = extent.createTest(result.getMethod().getMethodName());
        logger.info("Test started: " + result.getMethod().getMethodName());
       
    }

    public void onTestSuccess(ITestResult result) {
    	
    	
        test.log(Status.PASS, "Test Passed");
        logger.info("Test passed: " + result.getMethod().getMethodName());
        appendLogsToReport();
    }

    public void onTestFailure(ITestResult result) {
    	
    	
    	
        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getThrowable());
        logger.error("Test failed: " + result.getMethod().getMethodName());
        appendLogsToReport();
       

        
        
       
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
        // not implemented
    }

    public void onFinish(ITestContext context) {
        // not implemented
    }

    private void appendLogsToReport() {
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
        extent.flush();
    }
    
    
    
    private void clearLogFile() {
        File logFile = new File("logs/application.log");
        if (logFile.exists()) {
            try {
                FileUtils.write(logFile, "", "UTF-8");
                logger.info("Log file cleared");
            } catch (IOException e) {
                logger.error("Error clearing log file", e);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}














































//
//try {
//	driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//} catch (IllegalArgumentException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (IllegalAccessException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (NoSuchFieldException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//} catch (SecurityException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//test.log(Status.FAIL, "Test Failed");
//test.fail(result.getThrowable());
//logger.error("Test failed: " + result.getMethod().getMethodName());
//appendLogsToReport();
//try {
//	//test.add
//	test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
//} catch (IOException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();

