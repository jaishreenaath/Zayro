package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KYCPageObjects {
	
	WebDriver driver;
	
	public KYCPageObjects(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	// KYC elements
	
	@FindBy(xpath = "//li//a[@id='securitylink']")
	private WebElement securitylink;
	
	@FindBy(xpath = "//button[@aria-label='Close' and @type='button']")
	private WebElement securitypopupclosebtn;
	
	@FindBy(id ="kycbtn")
	private WebElement kycbutton;
	
	@FindBy(id ="startkyc")
	private WebElement startkycbutton;
	
	@FindBy(name ="firstname")
	private WebElement firstnamefield;
	
	@FindBy(name ="lastname")
	private WebElement lastnamefield;
	
	@FindBy(xpath ="//select[@name='country']")
	private WebElement countrydropdown;
	
	@FindBy(xpath ="//select[@name='document_type']")
	private WebElement documenttypedropdown;
	
	@FindBy(name ="document_number")
	private WebElement documentnumberfield;
	
	@FindBy(xpath ="//input[@placeholder='Select expiry date']")
	private WebElement documentexpirydatefield;
	
	@FindBy(xpath ="//input[@id='fileInput1' and @type='file']")
	private WebElement uploadfrontdocumentbutton;
	
	@FindBy(xpath ="//input[@id='fileInput2' and @type='file']")
	private WebElement uploadbackdocumentbutton;
	
	@FindBy(xpath ="//button[.='Verify Now']")
	private WebElement verifynowbutton;


	public WebElement getKycbutton() {
		return kycbutton;
	}

	public WebElement getStartkycbutton() {
		return startkycbutton;
	}

	public WebElement getFirstnamefield() {
		return firstnamefield;
	}

	public WebElement getLastnamefield() {
		return lastnamefield;
	}

	public WebElement getCountrydropdown() {
		return countrydropdown;
	}

	public WebElement getDocumenttypedropdown() {
		return documenttypedropdown;
	}

	public WebElement getDocumentnumberfield() {
		return documentnumberfield;
	}

	public WebElement getDocumentexpirydatefield() {
		return documentexpirydatefield;
	}

	public WebElement getUploadfrontdocumentbutton() {
		return uploadfrontdocumentbutton;
	}

	public WebElement getUploadbackdocumentbutton() {
		return uploadbackdocumentbutton;
	}

	public WebElement getVerifynowbutton() {
		return verifynowbutton;
	}

}
