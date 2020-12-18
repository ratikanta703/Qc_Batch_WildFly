package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.StringTokenizer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class QC_Adjust_Interest_Amount_HistoryVerification extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void increased_adjamount_verfication(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* Adjust Interest  Amount Verification From History started ********");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");	
					Thread.sleep(1000);
				}
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");

				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");					
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						 String Adjusted_Amount1 =  driver.findElement(By.xpath("//*[@id='adjInterestHistoryTable']/tbody/tr[3]/td[3]")).getText();	
						 String delims=".";
						 StringTokenizer st=new StringTokenizer(Adjusted_Amount1,delims);
						String Adjusted_Amount=(String) st.nextElement();
						System.out.println(Adjusted_Amount);
						 //================================					
						//String Updated_Adjusted_Amount="50.0";
						char ch1 = Updated_Adjusted_Amount.charAt(0);
						char ch2 = Updated_Adjusted_Amount.charAt(1);
				
						String val=Character.toString(Updated_Adjusted_Amount.charAt(0))+Character.toString(Updated_Adjusted_Amount.charAt(1));
						
						if(Adjusted_Amount.equalsIgnoreCase(val)){						
							 test.log(LogStatus.INFO, "<FONT color=green style=Arial>In History Screen Adjusted Interest Amount is : " +Adjusted_Amount);
							 System.out.println(Adjusted_Amount);										
							 Thread.sleep(1000);										
							 break;
							 } 
							 else {
								 test.log(LogStatus.FAIL,"Adjusted Amount Mismatch");							    
							 }
						//================================
						 Thread.sleep(500);
					
						 break;														
									
					
					}				
	}
	public static void adjamount_verfication(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* Adjust Interest Amount Verification From History started ********");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");	
					Thread.sleep(1000);
				}
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");

				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");					
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						 String Adjusted_Amount =  driver.findElement(By.xpath("//*[@id='adjInterestHistoryTable']/tbody/tr[3]/td[3]")).getText();	
						 test.log(LogStatus.INFO, "<FONT color=green style=Arial>In History Screen Adjusted Amount is : " +Adjusted_Amount);
						
						 Thread.sleep(500);
					
						 break;														
									
					
					}				
	}
	
}
