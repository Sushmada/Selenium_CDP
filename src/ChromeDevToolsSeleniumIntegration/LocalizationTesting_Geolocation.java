package ChromeDevToolsSeleniumIntegration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.emulation.Emulation;

public class LocalizationTesting_Geolocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();        //using ChromeDriver bcz, WebDriver will not expose DevTools
		
		DevTools devTools = driver.getDevTools();        //create object of devTools
		devTools.createSession();                       //creating session
		
		
		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);                                       //latitude and logitude values of Madrid
		coordinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);          //Madrid location has Spain as there local language. the Results will be in spain
		
		//devTools.send(Emulation.setGeolocationOverride(Optional.of(46), Optional.of(9), Optional.of(1)));       //script not working
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		driver.findElement(By.cssSelector(".LC20lb")).click();
		System.out.println(driver.findElement(By.cssSelector(".our-story-card-title")).getText());
	}

}
