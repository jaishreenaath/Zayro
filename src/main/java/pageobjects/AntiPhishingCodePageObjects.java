package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AntiPhishingCodePageObjects {
	
	WebDriver driver;
	
	public AntiPhishingCodePageObjects(WebDriver driver) { 
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "antipshbtn")
	private WebElement antipshbtnenable;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement createantipshbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter OTP']")
	private WebElement enterotpfield;
	
	@FindBy(xpath = "//span[.='Get Code']")
	private WebElement getcodebtn;
	
	@FindBy(xpath = "//button[.='Confirm']")
	private WebElement confirmbtn;
	
	@FindBy(xpath = "//input[contains(@placeholder,'characters')]")
	private WebElement createantiphiscode;
	

	public WebElement getCreateantiphiscode() {
		return createantiphiscode;
	}

	public WebElement getAntipshbtnenable() {
		return antipshbtnenable;
	}

	public WebElement getCreateantipshbtn() {
		return createantipshbtn;
	}

	public WebElement getEnterotpfield() {
		return enterotpfield;
	}

	public WebElement getGetcodebtn() {
		return getcodebtn;
	}

	public WebElement getConfirmbtn() {
		return confirmbtn;
	}
	
	

}
