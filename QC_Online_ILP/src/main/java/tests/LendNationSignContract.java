package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class LendNationSignContract extends QCStore{
	
	public static void nmilp_ach_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(3000);	
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);								
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the Third checkbox");
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();			
				test.log(LogStatus.PASS, "Checked the Fourth checkbox");
				Thread.sleep(3000);				
				
				
			
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void moilp_ach_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(2000);				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the Third checkbox");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();			
				test.log(LogStatus.PASS, "Checked the Fourth checkbox");
				Thread.sleep(3000);				
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
			
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void ilp_cashatstore_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(3000);
												
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the Third checkbox");
				Thread.sleep(5000);
				
				
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}

	public static void signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the Third checkbox");
				Thread.sleep(5000);
												
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the Fourth checkbox");
				Thread.sleep(5000);
								
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				

				//driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				
				/*driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the Fourth checkbox");
				Thread.sleep(3000);*/
				
				
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void moilp_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(3000);
				driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(3000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);
				
				driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(3000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='subHeading']/div/h1")).getText().contains("LOAN APPROVED PENDING VERIFICATION")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was Approved successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Approved failed");}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	
public static void utilp_dc_ACH_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				Thread.sleep(5000);	
							
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();				
				test.log(LogStatus.PASS, "Checked the First checkbox ");
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();				
				test.log(LogStatus.PASS, "Checked the Second checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);		
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);				
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();				
				test.log(LogStatus.PASS, "Checked the Third checkbox ");
				Thread.sleep(5000);				
				
				
							
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				  System.out.println(e);

			  }
		
				
				
				}
	
