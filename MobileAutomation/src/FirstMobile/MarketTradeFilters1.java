package FirstMobile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.testng.Assert;
import org.apache.commons.compress.archivers.sevenz.CLI;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MarketTradeFilters1 extends CommonClassForMobile{
	
	@Test
	public void FilterCrieteria() throws InterruptedException, IOException 	{
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/toolTabList")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addstockselect")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on market price pop-up");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tools_filter")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on filter icon");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/certified_level")).click();
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filter_cetified_car")).click();
		
		System.out.println("clicked on certified cars");
		
//		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filter_all_cars")).click();
		
//		System.out.println("clicked on all cars");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/certified_level")).click();
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filter_price_card")).click();
		
		WebElement seekbar = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/twoseekar"));
		
		driver.findElementById("com.mfcwl.mfc_dealer:id/twoseekar").click();
		
		System.out.println("drigging from right in selling price");
		
		//LOCATION OF BAR FROM LEFT
		
		int left = seekbar.getLocation().getX();
		
		//LOCATION OF BAR FROM TOP
		
		int top = seekbar.getLocation().getY();
		
		//WIDTH OF THE BAR
		
		int width = seekbar.getSize().getWidth();
		
		int moveTo = (int) (0.4 * width);
	
		TouchAction action = new TouchAction(driver);
		
		action.longPress(PointOption.point(left,top))
  	  .moveTo(PointOption.point(moveTo,top))
  	  .release().perform();
		
		System.out.println("Dragging from left in selling price");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filter_delear_price")).click();
		
		WebElement seekbar1 = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/threeseekar"));
		
		driver.findElementById("com.mfcwl.mfc_dealer:id/threeseekar").click();
		
		System.out.println("drigging from right in dealer price");
		
		//LOCATION OF BAR FROM LEFT
		
		int left1 = seekbar1.getLocation().getX();
		
		//LOCATION OF BAR FROM TOP
		
		int top1 = seekbar1.getLocation().getY();
		
		//WIDTH OF THE BAR
		
		int width1 = seekbar1.getSize().getWidth();
		
		int moveTo1 = (int) (0.5 * width1);
	
		TouchAction action1 = new TouchAction(driver);
		
		action1.longPress(PointOption.point(left1,top1))
  	  .moveTo(PointOption.point(moveTo1,top1))
  	  .release().perform();
		
		System.out.println("Dragging from left in dealer price");
		
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/kms_level")).click();
		
		driver.findElementById("com.mfcwl.mfc_dealer:id/filter_seekbar").click();
		
		System.out.println("dragging from right in KMS");
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/yearicon")).click();
		
		WebElement seekbar2 = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/year_seekbar"));
		
		//LOCATION OF BAR FROM LEFT
		
		int left2 = seekbar2.getLocation().getX();
		
		//LOCATION OF BAR FROM TOP
		
		int top2 = seekbar2.getLocation().getY();
		
		//WIDTH OF THE BAR
		
		int width2 = seekbar2.getSize().getWidth();
		
		int moveTo2 = (int) (0.6 * width);
	
		TouchAction action2 = new TouchAction(driver);
		
		action.longPress(PointOption.point(left2,top2))
  	  .moveTo(PointOption.point(moveTo2,top2))
  	  .release().perform();
		
		System.out.println("Dragging from left in year");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filterby_apply")).click();
		
		System.out.println("clicked on APPLY button");
		
		Thread.sleep(2000);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String S = "snap";
        FileUtils.copyFile(scrFile, new File("E:\\software\\mobilescreenshot\\mobilesnap.png"+S+"-"+dateFormat.format(date)+".png"));
        
        System.out.println("Screenshot has been taken and stored in E:\\software\\mobilescreenshot folder location");
	}
}


