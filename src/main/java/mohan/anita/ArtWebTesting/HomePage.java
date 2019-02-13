package mohan.anita.ArtWebTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	@FindBy(id = "searchTerm")
	private WebElement searchBar;
	
	@FindBy(xpath = "/html/body/nav/div/div[1]/form/button")
	private WebElement searchButton;
	
	@FindBy(id = "searchresultsTable")
	private WebElement searchresults;
	
	
	public void clickSearchBar() {
		searchBar.click();
	}
	
	public void enterSearchTerm(String searchTerm){
		searchBar.sendKeys(searchTerm);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	public String returnSearchResultsText() {
		return searchresults.getText();
	}
	public WebElement returnSearchTable() {
		return searchresults;
	}

}
