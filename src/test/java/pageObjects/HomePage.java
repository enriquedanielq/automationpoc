package pageObjects;

import base.BasePage;
import utilities.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	By txtboxSearchBar = By.id("twotabsearchtextbox");
	By btnSubmit = By.cssSelector(".nav-input[type='submit']");
	By homePageBanner = By.id("desktop-banner");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isHomePageVisible() {
		return Actions.isElementDisplayed(driver, homePageBanner);
	}
	
	public void setTextToSearch(String text) {
		Actions.typeInElement(driver, txtboxSearchBar, text);
	}
	
	public SearchResults clickSearchButton() {
		Actions.clickElement(driver, btnSubmit);
		SearchResults amazonResultsPage = new SearchResults(driver);
		return amazonResultsPage;
	}
	

}
