package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class RegisterPageObjects {
	
	WebDriver driver;
	
	public RegisterPageObjects(WebDriver driver)
	{
		this.driver = DriverManager.get();
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id ="email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "password-confirm")
	private WebElement confirmPassword;
	
	@FindBy(id = "terms-agreement")
	private WebElement termsAgreement;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		
		return username;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getTermsAgreement() {
		return termsAgreement;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	
}
