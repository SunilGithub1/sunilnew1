package FirstMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class UpdateFollowUpProcLead extends CommonClassForMobile{
	
	@Test(dataProvider="ProcurementLead")
	public void UpdateFollowup(String LeadStatus, String CustomerName, String MobileNO, String EmailID, String CustomerAddress, String pincode,String City, String ManufacturedYear, String ManufacturedMonth, String Colour, String KMs, String Owner, String LeadSource, String Make, String ModelAndVariant, String CustomerExpct, String BuyingQuote, String RegdYear, String RegdMonth, String RegdNo, String Insurance, String RefSource, String ExecInfo, String StockVinNo, String VerifyLead) throws InterruptedException, IOException{
		
		
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
	
	// TO MATCH MANF. YEAR IN ADD STOCK PAGE
	
	String STOCKVERIFYMANFYEAR = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addstock_yesrtv")).getText();
	
	System.out.println("Manf. Year present in ADD STOCK PAGE is :"+STOCKVERIFYMANFYEAR);
	
	
	
	if(STOCKVERIFYMANFYEAR.equals(ManufacturedYear)) {
		
		System.out.println("Year is matching as per entered data");
	}
	else {
		
		System.out.println("Year is not matching");
	}
	
	// TO MATCH MANF. MONTH IN ADD STOCK PAGE
	
String STOCKVERIFYMANFMNTH = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/addstock_monthtv")).getText();
	
	System.out.println("Manf. Month present in ADD STOCK PAGE is :"+STOCKVERIFYMANFMNTH);
	
	
	
	if(STOCKVERIFYMANFMNTH.equals(ManufacturedMonth)) {
		
		System.out.println("Month is matching as per entered data");
	}
	else {
		
		System.out.println("Month is not matching");
	}
	
	// TO MATCH MAKE IN ADD STOCK PAGE
	
String STOCKMAKE = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/maketv")).getText();
	
	System.out.println("Make present in ADD STOCK PAGE is :"+STOCKMAKE);
	
	
	
	if(STOCKMAKE.equals(Make)) {
		
		System.out.println("Make is matching as per entered data");
	}
	else {
		
		System.out.println("Make is not matching");
	}
	
	// TO MATCH MODEL AND VARIANT
	
	
String STOCKMODELANDVARIANT = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/modelandvariant")).getText();
	
	System.out.println("ModelAndVariant present in ADD STOCK PAGE is :"+STOCKMODELANDVARIANT);
	
	if(STOCKMODELANDVARIANT.equals(ModelAndVariant)) {
		
		System.out.println("ModelAndVariant is matching as per entered data");
	}
	else {
		
		System.out.println("ModelAndVariant is not matching");
	}
	
//TO ENTER SELLING PRICE
	
	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/sellingptv")).sendKeys("500000");
	
	log.info("Entered Selling Price");
	
	System.out.println("Entered Selling Price");
	
	//TO ENTER DEALER PRICE
	
	driver.findElement(By.id("com.mfcwl.mfc_dealer:id/dealerptv")).sendKeys("40000");
	
	log.info("Entered Dealer Price");
	
	System.out.println("Entered Dealer Price");
	
	
	// TO MATCH REGISTRATION NUMBER
	
String STOCKREGISTRATION = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/regtv")).getText();
	
	System.out.println("Registration no present in ADD STOCK PAGE is :"+STOCKREGISTRATION);
	
	if(STOCKREGISTRATION.equals(RegdNo)) {
		
		System.out.println("Registration no is matching as per entered data");
	}
	else {
		
		System.out.println("Registration no is not matching");
	}
	
	
	// TO MATCH COLOUR
	
String STOCKCOLOUR = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/colortv")).getText();
	
	System.out.println("Colour present in ADD STOCK PAGE is :"+STOCKCOLOUR);
	
	if(STOCKCOLOUR.equals(Colour)) {
		
		System.out.println("Colour is matching as per entered data");
	}
	else {
		
		System.out.println("Colour is not matching");
	}
	
	(new TouchAction(driver))
    .press(PointOption.point(535, 1702))
    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
    .moveTo(PointOption.point(474, 642))
    .release()
    .perform();
	
	// TO MATCH KM's
	
	String STOCKKMs = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/kmstv")).getText();
	
	System.out.println("KM present in ADD STOCK PAGE is :"+STOCKKMs);
	
	if(STOCKKMs.equals(KMs)) {
		
		System.out.println("KM is matching as per entered data");
	}
	else {
		
		System.out.println("KM is not matching");
	}
	
	// TO MATCH OWNER
	
String STOCKOWNER = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/ownertv")).getText();
	
	System.out.println("Owner present in ADD STOCK PAGE is :"+STOCKOWNER);
	
	if(STOCKOWNER.equals(Owner)) {
		
		System.out.println("Owner is matching as per entered data");
	}
	else {
		
		System.out.println("Owner is not matching");
	}
	
	// TO MATCH CITY
	
String STOCKCITY = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/regcitytv")).getText();
	
	System.out.println("City present in ADD STOCK PAGE is :"+STOCKCITY);
	
	if(STOCKCITY.equals(City)) {
		
		System.out.println("City is matching as per entered data");
	}
	else {
		
		System.out.println("City is not matching");
	}
	
	// TO MATCH REGDYEAR
	
	String STOCKREGDYEAR = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/regontv")).getText();
		
		System.out.println("RegdYr present in ADD STOCK PAGE is :"+STOCKREGDYEAR);
		
		if(STOCKREGDYEAR.equals(RegdYear)) {
			
			System.out.println("RegdYr is matching as per entered data");
		}
		else {
			
			System.out.println("RegdYr is not matching");
		}
		
		// TO MATCH REGDMONTH
		
		String STOCKREGDMONTH = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/regmonthtv")).getText();
			
			System.out.println("RegdMnth present in ADD STOCK PAGE is :"+STOCKREGDMONTH);
			
			if(STOCKREGDMONTH.equals(RegdMonth)) {
				
				System.out.println("RegdMnth is matching as per entered data");
			}
			else {
				
				System.out.println("RegdMnth is not matching");
			}
			
			// TO MATCH REGDMONTH
			
			String STOCKINSU = driver.findElement(By.id("com.mfcwl.mfc_dealer:id/instv")).getText();
				
				System.out.println("Ins present in ADD STOCK PAGE is :"+STOCKINSU);
				
				if(STOCKINSU.equals(Insurance)) {
					
					System.out.println("Ins is matching as per entered data");
				}
				else {
					
					System.out.println("ins is not matching");
				}
				
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
				
				Thread.sleep(2000);
				
				DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
		        Date date = new Date();
		        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        String S = "snap";
		        FileUtils.copyFile(scrFile, new File("E:\\software\\mobilescreenshot\\mobilesnap.png"+S+"-"+dateFormat.format(date)+".png"));
		        
		        Thread.sleep(2000);
		        
		        log.info("Screenshot has been taken and saved in E:\\software\\mobilescreenshot location");
				
				System.out.println("Screenshot has been taken and saved in E:\\software\\mobilescreenshot location");
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

