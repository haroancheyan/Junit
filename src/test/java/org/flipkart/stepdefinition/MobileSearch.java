package org.flipkart.stepdefinition;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSearch {
	static WebDriver driver;
	@BeforeClass
	public static void launch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public static void quit() {
		System.out.println("quit");
		driver.quit();
		
	}
	long StartTime;
	@Before
	public void method1() {
		System.out.println("BEfore method");
		StartTime = System.currentTimeMillis();
		
	}
	@After
	public void method2() {
		System.out.println("After method");
		long endtime = System.currentTimeMillis();
		System.out.println("Time Taken :"+(endtime-StartTime));
		
		
	}
	@Test
	public void method3() {
		System.out.println("login");
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		
	}
	@Test
	public void method4() throws Throwable {
		System.out.println("mobile search");
		driver.findElement(By.name("q")).sendKeys("Redmi mobile",Keys.ENTER);
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (int i = 0; i < element.size(); i++) {
			WebElement mobilename = element.get(i);
			String name = mobilename.getText();
			System.out.println(name);
			
		}
		
	}
	
	
	}


