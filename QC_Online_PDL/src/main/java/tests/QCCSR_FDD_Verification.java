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

public class QCCSR_FDD_Verification extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void fdd_verification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "****** FDD Details Verification in Courtesycall Screen started ********");
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
					driver.findElement(locator(prop.getProperty("courtesycall_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Courtesy call Link");
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
			//String loan_number="11318122";
					driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("searchajax")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					//driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();	
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(2000);
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();
                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Courtesy call screen ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}	
	
	public static void paymentscreen_history_fddverification(String SSN, String AppURL) throws Exception {
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
					test.log(LogStatus.INFO, "****** Payment Screen History FDD Verification ******");
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

						String BalanceStatus = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]")).getText();
								
						
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
							Thread.sleep(8000);
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
				
	
	public static void fdd_courtesycall_allvalues_verification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "****** FDD Details For All Values Verification in Courtesycall Screen started ********");
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
					driver.findElement(locator(prop.getProperty("courtesycall_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Courtesy call Link");
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
			//String loan_number="11318122";
					driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("searchajax")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					//driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					driver.findElement(By.xpath("//*[@id='SearchResults']/form/table/tbody/tr/td/table[3]/tbody/tr[3]/td[15]/input")).click();	
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(2000);
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String Date_Created = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[1]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Date Created is : "+Date_Created);
						Thread.sleep(200);
						
						String Inst_Num = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[2]")).getText();
						//if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[2]")).getText().isEmpty()){
						if (Inst_Num.isEmpty()){
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is Empty in FDD History ");
						}
						else{
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is : "+Inst_Num);
						}
						Thread.sleep(200);
						String Org_Duedate = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[3]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Orginal Duedate is : "+Org_Duedate);
						Thread.sleep(200);
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						Thread.sleep(200);
						String Amount = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[5]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Amount is : "+Amount);
						Thread.sleep(200);
						String Created_By = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[6]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Created By : "+Created_By);
						Thread.sleep(200);						
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> All FDD Details are Captured Successfully ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	
	public static void fdd_centralstore_collectionverification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "************ Central Store FDD Details Verification in Collection Screen started ******************");
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='940000']")));			       
					driver.findElement(locator(prop.getProperty("account_mgmt_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Account Mgmt Tab");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='940003']")));
					driver.findElement(By.xpath("//*[@id='940003']/a")).click();
					test.log(LogStatus.PASS, "Clicked on Collection Link");
					Thread.sleep(1000);
					//===========================================================================================
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product type is selected as :" +ProductType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
					test.log(LogStatus.PASS, "Loan Nbr selected from List");
					Thread.sleep(500);
			//String loan_number="11318226";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);			
					      
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					
					Thread.sleep(2000);
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();
                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Collection screen ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	public static void fdd_centralstore_historyscreen_verfication(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Details Verification From Central Store (2997) History Screen started ********");
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
				}
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
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						 Thread.sleep(2000);
							if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).isDisplayed()){
								String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).getText();
		                        
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Central store (2997) History Screen ");																											
								driver.close();	
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "FDD Details are not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
					
						 //break;														
									
					
					}				
	}
	
	public static void fdd_historyscreen_verfication(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Details Verification From History Screen started ********");
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
				}
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
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						 if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).isDisplayed()){
								String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).getText();
		                        
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in History screen ");																											
								driver.close();	
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "FDD Details are not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
						
					}				
	}
	
	public static void fdd_datefield_historyscreen_loanacctsection_verfication(String SSN, String AppURL) throws InterruptedException {
		
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Date Field Verification From History Screen Loan Account Section started ********");
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
				}
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
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
						
						 if (driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[1]/b")).isDisplayed()){								
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Future Deposite Date Field is available in History screen Loan Account Section ");																											
								driver.close();	
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "Future Deposite Date Field is not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
						
					}				
	}
	
	public static void fdd_date_historyscreen_loanacctsection_verfication(String SSN, String AppURL) throws InterruptedException {
		
			//try {
				int lastrow = TestData.getLastRow("New_Loan");
				String sheetName = "New_Loan";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
					//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
					//String PIN = TestData.getCellData(sheetName, "PIN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);

						Thread.sleep(3000);
						test.log(LogStatus.INFO, "********* FDD Date Verification From History Screen Loan Account Section started ********");
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
					}
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
						
					    for(String winHandle : driver.getWindowHandles()){
						    driver.switchTo().window(winHandle);
							}				    
						 driver.switchTo().defaultContent();
						    driver.switchTo().frame("mainFrame");
						    driver.switchTo().frame("main");
						   					    
						    Thread.sleep(5000);
						    
						   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
			
							 driver.findElement(By.name("transactionList")).sendKeys("History");
							 test.log(LogStatus.PASS, "Transaction Type is selected as History");
							 Thread.sleep(500);
							 driver.findElement(By.name("button")).click();
							 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
							 Thread.sleep(8000); 
							
							 if (driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[2]")).isDisplayed()){
									String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[3]/td[4]")).getText();
			                        
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Future Deposite Date date is : "+FDD_date);
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> Future Deposite Date is available in History screen Loan Account Section ");																											
									driver.close();	
									break;
									
								}
									
									else {
										test.log(LogStatus.FAIL, "Future Deposite Date is not displayed");
									    //Assert.assertTrue(false);
									      Assert.assertTrue(false);
									
									break;
									}
							
						}				
		}
	
	public static void fdd_date_empty_historyscreen_loanacctsection_verfication(String SSN, String AppURL) throws InterruptedException {
		
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Date is Empty Verification From History Screen Loan Account Section started ********");
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
				}
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
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 

						 if (driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td/span[1]/b")).isDisplayed()){
								String FDD_date =driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[3]/table/tbody/tr[5]/td")).getAttribute("value");
		                        
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Future Deposite Date date is : "+FDD_date);
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Future Deposite Date is Empty in History screen Loan Account Section ");																											
								driver.close();	
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "Future Deposite Date is not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
						
					}				
	}
	
	
	public static void fdd_historyscreen_all_value_verfication(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("New_Loan");
			String sheetName = "New_Loan";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Details All Value Verification From History Screen started ********");
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
				}
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
					
				    for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
						}				    
					 driver.switchTo().defaultContent();
					    driver.switchTo().frame("mainFrame");
					    driver.switchTo().frame("main");
					   					    
					    Thread.sleep(5000);
					    
					   driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					   test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
		
						 driver.findElement(By.name("transactionList")).sendKeys("History");
						 test.log(LogStatus.PASS, "Transaction Type is selected as History");
						 Thread.sleep(500);
						 driver.findElement(By.name("button")).click();
						 test.log(LogStatus.PASS, "Clicked on Go button under Transaction selection section");
						 Thread.sleep(8000); 
																													
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
						
								break;
								
							}
								
								else {
									test.log(LogStatus.FAIL, "FDD Details are not displayed");
								    //Assert.assertTrue(false);
								      Assert.assertTrue(false);
								
								break;
								}
						
					}				
	}
	
	public static void fdd_collectionverification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********* FDD Details Verification in Collection Screen started **********");
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
					driver.findElement(locator(prop.getProperty("collection_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Collection Link");
					Thread.sleep(1000);
					//===========================================================================================
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product type is selected as :" +ProductType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
					test.log(LogStatus.PASS, "Loan Nbr selected from List");
					Thread.sleep(500);
			//String loan_number="11318203";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);		
		
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(2000);
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();
                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Collection screen ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	
	public static void fdd_collection_allvalue_verification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "******* FDD Details For All Values Verification in Collection Screen started *******");
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
					driver.findElement(locator(prop.getProperty("collection_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Collection Link");
					Thread.sleep(1000);
					//===========================================================================================
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product type is selected as :" +ProductType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
					test.log(LogStatus.PASS, "Loan Nbr selected from List");
					Thread.sleep(500);
			//String loan_number="11318245";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);		
		
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(2000);
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String Date_Created = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[1]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Date Created is : "+Date_Created);
						Thread.sleep(200);
						
						String Inst_Num = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[2]")).getText();
						//if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[2]")).getText().isEmpty()){
						if (Inst_Num.isEmpty()){
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is Empty in FDD History ");
						}
						else{
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Installment Number is : "+Inst_Num);
						}
						Thread.sleep(200);
						String Org_Duedate = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[3]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Orginal Duedate is : "+Org_Duedate);
						Thread.sleep(200);
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						Thread.sleep(200);
						String Amount = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[5]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Amount is : "+Amount);
						Thread.sleep(200);
						String Created_By = driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[6]")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Created By : "+Created_By);
						Thread.sleep(200);						
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> All FDD Details are Captured Successfully ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	
	public static void fdd_tlpcollectionverification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "FDD Details Verification in Collection Screen started");
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");			 
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='901000']")));
					driver.findElement(locator(prop.getProperty("collection_link"))).click();
					test.log(LogStatus.PASS, "Clicked on Collection Link");
					Thread.sleep(1000);
					//===========================================================================================
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.installmentType")).sendKeys(ProductType);
					test.log(LogStatus.PASS, "Product type is selected as :" +ProductType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='queueTable']/tbody/tr[22]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Clicked on Customer search radiobutton");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='ach12']/option[6]")).click();
					test.log(LogStatus.PASS, "Loan Nbr selected from List");
					Thread.sleep(500);
			//String loan_number="11318203";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);		
		
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[20]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(2000);

					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();
                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Collection screen ");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	
	public static void centralstore_fdd_verification(String SSN, String AppURL) throws InterruptedException {
		//try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "************ Central Store FDD Details Verification in Courtesycall Screen started ******************");
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
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).isDisplayed()){
						String FDD_date =driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[2]/td[4]")).getText();
                        
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD date is : "+FDD_date);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Details are available in Courtesy call screen Of Central Store");																											
						driver.close();	
						break;
						
					}
						
						else {
							test.log(LogStatus.FAIL, "FDD Details are not displayed");
						    //Assert.assertTrue(false);
						      Assert.assertTrue(false);
						
						break;
						}
					}
					//break;
				}

			}
	


}
	
	
	


