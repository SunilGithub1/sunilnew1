package FirstMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TotalStoreStocks extends CommonClassForMobile{
	
	@Test(priority=0)
	
	public void StoreStocksVerification() throws InterruptedException {
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/click_stock")).click();
		
		Thread.sleep(2000);
		
		System.out.println("clicked on store stocks page");
		
		WebElement store = driver.findElement(By.xpath("//android.widget.TextView[@text='Store Stocks']"));
		
		if(store.isDisplayed()) {
			
			System.out.println("Test is passed and showing store stock listing page");
		}
		else {
			System.out.println("Test is failed and store stock listing page is not showing");
		}
		
	} 
	
	@Test(priority=1)
	public void StoreStocksFilter() throws InterruptedException{
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/stock_filter")).click();
		
		System.out.println("clicked on filter icon");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/thirtydaycheckbox")).click();
		
		System.out.println("clicked on >30 days old check box");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/filterby_apply")).click();
		
		System.out.println("clicked on apply button");
		
		WebElement store = driver.findElement(By.xpath("//android.widget.TextView[@text='Store Stocks']"));
		
		if(store.isDisplayed()) {
			
			System.out.println("Test is passed and showing store stock listing page after applying filter");
		}
		else {
			System.out.println("Test is failed and store stock listing page is not showing after applying filter");
		}
		
	}

}
