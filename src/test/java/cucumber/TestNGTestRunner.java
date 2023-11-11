package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//Annotations that provide Cucumber options for the execution
@CucumberOptions (
		 // Specifies the path to the Cucumber feature files
		features = "C:\\Users\\MED\\Desktop\\eclipse\\SeleniumTrainingFramework\\src\\test\\java\\cucumber",
		// Specifies the path to the step definitions
		glue = "stepDefenitions", 
		// Makes console output readable for the human eye
		monochrome = true, 
		// Specifies the plugin for report generation; in this case, an HTML report is generated
		plugin = {"html:target\\cucumber.html"} )
		//Class definition that extends the TestNG support for Cucumber
	public class TestNGTestRunner	extends AbstractTestNGCucumberTests	 {

	// Empty class body. The annotations and class extension above handle the execution.
	

}
//tags ="@ErrorValidation" ,