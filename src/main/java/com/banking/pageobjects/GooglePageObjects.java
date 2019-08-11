package com.banking.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.banking.resources.BasePage;
import com.banking.resources.Constants;

public class GooglePageObjects extends BasePage {

	
	
	@FindBy(xpath="//input[@name='q']")
	public static WebElement searchbar;
	
	
	@FindBy(xpath="//div[@id='lga']")
	public static WebElement focusOut;
	
	
	
	@FindBy(xpath="//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")
	public static WebElement enterButton;
	
	
	
	public void searchInGoogle(String searchTerm){
		launch(Constants.GOOGLEURL);
		enter(searchbar, searchTerm);
		click(focusOut);
		click(enterButton);
		jsScrollToBottom();
		//jsScrollToTop();
	}
	
}
