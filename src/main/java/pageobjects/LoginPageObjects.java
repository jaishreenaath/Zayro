package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class LoginPageObjects {
	
	WebDriver driver;
	
	public LoginPageObjects(WebDriver driver) {
		
		this.driver = DriverManager.get();
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "username_email")
	private WebElement loginUsername;
	
	@FindBy(id = "password")
	private WebElement loginPassword;
	
	@FindBy(id = "submit")
	private WebElement loginButton;

	
	public WebElement getLoginUsername() {
		return loginUsername;
	}

	public WebElement getLoginPassword() {
		return loginPassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
}


