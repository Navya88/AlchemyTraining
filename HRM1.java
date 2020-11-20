package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class HRM1 {
  @Test
  public void f() {
  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
    //Create a new instance of the Firefox driver
	File file = new File("Drivers/chromedriver.exe");
	System. setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	WebDriver driver = new ChromeDriver();
	driver.get(sUrl);
	String sTitle = driver.getTitle();
	Assert.assertEquals(sTitle, "OrangeHRM");
	Reporter.log("Website title is OrangeHRM");
    driver.quit();
  }
}
