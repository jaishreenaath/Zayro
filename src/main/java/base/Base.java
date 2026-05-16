package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.DriverManager;
import utils.DriverSetup;

public class Base extends DriverSetup{
	
	public static ExtentSparkReporter spark;
	
	public static ExtentReports extent;
	
	public static void startreport()
	{
		spark = new ExtentSparkReporter("./Report//Staking.html");
		
		extent = new ExtentReports();
		
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Project Name", "Zayro");
		
		extent.setSystemInfo("Tester Name", "Jaishreenaatth");
	}
	
	public static void stopreport()
	{
		extent.flush();
	}
	
	public static void mailinator(String email)
	{
		
		String parent = DriverManager.get().getWindowHandle();
		
		DriverManager.get().switchTo().newWindow(WindowType.TAB);
		
		DriverManager.get().get("https://www.mailinator.com/");
		
		hold(3000);
		
		WebElement searchbox = xpath("//input[@name='search']");
		
		sendkey(searchbox, email);
		
		hold(2000);
		
		searchbox.sendKeys(Keys.ENTER);
		
		hold(4000);
		
		WebElement verifyemail = xpath("(//table)[3]//tr//td[contains(.,'Verify Email Address')]");
			
		verifyemail.click();

		hold(2000);

		DriverManager.get().switchTo().frame("html_msg_body");

		WebElement verifylink = xpath("//a[contains(text(),'Confirm Email Address')]");

		verifylink.click();

		hold(2000);
		
		Set<String> all = DriverManager.get().getWindowHandles();
		
		DriverManager.get().close();
		
		hold(2000);
		
		driver.switchTo().window(parent);
		
		hold(1000);
		
	}
	
	public static String mailinatorgetotp(String email)
	{
		String parent = DriverManager.get().getWindowHandle();
		
		hold(1500);
		
		DriverManager.get().switchTo().newWindow(WindowType.TAB);
		
		DriverManager.get().get("https://www.mailinator.com/");
		
		hold(3000);
		
		WebElement searchbox = xpath("//input[@name='search']");
		
		sendkey(searchbox, email);
		
		hold(2000);
		
		searchbox.sendKeys(Keys.ENTER);
		
		hold(4000);
		
		WebElement verifyemail = xpath("(//table)[3]//tr//td[contains(.,'Verification Code')]");
			
		verifyemail.click();

		hold(4000);

		DriverManager.get().switchTo().frame("html_msg_body");

		WebElement verifylink = xpath("(//td//span)[2]");

		String otp = verifylink.getText();
		
		Set<String> windows = driver.getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		DriverManager.get().close();
		
		DriverManager.get().switchTo().window(parent);
		
		hold(2000);
		
		return otp;

		
	}
	
	public static void cli(WebElement ele)
	{
		ele.click();
	}
	
	public static void url(String url)
	{
		
		DriverManager.get().get(url);
	
	}
	
	public static void sendkey(WebElement e, String value)
	{
		e.sendKeys(value);
	}
	
	public static void hold(int a)
	{
		try {
			Thread.sleep(a);
			
		} catch (InterruptedException e) {
			
			e.getMessage();
			
			e.printStackTrace();
		}
	}
	
	public static WebElement id(String a)
	{
		return DriverManager.get().findElement(By.id(a));
	}
	
	public static WebElement name(String a)
	{
		return DriverManager.get().findElement(By.name(a));
	}
	
	public static WebElement xpath(String a)
	{
		return DriverManager.get().findElement(By.xpath(a));
	}
	
	public static void windows(int a)
	{
		String parent = DriverManager.get().getWindowHandle();
		
		Set<String> all = DriverManager.get().getWindowHandles();
		
		List<String> li = new ArrayList<String>();
		
		DriverManager.get().switchTo().window(li.get(a));
	}
	
	public static void iframe(String a)
	{
		DriverManager.get().switchTo().frame(a);
	}
	
	public static String screenshot()
	{
		TakesScreenshot tk = (TakesScreenshot)driver;
		
		return tk.getScreenshotAs(OutputType.BASE64);
	}
	
	public static void dropdown(WebElement ele, String value)
	{
		
		Select s = new Select(ele);
		
		List<WebElement> all = s.getOptions();
		
		for (int i = 0; i < all.size(); i++) 
		{
			
			WebElement el = all.get(i);
			
			String one = all.get(i).getText();
			
			if (one.equalsIgnoreCase(value)) 
			{
		
				el.click();
				
				break;
				
			}

		}
	}
	


}
