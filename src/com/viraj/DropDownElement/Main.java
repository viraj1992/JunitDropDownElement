package com.viraj.DropDownElement;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
	WebDriver driver;
	String baseURL = "https://letskodeit.teachable.com/p/practice";
	Select select;
	WebElement element;


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Viraj\\Desktop\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		element = driver.findElement(By.id("carselect"));
		select = new Select(element);
		
		select.selectByIndex(1);
		System.out.println("Selected BMW");
		
		Thread.sleep(500);
		
		select.selectByValue("benz");
		System.out.println("Selected Benz");
		
		Thread.sleep(500);
		
		select.selectByVisibleText("Honda");
		System.out.println("Selected Honda");
		
		Thread.sleep(500);
		
		List<WebElement> element1 = select.getOptions();
		//List<WebElement> element1 = driver.findElements(By.id("carselect"));
		for(int i= 0; i < element1.size(); i++) {
			System.out.println(element1.get(i).getText());
		}
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
