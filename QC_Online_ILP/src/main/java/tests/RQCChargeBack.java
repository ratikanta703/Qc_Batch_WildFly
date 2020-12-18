package tests;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RQCChargeBack extends QCStore
{

	public static void chargeback(String SSN,String AppURL)throws Exception
	{
		//int i;
		//for(i=0;i<3;i++)
		//{
		
	try{
			int lastrow=TestData.getLastRow("ChargeBack");
			String sheetName="ChargeBack";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					String TransName = TestData.getCellData(sheetName,"TransName",row);
					
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					//Thread.sleep(3000);
					test.log(LogStatus.INFO,"ChargeBack From History Has started");
					Thread.sleep(1000);
			        Actions action = new Actions(driver);
			    	action.moveByOffset(200,100).perform();
			    	Thread.sleep(3000);
			    	action.click();
			    	Thread.sleep(1000);
					
					//Thread.sleep(3000);
					driver.switchTo().frame("topFrame");
					Thread.sleep(1000);
					/*Thread.sleep(3000);
			        Actions action1 = new Actions(driver);
			    	action1.moveByOffset(200,100).perform();
			    	Thread.sleep(3000);
			    	action1.click();*/
			    	Thread.sleep(2000);
					driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					
					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
					Thread.sleep(5000);			
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(2000);	
				//================================================
					
					List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr"));
					int n = rows.size();
					for (int i = 2; i <= n; i++) {
					String Transaction = driver.findElement(By.xpath("//*[@id='transactionDetailsTable']/tbody/tr["+i+"]/td[6]/font")).getText();
					test.log(LogStatus.PASS, "getting Transaction name as : " + Transaction);
					if (Transaction.equals("Buyback"))							
					{	
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table[2]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[1]/input")).click();
					test.log(LogStatus.PASS, "Transaction Type is : " + Transaction);
					test.log(LogStatus.PASS, "Clicked on BuyBack Radio button ");
					Thread.sleep(500);		

					//break;														
					}	
					else{
						continue;
					}
			  //==================================================
					
					JavascriptExecutor js=(JavascriptExecutor) driver;
					WebElement element = driver.findElement(By.xpath("//*[@id='selRadio']"));
					js.executeScript("arguments[0].scrollIntoView();", element);

					Thread.sleep(1000);

					break;
					
				}
					
					if (driver.findElement(By.xpath("//*[@id='dispute']")).isEnabled())
					{
						driver.findElement(By.xpath("//*[@id='dispute']")).click();
						
						test.log(LogStatus.PASS, "Clicked on Charge Back button ");
						Thread.sleep(1000);
					    	 			
					try {
						Alert alert = driver.switchTo().alert();
						String almsg = alert.getText();
						
						Thread.sleep(1000);
						alert.accept();
						
						test.log(LogStatus.PASS, "Alert Displayed");
						test.log(LogStatus.PASS, "Alert Message is : " + almsg);
						//test.log(LogStatus.PASS, "Trying to make a payment less than total due with waive apply fee)");
						Thread.sleep(1000);
						test.log(LogStatus.PASS, "ChargeBack Completed successfully");
						
						test.log(LogStatus.PASS,"****************************************");
						Thread.sleep(1000);
						String Verification_Fee=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[14]/td")).getText();
						test.log(LogStatus.PASS, "" +Verification_Fee);
						Thread.sleep(500);
						loan_nbr=driver.findElement(By.xpath("//*[@id='transactionHistoryTable']/tbody/tr/td[4]/table/tbody/tr[4]/td/span[2]")).getText();
						test.log(LogStatus.PASS, "Loan Number is " +loan_nbr);
						driver.close();
						break;
						

					} 
					catch (NoAlertPresentException e) 
					{
					//do what you normally would if you didn't have the alert.
				    }
				}
					else
					{
						test.log(LogStatus.FAIL, "Charge back button is disabled");
						Assert.assertTrue(false);
					}
					}
		
break;

}
	}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//test.log(LogStatus.FAIL, MarkupHelper.createLabel("Getting Encryption from Admin is failed", ExtentColor.RED));
					test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
					test.log(LogStatus.INFO, "Charge back button is disabled");
					driver.get(Rprop.getProperty("login_page")); 
					//continue;


				}

	
	}}