package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseTest {
  public WebDriver driver;

  
  @BeforeClass
  public void beforeClass() {
  
  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("http://www.amazon.com/");
  }
 
  @AfterClass
  public void afterClass() {
  driver.quit();
  }
  
  public WebDriver getDriver() {
      return driver;
  }
 
}

