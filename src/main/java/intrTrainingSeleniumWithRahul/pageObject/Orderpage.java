package intrTrainingSeleniumWithRahul.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class Orderpage extends AbstractComponent {

	WebDriver driver;

	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath  = "//table/tbody/tr/td[2]")
	List<WebElement> namePeoductOeder;
	
	
	public Boolean verifyOrdermatching (String selectedItemName)
	{
	Boolean match =	namePeoductOeder.stream().anyMatch(item -> item.getText().equalsIgnoreCase(selectedItemName));
		return match;
	}
	

	
}
