package intrTrainingSeleniumWithRahul.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import intrTrainingSeleniumWithRahul.pageObject.CardPage;
import intrTrainingSeleniumWithRahul.pageObject.Orderpage;

public class AbstractComponent {

	WebDriver driver;
	
	@FindBy(xpath  = "//button[@routerlink='/dashboard/cart']")
	WebElement cardButton;
	
	@FindBy(xpath  = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	
	public CardPage goToCardpage ()
	{
		cardButton.click();
		CardPage card = new CardPage(driver);
		return card;
	}
	
	public Orderpage goToOrderPage ()
	{
		orderButton.click();
		Orderpage order = new Orderpage(driver);
		return order;
	}
	
	
	public void waitForElementToAppear(WebElement waitedElement)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(waitedElement));
	}

	
	public void waitForElementToDisappear(WebElement waitedElement)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(waitedElement));
	}
	
	
}
