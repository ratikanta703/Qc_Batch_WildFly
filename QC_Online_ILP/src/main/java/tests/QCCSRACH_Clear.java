
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



public class QCCSRACH_Clear extends QCStore{

	public static void achclear_adminmenu(WebDriver driver,String SSN,String AppURL) throws Exception
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Clear");
			String sheetName="Clear";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Trancd = TestData.getCellData(sheetName,"Trancd",row);
				String encryption_store_no = TestData.getCellData(sheetName,"encryption_store_no",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				
				

				test.log(LogStatus.INFO,"******** Admin Application is launched For  Clear *********");

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
	driver.findElement(By.linkText("ACH")).click();

	test.log(LogStatus.PASS, "Clicked on ACH link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Payday Loan")).click();
	test.log(LogStatus.PASS, "Clicked on Payday Loan");

	Thread.sleep(5000);
	
	driver.findElement(By.linkText("ACH Clear")).click();
	test.log(LogStatus.PASS, "Clicked on Clear");		

	//driver.switchTo().defaultContent();

	//driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
	
	Thread.sleep(500);
	
	driver.findElement(By.name("submit")).click();
	test.log(LogStatus.PASS, "Clicked on Submit Button"); 
	Thread.sleep(1000);
	if (driver.findElement(By.name("requestBean.chkName")).isDisplayed()){
		driver.findElement(By.name("requestBean.chkName")).click();
		test.log(LogStatus.PASS, "Clicked on Check box");
		Thread.sleep(500);
		driver.findElement(By.name("CmdReturnPosting")).click();
		test.log(LogStatus.PASS, "Clicked on Finish Clear");
		Thread.sleep(5000);
		//if(driver.findElement(By.name("/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
			driver.findElement(By.name("Ok")).click();
			test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Clear Transaction From Admin is Completed Successfully");
			Thread.sleep(1000);
			driver.close();	
			Thread.sleep(1000);
			break;
		//}
		/*else
		{
			test.log(LogStatus.FAIL, "Clear Transaction is  not Completed Successfully ");
			}																													
		 Assert.assertTrue(false);
		driver.close();	
		break;*/
		
	}
				
}
}	
	
	
}

				catch (Exception e) {
					String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_Txn");
		 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		 			//test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_087_Txn_Testdata Transaction Failed ");					
					test.log(LogStatus.FAIL,"Clear From Admin is failed");

				}

	}
	
	
	
}

