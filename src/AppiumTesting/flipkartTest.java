package AppiumTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class flipkartTest {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  
	  WebDriver driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "70cd0691");
		cap.setCapability("platform", "ANDROID");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("app", "B:\\selcontent\\apk\\Flipkart.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("btn_mlogin")).click();
		
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[36,383][446,437]']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//android.widget.LinearLayout[@bounds='[36,491][504,599]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[36,269][420,323]']")).sendKeys("9789403377");
		driver.findElement(By.xpath("//android.widget.Button[@bounds='[36,368][504,428]']")).click();
		
		//Thread.sleep(5000);
		//driver.findElement(By.name("Never")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[12,132][528,192]']")).sendKeys("mobile\n");
		//driver.findElement(By.xpath("//android.widget.TextView[@bounds='[12,132][528,192]']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//android.view.View[@bounds='[0,264][540,477]']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[13,913][168,938]']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.RelativeLayout[@bounds='[468,36][528,120]']")).click();
		
  }
}
