package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class LendNationFinancialInformation extends QCStore {
	@Test(priority=3)
	  public static void financialInformation(String SSN,String AppURL) throws Exception
		  
	  {
			 
			try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Financial Informartion");
					String sheetName="Financial Informartion";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						
				if(SSN.equals(RegSSN))
				{	
			String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
			String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
			String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
			String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
			String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
			String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
			String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
			String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
			String HireDate = TestData.getCellData(sheetName,"Hire_Date",row);
			
			String AccountType = TestData.getCellData(sheetName,"AccountType",row);
			String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
			String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			String MonthlyType = TestData.getCellData(sheetName,"MonthlyType",row);
			String MonthlyPayWeek = TestData.getCellData(sheetName,"MonthlyPayWeek",row);
			String MonthlyPayWeekDay = TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
			
			String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			String LastName = TestData.getCellData(sheetName,"LastName",row);
			String BillingAddress = TestData.getCellData(sheetName,"BillingAddress",row);
			String DebitCard = TestData.getCellData(sheetName,"DebitCard",row);
			String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			String CardType = TestData.getCellData(sheetName,"CardType",row);
			String CVV = TestData.getCellData(sheetName,"CVV",row);
			String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
			String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
		
	Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("income_type"))).sendKeys(IncomeSourse);
		 //test.log(LogStatus.INFO, "Lend Nation application navigated to Financial Information page ");
	     test.log(LogStatus.INFO, "*******Lend Nation application navigated to Financial Information page*******");

	     Thread.sleep(500);
		  try { 
				driver.findElement(By.name("primaryIncomeCheck")).click();
				test.log(LogStatus.PASS, "Clicked On Primary Incom Check Box");

			}
			catch(Exception e){
				//do what you normally would if you didn't have the alert.
			}
		  Thread.sleep(500);
		  test.log(LogStatus.PASS, "Selected Income source as " + IncomeSourse);
		  Thread.sleep(500);
		  //wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_name")))));

		  driver.findElement(locator(prop.getProperty("employer_name"))).sendKeys(EmployerName);
		  test.log(LogStatus.PASS, "Entered Employer Name : " + EmployerName);
		  Thread.sleep(500);
		  try { 
				driver.findElement(By.name("vpdCust")).sendKeys("NO");
				test.log(LogStatus.PASS, "Select State or Govt emp as : NO ");

			}
			catch(Exception e){
				//do what you normally would if you didn't have the alert.
			}
		  Thread.sleep(500);
		  driver.findElement(locator(prop.getProperty("employer_industry"))).sendKeys(EmployerIndustry);
		  test.log(LogStatus.PASS, "Selected Employer Industry as " + EmployerIndustry);
		  Thread.sleep(500);
		 // wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_phone_no")))));

		  driver.findElement(locator(prop.getProperty("employer_phone_no"))).sendKeys(WorkPhone);
		  test.log(LogStatus.PASS, "Enterted Employer phone no :" + WorkPhone);
		  Thread.sleep(500);
		
		  WebElement hiredate = driver.findElement(By.xpath("//*[@id='hiredDate']"));
		    hiredate.click();
	        test.log(LogStatus.PASS, "Clicked On Hire Date Calender");
	        Thread.sleep(300);
	        WebElement hiredateyear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
	        hiredateyear.click();
	        Thread.sleep(300);
	        test.log(LogStatus.PASS, "Clicked On Year");
	        Actions action1 = new Actions(driver);

			action1.moveToElement(hiredateyear);
	        action1.sendKeys(Keys.PAGE_UP).build().perform();
	        Thread.sleep(300);	        
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
	        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a")).click();
	        Thread.sleep(300);
	        String Hdate = driver.findElement(By.xpath("//*[@id='hiredDate']")).getAttribute("value");
		   System.out.println(Hdate);
			test.log(LogStatus.PASS, "Entered Hire Date as  :"+ Hdate);
			 Thread.sleep(300);
	        
//============================================ Pay Frequency ===========================================================
		    Thread.sleep(200);
		  if(Income_PayFrequency.equalsIgnoreCase("Bi-Weekly")){
			  
				 Thread.sleep(200); 
				 
				 driver.findElement(locator(prop.getProperty("pay_frequency"))).sendKeys(Income_PayFrequency);
				 test.log(LogStatus.PASS, "Selected Pay frequency as " + Income_PayFrequency);

				  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
				  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
				  
				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("income_pay_day")))));
				  driver.findElement(locator(prop.getProperty("income_pay_day"))).sendKeys(PaidDay);
				  test.log(LogStatus.PASS, "Selected Income paid day as " + PaidDay);

				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("next_pay_day")))));
				  //driver.findElement(locator(prop.getProperty("next_pay_day"))).click();
				  driver.findElement(By.id("second")).click();
				  test.log(LogStatus.PASS, "Selected Next pay date " );
				  
				  Thread.sleep(200);
				  
				  String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
				  test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				}
		  if(Income_PayFrequency.equalsIgnoreCase("Semi-Monthly")){
			  
				 Thread.sleep(200); 
				 
		
						//driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
						
						Thread.sleep(200); 
						
						driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
						test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200);
						
						driver.findElement(By.xpath("//*[@id='incomeWeekNxtPaydt20']")).click();
						test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
						
						Thread.sleep(200); 
						
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				
				}
		
		  if(Income_PayFrequency.equals("Monthly")){
			  
			  Thread.sleep(200); 
			  
			  
			  driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
			  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
			  
			  Thread.sleep(200);
			  
			  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
			  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
			  
			  Thread.sleep(200);			  
				
				if(MonthlyType.equals("1")){
					driver.findElement(By.xpath("//*[@id='incomeRadio10']")).click();
					test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
					
					Thread.sleep(500); 
					
					//driver.findElement(By.xpath("//*[@id='income1st0']")).sendKeys(MonthDay);
					//test.log(LogStatus.PASS, "Each of Month is: " +MonthDay);											
					Select Value = new Select(driver.findElement(By.id("income1st0")));
					Value.selectByValue("5");
					
					Thread.sleep(200);
					
					
					String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				}
				else if(MonthlyType.equals("2")){
					
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//input[@value='2' and @name='incomeRadio10']")).click();
					
					 test.log(LogStatus.PASS, "Clicked on Radio button");
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st20']")).sendKeys(MonthlyPayWeek);
					 test.log(LogStatus.PASS, "Month Pay Week Select as :" +MonthlyPayWeek);
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st30']")).sendKeys(MonthlyPayWeekDay);
					 test.log(LogStatus.PASS, "Month Pay WeekDay Select as :" +MonthlyPayWeekDay);
					 
					 Thread.sleep(200);
						
					 String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					 test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
		
					}}
		  if(Income_PayFrequency.equalsIgnoreCase("Weekly")){
			  
				 Thread.sleep(200); 
				 
		
				      driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
					  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
					
					  Thread.sleep(200); 
					
					  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
					  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@type='radio'")).click();
						test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@id='week']")).sendKeys(PaidDay);
						test.log(LogStatus.PASS, "Exch of Month is: " +PaidDay);
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
						
				
				
				}
