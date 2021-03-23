package com.SpecialDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap {
	
public static WebDriver driver;
	
	
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]")).click();
		List<WebElement> options= driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println(options.size());
		
		for(WebElement check: options)
		{
			if(check.getText().equals("EMI"))
			{
				check.click();
				break;
			}
		}
	}
	

}
