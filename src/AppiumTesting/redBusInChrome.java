package AppiumTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class redBusInChrome {
	
	public static void main(String args[]) throws BiffException, FileNotFoundException, IOException, InterruptedException{
		
		Workbook w = Workbook.getWorkbook(new FileInputStream("B:\\selcontent\\excel\\redbusMobile.xls"));
		Sheet s = w.getSheet(0);
		
		AndroidDriver d = null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "70cd0691");
		cap.setCapability(MobileCapabilityType.PLATFORM, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		
		d.get("http://redbus.in");
		Reporter.log("loads the red bus page successfully");
		
		Reporter.log("gets the input from the excel sheet");
		Cell c = s.getCell(0, 0);
		String text = c.getContents();
		Reporter.log("successfully gets the value from the excel sheet");
		
		Reporter.log("clicks the from bar");
		d.findElement(By.id("fromIp")).click();
		Reporter.log("successfully clicks the from bar");
		
		Reporter.log("send the key value to the bar");
		d.findElement(By.id("suggestInput")).sendKeys(text);
		Reporter.log("Successfully send the key to the bar");
		
		Thread.sleep(2000);
		
		Reporter.log("clicks the starting button");
		d.findElement(By.xpath("//*[@id=\"suggestedCities\"]/li")).click();
		Reporter.log("clicks the key displayed");
		
		Reporter.log("clicks the to textfeild");
		d.findElement(By.id("toIp")).click();
		Reporter.log("successfully clicks the textfeild");
		
		c = s.getCell(1, 0);
		text = c.getContents();
		Reporter.log("send the to key value to the textfeild");
		d.findElement(By.id("suggestInput")).sendKeys(text);
		Reporter.log("successfullt sends the key value");
		
		Thread.sleep(2000);
		
		d.findElement(By.xpath("//*[@id=\"suggestedCities\"]/li[1]")).click();
		Reporter.log("successfully clicks the key");
		
		Reporter.log("clicks the calender");
		d.findElement(By.id("openCalendar")).click();
		Reporter.log("Successfully clicks the calender");
		
		Thread.sleep(3000);
		
		List<WebElement> columns = d.findElements(By.tagName("td"));

        
        for (WebElement cell: columns) {
            if (cell.getText().equals("25")) {
                cell.click();
                break;
            }
        }
		
		Reporter.log("clicks the search button");
		d.findElement(By.id("search_button")).click();
		Reporter.log("successully clicks the search button");
		
		Thread.sleep(3000);
		
		//d.findElement(By.id("filterToggle")).click();
		
		d.findElement(By.xpath("//*[@id=\"headerSort\"]/a[4]"));
		
		
		
		
		
		
	}

}
