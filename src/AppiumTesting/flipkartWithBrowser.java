package AppiumTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class flipkartWithBrowser {
	
	public static void main(String args[]) throws BiffException, FileNotFoundException, IOException, InterruptedException{
		AndroidDriver d = null;
		
		Workbook w =  Workbook.getWorkbook(new FileInputStream("B:\\selcontent\\excel\\flipkartMobile.xls"));
		Sheet s =  w.getSheet(0);
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"70cd0691");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome" );
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		d.get("http://www.flipkart.com");
		
		Cell c = s.getCell(0, 0);
		String text = c.getContents();
		d.findElement(By.className("e73_44")).click();
		d.findElement(By.id("input-search")).sendKeys(text);
		d.findElement(By.id("input-search")).sendKeys(Keys.ENTER);
		
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div/div[1]/div/a/table/tbody/tr/td[2]/div[1]/div/div")).click();
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		File img = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("B:\\selcontent\\screenshot\\mobile\\"+ timestamp +".png"));
		
		Thread.sleep(5000);
		
		WebElement el = d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div[3]/div/div[8]/div/div/div[2]"));
		el.click();
		
		Thread.sleep(5000);
		
		c = s.getCell(1, 0);
		text = c.getContents();
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/form/div[2]/div/div/div/input")).sendKeys(text);
		
		c = s.getCell(2, 0);
		text = c.getContents();
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/form/div[3]/div[1]/div/div/input")).sendKeys(text);
		
		d.findElement(By.className("_2iUM2T")).click();
		
		
		
	}

}
