package listenner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportt {
	
static ExtentReports extent;
	
	public static ExtentReports getReport() {
	String path = 	"C:\\Users\\pc\\eclipse-workspace\\AppiumFramework\\Reportss";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path) ;
	reporter.config().setReportName("WorkOverSolutions");
	reporter.config().setDocumentTitle("TestResults");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
	
	
	

	}

}
