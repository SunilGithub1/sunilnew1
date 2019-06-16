package FirstMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FreshDataProvider {
	
	WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
   
    @Test(dataProvider="ProcurementLead")
    public void test(String LeadStatus, String CustomerName, String MobileNO, String EmailID, String CustomerAddress, String pincode, String City, String ManufacturedYear, String ManufacturedMonth, String Colour, String KMs, String Owner, String LeadSource, String Make, String ModelAndVariant, String CustomerExpct, String BuyingQuote, String RegdYear, String RegdMonth, String RegdNo, String Insurance, String RefSource, String ExecInfo, String StockVinNo, String VerifyLead) {
    	
    	System.out.println(LeadStatus);
    	System.out.println(CustomerName);
    	System.out.println(MobileNO);
    	System.out.println(EmailID);
    	System.out.println(CustomerAddress);
    	System.out.println(pincode);
    	System.out.println(City);
    	System.out.println(ManufacturedYear);
    	System.out.println(ManufacturedMonth);
    	System.out.println(Colour);
    	System.out.println(KMs);
    	System.out.println(Owner);
    	System.out.println(LeadSource);
    	System.out.println(Make);
    	System.out.println(ModelAndVariant);
    	System.out.println(CustomerExpct);
    	System.out.println(BuyingQuote);
    	System.out.println(RegdYear);
    	System.out.println(RegdMonth);
    	System.out.println(RegdNo);
    	System.out.println(Insurance);
    	System.out.println(RefSource);
    	System.out.println(ExecInfo);
    	System.out.println(StockVinNo);
    	System.out.println(VerifyLead);
    	
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

                }
      
                
                
                //String value = String.valueOf(cell);
                
               // String value1=Boolean.valueOf(cell);
              //  inputdata[i-1][j] = value;
            }}
    return inputdata;
        }
}