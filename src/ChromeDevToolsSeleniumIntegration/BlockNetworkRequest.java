package ChromeDevToolsSeleniumIntegration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v105.network.Network;
import org.openqa.selenium.devtools.v106.fetch.Fetch;

import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		long startTime = System.currentTimeMillis();
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.tagName("p")).getText());
		long endTime = System.currentTimeMillis();
		
		System.out.println(startTime - endTime);

	}

}
