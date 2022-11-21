package ChromeDevToolsSeleniumIntegration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.Response;

public class NetworkLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\W10-Lenovo\\OneDrive\\Desktop\\Udemy_Selenium\\1. driver executables\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//to enable the network domain and to listen all the network calls
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		//to listen to the events triggered we are adding the addListener
		//it accepts 2 parameters command and the consumer object
		//consumer object(request) should be written in lamba expression as below
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			///System.out.println(req.getUrl());  //to get all the requests made
		});
		
		devTools.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			//System.out.println(res.getStatus());     //to get all the response codes
			
			if(res.getStatus().toString().startsWith("4"))       //to get failed responses i.e., API calls which have failed to load
			{
				System.out.println(res.getUrl()+"has failed with"+res.getStatus());
			}
			
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		

	}

}
