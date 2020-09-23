package com.project.api;

import java.util.ResourceBundle;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class SpaceXStepDefs {

	RestAssuredWrapper restAssuredWrapper = new RestAssuredWrapper();
	SoftAssert softAssert = new SoftAssert();
	
	@Given("I have GET API")
	public void givenGetAPI() throws InterruptedException {
		
		restAssuredWrapper.setUri("https://api.spacexdata.com/v4/launches/latest");

	}
	
	@When("I send GET request")
	public void sendGetAPI() throws InterruptedException {
		
		restAssuredWrapper.sendRequest("Get", RestAssured.given());

	}

	@Then("Response code is 200")
	public void validateResponseCode() throws InterruptedException {
		System.out.println("Response code is : \n"+restAssuredWrapper.response.asString());
		softAssert.assertTrue(restAssuredWrapper.response.getStatusCode()==200,"Status code is not 200");
	}

	
}
