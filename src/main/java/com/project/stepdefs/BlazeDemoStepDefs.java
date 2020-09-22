package com.project.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.project.pages.ChooseFlightsPage;
import com.project.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlazeDemoStepDefs {
	

	public WebDriver driver;
	private HomePage homePage;
	private ChooseFlightsPage chooseFlightsPage;
	SoftAssert assertion = new SoftAssert();

	@After
	public void afterscenario() {
		driver.close();
	}
	
	@Given("user is in home screen of blaze demo")
	public void oen() throws InterruptedException {

		System. setProperty("webdriver.chrome.driver","E:\\GitRepos\\new\\CucumberProject\\Drivers\\chromedriver.exe");
	
		driver = new ChromeDriver();
		
		homePage= new HomePage(driver);
		chooseFlightsPage = new ChooseFlightsPage(driver);
		driver.get("https://blazedemo.com/");
        System.out.println("ia m in one");
	}
	
	@And("user selects departure city and destination city and find flights")
	public void two() throws InterruptedException {
		System.out.println("ia m in when");

		
		homePage.selectDeparture("Boston");
		homePage.selectDestination("Rome");

		homePage.findFlightsButton.click();
		
	}

	@Then("user is navigated to flights list screen")
	public void three() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(chooseFlightsPage.chooseFlightButton.isDisplayed(),"Not navigated to Choose Flights page");
		softAssert.assertAll();
	}

	
}