//===========================================================================================================

		 
		  driver.findElement(locator(prop.getProperty("gross_pay"))).sendKeys(Income_GrossIncome);
		  test.log(LogStatus.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		  driver.findElement(locator(prop.getProperty("net_pay"))).sendKeys(TakeHome);
		  test.log(LogStatus.PASS, "Entered Net pay amount is : " + TakeHome);

		  
		  driver.findElement(locator(prop.getProperty("add_income_button"))).click();
		  test.log(LogStatus.PASS, "Added Income " );
		  Thread.sleep(800);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("receive_type_financial_page")))));
		  driver.findElement(locator(prop.getProperty("receive_type_financial_page"))).sendKeys(ReceiveType);
		  //test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
		  
		  Thread.sleep(500);
		  
		  if(ReceiveType.equalsIgnoreCase("ACH")){
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  
				 Thread.sleep(200); 
				 
		
				 driver.findElement(locator(prop.getProperty("account_type"))).sendKeys(AccountType);
				  test.log(LogStatus.PASS, "Selected account type as " + AccountType );
				 
				  driver.findElement(locator(prop.getProperty("ABA_number_field"))).sendKeys(Bank_ABARoutingNbr);
				  test.log(LogStatus.PASS, "Entered ABA number : " + Bank_ABARoutingNbr);
				  Thread.sleep(500);
				  driver.findElement(locator(prop.getProperty("account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Entered Account number : " + AccountNumber);
				  Thread.sleep(500);

				  driver.findElement(locator(prop.getProperty("confirm_account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Confirmed account number : " + AccountNumber);										
				
				}
		  else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
								
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  
				}
		  
		  else if(ReceiveType.equalsIgnoreCase("Instant Funding With Debit Card")){			
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  Thread.sleep(8000);
			  driver.findElement(By.name("cardSelection")).sendKeys("NEW CARD");			  
			  test.log(LogStatus.PASS, "Selected Card as : NEW CARD");
			  Thread.sleep(15000);
			 
			 
			  driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
				test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
				Thread.sleep(100);
			  
			  String mainwindow=driver.getWindowHandle();
			  
			    for(String winHandle : driver.getWindowHandles()){
					if(!mainwindow.equalsIgnoreCase(winHandle))
					{
				    driver.switchTo().window(winHandle);
				    
					driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
					test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
					Thread.sleep(100);
					
					driver.findElement(By.name("card_number")).sendKeys(DebitCard);
					test.log(LogStatus.PASS, "Debit Card Number is : " + DebitCard);
					  
					Thread.sleep(300);
					
					driver.findElement(By.name("card_expiration_month")).sendKeys(ExpMonth);
					test.log(LogStatus.PASS, "Exp Month is : " + ExpMonth);
					  
					Thread.sleep(300);
					  
					driver.findElement(By.name("card_expiration_year")).sendKeys(ExpYear);
					test.log(LogStatus.PASS, "Exp year is : " + ExpYear);
					
					Thread.sleep(300);
					
					driver.findElement(By.name("card_cvc")).sendKeys(CVV);
				    test.log(LogStatus.PASS, "Cvv Number is : " + CVV);
				    
				    Thread.sleep(300);
					  
					driver.findElement(By.name("address_street")).sendKeys(BillingAddress);
					test.log(LogStatus.PASS, "Billing Address is : " + BillingAddress);
					  
					Thread.sleep(300);
					 					  					  
					driver.findElement(By.name("address_zip")).sendKeys(ZipCode);
					test.log(LogStatus.PASS, "Zip Code is : " + ZipCode);
					  
					Thread.sleep(300);
					
					driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/form/div[3]/button)")).click();
					test.log(LogStatus.PASS, "Clicked On Save Card button");
					
					Thread.sleep(30000);
					
					if(driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/div[2])")).getText().contains("Card Saved Successfully"))
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Card Is Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Card is not saved ");
					}
					Thread.sleep(3000);
					driver.findElement(By.xpath("xpath(//*[@id='hppCloseBtn'])")).click();
					test.log(LogStatus.PASS, "Clicked On Finish button");
					//close = xpath(//*[@id="repayModal"]/div/div/div[1]/button)
					
			        driver.close();
					break;
					}
			    }
					driver.switchTo().window(mainwindow);
			  
			  
				}
		  
		

		  Thread.sleep(2000);
		
		  //driver.findElement(By.xpath("//*[@id='incSubmitBtn']")).click();
		  driver.findElement(By.xpath("//*[@id='incomeSubmitBtn']")).click();
		  test.log(LogStatus.PASS, "Clicked on Continue " );
		  Thread.sleep(20000);
		  
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("repayment_method_type")))));
		  Thread.sleep(5000);
		  if( driver.findElement(locator(prop.getProperty("repayment_method_type"))).isEnabled())
		  {
			    test.log(LogStatus.PASS, "<FONT color=green style=Arial> Finanacial Information Entered Successfully with SSN : " +SSN);
				test.log(LogStatus.INFO, "******************************************************** ");
				Thread.sleep(10000);
				//Thread.sleep(30000);

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Financial Information is not entered Successfully with SSN : " +SSN);
				}
	  

				}
			}
			
	  }
			 catch(Exception e)
			  {
					//test.log(LogStatus.ERROR, "Financial Information is not successfully filled with SSN : " +SSN);
					//test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "financialInformation");
					  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			
	  }
	  

}
	
	  public static void financialInformation_cashatstore_notallowed(String SSN,String AppURL) throws Exception
	  
	  {
			 
			try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Financial Informartion");
					String sheetName="Financial Informartion";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						
				if(SSN.equals(RegSSN))
				{	
			String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
			String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
			String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
			String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
			String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
			String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
			String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
			String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
			String HireDate = TestData.getCellData(sheetName,"Hire_Date",row);
			
			String AccountType = TestData.getCellData(sheetName,"AccountType",row);
			String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
			String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			String MonthlyType = TestData.getCellData(sheetName,"MonthlyType",row);
			String MonthlyPayWeek = TestData.getCellData(sheetName,"MonthlyPayWeek",row);
			String MonthlyPayWeekDay = TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
			
			String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			String LastName = TestData.getCellData(sheetName,"LastName",row);
			String BillingAddress = TestData.getCellData(sheetName,"BillingAddress",row);
			String DebitCard = TestData.getCellData(sheetName,"DebitCard",row);
			String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			String CardType = TestData.getCellData(sheetName,"CardType",row);
			String CVV = TestData.getCellData(sheetName,"CVV",row);
			String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
			String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
		
	Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("income_type"))).sendKeys(IncomeSourse);
		 //test.log(LogStatus.INFO, "Lend Nation application navigated to Financial Information page ");
	test.log(LogStatus.INFO, "*******Lend Nation application navigated to Financial Information page*******");


		  test.log(LogStatus.PASS, "Selected Income source as " + IncomeSourse);
		  Thread.sleep(500);
		  //wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_name")))));

		  driver.findElement(locator(prop.getProperty("employer_name"))).sendKeys(EmployerName);
		  test.log(LogStatus.PASS, "Entered Employer Name : " + EmployerName);

		  driver.findElement(locator(prop.getProperty("employer_industry"))).sendKeys(EmployerIndustry);
		  test.log(LogStatus.PASS, "Selected Employer Industry as " + EmployerIndustry);
		  Thread.sleep(500);
		 // wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_phone_no")))));

		  driver.findElement(locator(prop.getProperty("employer_phone_no"))).sendKeys(WorkPhone);
		  test.log(LogStatus.PASS, "Enterted Employer phone no :" + WorkPhone);
		  Thread.sleep(500);
		
		  WebElement hiredate = driver.findElement(By.xpath("//*[@id='hiredDate']"));
		    hiredate.click();
	        test.log(LogStatus.PASS, "Clicked On Hire Date Calender");
	        Thread.sleep(300);
	        WebElement hiredateyear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
	        hiredateyear.click();
	        Thread.sleep(300);
	        test.log(LogStatus.PASS, "Clicked On Year");
	        Actions action1 = new Actions(driver);

			action1.moveToElement(hiredateyear);
	        action1.sendKeys(Keys.PAGE_UP).build().perform();
	        Thread.sleep(300);	        
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
	        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a")).click();
	        Thread.sleep(300);
	        String Hdate = driver.findElement(By.xpath("//*[@id='hiredDate']")).getAttribute("value");
		   System.out.println(Hdate);
			test.log(LogStatus.PASS, "Entered Hire Date as  :"+ Hdate);
			 Thread.sleep(300);
	        
