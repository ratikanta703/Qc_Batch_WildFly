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

public class QC_FDD extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;
	
	public static void pdl_future_deposit_date(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String FDD_Date = TestData.getCellData(sheetName, "FDD_Date", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********** Future Deposit Date  Details Verification started ************");
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
			//String loan_number="11318137";
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
					
					
					//if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){
						if (driver.findElement(By.name("FUTDEPDATE")).isDisplayed()){
							test.log(LogStatus.PASS, "Future Deposit Button Displayed");
							Thread.sleep(1000);
						
							//driver.findElement(By.name("FUTDEPDATE")).click();
							driver.findElement(By.xpath("//input[@value='Future Deposit Date' and @name='FUTDEPDATE']")).click();
							test.log(LogStatus.PASS, "Clicked on Future Deposit Date Button");
							Thread.sleep(500);
							String mainwindow=driver.getWindowHandle();
							for(String winHandle : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle))
								{
							    driver.switchTo().window(winHandle);							    					  
								Thread.sleep(1000);
								
						//****************  Capturing Due Date *****************
								
								NextDueDate=driver.findElement(By.xpath("//*[@id='tblGrid']/tbody/tr[3]/td[9]")).getText();
								test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
								
								int IAgeStore=Integer.parseInt(FDD_Date);
						    	
								 DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
									Date DDueDateminus1 = df.parse(NextDueDate);
									Calendar cal = Calendar.getInstance();
									 cal.setTime(DDueDateminus1);
									 cal.add(Calendar.DATE, IAgeStore);
									 Date DDueDate1= cal.getTime();
									 NextDueDate =df.format(DDueDate1);
									 System.out.println(NextDueDate);
								
								String Due_Date[] =NextDueDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("dueDate1-1")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("dueDate2-1")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("dueDate3-1")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								Thread.sleep(500);
								driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on Submit Button");
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Completed Successfully ");
								Thread.sleep(3000);
								
						        driver.close();
						        driver.switchTo().window(mainwindow);
						        for(String winHandle1 : driver.getWindowHandles()){
								    driver.switchTo().window(winHandle1);
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
						else {
							test.log(LogStatus.FAIL, "FDD Is Failed");
						}
				}
				break;
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
	
	public static void pdl_cancel_future_deposit_date(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String FDD_Date = TestData.getCellData(sheetName, "FDD_Date", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********** Cancelling Of Future Deposit Date started ************");
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
			//String loan_number="11318328";
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
					
					
					//if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){
						if (driver.findElement(By.name("FUTDEPDATE")).isDisplayed()){
							test.log(LogStatus.PASS, "Future Deposit Button Displayed");
							Thread.sleep(1000);
						
							//driver.findElement(By.name("FUTDEPDATE")).click();
							driver.findElement(By.xpath("//input[@value='Future Deposit Date' and @name='FUTDEPDATE']")).click();
							test.log(LogStatus.PASS, "Clicked on Future Deposit Date Button");
							Thread.sleep(500);
							String mainwindow=driver.getWindowHandle();
							for(String winHandle : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle))
								{
							    driver.switchTo().window(winHandle);							    					  
								Thread.sleep(1000);
								
						//****************  Cancelling FDD *****************

								Thread.sleep(500);
								driver.findElement(By.xpath("//input[@value='Cancel Future Deposit Date' and @type='button']")).click();
								test.log(LogStatus.PASS, "Clicked on Cancel Future Deposit Date Button");
								try { 
									Alert alert = driver.switchTo().alert();
									alert.accept();
									Thread.sleep(500);
									test.log(LogStatus.PASS, "Alert Accepted");																						
								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
								Thread.sleep(500);
								if(driver.findElement(By.xpath("/html/body/form[3]/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td")).getText().contains("Future Deposit Date Cancelled Successfully")){
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Cancelled Successfully ");
								}
								else
								{
									test.log(LogStatus.FAIL, "FDD Cancellation Failed");}
								
								Thread.sleep(3000);
								
						        driver.close();
						        driver.switchTo().window(mainwindow);
						        for(String winHandle1 : driver.getWindowHandles()){
								    driver.switchTo().window(winHandle1);
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
						else {
							test.log(LogStatus.FAIL, "FDD Is Failed");
						}
				}
				break;
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
	
	public static void ilp_future_deposit_date(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String FDD_Date = TestData.getCellData(sheetName, "FDD_Date", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********** Future Deposit Date  started ************");
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
			//String loan_number="11318195";
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
					
					
					//if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){
						if (driver.findElement(By.name("FutDepDate")).isDisplayed()){
							test.log(LogStatus.PASS, "Future Deposit Button Displayed");
							Thread.sleep(1000);
						
							//driver.findElement(By.name("FUTDEPDATE")).click();
							driver.findElement(By.xpath("//input[@value='Future Deposit Date' and @name='FutDepDate']")).click();
							test.log(LogStatus.PASS, "Clicked on Future Deposit Date Button");
							Thread.sleep(500);
							String mainwindow=driver.getWindowHandle();
							for(String winHandle : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle))
								{
							    driver.switchTo().window(winHandle);							    					  
								Thread.sleep(1000);
								
						//****************  Capturing Due Date *****************
								
								NextDueDate=driver.findElement(By.xpath("//*[@id='tblGrid']/tbody/tr[3]/td[9]")).getText();
								test.log(LogStatus.PASS, "Next due date is "+NextDueDate);
								
								int IAgeStore=Integer.parseInt(FDD_Date);
						    	
								 DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
									Date DDueDateminus1 = df.parse(NextDueDate);
									Calendar cal = Calendar.getInstance();
									 cal.setTime(DDueDateminus1);
									 cal.add(Calendar.DATE, IAgeStore);
									 Date DDueDate1= cal.getTime();
									 NextDueDate =df.format(DDueDate1);
									 System.out.println(NextDueDate);
								
								String Due_Date[] =NextDueDate.split("/");
						        String Due_Date1 = Due_Date[0];
						        String Due_Date2 = Due_Date[1];
						        String Due_Date3 = Due_Date[2];
						        driver.findElement(By.name("dueDate1-1")).sendKeys(Due_Date1);
						        test.log(LogStatus.PASS, "Month is entered: "+Due_Date1);
								driver.findElement(By.name("dueDate2-1")).sendKeys(Due_Date2);
								test.log(LogStatus.PASS, "Date is entered: "+Due_Date2);
								driver.findElement(By.name("dueDate3-1")).sendKeys(Due_Date3);
								test.log(LogStatus.PASS, "Year is entered: "+Due_Date3);
								Thread.sleep(500);
								driver.findElement(By.name("button")).click();
								test.log(LogStatus.PASS, "Clicked on Submit Button");
								test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Completed Successfully ");
								Thread.sleep(3000);
								
						        driver.close();
						        driver.switchTo().window(mainwindow);
						        for(String winHandle1 : driver.getWindowHandles()){
								    driver.switchTo().window(winHandle1);
									}				    
							   driver.switchTo().defaultContent();
							   driver.switchTo().frame("topFrame");
							   Thread.sleep(5000);		
					           driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
					           test.log(LogStatus.PASS, "Clicked On logout Button");
					           if(driver.getTitle().contains("Login")){
					    	   test.log(LogStatus.PASS, "Logout is Successfully"); 
					    	   test.log(LogStatus.INFO,"loggged out from the CSR Application");
					    	   Thread.sleep(2000);
					    	   test.log(LogStatus.INFO, "******************************************************** ");
					    	   Thread.sleep(3000);
					    	   driver.close();
					    	   //driver.quit();
					           Thread.sleep(3000);
					     }
						        
								break;
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
				
	
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint1 Transaction");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void ilp_cancel_future_deposit_date(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("FDD");
			String sheetName = "FDD";

			for (int row = 2; row <= lastrow; row++) {
				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String FDD_Date = TestData.getCellData(sheetName, "FDD_Date", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "********** Cancellation Of Future Deposit Date  started ************");
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
			//String loan_number="11318195";
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
					
					
					//if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){
						if (driver.findElement(By.name("FutDepDate")).isDisplayed()){
							test.log(LogStatus.PASS, "Future Deposit Button Displayed");
							Thread.sleep(1000);
						
							//driver.findElement(By.name("FUTDEPDATE")).click();
							driver.findElement(By.xpath("//input[@value='Future Deposit Date' and @name='FutDepDate']")).click();
							test.log(LogStatus.PASS, "Clicked on Future Deposit Date Button");
							Thread.sleep(500);
							String mainwindow=driver.getWindowHandle();
							for(String winHandle : driver.getWindowHandles()){
								if(!mainwindow.equalsIgnoreCase(winHandle))
								{
							    driver.switchTo().window(winHandle);							    					  
								Thread.sleep(1000);
								
								//****************  Cancelling FDD *****************

								Thread.sleep(500);
								driver.findElement(By.xpath("//input[@value='Cancel Future Deposit Date' and @type='button']")).click();
								test.log(LogStatus.PASS, "Clicked on Cancel Future Deposit Date Button");
								try { 
									Alert alert = driver.switchTo().alert();
									alert.accept();
									Thread.sleep(500);
									test.log(LogStatus.PASS, "Alert Accepted");																						
								}
								catch (NoAlertPresentException e) {
									//do what you normally would if you didn't have the alert.
								}
								Thread.sleep(500);
								if(driver.findElement(By.xpath("/html/body/form[3]/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td")).getText().contains("Future Deposit Date Cancelled Successfully")){
									test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Cancelled Successfully ");
								}
								else
								{
									test.log(LogStatus.FAIL, "FDD Cancellation Failed");}
								
								Thread.sleep(3000);
								
						        driver.close();
						        driver.switchTo().window(mainwindow);
						        for(String winHandle1 : driver.getWindowHandles()){
								    driver.switchTo().window(winHandle1);
									}				    
							   driver.switchTo().defaultContent();
							   driver.switchTo().frame("topFrame");
							   Thread.sleep(5000);		
					           driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
					           test.log(LogStatus.PASS, "Clicked On logout Button");
					           if(driver.getTitle().contains("Login")){
					    	   test.log(LogStatus.PASS, "Logout is Successfully"); 
					    	   test.log(LogStatus.INFO,"loggged out from the CSR Application");
					    	   Thread.sleep(2000);
					    	   test.log(LogStatus.INFO, "******************************************************** ");
					    	   Thread.sleep(3000);
					    	   driver.close();
					    	   //driver.quit();
					           Thread.sleep(3000);
					     }
						        
								break;
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
				
	
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint1 Transaction");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	
}
	








