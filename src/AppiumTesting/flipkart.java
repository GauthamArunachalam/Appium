package AppiumTesting;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class flipkart {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		WebDriver driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "70cd0691");
		cap.setCapability("platform", "ANDROID");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("app", "B:\\selcontent\\apk\\Flipkart.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		Thread.sleep(35000);
		
		driver.findElement(By.id("btn_mlogin")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[36,383][446,437]']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//android.widget.LinearLayout[@bounds='[36,491][504,599]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[36,269][420,323]']")).sendKeys("9789403377");
		driver.findElement(By.xpath("//android.widget.Button[@bounds='[36,368][504,428]']")).click();
		
		//Thread.sleep(5000);
		//driver.findElement(By.name("Never")).click();
		Thread.sleep(50000);
		

	/*  	Dimension size = driver.manage().window().getSize();
	  
	  	int starty = (int) (size.height * 0.80);
 	 	
  		int endy = (int) (size.height * 0.20);
  	
  		int startx = (int) size.width / 2;
  	  
  		((AndroidDriver)driver).swipe(startx, starty, startx, endy, 1000);*/
  	

		
		driver.findElement(By.id("search_widget_textbox")).click();
		driver.findElement(By.id("search_autoCompleteTextView")).sendKeys("asuz zenfone \n");
		
		Thread.sleep(50000);
		
		driver.findElement(By.xpath("//android.view.View[@bounds='[306,119][540,194]']")).click();
		
		Thread.sleep(15000);
		
		WebElement ele = driver.findElement(By.xpath("//android.view.View[bounds='[45,308][495,311]']"));
		
		//WebElement to = driver.findElement(By.xpath("//android.view.View[@bounds='[161,289][199,327]']"));
		
		
		int a = ele.getLocation().getX();
		int end = ele.getSize().getWidth();
		int b = ele.getLocation().getY();
		
		int moveTo=(int)(end*0.4);
		
		TouchAction action=new TouchAction((MobileDriver) driver);
		
		action.press(a,b).moveTo(moveTo,b).release().perform();
		
		//((AndroidDriver)driver).swipe(25,144+25,300,144+24,3000);
		
		
		//driver.findElement(By.xpath("//android.widget.TextView[@bounds='[12,132][528,192]']")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("//android.view.View[@bounds='[0,264][540,477]']")).click();
		//Thread.sleep(7000);
		//driver.findElement(By.xpath("//android.widget.TextView[@bounds='[13,913][168,938]']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.widget.RelativeLayout[@bounds='[468,36][528,120]']")).click();
		
	}

}
