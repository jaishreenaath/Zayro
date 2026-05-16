package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class ProfileSettingsPageObjects {
	
	WebDriver driver;
	
	public ProfileSettingsPageObjects()
	{
		this.driver = DriverManager.get();
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//ul//li//a[@id='profilelink']")
	private WebElement profilelink;
	
	@FindBy(id = "nickname")
	private WebElement nickname;
	
	@FindBy(id = "dob")
	private WebElement dob;
	
	@FindBy(id = "bio")
	private WebElement bio;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement profiledetailsUpdateButton;
	
	@FindBy(xpath = "//div[@class='prediticon']//input[@type='file']")
	private WebElement profilePictureUpload;

	
	public WebElement getProfilelink() {
		return profilelink;
	}

	public WebElement getNickname() {
		return nickname;
	}

	public WebElement getDob() {
		return dob;
	}

	public WebElement getBio() {
		return bio;
	}

	public WebElement getProfiledetailsUpdateButton() {
		return profiledetailsUpdateButton;
	}

	public WebElement getProfilePictureUpload() {
		return profilePictureUpload;
	}
	
	

}



