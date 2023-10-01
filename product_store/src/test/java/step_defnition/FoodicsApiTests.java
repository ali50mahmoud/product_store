package step_defnition;




import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.testng.Assert;


public class FoodicsApiTests {
	
	
	 private Response response;

	    @Given("the base URL is {string}")
	    public void setBaseURL(String baseURL) {
	        RestAssured.baseURI = baseURL;
	    }

	    @Given("the email is {string}")
	    public void setEmail(String email) {
	        // Implement code to set email (if needed)
	    }

	    @Given("the password is {string}")
	    public void setPassword(String password) {
	        // Implement code to set password (if needed)
	    }

	    @Given("the token is {string}")
	    public void setToken(String token) {
	        // Implement code to set token (if needed)
	    }

	    @When("I make a POST request to {string}")
	    public void makePostRequest(String endpoint) {
	        // Assuming email and password are set as background data
	    	 response = RestAssured.given()
	                 .contentType("application/json")
	                 .body("{\n" +
	                         "  \"email\": \"merchant@foodics.com\",\n" +
	                         "  \"password\": \"123456\",\n" +
	                         "  \"token\": \"Lyz22cfYKMetFhKQybx5HAmVimF1i0xO\"\n" +
	                         "}")
	                 .post("https://pay2.foodics.dev/cp_internal/login");
	    }

	    @When("I make a GET request to {string}")
	    public void makeGetRequest(String endpoint) {
	        // Assuming the token is set as background data
	    	 response = RestAssured.given()
	                .contentType("application/json")
	                .header("Authorization", "Bearer Lyz22cfYKMetFhKQybx5HAmVimF1i0xO")
	                .get("https://pay2.foodics.dev/cp_internal/whoami");

	    }
	    @When("I make a GET req to {string}")
	    public void makeGetReq(String endpoint) {
	    	// Assuming the token is set as background data
	    	 
	    	        // Create a request object
	    	    response = RestAssured.given()
	    	                .contentType("application/json")
	    	                .header("Authorization", "Bearer Lyz22cfYKMetFhKQybx5HAmVimF1i0xO")
	    	                .post("https://pay2.foodics.dev/cp_internal/logout");
	    	
	    }

	    @Then("the response status code should be {int}")
	    public void verifyStatusCode(int expectedStatusCode) {
	        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
	    }

}
