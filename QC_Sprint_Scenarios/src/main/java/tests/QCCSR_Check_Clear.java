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



public class QCCSR_Check_Clear extends QCStore{

	public static void checkclear_adminmenu(WebDriver driver,String SSN,String AppURL)
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
				//String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				//String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String Trancd = TestData.getCellData(sheetName,"Trancd",row);
				String encryption_store_no = TestData.getCellData(sheetName,"encryption_store_no",row);
				String StoreID = TestData.getCellData(sheetName,"StoreID",row);
				
				

				test.log(LogStatus.INFO,"******** Admin Application is launched For Check Clear *********");

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
	
	driver.findElement(By.linkText("Clear")).click();
	test.log(LogStatus.PASS, "Clicked on Clear");		

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);

	test.log(LogStatus.PASS, "Store number Entered"+StoreID); 
	
	Thread.sleep(500);
	
	driver.findElement(By.xpath("//input[@value='Submit' and @type='button']")).click();
	test.log(LogStatus.PASS, "Clicked on Submit Button"); 
	Thread.sleep(1000);
	if (driver.findElement(By.name("requestBean.chkName")).isDisplayed()){
		driver.findElement(By.name("requestBean.chkName")).click();
		test.log(LogStatus.PASS, "Clicked on Check box");
		Thread.sleep(500);
		driver.findElement(By.name("CmdReturnPosting")).click();
		test.log(LogStatus.PASS, "Clicked on Finish Clear");
		Thread.sleep(500);
		if(driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td")).getText().contains("Successfully")){
			driver.findElement(By.name("checkno")).click();
			test.log(LogStatus.PASS, "Clicked on Transaction Completed OK Button");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Clear Transaction From Admin is Completed Successfully");
			Thread.sleep(1000);
			driver.close();	
			Thread.sleep(1000);
			break;
		}
		else
		{
			test.log(LogStatus.FAIL, "Clear Transaction is  not Completed Successfully ");}																													
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
					test.log(LogStatus.FAIL,"Clear From Admin is failed");

				}

	}
	
	public static void writeoffEncryption(WebDriver driver,String SSN,String AppURL)
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Login");
			String sheetName="Login";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
				String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
				String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
				//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
				String PIN = TestData.getCellData(sheetName,"PIN",row);
				String WOTrancd = TestData.getCellData(sheetName,"WOTrancd",row);
				String encryption_store_no = TestData.getCellData(sheetName,"encryption_store_no",row);
				
				

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
				test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);



	
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

	driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click(); 

	test.log(LogStatus.PASS, "Clicked on Employee tab");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(3000);
	driver.findElement(By.linkText("Encryption Key")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption Key link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Encryption")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption");

	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(encryption_store_no);

	test.log(LogStatus.PASS, "Store number Entered"+encryption_store_no); 
	
	Thread.sleep(500);


	driver.findElement(By.name("requestBean.tranNbr")).sendKeys(encryption_transaction_nbr);

	test.log(LogStatus.PASS, "Tran number Entered"+encryption_transaction_nbr); 
	
	Thread.sleep(500);


	driver.findElement(By.name("trancd")).sendKeys(WOTrancd);

	test.log(LogStatus.PASS, "Transaction selected as: " +WOTrancd);
	
	Thread.sleep(1000);


	driver.findElement(By.name("GetKey")).click();

	test.log(LogStatus.PASS, "GetKey clicked");
	
	Thread.sleep(500);

	Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");

	test.log(LogStatus.PASS,"GetKey captured as:" +Eankey);
	Thread.sleep(500);
	driver.close();

break;
}
			}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");

				}

	}
	public static void adjust_interest_Encryption(WebDriver driver,String SSN,String AppURL)
	{
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("adjust_interest");
			String sheetName="adjust_interest";

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
				test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);



	
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

	driver.findElement(By.xpath("//*[contains(text(),'Employee')]")).click(); 

	test.log(LogStatus.PASS, "Clicked on Employee tab");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
	Thread.sleep(3000);
	driver.findElement(By.linkText("Encryption Key")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption Key link");

	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");
	Thread.sleep(3000);
	driver.findElement(By.linkText("Encryption")).click();

	test.log(LogStatus.PASS, "Clicked on Encryption");

	Thread.sleep(5000);


	driver.switchTo().defaultContent();

	driver.switchTo().frame("mainFrame");

	driver.switchTo().frame("main");

	driver.findElement(By.name("requestBean.locationNbr")).sendKeys(encryption_store_no);

	test.log(LogStatus.PASS, "Store number Entered"+encryption_store_no); 
	
	Thread.sleep(500);


	driver.findElement(By.name("requestBean.tranNbr")).sendKeys(adjint_transnum);

	test.log(LogStatus.PASS, "Tran number Entered"+adjint_transnum); 
	
	Thread.sleep(500);


	driver.findElement(By.name("trancd")).sendKeys(Trancd);

	test.log(LogStatus.PASS, "Transaction selected as: " +Trancd);
	
	Thread.sleep(1000);


	driver.findElement(By.name("GetKey")).click();

	test.log(LogStatus.PASS, "GetKey clicked");
	
	Thread.sleep(500);

	Eankey = driver.findElement(By.name("EanKey")).getAttribute("value");

	test.log(LogStatus.PASS,"GetKey captured as:" +Eankey);
	Thread.sleep(500);
	driver.close();

break;
}
			}	
	
	
}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					test.log(LogStatus.FAIL,"Getting Encryption from Admin is failed");

				}

	}
	
}
