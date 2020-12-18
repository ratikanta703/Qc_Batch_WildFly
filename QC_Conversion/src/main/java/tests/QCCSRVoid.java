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

public class QCCSRVoid extends QCStore {
	public static void cvoid(String SSN, String AppURL) {
	
		try {
			
			int lastrow = TestData.getLastRow("Void");
			String sheetName = "Void";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String No_Of_Loan = TestData.getCellData(sheetName, "No_Of_Loan", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);

					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "Void Started");
					test.log(LogStatus.INFO, "******************************************************** ");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					Thread.sleep(4000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					Thread.sleep(4000);

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					

					if (ProductID.equals("PDL")) {
						
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						Thread.sleep(4000);
					}
					
					
                    if (ProductID.equals("ILP")) {
                    	
                    	                               
						//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[13]/input")).click();
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[13]/input[1]")).click();
						                            
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						Thread.sleep(4000);
                    }
                    if (ProductID.equals("ILP-2PDL")) {
                    	
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[11]/td[13]/input[1]")).click();						
						                             
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						Thread.sleep(4000);
                    }
					if (ProductID.equals("TLP")) {
						driver.findElement(By
								.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input"))
								.click();
					}

					
					if (ProductID.equals("LOC")) {
						
						driver.findElement(By
								.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]"))
								.click();
					}

					
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(10000);
					driver.findElement(By.name("tenderType")).sendKeys(TenderType);
					test.log(LogStatus.PASS, "Tender Type is :" + TenderType);
					Thread.sleep(500);
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin entered is :" +PIN);
					Thread.sleep(600);
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Void Conversion Button");					
					Thread.sleep(5000);
					try { 
						Alert alert = driver.switchTo().alert();
						alert.accept();
						test.log(LogStatus.PASS, "Clicked on OK Button");
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(5000);
					driver.findElement(By.name("checkno")).click();
					 test.log(LogStatus.PASS, "Clicked on Do you want another transaction for this customer : No");
					 
					 test.log(LogStatus.PASS, "Void Completed Successfully");
					 test.log(LogStatus.PASS, "Loggout Out From CSR Portal");
					 test.log(LogStatus.INFO, "******************************************************** ");
					 Thread.sleep(1000);
					driver.close();
					
					// ------------------------------------

					break;
				}
			}

		}

		catch (Exception e) {
		
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Void failed");

		}

	}
}

