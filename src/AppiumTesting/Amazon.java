package AppiumTesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Amazon {
	
	public static void main(String args[]) throws MalformedURLException{
		WebDriver d = null;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "70cd0691");
		cap.setCapability("platform", "Android");
		cap.setCapability("platformVersion", "5.0.2");
		cap.setCapability("app", "B:\\selcontent\\apk\\Amazon Shopping.apk");
		
		d = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}

}
