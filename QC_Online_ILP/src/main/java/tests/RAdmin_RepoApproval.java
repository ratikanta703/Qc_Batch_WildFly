package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class RAdmin_RepoApproval extends QCStore{
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;


	public static void repoapproval(WebDriver driver,String SSN,String AppURL)
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
				String RepoRequest = TestData.getCellData(sheetName,"RepoRequest",row);
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
				test.log(LogStatus.INFO,"Admin Login For Repo Approval"+ AdminURL);



	
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
	Thread.sleep(2000);
	driver.findElement(By.linkText("Repo Approval Inbox")).click();
	test.log(LogStatus.PASS, "Clicked on Repo Approval");
	Thread.sleep(2000);
	driver.findElement(By.linkText("Search")).click();
	test.log(LogStatus.PASS, "Clicked on Repo Approval Search Link");
	
	//Thread.sleep(5000);
	
	//==================================================================
	Thread.sleep(3000);
	test.log(LogStatus.INFO, "Repo Approval Process Started");
	
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
	
	driver.findElement(By.id("viewAppl")).click();
	test.log(LogStatus.PASS, "Clicked on View Application Check Box");	
	Thread.sleep(500);
	driver.findElement(By.id("bnkScrub")).click();
	test.log(LogStatus.PASS, "Clicked on Bankruptcy Scrub Check Box");	
	Thread.sleep(500);	
	driver.findElement(By.id("titleLienCb")).click();
	test.log(LogStatus.PASS, "Clicked on View Title with Lien Check Box");	
	Thread.sleep(500);
	driver.findElement(By.name("button1")).click();
	test.log(LogStatus.PASS, "Clicked on View Contact Check Box");	
	Thread.sleep(8000);	
	driver.findElement(By.xpath("//input[@value='Close' and @type='button']")).click();
	test.log(LogStatus.PASS, "Clicked on View Contact Check Box Closed");
	Thread.sleep(800);	
	driver.findElement(By.name("button2")).click();
	test.log(LogStatus.PASS, "Clicked on View Pay History Check Box");	
	Thread.sleep(8000);	
	
//===========================================================
	
		    String mainwindow=driver.getWindowHandle();
		    for(String winHandle1 : driver.getWindowHandles()){
				if(!mainwindow.equalsIgnoreCase(winHandle1))
				{
			    driver.switchTo().window(winHandle1);
			    			   
				Thread.sleep(2000);			    							   				
		        driver.close();
				break;
				}
		    }
		    Thread.sleep(1000);
				driver.switchTo().window(mainwindow);
				driver.switchTo().defaultContent();
				
				driver.switchTo().frame("mainFrame");
				
				driver.switchTo().frame("main");
				
	Thread.sleep(1000);	
	driver.findElement(By.name("button3")).click();
	test.log(LogStatus.PASS, "Clicked on Vehicle Condition Report Check Box");
	Thread.sleep(8000);	
	String mainwindow2=driver.getWindowHandle();
    for(String winHandle1 : driver.getWindowHandles()){
		if(!mainwindow.equalsIgnoreCase(winHandle1))
		{
	    driver.switchTo().window(winHandle1);
	    			   
		Thread.sleep(2000);			    							   				
        driver.close();
		break;
		}
    }
    Thread.sleep(1000);
		driver.switchTo().window(mainwindow);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("mainFrame");
		
		driver.switchTo().frame("main");
		Thread.sleep(1000);	
		driver.findElement(By.name("button4")).click();
		test.log(LogStatus.PASS, "Clicked on Clarity Check Box");		
    Thread.sleep(8000);	
    driver.findElement(By.xpath("//input[@value='Right To Cure Letter' and @type='button']")).click();
	test.log(LogStatus.PASS, "Clicked on Right to Cure Check Box");
	Thread.sleep(3000);
	try { 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//if alert present, accept and move on.														
	}
	catch (NoAlertPresentException e) {
		//do what you normally would if you didn't have the alert.
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@value='Co-Owner Consent' and @type='button']")).click();
	test.log(LogStatus.PASS, "Clicked on Coowner Consent Check Box");
	Thread.sleep(3000);
	try { 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//if alert present, accept and move on.														
	}
	catch (NoAlertPresentException e) {
		//do what you normally would if you didn't have the alert.
	}
	Thread.sleep(3000);
//============================================================
	
	
	driver.findElement(By.name("approveBtn")).click();
	test.log(LogStatus.PASS, "clicked on Approved Button"); 			
	Thread.sleep(5000);			
	driver.findElement(By.name("Ok")).click();
	test.log(LogStatus.PASS, "Transaction Completed Successfully");
	Thread.sleep(1000);
	test.log(LogStatus.PASS, "<FONT color=green style=Arial> New Repo Request Approved Successfully ");
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
					test.log(LogStatus.FAIL,"Repo Request in Admin is failed");

				}

	}
}
