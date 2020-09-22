package com.project.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



/**
 * Created by Bhargav on 16/06/2017.
 */
public class BasePage {

	public final WebDriver driver;
	public JavascriptExecutor js;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
	
	}


	public  void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	public WebElement waitTillElementIsLoaded(WebElement elementToBeLoaded) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));

		return element;
	}
	


	public boolean isElementVisible(By by) {
		boolean isVisible = true;
		try{

			WebElement ele = (new WebDriverWait(driver, 4))
					.until(ExpectedConditions.visibilityOfElementLocated(by));

			if(ele!=null){
				isVisible = true;
				System.out.println("Element Visible");
			}else{
				isVisible = false;
				System.out.println("Element not Visible");
			}
		}catch(Exception e){
			isVisible = false;
			System.out.println("Caught Exception, Element not Visible "+e);

		}
		return isVisible;
	}


	public boolean isElementVisible(WebElement element) {
		boolean isVisible = true;
		try{

			WebElement ele = (new WebDriverWait(driver, 4))
					.until(ExpectedConditions.visibilityOf(element));

			if(ele!=null){
				isVisible = true;
				System.out.println("Element Visible");
			}else{
				isVisible = false;
				System.out.println("Element not Visible");
			}
		}catch(Exception e){
			isVisible = false;
			System.out.println("Caught Exception, Element not Visible "+e);

		}
		return isVisible;
	}


	
	public boolean isElementInVisible(By by) {
		boolean isInVisible = true;
		try{

			boolean flag = (new WebDriverWait(driver, 5))
					.ignoring(TimeoutException.class)
					.until(ExpectedConditions.invisibilityOfElementLocated(by));

			if(flag==true){
				isInVisible = true;
				System.out.println("Element Visible");
			}else{
				isInVisible = false;
				System.out.println("Element not Visible");
			}
		}catch(Exception e){
			isInVisible = false;
			System.out.println("Caught Exception, Element not Visible "+e);

		}
		return isInVisible;
	}


	public  boolean isElementPresent(By by) {
		boolean isPresent = true;
		try{

			WebElement ele = (new WebDriverWait(driver, 4))
					.until(ExpectedConditions.presenceOfElementLocated(by));
			//	.ignoring(TimeoutException.class)

			if(ele!=null){
				isPresent = true;
				System.out.println("Element present "+by.toString());
			}else{
				isPresent = false;
				System.out.println("Element not present"+by.toString());
			}
		}catch(Exception e){
			isPresent = false;
			System.out.println("Caught Exception, Element not present"+e);

		}
		return isPresent;
	}

	public void clearField(By by)
	{
		WebElement element = waitUntilElementPresent(by);


		String field = element.getAttribute("value");
		System.out.println("value of field is "+field);
		element.sendKeys(Keys.ENTER);

		for(Character ch: field.toCharArray()){

			element.sendKeys(Keys.BACK_SPACE);
		}
		element.clear();

	}

	public void signOut(){
		waitAndClickUsingJSWhenPresent(By.xpath("//a[contains(@href,'logout')]/span"));
		waitUntilElementVisible(By.xpath("//input[@id='tpxId']"));
	}


	public void clickOnElement(WebElement ele){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(ele));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);

	}

	public void waitAndClickUsingJSWhenClickable(WebElement ele){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(ele));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);

	}
	
	public void waitAndClickUsingJSWhenClickable(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(by));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);

	}
	public void waitAndClickWhenVisible(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));

		element.click();
	}
	
	public void waitAndClickUsingJSWhenPresent(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.presenceOfElementLocated(by));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);

	}
	
	
	public void waitAndClickUsingJSWhenVisible(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);

	}

	public void waitAndClickWhenClickable(WebElement ele){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(ele));


		element.click();

	}
	


	public void waitUntilElementClickable(By by){
		WebElement element=(new WebDriverWait(driver, 15))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(by));

	}

	public void waitAndClickWhenClickable(By by){
		WebElement element=(new WebDriverWait(driver, 15))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.elementToBeClickable(by));

		element.click();
	}

	public WebElement waitUntilElementVisible(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;

	}

	public Boolean isElementInvisibleWithWait(By by){
		boolean flag =(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.invisibilityOfElementLocated(by));
		return flag;

	}
	public WebElement waitUntilElementVisible(WebElement element){
		WebElement ele=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOf(element));
		return ele;

	}

	public WebElement waitUntilElementPresent(By by){
		WebElement element=(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.presenceOfElementLocated(by));

		return element;
	}
	public void waitUntilElementInvisible(By by){
		(new WebDriverWait(driver, 10))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.invisibilityOfElementLocated(by));
		
	}
	public void waitTillSpinnerDissappears()
	{
		waitUntilElementInvisible(By.cssSelector(".spinner-container"));
	//	waitUntilEleme(By.cssSelector(".spinner-container"));
	}

	public boolean isElementExists(By by) {
		boolean flag = false;
		try {
			if(driver.findElements(by).size()>0) {
				flag= true;
			}else {
				flag = false;
			}
		}catch(Exception e) {
			flag = false;
		}
		return flag;
	}

	public void clearValue(WebElement element, String vAttribute)
	{
		String vElement = element.getAttribute(vAttribute);
		System.out.println("value for clear field is "+vElement);
		if (!(vElement == null || vElement.isEmpty()))
		{
			new Actions(driver).moveToElement(element).perform();
			for(Character ch: vElement.toCharArray()){
				element.sendKeys(Keys.BACK_SPACE);
			}
		}else {
		}
	}

	public void replaceValue(WebElement element, String newString)
	{
		element.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), newString);
	}
	
	//jse.executeScript("window.scrollBy(0,250)", "");

	public void scrollDown(){
		waitTillSpinnerDissappears();
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)", "");

	}

	public void scrollIntoView(By by){
	//	WebElement element = driver.findElement(by);
		WebElement element = waitUntilElementPresent(by);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	
	
	public void scrollIntoView(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	
	
	public List<HashMap<String,String>> getTableDetails(String tableLocator){
		List<HashMap<String,String>> tableDetailsListofMaps = new ArrayList<HashMap<String,String>>();
		WebElement table;
		if(tableLocator.contains("xpath"))
			table= waitUntilElementPresent(By.xpath(tableLocator));
		else
			table = waitUntilElementPresent(By.cssSelector(tableLocator));
		
		List<String> headerList = new ArrayList<String>();
		List<WebElement> ths = table.findElements(By.cssSelector("thead tr th"));

		for(WebElement th:ths){
			headerList.add(th.getText());
		}
		System.out.println("Headers list of Notifications table is : "+headerList);
		
		List<WebElement> trs = table.findElements(By.cssSelector("tbody tr"));
		List<WebElement> tds;
		ArrayList<String> rowDetailsAsList = new ArrayList<String>();
		
		int i;
		for(WebElement tr: trs){
			HashMap<String,String> rowDetailsAsMap = new HashMap<String,String>();
			tds = tr.findElements(By.cssSelector("td"));
		    i=0;
			for(WebElement td: tds){
				//rowDetailsAsList.add(td.getText());
				rowDetailsAsMap.put(headerList.get(i), td.getText());
				i++;
			}
			System.out.println("rowDetailsAsMap  is "+rowDetailsAsMap.toString());
			tableDetailsListofMaps.add(rowDetailsAsMap);
			//rowDetailsAsList.clear();
		}
		System.out.println("tableDetailsListofMaps    in method is "+tableDetailsListofMaps.toString());
		return tableDetailsListofMaps;
	}
	

}

