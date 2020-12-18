

package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class QC_DC_Return_Validation extends QCStore{
	//private static String NextDueDate;

	public static void dc_dbreturn_validation(String SSN,String AppURL){
		int i;
		for(i=0;i<4;i++)
		{
			
		 
		try{
			
				int lastrow=TestData.getLastRow("DCDeposit");
				String sheetName="DCDeposit";

					for(int row=2;row<=lastrow;row++)
							{		
								String RegSSN = TestData.getCellData(sheetName,"SSN",row);
								if(SSN.equals(RegSSN))
								{
							
								String PIN = TestData.getCellData(sheetName,"PIN",row);
						       // System.out.println(Password);
						        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
						        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
						        String Status = TestData.getCellData(sheetName,"Status",row);
						
						       String AgeStore = TestData.getCellData(sheetName,"AgeStore",row);
						      
						
									  
								        String SSN1 = SSN.substring(0, 3);
								        String SSN2 = SSN.substring(3,5);
								        String SSN3 = SSN.substring(5,9);
								
								        
								        test.log(LogStatus.INFO, "Debit Card Status Verification");

										driver.switchTo().frame("bottom");
										String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
										test.log(LogStatus.PASS, ""+Str_date);

										driver.switchTo().defaultContent();	

										wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
										driver.switchTo().frame("topFrame");
										wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
										driver.findElement(By.cssSelector("li[id='910000']")).click();		
										test.log(LogStatus.PASS, "Clicked on Loan Transactions");
										Thread.sleep(3000);
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										driver.switchTo().defaultContent();
										driver.switchTo().frame("mainFrame");

										driver.findElement(By.cssSelector("li[id='911101']")).click();			
										test.log(LogStatus.PASS, "Clicked on Transactions");		
										driver.switchTo().frame("main");		
										driver.findElement(By.name("ssn1")).sendKeys(SSN1);
										test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
										driver.findElement(By.name("ssn2")).sendKeys(SSN2);
										test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
										driver.findElement(By.name("ssn3")).sendKeys(SSN3);
										test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
										driver.findElement(By.name("submit1")).click();
										test.log(LogStatus.PASS, "Click on submit Button");		

										driver.switchTo().defaultContent();
										driver.switchTo().frame("mainFrame");
										driver.switchTo().frame("main");

										driver.findElement(By.name("button")).click();
										test.log(LogStatus.PASS, "Clicked on Go button under search results");

										loan_nbr= driver.findElement(locator(prop.getProperty("loan_nbr"))).getText();
										test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
										driver.findElement(locator(prop.getProperty("clear_go"))).click();
										test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
										String DC_Status=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form[1]/table[2]/tbody/tr[5]/td/table/tbody/tr/td/table/tbody/tr[2]/td[6]")).getText();
										//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Debit Card Status is : "+DC_Status);
										//===============================
										if (DC_Status.trim().equalsIgnoreCase(Status.trim())) {
											//test.log(LogStatus.PASS, "Debit Card Status is :" + DC_Status);
											test.log(LogStatus.PASS, "<FONT color=green style=Arial> Debit Card Status is : "+DC_Status);
											
											//driver.close();
											break;
										
									}
										else 
											test.log(LogStatus.FAIL, "Status is not Returned");
				                          
										break;
									//}
										//=================================
							//break;
						 
					}
				}
			

		break; //for FOR loop		
		}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Borrower Registration is failed", ExtentColor.RED));
					//test.log(LogStatus.FAIL, "Age store is failed");
					test.log(LogStatus.FAIL, " "+e);
					test.log(LogStatus.INFO, "Status is not Returned");
					continue;


				}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Status is not Returned");
	
		}
	}
	
	
}
