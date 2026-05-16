package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class DepositPageObjects {
	
	WebDriver driver;
	
	public  DepositPageObjects(WebDriver driver) {
		
		this.driver = DriverManager.get();	
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//div//a[.='Wallets']")
	private  WebElement walletsLink;
	
	@FindBy(id = "walletlink")
	private  WebElement spotAccount;
	
	@FindBy(xpath = "//table[@id='table1']//tbody//tr[1]//td[5]//button[.='Deposit']")
	private  WebElement depositButton;
	
	@FindBy(id = "currency")
	private  WebElement currencyDropdown;
	
	@FindBy(id = "network")
	private  WebElement networkDropdown;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Address')]")
	private  WebElement addressField;

	public WebElement getWalletsLink() {
		return walletsLink;
	}

	public WebElement getSpotAccount() {
		return spotAccount;
	}

	public WebElement getDepositButton() {
		return depositButton;
	}

	public WebElement getCurrencyDropdown() {
		return currencyDropdown;
	}

	public WebElement getNetworkDropdown() {
		return networkDropdown;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	
	
	

}
