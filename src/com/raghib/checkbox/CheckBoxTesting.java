package com.raghib.checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.raghib.selenium.BaseClass;

public class CheckBoxTesting extends BaseClass {

	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	
	public static String url = "http://www.echoecho.com/htmlforms09.htm";
	
	public static boolean valueIsSelected, valueIsDisplayed, valueIsEnabled;
	public static WebElement element, element1, element2;
	public static List <WebElement> allCheckboxes;
	public static String checkboxValue;
	
	public static void main(String[] args) throws InterruptedException {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
				
		element = driver.findElement(By.xpath("//input[@type='checkbox' and @value='ON'][1]"));
		valueIsSelected = element.isSelected();
		System.out.println("Is Selected : "+valueIsSelected);
		
		element1 = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Milk']"));
		valueIsDisplayed = element1.isDisplayed();
		System.out.println("Is Displayed : "+valueIsDisplayed);
		
		element2 = driver.findElement(By.xpath("//input[@type='checkbox' and @value='Butter']"));
		valueIsEnabled = element2.isEnabled();
		System.out.println("Is Enabled : "+valueIsEnabled);
		
		//Click on Checkbox	    
	    allCheckboxes =  driver.findElements(By.xpath("//input[contains(@name,'option')]"));	    
	    int size = allCheckboxes.size();	    
	    
	    for(int i = 0; i<size; i++) {	        
	    	checkboxValue = allCheckboxes.get(i).getAttribute("value");	        
	        if(checkboxValue.equalsIgnoreCase("Cheese")){	            
	        	allCheckboxes.get(i).click();
	            continue;	            
	        } else if(checkboxValue.equalsIgnoreCase("Milk")) { 
	        	allCheckboxes.get(i).click();
	            continue;
			} else if(checkboxValue.equalsIgnoreCase("Butter")) { //By Default it checked so I unchecked.
				allCheckboxes.get(i).click();
	            continue;
			}
	    }
	  //BaseClass.quitDriver();
	}
}
