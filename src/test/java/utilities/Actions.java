package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Actions {
	
	public static boolean isElementDisplayed(WebDriver driver, By object) {
		return driver.findElement(object).isDisplayed();
	}
	
	public static void clickElement(WebDriver driver, By object) {
		driver.findElement(object).click();
	}
	
	public static void typeInElement(WebDriver driver, By object, String text) {
		driver.findElement(object).sendKeys(text);
	}
	
	public static WebElement findElement(WebDriver driver, By object) {
		return driver.findElement(object);
	}
	
	public static List<WebElement> findElements(WebDriver driver, By object) {
		return driver.findElements(object);
	}
	
	

}
