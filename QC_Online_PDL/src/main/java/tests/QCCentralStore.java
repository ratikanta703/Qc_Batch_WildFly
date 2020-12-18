

package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

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

public class QCCentralStore extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	
	public static void check_clear_dropdown(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("Clear");
			String sheetName = "Clear";

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
					test.log(LogStatus.INFO, "********* Clear From Central Store (2997) started ********");
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
		
						 driver.findElement(By.name("transactionList")).sendKeys("Clear");
						 test.log(LogStatus.PASS, "Transaction Type is selected as Clear");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						 Thread.sleep(500);
							if (driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).isDisplayed()){
								test.log(LogStatus.PASS, "Finish Clear Button Displayed");
								driver.findElement(By.name("requestBean.chkName")).click();
								test.log(LogStatus.PASS, "Clicked on Check Box");
								Thread.sleep(500);
								driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).click();
								test.log(LogStatus.PASS, "Clicked on Finish Clear");		                       					
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Clear From Central Store(2997) Transaction Dropdown Completed ");																											
								//driver.close();	
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "Finish Clear Button not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
					
						 //break;														
									
					
					}				
	}
	
	public static void check_clear_menu(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("Clear");
			String sheetName = "Clear";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String StoreID = TestData.getCellData(sheetName, "StoreID", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* Check Clear Menu From Central Store (2997) started ********");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.linkText("Collateral Checks")).click();						
					test.log(LogStatus.PASS, "Clicked on Collateral Checks Link");	
					Thread.sleep(3000);
					driver.findElement(By.linkText("Payday Loan")).click();	
					test.log(LogStatus.PASS, "Clicked on Payday Link");
					Thread.sleep(3000);
					driver.findElement(By.linkText("Clear")).click();	
					test.log(LogStatus.PASS, "Clicked on Clear Link");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.locationNbr")).clear();					
					Thread.sleep(2000);
					driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
					test.log(LogStatus.PASS, "Store Number updated to :" +StoreID);
					Thread.sleep(2000);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Submit Button");
					Thread.sleep(8000);
					if (driver.findElement(By.name("requestBean.chkName")).isDisplayed()){
						driver.findElement(By.name("requestBean.chkName")).click();
						test.log(LogStatus.PASS, "Clicked on Check box");
						Thread.sleep(500);
						driver.findElement(By.name("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Clear");
						Thread.sleep(500);
						if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
							driver.findElement(By.name("checkno")).click();
							test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Clear Transaction From 2997 Menu is Completed Successfully");
							/*Thread.sleep(1000);
							driver.close();*/	
							Thread.sleep(1000);
							break;
						}
						else
						{
							test.log(LogStatus.FAIL, "Clear Transaction is  not Completed Successfully ");}																													
						 Assert.assertTrue(false);
						driver.close();	
						break;
						
					}
				}
			}
			

	}
					
}				
					
					
				
				
	
	
	
	


