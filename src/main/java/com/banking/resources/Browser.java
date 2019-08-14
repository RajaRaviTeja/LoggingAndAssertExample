package com.banking.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Browser {

	public static WebDriver driver;
	public static BufferedReader bReader;
	public static Properties props;
	public static SoftAssert softAssert = new SoftAssert();
	
	
	public static Logger log= Logger.getLogger(Browser.class);
	
	
	public  static WebDriver getBrowserObject() {
		log.info("getBrowserObject");
		System.out.println("-------------------Create BrowserObject-----------------------------");
	    System.out.println(Constants.BROWSERNAME);
		
		
		if ((Constants.BROWSERNAME).equals("chrome")){
		
		if (null == driver) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVERPATH);
			driver = new ChromeDriver();
			}
		driver.manage().window().maximize();
		}
		
		return driver;
	}

	public static String getProperty(String key) {
		if(null==bReader){
			System.out.println("brreader created");
		try {
			
			bReader = new BufferedReader(new FileReader(new File("./src/main/resources/config.properties")));
			props = new Properties();
			props.load(bReader);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return props.getProperty(key);

	}

	public void logOut(){
			driver.findElement(By.xpath("//font[contains(text(),'Sign Off')]")).click();
	}
	

	public void tearDown() {
		try {
            bReader.close();
			props.clear();
		  
 		driver.quit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
