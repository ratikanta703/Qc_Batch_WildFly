

package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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


public class QCCSR_CourtesyCall_PromiseToPay extends QCStore {

public static String State;
public static String SSN1;
public static String SSN2;
public static String SSN3;
	
	
	public static void courtesycall_promisetoPay(String SSN, String AppURL) {
		
			try {
				
				int lastrow = TestData.getLastRow("PromiseToPay");
				
				String sheetName="PromiseToPay";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
					String Action= TestData.getCellData(sheetName, "Action", row);
					String Response= TestData.getCellData(sheetName, "Response", row);
					String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					String PaymentNote = TestData.getCellData(sheetName,"PaymentNote",row);
					String Comment = TestData.getCellData(sheetName,"Comment",row);
					
					
					
					 
					String AgeStore = TestData.getCellData(sheetName,"AgeStore",row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);

				Thread.sleep(3000);
				test.log(LogStatus.INFO, "************ Central Store (2997)Courtesycall Promise To Pay started ******************");				
			
				driver.switchTo().frame("topFrame");	        
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='940000']")));			       
				driver.findElement(locator(prop.getProperty("account_mgmt_tab"))).click();	
				Thread.sleep(2000);				
				test.log(LogStatus.PASS, "Clicked on Account Mgmt Tab");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");			 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='940003']")));
				driver.findElement(By.xpath("//*[@id='940002']/a")).click();
				test.log(LogStatus.PASS, "Clicked on Courtesycall Link");
				Thread.sleep(1000);
				//===========================================================================================
				driver.switchTo().frame("main");
				driver.findElement(By.name("requestBean.productType")).sendKeys(ProductType);
				test.log(LogStatus.PASS, "Product type is selected as :" +ProductType);
				Thread.sleep(500);
				driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[28]/td[1]/input")).click();
				test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
				Thread.sleep(500);
				driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
				test.log(LogStatus.PASS, "Loan Nbr selected from List");
				Thread.sleep(500);
		//String loan_number="11318195";
				driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
				test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
				Thread.sleep(500);
				driver.findElement(By.name("searchajax")).click();
				test.log(LogStatus.PASS, "Clicked on Search button");
				Thread.sleep(8000);			
				              
				driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();
				//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Go button");
				Thread.sleep(2000);
						
						
						driver.findElement(By.name("requestBean.colleffortActivityCd")).sendKeys(Action);
						test.log(LogStatus.PASS, "Action entered as :" + Action);
						Thread.sleep(500);
						driver.findElement(By.name("requestBean.colleffortResponseCd")).sendKeys(Response);
						test.log(LogStatus.PASS, "Response entered as :" + Response);
						Thread.sleep(500);
						driver.findElement(By.name("paymentScheduleBean.paymentType")).sendKeys(PaymentType );
						test.log(LogStatus.PASS, "PaymentType  entered as :" + PaymentType );
						Thread.sleep(500);		
						// Create object of SimpleDateFormat class and decide the format
						 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

						 //get current date time with Date()
						 Date date = new Date();

						 // Now format the date
						 currentdate= dateFormat.format(date);

						 // Print the Date
						 System.out.println("Current date  is " +currentdate);	
						
						 /*int IAgeStore=Integer.parseInt(AgeStore);
				    	
						 DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
							Date DDueDateminus1 = df.parse(NextDueDate);
							Calendar cal = Calendar.getInstance();
							 cal.setTime(DDueDateminus1);
							 cal.add(Calendar.DATE, IAgeStore);
							 Date DDueDate1= cal.getTime();
							 NextDueDate =df.format(DDueDate1);
							 System.out.println(NextDueDate);
						     
						      test.log(LogStatus.PASS, "Age Store Date after increasing to Payment Date is :"+NextDueDate);*/
						
						
				    //String loan_status_inf_latest_payment_date=	date1;
				    //String payment_date = currentdate;
						driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						String Due_Date[] =currentdate.split("/");
				        String Due_Date1 = Due_Date[0];
				        String Due_Date2 = Due_Date[1];
				        String Due_Date3 = Due_Date[2];
				        driver.findElement(By.name("paymentDtMM")).sendKeys(Due_Date1);
				        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
						driver.findElement(By.name("paymentDtDD")).sendKeys(Due_Date2);
						test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
						driver.findElement(By.name("paymentDtYY")).sendKeys(Due_Date3);
						test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);						
						Thread.sleep(500);	
						/*driver.findElement(By.name("ptpPaymentNote")).sendKeys(PaymentNote);
						test.log(LogStatus.PASS, "Payment Note entered: "+PaymentNote);
						Thread.sleep(500);*/
                        driver.findElement(By.xpath(" //*[@id='ptpAdd']/td/input")).click();						
						test.log(LogStatus.PASS, "Clicked on Add payment button");
						Thread.sleep(500);
				        driver.findElement(By.name("requestBean.collEffortCommentText")).sendKeys(Comment);
				        test.log(LogStatus.PASS, "Comment is "+Comment);
				        Thread.sleep(500);
				        driver.findElement(By.name("SubmitButton")).click();
				        test.log(LogStatus.PASS, "Clicked on Submit button");
				        Thread.sleep(8000);
				        if (driver.findElement(By.xpath("//*[@id='ptpHistoryTable']/tbody/tr[2]/td[1]")).isDisplayed()){
							Payment_date =driver.findElement(By.xpath("//*[@id='ptpHistoryTable']/tbody/tr[2]/td[1]")).getText();
	                        
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment date is : "+Payment_date);
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Completed In Courtesy call screen ");																											
							//driver.close();	
							break;
							
						}
							
							else {
								test.log(LogStatus.FAIL, "Payment Failed");
							    //Assert.assertTrue(false);
							      Assert.assertTrue(false);
							
							break;
							}
				        
						
								}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.FAIL,"Promise to Pay process failed");

									}

						}
					}

						 

