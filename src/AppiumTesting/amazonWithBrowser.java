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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class amazonWithBrowser {
	
	public static void main(String args[]) throws BiffException, FileNotFoundException, IOException, InterruptedException{
		
		Workbook w = Workbook.getWorkbook(new FileInputStream("B:\\selcontent\\excel\\amazonMobile.xls"));
		Sheet s = w.getSheet(0);
		
		
		WebDriver d =  null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "70cd0691");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		d.get("http://www.amazon.com");
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		File img = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("B:\\selcontent\\screenshot\\mobile\\"+ timeStamp +".png"));
		
		Cell c = s.getCell(0, 0);
		String text = c.getContents();
		d.findElement(By.xpath("//*[@id=\"nav-search-keywords\"]")).sendKeys(text);
		d.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[1]/div/input")).click();
		
		d.findElement(By.xpath("//*[@id=\"resultItems\"]/li[1]/a/div/div[2]/h5/span")).click();
		
		Thread.sleep(5000);
		d.findElement(By.id("add-to-cart-button")).click();
		
		
		
		
	}

}
