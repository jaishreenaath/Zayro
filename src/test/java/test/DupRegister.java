package test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DupRegister {

	private static final String SIGNUP_URL = "https://new.demozab.com/zayro/userpanel/signup";
	
	private static final Duration TIMEOUT = Duration.ofSeconds(10);

	private static void registerUser(WebDriver driver, WebDriverWait wait, String username, String email,
			String password, String confirmPassword) {

		wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).clear();

		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("email")).clear();

		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("password")).clear();

		driver.findElement(By.id("password")).sendKeys(password);

		try {

			driver.findElement(By.xpath("//*[name()='svg' and @data-icon='eye-slash']")).click();

		} catch (Exception e) {

			
		}

		driver.findElement(By.id("password-confirm")).clear();

		driver.findElement(By.id("password-confirm")).sendKeys(confirmPassword);

		try {

			driver.findElement(By.xpath("//*[name()='svg' and @data-icon='eye-slash']")).click();

		} catch (Exception e) {

		}

		driver.findElement(By.id("terms-agreement")).click();

		driver.findElement(By.id("submit")).click();

		try {
			wait.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfElementLocated(
							By.xpath("//div[contains(@class,'alert') or contains(@class,'error')]")),

					ExpectedConditions.urlContains("/userpanel/signup")));
		} catch (Exception e) {

		}
	}

	private static List<String[]> getTestData() {
		return Arrays.asList(
				new String[] { "abu", "abu@mailinator.com", "Shree!123", "Shree!123" },
				new String[] { "ibu", "ibu@mailinator.com", "Shree@123", "Shree@123" },
				new String[] { "muthu", "muthu@mailinator.com", "Shree#123", "Shree#123" },
				new String[] { "ganesh", "ganesh@mailinator.com", "Shree$123", "Shree$123" },
				new String[] { "fayith", "fayith@mailinator.com", "Shree%123", "Shree%123" },
				new String[] { "vicky", "vicky@mailinator.com", "Shree^123", "Shree^123" },
				new String[] { "irwin", "irwin@mailinator.com", "Shree&123", "Shree&123" },

				new String[] { "karthi", "karthi@mailinator.com", "Shree(123", "Shree(123" },
				new String[] { "mouli", "mouli@mailinator.com", "Shree*123", "Shree*123" },
				new String[] { "praveen", "praveen@mailinator.com", "Shree)123", "Shree)123" },
				new String[] { "rajesh", "rajesh@mailinator.com", "Shree-123", "Shree-123" },
				new String[] { "naveen", "naveen@mailinator.com", "Shree_123", "Shree_123" },
				new String[] { "sibu", "sibu@mailinator.com", "Shree<123", "Shree<123" },
				new String[] { "mathan", "mathan@mailinator.com", "Shree>123", "Shree>123" },
				new String[] { "saran", "saran@mailinator.com", "Shree?123", "Shree?123" },
				new String[] { "guru", "guru@mailinator.com", "Shree/123", "Shree/123" },
				new String[] { "viyas", "viyas@mailinator.com", "Shree\123", "Shree\123" },
				new String[] { "prem", "prem@mailinator.com", "Shree{123", "Shree{123" },
				new String[] { "dayal", "dayal@mailinator.com", "Shree}123", "Shree}123" },
				new String[] { "prasath", "prasath@mailinator.com", "Shree:123", "Shree:123" },
				new String[] { "krish", "krish@mailinator.com", "Shree;123", "Shree;123" },
				new String[] { "dhiyanesh","dhiyanesh@mailinator.com", "Shree.123", "Shree.123" },
				new String[] { "suresh", "suresh@mailinator.com", "Shree,123", "Shree,123" },
				new String[] { "vijayjs", "vijayjs@mailinator.com", "Shree|123", "Shree|123" },
				new String[] { "ajith", "ajith@mailinator.com", "Shree=123", "Shree=123" }
				);
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);  

		try {
			driver.get(SIGNUP_URL);

			List<String[]> users = getTestData();

			for (String[] user : users) {

				registerUser(driver, wait, user[0], user[1], user[2], user[3]);

				// refresh to prepare for the next registration
				driver.navigate().refresh();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			}

		} finally {
			// ensure the browser is closed even if a test fails
			if (driver != null) {

				driver.quit();
			}
		}
	}

}
