package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class WithdrawPageObjects {
	
	WebDriver driver;
	
	public WithdrawPageObjects(WebDriver driver) {
		
		this.driver = DriverManager.get();
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//div//a[.='Wallets']")
	private WebElement walletsLink;
	
	@FindBy(id = "walletlink")
	private  WebElement spotAccount;
	
	@FindBy(xpath = "//table[@id='table1']//tbody//tr[1]//td[5]//button[.='Withdraw']")
	private  WebElement withdrawButton;
	
	@FindBy(id = "currency")
	private  WebElement currencyDropdown;
	
	@FindBy(id = "network")
	private  WebElement networkDropdown;
	
	@FindBy(id = "address")
	private  WebElement addressField;
	
	@FindBy(id = "amount")
	private  WebElement amountField;
	
	@FindBy(id = "withdrawsubmit")
	private  WebElement withdrawSubmitButton;

	public WebElement getWalletsLink() {
		return walletsLink;
	}

	public WebElement getSpotAccount() {
		return spotAccount;
	}

	public WebElement getWithdrawButton() {
		return withdrawButton;
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

	public WebElement getAmountField() {
		return amountField;
	}

	public WebElement getWithdrawSubmitButton() {
		return withdrawSubmitButton;
	}
	
	
	
	

}