//============================================ Pay Frequency ===========================================================
		    Thread.sleep(200);
		  if(Income_PayFrequency.equalsIgnoreCase("Bi-Weekly")){
			  
				 Thread.sleep(200); 
				 
				 driver.findElement(locator(prop.getProperty("pay_frequency"))).sendKeys(Income_PayFrequency);
				 test.log(LogStatus.PASS, "Selected Pay frequency as " + Income_PayFrequency);

				  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
				  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
				  
				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("income_pay_day")))));
				  driver.findElement(locator(prop.getProperty("income_pay_day"))).sendKeys(PaidDay);
				  test.log(LogStatus.PASS, "Selected Income paid day as " + PaidDay);

				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("next_pay_day")))));
				  //driver.findElement(locator(prop.getProperty("next_pay_day"))).click();
				  driver.findElement(By.id("second")).click();
				  test.log(LogStatus.PASS, "Selected Next pay date " );
				  
				  Thread.sleep(200);
				  
				  String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
				  test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				}
		  if(Income_PayFrequency.equalsIgnoreCase("Semi-Monthly")){
			  
				 Thread.sleep(200); 
				 
		
						//driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
						
						Thread.sleep(200); 
						
						driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
						test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200);
						
						driver.findElement(By.xpath("//*[@id='incomeWeekNxtPaydt20']")).click();
						test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
						
						Thread.sleep(200); 
						
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				
				}
		
		  if(Income_PayFrequency.equals("Monthly")){
			  
			  Thread.sleep(200); 
			  
			  
			  driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
			  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
			  
			  Thread.sleep(200);
			  
			  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
			  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
			  
			  Thread.sleep(200);			  
				
				if(MonthlyType.equals("1")){
					driver.findElement(By.xpath("//*[@id='incomeRadio10']")).click();
					test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
					
					Thread.sleep(500); 
					
					//driver.findElement(By.xpath("//*[@id='income1st0']")).sendKeys(MonthDay);
					//test.log(LogStatus.PASS, "Each of Month is: " +MonthDay);											
					Select Value = new Select(driver.findElement(By.id("income1st0")));
					Value.selectByValue("5");
					
					Thread.sleep(200);
					
					
					String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				}
				else if(MonthlyType.equals("2")){
					
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//input[@value='2' and @name='incomeRadio10']")).click();
					
					 test.log(LogStatus.PASS, "Clicked on Radio button");
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st20']")).sendKeys(MonthlyPayWeek);
					 test.log(LogStatus.PASS, "Month Pay Week Select as :" +MonthlyPayWeek);
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st30']")).sendKeys(MonthlyPayWeekDay);
					 test.log(LogStatus.PASS, "Month Pay WeekDay Select as :" +MonthlyPayWeekDay);
					 
					 Thread.sleep(200);
						
					 String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					 test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
		
					}}
		  if(Income_PayFrequency.equalsIgnoreCase("Weekly")){
			  
				 Thread.sleep(200); 
				 
		
				      driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
					  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
					
					  Thread.sleep(200); 
					
					  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
					  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@type='radio'")).click();
						test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@id='week']")).sendKeys(PaidDay);
						test.log(LogStatus.PASS, "Exch of Month is: " +PaidDay);
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
						
				
				
				}
