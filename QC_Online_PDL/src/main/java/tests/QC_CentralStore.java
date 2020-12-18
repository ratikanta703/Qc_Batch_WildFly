/*package tests;

public class QC_CentralStore {

}*/
/*package tests;

public class QCCSR_FDD_Verification {

}*/

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

public class QC_CentralStore extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	
	public static void centralstore_paymentscreen_history_fddverification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("Payment");
			String sheetName = "Payment";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String TenderAmount = TestData.getCellData(sheetName, "TenderAmount", row);
				String PaymentAmount = TestData.getCellData(sheetName, "PaymentAmount", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "****** Central Store Payment Screen History FDD Verification ******");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");
					driver.switchTo().frame("main");
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(500);
						                  
						String BalanceStatus = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[6]")).getText();
														
						System.out.println(BalanceStatus);
						Thread.sleep(5000);
						if (Balance_Status.trim().equalsIgnoreCase(BalanceStatus.trim())) {
							test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
							
							driver.findElement(By.name("transactionList")).sendKeys(TxnType);
							test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
							driver.findElement(By.name("button")).click();
							test.log(LogStatus.PASS, "Clicked on Go button");
							Thread.sleep(500);
				//=======================================================================================	
							driver.findElement(By.name("Submit33")).click();
							test.log(LogStatus.PASS, "Clicked on History Button in Payment Screen");
							Thread.sleep(10000);
							String mainwindow=driver.getWindowHandle();
							for(String winHandle1 : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle1))
								{
							    driver.switchTo().window(winHandle1);							    					  
								Thread.sleep(1000);
								driver.manage().window().maximize();
								driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
								Thread.sleep(3000); 
								
								 if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).isDisplayed()){
									String Date_Created = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[1]")).getText();
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Date Created is : "+Date_Created);
									Thread.sleep(200);
									
									String Inst_Num = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[2]")).getText();
									//if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[2]")).getText().isEmpty()){
									if (Inst_Num.isEmpty()){
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is Empty in FDD History ");
									}
									else{
										test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is : "+Inst_Num);
									}
									Thread.sleep(200);
									String Org_Duedate = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[3]")).getText();
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Orginal Duedate is : "+Org_Duedate);
									Thread.sleep(200);
									String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).getText();                        
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
									Thread.sleep(200);
									String Amount = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[5]")).getText();
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Amount is : "+Amount);
									Thread.sleep(200);
									String Created_By = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[6]")).getText();
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Created By : "+Created_By);
									Thread.sleep(200);						
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> All FDD Details are Captured Successfully ");																											
									driver.close();			
						
									driver.switchTo().window(mainwindow);
							        for(String winHandle2 : driver.getWindowHandles()){
									    driver.switchTo().window(winHandle2);
										}				    
								   driver.switchTo().defaultContent();
								   driver.switchTo().frame("topFrame");
								   Thread.sleep(5000);		
						           driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
						           test.log(LogStatus.PASS, "Clicked On logout Button");
						           if(driver.getTitle().contains("Login")){
						    	   test.log(LogStatus.PASS, "Logout is Successfully"); 
						    	   test.log(LogStatus.INFO,"loggged out from the CSR Application");
						    	   Thread.sleep(5000);
						    	   test.log(LogStatus.INFO, "******************************************************** ");
						           driver.close();
						           //driver.quit();
						           Thread.sleep(3000);
						     }
							        
									break;
									}
									
									
							    }
							}
						}
							else {
								test.log(LogStatus.FAIL, "FDD Is Failed");
							}
					}
					break;
				}
				
			}
		}
					
		
							catch(Exception e){

								String screenshotPath = getScreenhot(driver, "QC_Sprint1 Transaction");
								test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
								test.log(LogStatus.INFO, "QC_Sprint1 Transaction Failed ");
								//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
								Assert.assertTrue(false);

							}


						}
				
	
	
}
	
	
	


