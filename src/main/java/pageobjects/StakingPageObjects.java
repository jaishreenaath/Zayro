package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StakingPageObjects {
	
	WebDriver driver;
	
	public StakingPageObjects(WebDriver driver)
	{
		
		this.driver = driver;
		
		PageFactory.initElements(driver , this);
		
	}
	
	@FindBy(id = "earnlink")
	private WebElement earn;
	
	@FindBy(xpath = "//a[.='Overview']")
	private WebElement overview;
	
	@FindBy(xpath = "//table[@id='table1']//tbody//tr[1]//td//a[.='Subscribe']")
	private WebElement subscribe;
	
	@FindBy(id = "document1")
	private WebElement interestcreditsch;
	
	@FindBy(id = "code")
	private WebElement subscriptionamount;
	
	public WebElement getEarn() {
		return earn;
	}

	public WebElement getOverview() {
		return overview;
	}

	public WebElement getSubscribe() {
		return subscribe;
	}

	public WebElement getInterestcreditsch() {
		return interestcreditsch;
	}

	public WebElement getSubscriptionamount() {
		return subscriptionamount;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getConfirm() {
		return confirm;
	}

	@FindBy(id = "savingcheck")
	private WebElement checkbox;
	
	@FindBy(id = "savingbtn")
	private WebElement confirm;
	
	
	
}	
