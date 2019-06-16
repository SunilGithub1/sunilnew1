package FirstMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonClassForMobile {
	
	private static final String MobileElement = null;
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    
    public static Logger log = Logger.getLogger(MainProcurementLead.class.getName());
	
	public AndroidDriver<MobileElement> driver;
	private WebElement element;
	public WebDriverWait wait;
			    
			@BeforeTest
			    public void setup() throws MalformedURLException, InterruptedException {
					 
					 DOMConfigurator.configure("log4j.xml");
			        
			        DesiredCapabilities caps = new DesiredCapabilities();
			        caps.setCapability("automationName", "UiAutomator2");
			        caps.setCapability("deviceName", "sunil");
			        caps.setCapability("udid", "422b21e7");
			        caps.setCapability("platformName", "Android");
			        caps.setCapability("platformVersion", "8.1.0");
			        caps.setCapability("appPackage", "com.mfcwl.mfc_dealer");
			        caps.setCapability("appActivity", "com.mfcwl.mfc_dealer.Activity.SplashActivity");
			        caps.setCapability("autoAcceptAlerts", true);
			        caps.setCapability("noReset", true);
			        caps.setCapability("autoGrantPermissions", true);  // to allow the permission of contacts camara, which comes in the begining when we install the app*/
			        caps.setCapability("unicodeKeyboard", true);  // to make the keyboard working
			        caps.setCapability("resetKeyboard", false);  // it will remove auto input suggetions
			        
				  try
			        {
			        	
			       driver = new AndroidDriver<MobileElement> (new URL("http://0.0.0.0:4723/wd/hub"),caps);
			        }
			        catch(MalformedURLException e)
			        {
			        	System.out.println();
			        }
			         
			        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);
				 }
				 
				@Test
					public void Common() throws InterruptedException{
						
							MobileElement email = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email"));
						 
							Thread.sleep(4000);
							 
							 WebDriverWait wait = new WebDriverWait(driver, 10);
						        
							 wait.until(ExpectedConditions.visibilityOf(email));
						        
							 boolean isElementPresent = email.isDisplayed();
						        
							 System.out.println(isElementPresent);

				  
							 Thread.sleep(4000);
							 
							 driver.findElementById("com.mfcwl.mfc_dealer:id/email").clear();
						        
							 driver.findElementById("com.mfcwl.mfc_dealer:id/email").sendKeys("prestige");
							 
							 log.info("Entered ID");
							
							 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).clear();
							 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).sendKeys("Mahindra");
							 
							 log.info("Entered password");
					 
							driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email_sign_in_button")).click(); //to login
							
							Thread.sleep(4000);
							
							log.info("clicked on login");
							
							
							driver.findElement(By.id("com.mfcwl.mfc_dealer:id/homeTab")).click(); //to click on home button
							
							Thread.sleep(3000);
							
							log.info("clicked on Home");
							
		}
}
