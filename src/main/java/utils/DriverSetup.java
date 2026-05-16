package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	
	public static WebDriverWait wait;

	public static void start() {

		if (DriverManager.get() == null) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions c = new ChromeOptions();

			c.addArguments("--start-maximized");

			driver = new ChromeDriver(c);
			
			Duration sec = Duration.ofSeconds(10);
			
			wait = new WebDriverWait(driver, sec);

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(sec);
			
			DriverManager.set(driver);
			
		}

	}

	public static void end() {

		if (DriverManager.get() != null) {

			try {
				
				DriverManager.get().quit();
				
			} 
			catch (Exception e) {

			}

			DriverManager.unload();

			driver = null;
			
			wait = null;

		}

	}

}