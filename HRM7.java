package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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


public class HRM7 {
  @Test
  @Parameters({ "sUsername", "sPassword" })
  public void f(String sUsername, String sPassword) throws InterruptedException {
	  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
	  	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  	Date rj = new Date();
	  	String date = sdf.format(rj);
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
		driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_leave_applyLeave")).click();
		Select Usyss = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
		Usyss.selectByVisibleText("Paid Leave");
        for (int i=0;i<10;i++){
    		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(Keys.BACK_SPACE);
        }
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(date);
		driver.findElement(By.id("applyleave_txtFromDate")).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		driver.findElement(By.id("applyleave_txtToDate")).click();
        for (int j=0;j<10;j++){
    		driver.findElement(By.id("applyleave_txtToDate")).sendKeys(Keys.BACK_SPACE);
        }
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys(date);
		driver.findElement(By.id("applyleave_txtToDate")).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		driver.findElement(By.id("applyBtn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		Thread.sleep(2000);
        for (int k=0;k<10;k++){
    		driver.findElement(By.id("calFromDate")).sendKeys(Keys.BACK_SPACE);
        }
		driver.findElement(By.id("calFromDate")).sendKeys(date);
		driver.findElement(By.id("calFromDate")).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		driver.findElement(By.id("calToDate")).click();
        for (int l=0;l<10;l++){
    		driver.findElement(By.id("calToDate")).sendKeys(Keys.BACK_SPACE);
        }
		driver.findElement(By.id("calToDate")).sendKeys(date);
		driver.findElement(By.id("calToDate")).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		driver.findElement(By.id("btnSearch")).click();
		String sts = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[1]/td[6]/a")).getText();
		System.out.println("Applied Leave status "+sts);
		Reporter.log("Applied Leave status "+sts);
	    //driver.quit(); 
  }
}
