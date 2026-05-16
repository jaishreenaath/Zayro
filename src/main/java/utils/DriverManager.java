package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static void set(WebDriver driver) {
		
		tdriver.set(driver);
	}

	public static WebDriver get()
	{
		return tdriver.get();
	}
	
	public static void unload()
	{
		
		tdriver.remove(); // To remove the old objects in thread local memory
		
	}
}
