package AppiumTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class flipTestBrowserTest {
  @Test
  public void f() throws InterruptedException, BiffException, FileNotFoundException, IOException {
	  
	  Workbook w = Workbook.getWorkbook(new FileInputStream("B:\\selcontent\\excel\\filpy.xls"));
		Sheet s = w.getSheet(0);
		
		AndroidDriver d = null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "70cd0691");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		d.get("http://www.flipkart.com");
		Reporter.log("loads the webpage successfully");
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		  File img = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(img, new File("B:\\selcontent\\screenshot\\mobile\\"+ timestamp +".png"));
		  Reporter.log("* takes a screenshot of the webpage");
		
		Reporter.log("clicks the search bar");
		d.findElement(By.className("e73_44")).click();
		Reporter.log("successfully clicks the search bar");
		
		Cell c = s.getCell(0, 0);
		String text = c.getContents();
		Reporter.log("sends the key to the search bar");
		d.findElement(By.id("input-search")).sendKeys(text);
		d.findElement(By.id("input-search")).sendKeys(Keys.ENTER);
		Reporter.log("successfully send the key value to the search bar");
		
		Thread.sleep(5000);
		
		Reporter.log("clicks the sort button");
		d.findElement(By.className("_1ri6n1")).click();
		Reporter.log("successfully clicks the sort button");
		
		Thread.sleep(3000);
		
		Reporter.log("clicks the low to high button");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[4]/div/div[2]/div[2]/ul/li[4]/div/div[2]")).click();
		Reporter.log("successfully clicks the low to high");
		
		Reporter.log("clicks the apply button");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[4]/div/div[2]/div[3]/div[2]")).click();
		Reporter.log("successfully clicks the apply button");
		
		Thread.sleep(4000);
		
		Reporter.log("clicks the product");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div/div[1]/div/a")).click();
		Reporter.log("successfully clicks the product");
		
		Thread.sleep(5000);
		Reporter.log("clicks the add the cart button");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div[3]/div/div[8]/div/div/div[1]")).click();
		Reporter.log("successfully clicks the add the cart button");
		
		Thread.sleep(3000);
		
		Reporter.log("clicks the login icon");
		d.findElement(By.cssSelector("#container > div > div._2YLOKV > div:nth-child(1) > div._1FWdmb > a:nth-child(7)")).click();
		Reporter.log("successfully clicks the loin button");
		
		Thread.sleep(4000);
		
		Reporter.log("sends the key value to the id bar");
		c = s.getCell(1, 0);
		text = c.getContents();
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/form/div[2]/div/div/div/input")).sendKeys(text);
		Reporter.log("successfull sends the id bar");
		
		c = s.getCell(2, 0);
		text = c.getContents();
		Reporter.log("sends the password into the pass bar");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/form/div[3]/div[1]/div/div/input")).sendKeys(text);
		Reporter.log("successfullt send the key to pass bar");
		
		Reporter.log("clicks the sign button");
		d.findElement(By.className("_2iUM2T")).click();
		Reporter.log("successfully clicks the sign button");
		
		Thread.sleep(5000);
		
		Reporter.log("clicks the back button");
		d.findElement(By.xpath("//*[@id=\"fk-cp-accounts\"]/div/div[2]/div[1]/a[1]")).click();
		Reporter.log("successfully clicks the back button");
		
		Thread.sleep(5000);
		
		Reporter.log("clicks the cart button");
		d.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div[1]/div/div[1]/a[4]")).click();
		Reporter.log("successfully clicks the cart button");
		
		Thread.sleep(6000);
		
		timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		  img = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(img, new File("B:\\selcontent\\screenshot\\mobile\\"+ timestamp +".png"));
		  Reporter.log("* takes a screenshot of the webpage");
		
		//Thread.sleep(4000);
		
		String asser = d.findElement(By.className("_9SoR0T")).getText();
		
		if(asser.contains("Skmei Rubber Magnet")){
			Reporter.log("successfully assets the correct product has been added to the cart");
		}
  }
}
