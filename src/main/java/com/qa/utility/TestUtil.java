package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static long page_load_Timeout=40;
	public static long Implicit_wait=40;
	static String TestData_sheet_path="C:/Users/pavithra/eclipse-workspace/CGtest/src/main/java/com/qa/testdata/FreeCRMTestdata.xlsx";
	public void switctoframe() {
		driver.switchTo().frame("mainpanel");
	}
public static Workbook book;
public static Sheet sheet;

	public static Object[][] getTestData(String sheetname){
		FileInputStream file=null;
		try {
			file=new FileInputStream(TestData_sheet_path);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
		book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(i).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		
			}
		}
		return data;
		}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir+"/screenshots"+System.currentTimeMillis()+".png"));
	}
	
}

