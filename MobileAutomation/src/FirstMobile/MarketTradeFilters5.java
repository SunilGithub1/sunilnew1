package FirstMobile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class MarketTradeFilters5 extends CommonClassForMobile{
	
	
	@Test
	public void FilterCrieteria5() throws InterruptedException, IOException 	{
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/toolTabList")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addstockselect")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on market price pop-up");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/stock_sort")).click();
		
		System.out.println("clicked on sort by filter");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/postdatesort")).click();
		
		System.out.println("clicked on dealer price Sort");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/stock_sort_apply")).click();
		
		System.out.println("clicked on apply sort filter");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tools_filter")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on filter icon");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/certified_level")).click();
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filter_all_cars")).click();
		
		System.out.println("clicked on all cars");
		
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
		
		int moveTo1 = (int) (0.3 * width1);
	
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
		
		int moveTo2 = (int) (0.2 * width);
	
		TouchAction action2 = new TouchAction(driver);
		
		action.longPress(PointOption.point(left2,top2))
  	  .moveTo(PointOption.point(moveTo2,top2))
  	  .release().perform();
		
		System.out.println("Dragging from left in year");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filterby_apply")).click();
		
		System.out.println("clicked on APPLY button");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/stockTab")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on Stocks in main page");
		
		driver.findElement(By.xpath("//android.widget.TextView[@index='0']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on Booked stocks");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tools_filter")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on filter icon again to verify the filtered crieteria is still there");
}
}
