package maincode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import base.Base;
import pagemanner.PageManner;
import pageobjects.DepositPageObjects;
import pageobjects.LoginPageObjects;
import pageobjects.TradePageObjects;
import pageobjects.WithdrawPageObjects;
import utils.ConfigReader;
import utils.DriverManager;
import maincode.Basic;

public class Trade extends Base {

	WebDriver driver;

	PageManner pm;

	ConfigReader cr;

	JavascriptExecutor js;

	@BeforeClass
	public void setup() {
		
		startreport();

		start();

		driver = DriverManager.get();

		pm = new PageManner(DriverManager.get());

		cr = new ConfigReader();

		js = (JavascriptExecutor) DriverManager.get();

//		driver = DriverManager.get();

	}

	@AfterClass
	public void teardown() {
		
		stopreport();

		// end();

	}
	
	public void aa()
	{

		ExtentTest test = extent.createTest("Deposit");

		LoginPageObjects l = pm.loginPage();

		driver.get(cr.get("loginurl"));

		hold(4000);

		sendkey(l.getLoginUsername(), "rithin");

		hold(1000);

		sendkey(l.getLoginPassword(), cr.get("password"));

		hold(1000);

		l.getLoginButton().click();

		hold(4000);

		DepositPageObjects d = pm.depositpage();

		d.getWalletsLink().click();

		hold(2000);

		Actions action = new Actions(driver);

		action.moveToElement(d.getSpotAccount()).build().perform();

		action.click().perform();

		hold(2000);
	}

	@Test(priority = 1, description = "Deposit Test", enabled = true)
	public void deposit() throws IOException, NotFoundException {

		
		ExtentTest test = extent.createTest("Deposit");

		LoginPageObjects l = pm.loginPage();

		driver.get(cr.get("loginurl"));

		hold(4000);

		sendkey(l.getLoginUsername(), "rithin");

		hold(1000);

		sendkey(l.getLoginPassword(), cr.get("password"));

		hold(1000);

		l.getLoginButton().click();

		hold(20000);
		
		cli(xpath("//button[.='Submit']"));
		
		hold(3000);
		
		cli(xpath("//button[@aria-label='Close']"));
		
	//	driver.navigate().refresh();

		DepositPageObjects d = pm.depositpage();
		
		hold(5000);

		d.getWalletsLink().click();

		hold(2000);

		Actions action = new Actions(driver);

		action.moveToElement(d.getSpotAccount()).build().perform();

		action.click().perform();

		hold(2000);

		d.getDepositButton().click();

		hold(2000);

		Select s = new Select(d.getCurrencyDropdown());

		for (int i = 1; i < s.getOptions().size(); i++) {
			
			List<WebElement> all = s.getOptions();
			
			String currencyname = all.get(i).getAttribute("value");

			s.selectByValue(currencyname);

			hold(1000);

			Select s1 = new Select(id("network"));

			for (int j = 1; j < s1.getOptions().size(); j++) {
				
				List<WebElement> allnetworktypes = s1.getOptions();

				hold(600);
				
				allnetworktypes = s1.getOptions();
				
				String networkname = allnetworktypes.get(j).getAttribute("value");

				s1.selectByValue(networkname);

				hold(1000);

				WebElement qrEl = driver.findElement(By.id("qrcode"));
				
				hold(1000);
				
				test.addScreenCaptureFromBase64String(screenshot());
				
				File shot = qrEl.getScreenshotAs(OutputType.FILE);

				BufferedImage img = ImageIO.read(shot); // qr code image ah store panrom ( basically buffered image
														// colors --> red, green, blue values)

				LuminanceSource source = new BufferedImageLuminanceSource(img); // Black and white color ku convert
																				// panorm because zxing understand
																				// panrathuku (ZXing understand where
																				// the black and white squares are in
																				// the QR image. )

				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

				Result result = new MultiFormatReader().decode(bitmap);

				System.out.println(result);
				
				System.out.println("Coinname : "+ currencyname + " Network Type : " + networkname);
				
				hold(300);

			}
			
		}
		
		test.pass("Deposit test passed successfully");
		
	}
	
	@Test(priority = 2, description = "Withdraw Test", enabled = true)
	public void withdraw()
	{
		
		ExtentTest test = extent.createTest("Withdraw");
		
		WithdrawPageObjects w = pm.withdrawpage(); 
		
		hold(2000);
		
		DriverManager.get().get("https://new.demozab.com/zayro/userpanel/withdraw");

		hold(2000);
		
		//cli(id("terms-agreement"));
		
		js.executeScript("arguments[0].click();", id("terms-agreement"));
		
		hold(1000);
		
		js.executeScript("arguments[0].click();", xpath("//button[.='Confirm']"));
		
	//	cli(id("withdrawsubmit"));
		
		hold(1500);
		
		dropdown(w.getCurrencyDropdown(), "LTC");
		
		hold(2000);
		
		sendkey(w.getAddressField(), "LP63ffGr1sZi8n6Gi1Wz7Kwr9xd1SDGd5J");
		
		hold(2000);
		
		sendkey(w.getAmountField(), "2");
		
		hold(2000);
		
		w.getWithdrawSubmitButton().click();
		
		hold(2000);
		
		test.pass("Withdraw test passed successfully");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	
	
	@Test(priority = 3, description = "Trade Test", enabled = true)
	public void trade()
	{
		
		hold(2000);
		
		ExtentTest test = extent.createTest("Trade");

//		LoginPageObjects l = pm.loginPage();
//
//		driver.get(cr.get("loginurl"));
//
//		hold(4000);
//
//		sendkey(l.getLoginUsername(), "kaba");
//
//		hold(1000);
//
//		sendkey(l.getLoginPassword(), cr.get("password"));
//
//		hold(1000);
//
//		l.getLoginButton().click();
//		
//		hold(20000);
//		
//		cli(xpath("//button[.='Submit']"));
//		
//		hold(3000);
		
//		driver.navigate().refresh();
//		
//		hold(5000);
//		
		TradePageObjects t = pm.tradepage();
//		
//		cli(t.getSpotmenu());
//		
//		Actions action = new Actions(driver);
//
//		action.moveToElement(t.getSpotlinktradepage()).build().perform();
//
//		action.click().perform();
//
//		hold(2000);
		
		DriverManager.get().get("https://new.demozab.com/zayro/userpanel/trade");
		
		hold(5000);
		
		cli(t.getMarketdropdown());
		
		hold(2000);
		
//		cli(t.getLtcusdtpair());
//		
//		hold(10000);
		
		cli(xpath("//div[@class='nav-item']//a[.='USDT']"));
		
		hold(1500);
		
		cli(t.getLtcusdtpair());
		
		hold(12000);
		
	//	sendkey(t.getBuypricefield(), "15");
		
		sendkey(t.getBuyvolumefield(), "1");
		
		hold(1000);
		
		cli(t.getBuylimitorderbutton());
		
		hold(2000);
		
		id("confirm").click();
		
		hold(2000);
		
		cli(t.getSelltab());
		
		hold(2000);
		
		cli(xpath("//table[@id='table6']//tbody//tr[1]"));
		
		hold(1000);
		
		cli(t.getSelllimitorderbutton());
		
		hold(3000);
		
		cli(id("confirm"));
		
		test.pass("Trade completed successfully");
		
	//	xpath("//div[@class='openorder griddragoption']//descendant-or-self::a[.='Order History']").click();
		
		hold(1000);
		
		test.pass("Trade completed successfully");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	

}