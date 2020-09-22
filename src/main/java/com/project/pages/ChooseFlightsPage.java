package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChooseFlightsPage extends BasePage {

	@FindBy(xpath="//input[@type='submit']")
	public WebElement chooseFlightButton;
	
	//public WebDriver driver;
	public ChooseFlightsPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
}
