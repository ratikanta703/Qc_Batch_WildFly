package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class RAdmin_OutForRepo extends QCStore{
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;


	public static void outforrepo(WebDriver driver,String SSN,String AppURL)
	{
	try{
	
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{	
				
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					SSN1 = SSN.substring(0, 3);
					SSN2 = SSN.substring(3, 5);
					SSN3 = SSN.substring(5, 9);
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				      //String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Trancd = TestData.getCellData(sheetName,"Trancd",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				
				
				String OutForRepo = TestData.getCellData(sheetName,"OutForRepo",row);
				String RepoCompany = TestData.getCellData(sheetName,"RepoCompany",row);
				String Status = TestData.getCellData(sheetName,"Status",row);
				String ContactName = TestData.getCellData(sheetName,"ContactName",row);
				String VendorCompany = TestData.getCellData(sheetName,"VendorCompany",row);
				String Contract_Sent_Date = TestData.getCellData(sheetName,"Contract_Sent_Date",row);
				String Contract_Exe_Date = TestData.getCellData(sheetName,"Contract_Exe_Date",row);
				
				String CaseNo = TestData.getCellData(sheetName,"CaseNo",row);
				String BankChapter = TestData.getCellData(sheetName,"BankChapter",row);
				String AttorneyName = TestData.getCellData(sheetName,"AttorneyName",row);
				String AttorneyPhone = TestData.getCellData(sheetName,"AttorneyPhone",row);
				String AttorneyP1 = AttorneyPhone.substring(0, 3);
		        String AttorneyP2 = AttorneyPhone.substring(3, 6);
		        String AttorneyP3 = AttorneyPhone.substring(6, 10);

				test.log(LogStatus.INFO,"Admin Application is launched");

				driver = new InternetExplorerDriver();
				//wait = new WebDriverWait(driver, 40000);

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
			
				driver.get(AdminURL);
				Thread.sleep(1000);
				
				try {
					driver.findElement(By.id("overridelink")).click();
					Thread.sleep(3000);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(1000);
				test.log(LogStatus.INFO,"Opened the Admin URL"+ AdminURL);
				test.log(LogStatus.INFO,"Admin Login For Out For Repo"+ AdminURL);



	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

	test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

	test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(800);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");
	
	Thread.sleep(2000);

	driver.findElement(By.xpath("//*[@id='500000']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Transaction tab");
	
	
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id='9881908084']/a")).click();

	test.log(LogStatus.PASS, "Clicked on Title Loan link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(5000);
	driver.findElement(By.linkText("Repo Process")).click();

	test.log(LogStatus.PASS, "Clicked on Repo Process");
	
	//Thread.sleep(5000);
	
	//==================================================================
	Thread.sleep(3000);
	test.log(LogStatus.INFO, "Repo Process Started");
	
		driver.switchTo().frame("main");
	/*driver.findElement(By.name("ssn1")).sendKeys(SSN1);
	test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
	driver.findElement(By.name("ssn2")).sendKeys(SSN2);
	test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);*/
	driver.findElement(By.name("ssn3")).sendKeys(SSN3);
	test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
	driver.findElement(By.name("submit")).click();
	test.log(LogStatus.PASS, "Click on submit Button");		
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("main");
		driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
		test.log(LogStatus.PASS, "Clicked on GO Button");
		Thread.sleep(5000);
	//==================================================================
	
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame("mainFrame");
	
	driver.switchTo().frame("main");
	
	Thread.sleep(500);
	
	driver.findElement(By.name("requestBean.repoStatusId")).sendKeys(OutForRepo);
	test.log(LogStatus.PASS, "Repo Action Selected as :" +OutForRepo); 
	
	Thread.sleep(1000);
	
//==================================  Adding Repo Company  ===============================================
	driver.findElement(By.name("addRepoCompany")).click();
	test.log(LogStatus.PASS, "Clicked On Add Repo Company"); 
	Thread.sleep(5000);
    String mainwindow=driver.getWindowHandle();
   
		    for(String winHandle1 : driver.getWindowHandles()){
				if(!mainwindow.equalsIgnoreCase(winHandle1))
				{
			    driver.switchTo().window(winHandle1);
	
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.repoCompany")).sendKeys(RepoCompany);
		        test.log(LogStatus.PASS, "Company Name Entered as "+RepoCompany);
		        Thread.sleep(200);
		        driver.findElement(By.name("requestBean.repoStatus")).sendKeys(Status);
		        test.log(LogStatus.PASS, "Company Name Selected as "+Status);
		        Thread.sleep(200);
		        driver.findElement(By.name("requestBean.vendorCompName")).sendKeys(VendorCompany);
		        test.log(LogStatus.PASS, "Vendor Company Name Entered as "+VendorCompany);
		        Thread.sleep(200);
		        driver.findElement(By.name("requestBean.contactName")).sendKeys(ContactName);
		        test.log(LogStatus.PASS, "Contact Name Entered as "+ContactName);
		        Thread.sleep(200);
		        String SentDate[] =Contract_Sent_Date.split("/");
		        String SentDate1 = SentDate[0];
		        String SentDate2 = SentDate[1];
		        String SentDate3 = SentDate[2];	
		        Thread.sleep(200);
		        String ExeDate[] =Contract_Exe_Date.split("/");
		        String ExeDate1 = ExeDate[0];
		        String ExeDate2 = ExeDate[1];
		        String ExeDate3 = ExeDate[2];
		        Thread.sleep(500);
		        driver.findElement(By.name("contractSentDate1")).sendKeys(SentDate1);
				test.log(LogStatus.PASS, "Sent Date1 is entered: "+SentDate1);
				Thread.sleep(200);
				driver.findElement(By.name("contractSentDate2")).sendKeys(SentDate2);
				test.log(LogStatus.PASS, "Sent Date2 is entered: "+SentDate2);
				Thread.sleep(200);
				driver.findElement(By.name("contractSentDate3")).sendKeys(SentDate3);
				test.log(LogStatus.PASS, "Sent Date3 is entered: "+SentDate3);
				Thread.sleep(200);
				driver.findElement(By.name("contractExecutedDate1")).sendKeys(ExeDate1);
				test.log(LogStatus.PASS, "Contract Exe Date1 is entered: "+ExeDate1);
				Thread.sleep(200);
				driver.findElement(By.name("contractExecutedDate2")).sendKeys(ExeDate2);
				test.log(LogStatus.PASS, "Contract Exe Date2 is entered: "+ExeDate2);
				Thread.sleep(200);
				driver.findElement(By.name("contractExecutedDate3")).sendKeys(ExeDate3);
				test.log(LogStatus.PASS, "Contract Exe Date3 is entered: "+ExeDate3);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@value='Add Repo Company' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on Add Repo Company Button");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Ok' and @type='button']")).click();
				test.log(LogStatus.PASS, "Clicked on OK Button");
			
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Company Added Successfully ");
				test.log(LogStatus.INFO, "******************************************************** ");

				Thread.sleep(3000);
		        
		       /* driver.close();
				break;*/
				}
		    }
				driver.switchTo().window(mainwindow);
				Thread.sleep(3000);
				
				String Repo_Date[] =business_date.split("/");
		        String Repo_Date1 = Repo_Date[0];
		        String Repo_Date2 = Repo_Date[1];
		        String Repo_Date3 = Repo_Date[2];
		        driver.switchTo().defaultContent();
		    	
		    	driver.switchTo().frame("mainFrame");
		    	
		    	driver.switchTo().frame("main");
		    	
		    	Thread.sleep(500);
		        driver.findElement(By.name("repoDate1")).sendKeys(Repo_Date1);
		        test.log(LogStatus.PASS, "Month is entered: "+Repo_Date1);
				driver.findElement(By.name("repoDate2")).sendKeys(Repo_Date2);
				test.log(LogStatus.PASS, "Date is entered: "+Repo_Date2);
				driver.findElement(By.name("repoDate3")).sendKeys(Repo_Date3);
				test.log(LogStatus.PASS, "Year is entered: "+Repo_Date3);
	
//==================================================================================
	
	driver.findElement(By.name("submitBtn")).click();
	test.log(LogStatus.PASS, "clicked on Repo Screen Save&Close Button"); 		
	
	
	Thread.sleep(1000);
	driver.findElement(By.name("Ok")).click();
	test.log(LogStatus.PASS, "Transaction Completed Successfully");
	Thread.sleep(1000);
	test.log(LogStatus.PASS, "<FONT color=green style=Arial> Out For Repo Successfully ");
	test.log(LogStatus.INFO, "******************************************************** ");
	   
			break;
		
	    }
			
	Thread.sleep(500);
	
	driver.close();

//break;
}
			//}	
	
			}	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Assert.assertTrue(false);
					test.log(LogStatus.FAIL,"Out For Repo In Admin is failed");

				}

	}
}
