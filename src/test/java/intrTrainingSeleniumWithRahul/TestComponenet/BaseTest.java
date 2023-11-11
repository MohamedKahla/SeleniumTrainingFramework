package intrTrainingSeleniumWithRahul.TestComponenet;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import intrTrainingSeleniumWithRahul.pageObject.LandingPage;

public class BaseTest {

	public	WebDriver driver;
	public LandingPage landingPage;
	/**
     * This method is used to initialize the WebDriver based on browser preference set in a properties file.
	 * @return 
     * @throws IOException if there's an issue reading the properties file.
     */
	public WebDriver  initilizeDriver () throws IOException
	{
		 // Create a new Properties object to load configurations from a file.
		Properties prop = new Properties();
		// Creating a file input stream to read the properties file.
        // System.getProperty("user.dir") fetches the project's root directory.
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\intrTrainingSeleniumWithRahul\\Ressources\\GlobalData.properties");
		 // Loading properties from the input stream into the prop object.
		prop.load(fls);
		
		 /**
	     this code is the same of ( if, else )
	     if System.getProperty("browser") not null: so execute System.getProperty("browser") -- take the browser name entred from cmd commande
	     else if System.getProperty("browser") null: so execute prop.getProperty("browser") -- take browser name from Json file
	     System.getProperty("browser"): to use the "browser" value sent via cmd
	     prop.getProperty("browser") : to Retrieving the desired browser's name from the properties JSON file.
	     */
		 String browserName =	System.getProperty("browser") != null ? System.getProperty("browser") :prop.getProperty("browser");
				
		// Checking the browser name and initializing the respective WebDriver.
		if ( browserName.contains("chrome")   )
			{
		    // Create a new instance of ChromeOptions to configure Chrome-specific settings.
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "\\Users\\MED\\Documents\\chromedriver.exe");
			// Check if the user wants to run Chrome in headless mode.
		    // Headless mode allows the browser to run without a graphical user interface.
			if (browserName.contains("headless") )
			{
				// run Chrome in headless mode.
				options.addArguments("headless");
			}
			// Initialize the ChromeDriver with the specified options.
			driver = new ChromeDriver(options);
			// Set the size of the browser window to 1440x900.
			driver.manage().window().setSize(new Dimension(1440, 900)); // execute in full screen
			}
		else if ( browserName.equals("edge")  )
			{
			System.setProperty("webdriver.chrome.driver", "\\Users\\MED\\Documents\\msedgedriver.exe");
			driver = new EdgeDriver();
			}
		
		else if ( browserName.equals("Firefox")  )
		{
		//set Firefox configuration
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	/**
	 * A utility method to import test data from a specified JSON file and convert it into a List of HashMaps.
	 */
	public List<HashMap<String, String>> getJsonDataToMap (String	filePath	) throws IOException
	{
		 // Read the content of the JSON file into a string.
	String jsonContent =	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8 );
		
		// Initialize the Jackson ObjectMapper. This is used to convert between Java objects and JSON representation.
		// concert Json to HashMap
		ObjectMapper mapper = new ObjectMapper();
		 // Convert the JSON string content into a List of HashMaps. The TypeReference helps in specifying	
		// the complex type for deserialization.
		List<HashMap<String, String>> data =	mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {}) ;
		// Return the deserialized data.
		return data;
	}
	
	
	
	/**
	 * This method initializes the WebDriver, launches the application's landing page, 
	 * and returns an instance of the LandingPage class to interact with it.
	 * 
	 * @return LandingPage - An object representing the landing page of the application.
	 * @throws IOException - If there is an error during the driver initialization.
	 */
	@BeforeMethod
	public LandingPage lunchApplication () throws IOException
		{
		// Initialize the WebDriver based on the browser preference from the properties file.
		driver = initilizeDriver ();
		 // Create a new LandingPage object with the initialized driver.
		landingPage = new LandingPage(driver);
		// Navigate to the application's landing page using the goToUrl() method.
		landingPage.goToUrl();
		// Return the LandingPage object for further interactions.
		return landingPage;
		}
	
	@AfterMethod
	public void closeBrowser () throws InterruptedException
	{
		Thread.sleep(4000L);	
		driver.close();
	}
	
			
	public String getScreenShotOfFailedTest (String testCaseName, WebDriver driver) throws IOException
	{
	// Create an instance of TakesScreenshot for the current driver to capture the screenshot.
	TakesScreenshot	 screenshot =	(TakesScreenshot)driver;
	 // Use the getScreenshotAs method to capture the screenshot and store it in a temporary file.
	File source =	screenshot.getScreenshotAs(OutputType.FILE);
	// Define the destination file path. The screenshot will be saved in the "Reports" directory 
    // with the test case name as its filename.
	File file = new	File(System.getProperty("user.dir")+"\\Reports\\" +  testCaseName + ".png");
	 // Use FileUtils to copy the temporary screenshot to the desired location.
	FileUtils.copyFile(source, file);
	// Return a reference to the saved screenshot file.
	return System.getProperty("user.dir")+"\\Reports\\" +  testCaseName + ".png";
	
	}
			
	

	
	
	
	

}
