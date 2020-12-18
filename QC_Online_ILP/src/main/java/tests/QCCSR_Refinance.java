package tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSR_Refinance extends QCStore{
	public static void StepSame_WaiveFee(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Default Verify started");
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
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(8000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(5000);
					 driver.findElement(By.name("waiveFeeChkBox")).click();
					 test.log(LogStatus.PASS, "Click on Waive Fee Checkbox ");
					 Thread.sleep(2000);
					 
					 
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(stepupmsg.equalsIgnoreCase("Step Same"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					
					if(stepupmsg.contains("Step Same")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
	public static void StepSame(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Default Verify started");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(8000);
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(stepupmsg.equalsIgnoreCase("Step Same"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(stepupmsg.contains("Step Same")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
	
	public static void tlpStepSame(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "******** Refinance started *********");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(2000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("button1")));
					
					 driver.findElement(By.name("button1")).click();
					 test.log(LogStatus.PASS, "Click on Borrower Overview Update Button ");
					 Thread.sleep(10000);
					 driver.findElement(By.name("button2")).click();
					 test.log(LogStatus.PASS, "Click on Co-Owner Update Button ");
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("process")));
					 driver.findElement(By.name("process")).click();
					 test.log(LogStatus.PASS, "Click on Process Button ");
					 Thread.sleep(500);
					 //Thread.sleep(10000);
					 try { 
						                              
						 driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();
						 test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
							
						}
						catch(Exception e){
							//do what you normally would if you didn't have the alert.
						}
					 Thread.sleep(50000);
					 Thread.sleep(10000);
					 driver.findElement(By.name("qualify")).click();
					 test.log(LogStatus.PASS, "Click on Qualify Button ");
					 Thread.sleep(40000);					 					
				    String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(ProductType.equalsIgnoreCase("NV Title"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(ProductType.contains("NV Title")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
						try {
							driver.findElement(By.name("advanceRequestBean.disbursementType")).sendKeys(TenderType);
                            
					        test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					       Thread.sleep(5000);
					       String ele=driver.findElement(By.className("textBox50NoneditableMonetary2")).getAttribute("value");
					       test.log(LogStatus.PASS, "Total Disb. Amt is "+ele);
					       Thread.sleep(1000);
					       driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+ele);				       
					       test.log(LogStatus.PASS, "Enter the Disb. Amt "+ele);
					       Thread.sleep(500);				       							
						   driver.findElement(By.name("finishLoan")).click();
						   test.log(LogStatus.PASS, "click on Finish Loan button ");

						}
						catch(Exception e){
							driver.findElement(By.name("finishLoan")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
						}	
						   
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							
							test.log(LogStatus.PASS, "click on Yes button ");
							
							Thread.sleep(1000);
								if(driver.findElement(By.name("ok")).isDisplayed()){
								
								driver.findElement(By.name("ok")).click();
								test.log(LogStatus.PASS, "click on OK button ");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}
		catch(Exception e){
			
			/*String screenshotPath = getScreenhot(driver, "QC_LOC_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_Loan_Default_Repo_Refinance Transaction Failed ");*/
			test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}
			
		
	}
	
	public static void ilpStepSame(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "******** Refinance started *********");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(2000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
					 driver.findElement(By.name("qualify")).click();
					 test.log(LogStatus.PASS, "Click on Qualify Button ");
					 Thread.sleep(30000);
					 
				    String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					
					if(ProductType.equalsIgnoreCase("MO Installment Loan"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(ProductType.contains("MO Installment Loan")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							
							driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
						try {
							driver.findElement(By.name("advanceRequestBean.disbursementType")).sendKeys(TenderType);
                            
					        test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					       Thread.sleep(5000);
					       String ele=driver.findElement(By.className("textBox50NoneditableMonetary2")).getAttribute("value");
					       test.log(LogStatus.PASS, "Total Disb. Amt is "+ele);
					       Thread.sleep(1000);
					       driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+ele);				       
					       test.log(LogStatus.PASS, "Enter the Disb. Amt "+ele);
					       Thread.sleep(500);				       							
						   driver.findElement(By.name("finishLoan")).click();
						   test.log(LogStatus.PASS, "click on Finish Loan button ");

						}
						catch(Exception e){
							driver.findElement(By.name("finishLoan")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
						}	
						Thread.sleep(4000);
						    driver.findElement(By.name("OKBut")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.name("ok")).isDisplayed()){
								
								driver.findElement(By.name("ok")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}
		catch(Exception e){
			
			/*String screenshotPath = getScreenhot(driver, "QC_LOC_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_Loan_Default_Repo_Refinance Transaction Failed ");*/
			test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}
			
		
	}
	
	public static void SecuredLocStepSame(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "******** Refinance started *********");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(2000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("button1")));
					
					 driver.findElement(By.name("button1")).click();
					 test.log(LogStatus.PASS, "Click on Borrower Overview Update Button ");
					 Thread.sleep(10000);
					 driver.findElement(By.name("button2")).click();
					 test.log(LogStatus.PASS, "Click on Co-Owner Update Button ");
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("process")));
					 driver.findElement(By.name("process")).click();
					 test.log(LogStatus.PASS, "Click on Process Button ");
					 Thread.sleep(10000);
					
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(ProductType.equalsIgnoreCase("KS Title"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(ProductType.contains("KS Title")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
						test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
						try {
							driver.findElement(By.name("advanceRequestBean.disbursementType")).sendKeys(TenderType);
                            
					        test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					       Thread.sleep(5000);
					       String ele=driver.findElement(By.className("textBox50NoneditableMonetary2")).getAttribute("value");
					       test.log(LogStatus.PASS, "Total Disb. Amt is "+ele);
					       Thread.sleep(1000);
					       driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+ele);				       
					       test.log(LogStatus.PASS, "Enter the Disb. Amt "+ele);
					       Thread.sleep(500);				       							
						   driver.findElement(By.name("finishadvance")).click();
						   test.log(LogStatus.PASS, "click on Finish Loan button ");

						}
						catch(Exception e){
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
						}	
						    /*driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");*/
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}
		catch(Exception e){
			
			/*String screenshotPath = getScreenhot(driver, "QC_LOC_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_Loan_Default_Repo_Refinance Transaction Failed ");*/
			test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}
			
		
	}
	
	public static void lessthansecuredlocamount(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
		        
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Default Verify started");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(2000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("button1")));
					
					 driver.findElement(By.name("button1")).click();
					 test.log(LogStatus.PASS, "Click on Borrower Overview Update Button ");
					 Thread.sleep(10000);
					 driver.findElement(By.name("button2")).click();
					 test.log(LogStatus.PASS, "Click on Co-Owner Update Button ");
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("process")));
					 driver.findElement(By.name("process")).click();
					 test.log(LogStatus.PASS, "Click on Process Button ");
					 Thread.sleep(10000);
					 
					 
					 
					 
					//====================================
					 
				   String Prev_LOCAmount=driver.findElement(By.name("advanceRequestBean.originalLimitAmt")).getAttribute("value");
				   test.log(LogStatus.PASS, "Previous LOC Amount is :"+Prev_LOCAmount);
				 //================== Enable when didn't hit RE =========================
				   
				   //string to double 
				   /*double d = Double.parseDouble(Prev_LOCAmount);
				   double dd=d-50;
				       //double to string 	       
				   String Refinanceamount=String.valueOf(dd);  
				   System.out.println(Refinanceamount);
				   
				   Thread.sleep(1000);
				  
				   driver.findElement(By.name("advanceRequestBean.loanAmount")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+Refinanceamount);
				   Thread.sleep(500);
				   test.log(LogStatus.PASS, "Refinance Loan amount Less than LOC amount entered as "+Refinanceamount); 
				   Thread.sleep(800);
				   driver.findElement(By.name("advanceRequestBean.paymentAmt")).click();
				   wait.until(ExpectedConditions.elementToBeClickable(By.name("finishadvance")));*/
				     
					   //==============================================================================  
				   String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					
					
					
					
					
					
					if(ProductType.equalsIgnoreCase("KS Title"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(ProductType.equalsIgnoreCase("KS Title")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							                           
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							try {
								driver.findElement(By.name("advanceRequestBean.disbursementType")).sendKeys(TenderType);
                                
						        test.log(LogStatus.PASS, "Select Disb type as "+TenderType);
						       Thread.sleep(3000);
						       String ele=driver.findElement(By.className("textBox50NoneditableMonetary2")).getAttribute("value");
						       test.log(LogStatus.PASS, "Total Disb. Amt is "+ele);
						       Thread.sleep(1000);
						      driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).clear();
						      Thread.sleep(1000);
						      driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(Keys.chord(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE)+ele);
						       //driver.findElement(By.name("advanceRequestBean.disbAmtFirst")).sendKeys(ele);
						       test.log(LogStatus.PASS, "Enter the Disb. Amt "+ele);
						       Thread.sleep(500);	
						       driver.findElement(By.name("finishadvance")).click();
								test.log(LogStatus.PASS, "click on Finish Loan button ");

							}
							catch(Exception e){
								driver.findElement(By.name("finishadvance")).click();
								test.log(LogStatus.PASS, "click on Finish Loan button ");
							}		
							
							
							
							//driver.findElement(By.name("finishadvance")).click();
							//test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
			/*String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_Loan_Payment_Default_Repo_Refinance Transaction Failed ");*/
			test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}
			
		
	}
	
	public static void refinanceshouldnttallow(String SSN,String AppURL) throws Exception
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
		        
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Default Verify started");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(2000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("button1")));
					
					 driver.findElement(By.name("button1")).click();
					 test.log(LogStatus.PASS, "Click on Borrower Overview Update Button ");
					 Thread.sleep(5000);
					 driver.findElement(By.name("button2")).click();
					 test.log(LogStatus.PASS, "Click on Co-Owner Update Button ");
					 Thread.sleep(5000);
					 wait.until(ExpectedConditions.elementToBeClickable(By.name("process")));
					 driver.findElement(By.name("process")).click();
					 test.log(LogStatus.PASS, "Click on Process Button ");
					 Thread.sleep(10000);
					 //Here
					 String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td")).getText();

					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> confirm text is "+confirm_text1);
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> It is not allow for Refinance ");
					 test.log(LogStatus.INFO, "********************Scenario is Successfull****************************** ");
			
				
						break;
				}
				
				 
			}
			
		}catch(Exception e){
			String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_Loan_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb Transaction Failed ");
			test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}

	
	
	public static void StepDown(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Default Verify started");
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
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");			
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(5000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[10]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(8000);
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(stepupmsg.contains("Stepped Down"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					if(stepupmsg.contains("Step Same")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
	public static void StepUp(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Refinance started");
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
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(8000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(5000);
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
			
					
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(stepupmsg.contains("Stepped Up"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					
					
					
					if(stepupmsg.contains("Stepped Up")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							Thread.sleep(1000);
                           /*driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys("Cash");
							
							test.log(LogStatus.PASS, "Select Disb type as : Cash");*/
							
							try { 
								//driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys("Cash");
								driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys("Cash");
								test.log(LogStatus.PASS, "Select Disb type as : Cash");
								//if alert present, accept and move on.														

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepUp from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepSame from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
	public static void StepUp_WaiveFee(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Refinance started");
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
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(8000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(3000);
					 driver.findElement(By.name("waiveFeeChkBox")).click();
					 test.log(LogStatus.PASS, "Click on Waive Fee Checkbox ");
					 Thread.sleep(2000);
					 
					 
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					//test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					if(stepupmsg.contains("Stepped Up"))
					{									
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);																								 						
						}
					else{
						test.log(LogStatus.FAIL, "<FONT color=red style=Arial>getting refinance message  :" +stepupmsg);
						Assert.assertTrue(false);
						
						break;
					}
					
					if(stepupmsg.contains("Stepped Up")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							try { 
								//driver.findElement(By.name("advanceRequestBean.disbursementTypeSecond")).sendKeys("Cash");
								driver.findElement(By.xpath("//*[@id='advanceRequestBean.disbursementType']")).sendKeys("Cash");
								test.log(LogStatus.PASS, "Select Disb type as : Cash");
								//if alert present, accept and move on.														

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepUp from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance StepUp from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
	public static void Stepdown(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((Jprop.getProperty("Refinance")));
			String sheetName=Jprop.getProperty("Refinance");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Refinance from CSR has initiated");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				
				test.log(LogStatus.PASS, ""+Str_date);
				
				driver.switchTo().defaultContent();	
				
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
				
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
							
									    					   					     
				driver.findElement(locator(Jprop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 driver.findElement(locator(Jprop.getProperty("transactionList"))).sendKeys("Refinance");
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 Thread.sleep(500);
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(15000);
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					
					float PbalInt=Float.valueOf(paymentamount);
					PbalInt=PbalInt+10;
					String pbalstr=Float.toString(PbalInt);
					test.log(LogStatus.PASS, "payble loan amount is : "+pbalstr);
					Thread.sleep(500);
					for(int i=1; i<=11; i++){
					driver.findElement(By.name("advanceRequestBean.paymentAmt")).sendKeys(Keys.BACK_SPACE);
					}
					driver.findElement(By.name("advanceRequestBean.paymentAmt")).sendKeys(pbalstr);
					test.log(LogStatus.PASS, "Enter loan amount is : "+pbalstr);
					driver.findElement(By.name("advanceRequestBean.paymentAmt")).sendKeys(Keys.TAB);
					Thread.sleep(30000);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					Thread.sleep(500);
					driver.findElement(By.name("advanceRequestBean.tenderAmtFirst")).clear();
					String amount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					driver.findElement(By.name("advanceRequestBean.tenderAmtFirst")).sendKeys(amount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+amount);
					Thread.sleep(500);
					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					test.log(LogStatus.PASS, "getting refinance message  :"+stepupmsg);
					
					if(stepupmsg.contains("Stepped Down")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
								 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
							test.log(LogStatus.PASS,"<FONT color=green style=Arial>"+ ESign_CollateralType+ "Refinance StepDown from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");
							 Thread.sleep(3000);
							}else{
								
								test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepDown from CSR is successfull");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}	
	
	public static void normalrefinance(String SSN,String AppURL)
	{
		try{
			/*int lastrow=TestData.getLastRow((prop.getProperty("ReFinance")));
			String sheetName=prop.getProperty("ReFinance");*/
			int lastrow = TestData.getLastRow("ReFinance");
			String sheetName = "ReFinance";
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
		      	
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
		       Thread.sleep(3000);
				test.log(LogStatus.INFO, "Refinance started");
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
							
									    					   					     
				
				driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
				test.log(LogStatus.PASS, "Clicked on GO Button under search results");
				Thread.sleep(5000);		
			
				
				    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    Thread.sleep(8000);
				   
				    driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					   //driver.findElement(locator(prop.getProperty("transactionList"))).sendKeys("Refinance");
					 //driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select")).sendKeys("Refinance");
					 driver.findElement(By.name("transactionList")).sendKeys("Refinance");
					 test.log(LogStatus.PASS, "Transaction type is selected as Refinance");
					 driver.findElement(By.xpath("//input[@name='button' and @value='Go']")).click();
					 test.log(LogStatus.PASS, "Click on GO Button after transaction type selection ");
					 Thread.sleep(3000);
					 
				    String paymentamount=driver.findElement(By.name("advanceRequestBean.paymentAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Getting payment amount "+paymentamount);
					driver.findElement(By.name("advanceRequestBean.tenderTypeFirst")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Select tender type as "+TenderType);
					WebElement e1=driver.findElement(By.name("advanceRequestBean.tenderAmtFirst"));
					e1.clear();
					e1.sendKeys(paymentamount);
					test.log(LogStatus.PASS, "Entered tender amount as  :"+paymentamount);

					String stepupmsg=driver.findElement(By.xpath("//*[@id='_StepUpDown']")).getText();
					//test.log(LogStatus.PASS, "getting stepup message  :"+stepupmsg);
					test.log(LogStatus.INFO, "<FONT color=green style=Arial>getting refinance message  :" +stepupmsg);
					
					/*if(stepupmsg.contains("Step Same")){
						
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Collateral is " + ESign_CollateralType);*/
						 Thread.sleep(2000);
		
						if(ESign_CollateralType.equalsIgnoreCase("SIGNATURE"))
						{			
							
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
															 
							
							}
						else if(ESign_CollateralType.equalsIgnoreCase("DEBIT CARD"))
						{
							driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
							test.log(LogStatus.PASS, "Select Payment collateral type as "+ESign_CollateralType);
							
							driver.findElement(By.xpath("//*[@id='cardsListColl']/select")).sendKeys("NEW CARD");
							test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

							driver.findElement(By.xpath("//*[@id='cardTypeColl']/select")).sendKeys(cardType);
							test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
							
							driver.findElement(By.xpath("//*[@id='ccnumberColl']")).sendKeys(cardNumber);
							test.log(LogStatus.PASS, "Card number is :" + cardNumber);							
							
							driver.findElement(By.xpath("//*[@id='expmonthColl']")).sendKeys(cardEx_month);
							test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

							Select sel = new Select(driver.findElement(By.xpath("//*[@id='expyearColl']")));
							
							sel.selectByVisibleText(cardEx_Year);

							
							test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_Year);
							
							driver.findElement(By.xpath("//*[@id='cvvnumberColl']")).sendKeys(cvv);
							test.log(LogStatus.PASS, "Enterd CVV " + cvv);
							driver.findElement(By.xpath("//*[@id='ccnameColl']")).sendKeys(CardHolderName);
							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
														
							driver.findElement(By.xpath("//input[@value='Add Card' and @type='button']")).click();
							test.log(LogStatus.PASS, "Clicked on add card button ");	
							Thread.sleep(30000);						
							
						}
						driver.findElement(By.name("advanceRequestBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
						
						if(ESign_CourtesyCallConsent.equalsIgnoreCase("Yes"))
						{
							
							if(ESign_Preference.equalsIgnoreCase("Call"))
							{
								driver.findElement(By.id("preferenceCall")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
							}
			
							else if(ESign_Preference.equalsIgnoreCase("SMS"))
							{
								driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
								test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

								try {
									Alert alert = driver.switchTo().alert();
									alert.dismiss();
									//if alert present, accept and move on.

								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
							}

						}
						driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
							test.log(LogStatus.PASS, "ESign_Checks is selected as "+PIN);
							
							driver.findElement(By.name("finishadvance")).click();
							test.log(LogStatus.PASS, "click on Finish Loan button ");
							
							String confirm_text1=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[1]")).getText();
							
							String confirm_text2=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[2]")).getText();
							String confirm_text3=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]")).getText();
							//String confirm_text4=driver.findElement(By.xpath("//*[@id='confirmMsg']/b[3]/text()[2]")).getText();
						
							test.log(LogStatus.PASS, "confirm text is  "+confirm_text1+" Will receive an LOC of "+confirm_text2+", out of Credit Limit "+confirm_text3);
							
							
							driver.findElement(By.xpath("//input[@value='Yes' and @type='button']")).click();
							test.log(LogStatus.PASS, "click on Yes button ");
							
							if(driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).isDisplayed()){
								
								driver.findElement(By.xpath("//input[@value='OK' and @type='button']")).click();
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance  from CSR is successfull ");	
							//test.log(LogStatus.PASS, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
							 test.log(LogStatus.PASS, "**********************************************");	
							}else{
								
								//test.log(LogStatus.INFO, ESign_CollateralType+ "Refinance StepSame from CSR is successfull");
								test.log(LogStatus.INFO, "<FONT color=green style=Arial>Refinance  from CSR is successfull ");
								 test.log(LogStatus.PASS, "**********************************************");
							}					
					//} 
					
					
						break;
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Refinance from CSR is failed");

		}
			
		
	}
	
}
