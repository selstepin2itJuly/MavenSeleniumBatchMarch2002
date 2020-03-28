package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver dr;
	
	public DashboardPage(WebDriver driver) 
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="menu_dashboard_index")
	WebElement dashboardTab;
	
	@FindBy(css=".head > h1")
	WebElement dashboardContent;
	
	@FindBy(css=".firstLevelMenu b")
	List<WebElement> tabMenu;
	
	@FindBy(css="span.quickLinkText")
	List<WebElement> quickLink;
	public boolean dashboardVisible() 
	{
		boolean b=false;
		try {
			b=dashboardTab.isDisplayed();
		}catch(Exception e) {
			
		}
		return b;
	}
	public boolean dashboardContent() 
	{
		boolean b=false;
		try {
			b=dashboardContent.isDisplayed();
		}catch(Exception e) {
			
		}
		return b;
	}
	
	public List<String> getTabData(){
		List<String> data= new ArrayList<String>();
		for(WebElement e:tabMenu) {
			System.out.println(e.getText());
			data.add(e.getText());
		}
		return data;
	}
	public List<String> getQuickLinkData(){
		List<String> data= new ArrayList<String>();
		for(WebElement e:quickLink) {
			System.out.println(e.getText());
			data.add(e.getText());
		}
		return data;
	}
}
