package intrTrainingSeleniumWithRahul.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class CardPage extends AbstractComponent {

	WebDriver driver;

	public CardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath  = "//p[@class='itemNumber']/following-sibling::h3")
	List<WebElement> itemsAdded;
	
	@FindBy(xpath  = "//li[@class='totalRow']/button")
	WebElement checkOutButton;
	
	public Boolean verifyProductmatching (String selectedItemName)
	{
	Boolean match =	itemsAdded.stream().anyMatch(item -> item.getText().equalsIgnoreCase(selectedItemName));
		return match;
	}
	
	
	public CheckOutPage goToCheckOutPage ()
	{
		checkOutButton.click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}
	
	
}
