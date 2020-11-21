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


public class HRM8 {
  @Test
  @Parameters({ "sUsername", "sPassword" })
  public void f(String sUsername, String sPassword) throws InterruptedException {
	  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
	  	Random rd = new Random();
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
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='sidenav']/li[9]/a")).click();
		driver.findElement(By.id("addWorkExperience")).click();
		driver.findElement(By.id("experience_employer")).sendKeys("company"+rd.nextInt(1000));
		driver.findElement(By.id("experience_jobtitle")).sendKeys("Jtitle"+rd.nextInt(1000));
		driver.findElement(By.id("btnWorkExpSave")).click();
	    //driver.quit(); 
  }
}
