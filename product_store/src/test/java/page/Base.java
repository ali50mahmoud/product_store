package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import step_defnition.Hooks;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class Base {
	
	
	JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

	public void hit_signup() throws InterruptedException {
		final By hit_signup = By.xpath("//a[.='Sign up']");
		final By u_name = By.xpath("//input[@id='sign-username']");
		final By pass = By.xpath("//input[@id='sign-password']");
		final By signUp_btn = By.xpath("//button[.='Sign up']");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(hit_signup));
		Hooks.driver.findElement(hit_signup).click();

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(u_name));
		Hooks.driver.findElement(u_name).sendKeys("ccccyxxx");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(pass));
		Hooks.driver.findElement(pass).sendKeys("test123");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(signUp_btn));
		Hooks.driver.findElement(signUp_btn).click();

		// Hooks.driver.switchTo().frame(0);
		Thread.sleep(1000);
		Hooks.driver.switchTo().alert().accept();

	}

	public void hit_Login() throws InterruptedException {
		final By hit_login = By.xpath("//a[.='Log in']");
		final By login_name = By.xpath("//input[@id='loginusername']");
		final By login_pass = By.xpath("//input[@id='loginpassword']");
		final By Login_btn = By.xpath("//button[.='Log in']");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(hit_login));
		Hooks.driver.findElement(hit_login).click();

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(login_name));
		Hooks.driver.findElement(login_name).sendKeys("ccccyxxx");

		
		Hooks.driver.findElement(login_pass).sendKeys("test123");

		
		Hooks.driver.findElement(Login_btn).click();
		Thread.sleep(1000);

	}
	
	 public void CheckListedCat_hasItems() throws InterruptedException {
			final By click_laptops = By.xpath("//a[.='Laptops']");
			Hooks.driver.findElement(click_laptops).click();
			Thread.sleep(1000);
			final By item = By.xpath("//h4[.='Sony vaio i5']");

		 
		 	new WebDriverWait(Hooks.driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(item));
		 	WebElement TextOfItem = Hooks.driver.findElement(item);
		 	assertEquals(TextOfItem.getText(), "Sony vaio i5");
			System.out.println("THE LISTED CATEGORIES ALREADY HAS ITEMS"  );

		 }

	public void Add_item() throws InterruptedException {
		final By select_category = By.xpath("//a[.='Phones']");
		final By select_item = By.xpath("//a[.='Samsung galaxy s6']");
		final By add_toCart = By.xpath("//a[.='Add to cart']");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(select_category));
		Hooks.driver.findElement(select_category).click();

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(select_item));
		Hooks.driver.findElement(select_item).click();

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(add_toCart));
		Hooks.driver.findElement(add_toCart).click();

		Thread.sleep(1000);
		Hooks.driver.switchTo().alert().accept();

	}
	
	
	public static By hit_cart = By.xpath("//a[@id='cartur']");

	public void Remove_item() throws InterruptedException {

		final By delete_item = By.xpath("//a[.='Delete']");

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(hit_cart));
		Hooks.driver.findElement(hit_cart).click();

		new WebDriverWait(Hooks.driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfElementLocated(delete_item));
		Hooks.driver.findElement(delete_item).click();

	}
	
	public void Checkout_item() throws InterruptedException {
		final By hit_Home = By.xpath("//a[.='Home (current)']");
		final By place_order = By.xpath("//button[@class='btn btn-success']");
		final By name = By.xpath("//input[@id='name']");
		final By country = By.xpath("//input[@id='country']");
		final By city = By.xpath("//input[@id='city']");
		final By credit_card = By.xpath("//input[@id='card']");
		final By month = By.xpath("//input[@id='month']");
		final By year = By.xpath("//input[@id='year']");
		final By purchace_btn = By.xpath("//button[.='Purchase']");
		
		
        Hooks.driver.findElement(hit_Home).click();

		Add_item();
		
        Hooks.driver.findElement(hit_cart).click();
        
        Hooks.driver.findElement(place_order).click();
        Thread.sleep(1000);
        
        Hooks.driver.findElement(name).sendKeys("rrrr");
        Hooks.driver.findElement(country).sendKeys("rrrr");
        Hooks.driver.findElement(city).sendKeys("rrrr");
        Hooks.driver.findElement(credit_card).sendKeys("rrrr");
        Hooks.driver.findElement(month).sendKeys("rrrr");
        Hooks.driver.findElement(year).sendKeys("rrrr");
		
        
        Hooks.driver.findElement(purchace_btn).click();
     
		
	}
	
	 public void Validate_Successful_Checkout() throws InterruptedException {
			final By checkout = By.xpath("//h2[.='Thank you for your purchase!']");
			
		 	new WebDriverWait(Hooks.driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(checkout));
		 	WebElement CheckoutText = Hooks.driver.findElement(checkout);
		 	assertEquals(CheckoutText.getText(), "Thank you for your purchase!");
			System.out.println("THANK YOU FOR YOUR PURCHASE!"  );
			
			final By ok_btn = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
			Thread.sleep(1000);
			Hooks.driver.findElement(ok_btn).click();

	 }
}
