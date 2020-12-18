/*package tests;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;*/
//===================================================================================================
package tests;


import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.relevantcodes.extentreports.Status;
/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.LogStatus;



public class QCCSRLoginLogout extends QCStore
{

	public static void login(String SSN,String AppURL) throws Exception
	/*{
		try{
			String FileName= prop.getProperty("file_name1");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("Login_Logout");
				String sheetName="Login_Logout";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
*/
	
	
	
	
	
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Login_Logout");
				String sheetName="Login_Logout";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					
				    
						
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
	
	
	public static void PAMLogin(String SSN,String AppURL) throws Exception
	/*{
		try{
			String FileName= prop.getProperty("file_name1");
			
			ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("Test_data_sheet_path")+FileName);  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String admin_url = TestData.getCellData(sheetName,"AdminURL",row);
*/
	
	{
		 
		try{
			//String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("PAM");
				String sheetName="PAM";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					String username2 = TestData.getCellData(sheetName,"UserName2",row);
					String password2 = TestData.getCellData(sheetName,"Password2",row);
					String store_id2 = TestData.getCellData(sheetName,"StoreID2",row);
					String application_status = TestData.getCellData(sheetName,"ApplicationStatus",row);
					String comments = TestData.getCellData(sheetName,"Comments",row);
					String last_four_account_no = TestData.getCellData(sheetName,"LastFourAccountNo",row);
					String ProductType = TestData.getCellData(sheetName,"ProductType",row);
					String ReceiveType = TestData.getCellData(sheetName,"ReceiveType",row);
					
					   //String  last_four_account_no=SSN.substring(SSN.length() - 4);


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO, "Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO, "*******CSR Application is launched For Loan Approval*******");

						driver = new InternetExplorerDriver();
						WebDriverWait wait = new WebDriverWait(driver, 30000);

						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
					
						driver.get(csr_url);
						
					if(ReceiveType.equalsIgnoreCase("ACH"))	{
						
					    driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username);
				        test.log(LogStatus.PASS, "Username is entered: "+username);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password);
				        test.log(LogStatus.PASS, "Password is entered: "+password);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");
				        
				       Thread.sleep(5000);
					}
				    
					else if(ReceiveType.equalsIgnoreCase("Cash At Store")){
						driver.findElement(locator(prop.getProperty("csr_username"))).sendKeys(username2);
				        test.log(LogStatus.PASS, "Username is entered: "+username2);
				        
				        

					    driver.findElement(locator(prop.getProperty("csr_password"))).clear();
					    driver.findElement(locator(prop.getProperty("csr_password"))).sendKeys(password2);
				        test.log(LogStatus.PASS, "Password is entered: "+password2);
				        
				       
				        driver.findElement(locator(prop.getProperty("csr_storeid"))).sendKeys(store_id2);;
				        test.log(LogStatus.PASS, "Storenumber is entered: "+store_id2);
				        //Click Login Button
				        driver.findElement(locator(prop.getProperty("csr_login_button"))).click();
				        test.log(LogStatus.PASS, "Clicked on login button");	
						
						
					}
					
		
		
		break;
	}
				}
		}
	
					catch(Exception e)
					  {
						  test.log(LogStatus.ERROR, "Unable to complete  CSR with SSN and Loan Number : " +SSN+","+loan_number);
						  test.log(LogStatus.ERROR, "Error message  " +e);
						  String screenshotPath = getScreenhot(driver, "QCCSRLoginLogout");
						  test.log(LogStatus.ERROR, "Screen message  " +test.addScreenCapture(screenshotPath));
							System.out.println(e);
	
}
	}
	
//==================================== For Logout =============================================	
	
              public static void logout(String SSN,String AppURL){
							
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					 Thread.sleep(5000);		
			       //driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     driver.findElement(By.xpath("//a[@href='/cc/logout.do']")).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     if(driver.getTitle().contains("Login")){
			    	// test.log(LogStatus.PASS, "Logout is Successfully");
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			    	 test.log(LogStatus.INFO,"loggged out from the CSR Application");
			    	 Thread.sleep(5000);
			     driver.close();
			    	 //driver.quit();
			    	 Thread.sleep(10000);
			     }
			    else{
			    	 //test.log(LogStatus.PASS, "Logout was Successfull"); 
			    	 test.log(LogStatus.PASS, "<FONT color=green style=Arial> Logout Successfully ");
			     }


			     	
			}
						
			
		
		
		catch(Exception e)
		{
			test.log(LogStatus.ERROR,"CSR logout is failed");

			e.printStackTrace();
		}
	
	
	
}	

//============================ For Admin Logout ===============================
              public static void adminLogin(String SSN,String AppURL){
					
					
          		try{
          			int lastrow=TestData.getLastRow("Login");
          			String sheetName="Login";

          			for(int row=2;row<=lastrow;row++)
          			{		
          				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
          				if(SSN.equals(RegSSN))
          				{
          					//AdminUserName= prop.getProperty("admin_userid");
          					//AdminPassword= prop.getProperty("admin_password");

          				//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
          				test.log(LogStatus.INFO, "********Admin Application is launched********");


          				if(Rprop.getProperty("login_method").equalsIgnoreCase("local"))
          				{
          					driver = new InternetExplorerDriver();
          				}
          				else
          				{
          					String Node = "http://192.168.2.164:5555/wd/hub";
          					 //String Node2 = "http://192.168.0.238:5566/wd/hub";
          					 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
          					 driver = new RemoteWebDriver(new URL(Node), cap);	
          				}
          				wait = new WebDriverWait(driver, 40000);

          				driver.manage().window().maximize();
          				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          			
          				driver.get(AdminURL);

          				driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

          				test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

          				driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

          				test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

          				//Click Login Button

          				driver.findElement(By.name("login")).click();

          				test.log(LogStatus.PASS, "Clicked on Submit button");
          				break;

          }
          					
          	}
          	}
          	catch (Exception e) {
          		// TODO Auto-generated catch block
          		//test.log(LogStatus.FAIL, MarkupHelper.createLabel("CSR login is failed", ExtentColor.RED));
          		test.log(LogStatus.FAIL,"Admin login is failed");


          		e.printStackTrace();
          	}


          	
          }	
public static void Adminlogout(String SSN,String AdminURL){
	try{
		
		
		driver.switchTo().defaultContent();
		 driver.switchTo().frame("topFrame");
		
driver.findElement(locator(prop.getProperty(("admin_logout_link")))).click();
     test.log(LogStatus.PASS, "Clicked On logout Button");
     if(driver.getTitle().contains("Login")){
    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
    	 test.log(LogStatus.INFO,"loggged out from the Admin Application");
    	 Thread.sleep(5000);
     //driver.close();
    	 driver.quit();
     }
    else{
    	 test.log(LogStatus.PASS, "Logout was unsuccessfull"); 
     }


     	
}
			



catch(Exception e)
{
test.log(LogStatus.ERROR,"CSR logout is failed");

e.printStackTrace();
}
}
}

//}
