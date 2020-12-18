package tests;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.Status;


//import tests.LendNation;
import tests.QCStore;

public class LendNationLoggin extends QCStore{
	
	public static void nm_ilp_refinance(String SSN,String AppURL) throws Exception	
	
    {
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Refinance");
			String sheetName="Refinance";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

		if(SSN.equals(RegSSN))
		{	
			
		String state = TestData.getCellData(sheetName,"State",row);
		String email1 = TestData.getCellData(sheetName,"Email",row);
		String email2 = TestData.getCellData(sheetName,"EmailExt",row);
		String email=email1.concat(email2);
		String password = TestData.getCellData(sheetName,"Password",row);
		String Payment_Method = TestData.getCellData(sheetName,"Payment_Method",row);
		String firstname = TestData.getCellData(sheetName,"FirstName",row);
		String lastname = TestData.getCellData(sheetName,"LastName",row);
		String Signaturename=firstname+" "+lastname;
		
		String SSN1 = SSN.substring(0, 3);
	    String SSN2 = SSN.substring(3,5);
	    String SSN3 = SSN.substring(5,9);
	    
		
		
	  //driver.get(AppURL);
	    
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
	
	  driver.get(prop.getProperty("LendNation_URL"));
	  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
	
	  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Opened Lend Nation Portal For Refinance ********* ");
	  test.log(LogStatus.INFO, "******************************************************** ");

	  Thread.sleep(2000);
	  
	    driver.findElement(By.linkText("QTP")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");
	    
	  Thread.sleep(4000);
	 
//========================  Script For Login Through Email =================
	  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
	  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
	  		 
	  Thread.sleep(1000);
	  
	  
//========================  Script For Login Through Email =================

Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
	  test.log(LogStatus.PASS, "User Name Enter as : " +email);

	  Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
	  test.log(LogStatus.PASS, "Password Enter as : " +password);
	  
      Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
	  test.log(LogStatus.PASS, "Clicked on Login");
	  
	  Thread.sleep(10000);
	  
	  Thread.sleep(2000);
	  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
	  Thread.sleep(2000);
	  WebElement element = driver.findElement(By.id("ui-id-1"));

		Actions action = new Actions(driver);

		action.moveToElement(element);
		//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
		//driver.findElement(By.id("ui-id-1")).click();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		 Thread.sleep(500); 

	  driver.findElement(By.id("ui-id-1")).click();		
	  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
	  Thread.sleep(1000);
	  driver.findElement(By.id("cur")).click();
	  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
	  Thread.sleep(1000);

	  
//======================================  Refinance Started =======================================================
	 
			 if (driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[2]/div/div[2]/div[2]/button")).isEnabled()){

					test.log(LogStatus.INFO, "Refinance Button Is  Enabled");
					
				}
				else {
				
					test.log(LogStatus.INFO, "Refinance Button Is  Disabled");
					test.log(LogStatus.PASS, "Refinance Tab Verification Completed");
					test.log(LogStatus.INFO, "******************************************************** ");
					break;
				}
			 
	

	
		Thread.sleep(2000);

	  
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			//test.log(LogStatus.ERROR, "Unable to Login through Email");
			//test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "OnlineLogin");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }

	public static void nm_ilp_dc_payment(String SSN,String AppURL) throws Exception	
	
    {
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

		if(SSN.equals(RegSSN))
		{	
			
		String state = TestData.getCellData(sheetName,"State",row);
		String email1 = TestData.getCellData(sheetName,"Email",row);
		String email2 = TestData.getCellData(sheetName,"EmailExt",row);
		String email=email1.concat(email2);
		String password = TestData.getCellData(sheetName,"Password",row);
		String PaymentMethod = TestData.getCellData(sheetName,"PaymentMethod",row);
		String FirstName = TestData.getCellData(sheetName,"FirstName",row);
		String LastName = TestData.getCellData(sheetName,"LastName",row);
		String BillingAddress = TestData.getCellData(sheetName,"BillingAddress",row);
		String DebitCard = TestData.getCellData(sheetName,"DebitCard",row);
		String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
		String CardType = TestData.getCellData(sheetName,"CardType",row);
		String CVV = TestData.getCellData(sheetName,"CVV",row);
		String ExpMonth = TestData.getCellData(sheetName,"ExpMonth",row);
		String ExpYear = TestData.getCellData(sheetName,"ExpYear",row);
		//String Signaturename=firstname+" "+lastname;
		
		String SSN1 = SSN.substring(0, 3);
	    String SSN2 = SSN.substring(3,5);
	    String SSN3 = SSN.substring(5,9);
	    
		
		
	  //driver.get(AppURL);
	    
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
	
	  driver.get(prop.getProperty("LendNation_URL"));
	  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
	
	  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Opened Lend Nation Portal For Payment ********* ");
	  test.log(LogStatus.INFO, "******************************************************** ");

	  Thread.sleep(2000);
	  
	    driver.findElement(By.linkText("QTP")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");
	    
	  Thread.sleep(4000);
	 
//========================  Script For Login Through Email =================
	  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
	  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
	  		 
	  Thread.sleep(1000);
	  
	  
//========================  Script For Login Through Email =================

Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
	  test.log(LogStatus.PASS, "User Name Enter as : " +email);

	  Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
	  test.log(LogStatus.PASS, "Password Enter as : " +password);
	  
      Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
	  test.log(LogStatus.PASS, "Clicked on Login");
	  
	  Thread.sleep(10000);
	  
	  Thread.sleep(2000);
	  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
	  Thread.sleep(2000);
	  WebElement element = driver.findElement(By.id("ui-id-1"));

		Actions action = new Actions(driver);

		action.moveToElement(element);
		//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
		//driver.findElement(By.id("ui-id-1")).click();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		 Thread.sleep(500); 

	  driver.findElement(By.id("ui-id-1")).click();		
	  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
	  Thread.sleep(1000);
	  driver.findElement(By.id("cur")).click();
	  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
	  Thread.sleep(1000);

	  
//======================================  Payment Started =======================================================
	 
			 if (driver.findElement(By.xpath("//*[@id='makePay']")).isEnabled()){

					test.log(LogStatus.INFO, "Payment Button Is  Enabled");
					Thread.sleep(500);
					test.log(LogStatus.INFO, "************ Payment Started ************** ");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='makePay']")).click();
					test.log(LogStatus.PASS, "Clicked On Payment Tab");
					Thread.sleep(1000);
					driver.findElement(By.name("mkpayts")).click();
					test.log(LogStatus.PASS, "Clicked On Continue Tab");
					Thread.sleep(8000);
					driver.findElement(By.id("instAmtRad")).click();
					test.log(LogStatus.PASS, "Clicked On Scheduled Payment amount Check box");
					Thread.sleep(500);
					String PaymentAmt = driver.findElement(By.xpath("//*[@id='othAmtTLP']")).getText();
					test.log(LogStatus.PASS, "Payment amount on screen is :"+PaymentAmt);
					Thread.sleep(500);
					driver.findElement(By.name("paymentType")).sendKeys(PaymentMethod);
					test.log(LogStatus.PASS, "Payment type selected as  :"+PaymentMethod);
					Thread.sleep(500);
			//===========================================
					Thread.sleep(100);
					
					  driver.findElement(By.xpath("//*[@id='fName']")).sendKeys(FirstName);
					  test.log(LogStatus.PASS, "Card Holder First Name is : " + FirstName); 
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='lName']")).sendKeys(LastName);
					  test.log(LogStatus.PASS, "Card Holder Last Name is : " + LastName);
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='addres']")).sendKeys(BillingAddress);
					  test.log(LogStatus.PASS, "Billing Address is : " + BillingAddress);
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='cardNumber']")).sendKeys(DebitCard);
					  test.log(LogStatus.PASS, "Debit Card Number is : " + DebitCard);
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(ZipCode);
					  test.log(LogStatus.PASS, "Zip Code is : " + ZipCode);
					  
					  Thread.sleep(100);
					  					
					 /* driver.findElement(By.xpath("//*[@id='rCardType']")).sendKeys("Visa");
					  test.log(LogStatus.PASS, "Card type is : " + "Visa");
					  
					  Thread.sleep(100);*/
					  
					  driver.findElement(By.xpath("//*[@id='cvvNumber']")).sendKeys(CVV);
					  test.log(LogStatus.PASS, "Cvv Number is : " + CVV);
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='rExpiresMonth']")).sendKeys(ExpMonth);
					  test.log(LogStatus.PASS, "Exp Month is : " + ExpMonth);
					  
					  Thread.sleep(100);
					  
					  driver.findElement(By.xpath("//*[@id='rExpiresYear']")).sendKeys(ExpYear);
					  test.log(LogStatus.PASS, "Exp year is : " + ExpYear);
					  
					  Thread.sleep(1000);
			//===========================================
					  
					driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
					test.log(LogStatus.PASS, "Clicked On Submit Tab in Payment Screen");
					Thread.sleep(20000);
					Thread.sleep(20000);
					if(driver.findElement(By.xpath("//*[@id='submit']/div[1]/h3/strong")).getText().contains("Your payment has been submitted")){
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Completed Successfully");
					}
					else
					{
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>Payment  Completed Successfully ");}
			 }
				else {
				
					test.log(LogStatus.INFO, "Payment Button Is  Disabled");
					test.log(LogStatus.PASS, "Payment Tab Verification Completed");
					test.log(LogStatus.INFO, "******************************************************** ");
					break;
				}
			 
	

	
		Thread.sleep(2000);

	  
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			//test.log(LogStatus.ERROR, "Unable to Login through Email");
			//test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "OnlineLogin");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }
	public static void nm_ilp_ach_payment(String SSN,String AppURL) throws Exception	
	
    {
	 
	try{
		//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
		
		//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
			int lastrow=TestData.getLastRow("Payment");
			String sheetName="Payment";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);

		if(SSN.equals(RegSSN))
		{	
			
		String state = TestData.getCellData(sheetName,"State",row);
		String email1 = TestData.getCellData(sheetName,"Email",row);
		String email2 = TestData.getCellData(sheetName,"EmailExt",row);
		String email=email1.concat(email2);
		String password = TestData.getCellData(sheetName,"Password",row);
		String PaymentMethod = TestData.getCellData(sheetName,"PaymentMethod",row);
		String firstname = TestData.getCellData(sheetName,"FirstName",row);
		String lastname = TestData.getCellData(sheetName,"LastName",row);
		String Signaturename=firstname+" "+lastname;
		
		String SSN1 = SSN.substring(0, 3);
	    String SSN2 = SSN.substring(3,5);
	    String SSN3 = SSN.substring(5,9);
	    
		
		
	  //driver.get(AppURL);
	    
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		
	
	  driver.get(prop.getProperty("LendNation_URL"));
	  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
	
	  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Opened Lend Nation Portal For Payment ********* ");
	  test.log(LogStatus.INFO, "******************************************************** ");

	  Thread.sleep(2000);
	  
	    driver.findElement(By.linkText("QTP")).click();	
	    test.log(LogStatus.PASS, "Clicked on QTP link ");
	    
	  Thread.sleep(4000);
	 
//========================  Script For Login Through Email =================
	  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
	  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
	  		 
	  Thread.sleep(1000);
	  
	  
//========================  Script For Login Through Email =================

Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
	  test.log(LogStatus.PASS, "User Name Enter as : " +email);

	  Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
	  test.log(LogStatus.PASS, "Password Enter as : " +password);
	  
      Thread.sleep(800);
	  
	  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
	  test.log(LogStatus.PASS, "Clicked on Login");
	  
	  Thread.sleep(10000);
	  
	  Thread.sleep(2000);
	  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
	  Thread.sleep(2000);
	  WebElement element = driver.findElement(By.id("ui-id-1"));

		Actions action = new Actions(driver);

		action.moveToElement(element);
		//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
		//driver.findElement(By.id("ui-id-1")).click();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		action.sendKeys(Keys.PAGE_UP).build().perform();
		 Thread.sleep(500); 

	  driver.findElement(By.id("ui-id-1")).click();		
	  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
	  Thread.sleep(1000);
	  driver.findElement(By.id("cur")).click();
	  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
	  Thread.sleep(1000);

	  
//======================================  Payment Started =======================================================
	 
			 if (driver.findElement(By.xpath("//*[@id='makePay']")).isEnabled()){

					test.log(LogStatus.INFO, "Payment Button Is  Enabled");
					Thread.sleep(500);
					test.log(LogStatus.INFO, "************ Payment Started ************** ");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='makePay']")).click();
					test.log(LogStatus.PASS, "Clicked On Payment Tab");
					Thread.sleep(1000);
					driver.findElement(By.name("mkpayts")).click();
					test.log(LogStatus.PASS, "Clicked On Continue Tab");
					Thread.sleep(8000);
					driver.findElement(By.id("instAmtRad")).click();
					test.log(LogStatus.PASS, "Clicked On Scheduled Payment amount Check box");
					Thread.sleep(500);
					String PaymentAmt = driver.findElement(By.xpath("//*[@id='othAmtTLP']")).getText();
					test.log(LogStatus.PASS, "Payment amount on screen is :"+PaymentAmt);
					Thread.sleep(500);
					driver.findElement(By.name("paymentType")).sendKeys(PaymentMethod);
					test.log(LogStatus.PASS, "Payment type selected as  :"+PaymentMethod);
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
					test.log(LogStatus.PASS, "Clicked On Continue Tab in Payment Screen");
					Thread.sleep(20000);
					Thread.sleep(20000);
					if(driver.findElement(By.xpath("//*[@id='submit']/div[1]/h3/strong")).getText().contains("Your payment has been submitted")){
						test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Completed Successfully");
					}
					else
					{
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>Payment  Completed Successfully ");}
			 }
				else {
				
					test.log(LogStatus.INFO, "Payment Button Is  Disabled");
					test.log(LogStatus.PASS, "Payment Tab Verification Completed");
					test.log(LogStatus.INFO, "******************************************************** ");
					break;
				}
			 
	

	
		Thread.sleep(2000);

	  
		break;
		}
	}
  }
	 catch(Exception e)
	  {
			//test.log(LogStatus.ERROR, "Unable to Login through Email");
			//test.log(LogStatus.ERROR, "Error message  " +e);
			  String screenshotPath = getScreenhot(driver, "OnlineLogin");
			  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
			Assert.assertTrue(false);
	
}
  
  }
	public static void esignature_moilp(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.moilp_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void wiilp_loancapture(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  if( driver.findElement(By.xpath("//*[@id='loadDatas0']/div[1]/div/p")).isDisplayed())
		  {
		  String loan_num=driver.findElement(By.xpath("//*[@id='loadDatas0']/div[1]/div/p")).getText();
		 // String loan_num="Loan 12345";
			loan_num=Character.toString(loan_num.charAt(5))+
					Character.toString(loan_num.charAt(6))+
					Character.toString(loan_num.charAt(7))+
					Character.toString(loan_num.charAt(8))+
					Character.toString(loan_num.charAt(9))+
					Character.toString(loan_num.charAt(10))+
					Character.toString(loan_num.charAt(11))+
					Character.toString(loan_num.charAt(12)).trim();
		  
	        loan_number=loan_num;
		  
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial>Loan Number is: " +loan_number);
		  Thread.sleep(500);
		  String app_date=driver.findElement(By.xpath("//*[@id='payDueundefined']")).getText();
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial>Application Date is: " +app_date);
		  String App_Status=driver.findElement(By.xpath("//*[@id='currentBalundefined']")).getText();
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial>Application Status is: " +App_Status);
		  }
		  else
			{
			test.log(LogStatus.FAIL, " Loan Number is not displayed");
			}
		 
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial>Loan Capturing Completed ");
			test.log(LogStatus.INFO, "******************************************************** ");
			
			Thread.sleep(5000);
			driver.close();
			
		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void OKILP_ACH_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.okilp_ach_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void OKILP_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.okilp_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void ililp_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.ililp_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	
	
	public static void esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(800);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.wiilp_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Your loan was originated successfully");
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void wi_dc_ach_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(2000);
	  
		  driver.findElement(By.xpath("/html/body/div/div/div/a[3]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.wiilp_dc_ach_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			

		  
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
public static void il_ilp_dc_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(6000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.ililp_dc_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			Thread.sleep(1000);
			driver.close();
			Thread.sleep(1000);
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
public static void il_ilp_cashatstore_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(6000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.ililp_cashatstore_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			Thread.sleep(1000);
			driver.close();
			Thread.sleep(1000);
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
	
	public static void wi_ilp_cashatstore_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(6000);
	  
		    driver.findElement(By.linkText("QTP")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.wiilp_cashatstore_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			Thread.sleep(1000);
			driver.close();
			Thread.sleep(1000);
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				Assert.assertTrue(false);
		
 }
	  
	  }
public static void wi_ilp_dc_cashatstore_esignature(String SSN,String AppURL) throws Exception	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("OnlineLogin");
				String sheetName="OnlineLogin";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);

			if(SSN.equals(RegSSN))
			{	
				
			String state = TestData.getCellData(sheetName,"State",row);
			String email1 = TestData.getCellData(sheetName,"Email",row);
			String email2 = TestData.getCellData(sheetName,"EmailExt",row);
			String email=email1.concat(email2);
			String password = TestData.getCellData(sheetName,"Password",row);
			
			String SSN1 = SSN.substring(0, 3);
		    String SSN2 = SSN.substring(3,5);
		    String SSN3 = SSN.substring(5,9);
		    
			
			
		  //driver.get(AppURL);
		    
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			
		
		  driver.get(prop.getProperty("LendNation_URL"));
		  test.log(LogStatus.PASS, "Opened Lend Natinon URL  "+AppURL);
		
		  test.log(LogStatus.PASS, "<FONT color=green style=Arial> ********* Login Lend Nation Portal For Esignature ********* ");
		  test.log(LogStatus.INFO, "******************************************************** ");

		  Thread.sleep(6000);
	  
		  driver.findElement(By.xpath("/html/body/div/div/div/a[3]")).click();	
		    test.log(LogStatus.PASS, "Clicked on QTP link ");
		    
		  Thread.sleep(4000);
		 
//========================  Script For Login Through Email =================
		  driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")).click();
		  test.log(LogStatus.PASS, "Clicked on SignIn Link ");
		  		 
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='Username']")).sendKeys(email);
		  test.log(LogStatus.PASS, "User Name Enter as : " +email);

		  Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		  test.log(LogStatus.PASS, "Password Enter as : " +password);
		  
          Thread.sleep(500);
		  
		  driver.findElement(By.xpath("//*[@id='loginForm']/div[7]/button")).click();
		  test.log(LogStatus.PASS, "Clicked on Login");
		  
		  Thread.sleep(10000);
		  
		  Thread.sleep(2000);
		  test.log(LogStatus.INFO, "****************** Now in My Dashboard Page ************************");
		  Thread.sleep(2000);
		  WebElement element = driver.findElement(By.id("ui-id-1"));

			Actions action = new Actions(driver);

			action.moveToElement(element);
			//driver.findElement(locator(prop.getProperty("first_scrolling_area"))).click();
			//driver.findElement(By.id("ui-id-1")).click();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			action.sendKeys(Keys.PAGE_UP).build().perform();
			 Thread.sleep(500); 

		  driver.findElement(By.id("ui-id-1")).click();		
		  test.log(LogStatus.PASS, "Clicked on Bank Verification Tab" );
		  Thread.sleep(1000);
		  driver.findElement(By.id("pen")).click();
		  test.log(LogStatus.PASS, "Clicked on Pending Loans Tab" );
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='needEsign']")).click();
		  test.log(LogStatus.PASS, "Clicked on Need Esign Tab");
		  
		  Thread.sleep(20000);
		  
		  test.log(LogStatus.INFO, "****** Navigating to Sign Contract Page ****** ");
		  		  
		  LendNationSignContract.wiilp_dc_cashatstore_signContract(SSN, AppURL);
		
		

			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Esign Completed Successfully with SSN : " +SSN);
			test.log(LogStatus.INFO, "******************************************************** ");
			Thread.sleep(1000);
			
			break;
			}
		}
	  }
		 catch(Exception e)
		  {
				test.log(LogStatus.ERROR, "Unable to Login through Email");
				test.log(LogStatus.ERROR, "Error message  " +e);
				  String screenshotPath = getScreenhot(driver, "OnlineLogin");
				  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
				  Assert.assertTrue(false);
		
 }
	  
	  }
	

}
