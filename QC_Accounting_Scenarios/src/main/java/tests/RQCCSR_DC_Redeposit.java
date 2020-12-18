package tests;

import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;

public class RQCCSR_DC_Redeposit extends QCStore{

	public static void csrredepositDC(String SSN,String AppURL) throws Exception
	{
		try{

		test.log(LogStatus.PASS, "************Debit Cards Redeposit Transaction started****************");
		int lastrow=TestData.getLastRow("DCDeposit");
		String sheetName="DCDeposit";

		for(int row=2;row<=lastrow;row++)
		{	
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{

				//String RepresentmentType = TestData.getCellData(sheetName,"RepresentmentType",row);
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.findElement(By.partialLinkText("Debit Cards")).click();
				test.log(LogStatus.PASS, "Clicked on Debit Cards");
				driver.findElement(By.partialLinkText("Payday Loan")).click();
				test.log(LogStatus.PASS, "Clicked on Payday Loan");
				driver.findElement(By.partialLinkText("ReDeposit/Representment")).click();
				test.log(LogStatus.PASS, "Clicked on ReDeposit/Representment");
				Thread.sleep(5000);
				//loan_nbr="11170179";
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");
				/*driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
				test.log(LogStatus.PASS, "Enterd loan number is :"+loan_nbr);*/
				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Click on submit button");
				Thread.sleep(5000);
				
				String loanno=driver.findElement(By.xpath("//*[@id='dealNbrId0']")).getText();
				test.log(LogStatus.PASS, "Getting loan number from table"+loanno);
				if(loanno.equals(loan_nbr)){

					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "clicking on check box to select customer having loan number"+loan_nbr);

					/*driver.findElement(By.name("dispRepresentmentType")).sendKeys(RepresentmentType);;
					test.log(LogStatus.PASS, "Selected representment type as :"+RepresentmentType);*/
					
					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Click on Representment Now Button");
				}
				else{
					test.log(LogStatus.FAIL, " loan number didn't match");
				}


				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Debit Card Redeposit Completed Successfully ");
				test.log(LogStatus.INFO, "******************************************************** ");
				break;
			}else
			{
				test.log(LogStatus.FAIL, "Debit Card Redeposit  is Failed ");
			}
			
			}			 
		}
		catch(Exception e){
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Less_Redeposit_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Less_Redeposit Transaction Failed ");
			test.log(LogStatus.FAIL, "Debit Card Redeposit from CSR is failed");

		}
		}}
