package com.webtable;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable1 {
	
	public static WebDriver driver;
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		WebElement table=driver.findElement(By.id("customers"));
		java.util.List<WebElement> rows=table.findElements(By.tagName("tr"));
		System.out.println("No of rows:"+rows.size());
		for (WebElement row : rows) {
			java.util.List<WebElement> cols=row.findElements(By.tagName("td"));
			for (WebElement col : cols) {
				System.out.println(col.getText());
			}
		}
	}

}
