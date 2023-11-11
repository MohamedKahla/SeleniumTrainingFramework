package intrTrainingSeleniumWithRahul.TestComponenet;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import intrTrainingSeleniumWithRahul.Ressources.ExtentRepoty;

public class Listeners extends BaseTest implements ITestListener {

	// Represents the current test in ExtentReports.
	ExtentTest test;
	// Represents the ExtentReports instance for reporting.
	ExtentReports extent = ExtentRepoty.getReportObject();
	// ThreadLocal instance to make ExtentTest thread-safe for parallel execution.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe

	/**
	 * Invoked when a test starts. Initializes the ExtentTest instance for
	 * reporting.
	 * 
	 * @param result - Contains information on the running test.
	 */
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		// here we have pushed the object created (test) in our Thread local
		// the object has assigned a unique thread ID
		extentTest.set(test);
	}

	/**
	 * Invoked when a test passes. Logs the success to the report.
	 * 
	 * @param result - Contains information on the passed test.
	 */
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
	}

	/**
	 * Invoked when a test fails. Captures the screenshot, logs the failure to the
	 * report, and attaches the screenshot to the report.
	 * 
	 * @param result - Contains information on the failed test.
	 */
	public void onTestFailure(ITestResult result) {
		// Log the failure details to the report.
		extentTest.get().fail(result.getThrowable());

		try {
			// Retrieve the WebDriver instance associated with the failed test.
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String filepath = null;
		try {
			// Capture the screenshot of the failure.
			filepath = getScreenShotOfFailedTest(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Attach the screenshot to the report.
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	/**
	 * Invoked after all tests in the suite are executed. Used to flush the reports,
	 * ensuring all data is written.
	 * 
	 * @param context - Contains information on the execution context.
	 */
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
