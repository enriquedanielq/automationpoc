package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public abstract class BaseTest {
  public WebDriver driver;
  
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--start-maximized");
	  driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @BeforeClass
  public void beforeClass() {  
  driver.get("http://www.amazon.com/");
  }
 
  @AfterSuite
  public void afterClass() {
  driver.quit();
  }
  
  public WebDriver getDriver() {
      return driver;
  }
 
}

