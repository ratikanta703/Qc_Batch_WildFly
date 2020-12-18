
package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class QCCSR_CheckReturn extends QCStore{

	public static void checkreturn_adminmenu(WebDriver driver,String SSN,String AppURL)
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Check_Return");
			String sheetName="Check_Return";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Reason = TestData.getCellData(sheetName,"Reason",row);
				String encryption_store_no = TestData.getCellData(sheetName,"encryption_store_no",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				
				

				test.log(LogStatus.INFO,"******** Admin Application is launched For Check Return Posting *********");

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
				test.log(LogStatus.INFO,"Performing Check Clear From Admin Menu"+ AdminURL);



	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

	test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

	test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(3000);
	driver.get(csrloginpage);
	Thread.sleep(3000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 

	test.log(LogStatus.PASS, "Clicked on Transaction tab");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(3000);
	driver.findElement(By.linkText("Collateral Checks")).click();

	test.log(LogStatus.PASS, "Clicked on Collateral Checks link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Payday Loan")).click();
	test.log(LogStatus.PASS, "Clicked on Payday Loan");

	Thread.sleep(5000);
	
	driver.findElement(By.linkText("Return Posting")).click();
	test.log(LogStatus.PASS, "Clicked on Return Posting");		

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
	
	Thread.sleep(500);
	
	driver.findElement(By.xpath("//input[@value='Submit' and @type='button']")).click();
	test.log(LogStatus.PASS, "Clicked on Submit Button"); 
	Thread.sleep(3000);
	if (driver.findElement(By.name("requestBean.chkName")).isDisplayed()){
		driver.findElement(By.name("requestBean.chkName")).click();
		test.log(LogStatus.PASS, "Clicked on Check box");
		Thread.sleep(500);
		driver.findElement(By.name("rtnReasonId")).sendKeys(Reason);
		test.log(LogStatus.PASS, "Select Reason as :"+Reason);
		Thread.sleep(500);
		driver.findElement(By.name("CmdReturnPosting")).click();
		test.log(LogStatus.PASS, "Clicked on Finish ReturnPosting");
		Thread.sleep(500);
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
			driver.findElement(By.name("checkno")).click();
			test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Check Return From Admin Transaction is Completed Successfully");
			Thread.sleep(1000);
			driver.close();	
			Thread.sleep(1000);
			break;
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Return From Admin Transaction is  not Completed Successfully ");}																													
		 Assert.assertTrue(false);
		driver.close();	
		break;
		
	}
				
}
}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 Assert.assertTrue(false);
					test.log(LogStatus.FAIL,"Check Return From Admin is failed");

				}

	}
	
	public static void checkredeposit_adminmenu(WebDriver driver,String SSN,String AppURL)
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Check_Redeposit");
			String sheetName="Check_Redeposit";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String CheckType = TestData.getCellData(sheetName,"CheckType",row);
				String encryption_store_no = TestData.getCellData(sheetName,"encryption_store_no",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				
				

				test.log(LogStatus.INFO,"******** Admin Application is launched For Check Return Posting *********");

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
				test.log(LogStatus.INFO,"Performing Check Clear From Admin Menu"+ AdminURL);



	
	DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

	driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

	test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

	driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

	test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

	//Click Login Button

	driver.findElement(By.name("login")).click();

	test.log(LogStatus.PASS, "Clicked on Submit button");

	Thread.sleep(3000);
	driver.get(csrloginpage);
	Thread.sleep(3000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("topFrame");

	driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 

	test.log(LogStatus.PASS, "Clicked on Transaction tab");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(3000);
	driver.findElement(By.linkText("Collateral Checks")).click();

	test.log(LogStatus.PASS, "Clicked on Collateral Checks link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Payday Loan")).click();
	test.log(LogStatus.PASS, "Clicked on Payday Loan");

	Thread.sleep(5000);
	
	driver.findElement(By.linkText("ReDeposit/Representment")).click();
	test.log(LogStatus.PASS, "Clicked on Redeposit/Representment Link");		

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
	
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
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
			driver.findElement(By.name("checkno")).click();
			test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Check Deposit From Admin Transaction is Completed Successfully");
			Thread.sleep(1000);
			driver.close();	
			Thread.sleep(1000);
			break;
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Deposit From Admin Transaction is  not Completed Successfully ");}																													
		 Assert.assertTrue(false);
		driver.close();	
		break;
		
	}
				
}
}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					 Assert.assertTrue(false);
					test.log(LogStatus.FAIL,"Check Deposit From Admin is failed");

				}

	}
	
	}

