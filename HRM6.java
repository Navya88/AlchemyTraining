package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class HRM6 {
  @Test
  @Parameters({ "sUsername", "sPassword" })
  public void f(String sUsername, String sPassword) throws InterruptedException {
	  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
	    //Create a new instance of the Firefox driver
		File file = new File("Drivers/chromedriver.exe");
		System. setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get(sUrl);
		WebElement txt = driver.findElement(By.id("txtUsername"));
		txt.sendKeys(sUsername);
		driver.findElement(By.id("txtPassword")).sendKeys(sPassword);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
		Thread.sleep(2000);
		String dir = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/h1")).getText();
		System.out.println("The page matches with "+dir);
		Reporter.log("The page matches with "+dir);
		Assert.assertEquals(dir,"Search Directory","The page matches with Search Directory");
	    //driver.quit(); 
  }
}
