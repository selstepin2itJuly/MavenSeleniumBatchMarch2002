package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr;
	
	public LoginPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//*[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(css="[id='txtPassword']")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	public void enterUsername(String user) 
	{
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() 
	{
		loginButton.click();;
	}
}
