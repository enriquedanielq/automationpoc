package pageObjects;

import base.BasePage;
import utilities.Actions;

import java.util.ArrayList;
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
	By resultsInfoBar = By.cssSelector("span[data-component-type='s-result-info-bar']");
	By filterCheckBox = By.xpath("//li[contains(*,'#REPLACE#')]//i");
	
	public SearchResults(WebDriver driver) {
		super(driver);
	}
	
	public boolean isSearchResultsPageVisible() {
		return Actions.isElementDisplayed(driver, resultsInfoBar);
	}
	
	public void selectFilter(String text) {
		String obj = filterCheckBox.toString().replaceAll("#REPLACE#", text).replaceAll("By.xpath: ","");
		Actions.clickElement(driver, By.xpath(obj));
	}
	
	public Map<String, String> searchResultsMap() {
		List<WebElement> results = Actions.findElements(driver, searchResultItems);
		
		 Map<String, String> resultsMap = new HashMap<String, String>();
		 for(WebElement e : results) {
			 resultsMap.put(e.findElement(itemName).getText(), e.findElement(itemPrice).getText());
	     }
	        
	     return resultsMap;
	}
	
	public List<String> searchResultsList() {
		List<WebElement> results = driver.findElements(searchResultItems);
		
		 List<String> resultsList = new ArrayList<String>();
		 for(WebElement e : results) {
			 resultsList.add(e.findElement(itemName).getText() + "#SEPARATOR#" + e.findElement(itemPrice).getText());
	     }
	        
	     return resultsList;
	}

}
