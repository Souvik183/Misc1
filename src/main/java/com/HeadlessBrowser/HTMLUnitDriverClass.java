package com.HeadlessBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLUnitDriverClass {
	
public static WebDriver driver;
	
	@Test
	public void test1() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new HtmlUnitDriver();
		
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demosite.executeautomation.com/Login.html");
		
		driver.findElement(By.name("UserName")).sendKeys("admin");
		driver.findElement(By.name("Password")).sendKeys("admin");
		driver.findElement((By.xpath("//input[@value=\"Login\"]"))).click();
		System.out.println(driver.getTitle());
		
	}

}
