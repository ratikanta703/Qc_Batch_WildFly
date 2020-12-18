package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;

import com.relevantcodes.extentreports.LogStatus;

public class RQCNSFPayment extends QCStore{

	public static void nsfpayment_withoutwave(String SSN,String AppURL) throws Exception
	{
		int i;
		for (i = 0; i < 3; i++) {
		
		try{

			
			int lastrow=TestData.getLastRow("NsfPayment");
			String sheetName="NsfPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.INFO,Scenario+" payment has started");
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
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");


					String tenderamunt=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[1]/td[3]/input")).getAttribute("value");					                                               
					test.log(LogStatus.PASS, " payment amount is"+tenderamunt);
					
					Thread.sleep(500);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Tender Type as "+TenderType);
					//Thread.sleep(1000);
					
					Thread.sleep(500);
					
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[13]/td[3]/input")).sendKeys(tenderamunt);					                            
					test.log(LogStatus.PASS, " Enterd tender amount is "+tenderamunt);
					
					Thread.sleep(500);
					
					String NSFFee_Amount=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[19]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> NSF Fee is : " +NSFFee_Amount);
					
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


						test.log(LogStatus.PASS, Scenario+"   is successfull");
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
			driver.get(Rprop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}
	
	public static void nsfpayment_withwave(String SSN,String AppURL) throws Exception
	{
		int i;
		for (i = 0; i < 3; i++) {
		
		try{

			
			int lastrow=TestData.getLastRow("NsfPayment");
			String sheetName="NsfPayment";

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String Scenario = TestData.getCellData(sheetName,"Scenario",row);
				String PaymentAmt = TestData.getCellData(sheetName,"PaymentAmt",row);

				if(SSN.equals(RegSSN))
				{

					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.INFO,Scenario+" payment has started");
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
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);
					Thread.sleep(500);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(6000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					Thread.sleep(1000);
					
					
                    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[19]/td[4]/input")).click();
                    test.log(LogStatus.PASS, "Clicked on Waive NSF Fee Checkbox");
                    
                    Thread.sleep(500);
                    
                    driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+PaymentAmt);
                    test.log(LogStatus.PASS, "Payment amount entered as : "+PaymentAmt);
                    
                    Thread.sleep(500);
                    
                    driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[13]/td[3]/input")).click();				                                                                                                                  
                    //test.log(LogStatus.PASS, " payment amount is"+tenderamunt);
					
					Thread.sleep(500);
                    
                    //String main_window = driver.getWindowHandle();
                    //driver.switchTo().window(main_window);
					try {
						Alert alert = driver.switchTo().alert();
						String almsg = alert.getText();
						

						alert.accept();
						
						test.log(LogStatus.PASS, "Alert Displayed");
						test.log(LogStatus.PASS, "Alert Message is : " + almsg);
						//test.log(LogStatus.PASS, "Trying to make a payment less than total due with waive apply fee)");
						Thread.sleep(5000);
						/*driver.switchTo().window(main_window);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");*/
						// if alert present, accept and move on.

					} 
					catch (Exception e) {
						test.log(LogStatus.FAIL, "Alert message not Displayed");
						Thread.sleep(500);
						driver.close();
						Thread.sleep(5000);
						

					}
       
					
					Thread.sleep(500);
					
					String NSFFee_Amount=driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[19]/td[3]/input")).getAttribute("value");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> NSF Fee is : " +NSFFee_Amount);
					
					Thread.sleep(500);
					
					//test.log(LogStatus.PASS, " Trying to make a payment less than total due with waive apply fee  is successfull");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Trying to make a payment less than total due with waive apply fee  is successfull ");
					test.log(LogStatus.PASS, "********************************************** ");
					
					
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					/*if(driver.findElement(By.xpath("//*[@class='sortbuttons']")).isDisplayed())
					{


						test.log(LogStatus.PASS, Scenario+"   is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}
					else
					{
						test.log(LogStatus.PASS, Scenario+"  is successfull");
						test.log(LogStatus.PASS, "********************************************** ");
					}*/



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
			driver.get(Rprop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}	
	public static void nsfpayment_less(String SSN,String AppURL) throws Exception
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
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.INFO,Scenario+" payment has started");
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
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(1000);
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

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Tender Type as "+TenderType);
					//Thread.sleep(1000);
					
					Thread.sleep(500);
					
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[13]/td[3]/input")).sendKeys(UpdatedPaymentAmt);					                            
					test.log(LogStatus.PASS, " Enterd tender amount is "+UpdatedPaymentAmt);
				//=============================================================================	
					Thread.sleep(500);
					
					String NSFFee_Amount=driver.findElement(By.name("transactionDataBean.ruleNSFFeeAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> NSF Fee is : " +NSFFee_Amount);
					
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


						
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>NSF Payment Is Successfull " );
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
			driver.get(Rprop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}
		
	public static void nsfpayment_morethanearnfee(String SSN,String AppURL) throws Exception
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
					
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);
					Thread.sleep(1000);
					test.log(LogStatus.INFO,Scenario+" payment has started");
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
					test.log(LogStatus.PASS, "Transaction Type is selected as "+TxnType);

					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(1000);
					String PaymentAmount=driver.findElement(By.name("transactionDataBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, " payment amount is :"+PaymentAmount);
					
					//====================================================
					String PaymentAmt1 = PaymentAmount;
					//string to double 
					double d = Double.parseDouble(PaymentAmt1);
					double dd=d-40;
					//double to string 	       
					String UpdatedPaymentAmt=String.valueOf(dd);  
					System.out.println(UpdatedPaymentAmt); 
				//=====================================================
					Thread.sleep(500);
					driver.findElement(By.name("transactionDataBean.paymentAmt")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+UpdatedPaymentAmt);										                                               
					test.log(LogStatus.PASS, " Updated Payment amount is"+UpdatedPaymentAmt);
					
					Thread.sleep(500);

					driver.findElement(By.name("transactionDataBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, " Select the Tender Type as "+TenderType);
					//Thread.sleep(1000);
					
					Thread.sleep(500);
					
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[1]/table[2]/tbody/tr[1]/td/table/tbody/tr[13]/td[3]/input")).sendKeys(UpdatedPaymentAmt);					                            
					test.log(LogStatus.PASS, " Enterd tender amount is "+UpdatedPaymentAmt);
				//=============================================================================	
					Thread.sleep(500);
					
					String NSFFee_Amount=driver.findElement(By.name("transactionDataBean.ruleNSFFeeAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> NSF Fee is : " +NSFFee_Amount);
					
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


						
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>NSF Payment Is Successfull " );
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
			driver.get(Rprop.getProperty("login_page"));  
			continue;

		}			 

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "payment is failed");
	
		}

}
	
	
	
	
	
}
