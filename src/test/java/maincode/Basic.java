package maincode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.Base;
import pagemanner.PageManner;
import pageobjects.AntiPhishingCodePageObjects;
import pageobjects.ForgotPasswordPageObjects;
import pageobjects.KYCPageObjects;
import pageobjects.LoginPageObjects;
import pageobjects.ProfileSettingsPageObjects;
import pageobjects.RegisterPageObjects;
import pageobjects.SecuritySettingsPageObjects;
import pageobjects.SupportPageObjects;
import pageobjects.changepasswordPageObjects;
import utils.ConfigReader;
import utils.DriverManager;

public class Basic extends Base {
	
	WebDriver driver;
	
	static PageManner pm;
	
	static ConfigReader cr;
	
	JavascriptExecutor js;
	
	
	@BeforeClass
	public void setup()
	{
		startreport();
		
		start();
		
		pm = new PageManner(DriverManager.get());
		
		cr = new ConfigReader();
		
		js = (JavascriptExecutor) DriverManager.get();
		
		driver = DriverManager.get();

	}
	
	@AfterClass
	public void teardown()
	{
		stopreport();
		
	//	end();
		
	}
	
	@Test(priority = 0, enabled = false)
	
	public void register()
	{
		
		ExtentTest test = extent.createTest("Register");
		
		RegisterPageObjects r = pm.registerPage();
		
		url(cr.get("registerurl"));
		
		hold(2000);
		
		sendkey(r.getUsername(), cr.get("username"));
		
		hold(1000);
		
		sendkey(r.getEmail(), cr.get("email"));
		
		hold(1000);
		
		sendkey(r.getPassword(), cr.get("password"));
		
		hold(1000);
		
		sendkey(r.getConfirmPassword(), cr.get("password"));
		
		hold(1000);
		
		r.getTermsAgreement().click();
		
		hold(1000);
		
		r.getSubmitButton().click();
		
		hold(2000);
		
		test.pass("Register Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
		hold(2000);
		
		mailinator(cr.get("email"));

		hold(2000);

	}
	
	@Test(priority = 1,  enabled = true)
	public static void login()
	{
		ExtentTest test = extent.createTest("Login Test");
		
		LoginPageObjects l = pm.loginPage();
		
		url(cr.get("loginurl"));
		
		hold(4000);
		
		sendkey(l.getLoginUsername(), cr.get("email"));
		
		hold(1000);
		
		sendkey(l.getLoginPassword(), cr.get("password"));
		
		hold(1000);
		
		l.getLoginButton().click();
		
		hold(1000);
		
		test.pass("Login Test Passed");
		
		test.info("URL: https://new.demozab.com/zayro/userpanel/login");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
		hold(2000);
	}

	
	@Test(priority = 3, enabled = true)
	public void profilesettings()
	{
		
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		ExtentTest test = extent.createTest("Profile Details Test");
		
		ProfileSettingsPageObjects ps = pm.profilesettingsPage();
		
		ps.getProfilelink().click();
		
		hold(2000);
		
		sendkey(ps.getNickname(), cr.get("username"));
		
		hold(1000);
		
		ps.getDob().click();
		
		hold(1000);
		
		dropdown(xpath("//select[contains(@class,'datepicker__month-select')]"), "june");
		
		hold(1000);
		
		dropdown(xpath("(//select)[2]"), "1996");
		
		hold(1000);
		
		xpath("//div[contains(@class,'react-datepicker__day--keyboard-selected')]").click();
		
		hold(2500);
		
		sendkey(ps.getBio(), "This is demo bio");
		
		hold(1000);
		
		ps.getProfiledetailsUpdateButton().click();
		
		hold(2000);
		
		sendkey(ps.getProfilePictureUpload(), "D:\\Jai\\Test Data\\Validation Images\\Images\\istockphoto-1309328823-612x612.jpg");
		
		hold(3000);
		
		xpath("//*[@local-name='svg' or @ data-icon='check']").click();
		
		hold(2000);
		
		test.pass("Profile Details Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	
	
	@Test(priority = 4, enabled = true)
	public void email2fa()
	{
		ExtentTest test = extent.createTest("Email 2FA Test");
		
		SecuritySettingsPageObjects s = pm.securitysettingspage();
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(3000);
		
		cli(s.getSecuritylink());
		
		hold(2000);
		
				try {
					
					WebElement closeBtn = s.getSecuritypopupclosebtn();
					
					if (closeBtn != null && closeBtn.isDisplayed()) {
						
						try {
							
							js.executeScript("arguments[0].click();", closeBtn);
							
						}
						catch (Exception jsEx) 
						{
							
	
						}
						
						hold(1500);
					}
				}
				catch (Exception e) 
				{
					
				}
		
		cli(s.getEmail2faenablebtn());
		
		hold(2000);
		
		cli(s.getEmail2fagetcodebtn());
		
		hold(1500);
		
		sendkey(s.getEmail2faotpfield(), mailinatorgetotp(cr.get("email")));
		
		hold(2000);
		
		cli(s.getEmail2fasubmitbtn());
		
		hold(1000);
		
		test.pass("Email 2FA Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}

	@Test(priority = 5, enabled = true)
	public void kyc()
	{
		ExtentTest test = extent.createTest("KYC Test");
		
		hold(2000);
		
		KYCPageObjects k = pm.kycpage();
		
		url("https://new.demozab.com/zayro/userpanel/kyc");
		
		hold(3500);
		
		cli(k.getStartkycbutton());
		
		hold(2000);
		
		sendkey(k.getFirstnamefield(), "Sanvi");
		
		hold(1000);
		
		sendkey(k.getLastnamefield(), "Test");
		
		hold(1000);
		
		dropdown(k.getCountrydropdown(), "India");
		
		hold(1000);
		
		dropdown(k.getDocumenttypedropdown(), "Passport");
		
		hold(1000);
		
		sendkey(k.getDocumentnumberfield(), "25658744");
		
		hold(1000);
		
		cli(k.getDocumentexpirydatefield());
		
		hold(4000);
		
	//	cli(xpath("//div[@class='react-datepicker__month']//div[contains(@class,'keyboard-selected ')]//following-sibling::div[2]"));
		
		hold(1000);
		
		sendkey(k.getUploadfrontdocumentbutton(), "D:\\Jai\\Test Data\\Validation Images\\Images\\1.jpg");
		
		hold(2000);
		
		sendkey(k.getUploadbackdocumentbutton(), "D:\\Jai\\Test Data\\Validation Images\\Images\\2.png");
		
		hold(2000);
		
		cli(k.getVerifynowbutton());
	
		hold(5000);
		
		test.pass("KYC Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
	}
	
	
	@Test(priority = 6, enabled = true)
	public void antiphishingcode()
	{
		
		ExtentTest test = extent.createTest("Anti phishing code");
		
		hold(2000);
		
		SecuritySettingsPageObjects s = pm.securitysettingspage();
		
		url("https://new.demozab.com/zayro/userpanel/anticode");
		
		hold(3500);
		
		AntiPhishingCodePageObjects a = pm.antiPhishingCodePage();
		
		cli(a.getCreateantipshbtn());
		
		hold(2000);
		
		cli(a.getGetcodebtn());
		
		hold(1500);
		
		sendkey(a.getEnterotpfield(), mailinatorgetotp(cr.get("email")));
		
		hold(2000);
		
		cli(a.getConfirmbtn());
		
		hold(2000);
		
		sendkey(a.getCreateantiphiscode(), "220696");
		
		hold(2000);
		
		cli(a.getConfirmbtn());
		
		test.pass("Anti phishing code Test Passed");
		
		hold(1000);
			
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	
	@Test(priority = 7, enabled = true)
	public void loginchangepassword()
	{
		
		ExtentTest test = extent.createTest("Login change password");
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(3500);
		
		SecuritySettingsPageObjects s = pm.securitysettingspage();
		
		cli(s.getSecuritylink());
		
		hold(2000);
		
		changepasswordPageObjects le = pm.changepassword();
		
		js.executeScript("arguments[0].scrollIntoView(true)", le.getChangepasswordbtn());
		
		hold(2000);
		
		cli(le.getChangepasswordbtn());
	
		hold(2000);
		
		cli(le.getConfirmbtn());
		
		hold(2000);
		
		String parent = DriverManager.get().getWindowHandle();
		
		hold(1500);
		
		DriverManager.get().switchTo().newWindow(WindowType.TAB);
		
		DriverManager.get().get("https://www.mailinator.com/");
		
		hold(3000);
		
		WebElement searchbox = xpath("//input[@name='search']");
		
		sendkey(searchbox, cr.get("email"));
		
		hold(2000);
		
		searchbox.sendKeys(Keys.ENTER);
		
		hold(4000);
		
		WebElement verifyemail = xpath("(//table)[3]//tr//td[contains(.,'Verification Code')]");
			
		verifyemail.click();

		hold(4000);

		DriverManager.get().switchTo().frame("html_msg_body");

		WebElement verifylink = xpath("//tr[@class='regimgbox']//td//span//b");

		String otp = verifylink.getText();
		
		Set<String> windows = DriverManager.get().getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		DriverManager.get().close();
		
		DriverManager.get().switchTo().window(parent);
		
		hold(2000);
		
		sendkey(le.getVerificationcodefield(), otp);
		
		hold(2000);
		
		cli(le.getConfirmbtn());
		
		hold(2000);
		
		sendkey(le.getCurrentpasswordfield(), cr.get("password"));
		
		hold(2000);
		
		sendkey(le.getNewpasswordfield(), cr.get("newpassword"));
		
		hold(2000);
		
		sendkey(le.getConfirmpasswordfield(),  cr.get("newpassword"));
		
		hold(2000);
		
		cli(le.getConfirmbtn());
		
		hold(3000);
		
		test.pass("Login change password Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	
	
	@Test(priority = 8, enabled = true)
	public void support()
	{
		
		ExtentTest test = extent.createTest("Support Ticket");
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(3500);
		
		SupportPageObjects s = pm.supportpage();
		
		cli(s.getSupportmenu());
		
		hold(2000);
		
		cli(s.getCreateticketbtn());
		
		hold(2000);
		
		sendkey(s.getTitlesupportfield(), "Demo Support Ticket");
		
		hold(2000);
		
		sendkey(s.getMessagesupportfield(), "This is a demo support ticket message.");
		
		hold(2000);
		
		cli(s.getSubmitbtn());
		
		hold(2000);
		
		test.pass("Support Ticket Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());		
		
		
	}
	
	@Test(priority = 9, enabled = true)
	public void forgotpassword()
	{
		
		ExtentTest test = extent.createTest("Forgot Password Test");
		
		url("https://new.demozab.com/zayro/userpanel/dashboard");
		
		hold(3000);
		
		xpath("//a[@id='profiledrp']").click();
		
		hold(1000);
		
		xpath("(//a[@id='logoutlink'])[1]").click();
		
		hold(2000);
		
		ForgotPasswordPageObjects f = pm.forgotPasswor();
		
		f.getResetButton().click();
		
		hold(2000);
		
		sendkey(f.getEmailField(), cr.get("email"));
		
		hold(1000);
		
		f.getSubmitButton().click();
		
		hold(2000);

		String parent = DriverManager.get().getWindowHandle();
		
		hold(1500);
		
		DriverManager.get().switchTo().newWindow(WindowType.TAB);
		
		DriverManager.get().get("https://www.mailinator.com/");
		
		hold(3000);
		
		WebElement searchbox = xpath("//input[@name='search']");
		
		sendkey(searchbox, cr.get("email"));
		
		hold(2000);
		
		searchbox.sendKeys(Keys.ENTER);
		
		hold(4000);
		
		WebElement verifyemail = xpath("(//table)[3]//tr//td[contains(.,'Verification Code')]");
			
		verifyemail.click();

		hold(4000);

		DriverManager.get().switchTo().frame("html_msg_body");

		WebElement verifylink = xpath("(//td/span//b)[3]");

		String otp = verifylink.getText();
		
		Set<String> windows = DriverManager.get().getWindowHandles();
		
		List<String> li = new ArrayList<String>(windows);
		
		DriverManager.get().close();
		
		DriverManager.get().switchTo().window(parent);
		
		hold(2000);
		
		sendkey(f.getEmailotpField(), otp);
		
		hold(1000);
		
		sendkey(f.getNewPasswordField(), cr.get("newpassword"));
		
		hold(1000);
		
		sendkey(f.getConfirmNewPasswordField(), cr.get("newpassword"));
		
		hold(1000);
		
		f.getSubmitButton().click();
		
		test.pass("Forgot Password Test Passed");
		
		test.addScreenCaptureFromBase64String(screenshot());
		
	}
	
}