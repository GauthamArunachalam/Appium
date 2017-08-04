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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class flipkartBrowserTry {
	
	public static void main(String args[]) throws InterruptedException, BiffException, FileNotFoundException, IOException{
		
		Workbook w = Workbook.getWorkbook(new FileInputStream("B:\\selcontent\\excel\\flipkartMobile.xls"));
		Sheet s = w.getSheet(0);
		
		
		AndroidDriver d = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "70cd0691");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		d.get("http://www.flipkart.com");
		
		Thread.sleep(3000);
		Reporter.log("loads the website successfully");
		Reporter.log("clicks the search button");
		d.findElement(By.className("e73_44")).click();
		Reporter.log("successfully clicks the search button");
		
		Cell c = s.getCell(0,0);
		String text = c.getContents();
		
		Reporter.log("send the key value into the search bar");
		d.findElement(By.className("_30tU0l")).sendKeys(text);
		Reporter.log("successfully sends the search keys");
		
		Thread.sleep(5000);
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		File img = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img, new File("B:\\selcontent\\screenshot\\"+ timestamp +".png"));
		Reporter.log("Successfully takes screenshot of the page");
		
		Reporter.log("clicks the filter button");
		d.findElement(By.className("_1aSXJy")).click();
		Reporter.log("successfully clicks the filter button");
		
		Thread.sleep(5000);
		
		
				

}
}