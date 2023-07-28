package com.raghib.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTesting {

	public static void main(String[] args) throws InterruptedException {
		
		boolean valueIsSelected, valueIsDisplayed, valueIsEnabled;
		WebElement element, element1, element2;
		List <WebElement> allCheckboxes;
		String checkboxValue;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Duration duration = Duration.ofSeconds(30);		
		driver.manage().timeouts().implicitlyWait(duration);
		
		driver.get("http://www.echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
		
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
	    driver.quit();
	}
}
