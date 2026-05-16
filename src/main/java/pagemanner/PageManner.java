package pagemanner;

import org.openqa.selenium.WebDriver;

import pageobjects.AntiPhishingCodePageObjects;
import pageobjects.DepositPageObjects;
import pageobjects.ForgotPasswordPageObjects;
import pageobjects.KYCPageObjects;
import pageobjects.LoginPageObjects;
import pageobjects.ProfileSettingsPageObjects;
import pageobjects.RegisterPageObjects;
import pageobjects.SecuritySettingsPageObjects;
import pageobjects.StakingPageObjects;
import pageobjects.SupportPageObjects;
import pageobjects.TradePageObjects;
import pageobjects.WithdrawPageObjects;
import pageobjects.changepasswordPageObjects;
import utils.DriverManager;

public class PageManner {
	
	WebDriver driver;
	
	public PageManner(WebDriver driver)
	{
		
		this.driver = DriverManager.get();
		
	}
	
	public RegisterPageObjects registerPage()	
	{
		return new RegisterPageObjects(driver);
		
	}
	
	public LoginPageObjects loginPage()
	{
		
		return new LoginPageObjects(driver);
		
	}
	
	public ForgotPasswordPageObjects forgotPasswor()
	{
		
		return new ForgotPasswordPageObjects(driver);
		
	}
	
	public ProfileSettingsPageObjects profilesettingsPage()
	{
		
		return new ProfileSettingsPageObjects();
		
	}
	
	public SecuritySettingsPageObjects securitysettingspage()
	{
		
		return new SecuritySettingsPageObjects(driver);
		
	}
	
	public KYCPageObjects kycpage()
	{
		
		return new KYCPageObjects(driver);
		
	}
	
	public AntiPhishingCodePageObjects antiPhishingCodePage()
	{
	
		return new AntiPhishingCodePageObjects(driver);
		
	}
	
	public changepasswordPageObjects changepassword()
	{
		return new changepasswordPageObjects(driver);
	}
	
	public SupportPageObjects supportpage()
	{
		return new SupportPageObjects(driver);
	}
	
	public DepositPageObjects depositpage()
	{
		return new DepositPageObjects(driver);
	}
	
	public WithdrawPageObjects withdrawpage()
	{
		return new WithdrawPageObjects(driver);
	}
	
	public TradePageObjects tradepage()
	{
		return new TradePageObjects(driver);
	}
	
	public StakingPageObjects staking()
	{
		return new StakingPageObjects(driver);
	}

}
