package tests;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RQCCSRHistory1 extends QCStore{
	public static String ACH_type;
	public static String ACH_transaction;
	public static String ACH_status;
	public static String ACH_amount;
	public static String ACH_ABA_code;
	public static String ACH_check_acc_no;
	public static String ach_history_ach_type;
	public static String ach_history_ach_transaction;
	public static String ach_history_ach_status;
	public static String ach_history_ach_amt;
	public static String ach_history_ach_check_acc_no;
	public static String ach_history_ach_ABA_code;

	public static void history(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				 
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="Borrower_Registration";
			String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"UserName",row);
					String Password = TestData.getCellData(sheetName,"Password",row);
			       // System.out.println(Password); 	
			        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			       String LastName = TestData.getCellData(sheetName,"LastName",row);
			       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			       String customer_name=FirstName+" "+LastName;
			       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
			       String City = TestData.getCellData(sheetName,"City",row);
			       String State = TestData.getCellData(sheetName,"State",row);	      
			       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
			       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);
			       Bank_ChkgAcctNbr= Bank_ChkgAcctNbr.substring(Bank_ChkgAcctNbr.length() - 4);
			       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
			       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
			       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
			       String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
			       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
			       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
			       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
			       String ESign_CollateralType = TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       String courtesy_consent=TestData.getCellData(sheetName_new_loan,"ESign_CourtesyCallConsent",row);
			     //  String courtesy_consent_status=TestData.getCellData(sheetName_new_loan,"ESign_Preference",row);
			       String collateral_type=TestData.getCellData(sheetName_new_loan,"ESign_CollateralType",row);
			       
			       String primary_source_of_income = TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",4);
			       System.out.println(sheetName_calc);
			       System.out.println(columnname+"_TxnHistory_FieldValue");

			       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
			       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
			       String NetIncomeAmt = TestData.getCellData(sheetName,"Income_NetIncomeAmt",row);
			       NetIncomeAmt=NetIncomeAmt+".00";
			       String GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			       String pay_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",7);
			       String loan_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",8);
			       String check_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",9);
			       String product_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",11);
			       String loan_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",12);
			       String finance_charge=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",13);
			       String apr=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",14);
			   //    String collateral_type=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",16);
			       String loan_frequency=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",17);
			       String credot_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",18);
			       String available_credit=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",19);
			       String courtesy_consent_status=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",21);
			       String principal_balance=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",22);
			       String fee_due=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",23);
			       String pay_off_amount=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",24);

			       String principal_paid_to_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",25);

			       String fee_paid_date=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",26);

			       //String total_paid_amountc=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",27);
			       String campaign_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",28);
			       String promotion_code=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",29);
			       String product_name=TestData.getCellData(sheetName_calc,columnname+"_TxnHistory_FieldValue",30);
			       String total_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",2);
			       String advance_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",3);
			       String advance_fees=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",4);
			       String NSF_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",5);
			       String WO_amount=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",6);
			       String interest_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",7);
			       String origination_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",8);
			       String credit_or_verification_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",9);
			       String EPP_fee=TestData.getCellData(sheetName_calc,columnname+"_Detail_FieldValue",10);
	 //ACH collateral details from sheet
			      if(ESign_CollateralType.equals("ACH"))
			      {
				    	//To read from Excel
			    	  ACH_type=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",2);
				       ACH_transaction=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",3);
				        ACH_status=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",4);
				       ACH_amount=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",5);
				       ACH_ABA_code=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",6);
				       ACH_check_acc_no=TestData.getCellData(sheetName_calc,columnname+"_ACHHistory_FieldValue",7);
				       
			
			      }

			       
			      
			       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
			       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
			       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
			       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
			       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
			       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
			       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
			       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
			       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
			       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
			       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
					        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
					        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
					        String IncomeP1 = Income_WorkPhone.substring(0, 3);
					        String IncomeP2 = Income_WorkPhone.substring(3, 6);
					        String IncomeP3 = Income_WorkPhone.substring(6, 10);
					        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
					        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
					        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
					        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
					        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
					        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
					        System.out.println(Misc_IDExpDate);
					        Date Misc_IDExpDt = df.parse(Misc_IDExpDate);
					        String IDExpDate0 =df.format(Misc_IDExpDt);	
					        System.out.println(IDExpDate0);
					        String IDExpDate[] =IDExpDate0.split("/");
					        String IDExpD1 = IDExpDate[0];
					        String IDExpD2 = IDExpDate[1];
					        String IDExpD3 = IDExpDate[2];
					        String DOB[] =BorrDOB.split("/");
					        String DOB1 = DOB[0];
					        String DOB2 = DOB[1];
					        String DOB3 = DOB[2];	
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction History validation has started");

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();	
					/*driver.switchTo().defaultContent();				
					driver.switchTo().frame("topFrame");
					driver.findElement(By.xpath("//*[contains(text(),'Loan Transactions')]")).click();	*/		
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.findElement(By.cssSelector("li[id='911101']")).click();			
					test.log(LogStatus.PASS, "Clicked on Transactions");		
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
				    
				    
				  // String loan_nbr= driver.findElement(locator(Rprop.getProperty("csr_loan_nbr"))).getText();
				  // test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					// driver.findElement(By.name("button")).click();
					
						    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   // driver.findElement(By.name("button")).click();
					    
					  if(ProductID.equals("PDL"))
						 {
					   // driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					    driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
					    }
					    if(ProductID.equals("TLP"))
						 {
					    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
						 }
					    
					    Thread.sleep(5000);
					    if(ProductID.equals("LOC"))
						 {
					    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
						 }
					    Thread.sleep(500);
					    if(ProductID.equals("ILP"))
						 {
					    	///html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]	
					    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 }
					   
						
					    Thread.sleep(1000);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 
						
						 Thread.sleep(3000);
			 //Validations
							
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
						 
						
						  if(ESign_CollateralType.equals("ACH"))
					      {
						    						       
						//To read from application       
						       ach_history_ach_type= driver.findElement(locator(Rprop.getProperty("ach_history_ach_type"))).getText();
								ach_history_ach_transaction= driver.findElement(locator(Rprop.getProperty("ach_history_ach_transaction"))).getText();
								ach_history_ach_status= driver.findElement(locator(Rprop.getProperty("ach_history_ach_status"))).getText();
								ach_history_ach_amt= driver.findElement(locator(Rprop.getProperty("ach_history_ach_amt"))).getText();
								ach_history_ach_ABA_code= driver.findElement(locator(Rprop.getProperty("ach_history_ach_ABA_code"))).getText();
								ach_history_ach_check_acc_no= driver.findElement(locator(Rprop.getProperty("ach_history_ach_check_acc_no"))).getText();
					      }
																		
						  String Status=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[3]/td/span[2]")).getText();
						  if(check_status.equalsIgnoreCase(Status))
							{
								test.log(LogStatus.PASS, "check_status->Expected value:"+check_status +"; == Actual value:"+Status);
							}
							else
							{
								test.log(LogStatus.FAIL, "check_status->Expected value:"+check_status +"; not equals to Actual value:"+Status);

							}
						  String LoanStatus=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[2]/td/span[2]")).getText();
						  if(loan_status.equalsIgnoreCase(LoanStatus))
							{
								test.log(LogStatus.PASS, "loan_status->Expected value:"+loan_status +"; == Actual value:"+LoanStatus);
							}
							else
							{
								test.log(LogStatus.FAIL, "loan_status->Expected value:"+loan_status +"; not equals to Actual value:"+LoanStatus);

							}
												
							
							//ACH validations
				
							if(ESign_CollateralType.equals("ACH"))
							{
								if(ACH_type.equalsIgnoreCase(ach_history_ach_type))
								{
									test.log(LogStatus.PASS, "ACH_type->Expected value:"+ACH_type +"; == Actual value:"+ach_history_ach_type);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_type->Expected value:"+ACH_type +"; not equals to Actual value:"+ach_history_ach_type);

								}
								if(ACH_transaction.equalsIgnoreCase(ach_history_ach_transaction))
								{
									test.log(LogStatus.PASS, "ACH_transaction->Expected value:"+ACH_transaction +"; == Actual value:"+ach_history_ach_transaction);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_transaction->Expected value:"+ACH_transaction +"; not equals to Actual value:"+ach_history_ach_transaction);
	
								}
								
	
								if(ACH_status.contains(ach_history_ach_status))
								{
									test.log(LogStatus.PASS, "ACH_status->Expected value:"+ACH_status +"; == Actual value:"+ach_history_ach_status);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_status->Expected value:"+ACH_status +"; not equals to Actual value:"+ach_history_ach_status);
	
								}
								if(ACH_amount.equalsIgnoreCase(ach_history_ach_amt))
								{
									test.log(LogStatus.PASS, "ACH_amount->Expected value:"+ACH_amount +"; == Actual value:"+ach_history_ach_amt);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_amount->Expected value:"+ACH_amount +"; not equals to Actual value:"+ach_history_ach_amt);
	
								}
								if(ACH_ABA_code.equalsIgnoreCase(ach_history_ach_ABA_code))
								{
									test.log(LogStatus.PASS, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; == Actual value:"+ach_history_ach_ABA_code);
								}
								else
								{
									test.log(LogStatus.FAIL, "ACH_ABA_code->Expected value:"+ACH_ABA_code +"; not equals to Actual value:"+ach_history_ach_ABA_code);
	
								}
								
							}	
						//	test.log(LogStatus.PASS, MarkupHelper.createLabel("History Transaction is successful", ExtentColor.GREEN));
							test.log(LogStatus.PASS, "History Transaction is successful");
							test.log(LogStatus.PASS, "**********************************************");

							break;
							
}
			}
		
			}
}