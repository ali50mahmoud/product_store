package step_defnition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Base;

public class steps {

	Base base = new Base();

	@Given("user Registered and logged in into demoblaze.com")
	public void user_registered_and_logged_in_into_https_www_demoblaze_com() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Hooks.driver.navigate().to("https://www.amazon.eg/");

		WebElement elementToHover = Hooks.driver.findElement(By.xpath("//div[.='AR']"));
		Actions actions = new Actions(Hooks.driver);
		actions.moveToElement(elementToHover).build().perform();

		Hooks.driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//i[@class='icp-radio']")).click();

//	    base.hit_signup();
		base.hit_Login();

		Thread.sleep(2000);

	}

	@When("I open the left menu")
	public void openLeftMenu() {
		// Implement steps to open the left menu (locate elements by XPath)
		WebElement leftMenuButton = Hooks.driver.findElement(By.xpath("//span[@class='hm-icon-label']"));
		leftMenuButton.click();
	}

	@When("I click on a category and choose a sub-category")
	public void clickCategoryAndSubCategory() throws InterruptedException {
		// Implement steps to click on a category and sub-category (locate elements by
		// XPath)
		Hooks.driver.findElement(By.xpath("//a[.='see all']")).click();
		Hooks.driver.findElement(By.xpath("//div[.='Video Games']")).click();
		Thread.sleep(2000);

		Hooks.driver.get("https://www.amazon.eg/-/en/gp/browse.html?node=18022560031&ref_=nav_em_vg_all_0_2_16_2");
		Thread.sleep(1000);

	}

	@When("I add a filter from the left side")
	public void addFilterFromLeftSide() throws InterruptedException {
		// Implement steps to add a filter from the left side (locate elements by XPath)
		Hooks.driver.findElement(By.xpath("//div[@id='s-refinements']//a[1]/span[.='Free Shipping']")).click();
		Thread.sleep(1000);

	}

	@When("I add another filter from the left side")
	public void addAnotherFilterFromLeftSide() {
		// Implement steps to add another filter from the left side (locate elements by
		// XPath)
		Hooks.driver.findElement(By.xpath("//span[.='New']")).click();
	}

	@When("I open the sort menu on the right side and sort by a specific option")
	public void sortBySpecificOption() {
		// Implement steps to open the sort menu and sort by a specific option (locate
		// elements by XPath)
		WebElement sortMenu = Hooks.driver.findElement(
				By.xpath("//span[@class='a-button-text a-declarative'][contains(.,'Sort by:Bestselling')]"));
		sortMenu.click();

		WebElement sortingOption = Hooks.driver
				.findElement(By.xpath("//a[@tabindex='-1'][contains(@id,'2')][contains(.,'Price: High to Low')]"));
		sortingOption.click();
	}

	@When("I add all products with a cost below a certain amount to the cart")
//	    public void addProductsToCart() {
//	    	boolean foundPriceLessThan15000 = false;
//
//	    	while (!foundPriceLessThan15000) {
//	    	    List<WebElement> priceElements = Hooks.driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
//
//	    	    for (WebElement element : priceElements) {
//	    	        String priceText = element.getText();
//	    	        int priceValue = Integer.parseInt(priceText.replace(",", ""));
//
//	    	        if (priceValue < 15000) {
//	    	            // Click on the price element
//	    	            element.click();
//
//	    	            // Add to cart (assuming "Add to Cart" is an accessible button)
//	    	            Hooks.driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
//
//	    	            foundPriceLessThan15000 = true;
//	    	            break;  // Exit the loop as we found a price less than 15000
//	    	        }
//	    	    }
//
//	    	    if (!foundPriceLessThan15000) {
//	    	    	String xpath = "//a[@aria-label='Go to page 2']";
//
//	    	    	// Find the element and click it
//	    	    	WebElement nextPageButton = Hooks.driver.findElement(By.xpath(xpath));
//	    	    	nextPageButton.click();
//	    	        
//	    	        if (nextPageButton.isEnabled()) {
//	    	            nextPageButton.click();
//	    	        } else {
//	    	            break;  // Exit the loop if there's no next page
//	    	        }
//	    	    }
//	    	}

