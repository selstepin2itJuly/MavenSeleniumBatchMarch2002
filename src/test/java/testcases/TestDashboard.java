package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TestDashboard {
	private static WebDriver dr;
	LoginPage lp;
	DashboardPage db;
  @Test
  public void TC003() {
	  lp.enterUsername("Admin");
	  lp.enterPassword("admin123");
	  lp.clickOnLoginButton();
	  assertTrue(db.dashboardVisible());
	  assertTrue(db.dashboardContent());
	
  }
  @Test
  public void TC004() {
	  String[] arr= {"Admin", "PIM","Leave", "Time","Recruitment","Performance","Dashboard","Directory","Maintenance"};
	  List<String> str = db.getTabData();
	  assertEquals(str.size(),9);
	  int i=0;
	  for(String s:str) 
	  {
		  assertEquals(s.trim(),arr[i]);
		  i++;
	  }
	  
  }
  @Test
  public void TC005() {
	  String[] arr= {"Assign Leave", "Leave List","Timesheets"};
	  List<String> str = db.getQuickLinkData();
	  assertEquals(str.size(),3);
	  int i=0;
	  for(String s:str) 
	  {
		  assertEquals(s.trim(),arr[i]);
		  i++;
	  }
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  dr=TestBase.getBrowserInstance();
	  lp=new LoginPage(dr);
	  db=new DashboardPage(dr);
  }

  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
