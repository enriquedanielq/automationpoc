package pageObjects;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	
	By txtboxSearchBar = By.id("twotabsearchtextbox");
	By btnSubmit = By.cssSelector(".nav-input[type='submit']");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void setTextToSearch(String text) {
		driver.findElement(txtboxSearchBar).sendKeys(text);
	}
	
	public SearchResults clickSearchButton() {
		driver.findElement(btnSubmit).click();
		SearchResults amazonResultsPage = new SearchResults(driver);
		return amazonResultsPage;
	}
	

}
