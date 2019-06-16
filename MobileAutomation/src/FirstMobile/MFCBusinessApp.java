package FirstMobile;


import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.text.html.ImageView;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AllPermission;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
		
public class MFCBusinessApp {
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
	public static Logger log = Logger.getLogger(MFCBusinessApp.class.getName());
	
			
// public AppiumDriver<MobileElement> driver; // this will depricate some methods
public AndroidDriver<MobileElement> driver;
private WebElement element;
public WebDriverWait wait;
		    
			 @BeforeMethod
		    public void MobileAppiumSetup() throws MalformedURLException, InterruptedException {
				 
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
		    public void ProcurementLead() throws IOException, InterruptedException {
				 
				// excel reading
					File src = new File("E:\\software\\DataDriverForMobile.xlsx");
					
				     FileInputStream fis = new FileInputStream(src);
				
				  	workbook = new XSSFWorkbook(fis);
				
				  	sheet = workbook.getSheetAt(0);
				  	
				  	for(int i = 1; i<=sheet.getLastRowNum(); i++) 
				  		
				  	{
				  	
				  	cell = sheet.getRow(i).getCell(0);
				  	 
				  	cell.setCellType(CellType.STRING);
				 
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
				
		 
				driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.Button")).click(); //to click on + button
			    
				log.info("clicked on + Button");
		 
				 // to click on procurement lead
		
				 driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView[1]")).click();
		 
				Thread.sleep(2000);
				
				log.info("clicked on procurement lead");
				
				// TO CLICK ON CALENDER
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leaddate")).click();
				
				MobileElement e26 = (MobileElement) driver.findElementByAccessibilityId("01 February 2019");
				 e26.click(); 
				
		
				 	MobileElement e27 = (MobileElement) driver.findElementById("android:id/button1");
				 		e27.click();
				 		
				 log.info("clicked on Date");
				 
				
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leadstatus")).click(); // to select lead status
		
		log.info("Clicked on Lead status Dropdown");
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+cell+"']")).click();
	
	   Thread.sleep(2000);
		
	   log.info("Clicked on Lead status");
	   
	    WebElement Name = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Name']"));
	   
	   cell = sheet.getRow(i).getCell(1);
	   
	   Name.sendKeys(cell.getStringCellValue());
		
		log.info("Entered Customer Name");
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile No.']")).sendKeys("9742721634");;
		
		log.info("Entered Mobile Number");
		
		WebElement Email = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Email ID']"));
		
		cell = sheet.getRow(i).getCell(2);
		
		Email.sendKeys(cell.getStringCellValue());
		
		log.info("Entered Email ID");
		
		WebElement Address = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Address']"));
		
		cell = sheet.getRow(i).getCell(3);
		
		Address.sendKeys(cell.getStringCellValue());
		
		log.info("Entered Address");
		
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Pincode']")).sendKeys("560037");;
		
		log.info("Entered Pincode");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_city")).click();
		
		log.info("Clicked On City Name Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[11]")).click();
		
		log.info("Clicked On City");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_years")).click();
		
