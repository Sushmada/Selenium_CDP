package ChromeDevToolsSeleniumIntegration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(true, 5000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));       //if 1st argument(offline) is set to true then no internet will be there for the test
		
		devTools.addListener(Network.loadingFailed(), request->
		{                                                                     //when test fails due to any of the issues then we can capture the ErrorText and also time when the test failed
			System.out.println(request.getErrorText());
			System.out.println(request.getTimestamp());            //getting error message when there is a network failure
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();

	}

}
