package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest {
 

	@Test
	public void test() {
	    	/*final String sUrl = "http://www.google.co.in/"; 
	        //Create a new instance of the Firefox driver
	    	System. setProperty("webdriver.chrome.driver","C:/Users/user110/Downloads/chromeDriver.exe");
	    	 WebDriver driver = new ChromeDriver();	            
	        //Open the browser
	        driver.get(sUrl);
	        //This test case will pass
	        String title = driver.getTitle();
	        Reporter.log("Testing");
	        System.out.println("Title is: " + title);
	        Assert.assertEquals(title, "Target Practice");
	        driver.close();*/
    	  Random objGenerator = new Random();
          int randomNumber = objGenerator.nextInt(100000);
          System.out.println("Random No : " + randomNumber);
	    }
	   
}
