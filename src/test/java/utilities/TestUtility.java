package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.TestBase;

public class TestUtility extends TestBase{

	public static void scrollToElement(WebElement ele) {
		//JavascriptExecutor je=(JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)", "");	
	}
	public static void clickOnElementByJE(WebElement ele) 
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}
	public static void sendKeysJE(WebElement ele, String str) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+str+"'", ele);
	}
	
	public static void captureScreenShot() throws IOException 
	{
		TakesScreenshot cr=(TakesScreenshot) driver;
		File file = cr.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(getDate()+"_image"+".jpg"));
	}
	
	public static String getDate() 
	{
		Date dt=new Date();
		System.out.println(dt);
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss_SS");
		String str = sdf.format(dt);
		System.out.println(str);
		return str;
	}
	//Explicit Wait time
	public static void waitForElementVisible(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static boolean isElementDisplayed(WebElement ele) 
	{
		boolean b=false;
		try {
			b=ele.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
