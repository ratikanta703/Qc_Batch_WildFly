
package tests;

import java.util.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class QCCSR2997_TransactionClear_Validation extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	
	public static void check_clear_dropdown_validation(String SSN, String AppURL) throws InterruptedException {
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
					test.log(LogStatus.INFO, "********* Check Clear From Central Store (2997) Validation started ********");
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
					   Thread.sleep(1000);
						 //driver.findElement(By.name("transactionList")).sendKeys("Clear");
						 //test.log(LogStatus.PASS, "Transaction Type is selected as Clear");
						 Thread.sleep(10000);
						 
						 Select dropdown = new Select(driver.findElement(By.name("transactionList")));
						    //Get all options
						    List<WebElement> dd = dropdown.getOptions();

						    //Total numbe of options
						    System.out.println(dd.size());

						    // Loop to print one by one
						    for (int j = 0; j <= dd.size(); j++) {
						    	
						    	String option=dd.get(j).getText();
						    	System.out.println(option);			    			    
								if (option.trim().equalsIgnoreCase("Clear".trim())) {
									test.log(LogStatus.INFO, "<FONT color=green style=Arial>Option Available Is : " +option);
									test.log(LogStatus.INFO, "******************************************************** ");
									System.out.println(option);										
									Thread.sleep(1000);																
									 break;
							} 			    	
								else {
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Options available in dropdown are : " +option);												    
			}
							
			}
						    break;
						 
																			
									
					
					}				
	}
	
		
}				
					
					
				
				
	
	
	
	


