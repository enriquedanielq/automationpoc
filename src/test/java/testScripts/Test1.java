package testScripts;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.SearchResults;
import utilities.utilities;

public class Test1 extends BaseTest{
    
	@Test
    public void homepageTests() throws InterruptedException {
        HomePage amazonHomepage = new HomePage(getDriver());
        
        amazonHomepage.setTextToSearch("phone case Carbon Fiber");
        SearchResults amazonResultsPage = amazonHomepage.clickSearchButton();
        amazonResultsPage.waitForPageLoaded();
        
        amazonResultsPage.selectFilter("Carbon Fiber");
        amazonResultsPage.waitForPageLoaded();
        
        List<String> results = amazonResultsPage.searchResultsList();
        Map<Integer, Float> orderedValues = utilities.orderValues(results);
        
        utilities.printProductAndPrice(orderedValues, results);
        Thread.sleep(1000);
    }

}
