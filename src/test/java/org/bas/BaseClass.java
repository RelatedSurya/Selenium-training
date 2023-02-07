package org.bas;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static  WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static String pageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public static String pageUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}
	
	public static void closeEntireBrowser() {
		driver.quit();
	}
	
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File ("location + ImgNAme.png");
		FileUtils.copyFile(image, f);
	}
	
	public static Actions a;
	
	public static void moveTheCursor(WebElement targetWebelemet) {
		a = new Actions (driver);
		a.moveToElement(targetWebelemet).perform();
	}
	
	public static void dragDrop(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions (driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollThePage(WebElement tarWebele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebele);	
	}
	
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File ("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet("Data");
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value = "  ";
		if (cellType==1) {
			String value2 = c.getStringCellValue();
		}
		
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			 SimpleDateFormat s = new SimpleDateFormat(value);
			    String value1 = s.format(dd);
			}
			else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				String valueof = String.valueOf(l);
			}	
		}
	    
	    public static void createNewExcelFile(int rowNum, int cellNum, String newData) throws IOException {
	    	File f = new File ("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\MavenProgram\\\\Excel\\\\newfile.xlsx");
			Workbook w = new XSSFWorkbook();
			Sheet newSheet = w.createSheet("Datas");
			Row newRow = newSheet.createRow(rowNum);
			Cell newCell = newRow.createCell(cellNum);
			newCell.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			w.write(fos);
	  }
	    
	    public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
	    	File f = new File ("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\MavenProgram\\\\Excel\\\\newfile.xlsx");
	    	FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.getRow(rowNum);
			Cell c = r.createCell(cellNum);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
	  }
	    
	    public static void createRow(int creRow, int creCell, String newData) throws IOException {
	    	File f = new File ("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\MavenProgram\\\\Excel\\\\newfile.xlsx");
	    	FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.createRow(creRow);
			Cell c = r.createCell(creCell);
			c.setCellValue(newData);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
	  }
	    
	    public static void upDateToParticulerCell(int getTheRow, int getTheCell, String exixtingData, String writeNewData) throws IOException{
	    	File f = new File ("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\MavenProgram\\\\Excel\\\\newfile.xlsx");
	    	FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			Sheet s = wb.getSheet("Datas");
			Row r = s.getRow(getTheRow);
			Cell c = r.getCell(getTheCell);
			String str = c.getStringCellValue();
			if (str.equals(exixtingData)) {
				c.setCellValue(writeNewData);
			}
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
	  }
	    
	    public class Flipkart {
	    	//1.Non Parameterized constructor
	    	public Flipkart() {
	    		PageFactory.initElements(driver, this);
	    	
	    	}
	    	//2.Private WebElement
	    	@FindBy(xpath="//input[@type='text']")
	    	private WebElement email;
	    	
	    	@FindBy(xpath="//input[@type='password']")
	    	private WebElement password;
	    	
	    	@FindBy(xpath="//button[@value='1']")
	    	private WebElement LoginBtn;

	    	//3.Getters to access webelement outside the class
	    	public WebElement getemail() {
	    		return email;
	    	}

	    	public WebElement getpassword() {
	    		return password;
	    	}

	    	public WebElement getLoginBtn() {
	    		return LoginBtn;
	    	}
	    	
	    }

}	  
	  



