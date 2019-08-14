package com.test;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.banking.pageobjects.GooglePageObjects;
import com.banking.resources.Browser;

public class GoogleTest2 extends Browser {

	
	@Test
	public void search(){
		//Logger logger =LogManager.getLogger(GoogleTest2.class);
		Logger logger = Logger.getLogger(GoogleTest.class);
	
		logger.info("GoogleTest-Search test2");
		 
		GooglePageObjects obj=PageFactory.initElements(Browser.getBrowserObject(),GooglePageObjects.class);
		obj.searchInGoogle("apple");
		obj.searchInGoogle("banana");
		obj.searchInGoogle("blue berry");
	}
	
}
