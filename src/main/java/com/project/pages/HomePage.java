package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	@FindBy(xpath="//input[@type='submit']")
	public WebElement findFlightsButton;
	
	public WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectDeparture(String city){
		Select selectDepar = new Select(driver.findElement(By.name("fromPort")));
		selectDepar.selectByVisibleText(city);
	}
	
	public void selectDestination(String city){
		Select selectDepar = new Select(driver.findElement(By.name("toPort")));
		selectDepar.selectByVisibleText(city);
	}
}