public static void nmilp_dc_ACH_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();				
				test.log(LogStatus.PASS, "Checked the second checkbox ");
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();				
				test.log(LogStatus.PASS, "Checked the third checkbox ");
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();				
				test.log(LogStatus.PASS, "Checked the fourth checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox4']")).click();				
				test.log(LogStatus.PASS, "Checked the fifth checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox5']")).click();				
				test.log(LogStatus.PASS, "Checked the sixth checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox6']")).click();				
				test.log(LogStatus.PASS, "Checked the seventh checkbox ");
				Thread.sleep(5000);
				
							
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox6']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void ilp_dc_ACH_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();				
				test.log(LogStatus.PASS, "Checked the second checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();				
				test.log(LogStatus.PASS, "Checked the third checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();				
				test.log(LogStatus.PASS, "Checked the fourth checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);			
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	public static void ilp_dc_CashatStore_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(5000);
				
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();				
				test.log(LogStatus.PASS, "Checked the second checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();				
				test.log(LogStatus.PASS, "Checked the third checkbox ");
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);			
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(1000);
				
				Thread.sleep(30000);
				
				 if( driver.findElement(By.xpath("//*[@id='appNo']")).isDisplayed())
				  {
					 loan_number=driver.findElement(By.xpath("//*[@id='appNo']")).getText();
					 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Number is : " +loan_number);
					 
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Successfully with SSN : " +SSN);
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Loan Generated Successfully with Loan Number as  : " +loan_number);
						Thread.sleep(500);
						String app_date=driver.findElement(By.xpath("//*[@id='appDate']")).getText();
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Application Date is : " +app_date);
						test.log(LogStatus.INFO, "******************************************************** ");
						
						

					 	}
				else
						{
						test.log(LogStatus.FAIL, " Esign not successfully with SSN : " +SSN);
						}


					Thread.sleep(5000);
					driver.close();
					break ;
		
					}
			  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void okilp_ach_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the Fifth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired3']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/h1")).getText().contains("LOAN APPROVED")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was approved successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void okilp_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
					test.log(LogStatus.PASS, "Checked the first checkbox ");
					
				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
				test.log(LogStatus.PASS, "Checked the Fifth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired3']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void ililp_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(5000);
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBoxNotReq4']")).click();
				test.log(LogStatus.PASS, "Checked the fifth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureNotRequired3']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox5']")).click();
				test.log(LogStatus.PASS, "Checked the sixth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired4']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox5']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void wiilp_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				//driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox3']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
				


					 
					 
					 

				 
			
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void wiilp_dc_ach_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				driver.findElement(locator(prop.getProperty("checkbox1_signpage"))).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				driver.findElement(locator(prop.getProperty("checkbox2_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(locator(prop.getProperty("checkbox3_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(locator(prop.getProperty("checkbox4_signpage"))).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");	
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
								
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
			
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");}


					Thread.sleep(5000);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					driver.close();
					
					break ;
	
					}
			  
					}
				
			  
		}
		catch(Exception e)
		  {
			  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
			  //test.log(LogStatus.ERROR, "Error message  " +e);
			  //test.log(LogStatus.FAIL, "Loan Orgination failed");
			  //Assert.assertTrue(false);
			  String screenshotPath = getScreenhot(driver, "signContract");
			  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				System.out.println(e);

		  }
			
			
			}

//}
	
public static void ililp_dc_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureNotRequired2']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBoxNotReq3']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");
				Thread.sleep(5000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired3']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);				
				driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
				test.log(LogStatus.PASS, "Checked the fifth checkbox");
				Thread.sleep(5000);
				
				
				
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");
					}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
		
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
public static void ililp_cashatstore_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBoxNotReq3']")).click();
				test.log(LogStatus.PASS, "Checked the fourth checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureNotRequired3']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox4']")).click();
				test.log(LogStatus.PASS, "Checked the fifth checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired4']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");
					}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
		
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}

	
	public static void wiilp_cashatstore_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				Thread.sleep(3000);
				
				
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired2']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(5000);
				
			
				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				Thread.sleep(5000);
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='achSuccess']/td/center")).getText().contains("Your loan was originated successfully")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");
					}


					Thread.sleep(5000);
					driver.close();
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					break ;
				
		
					}
				  
				 
				  
					}
				
			  
		}
			  catch(Exception e)
			  {
				  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
				  //test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "signContract");
				  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
					System.out.println(e);

			  }
				
				
				}
	
	public static void wiilp_dc_cashatstore_signContract(String SSN,String AppURL) throws Exception
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Personal Information");
				String sheetName="Personal Information";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					if(SSN.equals(RegSSN))
					{	
				String firstname = TestData.getCellData(sheetName,"FirstName",row);
				String lastname = TestData.getCellData(sheetName,"LastName",row);
				String Signaturename=firstname+" "+lastname;

				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("checkbox1_signpage")))));
				test.log(LogStatus.INFO, "*******Lend Nation application navigated to Sign Contract page********");
				System.out.println("Under SignContra");
				
				driver.findElement(By.xpath("//*[@id='checkBox0']")).click();				
				test.log(LogStatus.PASS, "Checked the first checkbox ");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='checkBox1']")).click();
				test.log(LogStatus.PASS, "Checked the second checkbox");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='SignatureRequired0']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the first Signature field details as : "+Signaturename);
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
				test.log(LogStatus.PASS, "Checked the third checkbox");
				Thread.sleep(1000);				
				driver.findElement(By.xpath("//*[@id='SignatureRequired1']")).sendKeys(Signaturename);				
				test.log(LogStatus.PASS, "Entered the  Signature field details as : "+Signaturename);
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
				test.log(LogStatus.PASS, "Clicked on Get New Loan button");
				try { 
					driver.findElement(By.xpath("//*[@id='checkBox2']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='getLoanNowButton']")).click();
					test.log(LogStatus.PASS, "Clicked on Get New Loan button");

				}
				catch(Exception e){
					//do what you normally would if you didn't have the alert.
				}
				
				Thread.sleep(30000);
				
				//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator(prop.getProperty("go_to_dashboard_button")))));
				
				if(driver.findElement(By.xpath("//*[@id='cashAtSuccess']/td/center")).getText().contains("E-sign process is completed")){
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> E-sign process is completed successfully");
					test.log(LogStatus.INFO, "*********************** Now Login to 252 store for Loan Completion ********************** ");
				}
				else
				{
					test.log(LogStatus.FAIL, "Loan Orgination failed");
					}


					Thread.sleep(5000);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Log Out From Lendnation successfully");
					driver.close();
					
					break ;
				
		
					}
				  
				 
				  
					}
				
			  
		}
		catch(Exception e)
		  {
			  //test.log(LogStatus.ERROR, "Unable to complete  Sign Contract with SSN  " +SSN);
			  //test.log(LogStatus.ERROR, "Error message  " +e);
			  //test.log(LogStatus.FAIL, "Loan Orgination failed");
			  //Assert.assertTrue(false);
			  String screenshotPath = getScreenhot(driver, "signContract");
			  //test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				System.out.println(e);

		  }
				
				
				}
	
	}
	
	
	

