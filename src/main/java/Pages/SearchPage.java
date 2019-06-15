package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;

	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id="ui-id-1")
	WebElement productList;

	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitile;

	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}

	public void OpenproductDetailsPage() {
		clickButton(productTitile);
	}

}
