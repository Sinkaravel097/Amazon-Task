package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static void chrome() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void maxWindow() {
		driver.manage().window().maximize();

	}
	
	public static void implisitWait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
	
	public static void findAndSend(WebElement element, String sendTxt) {
		element.sendKeys(sendTxt);
	}
	
	public static void clickAny(WebElement element) {
		
		element.click();
	}
	
	public static String readExcel(int particularRow, int particularCellFromRow) throws IOException {

			File f = new File("E:\\Selenium Practical\\AmazonTest\\ExcelSheets\\Amazon.xlsx");

			FileInputStream fis = new FileInputStream(f);

			Workbook wb = new XSSFWorkbook(fis);

			Sheet sheet = wb.getSheet("Sheet1");

			Row row = sheet.getRow(particularRow);

			Cell cell = row.getCell(particularCellFromRow);
			
			int cellType = cell.getCellType();

			String value = " ";

			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
				value = sdf.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
			return value;

	}
	
	public static void windowHand() {
		
		String parentId = driver.getWindowHandle();
		Set<String> childId = driver.getWindowHandles();
		for (String child : childId) {
			if (!parentId.equals(childId)) {
				driver.switchTo().window(child);
			}
		}
	}
	
	public static void frames() {
		driver.switchTo().frame("//div[@class='a-section a-spacing-none a-padding-base attach-primary-atc-confirm-box']");

	}
	
	public static void javaClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}
	
	public static String getTxt(WebElement element) {
		
		String tex = element.getText();
		return tex;
	}
	
	public static void located() {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='a-button-input'])[8]")));

	}

}
