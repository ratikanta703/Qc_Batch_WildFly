package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class RQCEPPPayment extends QCStore{
	public static void epppayment(String SSN,String AppURL) throws Exception
	{

			test.log(LogStatus.PASS, "************EPP payment Transaction started****************");
			

			int lastrow=TestData.getLastRow("EPPPayment");
			String sheetName="EPPPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					//String ChkgAcctNbr = TestData.getCellData(sheetName,"ChkgAcctNbr",row);
					String ChkAcctNumber = TestData.getCellData(sheetName,"ChkAcctNumber",row);
					String last4cheknum= ChkAcctNumber.substring(ChkAcctNumber.length() - 4);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(1000);
					test.log(LogStatus.INFO,"EPP started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")	).click();			
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Click on Submit");		

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(2000);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as EPP Payment");
					Thread.sleep(500);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					
					Thread.sleep(1000);



					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					                                               
					String tenderamunt=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[5]/td/table/tbody/tr[1]/td/table/tbody/tr[6]/td[2]/input[3]")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is"+tenderamunt);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Tender Type as"+TenderType);
					Thread.sleep(500);	
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(tenderamunt);
					test.log(LogStatus.PASS, " Enterd tender amount is"+tenderamunt);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='chkAcctNbr1']/td[2]/input")).sendKeys(last4cheknum);
					test.log(LogStatus.PASS, " Checking account number is "+last4cheknum);
					Thread.sleep(200);
					driver.findElement(By.name("password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);
					Thread.sleep(200);
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " click on finish button");
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled, alert message is :"+almsg);
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


						test.log(LogStatus.PASS, "<FONT color=green style=Arial> EPP Payment Completed Successfully ");
						test.log(LogStatus.INFO, "******************************************************** ");
					}
					
					else{
						test.log(LogStatus.PASS, " EPP payment  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
					break;

				}
				else{
					test.log(LogStatus.INFO, "RegSSN and SSN not matching ");
				}} 

	}
	
	public static void dcepppayment(String SSN,String AppURL) throws Exception
	{

			test.log(LogStatus.PASS, "************EPP payment Transaction started****************");
			

			int lastrow=TestData.getLastRow("EPPPayment");
			String sheetName="EPPPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					String Card = TestData.getCellData(sheetName,"Card",row);
					String CardType = TestData.getCellData(sheetName,"CardType",row);
					String CVV = TestData.getCellData(sheetName,"CVV",row);
					String ExpiryYear = TestData.getCellData(sheetName,"ExpiryYear",row);
					String ExpiryMonth = TestData.getCellData(sheetName,"ExpiryMonth",row);
					String DebitCardNo = TestData.getCellData(sheetName,"DebitCardNo",row);
					String CardHolderName = TestData.getCellData(sheetName,"CardHolderName",row);
					
					
					
					
					String ChkAcctNumber = TestData.getCellData(sheetName,"ChkAcctNumber",row);
					String last4cheknum= ChkAcctNumber.substring(ChkAcctNumber.length() - 4);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(1000);
					test.log(LogStatus.INFO,"EPP started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")	).click();			
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Click on Submit");		

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(2000);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Click on GO Button under loan section");
					Thread.sleep(1000);


					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as EPP Payment");
					Thread.sleep(500);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					
					Thread.sleep(1000);



					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					                                                 
					                                               
					String tenderamunt=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is"+tenderamunt);
					
					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Tender Type as"+TenderType);
					Thread.sleep(500);	
					driver.findElement(By.name("crditNbrFirst")).sendKeys(Card);
					test.log(LogStatus.PASS, " Select the Card as"+Card);
					Thread.sleep(500);	
					driver.findElement(By.name("cardType")).sendKeys(CardType);
					test.log(LogStatus.PASS, " Select the Card Type as"+CardType);
					/*Thread.sleep(500);	
					driver.findElement(By.name("cardType")).sendKeys(CardType);
					test.log(LogStatus.PASS, " Select the Card Type as"+CardType);*/
					Thread.sleep(500);	
					driver.findElement(By.name("ccnumber")).sendKeys(DebitCardNo);
					test.log(LogStatus.PASS, " Card Number as"+DebitCardNo);
					Thread.sleep(200);	
					driver.findElement(By.name("expmonth")).sendKeys(ExpiryMonth);
					test.log(LogStatus.PASS, " Expiried Month as"+ExpiryMonth);
					Thread.sleep(200);	
					driver.findElement(By.name("expyear")).sendKeys(ExpiryYear);
					test.log(LogStatus.PASS, " Expiried Date as"+ExpiryYear);
					Thread.sleep(200);
					driver.findElement(By.name("ccname")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, " CardHolder Name is :"+CardHolderName);
					Thread.sleep(200);
					driver.findElement(By.name("cvvnumber")).sendKeys(CVV);
					test.log(LogStatus.PASS, " CVV is :"+CVV);
					
					
					
					
					
					
					
					
					driver.findElement(By.name("transactionDataBean.tenderAmtFirst")).sendKeys(tenderamunt);
					test.log(LogStatus.PASS, " Enterd tender amount is"+tenderamunt);
					Thread.sleep(500);
					//driver.findElement(By.xpath("//*[@id='chkAcctNbr1']/td[2]/input")).sendKeys(last4cheknum);
					//test.log(LogStatus.PASS, " Checking account number is "+last4cheknum);
					Thread.sleep(200);
					driver.findElement(By.name("password")).sendKeys(PIN);
					test.log(LogStatus.PASS, " Entered password "+PIN);
					Thread.sleep(200);
					driver.findElement(By.name("Submit22")).click();
					test.log(LogStatus.PASS, " click on finish button");
					
					Thread.sleep(5000);
					try {
						Alert alert = driver.switchTo().alert();
						String almsg= alert.getText();

						alert.accept();
						test.log(LogStatus.PASS, "alert handled, alert message is :"+almsg);
					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(6000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{


						test.log(LogStatus.PASS, "<FONT color=green style=Arial> EPP Payment Completed Successfully ");
						test.log(LogStatus.INFO, "******************************************************** ");
					}
					
					else{
						test.log(LogStatus.PASS, " EPP payment  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
					break;

				}
				else{
					test.log(LogStatus.INFO, "RegSSN and SSN not matching ");
				}} 

	}
	
}			





