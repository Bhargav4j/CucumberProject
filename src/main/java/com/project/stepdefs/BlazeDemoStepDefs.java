package com.project.stepdefs;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;

import com.project.pages.ChooseFlightsPage;
import com.project.pages.HomePage;
import com.project.pages.PurchasePage;
import com.project.pages.ThankYouPage;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlazeDemoStepDefs {
	

	
	public static WebDriver driver;
	private HomePage homePage;
	private ChooseFlightsPage chooseFlightsPage;
	private PurchasePage purchasePage;
	private ThankYouPage thankYouPage;
	SoftAssert softAssert = new SoftAssert();
	private ResourceBundle testData;
	@After
	public void afterscenario() {
		
		softAssert.assertAll();

	}

	
	@Given("user is in home screen of blaze demo")
	public void oen() throws InterruptedException {
		testData =  ResourceBundle.getBundle("testData");

		System. setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
	//	System. setProperty("webdriver.chrome.driver","E:\\GitRepos\\new\\CucumberProject\\Drivers\\chromedriver.exe");
	
		driver = new ChromeDriver();
		
		homePage= new HomePage(driver);
		chooseFlightsPage = new ChooseFlightsPage(driver);
		purchasePage = new PurchasePage(driver);
		thankYouPage = new ThankYouPage(driver);
		
		driver.get("https://blazedemo.com/");
	}
	
	@And("user selects departure city and destination city and find flights")
	public void two() throws InterruptedException {
		
		homePage.selectDeparture(testData.getString("departureFrom"));
		homePage.selectDestination(testData.getString("destinationTo"));

		homePage.findFlightsButton.click();
		
	}

	@Then("user is navigated to flights list screen")
	public void three() throws InterruptedException {
		softAssert.assertTrue(chooseFlightsPage.chooseFlightButton.isDisplayed(),"Not navigated to Choose Flights page");
		chooseFlightsPage.chooseFlightButton.click();
	}

	@And("user chooses a flight and enters his details")
	public void enterdetails() throws InterruptedException {
		purchasePage.name.sendKeys("Bhargav Jagathabhi");
		purchasePage.address.sendKeys("Flat 202, Maithri Layout");
		purchasePage.city.sendKeys("Bangalore");
		purchasePage.state.sendKeys("Karnataka");
		purchasePage.zipCode.sendKeys("560066");
		purchasePage.creditCardNumber.sendKeys("1234");
		purchasePage.month.sendKeys("April");
		purchasePage.year.sendKeys("2020");
		purchasePage.nameOnCard.sendKeys("Jagathabhi Bhargav");
		purchasePage.purchaseFlightButton.click();
	}

	@Then("Thankyou page is displayed")
	public void thankYouPageValidation() throws InterruptedException {
		softAssert.assertTrue(thankYouPage.thankyoumessage.isDisplayed(),"Thank you page is not displayed");
	}

}
