package com.banking.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BasePage {
	//Logger.class.getName()
	Logger log= LogManager.getLogger(BasePage.class);
	public static WebDriver driver=Browser.getBrowserObject();
	public static SoftAssert softAssert=Browser.softAssert;
	//public LoginPageObjects  lpObj;
	
	
	
	public void refresh(){
		driver.navigate().refresh();
		implicitwait(5);
		
	}

	public String dateAsString(){
		Date d = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("M/dd/yy");
		String expectedDate=sdf.format(d);
		return expectedDate;
		
	}
	public void checkIfElementVisible(WebElement element){
		
		boolean b=element.isDisplayed();
		
	}
	
	public   void launch(String url){
		log.info("launching url  "+url);
		driver.get(url);}
	
	public void checkIfPageTitleMatches(){
		(driver.getTitle()).trim().equals("Find a Flight: Mercury Tours:");
	}
	public String getCurrentURL(){
		return driver.getCurrentUrl();
	}
	public void enter(WebElement element,String inputData){
		element.sendKeys(inputData); }
	
	public void click(WebElement element){
		element.click();}
	
	public void jsClick(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);}
	
	public void jsDoubleClick(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].doublClick();", element);}
	
	public void jsScrollToBottom(){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");}
	
	public void jsScrollToTop(){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");}
	
	public void scrollToView(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scfrollInToView();",element);}
    
	public Select createAndGetDropDownObject(WebElement element){
		Select dropdown = new Select(element);
		return dropdown;}
	
	public void selectByVisibleText(WebElement element,String visibleText){
    	Select dropdown=createAndGetDropDownObject(element);
    	
    	
    	dropdown.selectByVisibleText(visibleText);
	    }
	
	public void selectByIndex(WebElement element,String index){
    	Select dropdown=createAndGetDropDownObject(element);
    	dropdown.selectByIndex(Integer.parseInt(index));
    	}
	
	public void implicitwait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		}
	
	public void explicitWaitForElementVisibility(WebElement element){
		WebDriverWait eWait= new WebDriverWait(driver, 10);
		WebElement ele=eWait.until(ExpectedConditions.visibilityOf(element));
	}
	public WebDriverWait getExplicitWaitObject(){
		WebDriverWait wdWait=new WebDriverWait(driver, 10);
	    return wdWait;}
	
	public void waitUntillElelemntClickable(WebElement element){
		WebDriverWait wdWait=getExplicitWaitObject();
		wdWait.until(ExpectedConditions.elementToBeClickable(element));}
	
	public void checkIfExpectedTextDisplayed(WebElement element,String expected){
		}
	
	public void checkIfTextPresent(WebElement element,String expected){
		System.out.println(element.getText().trim());
		System.out.println(expected);
		
      }
		
	
	
	
	
	
	
	
	
	
	

}
