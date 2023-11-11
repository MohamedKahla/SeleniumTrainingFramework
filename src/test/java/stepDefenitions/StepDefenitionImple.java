package stepDefenitions;

import java.io.IOException;

import org.testng.Assert;

import intrTrainingSeleniumWithRahul.TestComponenet.BaseTest;
import intrTrainingSeleniumWithRahul.pageObject.CardPage;
import intrTrainingSeleniumWithRahul.pageObject.CheckOutPage;
import intrTrainingSeleniumWithRahul.pageObject.LandingPage;
import intrTrainingSeleniumWithRahul.pageObject.SubmitOrder;
import intrTrainingSeleniumWithRahul.pageObject.productCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefenitionImple extends BaseTest {

	public  LandingPage landingPage;
	public productCatalogue productCat;
	public CheckOutPage checkOut;
	public SubmitOrder subOrder;
		
		
	@Given("User landed on e-commerce page")
	public void User_landed_on_ecommerce_page() throws IOException {

		landingPage = 	lunchApplication();
	}

	@Given("^User connected with valid (.+) and (.+)$")
	public void User_connected_with_valid_email_and_password(String email, String password) throws IOException {
		productCat = landingPage.login(email, password);
	}

	@When("^User added product (.+) to card$")
	public void User_added_productName_to_card(String productName) throws InterruptedException {
		productCat.addProductToCard(productName);
	}

	@When("^Check out (.+) and submit the order$")
	public void Check_out_productName_submit_the_order(String productName) throws InterruptedException {
		CardPage card = productCat.goToCardpage();
		Boolean verifyMatching = card.verifyProductmatching(productName);
		Assert.assertTrue(verifyMatching);
		checkOut = card.goToCheckOutPage();
		subOrder = checkOut.validateOrder("tunisia");
	}

	@Then("Rederection to order confirmation page with header {string}")
	public void Rederection_to_order_confirmation_page_with_header_THANK_YOU_FOR_THE_ORDER(String string )
			throws InterruptedException {
			subOrder.verifyMatchingHeaderText();
			driver.close();
	}
			
	@Then("{string} message is displayed")
	public void Icorrect_email_or_password_message_is_displayed (String string )
			throws InterruptedException {
		Assert.assertEquals(string , landingPage.getErrorMessage()); 
			driver.close();
	}
	

}
