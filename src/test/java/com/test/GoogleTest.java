package com.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.banking.pageobjects.GooglePageObjects;
import com.banking.resources.BasePage;
import com.banking.resources.Browser;

public class GoogleTest extends BasePage {
	@Test
	public void search(){
		Logger logger =LogManager.getLogger(GoogleTest.class);
		logger.info("GoogleTest-Search test");
	
		GooglePageObjects obj=PageFactory.initElements(Browser.getBrowserObject(),GooglePageObjects.class);
		softAssert.assertEquals("test", "test");
		softAssert.assertEquals("Test", "TesT","Both Values DOnot Match");
		softAssert.assertNotEquals("actual", "actual", "Both values are same so its a fail");
		softAssert.assertEquals(true, false, "Expected both as true but its not");
		softAssert.assertSame(1, 2, "Both are not same");
		softAssert.assertTrue(false, "Result not as expected");
		softAssert.assertNull("Some String", "Object is NULL");
		
		
		obj.searchInGoogle("apple");
		//obj.searchInGoogle("banana");
		//obj.searchInGoogle("blue berry");
		
		softAssert.assertAll();
	}
	
}
