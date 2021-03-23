package com.GetTextAttribute;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextvsAttribute {
public static WebDriver driver;
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement email= driver.findElement(By.name("Email"));
		email.clear();
		email.sendKeys("admin@admin.com");
		System.out.println(email.getAttribute("value"));
		//System.out.println(email.getText());
		WebElement loginbtn=driver.findElement(By.xpath("//button[@type='submit']"));
		System.out.println(loginbtn.getText());
	}

}