	    log.info("Clicked On Manufactured year dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[10]")).click();
		
		log.info("Clicked On Year");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_month")).click();
		
		log.info("Clicked On Manufactutred month dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[3]")).click();
		
		log.info("Clicked On Month");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_color")).click();
		
		log.info("Clicked On Colour Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[10]")).click();
		
		log.info("Clicked On Colour");

		(new TouchAction(driver))
        .press(PointOption.point(535, 1702))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(474, 642))
        .release()
        .perform();
		
		log.info("To Scroll Down on screen");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_kms")).sendKeys("5000");
		
		log.info("Entered KM's");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_owner")).click();
		
		log.info("Clicked On Owner Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")).click();
		
		log.info("Clicked On Owner");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leadsource")).click();
		
		log.info("Clicked On Lead Source Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")).click();
		
		log.info("Clicked On Lead Source");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_make")).click();
		
		log.info("Clicked On Make Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[5]")).click();
		
		log.info("Clicked On Make");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_modelVariant")).click();
		
		log.info("Clicked On Model and Variant Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[7]")).click();
		
		log.info("Clicked On Model and Variant");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/et_proc_cust_exp")).sendKeys("100000");
		
		log.info("Entered Customer Expectation");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_remark")).sendKeys("200000");
		
		log.info("Entered Buying Quote");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_reg_years")).click();
		
		log.info("Clicked On Registration year dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[6]")).click();
		
		log.info("Clicked On Year");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_reg_month")).click();
		
		log.info("Clicked On Registration Month dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[8]")).click();
		
		log.info("Clicked On Month");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_reg")).sendKeys("OR07F1226");
		
		log.info("Entered Registration Number");
		
		(new TouchAction(driver))
        .press(PointOption.point(535, 1702))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(474, 642))
        .release()
        .perform();
		
		log.info("To Scroll down on screen");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_insurance")).click();
		
		log.info("Clicked On Insurance Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")).click();
		
		log.info("Clicked On Insurance");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_insuExp")).click();
		
		log.info("Clicked On Insurance Date");
		
		MobileElement e28 = (MobileElement) driver.findElementByAccessibilityId("05 February 2019");
		 e26.click(); 
		
		MobileElement e29 = (MobileElement) driver.findElementById("android:id/button1");
		 		e27.click();	
		 		
		 	log.info("Selected Insurance Expiry Date");
			 
			 
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/et_prod_refsource")).sendKeys("anilaa"); 
		
		log.info("Entered Ref.Source");
			 
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_exeInfo")).click();
		
		log.info("Clicked on Executive Information Dropdown");
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[3]")).click();
			 
		log.info("Clicked on Executive Name");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/et_prod_stockVin")).sendKeys("123");
		
		log.info("Entered Stock Number");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_follwdate")).click();
		
		log.info("Clicked on Follow Date");
		
		MobileElement e30 = (MobileElement) driver.findElementByAccessibilityId("03 February 2019");
		 e26.click(); 
		
		MobileElement e31 = (MobileElement) driver.findElementById("android:id/button1");
		 		e27.click();
		 		
		 log.info("Selected Date");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prodRemark")).sendKeys("ok");
		
		log.info("Entered Remarks");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/add_proc_btn")).click();
		
		log.info("Clicked on Save Button");

		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
		
		log.info("Clicked on Leads Button in Home page");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/procLeads")).click();
		
		Thread.sleep(3000);
		
		log.info("Clicked on Procurement Leads");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Private Leads']").click();
		
		Thread.sleep(2000);
		
		log.info("Clicked on Private Leads Option");
		
		//TO VERIFY THE TEXT PRESENT
	
		String leadName = driver.findElementByXPath("//android.widget.TextView[@text='Shoraff']").getText();
		
		System.out.println( "The Lead is Verified and the lead name is  "  +leadName );
     
        Assert.assertTrue(leadName.equalsIgnoreCase("Shoraff"));
        
        Thread.sleep(2000);
        
        driver.findElementByXPath("//android.widget.TextView[@text='Shoraff']").click(); //TO CLICK ON THE LEAD TO GET FULL DETAILS
        
        Thread.sleep(2000);
		
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String S = "snap";
        FileUtils.copyFile(scrFile, new File("E:\\software\\mobilescreenshot\\mobilesnap.png"+S+"-"+dateFormat.format(date)+".png"));
        
        log.info("Screenshot is saved in E:\\software\\mobilescreenshot location");
		
        Thread.sleep(2000);
        
       
        driver.findElementByXPath("//android.widget.ImageView[@index='0']").click();
        
		driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
		
		driver.findElementByXPath("//android.widget.CheckedTextView[@text='Logout']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
		
		Thread.sleep(2000);
		
		log.info("Logged out");
		
		if(i != sheet.getLastRowNum()) {
			break;
	     	 }
		
			}
	}
		
	
// TO VERIFY AFTER UPDATING THE FOLLOWUP, THE LEAD STATUS IS GETTING UPDATED.

	@Test
	public void Updatefollowup() throws InterruptedException {
		
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
		
		
		driver.findElementByXPath("//android.widget.Button[@index='0']").click();  //to click on home button
		
		Thread.sleep(3000);
		
		log.info("clicked on Home");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
		
		log.info("Clicked on Leads Button in Home page");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/procLeads")).click();
		
		Thread.sleep(3000);
		
		log.info("Clicked on Procurement Leads");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Private Leads']").click();
		
		Thread.sleep(2000);
		
		log.info("Clicked on Private Leads Option");
	
		driver.findElementByXPath("//android.widget.TextView[@text='Shoraff']").click();
		
		Thread.sleep(2000);
		
		log.info("Clicked on recent lead added");
		
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
		
		String LeadStatus = driver.findElementById("com.mfcwl.mfc_dealer:id/proc_leadFollowupHistory").getText();
		
		System.out.println("The Lead Status is Verified and the status is  "+LeadStatus );
     
        Assert.assertTrue(LeadStatus.equalsIgnoreCase("  Warm"));
        
        Thread.sleep(2000);
		
	}




	@Test
	public void AddAsStockVerification() throws InterruptedException {
		
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
		
		
		driver.findElementByXPath("//android.widget.Button[@index='0']").click();  //to click on home button
		
		Thread.sleep(3000);
		
		log.info("clicked on Home");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
		
		log.info("Clicked on Leads Button in Home page");
		
		driver.findElement(By.id("com.mfcwl.mfc_dealer:id/procLeads")).click();
		
		Thread.sleep(3000);
		
		log.info("Clicked on Procurement Leads");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Private Leads']").click();
		
		Thread.sleep(2000);
		
		log.info("Clicked on Private Leads Option");
	
		driver.findElementByXPath("//android.widget.TextView[@text='Shoraff']").click();
		
		Thread.sleep(2000);
		
		log.info("Clicked on recent lead added");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Add as stock']").click();
	}
}

 	 

