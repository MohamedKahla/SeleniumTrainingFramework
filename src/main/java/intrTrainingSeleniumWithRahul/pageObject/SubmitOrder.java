package intrTrainingSeleniumWithRahul.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class SubmitOrder extends AbstractComponent {

	WebDriver driver;

	public SubmitOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(className   = "hero-primary")
	WebElement header;
	
	String expectedText = "THANKYOU FOR THE ORDER.";
	
	public String getHeaderText ()
	{
	String actualText =	header.getText();
	return actualText;
	}
	
	public void verifyMatchingHeaderText ()
	{
		Assert.assertEquals(getHeaderText (), expectedText);
	}
	
}
