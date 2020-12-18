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

public class QCCSRStatusValidation extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void loanstatus(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("Validation");
			String sheetName = "Validation";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String New_Loan_Status = TestData.getCellData(sheetName, "New_Loan_Status", row);
				String Closed_Loan_Status = TestData.getCellData(sheetName, "Closed_Loan_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Loan Status Verification has Started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
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
					Thread.sleep(4000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();


						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
         //========================= Loan Status Verification Started==============
						
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='showMore-1']")).click();
						
						test.log(LogStatus.PASS, "Clicked on Show More Link");
						Thread.sleep(500);
						                                                        
						String ClosedLoanStatus = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[5]")).getText();
						String NewLoanStatus = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[9]/td[5]")).getText();
						                                                   
						Thread.sleep(5000);
						if (Closed_Loan_Status.trim().equalsIgnoreCase(ClosedLoanStatus.trim())) {
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Closed Loan Status is : "+ ClosedLoanStatus);
							
							
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Open");
						
						if (New_Loan_Status.trim().equalsIgnoreCase(NewLoanStatus.trim())) {
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Status is : "+ NewLoanStatus);
							test.log(LogStatus.PASS, "Both condition Satishfied");
							break;
							//driver.close();
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Void ");
						    test.log(LogStatus.FAIL, "Condition doesn't satishfied ");
						break;
					}
				}

			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, "Default Payment is failed");

		}

	}
	public static void twopdlloanstatus(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("Validation");
			String sheetName = "Validation";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TxnType = TestData.getCellData(sheetName, "TxnType", row);
				String New_Loan_Status = TestData.getCellData(sheetName, "New_Loan_Status", row);
				String Closed_Loan_Status = TestData.getCellData(sheetName, "Closed_Loan_Status", row);
				String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				String PIN = TestData.getCellData(sheetName, "PIN", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName, "StateID", row);

					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Loan Status Verification has Started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
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
					Thread.sleep(4000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();


						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
         //========================= Loan Status Verification Started==============
						
						Thread.sleep(500);
						driver.findElement(By.xpath("//*[@id='showMore-1']")).click();
						
						test.log(LogStatus.PASS, "Clicked on Show More Link");
						Thread.sleep(500);
						
						String ClosedLoanStatus = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[5]")).getText();
						String NewLoanStatus = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[10]/td[5]")).getText();
						
						Thread.sleep(5000);
						if (Closed_Loan_Status.trim().equalsIgnoreCase(ClosedLoanStatus.trim())) {
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Closed Loan Status is : "+ ClosedLoanStatus);
							
							
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Open");
						
						if (New_Loan_Status.trim().equalsIgnoreCase(NewLoanStatus.trim())) {
							
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Loan Status is : "+ NewLoanStatus);
							test.log(LogStatus.PASS, "Both condition Satisfied");
							break;
							//driver.close();
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Void ");
						break;
					}
				}

			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//test.log(LogStatus.FAIL, "Default Payment is failed");

		}

	}	
	
}
