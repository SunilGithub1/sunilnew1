package FirstMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.asm.Advice.Enter;

public class JustTry {
	private static final String MobileElement = null;
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    
    public static Logger log = Logger.getLogger(JustTry.class.getName());
	
	public AndroidDriver<MobileElement> driver;
	private WebElement element;
	public WebDriverWait wait;
			    
				 @BeforeMethod
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
				    public void test() throws InterruptedException, IOException {
					
					
					 MobileElement email = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email"));
					 
					 Thread.sleep(4000);
						 
						 WebDriverWait wait = new WebDriverWait(driver, 10);
					        
						 wait.until(ExpectedConditions.visibilityOf(email));
					        
						 boolean isElementPresent = email.isDisplayed();
					        
						 System.out.println(isElementPresent);
						 
						 Thread.sleep(4000);
						 
						 driver.findElementById("com.mfcwl.mfc_dealer:id/email").clear();
					        
						 driver.findElementById("com.mfcwl.mfc_dealer:id/email").sendKeys("newgen");
						 
						 log.info("Entered ID");
						
						 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).clear();
						 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).sendKeys("super123");
						 
						 log.info("Entered password");
				 
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email_sign_in_button")).click(); //to login
						
						log.info("clicked on login");
						
						Thread.sleep(4000);
						
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/homeTab")).click(); //to click on home button
						
						log.info("clicked on Home");
						
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
			 		 	
					 	log.info("Clicked on leadsTab");
						
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
						
						driver.findElementByXPath("//android.widget.TextView[@text='Update follow-up']").click();
						
						log.info("Clicked on update follow up button");
						
						driver.findElementByXPath("//android.widget.Spinner[@index='0']").click(); //TO CLICK ON LEAD STATUS DROPDOWN
						
						log.info("Clicked on Lead status dropdown");
						
						driver.findElementByXPath("//android.widget.CheckedTextView[@index='2']").click(); 
						
						log.info("Clicked on Lead status");
						
						driver.findElementByXPath("//android.widget.TextView[@text='Select Date']").click();
						
						log.info("Clicked on calender");
						
						MobileElement e30 = (MobileElement) driver.findElementByAccessibilityId("08 February 2019");
						e30.click(); 
						
						MobileElement e31 = (MobileElement) driver.findElementById("android:id/button1");
						 		e31.click();	
						 		
						 	log.info("Selected Next Followup Date");
						 	
						driver.findElementById("com.mfcwl.mfc_dealer:id/edit_Remark").sendKeys("Follow up date updated");	
						
						driver.findElementByXPath("//android.widget.Button[@text='Update Now']").click();
						
						log.info("Clicked on Update followup button");
						
						driver.findElementByXPath("//android.widget.ImageView[@index='0']").click();
						
						String LeadStatus1 = driver.findElementById("com.mfcwl.mfc_dealer:id/proc_leadFollowupHistory").getText();
						
						System.out.println("The Lead Status is Verified and the status is  "+LeadStatus1 );
				     
				        Assert.assertTrue(LeadStatus1.equalsIgnoreCase("  Warm"));
				        
				        Thread.sleep(2000);
				        
				        System.out.println("Lead status is verified and updated in the main page as :" +LeadStatus1);
						
				    }
}


