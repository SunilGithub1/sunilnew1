package FirstMobile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AddStockProcLead extends CommonClassForMobile{
	
	@Test
	public void AddStock() throws InterruptedException{
		
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
		
		log.info("Clicked on Leads Tab");
		
		System.out.println("Clicked on Leads Tab");
		 	
	 	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/procLeads")).click();
		
		Thread.sleep(3000);
		
		log.info("Clicked on procLeads");
		
		System.out.println("Clicked on procLeads");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Private Leads']").click();
		
		Thread.sleep(4000);
		
		log.info("Clicked on Private Leads");

		System.out.println("Clicked on Private Leads");
		
		driver.findElementById("com.mfcwl.mfc_dealer:id/proc_leadName").click();
		
		Thread.sleep(3000);
		
		log.info("Clicked on recently added lead");
		
		System.out.println("Clicked on recently added lead");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Add as stock']").click();
		
		log.info("Clicked on Add as stock");
		
		System.out.println("Clicked on Add as stock");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/stockcategory_tv")).click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Retail']")).click();
		
		log.info("Clicked on stock category");
		
		System.out.println("Clicked on stock category");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/sellingptv")).sendKeys("500000");
		
		log.info("Entered Selling Price");
		
		System.out.println("Entered Selling Price");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/dealerptv")).sendKeys("40000");
		
		log.info("Entered Dealer Price");
		
		System.out.println("Entered Dealer Price");
		
		(new TouchAction(driver))
        .press(PointOption.point(535, 1702))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(474, 642))
        .release()
        .perform();
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addstock_nextbtn")).click();
		
		log.info("Clicked on Next button");
		
		System.out.println("Clicked on Next button");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/chassisnotv")).sendKeys("RTMHSDEK64839K");
		
		log.info("Clicked on Chassis No");
		
		System.out.println("Clicked on Chassis No");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/enginenotv")).sendKeys("ENGINENUM345");
		
		log.info("Clicked on Engine No");
		
		System.out.println("Clicked on Engine No");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/boughttv")).sendKeys("274578");
		
		log.info("Clicked on Bought Price");
		
		System.out.println("Clicked on Bought Price");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/refuretv")).sendKeys("2000");
		
		log.info("Clicked on Refurbishment Cost");
		
		System.out.println("Clicked on Refurbishment Cost");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/cngkittv")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Company Fitted']")).click();
		
		log.info("Selected CNG kit");
		
		System.out.println("Selected CNG kit");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/editcmts")).sendKeys("Ok");
		
		log.info("Entered Comments");
		
		System.out.println("Entered Comments");
		
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();

}
}
