package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllUrl {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://new.demozab.com/zayro/userpanel/signin");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("username_email")).sendKeys("sanvi");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("password")).sendKeys("Shree@123");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.id("submit")).click();
		 
		 Thread.sleep(3000);
		 
		 List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
		 
		 System.out.println("Total number of links: " + allLinks.size());
		 
		 for (WebElement link : allLinks) {
			 
		     String url = link.getAttribute("href");
		     
		     System.out.println(url);
		     
		 }
		 
		
	}
	

}
