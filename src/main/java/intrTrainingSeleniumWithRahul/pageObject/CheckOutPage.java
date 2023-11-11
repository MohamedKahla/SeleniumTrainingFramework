package intrTrainingSeleniumWithRahul.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath  = "//div[@class='form-group']/input[@class='input txt text-validated']")
	WebElement countryField;

	@FindBy(css   = "section.ta-results")
	WebElement SearchedCountry;
	
	By SearchedCountry2 = By.cssSelector("section.ta-results");
	
	@FindBy(xpath  = "//button[@class='ta-item list-group-item ng-star-inserted']")
	WebElement SelectCountry;
	
	@FindBy(xpath  = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	
	public SubmitOrder validateOrder (String	countryName	) throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.sendKeys(countryField, "tunisia").build().perform();
		waitForElementToAppear(SearchedCountry);
		SelectCountry.click();
		submit.click();
		SubmitOrder subOrder = new SubmitOrder(driver);
		return subOrder;
	}
	
	
	
	
	
	
	
	
}
