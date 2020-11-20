package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class HRM4 {
  @Test
  @Parameters({ "sUsername", "sPassword" })
  public void f(String sUsername, String sPassword) throws InterruptedException {
	  	final String sUrl = "http://alchemy.hguy.co/orangehrm"; 
	    //Create a new instance of the Firefox driver
		File file = new File("Drivers/chromedriver.exe");
		Random rd = new Random();
		System. setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		WebDriver driver = new ChromeDriver();
		driver.get(sUrl);
		WebElement txt = driver.findElement(By.id("txtUsername"));
		txt.sendKeys(sUsername);
		driver.findElement(By.id("txtPassword")).sendKeys(sPassword);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("F"+rd.nextInt(100000));
		String fname = driver.findElement(By.id("firstName")).getAttribute("value");
		System.out.println("Employee is added with First Name "+fname);
		Reporter.log("Employee is added with Emp Id "+fname);
		driver.findElement(By.id("lastName")).sendKeys("L"+rd.nextInt(100000));
		String lname = driver.findElement(By.id("lastName")).getAttribute("value");
		System.out.println("Employee is added with Last Name "+lname);
		Reporter.log("Employee is added with Emp Id "+lname);
		String EmpID = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println("Employee is added with Emp Id "+EmpID);
		Reporter.log("Employee is added with Emp Id "+EmpID);		
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys("ORG"+rd.nextInt(100000));
		String UN = driver.findElement(By.id("user_name")).getAttribute("value");
		System.out.println("Employee has given the user name "+UN);
		Reporter.log("Employee has given the user name "+UN);		
		driver.findElement(By.id("user_password")).sendKeys("ORG@12345678456");
		driver.findElement(By.id("re_password")).sendKeys("ORG@12345678456");
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(UN);
		Select Usys = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		Usys.selectByVisibleText("ESS");
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(EmpID);
		Select Usts = new Select(driver.findElement(By.id("searchSystemUser_status")));
		Usts.selectByVisibleText("Enabled");
		driver.findElement(By.id("searchBtn")).click();
		String Tres = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a")).getText();
		System.out.println("Vaidated Employee Details passed for Emp "+Tres);
		Reporter.log("Vaidated Employee Details passed for Emp "+Tres);
		if(Tres == UN){
			System.out.println("Vaidated Employee Details passed for Emp "+Tres);
			Reporter.log("Vaidated Employee Details passed for Emp "+Tres);
		}
			else{
			System.out.println("Vaidated Employee Details failed for Emp "+Tres);
			Reporter.log("Vaidated Employee Details failed for Emp "+Tres);
		}		
	    //driver.quit(); 
	  }
}
