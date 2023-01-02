package com.hrms.lib;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WD_TestNG {
	WebDriver driver;
@BeforeClass
public void startup() {
	System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver_win32\\chromedriver.exe");
 driver = new ChromeDriver();
	
}
@AfterClass
public void tearDown() {
driver.close();	
Reporter.log("Application Closed");
}
@Test
public void tc001() throws Exception {
	driver.navigate().to("http://183.82.103.245/nareshit/login.php");
	Reporter.log("Application Opened");//html Report
	driver.findElement(By.name("txtUserName")).sendKeys("nareshit");
	driver.findElement(By.name("txtPassword")).sendKeys("nareshit");
    driver.findElement(By.name("Submit")).click();
    Thread.sleep(3000);
    System.out.println("Login completed");
    Reporter.log("Login completed");
    Reporter.log(driver.getTitle());
    driver.switchTo().frame("rightMenu");	
    driver.findElement(By.xpath("//input[@value='Add'][@value='Add']")).click();
    Thread.sleep(3000);
    driver.findElement(By.name("txtEmpFirstName")).sendKeys("vinay");
    driver.findElement(By.name("txtEmpLastName")).sendKeys("tomar");
    driver.findElement(By.id("btnEdit")).click();
    Thread.sleep(3000);	

    Reporter.log("New Emp added");
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();
    System.out.println("Logout completed");
    Reporter.log("Logout completed");
}
}