//===========================================================================================================

		 
		  driver.findElement(locator(prop.getProperty("gross_pay"))).sendKeys(Income_GrossIncome);
		  test.log(LogStatus.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		  driver.findElement(locator(prop.getProperty("net_pay"))).sendKeys(TakeHome);
		  test.log(LogStatus.PASS, "Entered Net pay amount is : " + TakeHome);

		  
		  driver.findElement(locator(prop.getProperty("add_income_button"))).click();
		  test.log(LogStatus.PASS, "Added Income " );
		  Thread.sleep(800);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("receive_type_financial_page")))));
		  driver.findElement(locator(prop.getProperty("receive_type_financial_page"))).sendKeys(ReceiveType);
		  //test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
		  
		  Thread.sleep(500);
		  
		  if(ReceiveType.equalsIgnoreCase("ACH")){
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  
				 Thread.sleep(200); 
				 
		
				 driver.findElement(locator(prop.getProperty("account_type"))).sendKeys(AccountType);
				  test.log(LogStatus.PASS, "Selected account type as " + AccountType );
				 
				  driver.findElement(locator(prop.getProperty("ABA_number_field"))).sendKeys(Bank_ABARoutingNbr);
				  test.log(LogStatus.PASS, "Entered ABA number : " + Bank_ABARoutingNbr);
				  Thread.sleep(500);
				  driver.findElement(locator(prop.getProperty("account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Entered Account number : " + AccountNumber);
				  Thread.sleep(500);

				  driver.findElement(locator(prop.getProperty("confirm_account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Confirmed account number : " + AccountNumber);										
				
				}
		  else if(ReceiveType.equalsIgnoreCase("Cash At Store")){								
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  Thread.sleep(500);
			  
				 
			  if(driver.findElement(By.xpath("//*[@id='stateCode']/center/span")).isDisplayed())
				{
					Thread.sleep(500);
					test.log(LogStatus.INFO, "<FONT color=green style=Arial> As per the Scenario: Application is not allowing to choose Cash At Store Option from Funding Method Dropdown");
				  
				}	
			  else{
				  test.log(LogStatus.FAIL, "Allowing to choose Cash At Store" );
				  Assert.assertTrue(false);
			  }
			
          Thread.sleep(1000);
		  
		  test.log(LogStatus.INFO, "******************************************************** ");
		  test.log(LogStatus.INFO, "****************** Cash At Store Validation Completed *************************** ");
      
		break;
			  			  
			  
				}
		  
		  else if(ReceiveType.equalsIgnoreCase("Instant Funding With Debit Card")){			
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  Thread.sleep(8000);
			  driver.findElement(By.name("cardSelection")).sendKeys("NEW CARD");			  
			  test.log(LogStatus.PASS, "Selected Card as : NEW CARD");
			  Thread.sleep(15000);
			 
			 
			  driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
				test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
				Thread.sleep(100);
			  
			  String mainwindow=driver.getWindowHandle();
			  
			    for(String winHandle : driver.getWindowHandles()){
					if(!mainwindow.equalsIgnoreCase(winHandle))
					{
				    driver.switchTo().window(winHandle);
				    
					driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
					test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
					Thread.sleep(100);
					
					driver.findElement(By.name("card_number")).sendKeys(DebitCard);
					test.log(LogStatus.PASS, "Debit Card Number is : " + DebitCard);
					  
					Thread.sleep(300);
					
					driver.findElement(By.name("card_expiration_month")).sendKeys(ExpMonth);
					test.log(LogStatus.PASS, "Exp Month is : " + ExpMonth);
					  
					Thread.sleep(300);
					  
					driver.findElement(By.name("card_expiration_year")).sendKeys(ExpYear);
					test.log(LogStatus.PASS, "Exp year is : " + ExpYear);
					
					Thread.sleep(300);
					
					driver.findElement(By.name("card_cvc")).sendKeys(CVV);
				    test.log(LogStatus.PASS, "Cvv Number is : " + CVV);
				    
				    Thread.sleep(300);
					  
					driver.findElement(By.name("address_street")).sendKeys(BillingAddress);
					test.log(LogStatus.PASS, "Billing Address is : " + BillingAddress);
					  
					Thread.sleep(300);
					 					  					  
					driver.findElement(By.name("address_zip")).sendKeys(ZipCode);
					test.log(LogStatus.PASS, "Zip Code is : " + ZipCode);
					  
					Thread.sleep(300);
					
					driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/form/div[3]/button)")).click();
					test.log(LogStatus.PASS, "Clicked On Save Card button");
					
					Thread.sleep(30000);
					
					if(driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/div[2])")).getText().contains("Card Saved Successfully"))
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Card Is Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Card is not saved ");
					}
					Thread.sleep(3000);
					driver.findElement(By.xpath("xpath(//*[@id='hppCloseBtn'])")).click();
					test.log(LogStatus.PASS, "Clicked On Finish button");
					//close = xpath(//*[@id="repayModal"]/div/div/div[1]/button)
					
			        driver.close();
					break;
					}
			    }
					driver.switchTo().window(mainwindow);
			  
			  
				}
		  
		

		  Thread.sleep(2000);
		
		 
		/*  if( driver.findElement(locator(prop.getProperty("repayment_method_type"))).isEnabled())
		  {
			    test.log(LogStatus.PASS, "<FONT color=green style=Arial> Finanacial Information Entered Successfully with SSN : " +SSN);
				test.log(LogStatus.INFO, "******************************************************** ");
				Thread.sleep(10000);
				//Thread.sleep(30000);

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Financial Information is not entered Successfully with SSN : " +SSN);
				}*/
	  

				}
			}
			
	  }
			 catch(Exception e)
			  {
					//test.log(LogStatus.ERROR, "Financial Information is not successfully filled with SSN : " +SSN);
					//test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "financialInformation");
					  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			
	  }
	  

}	
	  
	  public static void financialInformation_cashatstore_allowed(String SSN,String AppURL) throws Exception
	  
	  {
			 
			try{
				//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
				
				//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
					int lastrow=TestData.getLastRow("Financial Informartion");
					String sheetName="Financial Informartion";

					for(int row=2;row<=lastrow;row++)
					{		
						String RegSSN = TestData.getCellData(sheetName,"SSN",row);
						
				if(SSN.equals(RegSSN))
				{	
			String IncomeSourse = TestData.getCellData(sheetName,"IncomeSourse",row);
			String EmployerName = TestData.getCellData(sheetName,"EmployerName",row);
			String EmployerIndustry = TestData.getCellData(sheetName,"EmployerIndustry",row);
			String WorkPhone = TestData.getCellData(sheetName,"WorkPhone",row);
			String TimeAtJob = TestData.getCellData(sheetName,"TimeAtJob",row);
			String Income_GrossIncome = TestData.getCellData(sheetName,"Income_GrossIncome",row);
			String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			String PayMethod = TestData.getCellData(sheetName,"PayMethod",row);
			String PaidDay = TestData.getCellData(sheetName,"PaidDay",row);
			String TakeHome = TestData.getCellData(sheetName,"TakeHome",row);
			String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
			String HireDate = TestData.getCellData(sheetName,"Hire_Date",row);
			
			String AccountType = TestData.getCellData(sheetName,"AccountType",row);
			String AccountNumber = TestData.getCellData(sheetName,"AccountNumber",row);
			String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
			String MonthlyType = TestData.getCellData(sheetName,"MonthlyType",row);
			String MonthlyPayWeek = TestData.getCellData(sheetName,"MonthlyPayWeek",row);
			String MonthlyPayWeekDay = TestData.getCellData(sheetName,"MonthlyPayWeekDay",row);
			
			String FirstName = TestData.getCellData(sheetName,"FirstName",row);
			String LastName = TestData.getCellData(sheetName,"LastName",row);
			String BillingAddress = TestData.getCellData(sheetName,"BillingAddress",row);
			String DebitCard = TestData.getCellData(sheetName,"DebitCard",row);
			String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
			String CardType = TestData.getCellData(sheetName,"CardType",row);
			String CVV = TestData.getCellData(sheetName,"CVV",row);
			String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
			String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
		
	Thread.sleep(5000);
		  driver.findElement(locator(prop.getProperty("income_type"))).sendKeys(IncomeSourse);
		 //test.log(LogStatus.INFO, "Lend Nation application navigated to Financial Information page ");
	test.log(LogStatus.INFO, "*******Lend Nation application navigated to Financial Information page*******");


		  test.log(LogStatus.PASS, "Selected Income source as " + IncomeSourse);
		  Thread.sleep(500);
		  //wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_name")))));

		  driver.findElement(locator(prop.getProperty("employer_name"))).sendKeys(EmployerName);
		  test.log(LogStatus.PASS, "Entered Employer Name : " + EmployerName);

		  driver.findElement(locator(prop.getProperty("employer_industry"))).sendKeys(EmployerIndustry);
		  test.log(LogStatus.PASS, "Selected Employer Industry as " + EmployerIndustry);
		  Thread.sleep(500);
		 // wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(locator(prop.getProperty("employer_phone_no")))));

		  driver.findElement(locator(prop.getProperty("employer_phone_no"))).sendKeys(WorkPhone);
		  test.log(LogStatus.PASS, "Enterted Employer phone no :" + WorkPhone);
		  Thread.sleep(500);
		
		  WebElement hiredate = driver.findElement(By.xpath("//*[@id='hiredDate']"));
		    hiredate.click();
	        test.log(LogStatus.PASS, "Clicked On Hire Date Calender");
	        Thread.sleep(300);
	        WebElement hiredateyear = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
	        hiredateyear.click();
	        Thread.sleep(300);
	        test.log(LogStatus.PASS, "Clicked On Year");
	        Actions action1 = new Actions(driver);

			action1.moveToElement(hiredateyear);
	        action1.sendKeys(Keys.PAGE_UP).build().perform();
	        Thread.sleep(300);	        
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
	        //driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a")).click();
	        Thread.sleep(300);
	        String Hdate = driver.findElement(By.xpath("//*[@id='hiredDate']")).getAttribute("value");
		   System.out.println(Hdate);
			test.log(LogStatus.PASS, "Entered Hire Date as  :"+ Hdate);
			 Thread.sleep(300);
	        
//============================================ Pay Frequency ===========================================================
		    Thread.sleep(200);
		  if(Income_PayFrequency.equalsIgnoreCase("Bi-Weekly")){
			  
				 Thread.sleep(200); 
				 
				 driver.findElement(locator(prop.getProperty("pay_frequency"))).sendKeys(Income_PayFrequency);
				 test.log(LogStatus.PASS, "Selected Pay frequency as " + Income_PayFrequency);

				  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
				  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
				  
				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("income_pay_day")))));
				  driver.findElement(locator(prop.getProperty("income_pay_day"))).sendKeys(PaidDay);
				  test.log(LogStatus.PASS, "Selected Income paid day as " + PaidDay);

				  Thread.sleep(2000);
				  
				  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("next_pay_day")))));
				  //driver.findElement(locator(prop.getProperty("next_pay_day"))).click();
				  driver.findElement(By.id("second")).click();
				  test.log(LogStatus.PASS, "Selected Next pay date " );
				  
				  Thread.sleep(200);
				  
				  String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
				  test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				}
		  if(Income_PayFrequency.equalsIgnoreCase("Semi-Monthly")){
			  
				 Thread.sleep(200); 
				 
		
						//driver.findElement(By.name("customerBean.payFreqCdDisp")).sendKeys(Income_PayFrequency);
						driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
						test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
						
						Thread.sleep(200); 
						
						driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
						test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200);
						
						driver.findElement(By.xpath("//*[@id='incomeWeekNxtPaydt20']")).click();
						test.log(LogStatus.PASS, "Clicked on 1st and 16th of check box  ");
						
						Thread.sleep(200); 
						
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				
				
				}
		
		  if(Income_PayFrequency.equals("Monthly")){
			  
			  Thread.sleep(200); 
			  
			  
			  driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
			  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);	
			  
			  Thread.sleep(200);
			  
			  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
			  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
			  
			  Thread.sleep(200);			  
				
				if(MonthlyType.equals("1")){
					driver.findElement(By.xpath("//*[@id='incomeRadio10']")).click();
					test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
					
					Thread.sleep(500); 
					
					//driver.findElement(By.xpath("//*[@id='income1st0']")).sendKeys(MonthDay);
					//test.log(LogStatus.PASS, "Each of Month is: " +MonthDay);											
					Select Value = new Select(driver.findElement(By.id("income1st0")));
					Value.selectByValue("5");
					
					Thread.sleep(200);
					
					
					String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
				}
				else if(MonthlyType.equals("2")){
					
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//input[@value='2' and @name='incomeRadio10']")).click();
					
					 test.log(LogStatus.PASS, "Clicked on Radio button");
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st20']")).sendKeys(MonthlyPayWeek);
					 test.log(LogStatus.PASS, "Month Pay Week Select as :" +MonthlyPayWeek);
					 
					 Thread.sleep(200);
					 
					 driver.findElement(By.xpath("//*[@id='income1st30']")).sendKeys(MonthlyPayWeekDay);
					 test.log(LogStatus.PASS, "Month Pay WeekDay Select as :" +MonthlyPayWeekDay);
					 
					 Thread.sleep(200);
						
					 String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
					 test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
		
					}}
		  if(Income_PayFrequency.equalsIgnoreCase("Weekly")){
			  
				 Thread.sleep(200); 
				 
		
				      driver.findElement(By.xpath("//*[@id='iPayPeriodType']")).sendKeys(Income_PayFrequency);
					  test.log(LogStatus.PASS, "Income_PayFrequency is entered: "+Income_PayFrequency);
					
					  Thread.sleep(200); 
					
					  driver.findElement(locator(prop.getProperty("income_method_type"))).sendKeys(PayMethod);
					  test.log(LogStatus.PASS, "Selected Income method type as " + PayMethod);
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@type='radio'")).click();
						test.log(LogStatus.PASS, "Clicked on day of the month Radio button  ");
						
						Thread.sleep(200); 
						
						driver.findElement(By.xpath("//*[@id='week']")).sendKeys(PaidDay);
						test.log(LogStatus.PASS, "Exch of Month is: " +PaidDay);
						
						
						String NextPayDate = driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value");
						test.log(LogStatus.PASS, "Next Pay Date is: " +NextPayDate);
						
				
				
				}
