
package org.flipkart.stepdefinition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MobilePurchase extends Sample {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\haroa\\eclipse-workspace\\ModelProject\\driver\\msedgedriver.exe");
		driver =new EdgeDriver();
		
		String url = "https://www.flipkart.com/";
		driver.navigate().to(url);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		
		WebElement element = driver.findElement(By.name("q"));
		waitsTobeClick(element);
		element.sendKeys("Realme mobile");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		
		List<WebElement> element1= driver.findElements(By.xpath("//div[@class='_4rR01T']"));

		File f = new File("C:\\Users\\haroa\\eclipse-workspace\\ModelProject\\src\\test\\resources\\flipkartexcel.xlsx");
		
		Workbook w = new XSSFWorkbook();
	    Sheet sheet = w.createSheet("Realme");
		for (int i = 0; i < element1.size(); i++) {
			WebElement name = element1.get(i);
			String productname = name.getText();
			System.out.println(productname);
			for (int j = 0; j < element1.size(); j++) {
				Row row= sheet.createRow(j);
				Cell cell = row.createCell(0);
				cell.setCellValue(productname);
				
				FileOutputStream f1 = new FileOutputStream(f);
				w.write(f1);
				}	
		}
		WebElement product = element1.get(4);
		product.click();
		
		Set<String> id = driver.getWindowHandles();
		List<String> child = new ArrayList<>(id);
		driver.switchTo().window(child.get(1));
		
		WebElement element2 = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		String product4 = element2.getText();
		System.out.println("Selected product is "+product4);
		
        File fn = new File("C:\\Users\\haroa\\eclipse-workspace\\ModelProject\\src\\test\\resources\\ExcelWrite1.xls");
	    Workbook w1 = new HSSFWorkbook();
	    Sheet s1 = w1.createSheet("haroan");
 	    Row r1 =s1.createRow(0);
	    Cell c1 = r1.createCell(0);
	    c1.setCellValue(product4);
	    
	    FileOutputStream f2= new FileOutputStream(fn);
	    w.write(f2);
		
		WebElement element3 = driver.findElement(By.xpath("(//li[@class='col col-6-12'])[1]"));
		waitsTobeClick(element3);
		element3.click();
		Thread.sleep(2000);
		
		screenShot("print fouth");
		
		}

}
