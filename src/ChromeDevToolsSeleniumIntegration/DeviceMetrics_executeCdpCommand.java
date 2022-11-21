package ChromeDevToolsSeleniumIntegration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class DeviceMetrics_executeCdpCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//when custom Selenium methods is not present for the required CDP command
		//then we can directly call the CDP commands using executeCdpCommand()
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();        //using ChromeDriver bcz, WebDriver will not expose DevTools
		
		DevTools devTools = driver.getDevTools();        //create object of devTools
		devTools.createSession();                       //creating session
		
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScaleFactor", 50);
		deviceMetrics.put("mobile", true);               //passing only required parameters and leaving the optional parameters
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();
	}

}
