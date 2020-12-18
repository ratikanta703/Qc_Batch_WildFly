package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QCCSRPaymentPlanValidation extends QCStore{
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

	public static void paymentplanvalidation(String SSN,String AppURL) throws InterruptedException, ParseException
	{

				 
			int lastrow=TestData.getLastRow("Borrower_Registration");
			String sheetName="History";
			//String sheetName_calc="HistoryFieldsValidation";
			String sheetName_new_loan="New_Loan";
			

			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"UserName",row);
					String Password = TestData.getCellData(sheetName,"Password",row);
			       // System.out.println(Password); 	
			        String TransactionType = TestData.getCellData(sheetName,"TransactionType",row);
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        //String TransactionType = TestData.getCellData(sheetName,"StateID",row);
			        //String TransactionType = TestData.getCellData(sheetName,"TransactionType",row);
			        
			        
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
			        System.out.println(columnname);
			       	     
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					        
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Transaction Payment Plan validation has started");

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
					   
						
					    Thread.sleep(1000);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");						 
						
						 Thread.sleep(3000);
							
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");	
				//================================================== 
							 List<WebElement> rows = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
								int n = rows.size();
								for (int i = 2; i <= n; i++) {
								String Transaction = driver.findElement(
								By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[5]/font")).getText();
									test.log(LogStatus.PASS, "getting product name " + Transaction);									
										if (Transaction.equalsIgnoreCase("Payment Plan Payment"))								
									{
										driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[1]/input")).click();
										test.log(LogStatus.PASS, "Transaction Type is : " + Transaction);
										test.log(LogStatus.PASS, "<FONT color=green style=Arial> Transaction Type is Posted in Application History");
										break;																				
									}							 
							}																	
						//	test.log(LogStatus.PASS, MarkupHelper.createLabel("History Transaction is successful", ExtentColor.GREEN));
							test.log(LogStatus.PASS, "Payment Plan Payment Transaction Validation in History is successful");
							test.log(LogStatus.PASS, "**********************************************");

							break;
							
}
				
			}
		
			}
	
	public static void waivefeevalidation(String SSN,String AppURL) throws InterruptedException, ParseException, MalformedURLException
	{

				 
			int lastrow=TestData.getLastRow("History");
			String sheetName="History";
								
			for(int row=2;row<=lastrow;row++)
			{	
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String UserName = TestData.getCellData(sheetName,"UserName",row);
					String Password = TestData.getCellData(sheetName,"Password",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
			       // System.out.println(Password); 	
			        String TransactionType = TestData.getCellData(sheetName,"TransactionType",row);
			        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
			        String StateID = TestData.getCellData(sheetName,"StateID",row);
			        String ProductType = TestData.getCellData(sheetName,"ProductType",row);
			        //String TransactionType = TestData.getCellData(sheetName,"TransactionType",row);
			        
			        
			        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
			        String Header = StateID+ "_" + ProductID;	      
			        String columnname=StateID+"_"+ ProductID+"_"+ProductType;                                //column name
			        System.out.println(columnname);
			       	     
						
						   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
					        String SSN1 = SSN.substring(0, 3);
					        String SSN2 = SSN.substring(3,5);
					        String SSN3 = SSN.substring(5,9);
					        
					        String SSNverify="XXX-XX-"+SSN3;
					        
					        
					        //========================================
							if(SSN.equals(RegSSN))
							{	
						
								//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
								test.log(LogStatus.INFO,"CSR login has started");

								test.log(LogStatus.INFO,"Opened the CSR URL " +AppURL);


								//test.log(LogStatus.INFO, "CSR Application is launched " );
								test.log(LogStatus.INFO,"CSR Application is launched");

								if(Rprop.getProperty("login_method").equalsIgnoreCase("local"))
								{
									driver = new InternetExplorerDriver();
								}
								else
								{
									String Node = "http://192.168.2.66:5555/wd/hub";
									 //String Node2 = "http://192.168.0.238:5566/wd/hub";
									 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
									 driver = new RemoteWebDriver(new URL(Node), cap);	
								}
								 wait = new WebDriverWait(driver, 40000);
								

								driver.manage().window().maximize();
								driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
							
								driver.get(csr_url);
								
							    driver.findElement(locator(Rprop.getProperty("csr_username"))).sendKeys(UserName);
						        test.log(LogStatus.PASS, "Username is entered: "+UserName);
						        
						        

							    driver.findElement(locator(Rprop.getProperty("csr_password"))).clear();
							    driver.findElement(locator(Rprop.getProperty("csr_password"))).sendKeys(Password);
						        test.log(LogStatus.PASS, "Password is entered: "+Password);
						        
						       
						        driver.findElement(locator(Rprop.getProperty("csr_storeid"))).sendKeys(StoreID);;
						        test.log(LogStatus.PASS, "Storenumber is entered: "+StoreID);
						        //Click Login Button
						        driver.findElement(locator(Rprop.getProperty("csr_login_button"))).click();
						        test.log(LogStatus.PASS, "Clicked on login button");
						        
						       Thread.sleep(10000);
						     
		}
					        
					       //=========================================
					        
					        
					Thread.sleep(4000);
				//	test.log(LogStatus.INFO, MarkupHelper.createLabel("Transaction History validation has started", ExtentColor.BLUE));
					test.log(LogStatus.INFO, "Post Waive Fee  validation has started");

					driver.switchTo().defaultContent();	
					
			        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
			        driver.findElement(By.cssSelector("li[id='910000']")).click();						
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
	
				    driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");						    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					  
					    
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
					    	driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						 }
					   
						
					    Thread.sleep(1000);
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");						 
						
						 Thread.sleep(3000);
							
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");	
				//================================================== 							 
							 List<WebElement> rows = driver.findElements(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr"));
								int n = rows.size();
								for (int i = 2; i <= n; i++) {
								String Transaction = driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[4]")).getText();
									test.log(LogStatus.PASS, "getting Transaction name " + Transaction);									
										if (Transaction.equalsIgnoreCase("Waive Fee"))	
											//test.log(LogStatus.PASS, "getting Transaction name " + Transaction);
									{
										driver.findElement(By.xpath("//*[@id='revolvingCreditDetailsTable']/tbody/tr["+i+"]/td[1]/input")).click();
										test.log(LogStatus.PASS, "Transaction Type is : " + Transaction);
										test.log(LogStatus.PASS, "<FONT color=green style=Arial> Waive Fee is Posted in  2997 Store History");
										break;	
										
									}	
									
							}	
				
							test.log(LogStatus.PASS, "Post Waive Fee Validation in History is successful");
							test.log(LogStatus.PASS, "**********************************************");
							
							break;
							
							
}
				
				
			}
		
			}
	
	
}