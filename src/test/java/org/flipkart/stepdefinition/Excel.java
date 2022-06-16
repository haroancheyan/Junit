package org.flipkart.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static void main(String[] args) throws Throwable {
		File f = new File("C:\\Users\\haroa\\eclipse-workspace\\ModelProject\\src\\test\\resources\\ExcelWrite.xlsx");
	    
	    Workbook w = new XSSFWorkbook();
	    Sheet s = w.createSheet("haroan");
 	    Row r =s.createRow(0);
	    Cell c = r.createCell(0);
	    c.setCellValue("haroan");
	    
	    FileOutputStream f1= new FileOutputStream(f);
	    w.write(f1);
	    
			
			
		}
	    
	}

