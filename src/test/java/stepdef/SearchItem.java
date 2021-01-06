package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchItem {
	private static WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";
	private static String searchTerm = "Dress";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("^I can open the shopping site$")
	public void i_can_open_the_shopping_site() throws InterruptedException {
		driver.get(URL);
		assertEquals("My Store", driver.getTitle());
		Thread.sleep(2000);
	}

	@When("^I search for a dress$")
	public void i_search_for_a_dress() throws InterruptedException {
		driver.findElement(By.id("search_query_top")).sendKeys(searchTerm);
	    driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
	    driver.findElement(By.cssSelector(".product_img_link")).click();
	    Thread.sleep(3000);
	    
	}

	@Then("^I can add it to my cart$")
	public void i_can_add_it_to_my_cart() throws InterruptedException {
		driver.findElement(By.cssSelector(".exclusive added")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".button-medium")).click();
	}

}
