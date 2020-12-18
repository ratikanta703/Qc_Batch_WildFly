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

public class QC_Sprint_Adjust_Interestbutton_Verification extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void adjust_interest_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Adjust Interest Button Verification started");
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
					//String loan_number="11317815";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Button Is Available ");
					}
					else {
						test.log(LogStatus.FAIL, "Adjust Interest Button Is Not Available");
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_151_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void adjust_interest_Void_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "****** Adjust Interest Void Button Verification started ******");
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
			//String loan_number="11456387";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();

					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

						test.log(LogStatus.FAIL, "Adjust Interest Void Button Is  Enabled");
						
					}
					else {
					
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Disabled ");
						break;
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "Adjust Interest Void Transaction");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "Adjust Interest Void Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void Defaultilp_adjust_interest_Void_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Void Button Verification started");
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
			//String loan_number="11317951";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					
					if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Enabled ");
						
					}
					else {
					
						test.log(LogStatus.PASS, "Adjust Interest Void Button Is Disabled");
						break;
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_152_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void Defaulttlp_adjust_interest_Void_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Void Button Verification started");
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
			//String loan_number="11317947";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[20]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					
					if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Enabled ");
						
					}
					else {
					
						test.log(LogStatus.PASS, "Adjust Interest Void Button Is Disabled");
						break;
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_152_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void tlp_adjust_interest_Void_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);

				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "***** Void Button Verification started *****");
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
			//String loan_number="11456363";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[20]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					
					if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

						test.log(LogStatus.FAIL, "Adjust Interest Void Button Is  Enabled");
						
					}
					else {
					
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Disabled ");
						break;
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_152_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}

	
	public static void adjustinterest_amount_verification(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String Reason = TestData.getCellData(sheetName, "Reason", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Adjust Interest Button Verification started");
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
			//String loan_number="11317854";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Button Is Available ");
						driver.findElement(By.xpath("//*[@id='adjustInterest']")).click();						 
						test.log(LogStatus.PASS, "Clicked on Adjust Interest Button");
						Thread.sleep(2000);
						//=================================================================================================
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();																				
						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(2000);
						String Loanamt=driver.findElement(By.xpath("/html/body/form[1]/table[1]/tbody/tr[5]/td/table/tbody/tr[4]/td[2]")).getText();
						test.log(LogStatus.PASS, "Loan amount is :" +Loanamt);
						Thread.sleep(500);
						//=======================
						String Fee1 = Loanamt;
						//string to double 
						double d = Double.parseDouble(Fee1);
						double dd=d-100;
						//double to string 	       
						Updated_Adjusted_Amount=String.valueOf(dd);  
						System.out.println(Updated_Adjusted_Amount); 
						//========================
						driver.findElement(By.name("requestBean.adjustedIntAmt")).clear();
						driver.findElement(By.name("requestBean.adjustedIntAmt")).sendKeys(Updated_Adjusted_Amount);
						test.log(LogStatus.PASS, "Adjust Interest amount entered as :" +Updated_Adjusted_Amount);
						Thread.sleep(200);

						driver.findElement(By.name("requestBean.reasons")).sendKeys(Reason);
						test.log(LogStatus.PASS, "Reason mentioned as :" +Reason);
						Thread.sleep(200);
						adjint_transnum=driver.findElement(By.name("requestBean.randomNbr")).getAttribute("value");
						test.log(LogStatus.PASS, "Transaction Number is :" +adjint_transnum);
						Thread.sleep(500);

						//========= Going to Admin Portal to get Encryption Key ============

						AdminLoginForEncryption.adjust_interest_Encryption(driver,SSN, AppURL);

						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(5000);
						driver.findElement(By.name("requestBean.eanNbr")).sendKeys(Eankey);
						test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						Thread.sleep(500);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked On Finish Button");
						// Thread.sleep(500);
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully");
						Thread.sleep(1000);
						if (driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).isDisplayed()){
							String adjint_amt=driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).getText();
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully with amount :"+adjint_amt); 
							break;
						}
						//break;
						else {
							test.log(LogStatus.FAIL, "Adjust Interest Amount is not Displayed");
						}

						//=================================================================================================
					}
					else {
						test.log(LogStatus.FAIL, "Adjust Interest Button Is Not Available");
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_151_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void tlp_adjustinterest_amount_increased(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String Reason = TestData.getCellData(sheetName, "Reason", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Adjust Interest Button and Adjust Interest Void Verification started");
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
			//String loan_number="11317920";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);			
					
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[20]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Button Is Available ");
						driver.findElement(By.xpath("//*[@id='adjustInterest']")).click();						 
						test.log(LogStatus.PASS, "Clicked on Adjust Interest Button");
						Thread.sleep(2000);
						//=================================================================================================
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();																				
						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(2000);
						String AdjustInterest=driver.findElement(By.xpath("/html/body/form[1]/table[1]/tbody/tr[12]/td/table/tbody/tr/td/input")).getAttribute("value");
						test.log(LogStatus.PASS, "Adjust Interest amount is :" +AdjustInterest);
						Thread.sleep(500);
						//=======================
						String Fee1 = AdjustInterest;
						//string to double 
						double d = Double.parseDouble(Fee1);
						double dd=d+50;
						//double to string 	       
						Updated_Adjusted_Amount=String.valueOf(dd);  
						System.out.println(Updated_Adjusted_Amount); 
						//========================
						driver.findElement(By.name("requestBean.adjustedIntAmt")).clear();
						driver.findElement(By.name("requestBean.adjustedIntAmt")).sendKeys(Updated_Adjusted_Amount);
						test.log(LogStatus.PASS, "Adjust Interest amount entered as :" +Updated_Adjusted_Amount);
						Thread.sleep(200);

						driver.findElement(By.name("requestBean.reasons")).sendKeys(Reason);
						test.log(LogStatus.PASS, "Reason mentioned as :" +Reason);
						Thread.sleep(200);
						adjint_transnum=driver.findElement(By.name("requestBean.randomNbr")).getAttribute("value");
						test.log(LogStatus.PASS, "Transaction Number is :" +adjint_transnum);
						Thread.sleep(500);

						//========= Going to Admin Portal to get Encryption Key ============

						AdminLoginForEncryption.adjust_interest_Encryption(driver,SSN, AppURL);

						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(5000);
						driver.findElement(By.name("requestBean.eanNbr")).sendKeys(Eankey);
						test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						Thread.sleep(500);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked On Finish Button");
						// Thread.sleep(500);
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully");
						Thread.sleep(1000);
						if (driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).isDisplayed()){
							String adjincrease_amt=driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).getText();
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully with Increased amount :"+adjincrease_amt); 
							Thread.sleep(1000);
							//========= Go Back To Verify Adjust Interest Void Is Enable Or Not ========
							
							
							driver.findElement(By.name("button1")).click();
							test.log(LogStatus.PASS, "Clicked On Back Button");
							Thread.sleep(5000);
							
								if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Available ");
								break;
							}
							else {
								test.log(LogStatus.FAIL, "Adjust Interest Void Button Is Not Available");
							}
							
							
							
							//break;
						}
						//break;
						else {
							test.log(LogStatus.FAIL, "Adjust Interest Amount is not Displayed");
						}

						//=================================================================================================
					}
					else {
						test.log(LogStatus.FAIL, "Adjust Interest Button Is Not Available");
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_151_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	
	public static void adjustinterest_amount_increased(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String Reason = TestData.getCellData(sheetName, "Reason", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Adjust Interest Button and Adjust Interest Void Verification started");
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
			//String loan_number="11318059";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Button Is Available ");
						driver.findElement(By.xpath("//*[@id='adjustInterest']")).click();						 
						test.log(LogStatus.PASS, "Clicked on Adjust Interest Button");
						Thread.sleep(2000);
						//=================================================================================================
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();																				
						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(2000);
						String AdjustInterest=driver.findElement(By.xpath("/html/body/form[1]/table[1]/tbody/tr[12]/td/table/tbody/tr/td/input")).getAttribute("value");
						test.log(LogStatus.PASS, "Adjust Interest amount is :" +AdjustInterest);
						Thread.sleep(500);
						//=======================
						String Fee1 = AdjustInterest;
						//string to double 
						double d = Double.parseDouble(Fee1);
						double dd=d+50;
						//double to string 	       
						Updated_Adjusted_Amount=String.valueOf(dd);  
						System.out.println(Updated_Adjusted_Amount); 
						//========================
						driver.findElement(By.name("requestBean.adjustedIntAmt")).clear();
						driver.findElement(By.name("requestBean.adjustedIntAmt")).sendKeys(Updated_Adjusted_Amount);
						test.log(LogStatus.PASS, "Adjust Interest amount entered as :" +Updated_Adjusted_Amount);
						Thread.sleep(200);

						driver.findElement(By.name("requestBean.reasons")).sendKeys(Reason);
						test.log(LogStatus.PASS, "Reason mentioned as :" +Reason);
						Thread.sleep(200);
						adjint_transnum=driver.findElement(By.name("requestBean.randomNbr")).getAttribute("value");
						test.log(LogStatus.PASS, "Transaction Number is :" +adjint_transnum);
						Thread.sleep(500);

						//========= Going to Admin Portal to get Encryption Key ============
						test.log(LogStatus.INFO, "************* Login Into to Admin Portal To Get Encryption Key For Adjustinterest ***********");
						AdminLoginForEncryption.adjust_interest_Encryption(driver,SSN, AppURL);

						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(5000);
						driver.findElement(By.name("requestBean.eanNbr")).sendKeys(Eankey);
						test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						Thread.sleep(500);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked On Finish Button");
						// Thread.sleep(500);
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully");
						Thread.sleep(1000);
						if (driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).isDisplayed()){
							String adjincrease_amt=driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).getText();
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully with Increased amount :"+adjincrease_amt); 
							Thread.sleep(1000);
							//========= Go Back To Verify Adjust Interest Void Is Enable Or Not ========
							
							
							driver.findElement(By.name("button1")).click();
							test.log(LogStatus.PASS, "Clicked On Back Button");
							Thread.sleep(5000);
							
								if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Available ");
								break;
							}
							else {
								test.log(LogStatus.FAIL, "Adjust Interest Void Button Is Not Available");
							}
							
							
							
							//break;
						}
						//break;
						else {
							test.log(LogStatus.FAIL, "Adjust Interest Amount is not Displayed");
						}

						//=================================================================================================
					}
					else {
						test.log(LogStatus.FAIL, "Adjust Interest Button Is Not Available");
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_151_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
	public static void adjustinterest_amount_decreased(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("adjust_interest");
			String sheetName = "adjust_interest";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String ProductType = TestData.getCellData(sheetName, "ProductType", row);
				String Reason = TestData.getCellData(sheetName, "Reason", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Adjust Interest Button Verification started");
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
			//String loan_number="11317864";
					driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
					test.log(LogStatus.PASS, "Loan Nbr entered is :" + loan_number);
					Thread.sleep(500);
					driver.findElement(By.name("Button3")).click();
					test.log(LogStatus.PASS, "Clicked on Search button");
					Thread.sleep(8000);									
					driver.findElement(By.xpath("//*[@id='"+loan_number+"']/td[19]/input[4]")).click();
					//driver.findElement(By.xpath("//input[@value='Go' and @name='myButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					//Thread.sleep(8000);
					//if (element.isDisplayed()) {
					if (driver.findElement(By.xpath("//*[@id='adjustInterest']")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Button Is Available ");
						driver.findElement(By.xpath("//*[@id='adjustInterest']")).click();						 
						test.log(LogStatus.PASS, "Clicked on Adjust Interest Button");
						Thread.sleep(2000);
						//=================================================================================================
						try { 
							Alert alert = driver.switchTo().alert();
							alert.accept();																				
						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
						Thread.sleep(2000);
						String AdjustInterestDue=driver.findElement(By.xpath("/html/body/form[1]/table[1]/tbody/tr[5]/td/table/tbody/tr[4]/td[4]")).getText();
						test.log(LogStatus.PASS, "Adjust Interest amount is :" +AdjustInterestDue);
						Thread.sleep(500);
						//=======================
						String Fee1 = AdjustInterestDue;
						//string to double 
						double d = Double.parseDouble(Fee1);
						double dd=d-20;
						//double to string 	       
						Updated_Adjusted_Amount=String.valueOf(dd);  
						test.log(LogStatus.PASS, "Updated Adjusted Amount Is:" +Updated_Adjusted_Amount);
						System.out.println(Updated_Adjusted_Amount); 
						//========================
						driver.findElement(By.name("requestBean.adjustedIntAmt")).clear();
						driver.findElement(By.name("requestBean.adjustedIntAmt")).sendKeys(Updated_Adjusted_Amount);
						test.log(LogStatus.PASS, "Adjust Interest amount entered as :" +Updated_Adjusted_Amount);
						Thread.sleep(200);

						driver.findElement(By.name("requestBean.reasons")).sendKeys(Reason);
						test.log(LogStatus.PASS, "Reason mentioned as :" +Reason);
						Thread.sleep(200);
						adjint_transnum=driver.findElement(By.name("requestBean.randomNbr")).getAttribute("value");
						test.log(LogStatus.PASS, "Transaction Number is :" +adjint_transnum);
						Thread.sleep(500);

						//========= Going to Admin Portal to get Encryption Key ============

						AdminLoginForEncryption.adjust_interest_Encryption(driver,SSN, AppURL);

						Thread.sleep(2000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						Thread.sleep(5000);
						driver.findElement(By.name("requestBean.eanNbr")).sendKeys(Eankey);
						test.log(LogStatus.PASS, "Encryption number enter is :" +Eankey);
						Thread.sleep(500);
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked On Finish Button");
						// Thread.sleep(500);
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully");
						Thread.sleep(1000);
						if (driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).isDisplayed()){
							String adjincrease_amt=driver.findElement(By.xpath("/html/body/form[1]/table[2]/tbody/tr[2]/td[3]/font")).getText();
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Completed Successfully with Decreased amount :"+adjincrease_amt); 
							Thread.sleep(1000);
					
				//========= Go Back To Verify Adjust Interest Void Is Enable Or Not ========
							
							
							driver.findElement(By.name("button1")).click();
							test.log(LogStatus.PASS, "Clicked On Back Button");
							Thread.sleep(5000);
							
								if (driver.findElement(By.xpath("//*[@id='voidadjustInterest']")).isEnabled()){

								test.log(LogStatus.PASS, "<FONT color=green style=Arial> Adjust Interest Void Button Is Available ");
								break;
							}
							else {
								test.log(LogStatus.FAIL, "Adjust Interest Void Button Is Not Available");
							}

						}
					
						else {
							test.log(LogStatus.FAIL, "Adjust Interest Amount is not Displayed");
						}

						//=================================================================================================
					}
					else {
						test.log(LogStatus.FAIL, "Adjust Interest Button Is Not Available");
					}

				}

			}		
		}
		catch(Exception e){

			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_Sprint1_B20_151_1 Transaction Failed ");
			//test.log(LogStatus.FAIL, "Refinance from CSR is failed");
			Assert.assertTrue(false);

		}


	}
}