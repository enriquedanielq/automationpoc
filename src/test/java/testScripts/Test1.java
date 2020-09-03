package testScripts;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;
import pageObjects.SearchResults;
import utilities.Actions;
import utilities.Utilities;

public class Test1 extends BaseTest{
    
	@Test
	@Parameters({"textToSearch", "filterToSelect"})
    public void homepageTests(String textToSearch, String filterToSelect) {
        HomePage amazonHomepage = new HomePage(getDriver());
        
        //Assert if we are in correct page.
        Assert.assertTrue("Search results are not displayed", amazonHomepage.isHomePageVisible());
        
        //At Home Page, set the text to Search in Amazon Site.
        amazonHomepage.setTextToSearch(textToSearch);
        SearchResults amazonResultsPage = amazonHomepage.clickSearchButton();
        amazonResultsPage.waitForPageLoaded();
        
        //Select desired filter in the left pane of Search Results page.
        amazonResultsPage.selectFilter(filterToSelect);
        amazonResultsPage.waitForPageLoaded();
        
        //Assert if we are in correct page.
        Assert.assertTrue("Search results are not displayed", amazonResultsPage.isSearchResultsPageVisible());
        //Get the details of items at Search Results page.
        List<String> results = amazonResultsPage.searchResultsList();
        
        //Order items by price value ascending order
        Map<Integer, Float> orderedValues = Utilities.orderValues(results);
        
        //Print details in Console
        Utilities.printProductAndPrice(orderedValues, results);
    }

}
