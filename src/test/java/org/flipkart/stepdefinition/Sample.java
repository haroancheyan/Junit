package org.flipkart.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {
	static WebDriver driver;
	public static void waitsTobeClick(WebElement e) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public static void screenShot(String image) throws Throwable {
		TakesScreenshot tk = (TakesScreenshot)driver;
		File s= tk.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\haroa\\eclipse-workspace\\ModelProject\\screenshot\\"+image+".png");
		FileUtils.copyFile(s, f);
	}

}
