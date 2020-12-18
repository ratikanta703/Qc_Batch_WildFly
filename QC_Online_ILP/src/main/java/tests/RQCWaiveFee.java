package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class RQCWaiveFee extends QCStore{
	
	
	public static void WaiveFee(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((Rprop.getProperty("ReFinance")));
			String sheetName=Rprop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("WaiveFee");
			String sheetName = "WaiveFee";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				//String CallConsent = TestData.getCellData(sheetName,"CallConsent",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);		      	       		      		      
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		       
		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
		       
		       String cardType=TestData.getCellData(sheetName,"Card Type ",row);
		       String cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
		       String cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
		       String cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
		       String cvv=TestData.getCellData(sheetName,"CVV",row);
		       String CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);
		       String WaiveReason=TestData.getCellData(sheetName,"WaiveReason",row);
		    
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Full Waive Fee started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");	
				Thread.sleep(1000);
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");	
				Thread.sleep(8000);
							
									    					   					     
				
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(Rprop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Waive Fee");
					 driver.findElement(By.name("transactionList")).sendKeys("Waive Fee");
					 test.log(LogStatus.PASS, "Transaction type is selected as WaiveFee");
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(3000);
					 
					 String LateFee=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[3]/input")).getAttribute("value");
					 test.log(LogStatus.PASS, "Late Fee amount is : " +LateFee);
					 
					 Thread.sleep(1000);
					 
					 driver.findElement(By.name("waiveLF")).sendKeys(Keys.chord(Keys.BACK_SPACE)+LateFee);
					 test.log(LogStatus.PASS, "Late Fee Entered as : " +LateFee);
					 
					 Thread.sleep(500);
					 
					 encryption_transaction_nbr =  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td[4]/input")).getAttribute("value");
					 test.log(LogStatus.PASS, "Transaction Number is : " +encryption_transaction_nbr);
					 
					 Thread.sleep(500);
					 
					 RAdminLoginForEncryption.getEncryption(driver,SSN, AppURL);
					 
					 Thread.sleep(5000);
					 
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 Thread.sleep(1000);
					 driver.findElement(By.name("encryptionKey")).sendKeys(Eankey);
					 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
					 Thread.sleep(1000);
					 driver.findElement(By.name("commentDt")).sendKeys(WaiveReason);
					 test.log(LogStatus.PASS, "Waive Reason Entered As :" +WaiveReason);					
					 Thread.sleep(500);
					 driver.findElement(By.name("password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin Entered as :" +PIN);
					 Thread.sleep(500);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Waive");
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkno")).click();
					 test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully");
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Waive Completed Successfully");
					 test.log(LogStatus.PASS, "**********************************************");
					 driver.close();
					 
										
					
						break;
				}
				
				 
			}	
			
			
		}
		catch(Exception e){
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance Transaction Failed ");
			test.log(LogStatus.FAIL, "Waive Fee from CSR is failed");

		}
}
	
			
		
	//}
	
	public static void WaiveFee_Partial(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((Rprop.getProperty("ReFinance")));
			String sheetName=Rprop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("WaiveFee");
			String sheetName = "WaiveFee";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				//String CallConsent = TestData.getCellData(sheetName,"CallConsent",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName,"ESign_CourtesyCallConsent",row);
					String ESign_Preference = TestData.getCellData(sheetName,"Esign_Preference",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);		      	       		      		      
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);		       
		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
		       
		       String cardType=TestData.getCellData(sheetName,"Card Type ",row);
		       String cardNumber=TestData.getCellData(sheetName,"Debit Card No",row);
		       String cardEx_month=TestData.getCellData(sheetName,"Expiry Month",row);
		       String cardEx_Year=TestData.getCellData(sheetName,"Expiry Year",row);
		       String cvv=TestData.getCellData(sheetName,"CVV",row);
		       String CardHolderName=TestData.getCellData(sheetName,"CardHolderName",row);
		       String WaiveReason=TestData.getCellData(sheetName,"WaiveReason",row);
		       String Waive_Partial_Amount=TestData.getCellData(sheetName,"Waive_Partial_Amount",row);
		       
		    
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Partial Waive Fee started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");	
				Thread.sleep(1000);
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
				Thread.sleep(5000);			
									    					   					     
				
				driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(Rprop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Waive Fee");
					 driver.findElement(By.name("transactionList")).sendKeys("Waive Fee");
					 test.log(LogStatus.PASS, "Transaction type is selected as WaiveFee");
						Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(8000);
					 
					 String LateFee=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[5]/td[3]/input")).getAttribute("value");
					 test.log(LogStatus.PASS, "Late Fee amount is : " +LateFee);
					 
					 Thread.sleep(1000);
					 
					 driver.findElement(By.name("waiveLF")).sendKeys(Keys.chord(Keys.BACK_SPACE)+Waive_Partial_Amount);
					 test.log(LogStatus.PASS, "Late Fee Entered as : " +Waive_Partial_Amount);
					 
					 Thread.sleep(500);
					 
					 encryption_transaction_nbr =  driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[8]/td[4]/input")).getAttribute("value");
					 test.log(LogStatus.PASS, "Transaction Number is : " +encryption_transaction_nbr);
					 
					 Thread.sleep(500);
					 
					 RAdminLoginForEncryption.getEncryption(driver,SSN, AppURL);
					 
					 Thread.sleep(5000);
					 
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 Thread.sleep(1000);
					 driver.findElement(By.name("encryptionKey")).sendKeys(Eankey);
					 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
					 Thread.sleep(1000);
					 driver.findElement(By.name("commentDt")).sendKeys(WaiveReason);
					 test.log(LogStatus.PASS, "Waive Reason Entered As :" +WaiveReason);					
					 Thread.sleep(500);
					 driver.findElement(By.name("password")).sendKeys(PIN);
					 test.log(LogStatus.PASS, "Pin Entered as :" +PIN);
					 Thread.sleep(500);
					 driver.findElement(By.name("Submit22")).click();
					 test.log(LogStatus.PASS, "Clicked on Finish Waive");
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkno")).click();
					 test.log(LogStatus.PASS, " Transaction Completed Successfully");
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WaiveFee Partial Completed Successfully");
					 test.log(LogStatus.PASS, "**********************************************");
					 driver.close();
					 
										
					
						break;
				}
				
				 
			}
			
		}
		catch(Exception e){
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance Transaction Failed ");
			test.log(LogStatus.FAIL, "Waive Fee from CSR is failed");

		}
			
		
	}

	
}
