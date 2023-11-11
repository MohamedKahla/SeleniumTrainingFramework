package intrTrainingSeleniumWithRahul;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import intrTrainingSeleniumWithRahul.TestComponenet.BaseTest;
import intrTrainingSeleniumWithRahul.pageObject.CardPage;
import intrTrainingSeleniumWithRahul.pageObject.CheckOutPage;
import intrTrainingSeleniumWithRahul.pageObject.LandingPage;
import intrTrainingSeleniumWithRahul.pageObject.Orderpage;
import intrTrainingSeleniumWithRahul.pageObject.SubmitOrder;
import intrTrainingSeleniumWithRahul.pageObject.productCatalogue;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class StandAlonetest extends BaseTest {

	String selectedItemName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> map) throws InterruptedException, IOException {
		// Log into the application using email and password provided by HashMap method
		// .
		productCatalogue productCat = landingPage.login(map.get("email"), map.get("password"));
		// Add the desired product to the cart. "productName" provided by HashMap method
		productCat.addProductToCard(map.get("productName"));

		CardPage card = productCat.goToCardpage();
		// "productName" provided by HashMap method
		Boolean verifyMatching = card.verifyProductmatching(map.get("productName"));
		Assert.assertTrue(verifyMatching);

		CheckOutPage checkOut = card.goToCheckOutPage();

		SubmitOrder subOrder = checkOut.validateOrder("tunisia");

		subOrder.verifyMatchingHeaderText();
		Thread.sleep(5000L);
	}

	@Test(dependsOnMethods = "submitOrder", groups = { "purchasing" })
	public void checkSubmittedorder() throws InterruptedException, IOException {

		productCatalogue productCat = landingPage.login("kahlouchmamado@gmail.com", "MEDKHL@ssw0rd");
		Orderpage orderPage = productCat.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrdermatching(selectedItemName));
		Thread.sleep(5000L);

	}

	/*
	 * @DataProvider public Object[][] getData () { Object [] [] obj = new Object []
	 * [] {{"kahlouchmamado@gmail.com", "MEDKHL@ssw0rd", "ADIDAS ORIGINAL"} ,
	 * {"Testname@gmail.com", "MEDKHL@ssw0rd", "ZARA COAT 3"}}; return obj; }
	 */

	/**
	 * Data provider method that provides sets of test data for the 'submitOrder'
	 * test method.
	 * 
	 * @return A 2D Object array containing HashMaps with test data.
	 * @throws IOException
	 */
	/*
	 * @DataProvider public Object[][] getData () { // Creating a HashMap for the
	 * first set of test data. HashMap<String, String> map1 = new HashMap<String,
	 * String>(); map1.put("email", "kahlouchmamado@gmail.com");
	 * map1.put("password", "MEDKHL@ssw0rd"); map1.put("productName",
	 * "ADIDAS ORIGINAL"); // Creating a HashMap for the second set of test data.
	 * HashMap<String, String> map2 = new HashMap<String, String>();
	 * map2.put("email", "Testname@gmail.com"); map2.put("password",
	 * "MEDKHL@ssw0rd"); map2.put("productName", "ZARA COAT 3");
	 * 
	 * // Returning a 2D Object array containing the test data. return new Object []
	 * [] {{map1} , {map2}};
	 * 
	 * }
	 */

	/**
	 * DataProvider method to fetch test data from a JSON file. This method reads
	 * data from the specified JSON file and returns it in a format suitable for a
	 * TestNG test method.
	 * 
	 * @return Object[][] - A 2D array containing test data fetched from the JSON
	 *         file.
	 * @throws IOException In case of file reading or parsing errors.
	 */

	@DataProvider
	public Object[][] getData() throws IOException {
		// Fetch the test data from the JSON file using the getJsonDataToMap method.
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\intrTrainingSeleniumWithRahul\\Data\\Purshaseorder.json");
		// Create a 2D object array and populate it with the first and second sets of
		// test data from the list.
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	/**
	 * Captures a screenshot of the current browser window state using Selenium. The
	 * screenshot is saved to the "Reports" directory with the given test case name.
	 *
	 * @param testCaseName Name of the test case for which the screenshot is taken,
	 *                     used as the filename.
	 * @return File A reference to the saved screenshot file.
	 * @throws IOException In case of file I/O errors.
	 */

}
