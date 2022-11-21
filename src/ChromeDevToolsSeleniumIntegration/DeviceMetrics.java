package ChromeDevToolsSeleniumIntegration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.emulation.Emulation;

public class DeviceMetrics {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();        //using ChromeDriver bcz, WebDriver will not expose DevTools
		
		DevTools devTools = driver.getDevTools();        //create object of devTools
		devTools.createSession();                       //creating session
		
		devTools.send(Emulation.setDeviceMetricsOverride(414, 896, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		Thread.sleep(3000);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
		
		//after performing the actions the browser will get into its default state, that is expected behavior
		
		driver.close();

		
	}

}