//	    }

	 public void addProductsToCart() {
        boolean foundPriceLessThan15000 = false;

        while (!foundPriceLessThan15000) {
            List<WebElement> priceElements = Hooks.driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));

            for (WebElement element : priceElements) {
                String priceText = element.getText().replace(",", "").replace(".", ""); // Clean the text

                try {
                    int priceValue = Integer.parseInt(priceText);

                    if (priceValue < 15000) {
                        // Click on the price element
                        element.click();

                        // Add to cart (assuming "Add to Cart" is an accessible button)
                        Hooks.driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

                        foundPriceLessThan15000 = true;
                        break; // Exit the loop as we found a price less than 15000
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where priceText cannot be parsed as an integer
                    System.out.println("Skipping invalid price: " + priceText);
                }
            }

            if (!foundPriceLessThan15000) {
              //  String nextPageXPath = String.format("//a[@aria-label='Go to next page, page %d']");
//            	int wildcardValue = -1; // Use -1 as a placeholder for the integer value
            	WebElement nextPageButton = Hooks.driver.findElement(By.cssSelector(".s-pagination-next"));
            	nextPageButton.click();


                if (nextPageButton.isEnabled()) {
                    nextPageButton.click();
                } else {
                    break; 
                }
                }
            }
        
        Hooks.driver.navigate().back();
        Hooks.driver.navigate().back();
	}
	// ...
	
	
//	public void addProductsToCart() {
//	    int i = 1; // Initialize the page number
//
//	    while (true) { // Outer loop to repeat the process
//	        boolean foundPriceLessThan15000 = false;
//
//	        while (!foundPriceLessThan15000) {
//	            List<WebElement> priceElements = Hooks.driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));
//
//	            for (WebElement element : priceElements) {
//	                String priceText = element.getText().replace(",", "").replace(".", ""); // Clean the text
//
//	                try {
//	                    int priceValue = Integer.parseInt(priceText);
//
//	                    if (priceValue < 15000) {
//	                        // Click on the price element
//	                        element.click();
//
//	                        // Add to cart (assuming "Add to Cart" is an accessible button)
//	                        Hooks.driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
//
//	                        foundPriceLessThan15000 = true;
//	                        break; // Exit the loop as we found a price less than 15000
//	                    }
//	                } catch (NumberFormatException e) {
//	                    // Handle the case where priceText cannot be parsed as an integer
//	                    System.out.println("Skipping invalid price: " + priceText);
//	                }
//	            }
//
//	            if (!foundPriceLessThan15000) {
//	                String nextPageXPath = String.format("//a[@aria-label='Go to next page, page %d']", i);
//	                List<WebElement> nextPageButtons = Hooks.driver.findElements(By.xpath(nextPageXPath));
//
//	                // Check if there's a "Next Page" button
//	                if (!nextPageButtons.isEmpty()) {
//	                    // Click the first "Next Page" button
//	                    nextPageButtons.get(0).click();
//	                    i++; // Increment the page number
//	                } else {
//	                    break; // Exit the loop if there's no next page button
//	                }
//	            }
//	        }
//
//	        // Go back two steps in the browser
//	        Hooks.driver.navigate().back();
//	        Hooks.driver.navigate().back();
//
//	        // Check if there's another page to continue the outer loop or exit
//	        String nextPageXPath = String.format("//a[@aria-label='Go to next page, page %d']", i);
//	        List<WebElement> nextPageButtons = Hooks.driver.findElements(By.xpath(nextPageXPath));
//	        if (nextPageButtons.isEmpty()) {
//	            break; // Exit the outer loop if there's no more next page
//	        }
//	    }
//	}


	@When("I make sure all products are added to the cart")
	public void verifyProductsInCart() {
		// Implement verification logic to ensure products are added to the cart (locate
//		// elements by XPath)
//		List<WebElement> cartItems = Hooks.driver.findElements(By.xpath("//div[@class='cart-item']"));
//		assert cartItems.size() > 0;
	}

	@When("I add my address and choose a payment method")
	public void addAddressAndChoosePaymentMethod() {
		// Implement steps to add address and choose a payment method (locate elements
		// by XPath)
//		WebElement addressField = Hooks.driver.findElement(By.xpath("//input[@id='address']"));
//		addressField.sendKeys("Your Address Here");
//
//		Select paymentMethodDropdown = new Select(Hooks.driver.findElement(By.xpath("//select[@id='payment-method']")));
//		paymentMethodDropdown.selectByVisibleText("Cash");
	}

	@Then("I verify that the total amount, including any fees, is correct")
	public void verifyTotalAmount() {
//		WebElement totalAmountElement = Hooks.driver.findElement(By.id("total-amount"));
//		WebElement baseTotalElement = Hooks.driver.findElement(By.id("base-total")); // Replace with the actual ID
//		WebElement shippingFeeElement = Hooks.driver.findElement(By.id("shipping-fee")); // Replace with the actual ID
//
//		double totalAmountWithShipping = Double.parseDouble(totalAmountElement.getText().replace("$", ""));
//		double baseTotalAmount = Double.parseDouble(baseTotalElement.getText().replace("$", ""));
//		double shippingFee = Double.parseDouble(shippingFeeElement.getText().replace("$", ""));
//
//		double expectedTotalAmount = baseTotalAmount + shippingFee;
//
//		// Use Assert.assertTrue with a custom error message
//		Assert.assertTrue(Math.abs(expectedTotalAmount - totalAmountWithShipping) <= 0.001);

	}

}
