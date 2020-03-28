package testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	static WebDriver driver;
	LoginPage lp;
	DashboardPage db;
  @Test
  public void TC001() {
	  System.out.println("TC001");
	  lp.enterUsername("Admin");
	  lp.enterPassword("admin123");
	  lp.clickOnLoginButton();
	  assertTrue(db.dashboardVisible());
  }
  @Test
  public void TC002() {
	  System.out.println("TC002");
	  lp.enterUsername("Admin123");
	  lp.enterPassword("admin123");
	  lp.clickOnLoginButton();
	  assertFalse(db.dashboardVisible());
  }
 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  System.out.println("BeforeMethod");
	  driver=TestBase.getBrowserInstance();
	  lp=new LoginPage(driver);
	  db=new DashboardPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");
  }

}
