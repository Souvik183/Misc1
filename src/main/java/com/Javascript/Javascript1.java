package com.Javascript;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript1 {
	
public static WebDriver driver;
//public static JavascriptExecutor js;


	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demosite.executeautomation.com/Login.html");
		
	}
	
	public static void changeColor(WebElement element, String color)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
	}
	public static void drawborder(WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border ='3px solid red'", element);
	}
	
	public static void generateAlert(String message)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickonElement(WebElement element)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowser()
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static void takeScreenshotAtEndOfTest() throws Throwable {
		// TODO Auto-generated method stub
		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:\\Users\\User\\eclipse-workspace\\ECNew\\Misc1\\src"
				+ "	\\main\\java\\com\\screenshot\\element.png"));
	}
	
	public static void sendkeys()
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('UserName').value='admin';");
		js.executeScript("document.getElementById('Password').value='admin';");
	}
	
	@Test
	public void test1() throws Throwable
	{
		//driver.findElement(By.name("UserName")).sendKeys("admin");
		//driver.findElement(By.name("Password")).sendKeys("admin");
		
		sendkeys();
		WebElement loginbtn=driver.findElement((By.xpath("//input[@value=\"Login\"]")));
		//Drawing Border
		drawborder(loginbtn);
		//takeScreenshotAtEndOfTest();
		
		//Generating Alert
		generateAlert("My Check");
		driver.switchTo().alert().accept();
		
		//Refreshing browser
		//Thread.sleep(2000) ;
		//refreshBrowser();
		
		Thread.sleep(2000);
		//Clicking on Element
		clickonElement(loginbtn);
		
	}

}
