package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ThankYouPage extends BasePage {

	@FindBy(xpath="//h1[contains(text(),'Thank you for your purchase today!')]")
	public WebElement thankyoumessage;
	
	public WebDriver driver;
	public ThankYouPage(WebDriver driver){
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
