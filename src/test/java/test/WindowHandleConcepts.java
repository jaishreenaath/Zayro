package test;

import java.util.Iterator;
import java.util.Set;

import org.apache.hc.core5.net.Host;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleConcepts {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions o = new ChromeOptions();
		
		o.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(o);
		
		driver.get("https://www.amazon.com/");
		
		Thread.sleep(2000);
		
		String zero = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.myntra.com/");
		
		Thread.sleep(2000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.snapdeal.com/");
		
		Thread.sleep(2000);
		
		Set<String> all = driver.getWindowHandles();
		
		for (String handle : all) {
			
			if(!handle.equals(zero))
			{
				 driver.switchTo().window(handle); 
				 
				 Thread.sleep(1000);
				
				driver.close();
				
				Thread.sleep(1500);
			}
			
		}
		
		
		
		
		
	}

}
