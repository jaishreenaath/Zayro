package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class changepasswordPageObjects {
	
	WebDriver driver;
	
	public changepasswordPageObjects(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="changepassword_btn")
	private WebElement changepasswordbtn;
	
	@FindBy(xpath="//button[.='Confirm']")
	private WebElement confirmbtn;
	
	@FindBy(id="verificode")
	private WebElement verificationcodefield;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement currentpasswordfield;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement newpasswordfield;
	
	@FindBy(xpath="(//input[@type='password'])[3]")
	private WebElement confirmpasswordfield;
	

	public WebElement getChangepasswordbtn() {
		return changepasswordbtn;
	}
	

	public WebElement getConfirmbtn() {
		return confirmbtn;
	}

	public WebElement getVerificationcodefield() {
		return verificationcodefield;
	}

	public WebElement getCurrentpasswordfield() {
		return currentpasswordfield;
	}

	public WebElement getNewpasswordfield() {
		return newpasswordfield;
	}

	public WebElement getConfirmpasswordfield() {
		return confirmpasswordfield;
	}
	
	
	

}
