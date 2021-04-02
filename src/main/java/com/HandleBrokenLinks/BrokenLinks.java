package com.HandleBrokenLinks;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
public static WebDriver driver;
	
	@Test
	public void test1() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");
		
		java.util.List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		int brokenLinks=0;
		
		for (WebElement link : links) {
			//System.out.println(link.getText());
			String url= link.getAttribute("href");
			
			URL linktourl=new URL(url); // Capture the link into URL format
			HttpURLConnection httpconn=(HttpURLConnection) linktourl.openConnection();// Open the Connection Object
			httpconn.connect(); // send the URL to server
			
			if(httpconn.getResponseCode()>=400)
			{
				System.out.println(httpconn.getResponseCode()+ url + "is Broken Links");
				brokenLinks++;
			}
			else
			{
				System.out.println(httpconn.getResponseCode()+ url + "is Valid Links");
			}
			
		}
		
	}

}
