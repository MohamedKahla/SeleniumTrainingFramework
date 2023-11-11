package intrTrainingSeleniumWithRahul.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement login = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement loginElement;

	@FindBy(id = "userPassword")
	WebElement passwordElement;

	@FindBy(id = "login")
	WebElement loginButtonElement;
	
	@FindBy(id = "toast-container")
	WebElement errorMessage;
		
	public void goToUrl ()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public productCatalogue login (String username, String password )
	{
		loginElement.sendKeys(username);
		passwordElement.sendKeys(password);
		loginButtonElement.click();
		productCatalogue productCat = new productCatalogue (driver);
		return productCat;
		
	}
	
	public String getErrorMessage ()
	{
	waitForElementToAppear(errorMessage);	
	String error =	errorMessage.getText();
	return error;	
	}
	
	
	
}
