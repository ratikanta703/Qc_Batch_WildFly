/*package tests;

public class QC_CentralStore_FDDSection_Verification {

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

public class QC_CentralStore_FDDSection_Verification extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;


	public static void centralstore_courtesycall_fddsection_verification(String SSN, String AppURL) throws Exception {
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
			//String loan_number="11318261";
					
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
					if (driver.findElement(By.xpath("//*[@id='fddHistoryTable']/tbody/tr[1]/td[4]")).isDisplayed()){

						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Section is Displayed in Central Store Courtesy Call Screen");
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> FDD Section Verification is Successfull");
					}
					else {
						test.log(LogStatus.FAIL, "FDD Section Verification is Fail");
					}
					}
					//break;
				}

			}
	
}