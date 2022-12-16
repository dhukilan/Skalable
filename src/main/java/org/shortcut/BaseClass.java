package org.shortcut;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver d;
	
	//1.Browser Launch
	public static WebDriver browserLaunch(String browserName) {
		switch(browserName) {
		case "chrome":
		    WebDriverManager.chromedriver().setup();
		    d=new ChromeDriver();
		    break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			d=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			d=new EdgeDriver();
			break;
		default:
				System.err.println("Invalid browser");
		}
		return d;
	}
	
	//2.url Launch
	public static void  urlLaunch(String url) {
		d.get(url);
		d.manage().window().maximize();
	}
	//3.get title
	public static String getTitle() {
		String title=d.getTitle();
		return title;
	}
	//4.get current url
	public static String getCurrenturl() {
	String currentUrl = d.getCurrentUrl();
	return currentUrl;
	}
	//5.quit
	public static void quit() {
		d.quit();
	}
	//6.find Element
	public static WebElement findElement (String locatorName,String locatorValue) {
		WebElement value=null;
		if(locatorName.equals("id")) {
		    value=d.findElement(By.id(locatorValue));
		}else if(locatorName.equals("name")) {
			value=d.findElement(By.name(locatorValue));
		}else if(locatorName.equals("xpath")) {
			value=d.findElement(By.xpath(locatorValue));
		}
		return value;
	    }
	//7.sendKeys
	public static void sendkeyss(WebElement e,String user, Keys enter) {
		e.sendKeys(user);
	}
	public static void sendkeys(WebElement e,String user) {
		e.sendKeys(user);
	}
	//8.getAttribute
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	//9.getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	//10.click
	public static void click(WebElement e) {
		e.click();
	}
	//11.dynamic wait
	public static void Wait(long time) {
		d.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	//12.static wait
	public static void Threadsleep(long millis) throws InterruptedException{
		Thread.sleep(millis);
	}
	//Actions
	//13.moveToElement
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(d);
		a.moveToElement(e).perform();
	}
	//14.drag And Drop
	public static void dragAndDrop(WebElement scr,WebElement des) {
		Actions a=new Actions(d);
		a.dragAndDrop(scr, des).perform();
	}
	//15.click And Hold
	public static void clickAndHold(WebElement scr,WebElement des) {
		Actions a=new Actions(d);
		a.clickAndHold(scr).release(des).perform();
	}
	//16.rightClick
	public static void rightClick(WebElement e) {
		Actions a=new Actions(d);
		a.contextClick(e).perform();
	}
	//17.doubleClick
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(d);
		a.doubleClick().perform();
	}
	//18.clear
	public static void clear(WebElement e) {
		e.clear();
	}
	//19.copy text
	public static void copytext(WebElement e) throws AWTException{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	//20.paste text
	public static void pastetext(WebElement e) throws AWTException{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	//21.selected by index
	public static void selectedByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	//22.selected by value
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	//23.selected by text
	public static void selectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByVisibleText(value);
	}
	//24.First selected option
	public static void firstSelectedOption(WebElement e) {
		Select s=new Select(e);
		s.getFirstSelectedOption();
	}
	//25.deSelected by index
	public static void deSelectedbyindex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	//26.deSelected by value
	public static void deSelectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	//27.deSelected by text
	public static void deselectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByVisibleText(value);
	}
	//28.deSelectedAll
	public static void deselectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	//29.takeScreenShot
	public static void takeScreenShot(String name) throws IOException{
		TakesScreenshot tk=(TakesScreenshot)d;
		File scr = tk.getScreenshotAs(OutputType.FILE);
		File des=new File(
				System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshort\\"+name+".png");
		FileUtils.copyFile(scr, des);
	}
	//30.java script Executor send keys
	public static void jsSendkeys(WebElement e,String user) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].setAttribute('value','"+user+"')",e);
	}
	//31.java script Executor using click
	public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].click()",e);
	}
	//32.scroll up
	public static void scrollup(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(false)",e);
	}
	//33.scroll down
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	//34.switch to frame index
	public static void frameindex(int index) {
		d.switchTo().frame(index);
	}
	//35.switch to frame index
	public static void frame(WebElement e) {
		d.switchTo().frame(e);
	}
	//36.switch out from Frame
	public static void frameOut() {
		d.switchTo().defaultContent();
	}
	//37.switch out from frame one by one
	public static void ParentFrame() {
		d.switchTo().parentFrame();
	}
	//38.window handle
	public static void windowshandling() {
		String windowHandle = d.getWindowHandle();
		Set<String> windowHandles = d.getWindowHandles();
		for(String eachid:windowHandles) {
			if(!windowHandle.equals(eachid)) {
				d.switchTo().window(eachid);
			}
		}
	}
	
	//39.Navigate Back
	public static void navigateback() {
		d.navigate().back();
	}
	//40.Navigate Forward
	public static void navigateforward() {
		d.navigate().forward();
	}
	//41.Navigate Refresh
	public static void navigaterefresh() {
		d.navigate().refresh();
	}
	//42.Alert
	public static Alert alert() {
		Alert alert = d.switchTo().alert();
		return alert;
	}
	//43.Alert Accept
	public static Alert alertaccept() {
		Alert alert = d.switchTo().alert();
		alert.accept();
		return alert;
	}
	//44.Alert Reject
	public static Alert alertreject() {
		Alert alert = d.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	//45.Excel
	public static String getExcel(String excelname,String sheetname,int rowno,int cellno) throws IOException {
	File f=new File("C:\\Users\\Dhukilan\\eclipse-workspace2\\Skalable\\src\\test\\resources\\Excel\\"+excelname+".xlsx");
	FileInputStream fi=new FileInputStream(f);
	Workbook w= new XSSFWorkbook(fi);
	Sheet s= w.getSheet(sheetname);
	Row r= s.getRow(rowno);
	Cell cell = r.getCell(cellno);
	int type = cell.getCellType();
	String value =null;
	if(type==1) {
		 value = cell.getStringCellValue();
	}
	else {
		if(DateUtil.isCellDateFormatted(cell)) {
			 value = new SimpleDateFormat("dd-MMM-yyyy").format(cell.getDateCellValue());
		}
		else {
			 value = String.valueOf((long)cell.getNumericCellValue());
		}
	}
	return value;
	
	}

	public static boolean waitUrl(long sec,String partialUrl) {
	
	WebDriverWait w=new WebDriverWait(d, sec);
	return w.until(ExpectedConditions.urlContains(partialUrl));}
}  
	

	