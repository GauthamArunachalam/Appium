package AppiumTesting;

import java.net.MalformedURLException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



public class Facebook {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		WebDriver d=null;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"FCAXB704B637732");
		cap.setCapability(MobileCapabilityType.PLATFORM,"ANDROID");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
		cap.setCapability("appPackage", "com.facebook.katana");
		cap.setCapability("appActivity", ".MainActivity"); 
		cap.setCapability(MobileCapabilityType.APP, "B:\\selcontent\\apk\\Facebook.apk");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
		//d.findElement(By.id("selected_country_wrapper")).click();
		//d.findElement(By.xpath("//android.widget.ImageButton[@bounds='[0,36][72,120]']")).click();
		
	}
}
