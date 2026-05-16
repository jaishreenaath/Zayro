package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradePageObjects {
	
	WebDriver driver;
	
	public TradePageObjects(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "tradelink")
	private WebElement spotmenu;
	
	@FindBy(xpath = "(//div[.='Spot'])[2]")
	private WebElement spotlinktradepage;
	
	@FindBy(xpath = "//span[@class='markettabdropbox']//div//a[@id='basic-nav-dropdown']")
	private WebElement marketdropdown;
	
	@FindBy(xpath = "(//table[@class='sitetable table'])[3]//tbody//tr//td[contains(.,'LTC')]")
	private WebElement ltcusdtpair;
	
	@FindBy(id ="buyprice")
	private WebElement buypricefield;
	
	@FindBy(id = "buyvolume")
	private WebElement buyvolumefield;
	
	@FindBy(id = "buylimit_order")
	private WebElement buylimitorderbutton;
	
	@FindBy(xpath = "//a[@id='sellTab']")
	private WebElement selltab;
	
	@FindBy(id ="sellprice")
	private WebElement sellpricefield;
	
	@FindBy(id = "sellvolume")
	private WebElement sellvolumefield;
	
	@FindBy(id = "selllimit_order")
	private WebElement selllimitorderbutton;
	
	

	public WebElement getSpotmenu() {
		return spotmenu;
	}

	public WebElement getSpotlinktradepage() {
		return spotlinktradepage;
	}

	public WebElement getMarketdropdown() {
		return marketdropdown;
	}

	public WebElement getLtcusdtpair() {
		return ltcusdtpair;
	}

	public WebElement getBuypricefield() {
		return buypricefield;
	}

	public WebElement getBuyvolumefield() {
		return buyvolumefield;
	}

	public WebElement getBuylimitorderbutton() {
		return buylimitorderbutton;
	}

	public WebElement getSelltab() {
		return selltab;
	}

	public WebElement getSellpricefield() {
		return sellpricefield;
	}

	public WebElement getSellvolumefield() {
		return sellvolumefield;
	}

	public WebElement getSelllimitorderbutton() {
		return selllimitorderbutton;
	}
	
	
	
}
