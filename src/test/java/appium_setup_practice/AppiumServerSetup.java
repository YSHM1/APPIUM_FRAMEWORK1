package appium_setup_practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServerSetup {
	
	@Test
	public void appiumServerLaunchTest() throws MalformedURLException {
		
		AppiumDriverLocalService service = new AppiumServiceBuilder()
											.withAppiumJS(new File("C:/Users/asus/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
											.withIPAddress("http://127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 2 XL_Emulator");
		options.setApp("E:/APPIUM_WORKSPACE/APPIUM_TEST_PRACTICE/src/test/resources/ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.quit();
	}
	
}