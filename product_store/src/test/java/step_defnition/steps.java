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
	        // Implement steps to click on a category and sub-category (locate elements by XPath)
	      Hooks.driver.findElement(By.xpath("//a[.='see all']")).click();
	      Hooks.driver.findElement(By.xpath("//div[.='Video Games']")).click();
	    	 Thread.sleep(2000);
	    	// Assuming 'driver' is your WebDriver instance

	    	// Switch to the frame using its ID or name
//	    	 Hooks.driver.switchTo().frame("DAsis");

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
	        // Implement steps to add another filter from the left side (locate elements by XPath)
	    	Hooks.driver.findElement(By.xpath("//span[.='New']")).click();
	    }

	    @When("I open the sort menu on the right side and sort by a specific option")
	    public void sortBySpecificOption() {
	        // Implement steps to open the sort menu and sort by a specific option (locate elements by XPath)
	        WebElement sortMenu = Hooks.driver.findElement(By.xpath("//span[@class='a-button-text a-declarative'][contains(.,'Sort by:Bestselling')]"));
	        sortMenu.click();

	        WebElement sortingOption = Hooks.driver.findElement(By.xpath("//a[@tabindex='-1'][contains(@id,'2')][contains(.,'Price: High to Low')]"));
	        sortingOption.click();
	    }

	    @When("I add all products with a cost below a certain amount to the cart")
	    public void addProductsToCart() {
	    	boolean foundPriceLessThan15000 = false;

	    	while (!foundPriceLessThan15000) {
	    	    List<WebElement> priceElements = Hooks.driver.findElements(By.xpath("(//span[@class='a-price-whole'])"));

	    	    for (WebElement element : priceElements) {
	    	        String priceText = element.getText();
	    	        int priceValue = Integer.parseInt(priceText.replace(",", ""));

	    	        if (priceValue < 15000) {
	    	            // Click on the price element
	    	            element.click();

	    	            // Add to cart (assuming "Add to Cart" is an accessible button)
	    	            Hooks.driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

	    	            foundPriceLessThan15000 = true;
	    	            break;  // Exit the loop as we found a price less than 15000
	    	        }
	    	    }

	    	    if (!foundPriceLessThan15000) {
	    	    	String xpath = "//a[contains(@aria-label,'Next')]";

	    	    	// Find the element and click it
	    	    	WebElement nextPageButton = Hooks.driver.findElement(By.xpath(xpath));
	    	    	nextPageButton.click();
	    	        // If no price was less than 15000, click the next page button
//	    	        WebElement nextPageButton = Hooks.driver.findElement(By.xpath("//*[text()='Next']"));
	    	        if (nextPageButton.isEnabled()) {
	    	            nextPageButton.click();
	    	        } else {
	    	            break;  // Exit the loop if there's no next page
	    	        }
	    	    }
	    	}

	          
	    }

	    @When("I make sure all products are added to the cart")
	    public void verifyProductsInCart() {
	        // Implement verification logic to ensure products are added to the cart (locate elements by XPath)
	        List<WebElement> cartItems = Hooks.driver.findElements(By.xpath("//div[@class='cart-item']"));
	        assert cartItems.size() > 0;
	    }

	    @When("I add my address and choose a payment method")
	    public void addAddressAndChoosePaymentMethod() {
	        // Implement steps to add address and choose a payment method (locate elements by XPath)
	        WebElement addressField = Hooks.driver.findElement(By.xpath("//input[@id='address']"));
	        addressField.sendKeys("Your Address Here");

	        Select paymentMethodDropdown = new Select(Hooks.driver.findElement(By.xpath("//select[@id='payment-method']")));
	        paymentMethodDropdown.selectByVisibleText("Cash");
	    }

	    @Then("I verify that the total amount, including any fees, is correct")
	    public void verifyTotalAmount() {
	    	
	    	 WebElement totalAmountElement = driver.findElement(By.id("total-amount"));
                 double totalAmountWithShipping = Double.parseDouble(totalAmountElement.getText().replace("$", ""));
                 double expectedTotalAmount = baseTotalAmount + shippingFee;
                 assertEquals(expectedTotalAmount, totalAmountWithShipping);
	    }

   

}
