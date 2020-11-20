package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Test1 {
 
	    public static void main(String[] args) {
	    	final String sUrl = "http://www.google.co.in/"; 
	        //Create a new instance of the Firefox driver
	    	File file = new File("Drivers/chromedriver.exe");
	    	System. setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	    	 WebDriver driver = new ChromeDriver();	            
	        //Open the browser
	        driver.get(sUrl);
	        //This test case will pass
	        String title = driver.getTitle();
	        System.out.println("Title is: " + title);
	        //Assert.assertEquals(title, "Target Practice");
	        driver.close();
	    }
	   
}
