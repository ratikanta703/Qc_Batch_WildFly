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

public class QCCSRDefaultVerify extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void defaultverify(String SSN, String AppURL) {
		try {
			int lastrow = TestData.getLastRow("Default");
			String sheetName = "Default";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				String TxnType = TestData.getCellData(sheetName,"TxnType",row);
				String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
				String Balance_Status = TestData.getCellData(sheetName, "Balance_Status", row);
				//String TenderType = TestData.getCellData(sheetName, "TenderType", row);
				//String PIN = TestData.getCellData(sheetName, "PIN", row);
				if(SSN.equals(RegSSN))
				{		
					State = TestData.getCellData(sheetName,"StateID",row);
					 //ProductID=TestData.getCellData(sheetName,"ProductID",row);
					//System.out.println(ProductID);
					 
	
					 SSN1 = SSN.substring(0, 3);
					 SSN2 = SSN.substring(3,5);
					 SSN3 = SSN.substring(5,9);
					
					 
					Thread.sleep(3000);
					test.log(LogStatus.INFO, "Default Verification Started");
					driver.switchTo().frame("topFrame");
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();	
					
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");
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
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						driver.findElement(By.name("button")).click();
						test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);
						for (String winHandle1 : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle1);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						//test.log(LogStatus.PASS, "Clicked on GO Button");
						Thread.sleep(5000);

						String BalanceStatus = driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[8]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[6]")).getText();
						                                                    
						System.out.println(BalanceStatus);
						Thread.sleep(1000);
						if (Balance_Status.trim().equalsIgnoreCase(BalanceStatus.trim())) {
							//test.log(LogStatus.PASS, "Balance Status is :" + Balance_Status);
							test.log(LogStatus.PASS, "<FONT color=green style=Arial> Balance Status is :"+ Balance_Status);
							Thread.sleep(5000);
							driver.close();
						
	                        
						
					}
						else 
							test.log(LogStatus.FAIL, "Status is not Default");
                          
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
