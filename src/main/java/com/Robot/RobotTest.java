package com.Robot;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotTest {
	
	public static WebDriver driver;
	
	@Test
	public void test1() throws Throwable
	{
		String command="C:\\Windows\\Notepad.exe";
		Runtime run=Runtime.getRuntime();
		run.exec(command);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_S);
		Thread.sleep(100);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.mouseWheel(6);
	}

}
