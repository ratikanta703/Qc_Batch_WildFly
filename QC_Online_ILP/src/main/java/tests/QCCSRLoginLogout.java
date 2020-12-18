package tests;

import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.QCStore;

public class QCCSRLoginLogout extends QCStore
{
	public static void login(String SSN,String AppURL)
	{
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String csr_url = TestData.getCellData(sheetName,"AppURL",row);

					String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);
					/*username = prop.getProperty("LOC_UserName");
					password = prop.getProperty("LOC_Password");
					store_id = prop.getProperty("LOC_StoreId");*/
					
					


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO,"CSR login has started");

						test.log(LogStatus.INFO,"Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO,"CSR Application is launched");

						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
						}
						else
						{
							String Node = "http://192.168.2.66:5555/wd/hub";
							 //String Node2 = "http://192.168.0.238:5566/wd/hub";
							 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
							 driver = new RemoteWebDriver(new URL(Node), cap);	
						}
						 wait = new WebDriverWait(driver, 40000);
						

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
				        
				       Thread.sleep(8000);
				       break;
}
					
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		test.log(LogStatus.FAIL,"CSR login is failed");

		e.printStackTrace();
	}

}
	
	public static void nvtlp_login(String SSN,String AppURL)
	{
		try{
			//String FileName= prop.getProperty("QC_Store_NewLoan_file_name");
			
			//ExcelNew TestData = new ExcelNew(System.getProperty("user.dir")+prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");  		 
				int lastrow=TestData.getLastRow("Login");
				String sheetName="Login";

				for(int row=2;row<=lastrow;row++)
				{		
					String RegSSN = TestData.getCellData(sheetName,"SSN",row);
					//String csr_url = TestData.getCellData(sheetName,"AppURL",row);

					/*String username = TestData.getCellData(sheetName,"UserName",row);
					String password = TestData.getCellData(sheetName,"Password",row);
					String store_id = TestData.getCellData(sheetName,"StoreID",row);*/
					username = prop.getProperty("NVTLP_UserName");
					password = prop.getProperty("NVTLP_Password");
					store_id = prop.getProperty("NVTLP_StoreId");
					
					


					if(SSN.equals(RegSSN))
					{	
				
						//test.log(LogStatus.INFO, "Opened the CSR URL " +AppURL);
						test.log(LogStatus.INFO,"CSR login has started");

						test.log(LogStatus.INFO,"Opened the CSR URL " +csr_url);


						//test.log(LogStatus.INFO, "CSR Application is launched " );
						test.log(LogStatus.INFO,"CSR Application is launched");

						if(prop.getProperty("login_method").equalsIgnoreCase("local"))
						{
							driver = new InternetExplorerDriver();
						}
						else
						{
							String Node = "http://192.168.2.66:5555/wd/hub";
							 //String Node2 = "http://192.168.0.238:5566/wd/hub";
							 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
							 driver = new RemoteWebDriver(new URL(Node), cap);	
						}
						 wait = new WebDriverWait(driver, 40000);
						

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
				        
				       Thread.sleep(8000);
				       break;
}
					
	}
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		test.log(LogStatus.FAIL,"CSR login is failed");

		e.printStackTrace();
	}

}
	
public static void logout(String SSN,String AppURL){
		
						
				try{
					
					
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
					 Thread.sleep(5000);		
			driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     if(driver.getTitle().contains("Login")){
			    	 test.log(LogStatus.PASS, "Logout is Successfully"); 
			    	 test.log(LogStatus.INFO,"loggged out from the CSR Application");
			    	 Thread.sleep(5000);
			    	 test.log(LogStatus.INFO, "******************************************************** ");
			     driver.close();
			    	 //driver.quit();
			    	 Thread.sleep(5000);
			     }
			    else{
			    	 test.log(LogStatus.PASS, "Logout was Successfull"); 
			     }


			     	
			}
						
			
		
		
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Logout was Successfull"); 

			e.printStackTrace();
		}
	
	
	
}	
//}

public static void adminLogin(String SSN,String AppURL){
	
	
	try{
		int lastrow=TestData.getLastRow("Login");
		String sheetName="Login";

		for(int row=2;row<=lastrow;row++)
		{		
			String RegSSN = TestData.getCellData(sheetName,"SSN",row);
			if(SSN.equals(RegSSN))
			{
			String UserName = TestData.getCellData(sheetName,"AdminUserName",row);
			String Password = TestData.getCellData(sheetName,"AdminPassword",row);
			//String AdminURL = TestData.getCellData(sheetName,"AdminURL",row);
			

			//test.log(LogStatus.INFO, MarkupHelper.createLabel("Admin Application is launched", ExtentColor.BLUE));
			test.log(LogStatus.INFO, "********Admin Application is launched********");


			if(prop.getProperty("login_method").equalsIgnoreCase("local"))
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

			driver.findElement(By.name("loginRequestBean.userId")).sendKeys(UserName);

			test.log(LogStatus.PASS, "Username is entered: "+UserName); 

			driver.findElement(By.name("loginRequestBean.password")).sendKeys(Password);

			test.log(LogStatus.PASS, "Password is entered: "+Password); 

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
