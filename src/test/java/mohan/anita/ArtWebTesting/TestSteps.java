package mohan.anita.ArtWebTesting;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class TestSteps {
	ChromeDriver driver;
	WebDriverWait wait;
	String search;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_URL);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();	
	}
	
	
	@Given("^I navigate to the home page$")
	public void i_navigate_to_the_home_page() {
		driver.manage().window().maximize();
		driver.get(Constants.HOME_PAGE_URL);
	}

	@When("^I click on the search bar$")
	public void i_click_on_the_search_bar() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickSearchBar();
	}

	@When("^I enter a \"([^\"]*)\"$")
	public void i_enter_a(String arg1) {
		search = arg1;
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.enterSearchTerm(arg1);
	}

	@When("^I click the search button$")
	public void i_click_the_search_button() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickSearchButton();
	}

	@Then("^I should see a table of results$")
	public void i_should_see_a_table_of_results() {
	HomePage home = PageFactory.initElements(driver, HomePage.class);
	WebElement searchTable = home.returnSearchTable();
	assertTrue(searchTable.isDisplayed());
	
	}

}
