package com.project.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeatureOneStepDefs {
	
	public WebDriver driver;
	SoftAssert assertion = new SoftAssert();

	@After
	public void afterscenario() {
		driver.close();
	}
	
	@Given("user is in login screen of gmail")
	public void oen() throws InterruptedException {

		System. setProperty("webdriver.chrome.driver","D:\\skriptmateWS\\CucumberProject\\Drivers\\chromedriver.exe");
	
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
        System.out.println("ia m in one");
	}
	
	@When("user enters email id")
	public void two() throws InterruptedException {
		System.out.println("ia m in when");
	}

	
	
	@Then("user able to click on next button")
	public void three() throws Exception {
		System.out.println("i am in then");
		throw new Exception();
	//	assertion.assertTrue(false, "first scenario");
		//assertion.assertAll();
	}

	@Given("user is in login screen of gmail1")
	public void four() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.youtube.com");

	//	driver.navigate().to("https://www.youtube.com");
//		System. setProperty("webdriver.chrome.driver","D:\\skriptmateWS\\CucumberProject\\Drivers\\chromedriver.exe");
//	
//		driver = new ChromeDriver();
//		driver.get("https://www.gmail.com");
		System.out.println("i am in four");
	}
	
	@When("user enters email id1")
	public void five() throws InterruptedException {
		System.out.println("ia m in when");
	}

	
	
	@Then("user able to click on next button1")
	public void six() throws InterruptedException {
		System.out.println("i am in then");
	}

	
}
