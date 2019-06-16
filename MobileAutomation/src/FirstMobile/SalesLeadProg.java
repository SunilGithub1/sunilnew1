package FirstMobile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import java.net.MalformedURLException;

public class SalesLeadProg extends CommonClassForMobile{
	
					@Test(priority=0)
			        public void DashboardTotalLeads() throws MalformedURLException, InterruptedException {
			        
			        driver.findElement(By.id("com.mfcwl.mfc_dealer:id/click_lead")).click();
			        
			        Thread.sleep(2000);
			        
			        System.out.println("Clicked on sales follow-up lead");
			        
			        driver.findElement(By.id("com.mfcwl.mfc_dealer:id/lead_filter_linear")).click();
			        
			        System.out.println("clicked on filter button");
			        
			  WebElement chk = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/chfollowtoday"));
			  
			  if(chk.isEnabled()) {
				  
				  System.out.println("POSTED DATE IS SELECTED IN TOTAL LEADS");
			  }
			  else {
				  System.out.println("POSTED DATE IS NOT SELECTED IN TOTAL LEADS");
			  }
			  
			  driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			  
			}
					
			@Test(priority=1)
			public void DashboardWebLeads() throws MalformedURLException, InterruptedException{
				
		        
		        driver.findElement(By.xpath("//android.widget.TextView[@text=' Web Leads ']")).click();
		        
		        Thread.sleep(2000);
		        
		        System.out.println("clicked on webleads");
				
		        driver.findElement(By.id("com.mfcwl.mfc_dealer:id/lead_filter_linear")).click();
		        
		        System.out.println("clicked on filter button");
		        
		  WebElement chk = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/chfollowtoday"));
		  
		  if(chk.isEnabled()) {
			  
			  System.out.println("POSTED DATE IS SELECTED IN WEBLEADS");
		  }
		  else {
			  System.out.println("POSTED DATE IS NOT SELECTED IN WEBLEADS");
		  } 
		  
		  driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
		  
		}
			
			@Test(priority=2)
			public void DashboardPrivateLeads() throws MalformedURLException, InterruptedException{
		        
		        driver.findElement(By.xpath("//android.widget.TextView[@text='Private Leads']")).click();
		        
		        Thread.sleep(2000);
		        
		        System.out.println("clicked on private leads");
		        
		        driver.findElement(By.id("com.mfcwl.mfc_dealer:id/lead_filter_linear")).click();
		        
		        System.out.println("clicked on filter button");
		        
		        WebElement chk = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/chfollowtoday"));
				  
				  if(chk.isEnabled()) {
					  
					  System.out.println("POSTED DATE IS SELECTED IN PRIVATELEADS");
				  }
				  else {
					  System.out.println("POSTED DATE IS NOT SELECTED IN PRIVATELEADS");
				  }
				  
				  driver.findElement(By.xpath("//android.widget.ImageButton[@index='0']")).click();
			}
}
					





