package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class QCCSR_WriteOff extends QCStore {
	
	
	public static void ilpwriteoff(String SSN, String AppURL) throws Exception{
		
			try {
				
				int lastrow = TestData.getLastRow("Writeoff");
				String sheetName = "Writeoff";

				for (int row = 2; row <= lastrow; row++) {

					
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					
					
					if (SSN.equals(RegSSN)) {
						String UserName = TestData.getCellData(sheetName, "UserName", row);
						String Password = TestData.getCellData(sheetName, "Password", row);
						String PIN = TestData.getCellData(sheetName, "PIN", row);
						// System.out.println(Password);
						encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
						String ProductID = TestData.getCellData(sheetName, "ProductID", row);
						String ProductType = TestData.getCellData(sheetName, "ProductType", row);
						String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
						String Comments = TestData.getCellData(sheetName, "Comments", row);

						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						String SSN1 = SSN.substring(0, 3);
						String SSN2 = SSN.substring(3, 5);
						String SSN3 = SSN.substring(5, 9);

						Thread.sleep(4000);
					
						test.log(LogStatus.INFO, "***** WriteOff process Started ******");
						
						Thread.sleep(3000);
						
						driver.switchTo().frame("topFrame");	        
						wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
						driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
						Thread.sleep(2000);				
						test.log(LogStatus.PASS, "Clicked on Borrower");

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
				//String loan_number="11318468";
						driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
						test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
						Thread.sleep(500);
						driver.findElement(By.name("Button3")).click();
						test.log(LogStatus.PASS, "Clicked on Search button");
						Thread.sleep(8000);				
						
						driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
						
						//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(8000);	
						
						driver.findElement(By.xpath("//input[@value='WriteOff' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on WriteOff tab");
						Thread.sleep(10000);
						
						encryption_transaction_nbr = driver.findElement(By.name("customerBean.randomNbr1")).getAttribute("value");				
						test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
						
						//Admin Login For Getting Encryption Key
						
						
						 AdminLoginForEncryption.writeoffEncryption(driver,SSN, AppURL);
						 Thread.sleep(5000);
						
						 driver.switchTo().defaultContent();
						 driver.switchTo().frame("mainFrame");
						 driver.switchTo().frame("main");
						 Thread.sleep(5000);
						 driver.findElement(By.name("customerBean.eanNbr1")).sendKeys(Eankey);
						 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						 driver.findElement(By.name("SubButton")).click();
						 test.log(LogStatus.PASS, "Clicked on Submit Button");
						 Thread.sleep(5000);
						 driver.findElement(By.name("checkok")).click();
						 test.log(LogStatus.PASS, "Clicked on Ok");
						
						 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WriteOff Completed Successfully ");
						 test.log(LogStatus.INFO, "******************************************************** ");
						 driver.close();
						 
		// ------------------------------------
						
						 break;
					}
								}	
						
						
					}

									catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
										String screenshotPath = getScreenhot(driver, "RQC_WriteOffRecovery_Txn");
										test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
										test.log(LogStatus.FAIL,"Writeoff failed");
										Thread.sleep(1000);
										driver.close();
										Thread.sleep(3000);

									}

						}
	
	public static void tlpwriteoff(String SSN, String AppURL) throws Exception{
		
		try {
			
			int lastrow = TestData.getLastRow("Writeoff");
			String sheetName = "Writeoff";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				
				
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					// System.out.println(Password);
					encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);

					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
				
					test.log(LogStatus.INFO, "***** WriteOff process Started ******");
					
					Thread.sleep(3000);
					
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");

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
			//String loan_number="11318006";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);				
					
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[20]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(8000);	
					
					driver.findElement(By.xpath("//input[@value='WriteOff' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on WriteOff tab");
					Thread.sleep(10000);
					
					encryption_transaction_nbr = driver.findElement(By.name("customerBean.randomNbr1")).getAttribute("value");				
					test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
					
					//Admin Login For Getting Encryption Key
					
					
					 AdminLoginForEncryption.writeoffEncryption(driver,SSN, AppURL);
					 Thread.sleep(5000);
					
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 Thread.sleep(5000);
					 driver.findElement(By.name("customerBean.eanNbr1")).sendKeys(Eankey);
					 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
					 driver.findElement(By.name("SubButton")).click();
					 test.log(LogStatus.PASS, "Clicked on Submit Button");
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkok")).click();
					 test.log(LogStatus.PASS, "Clicked on Ok");
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WriteOff Completed Successfully ");
					 test.log(LogStatus.INFO, "******************************************************** ");
					 driver.close();
					 
	// ------------------------------------
					
					 break;
				}
							}	
					
					
				}

								catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
									String screenshotPath = getScreenhot(driver, "RQC_WriteOffRecovery_Txn");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
									test.log(LogStatus.FAIL,"Writeoff failed");
									Thread.sleep(1000);
									driver.close();
									Thread.sleep(3000);

								}

					}
	
public static void locwriteoff(String SSN, String AppURL) throws Exception{
		
		try {
			
			int lastrow = TestData.getLastRow("Writeoff");
			String sheetName = "Writeoff";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				
				
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					// System.out.println(Password);
					encryption_store_no = TestData.getCellData(sheetName, "encryption_store_no", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String ReasonsforTransfer = TestData.getCellData(sheetName, "ReasonsforTransfer", row);
					String Comments = TestData.getCellData(sheetName, "Comments", row);

					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
				
					test.log(LogStatus.INFO, "***** WriteOff process Started ******");
					
					Thread.sleep(3000);
					
					driver.switchTo().frame("topFrame");	        
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='900000']")));			       
					driver.findElement(locator(prop.getProperty("borrower_tab"))).click();	
					Thread.sleep(2000);				
					test.log(LogStatus.PASS, "Clicked on Borrower");

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
			//String loan_number="11318015";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);				
					
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(8000);	
					
					driver.findElement(By.xpath("//input[@value='WriteOff' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on WriteOff tab");
					Thread.sleep(10000);
					
					encryption_transaction_nbr = driver.findElement(By.name("customerBean.randomNbr1")).getAttribute("value");				
					test.log(LogStatus.PASS, "Trans Number is" + encryption_transaction_nbr);
					
					//Admin Login For Getting Encryption Key
					
					
					 AdminLoginForEncryption.writeoffEncryption(driver,SSN, AppURL);
					 Thread.sleep(5000);
					
					 driver.switchTo().defaultContent();
					 driver.switchTo().frame("mainFrame");
					 driver.switchTo().frame("main");
					 Thread.sleep(5000);
					 driver.findElement(By.name("customerBean.eanNbr1")).sendKeys(Eankey);
					 test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
					 driver.findElement(By.name("SubButton")).click();
					 test.log(LogStatus.PASS, "Clicked on Submit Button");
					 Thread.sleep(5000);
					 driver.findElement(By.name("checkok")).click();
					 test.log(LogStatus.PASS, "Clicked on Ok");
					
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> WriteOff Completed Successfully ");
					 test.log(LogStatus.INFO, "******************************************************** ");
					 driver.close();
					 
	// ------------------------------------
					
					 break;
				}
							}	
					
					
				}

								catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
									String screenshotPath = getScreenhot(driver, "RQC_WriteOffRecovery_Txn");
									test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
									test.log(LogStatus.FAIL,"Writeoff failed");
									Thread.sleep(1000);
									driver.close();
									Thread.sleep(3000);

								}

					}
	
	
					}
						 
