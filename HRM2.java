package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class HRM2 {
  @Test
  public void f() {
	  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
	    //Create a new instance of the Firefox driver
		File file = new File("Drivers/chromedriver.exe");
		System. setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get(sUrl);
		String img = driver.findElement(By.xpath("//*[@id='divLogo']/img")).getAttribute("src");
		System.out.println("Hearder Image URL :"+img);
		Reporter.log("Hearder Image URL :"+img);
	    driver.quit();
	  }
}
