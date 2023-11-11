package intrTrainingSeleniumWithRahul.Ressources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoty {

	
	
	
 	public static ExtentReports getReportObject() {

	String path = System.getProperty("user.dir") + "\\reports\\index.html";

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);

	reporter.config().setReportName("Automation result");

	reporter.config().setDocumentTitle("automatic test");

	ExtentReports	extent = new ExtentReports();

	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "MKahla");
	return extent;
}	
	
	
	
	
	
	
	
	
	
}
