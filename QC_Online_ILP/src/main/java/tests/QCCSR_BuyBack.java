
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

public class QCCSR_BuyBack extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void buyback(String SSN, String AppURL) {
		try {
						int lastrow = TestData.getLastRow("BuyBackLoan");
			String sheetName = "BuyBackLoan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName,"StateID",row);
					
					 
	
					 SSN1 = SSN.substring(0, 3);
					 SSN2 = SSN.substring(3,5);
					 SSN3 = SSN.substring(5,9);
					
					 
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"############ Buy Back started #############");
				   driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();			
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);				
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");					    					   					     
				    
				    Thread.sleep(5000);					  
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
			
					 driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button");
					 Thread.sleep(5000);
					 loan_nbr=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
					 test.log(LogStatus.PASS, "Loan Number is :" + loan_nbr);
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button");
					 Thread.sleep(5000);
					 driver.findElement(By.name("transactionList")).sendKeys("Buy Back");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Buy Back");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String Paymentamt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Payment amount is :"+Paymentamt);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Paymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+Paymentamt);
					 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered");
					 driver.findElement(By.name("finish")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Buyback");
					 Thread.sleep(5000);
					 try { 
						    Alert alert = driver.switchTo().alert();
						
						    alert.accept();
						    //if alert present, accept and move on.														
							
						}
						catch (NoAlertPresentException e) {
						    //do what you normally would if you didn't have the alert.
						}
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkno")).click();
					 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Buy Back Completed Successfully ");
					 test.log(LogStatus.INFO, "******************************************************** ");
					 Thread.sleep(5000);
					//driver.close();
			break;
					}
				}

				
			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "BuyBack Failed");

		}

	}
	
	public static void buyback_chkcash(String SSN, String AppURL) {
		try {
						int lastrow = TestData.getLastRow("BuyBackLoan");
			String sheetName = "BuyBackLoan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Chk_Nbr = TestData.getCellData(sheetName, "Chk_Nbr", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName,"StateID",row);
					
					 
	
					 SSN1 = SSN.substring(0, 3);
					 SSN2 = SSN.substring(3,5);
					 SSN3 = SSN.substring(5,9);
					
					 
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"############ Buy Back started #############");
				   driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();			
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
					for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);				
				    driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");					    					   					     
				    
				    Thread.sleep(5000);					  
					for( String winHandle1 : driver.getWindowHandles())
					{
					    driver.switchTo().window(winHandle1);
					}			
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
			
					 driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button");
					 Thread.sleep(5000);
					 loan_nbr=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
					 test.log(LogStatus.PASS, "Loan Number is :" + loan_nbr);
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					 test.log(LogStatus.PASS, "Clicked on GO Button");
					 Thread.sleep(5000);
					 driver.findElement(By.name("transactionList")).sendKeys("Buy Back");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Buy Back");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 
				//================================================================================
					    String Paymentamt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
						test.log(LogStatus.PASS, "Actual Paymentamt is :" + Paymentamt);
						
						/*String Fee1 = Paymentamt;
						//string to double 
						double d = Double.parseDouble(Fee1);
						double dd=d-50;
						//double to string 	       
						String PartialPay=String.valueOf(dd);  
						System.out.println(PartialPay); 
						test.log(LogStatus.PASS, "Partial payment Amount is :" + PartialPay);
						Thread.sleep(500);*/
						/*driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
						Thread.sleep(500);
						driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(PartialPay);
						Thread.sleep(500);
						test.log(LogStatus.PASS, "Partial Payment amount entered as :" + PartialPay);*/
						
						
						
						Thread.sleep(500);
						driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
						test.log(LogStatus.PASS, "Tender Type entered as :" + TenderType);									
						Thread.sleep(500);
						driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
						test.log(LogStatus.PASS, "Chk Nbr entered :" +Chk_Nbr);
						Thread.sleep(500);
						driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(Paymentamt);
						test.log(LogStatus.PASS, "Tender amount entered :" + Paymentamt);
						Thread.sleep(500);
						driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);			
						test.log(LogStatus.PASS, "Pin is entered :" + PIN);
						Thread.sleep(500);
						driver.findElement(By.name("finish")).click();
						Thread.sleep(3000);
						test.log(LogStatus.PASS, "Clicked on Finish BuyBack");
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial>BuyBack Transaction Completed Successfully");
						Thread.sleep(5000);
						
						try {
							Alert alert = driver.switchTo().alert();

							alert.accept();
							// if alert present, accept and move on.

						} catch (NoAlertPresentException e) {
							// do what you normally would if you didn't have
							// the alert.
						}
						//Thread.sleep(5000);
						
						 //driver.close();

					 
				//================================================================================	 
		
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkno")).click();
					 //test.log(LogStatus.PASS, "BuyBack Completed Successfully");
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Buy Back Completed Successfully ");
					 test.log(LogStatus.INFO, "******************************************************** ");
					 Thread.sleep(5000);
					//driver.close();
			break;
					}
				}

				
			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "BuyBack Failed");

		}

	}
	
}