//===========================================================================================================

		 
		  driver.findElement(locator(prop.getProperty("gross_pay"))).sendKeys(Income_GrossIncome);
		  test.log(LogStatus.PASS, "Enterted Gross pay amount is " + Income_GrossIncome);

		  driver.findElement(locator(prop.getProperty("net_pay"))).sendKeys(TakeHome);
		  test.log(LogStatus.PASS, "Entered Net pay amount is : " + TakeHome);

		  
		  driver.findElement(locator(prop.getProperty("add_income_button"))).click();
		  test.log(LogStatus.PASS, "Added Income " );
		  Thread.sleep(800);
		  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("receive_type_financial_page")))));
		  driver.findElement(locator(prop.getProperty("receive_type_financial_page"))).sendKeys(ReceiveType);
		  //test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
		  
		  Thread.sleep(500);
		  
		  if(ReceiveType.equalsIgnoreCase("ACH")){
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  
				 Thread.sleep(200); 
				 
		
				 driver.findElement(locator(prop.getProperty("account_type"))).sendKeys(AccountType);
				  test.log(LogStatus.PASS, "Selected account type as " + AccountType );
				 
				  driver.findElement(locator(prop.getProperty("ABA_number_field"))).sendKeys(Bank_ABARoutingNbr);
				  test.log(LogStatus.PASS, "Entered ABA number : " + Bank_ABARoutingNbr);
				  Thread.sleep(500);
				  driver.findElement(locator(prop.getProperty("account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Entered Account number : " + AccountNumber);
				  Thread.sleep(500);

				  driver.findElement(locator(prop.getProperty("confirm_account_number_field"))).sendKeys(AccountNumber);
				  test.log(LogStatus.PASS, "Confirmed account number : " + AccountNumber);										
				
				}
		  else if(ReceiveType.equalsIgnoreCase("Cash At Store")){								
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  Thread.sleep(500);
			  
			  try { 
				  if(driver.findElement(By.xpath("//*[@id='stateCode']/center/span")).isDisplayed())
					{
						Thread.sleep(500);
						
					  test.log(LogStatus.FAIL, "Application is not allowing to choose Cash At Store Option from Funding Method Dropdown" );
					  Assert.assertTrue(false);
					}											

				}
				catch(Exception e){
					test.log(LogStatus.INFO, "<FONT color=green style=Arial> As per the Scenario: Allowing to choose Cash At Store if the Zip Code is more then X miles");
				}
			
          Thread.sleep(1000);
		  
		  test.log(LogStatus.INFO, "******************************************************** ");
		  test.log(LogStatus.INFO, "****************** Cash At Store Validation Completed *************************** ");
      
		break;
			  			  
			  
				}
		  
		  else if(ReceiveType.equalsIgnoreCase("Instant Funding With Debit Card")){			
			  test.log(LogStatus.PASS, "Selected Receive type as " + ReceiveType);
			  Thread.sleep(8000);
			  driver.findElement(By.name("cardSelection")).sendKeys("NEW CARD");			  
			  test.log(LogStatus.PASS, "Selected Card as : NEW CARD");
			  Thread.sleep(15000);
			 
			 
			  driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
				test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
				Thread.sleep(100);
			  
			  String mainwindow=driver.getWindowHandle();
			  
			    for(String winHandle : driver.getWindowHandles()){
					if(!mainwindow.equalsIgnoreCase(winHandle))
					{
				    driver.switchTo().window(winHandle);
				    
					driver.findElement(By.name("cardholder_name")).sendKeys(FirstName);
					test.log(LogStatus.PASS, "Card Holder Name is : " + FirstName);
					Thread.sleep(100);
					
					driver.findElement(By.name("card_number")).sendKeys(DebitCard);
					test.log(LogStatus.PASS, "Debit Card Number is : " + DebitCard);
					  
					Thread.sleep(300);
					
					driver.findElement(By.name("card_expiration_month")).sendKeys(ExpMonth);
					test.log(LogStatus.PASS, "Exp Month is : " + ExpMonth);
					  
					Thread.sleep(300);
					  
					driver.findElement(By.name("card_expiration_year")).sendKeys(ExpYear);
					test.log(LogStatus.PASS, "Exp year is : " + ExpYear);
					
					Thread.sleep(300);
					
					driver.findElement(By.name("card_cvc")).sendKeys(CVV);
				    test.log(LogStatus.PASS, "Cvv Number is : " + CVV);
				    
				    Thread.sleep(300);
					  
					driver.findElement(By.name("address_street")).sendKeys(BillingAddress);
					test.log(LogStatus.PASS, "Billing Address is : " + BillingAddress);
					  
					Thread.sleep(300);
					 					  					  
					driver.findElement(By.name("address_zip")).sendKeys(ZipCode);
					test.log(LogStatus.PASS, "Zip Code is : " + ZipCode);
					  
					Thread.sleep(300);
					
					driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/form/div[3]/button)")).click();
					test.log(LogStatus.PASS, "Clicked On Save Card button");
					
					Thread.sleep(30000);
					Thread.sleep(30000);
					
					if(driver.findElement(By.xpath("xpath(//*[@id='app']/div/div/div/div[2])")).getText().contains("Card Saved Successfully"))
					{
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Card Is Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Card is not saved ");
					}
					Thread.sleep(3000);
					driver.findElement(By.xpath("xpath(//*[@id='hppCloseBtn'])")).click();
					test.log(LogStatus.PASS, "Clicked On Finish button");
					//close = xpath(//*[@id="repayModal"]/div/div/div[1]/button)
					
			        driver.close();
					break;
					}
			    }
					driver.switchTo().window(mainwindow);
			  
			  
				}
		  
		

		  Thread.sleep(2000);
		
		 
		/*  if( driver.findElement(locator(prop.getProperty("repayment_method_type"))).isEnabled())
		  {
			    test.log(LogStatus.PASS, "<FONT color=green style=Arial> Finanacial Information Entered Successfully with SSN : " +SSN);
				test.log(LogStatus.INFO, "******************************************************** ");
				Thread.sleep(10000);
				//Thread.sleep(30000);

			 	}
				else
				{
				test.log(LogStatus.FAIL, "Financial Information is not entered Successfully with SSN : " +SSN);
				}*/
	  

				}
			}
			
	  }
			 catch(Exception e)
			  {
					//test.log(LogStatus.ERROR, "Financial Information is not successfully filled with SSN : " +SSN);
					//test.log(LogStatus.ERROR, "Error message  " +e);
					  String screenshotPath = getScreenhot(driver, "financialInformation");
					  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			
	  }
	  

}
	
	
}
