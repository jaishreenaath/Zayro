package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecuritySettingsPageObjects {
	
	WebDriver driver;
	
	public SecuritySettingsPageObjects(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//li//a[@id='securitylink']")
	private WebElement securitylink;
	
	@FindBy(xpath = "//button[@aria-label='Close' and @type='button']")
	private WebElement securitypopupclosebtn;
	
	@FindBy(id ="googleauth")
	private WebElement googleauthenablebtn;
	
	@FindBy(id ="code")
	private WebElement googleauthcodefield;
	
	@FindBy(xpath ="//button[.='Submit']")
	private WebElement googleauthsubmitbtn;
	
	@FindBy(xpath ="//a[@class='alink']")
	private WebElement backlink;
	

	public WebElement getSecuritylink() {
		return securitylink;
	}

	public WebElement getSecuritypopupclosebtn() {
		return securitypopupclosebtn;
	}

	public WebElement getGoogleauthenablebtn() {
		return googleauthenablebtn;
	}

	public WebElement getGoogleauthcodefield() {
		return googleauthcodefield;
	}

	public WebElement getGoogleauthsubmitbtn() {
		return googleauthsubmitbtn;
	}

	public WebElement getBacklink() {
		return backlink;
	}
	
	
	// Email 2FA elements
	
	@FindBy(id ="emailauth")
	private WebElement email2faenablebtn;
	
	@FindBy(xpath ="//span[.='Get Code']")
	private WebElement email2fagetcodebtn;
	
	@FindBy(xpath ="//input[@placeholder='Enter OTP']")
	private WebElement email2faotpfield;
	
	@FindBy(id ="confirm")
	private WebElement email2fasubmitbtn;
	

	public WebElement getEmail2faenablebtn() {
		return email2faenablebtn;
	}

	public WebElement getEmail2fagetcodebtn() {
		return email2fagetcodebtn;
	}

	public WebElement getEmail2faotpfield() {
		return email2faotpfield;
	}

	public WebElement getEmail2fasubmitbtn() {
		return email2fasubmitbtn;
	}

	
	
}
