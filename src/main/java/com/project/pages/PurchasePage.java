package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage extends BasePage {

	@FindBy(id="inputName")
	public WebElement name;

	@FindBy(id="address")
	public WebElement address;

	@FindBy(id="city")
	public WebElement city;

	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(id="zipCode")
	public WebElement zipCode;
	
	@FindBy(id="creditCardNumber")
	public WebElement creditCardNumber;

	@FindBy(id="creditCardMonth")
	public WebElement month;

	@FindBy(id="creditCardYear")
	public WebElement year;

	@FindBy(id="nameOnCard")
	public WebElement nameOnCard;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement purchaseFlightButton;

	
	
	//public WebDriver driver;
	public PurchasePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
}
