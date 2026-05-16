package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class ForgotPasswordPageObjects {
	
	WebDriver driver;
	
	public ForgotPasswordPageObjects(WebDriver driver)
	{
		this.driver = DriverManager.get();
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "reset")
	private WebElement resetButton;
	
	@FindBy(id = "email")
	private WebElement emailField;
	
	@FindBy(id = "submit")
	private WebElement submitButton;
	
	@FindBy(id = "otp")
	private WebElement emailotpField;

	@FindBy(id = "password")
	private WebElement newPasswordField;
	
	@FindBy(id = "password-confirm")
	private WebElement confirmNewPasswordField;
	
	@FindBy(id = "submit")
	private WebElement updatePasswordButton;


	public WebElement getResetButton() {
		return resetButton;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getEmailotpField() {
		return emailotpField;
	}

	public WebElement getNewPasswordField() {
		return newPasswordField;
	}

	public WebElement getConfirmNewPasswordField() {
		return confirmNewPasswordField;
	}

	public WebElement getUpdatePasswordButton() {
		return updatePasswordButton;
	}
	
	
}

