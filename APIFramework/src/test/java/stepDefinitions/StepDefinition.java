package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import POJOClass.POJOClasses_GoogleAPI;
import POJOClass.POJOClasses_GoogleAPI_location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestdataBuild;
import resources.Utils;

public class StepDefinition extends Utils {
	RequestSpecification Request;
	ResponseSpecification Resposnespec;
	Response Response;
	TestdataBuild Body = new TestdataBuild();
	static String place_id_value;
	
	@Given("Add place payload with {string} {string} {string}")
	public void place_payload_with(String name, String language, String address) throws IOException 
	{
		Request  = given().spec(RequestSpecification()).log().all().body(Body.addPlacePayload(name, language, address));
	}
	
	@When("User calls {string} place API with {string} http request")
	public void user_calls_place_api_with_http_request(String resource, String operation) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources res = APIResources.valueOf(resource);
		System.out.println(res.getresource());
		
		if(operation.equalsIgnoreCase("POST")) 
		Response = Request.when().post(res.getresource());
		else if(operation.equalsIgnoreCase("GET")) 
		Response = Request.when().get(res.getresource());
		
	}
	
	@Then("API call is successful with a status code {int} response")
	public void api_call_is_successful_with_a_status_code_response(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	assertEquals(Response.statusCode(),200);
	}
	
	@Then("The {string} is response body is {string}")
	public void the_is_response_body_is(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
		//assertEquals(JS.get(key).toString(),value);
		assertEquals(getJson(Response, key),value);
	}
		
	@Then("Verify if {string} created maps to the {string} using {string}")
	public void verify_if_place_id_created_maps_to_the_using(String place_id, String expectedname, String resource) throws IOException {
	place_id_value = getJson(Response, place_id);
	Request  = given().spec(RequestSpecification()).queryParam(place_id, place_id_value);
	user_calls_place_api_with_http_request(resource,"GET");
	System.out.println("Response "+Response.toString());
	assertEquals(getJson(Response,"name"),expectedname);
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		Request  = given().spec(RequestSpecification()).body(Body.Deletepayload(place_id_value));
	}
	
}
