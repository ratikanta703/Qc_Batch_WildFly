package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class RAdmin_Repo_Validation extends QCStore{
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;


	public static void repovalidation(WebDriver driver,String SSN,String AppURL)
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
				test.log(LogStatus.INFO,"Admin Login For Repo Request"+ AdminURL);



	
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
	//------------------------	
	break;
    }	
	}							
				Select dropdown = new Select(driver.findElement(By.name("requestBean.repoStatusId")));
			    //Get all options
			    List<WebElement> dd = dropdown.getOptions();

			    //Total numbe of options
			    System.out.println(dd.size());

			    // Loop to print one by one
			    for (int j = 0; j <= dd.size(); j++) {
			    	
			    	String option=dd.get(j).getText();
			    	System.out.println(option);			    			    
					if (option.trim().equalsIgnoreCase("Repo".trim())) {
						test.log(LogStatus.INFO, "<FONT color=green style=Arial>Option Available Is : " +option);
						test.log(LogStatus.INFO, "******************************************************** ");
						System.out.println(option);										
						Thread.sleep(1000);																
						 break;
				} 			    	
					else {
					test.log(LogStatus.INFO, "<FONT color=green style=Arial>Options available in dropdown are : " +option);												    
}
				
}
			    break;
}	
			
}	
				catch (Exception e) {
					// TODO Auto-generated catch block
					
					//e.printStackTrace();
					//test.log(LogStatus.FAIL,"Repo Request in Admin is failed");

}		
	driver.close();
	test.log(LogStatus.INFO, "******************************************************** ");
}
	
}
