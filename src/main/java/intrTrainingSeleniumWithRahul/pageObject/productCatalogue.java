package intrTrainingSeleniumWithRahul.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import intrTrainingSeleniumWithRahul.AbstractComponent.AbstractComponent;

public class productCatalogue extends AbstractComponent {

	WebDriver driver;

	public productCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath  = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> listOfProducts;
	
	By addToCardButton = By.xpath(".//div[@class='card-body']/button[@class='btn w-10 rounded']");
	
	@FindBy(id = "toast-container")
	WebElement toastMessage;
	
	@FindBy(xpath  = "//div[@class='footer']/following-sibling::ngx-spinner")
	WebElement spinner;
	
	public List<WebElement> getListOfProducts ()
	{
		return listOfProducts;
	}
	
	
	public WebElement getProductByName (String selectedItemName  )
	{
		 WebElement selectedProduct =	listOfProducts.stream().filter(P-> P.findElement(By.tagName("h5")).getText().equals(selectedItemName) ).findFirst().orElse(null);
		 return selectedProduct;
	}
	
	public void addProductToCard (String	selectedItemName	) throws InterruptedException
	{
		Thread.sleep(4000L);
		getProductByName(selectedItemName).findElement(addToCardButton).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	
}
