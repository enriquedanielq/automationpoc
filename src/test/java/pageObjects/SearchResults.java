package pageObjects;

import base.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResults extends BasePage{
	
	By searchResultItems = By.cssSelector("[data-component-type='s-search-result']");
	By itemName = By.cssSelector("h2 span");
	By itemPrice = By.cssSelector(".a-price:not([data-a-color='secondary'])");
	
	public SearchResults(WebDriver driver) {
		super(driver);
	}
	
	public void selectFilter(String text) {
		driver.findElement(By.xpath("//li[contains(*,'" + text + "')]//input")).click();
	}
	
	public Map<String, Float> searchResultsMap() {
		List<WebElement> results = driver.findElements(searchResultItems);
		
		 Map<String, Float> resultsMap = new HashMap<String, Float>();
		 for(WebElement e : results) {
			 resultsMap.put(e.findElement(itemName).getText(), Float.parseFloat(e.findElement(itemPrice).getText()));
	     }
	        
	     return resultsMap;
	}

}
