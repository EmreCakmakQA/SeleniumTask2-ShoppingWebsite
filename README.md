# Selenium Task 2 - Shopping Website

The aim of this repo is to demonstrate the use of cucumber and selenium. The task is to automate front end testing of a demo site.

Task 2 - This website emulates a generic shopping website; think about the features that such a user might need from a website. Consider how many paths of interaction a user may have to take to achieve their intended goal. 

Write a test that will search the website for an item of clothing (e.g ‘Dress’) and assert that a particular item was found.

Cucumber takes the following format, allowing for a pseudo-code approach that adds more organisation to the code.

```
Feature: Search website for item and confirm it has been found 

Scenario: search for dress and assert it was found
	Given I can open the shopping site
	When I search for a dress
	Then I can add it to my cart

```
The *Given, When, Then* syntax makes it great for styling off of a Jira board and incorporating user stories.

In this task, the "*Given that, When*" is written as follows:

```
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

```

This allows for incorporation of Behaviour Driven Development.



