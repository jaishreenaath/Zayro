package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportPageObjects {
	
	WebDriver driver;
	
	public SupportPageObjects(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[.='Support']")
	private WebElement supportmenu;
	
	@FindBy(id = "createticket")
	private WebElement createticketbtn;
	
	@FindBy(id = "title")
	private WebElement titlesupportfield;
	
	@FindBy(id = "message")
	private WebElement messagesupportfield;
	
	@FindBy(id = "chatsubmit")
	private WebElement submitbtn;
	
	

	public WebElement getSupportmenu() {
		return supportmenu;
	}

	public WebElement getCreateticketbtn() {
		return createticketbtn;
	}

	public WebElement getTitlesupportfield() {
		return titlesupportfield;
	}

	public WebElement getMessagesupportfield() {
		return messagesupportfield;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
}
