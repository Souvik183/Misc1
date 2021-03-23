package com.SpecialDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DD1 {

	public static WebDriver driver;
	
	public static void selectChoiceValues(String... value)
	{
		 List<WebElement> ddList= driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
	}
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("justAnInputBox")).click();
	}

}
