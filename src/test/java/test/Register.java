package test;

import org.apache.hc.core5.net.Host;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
	
	public static WebDriver driver;
	
	

    // Method that returns a 2D array
    public static String[][] getLoginData() {

        // Creating a 2D array
        String[][] data = {
            
                {"abu","abu@mailinator.com", "Shree!123","Shree!123"},
                
                {"ibu","ibu@mailinator.com", "Shree@123","Shree@123"},
                
                {"muthu","muthu@mailinator.com", "Shree#123","Shree#123"},
                
                {"ganesh","ganesh@mailinator.com", "Shree$123","Shree$123"},
                
                {"fayith","fayith@mailinator.com", "Shree%123","Shree%123"},
                
                {"vicky","vicky@mailinator.com", "Shree^123","Shree^123"},
                
                {"irwin","irwin@mailinator.com", "Shree&123","Shree&123"},
                
   
        };

        return data; // returning the array to use in main
    }
    
    
    // Method that returns a 2D array
    public static String[][] getLoginData1() {

        // Creating a 2D array
        String[][] data1 = {
            
                {"karthi","karthi@mailinator.com", "Shree(123","Shree(123"},
                
                {"mouli","mouli@mailinator.com", "Shree*123","Shree*123"},
                
                {"praveen","praveen@mailinator.com", "Shree)123","Shree)123"},
                
                {"rajesh","rajesh@mailinator.com", "Shree-123","Shree-123"}, // -->
                
                {"naveen","naveen@mailinator.com", "Shree_123","Shree_123"}, // -->
                
                {"sibu","sibu@mailinator.com", "Shree<123","Shree<123"},
                
                {"mathan","mathan@mailinator.com", "Shree>123","Shree>123"},
                
                {"saran","saran@mailinator.com", "Shree?123","Shree?123"}, // -->
                
                {"guru","guru@mailinator.com", "Shree/123","Shree/123"},
                
                {"viyas","viyas@mailinator.com", "Shree\123","Shree\123"},
                
                {"prem","prem@mailinator.com", "Shree{123","Shree{123"},
                
                {"dayal","dayal@mailinator.com", "Shree}123","Shree}123"},
                
                {"prasath","prasath@mailinator.com", "Shree:123","Shree:123"},
                
                {"krish","krish@mailinator.com", "Shree;123","Shree;123"},
                
                {"dhiyanesh","dhiyanesh@mailinator.com", "Shree.123","Shree.123"},
                
                {"suresh","suresh@mailinator.com", "Shree,123","Shree,123"},
                
                {"vijay","vijay@mailinator.com", "Shree|123","Shree|123"},
                
                {"ajith","ajith@mailinator.com", "Shree=123","Shree=123"},
                
   
        };

        return data1; // returning the array to use in main
    }
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions o = new ChromeOptions();
		
		o.addArguments("--start-maximized");
		
		driver = new ChromeDriver(o);
		
		driver.get("https://new.demozab.com/zayro/userpanel/signup");
		
		Thread.sleep(3000);

		// Calling the method that returns 2D array
        String[][] loginData = getLoginData1();

       
        for (int i = 0; i < loginData.length; i++) {
            
        	driver.findElement(By.id("username")).sendKeys(loginData[i][0]);
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("email")).sendKeys(loginData[i][1]);
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("password")).sendKeys(loginData[i][2]);
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='eye-slash']")).click();
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("password-confirm")).sendKeys(loginData[i][3]);
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='eye-slash']")).click();
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("terms-agreement")).click();
    		
    		Thread.sleep(1000);
    		
    		driver.findElement(By.id("submit")).click();
    		
    		Thread.sleep(5000);
    		
    		driver.navigate().refresh();
    		
    		Thread.sleep(2000);
    		

        }


		
	}

}
