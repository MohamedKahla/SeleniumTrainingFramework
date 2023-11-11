package intrTrainingSeleniumWithRahul;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import intrTrainingSeleniumWithRahul.TestComponenet.BaseTest;
import intrTrainingSeleniumWithRahul.TestComponenet.Retry;
import intrTrainingSeleniumWithRahul.pageObject.CardPage;
import intrTrainingSeleniumWithRahul.pageObject.CheckOutPage;
import intrTrainingSeleniumWithRahul.pageObject.LandingPage;
import intrTrainingSeleniumWithRahul.pageObject.SubmitOrder;
import intrTrainingSeleniumWithRahul.pageObject.productCatalogue;

import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class FailedScenario extends BaseTest {



@Test (priority = 1 , retryAnalyzer = Retry.class   )
public void failedConnexion( ) throws InterruptedException, IOException {

		 landingPage.login("kahlouchmamado@gmail.com", "000000");
		 Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage()); 
		 Thread.sleep(5000L);
	}



@Test (priority = 2  )
public void failedAddedItemToCard( ) throws InterruptedException, IOException {


	String selectedItemName = "ADIDAS ORIGINAL";	

	productCatalogue productCat = landingPage.login("kahlouchmamado@gmail.com", "MEDKHL@ssw0rd");
	
	productCat.addProductToCard(selectedItemName);

	CardPage card =	productCat.goToCardpage();
	
	Boolean verifyMatching =	card.verifyProductmatching("ABCDD");
	Assert.assertFalse(verifyMatching);
	 Thread.sleep(5000L);
	
	}




}
