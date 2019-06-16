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
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    public class MainProcurementLead {
	private static final String MobileElement = null;
	XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    
    public static Logger log = Logger.getLogger(MainProcurementLead.class.getName());
	
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

				 
				    @Test(dataProvider="ProcurementLead")
				    public void test(String LeadStatus, String CustomerName, String MobileNO, String EmailID, String CustomerAddress, String pincode, String City, String ManufacturedYear, String ManufacturedMonth, String Colour, String KMs, String Owner, String LeadSource, String Make, String ModelAndVariant, String CustomerExpct, String BuyingQuote, String RegdYear, String RegdMonth, String RegdNo, String Insurance, String RefSource, String ExecInfo, String StockVinNo, String VerifyLead) throws InterruptedException, IOException {
					
					 MobileElement email = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email"));
					 
					 Thread.sleep(4000);
						 
						 WebDriverWait wait = new WebDriverWait(driver, 10);
					        
						 wait.until(ExpectedConditions.visibilityOf(email));
					        
						 boolean isElementPresent = email.isDisplayed();
					        
						 System.out.println(isElementPresent);
						 
						 Thread.sleep(4000);
						 
						 driver.findElementById("com.mfcwl.mfc_dealer:id/email").clear();
					        
						 driver.findElementById("com.mfcwl.mfc_dealer:id/email").sendKeys("prestige");
						 
						 System.out.println("Entered ID");
						
						 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).clear();
						 driver.findElement(By.id("com.mfcwl.mfc_dealer:id/password")).sendKeys("Mahindra");
						 
						 log.info("Entered password");
						 
						 System.out.println("Entered Password");
				 
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/email_sign_in_button")).click(); //to login
						
						log.info("clicked on login");
						
						System.out.println("Signed IN");
						
						Thread.sleep(4000);
						
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/homeTab")).click(); //to click on home button
						
						log.info("clicked on Home");
						
						System.out.println("Clicked on Home button");
						
						Thread.sleep(3000);
						
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addStockTab")).click(); //to click on + button
					    
						log.info("clicked on + Icon");
						
						System.out.println("Clicked on + Icon");
				 
						 // to click on procurement lead
				
						 driver.findElement(By.xpath("//android.widget.TextView[@text = 'Add Proc. Lead']")).click();
						 
						 log.info("clicked on Add procurement lead");
						 
						 System.out.println("clicked on Add procurement lead");
				 
						Thread.sleep(2000);
						
						// TO CLICK ON CALENDER
						
						driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leaddate")).click();
						
						MobileElement e26 = (MobileElement) driver.findElementByAccessibilityId("01 February 2019");
						e26.click(); 
						
				
					MobileElement e27 = (MobileElement) driver.findElementById("android:id/button1");
						 		e27.click();
						 		
					log.info("Selected Date");
					
					System.out.println("Selected Date");			
							 
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leadstatus")).click(); // to select lead status
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+LeadStatus+"']")).click();
							
				Thread.sleep(2000);
				
				log.info("Selected Lead status");
				 
				System.out.println("Selected Lead status");
								
				WebElement Name = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Name']"));
							   
				Name.sendKeys(CustomerName);
				
				log.info("Entered Customer Name");
				
				System.out.println("Entered Customer Name");
				
				WebElement Mobile =  driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile No.']"));
				
				Mobile.sendKeys(MobileNO);
				
				log.info("Entered Mobile No");
				
				System.out.println("Entered Mobile No");
								
				
				WebElement Email = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Email ID']"));
								
			
				Email.sendKeys(EmailID);
				
				log.info("Entered EmailID");
				
				System.out.println("Entered EmailID");
				
				
				WebElement Address = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Address']"));
								
				Address.sendKeys(CustomerAddress);
				
				log.info("Entered CustomerAddress");
				
				System.out.println("Entered CustomerAddress");
				
				WebElement Pincode = driver.findElementByXPath("//android.widget.EditText[@text='Enter Pincode']");
								
				Pincode.sendKeys(pincode);
				
				log.info("Entered pincode");
				
				System.out.println("Entered pincode");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_city")).click(); //TO CLICK CITY DROPDOWN
				
				 
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+City+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected City");
				
				System.out.println("Selected City");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_years")).click();
				
	
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+ManufacturedYear+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected Manf. Year");
				
				System.out.println("Selected Manf. Year");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_month")).click();
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+ManufacturedMonth+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected Manf. Month");
				
				System.out.println("Selected Manf. Month");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_color")).click();
				
				 driver.findElement(By.xpath("//android.widget.TextView[@text='"+Colour+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected Colour");
				
				System.out.println("Selected Colour");
				
				(new TouchAction(driver))
		        .press(PointOption.point(535, 1702))
		        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		        .moveTo(PointOption.point(474, 642))
		        .release()
		        .perform();
				
				WebElement KMs1 = driver.findElementByXPath("//android.widget.EditText[@text='Enter kms']");
				
				KMs1.sendKeys(KMs);
				
				log.info("Entered KM's");
				
				System.out.println("Entered KM's");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_owner")).click();
				
				 
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+Owner+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected Owner");
				
				System.out.println("Selected Owner");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_leadsource")).click();
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+LeadSource+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected LeadSource");
				
				System.out.println("Selected LeadSource");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_make")).click();
				
				 
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+Make+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected Make");
				
				System.out.println("Selected Make");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_modelVariant")).click();
				
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+ModelAndVariant+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Selected ModelAndVariant");
				
				System.out.println("Selected ModelAndVariant");
				
				WebElement Expect = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Expectation']"));
				
				 Expect.sendKeys(CustomerExpct);
				 
				 log.info("Entered CustomerExpct");
					
				System.out.println("Entered CustomerExpct");
				
				WebElement Quote = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter a buying quote']"));
				
				Quote.sendKeys(BuyingQuote);
				
				log.info("Entered BuyingQuote");
				
				System.out.println("Entered BuyingQuote");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_reg_years")).click();
				
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+RegdYear+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Entered RegdYear");
				
				System.out.println("Entered RegdYear");
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_add_prod_reg_month")).click();
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+RegdMonth+"']")).click();
				
				Thread.sleep(2000);
				
				log.info("Entered RegdMonth");
				
				System.out.println("Entered RegdMonth");
				
				(new TouchAction(driver))
		        .press(PointOption.point(535, 1702))
		        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		        .moveTo(PointOption.point(474, 642))
		        .release()
		        .perform();
				
				WebElement RegdNumber = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Reg.No']"));
				
				RegdNumber.sendKeys(RegdNo);
				
				Thread.sleep(2000);
				
				log.info("Entered RegdNo");
				
				System.out.println("Entered RegdNo");
			
				
				driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_insurance")).click();
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='"+Insurance+"']")).click();
		
				Thread.sleep(2000);
				
				log.info("Selected Insurance");
				
				System.out.println("Entered Insurance");
				
				driver.findElement(By.xpath("//android.widget.TextView[@text='Select Exp.Date']")).click();
				
				MobileElement e29 = (MobileElement) driver.findElementByAccessibilityId("10 February 2019");
				 e29.click(); 
				
		
				 	MobileElement e30 = (MobileElement) driver.findElementById("android:id/button1");
				 	e30.click();
				 	
				 	log.info("Selected Date");
					
					System.out.println("Selected Date");
				 	
				 	 WebElement RefeSource = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter a ref source']"));
					
					RefeSource.sendKeys(RefSource);
					
					Thread.sleep(2000);
					
					log.info("Entered RefSource");

					System.out.println("Entered RefSource");
							
					driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prod_exeInfo")).click();
					
					driver.findElement(By.xpath("//android.widget.TextView[@text='"+ExecInfo+"']")).click();
					
					log.info("Entered ExecInfo");

					System.out.println("Entered ExecInfo");
					
					
					WebElement StockVin = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Stock Vin Number']"));
		
					StockVin.sendKeys(StockVinNo);
					
					Thread.sleep(2000);
					
					log.info("Entered StockVinNo");

					System.out.println("Entered StockVinNo");
					
					driver.findElement(By.xpath("//android.widget.TextView[@text='Select Date']")).click();
					
					
					MobileElement e31 = (MobileElement) driver.findElementByAccessibilityId("10 February 2019");
					e31.click(); 
				
		
				 	MobileElement e32 = (MobileElement) driver.findElementById("android:id/button1");
				 	e32.click();
				 	
				 	log.info("Selected Date");

					System.out.println("Selected Date");
				
				
				 	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/tv_prodRemark")).sendKeys("ok");
				 	
				 	log.info("Entered Remark");

					System.out.println("Entered Remark");
				 	
				 	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/add_proc_btn")).click();
				 	
				 	log.info("Clicked on Save Button");

					System.out.println("Clicked on Save Button");
				 	
				 	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/leadsTab")).click();
				 	
				 	log.info("Clicked on leadsTab");

					System.out.println("Clicked on leadsTab");
				 	
				 	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/procLeads")).click();
					
					Thread.sleep(3000);
					
					log.info("Clicked on procLeads");

					System.out.println("Clicked on procLeads");
					
					driver.findElementByXPath("//android.widget.TextView[@text='Private Leads']").click();
					
					Thread.sleep(4000);
					
					log.info("Clicked on Private Leads");

					System.out.println("Clicked on Private Leads");
					
					//VERIFICATION
					
					String VerifyLead1=driver.findElementById("com.mfcwl.mfc_dealer:id/proc_leadName").getText();
					
					log.info("To Verify that the entered data is matching");
					
					System.out.println("The Entered data is matching successfully and the Lead Name is :" +VerifyLead1);
					
					driver.findElementById("com.mfcwl.mfc_dealer:id/proc_leadName").click();
					
					Thread.sleep(3000);
					
					Assert.assertTrue(VerifyLead1.equalsIgnoreCase(VerifyLead));
			        
			        Thread.sleep(2000);
			        
			        log.info("Verified with entered data and it is matching");
					
					System.out.println("Verified with entered data and it is matching name is :" +VerifyLead1);
			        
			        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
			        Date date = new Date();
			        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			        String S = "snap";
			        FileUtils.copyFile(scrFile, new File("E:\\software\\mobilescreenshot\\mobilesnap.png"+S+"-"+dateFormat.format(date)+".png"));
			        
			        Thread.sleep(2000);
			        
			        log.info("Screenshot has been taken and saved in E:\\software\\mobilescreenshot location");
					
					System.out.println("Screenshot has been taken and saved in E:\\software\\mobilescreenshot location");
			        
			       
			        driver.findElementByXPath("//android.widget.ImageView[@index='0']").click();
			        
			        log.info("Clicked on back Arrow");
					
					System.out.println("Clicked on back Arrow");
			        
					driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
					
					log.info("Clicked on Menu Bar");
					
					System.out.println("Clicked on Menu Bar");
					
					driver.findElementByXPath("//android.widget.CheckedTextView[@text='Logout']").click();
					
					Thread.sleep(2000);
					
					log.info("Clicked on LogOut Button");
					
					System.out.println("Clicked on LogOut Button");
					
					driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
					
					Thread.sleep(2000);
					
					log.info("Logged out");
					
					System.out.println("Logged out");
					
					}
				    @DataProvider (name = "ProcurementLead")
				    public Object[][] Procurement() throws IOException
				    {
				    	File src = new File("E:\\software\\DataDriverForMobile.xlsx"); //Excel sheet file location get mentioned here
				    	FileInputStream fis = new FileInputStream(src); 
				        workbook = new XSSFWorkbook(fis); //get my workbook 
				        sheet=workbook.getSheet("DataofProcurement");// get my sheet from workbook
				        int Row=sheet.getLastRowNum();  
				        System.out.println(Row);//get my Row which start from 0   
				     
				      //  int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
				        int ColNum= sheet.getRow(0).getLastCellNum(); // get last ColNum 
				         System.out.println(ColNum);
				        Object inputdata[][]= new Object[Row-1][ColNum]; // pass my count data in array

				       /* for (int i=1; i<Row; i++) {
				            XSSFRow row = sheet.getRow(i);
				            for (int j=0; j<ColNum; j++) {
				                XSSFCell cell = row.getCell(j);
				                String value = String.valueOf(cell);
				                inputdata[i-1][j] = value;
				            }}
				        */
				        
				        
				        
				        for (int i=1; i<Row; i++) {
				            XSSFRow row = sheet.getRow(i);
				            for (int j=0; j<ColNum; j++) {
				                XSSFCell cell = row.getCell(j);
				                CellType Cell=cell.getCellType();
				                
				                /*if(Cell==CellType.STRING) {
				                	 String value = String.valueOf(cell);	
				                	 inputdata[i-1][j] = value;
				                }
				                else if(Cell==CellType.FORMULA){
				                	String value =cell.getRichStringCellValue().toString();
				                	inputdata[i-1][j] = value;
				                }*/
				                
				                switch (Cell)
				                {
				                case  STRING:
				                	 String value = String.valueOf(cell);	
				                	 inputdata[i-1][j] = value;	
				                //return inputdata;               

				                case  FORMULA:
				                	String value1 =cell.getRichStringCellValue().toString();
				                	inputdata[i-1][j] = value1;          
				                	//return inputdata;

				                }}}
				      
				    return inputdata;
				        }
				}

				

