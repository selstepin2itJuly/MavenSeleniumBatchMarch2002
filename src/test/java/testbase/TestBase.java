package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver; //class var 
	public static String browser;
	public static Properties prop;
	private static String config;
	public static WebDriver getBrowserInstance() throws IOException {
		config="./src/main/resources/config/config.properties";
		FileInputStream inputfile=new FileInputStream(new File(config));
		prop=new Properties();
		prop.load(inputfile);
		browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeAgent"));
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxAgent"));
			driver=new FirefoxDriver();	
		}else if(browser.equalsIgnoreCase("edge"))
		{
			//System.setProperty("webdriver.edge.driver", prop.getProperty("egdeAgent"));
			driver=new EdgeDriver();
		}else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("ieAgent"));
			driver=new InternetExplorerDriver();
		}else
		{
			Throwable th=new Throwable();
			th.initCause(null);
		}

		
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		//Dimension d=new Dimension(411, 823);
		//driver.manage().window().setSize(d);//411 823
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//implicit wait timer
		return driver;
	}
	
}
