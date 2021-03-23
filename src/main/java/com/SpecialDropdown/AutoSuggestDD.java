package com.SpecialDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDD {
	
public static WebDriver driver;
	
	@Test
	public void test1() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		List<WebElement> values= driver.findElements(By.xpath("//li[@class='sa_sg']/div/span"));
		for(WebElement pick : values)
		{
			if(pick.getText().contains("download"))
			{
				Thread.sleep(2000);
				pick.click();
				break;
			}
		}
	}

}
