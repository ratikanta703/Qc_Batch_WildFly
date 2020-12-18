
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

public class QCCSR_Check_Redeposit extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void check_redeposit(String SSN, String AppURL) throws Exception {
		try {
			int lastrow = TestData.getLastRow("Check_Redeposit");
			String sheetName = "Check_Redeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				String TenderType = TestData.getCellData(sheetName,"TenderType",row);
				String CheckType = TestData.getCellData(sheetName,"CheckType",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String CC_MO_Nbr = TestData.getCellData(sheetName, "CC_MO_Nbr", row);
				if (SSN.equals(RegSSN)) {
					State = TestData.getCellData(sheetName,"StateID",row);
					
					 
	
					 SSN1 = SSN.substring(0, 3);
					 SSN2 = SSN.substring(3,5);
					 SSN3 = SSN.substring(5,9);
					
					 
					Thread.sleep(3000);
					test.log(LogStatus.INFO,"############ Check Redeposit started #############");
				   driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					//driver.findElement(locator(prop.getProperty("csr_transaction_link"))).click();			
					driver.findElement(By.linkText("Collateral Checks")).click();
					test.log(LogStatus.PASS, "Clicked on Collateral Checks");	
					
					Thread.sleep(3000);
					driver.findElement(By.linkText("Payday Loan")).click();
					test.log(LogStatus.PASS, "Clicked on Payday Loan");

					Thread.sleep(5000);
					
					driver.findElement(By.linkText("ReDeposit/Representment")).click();
					test.log(LogStatus.PASS, "Clicked on Redeposit/Representment Link");
					//driver.switchTo().defaultContent();

					//driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");

					//driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);

					//test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
					
					Thread.sleep(500);
					
					driver.findElement(By.xpath("//input[@value='Submit' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Submit Button"); 
					Thread.sleep(3000);
					if (driver.findElement(By.name("requestBean.chkName")).isDisplayed()){
						driver.findElement(By.name("requestBean.chkName")).click();
						test.log(LogStatus.PASS, "Clicked on Check box");
						Thread.sleep(500);
						driver.findElement(By.name("dispRepresentmentType")).sendKeys(CheckType);
						test.log(LogStatus.PASS, "Select Check type as :"+CheckType);
						Thread.sleep(500);
						driver.findElement(By.name("CmdReturnPosting")).click();
						test.log(LogStatus.PASS, "Clicked on Finish Deposit");
						Thread.sleep(500);
						//if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
							//driver.findElement(By.name("checkno")).click();
							//test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Check Redeposit  Transaction is Completed Successfully");
							Thread.sleep(1000);
							driver.close();	
							Thread.sleep(1000);
							break;
						//}
						
						
					}
					else
					{
						test.log(LogStatus.FAIL, "Check Redeposit From Admin Transaction is  not Completed Successfully ");
						}																													
					 //Assert.assertTrue(false);
					//driver.close();	
					break;
				}
			}
		}
				
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_087_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

		}

	}
	
	
	
}


