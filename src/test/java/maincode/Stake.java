package maincode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.warrenstrange.googleauth.GoogleAuthenticator;

import pagemanner.PageManner;
import pageobjects.LoginPageObjects;
import pageobjects.StakingPageObjects;
import utils.ConfigReader;
import utils.DriverManager;

public class Stake extends Basic {

	PageManner p;

	JavascriptExecutor js;

	ConfigReader c;

	LoginPageObjects l;

	public int googleotp() {

		String secretKey = "GSO6JK2BWTP7GLAF";

		GoogleAuthenticator gAuth = new GoogleAuthenticator();

		int otp = gAuth.getTotpPassword(secretKey);

		return otp;

	}

	public void loggg() {

		l = pm.loginPage();

		driver.get(cr.get("loginurl"));

		hold(4000);

		sendkey(l.getLoginUsername(), "rithin");

		hold(1000);

		sendkey(l.getLoginPassword(), cr.get("password"));

		hold(1000);

		l.getLoginButton().click();

		hold(2000);

//		sendkey(id("otpcode"), String.valueOf(googleotp()));
//
//		hold(1000);
//
//		cli(xpath("//button[.='Submit']"));

		hold(2000);

	}

	@BeforeClass
	public void initial() {
		
		startreport();

		start();

		pm = new PageManner(DriverManager.get());

		cr = new ConfigReader();

		js = (JavascriptExecutor) DriverManager.get();

	}

	@AfterClass
	public void teardownn() {
		end();
	}

	@Test(priority = 0)
	public void stake() {
		
		ExtentTest test = extent.createTest("Staking");
	
		loggg();
		
		hold(2500);
		
		StakingPageObjects s = pm.staking();
		
		url("https://new.demozab.com/zayro/userpanel/earn");
		
		hold(4000);
		
		cli(xpath("(//button[.='Invest Now'])[2]"));
		
		sendkey(xpath("//input[@placeholder='Enter amount']"), "28");
		
		hold(2000);
		
		cli(id("savingcheck"));
		
		hold(1500);
		
		cli(xpath("//button[.='Confirm']"));
		
		hold(3000);
		
		url("https://new.demozab.com/zayro/userpanel/earnhistory");
		
		hold(3000);
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(1000);
		
		WebElement closebtb = xpath("//button[@aria-label='Close']");
		
		cli(closebtb);
		
		hold(1000);
		
		cli(id("morelink"));
		
		cli(xpath("//div[@class='tableicon']//span[.='Referral']"));
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(1000);
		
		WebElement closebtb1 = xpath("//button[@aria-label='Close']");
		
		cli(closebtb1);
		
		hold(1000);
		
		cli(xpath("//li//a//div[.='Referral Overview']"));	
		
		hold(5000);
		
		test.addScreenCaptureFromBase64String(screenshot());
		
		test.pass("Staking successfully completed");
		
		

	}
	
	@Test(priority = 1)
	public void referral()
	{
		
		ExtentTest test = extent.createTest("Referral and Affiliate");
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(500);
		
		WebElement closebtb = xpath("//button[@aria-label='Close']");
		
		cli(closebtb);
		
		hold(1000);
		
		cli(id("morelink"));
		
		hold(1000);
		
		cli(xpath("//div[@class='tableicon']//span[.='Affiliate']"));
		
		hold(1500);
		
		cli(xpath("//a[.='Become an Affiliate']"));
		
		hold(1500);
		
		sendkey(id("nickname"), "Rithin");
		
		dropdown(id("affiliatetype"), "Developer / Trading Tools");
		
		hold(1000);
		
		dropdown(id("language"), "English");
		
		hold(1000);
		
		sendkey(id("contactinfo"), "Test");
		
		hold(1000);
		
		dropdown(id("country"), "India");
		
		hold(1000);
		
		dropdown(id("promoplatform"), "Telegram");
		
		hold(1000);
		
		cli(xpath("//div//input[@id='twitter']"));
		
		hold(1000);

		sendkey(id("description"), "Test Description");
		
		hold(1000);
		
		sendkey(id("hearingplatform"), "Zayro Instagram");
		
		hold(1000);
		
		cli(xpath("//button[.='Submit Application']"));
		
		hold(1500);
		
		test.addScreenCaptureFromBase64String(screenshot());
		
		test.pass("Referral and Affiliate passed succesfully");
	}
	
	

}
