package step_defnition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Base;

public class steps {
	
	 
	
	Base base = new Base();
	
	@Given("user Registered and logged in into demoblaze.com")
	public void user_registered_and_logged_in_into_https_www_demoblaze_com() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Hooks.driver.navigate().to("https://www.demoblaze.com/");
	    base.hit_signup();
	    base.hit_Login();
	   
	    
	  
	}

	@Then("user Check the listed Categories has Items")
	public void user_check_the_listed_categories_has_items() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		    Thread.sleep(1000);
		    base.CheckListedCat_hasItems(); 
	}

	@Then("Add random item to the cart & Remove item from cart")
	public void add_random_item_to_the_cart_remove_item_from_cart() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		  base.Add_item();
			base.Remove_item();
		
	   
	}

	@When("user Complete successful checkout with random item")
	public void user_complete_successful_checkout_with_random_item() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		base.Checkout_item();
	}

	@Then("user should get successful checkout")
	public void user_should_get_successful_checkout() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 Thread.sleep(1000);
		base.Validate_Successful_Checkout();
	}

	

}
