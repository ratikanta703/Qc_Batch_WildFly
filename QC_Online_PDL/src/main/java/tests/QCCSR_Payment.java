
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

public class QCCSR_Payment extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	
	public static void writeoff_recovery_fullpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("WORecovery");
			String sheetName = "WORecovery";

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
					test.log(LogStatus.INFO,"############ WO Recovery Full Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("WO Recovery");
					 test.log(LogStatus.PASS, "Transaction Type is selected as WO Recovery");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);				 
				
					 Thread.sleep(500);
					 
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(ActualPaymentAmt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+ActualPaymentAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish WriteOff Recovery");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WO Recovery Full Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "WO Recovery Partial Payment Failed");

		}

	}
	
	
	public static void writeoff_recovery_partialpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("WORecovery");
			String sheetName = "WORecovery";

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
					test.log(LogStatus.INFO,"############ WO Recovery Partial Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("WO Recovery");
					 test.log(LogStatus.PASS, "Transaction Type is selected as WO Recovery");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
				//===================================
					 String Fee1 = ActualPaymentAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish WriteOff Recovery");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WO Recovery Partial Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "WO Recovery Partial Payment Failed");

		}

	}
	
	public static void ach_full_prepayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ACHFullPayment");
			String sheetName = "ACHFullPayment";

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
					test.log(LogStatus.INFO,"############ ACH Full PrePayment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("ACH PrePayment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as ACH prePayment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
				//===================================
					/* String Fee1 = ActualPaymentAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); */
				//===================================
					 /*Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(ActualPaymentAmt);
					 test.log(LogStatus.PASS, "Payment amount is :"+ActualPaymentAmt);*/
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(ActualPaymentAmt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+ActualPaymentAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish ACH Pre Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Full Pre Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "ACH Partial Payment Failed");

		}

	}
	
	public static void ach_partial_prepayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ACHPartialPayment");
			String sheetName = "ACHPartialPayment";

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
					test.log(LogStatus.INFO,"############ ACH Partial PrePayment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("ACH PrePayment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as ACH prePayment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
				//===================================
					 String Fee1 = ActualPaymentAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish ACH Pre Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Partial Pre Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "ACH Partial Payment Failed");

		}

	}
	
	
	public static void achfullpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ACHPartialPayment");
			String sheetName = "ACHPartialPayment";

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
					test.log(LogStatus.INFO,"############ ACH Full Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("ACH Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as ACH Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(ActualPaymentAmt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+ActualPaymentAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish ACH Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Full Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "ACH Full Payment Failed");

		}

	}
	
	public static void achpartialpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ACHPartialPayment");
			String sheetName = "ACHPartialPayment";

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
					test.log(LogStatus.INFO,"############ ACH Partial Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("ACH Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as ACH Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
				//===================================
					 String Fee1 = ActualPaymentAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish ACH Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Partial Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "ACH Partial Payment Failed");

		}

	}
	
	public static void centralstore_achpartialpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("ACHPartialPayment");
			String sheetName = "ACHPartialPayment";

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
					test.log(LogStatus.INFO,"############ Central Store ACH Partial Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("ACH Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as ACH Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String ActualPaymentAmt = driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+ActualPaymentAmt);
					 
				//===================================
					 String Fee1 = ActualPaymentAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered as :"+PIN);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish ACH Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Partial Payment Completed Successfully ");
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
			Assert.assertTrue(false);
			test.log(LogStatus.FAIL, "ACH Partial Payment Failed");

		}

	}

	public static void partialpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("PartialPayment");
			String sheetName = "PartialPayment";

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
					test.log(LogStatus.INFO,"############ Partial Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Partial Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String LoanAmt = driver.findElement(By.name("advAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+LoanAmt);
					 
				//===================================
					 String Fee1 = LoanAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered");
					 driver.findElement(By.name("finish")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Partial Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Partial Payment Completed Successfully ");
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
			test.log(LogStatus.FAIL, "Partial Payment Failed");

		}

	}
	
	public static void fullpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("FullPayment");
			String sheetName = "FullPayment";

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
					test.log(LogStatus.INFO,"############ Full Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("Partial Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Partial Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String LoanAmt = driver.findElement(By.name("advAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Owed amount is :"+LoanAmt);
					 
				/*//===================================
					 String Fee1 = LoanAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
*/					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(LoanAmt);
					 test.log(LogStatus.PASS, "Payment amount is :"+LoanAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(LoanAmt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+LoanAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered");
					 driver.findElement(By.name("finish")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Full Payment Completed Successfully ");
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
			test.log(LogStatus.FAIL, "Partial Payment Failed");

		}

	}
	
	public static void partialdefaultpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("PartialDefaultPayment");
			String sheetName = "PartialDefaultPayment";

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
					test.log(LogStatus.INFO,"############ Partial Default Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("Default Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Default Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String LoanAmt = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Default amount is :"+LoanAmt);
					 
				//===================================
					 String Fee1 = LoanAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); 
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Payment amount is :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(partialpaymentamt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+partialpaymentamt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered");
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Partial Default Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Partial Deault Payment Completed Successfully ");
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
			test.log(LogStatus.FAIL, "Partial Default Payment Failed");

		}

	}
	public static void fulldefaultpayment(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("FullDefaultPayment");
			String sheetName = "FullDefaultPayment";

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
					test.log(LogStatus.INFO,"############ Full Default Payment started #############");
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
					 driver.findElement(By.name("transactionList")).sendKeys("Default Payment");
					 test.log(LogStatus.PASS, "Transaction Type is selected as Default Payment");
					 driver.findElement(By.name("button")).click();
					 test.log(LogStatus.PASS, "Clicked on Go button");
					 Thread.sleep(500);	
					 driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					 test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					 String LoanAmt = driver.findElement(By.name("transactionDataBean.paymentBalAmt")).getAttribute("value");
					 test.log(LogStatus.PASS, "Default amount is :"+LoanAmt);
					 
				//===================================
					/* String Fee1 = LoanAmt;
					//string to double 
					double d = Double.parseDouble(Fee1);
					double dd=d-100;
					//double to string 	       
					String partialpaymentamt=String.valueOf(dd);  
					System.out.println(partialpaymentamt); */
				//===================================
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(LoanAmt);
					 test.log(LogStatus.PASS, "Payment amount is :"+LoanAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).clear();
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(LoanAmt);
					 test.log(LogStatus.PASS, "Tender amount entered :"+LoanAmt);
					 Thread.sleep(500);
					 driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					 test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					 Thread.sleep(500);
					 driver.findElement(By.name("password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin is entered");
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Full Default Payment");
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
					 //driver.findElement(By.name("checkno")).click();
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Full Deault Payment Completed Successfully ");
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
			test.log(LogStatus.FAIL, "Full Default Payment Failed");

		}

	}

	public static void partial_nsfpayment(String SSN,String AppURL) throws Exception
	{
		int i;
		for (i = 0; i < 3; i++) {
		
		try{

			
			int lastrow=TestData.getLastRow("NSFPayment");
			String sheetName="NSFPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String Chk_Nbr = TestData.getCellData(sheetName, "Chk_Nbr", row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "********************************************** ");
					test.log(LogStatus.INFO,Scenario+" payment has started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")	).click();			
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
					test.log(LogStatus.PASS, "Click on Submit");		

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(2000);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(1000);
					 
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					Thread.sleep(500);	
					String PaymentAmount=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is :"+PaymentAmount);
					
					//====================================================
					String PaymentAmt1 = PaymentAmount;
					//string to double 
					double d = Double.parseDouble(PaymentAmt1);
					double dd=d-50;
					//double to string 	       
					String UpdatedPaymentAmt=String.valueOf(dd);  
					System.out.println(UpdatedPaymentAmt); 
				//=====================================================
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+UpdatedPaymentAmt);										                                               
					test.log(LogStatus.PASS, " Updated Payment amount is"+UpdatedPaymentAmt);
					
					Thread.sleep(500);
					
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(UpdatedPaymentAmt);					                            
					test.log(LogStatus.PASS, " Enterd tender amount is "+UpdatedPaymentAmt);
				//=============================================================================	
					Thread.sleep(500);
					
					driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					Thread.sleep(500);
									
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);
					
					Thread.sleep(500);

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " Clicked on finish "+Scenario+" button");
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled "+almsg);
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{


						
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>Partial NSF Payment Is Successfull " );
						test.log(LogStatus.PASS, "********************************************** ");
					}
					else
					{
						test.log(LogStatus.PASS, Scenario+"  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}



					break;



				}
				}
			break;
				}
		catch (Exception e) {

			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO,  " Process intiated again due to Application sync issue");
			driver.get(prop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}	
	
	public static void full_nsfpayment(String SSN,String AppURL) throws Exception
	{
		int i;
		for (i = 0; i < 3; i++) {
		
		try{

			
			int lastrow=TestData.getLastRow("NSFPayment");
			String sheetName="NSFPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);
				String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
				

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String Chk_Nbr = TestData.getCellData(sheetName, "Chk_Nbr", row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "********************************************** ");
					test.log(LogStatus.INFO,Scenario+" payment has started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")	).click();			
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
					test.log(LogStatus.PASS, "Click on Submit");		

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(2000);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(1000);
					 
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :"+TenderType);
					Thread.sleep(500);	
					String PaymentAmount=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is :"+PaymentAmount);
					
					//====================================================
					/*String PaymentAmt1 = PaymentAmount;
					//string to double 
					double d = Double.parseDouble(PaymentAmt1);
					double dd=d-50;
					//double to string 	       
					String UpdatedPaymentAmt=String.valueOf(dd);  
					System.out.println(UpdatedPaymentAmt); */
				//=====================================================
					Thread.sleep(500);
					
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(PaymentAmount);					                            
					test.log(LogStatus.PASS, " Enterd tender amount is "+PaymentAmount);
				//=============================================================================	
					Thread.sleep(500);
					
					driver.findElement(By.name("transactionDataBean.checkNbrFirst")).sendKeys(Chk_Nbr);
					test.log(LogStatus.PASS, "Chk Nbr entered :"+Chk_Nbr);
					Thread.sleep(500);
									
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);
					
					Thread.sleep(500);

					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " Clicked on finish "+Scenario+" button");
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled "+almsg);
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{


						
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>Full NSF Payment Is Successfull " );
						test.log(LogStatus.PASS, "********************************************** ");
					}
					else
					{
						test.log(LogStatus.PASS, Scenario+"  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}



					break;



				}
				}
			break;
				}
		catch (Exception e) {

			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Exception");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO,  " Process intiated again due to Application sync issue");
			driver.get(prop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}

	
}


