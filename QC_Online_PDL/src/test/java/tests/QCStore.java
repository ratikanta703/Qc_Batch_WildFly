package tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//This  is an executable class file.(Execution starts from here)
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static Properties Jprop;

	public static Properties Aprop;
	public static Properties Vprop;
	public static String accrual_date;
	public static String sstore_date;
	public static String curr_date;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentReports Breports;
	public static ExtentReports Jreports;
	public static ExtentReports Rreports;
	public static ExtentReports Areports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String username;
	public static String password;
	public static String store_id;
	public static String DBUserName;
	public static String DBPassword;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String adjint_transnum = null;
	
	public static String FileName;

	public static ExcelNew TestData;
	public static String LOCamount;
	public static String Statementdate;
	public static String currentdate;
	
	
	public static String loan_nbr;
	public static String Updated_Adjusted_Amount;
	
	
	
	public static String key;
	public static String NextDueDate;
	public static String Payment_date;
	
	
	public static String AppURL = "https://qclocalreg.qfund.net/cc/demoIndex.do";
	public static String business_date;

	public static String Duedate_confirm_text3;
	public static String No_of_Installments;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String appdate;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String Drawer_OverShort_Amount;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;
	public static String passwrd;
	public static String FirstName;

	public static String AdminURL;

	public static String csr_url;
	public static String csrloginpage;
	public static String AdminUserName;
	public static String AdminPassword;
	
	//public static String Tran_Nbr;
	
	
   //*****************************************************************************************************
   //=================================== ONLINE SPRINT SCENARIOS STARTS =========================================
    
   
 //=======================================  ON LINE MO PDL // SSN = 993838207-993838208 Acct No = 0043-0044================================================ 
   
	// Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
    
   @Test(priority = 1, groups = "Ratikanta_Online_MOPDL")
    	public static void QC_Sprint_Online_MOPDL_ACH_CashAtStore_Txn_Testdata() throws Exception {
 	  
  	  try {
  		 test = reports.startTest(("QC_Online_MOPDL_ACH_ReceiveType As CashAtStore"),  					  		    
  	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 118 Store");
  	   			String FileName = "QC_Sprint_Online_MOPDL_ACH_CashAtStore_Txn_Testdata.xls";
  			
  			TestData = new ExcelNew(System.getProperty("user.dir")
    					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			// int lastrow=TestData.getLastRow("Borrower");
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				// System.out.println(RunFlag);
  				if (RunFlag.equals("Y")) {
  					
  				String SSN = TestData.getCellData(sheetName, "SSN", row);
  				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
  				System.out.println(AppURL); 							 				
  				
  				LendNationRegistration.registration(SSN, AppURL);
  				LendNationPersonalInformation.personalInformation(SSN, AppURL);
  			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
  			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
  				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
  			    LendNationSignContract.signContract(SSN, AppURL);
  				          				
  			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
  			    {		  				
  				QCCSR_PAM.CashAtStore(SSN, AppURL);
  				
  				QCCSR_PAM.PAMLogin(SSN, AppURL);
  				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
  			    }
  			
  			else{
  				QCCSR_PAM.PAMLogin(SSN, AppURL);
  				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
  				
  			    }
  					
    }
    }
    }
    
  	 catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOPDL_ACH_CashAtStore_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOPDL_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
 		
 		}
  	}
  
    
  //=======================================  ON LINE MO PDL // SSN = 993838204-993838206 // Acct No = 0041-0042 ================================================ 
   
    	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
     
   @Test(priority = 2, groups = "Ratikanta_Online_MOPDL")
     	public static void QC_Sprint_Online_MOPDL_ACH_Txn_Testdata() throws Exception {
 	  
   	  try {
   		 test = reports.startTest(("QC_Online_MOPDL_ACH_ReceiveType As ACH"),  					  		    
   	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
   	   			String FileName = "QC_Sprint_Online_MOPDL_ACH_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 							 				
   				
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
   			    LendNationSignContract.signContract(SSN, AppURL);
   				          				
   			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
   			    {		  				
   				QCCSR_PAM.CashAtStore(SSN, AppURL);
   				
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   			    }
   			
   			else{
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   				
   			    }
   					
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOPDL_ACH_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOPDL_ACH_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
     	
     //=======================================  ON LINE MO PDL // SSN = 993838209-993838210 Acct No = 0045-0046================================================ 
        
    	// Receive Type as : "ACH" and Repayment Method  as  : "Debit Card" 
     
   @Test(priority = 3, groups = "Ratikanta_Online_MOPDL")
     	public static void QC_Sprint_Online_MOPDL_DC_ACH_Txn_Testdata() throws Exception {
 	  
   	  try {
   		 test = reports.startTest(("QC_Online_MOPDL_DC_ReceiveType As ACH"),  					  		    
   	   			"Lend Nation Login->Generate Online PDL Loan With DC-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
   	   			String FileName = "QC_Sprint_Online_MOPDL_DC_ACH_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 							 				
   				
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
   			    LendNationSignContract.signContract(SSN, AppURL);
   				          				
   			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
   			    {		  				
   				QCCSR_PAM.CashAtStore(SSN, AppURL);
   				
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   			    }
   			
   			else{
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   				
   			    }
   					
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOPDL_DC_ACH_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOPDL_DC_ACH_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
     	
//=======================================  ON LINE MO PDL // SSN = 993838211-993838212 Acct No = 0047-0048================================================ 
        
    	// Receive Type as : "Cash At Store" and Repayment Method  as  : "Debit Card" 
     
   @Test(priority = 4, groups = "Ratikanta_Online_MOPDL_1")
     	public static void QC_Sprint_Online_MOPDL_DC_CashAtStore_Txn_Testdata() throws Exception {
 	  
   	  try {
   		 test = reports.startTest(("QC_Online_MOPDL_DC_ReceiveType As CashAtStore"),  					  		    
   	   			"Lend Nation Login->Generate Online PDL Loan With DC-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 118 Store");
   	   			String FileName = "QC_Sprint_Online_MOPDL_DC_CashAtStore_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 							 				
   				
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
   			    LendNationSignContract.signContract(SSN, AppURL);
   				          				
   			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
   			    {		  				
   				QCCSR_PAM.CashAtStore(SSN, AppURL);
   				
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   			    }
   			
   			else{
   				QCCSR_PAM.PAMLogin(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   				
   			    }
   					
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOPDL_DC_CashAtStore_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOPDL_DC_CashAtStore_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
    
   
 //=======================================  ON LINE IL PDL // SSN = 993838213-993838214 Acct No = 0049-0050================================================ 
   
 	// Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
     
    @Test(priority = 1, groups = "Ratikanta_Online_ILPDL")
     	public static void QC_Online_ILPDL_ACH_CashAtStore_Txn_Testdata() throws Exception {
  	  
   	  try {
   		 test = reports.startTest(("QC_Online_ILPDL_ACH_ReceiveType As CashAtStore"),  					  		    
   	   			"Lend Nation Login-->Registration-->Generate Online IL PDL Loan-->Loan Approved-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Complete Loan in 455 Store");
   	   			String FileName = "QC_Online_ILPDL_ACH_CashAtStore_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 							 				
   				
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.ilpdl_loandecision(SSN, AppURL);	  				  		
   				LendNationLoggin.ilpdl_loancapture(SSN, AppURL);
   				
   				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
   				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
   				       				  				        
   				LendNationLoggin.il_pdl_cashatstore_esignature(SSN, AppURL);
   				    				
   				QCCSR_PAM.PAMLogin_with_455(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   		
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Online_ILPDL_ACH_CashAtStore_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Online_ILPDL_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
    
    
  //=======================================  ON LINE IL PDL // SSN = 993838215-993838216	 Acct No = 0051-0052================================================ 
    
  	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
      
     @Test(priority = 2, groups = "Ratikanta_Online_ILPDL")
      	public static void QC_Online_ILPDL_ACH_Txn_Testdata() throws Exception {
   	  
    	  try {
    		 test = reports.startTest(("QC_Online_ILPDL_ACH_ReceiveType As CashAtStore"),  					  		    
    	   			"Lend Nation Login-->Registration-->Generate Online IL PDL Loan-->Loan Approved-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Loan Orgination Completed");
    	   			String FileName = "QC_Online_ILPDL_ACH_Txn_Testdata.xls";
    			
    			TestData = new ExcelNew(System.getProperty("user.dir")
      					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

    			
    			int lastrow = TestData.getLastRow("Start");
    			String sheetName = "Start";
    			// int lastrow=TestData.getLastRow("Borrower");
    			System.out.println(lastrow);
    			for (int row = 2; row <= lastrow; row++) {

    				String RunFlag = TestData.getCellData(sheetName, "Run", row);
    				// System.out.println(RunFlag);
    				if (RunFlag.equals("Y")) {
    					
    				String SSN = TestData.getCellData(sheetName, "SSN", row);
    				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
    				System.out.println(AppURL); 							 				
    				
    				LendNationRegistration.registration(SSN, AppURL);
    				LendNationPersonalInformation.personalInformation(SSN, AppURL);
    			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
    			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
    				LendNationLoanDecision.ilpdl_loandecision(SSN, AppURL);	  				  		
    				LendNationLoggin.ilpdl_loancapture(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
    				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
    				
    				LendNationLoggin.esignature(SSN, AppURL);
    				       				  				        
    				    		
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Online_ILPDL_ACH_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Online_ILPDL_ACH_Txn_Testdata Transaction Failed ");			
   		
   		}
    	}
     
     
   //=======================================  ON LINE IL PDL // SSN = 993838217-993838218 Acct No = 0053-0054================================================ 
     
  	// Receive Type as : "Cash At Store" and Repayment Method  as  : "Debit Card" 
      
     @Test(priority = 3, groups = "Ratikanta_Online_ILPDL")
      	public static void QC_Online_ILPDL_DC_CashAtStore_Txn_Testdata() throws Exception {
   	  
    	  try {
    		 test = reports.startTest(("QC_Online_ILPDL_DC_ReceiveType As CashAtStore"),  					  		    
    	   			"Lend Nation Login-->Registration-->Generate Online IL PDL Loan With DC-->Loan Approved-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Complete Loan in 455 Store");
    	   			String FileName = "QC_Online_ILPDL_DC_CashAtStore_Txn_Testdata.xls";
    			
    			TestData = new ExcelNew(System.getProperty("user.dir")
      					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

    			
    			int lastrow = TestData.getLastRow("Start");
    			String sheetName = "Start";
    			// int lastrow=TestData.getLastRow("Borrower");
    			System.out.println(lastrow);
    			for (int row = 2; row <= lastrow; row++) {

    				String RunFlag = TestData.getCellData(sheetName, "Run", row);
    				// System.out.println(RunFlag);
    				if (RunFlag.equals("Y")) {
    					
    				String SSN = TestData.getCellData(sheetName, "SSN", row);
    				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
    				System.out.println(AppURL); 							 				
    				
    				LendNationRegistration.registration(SSN, AppURL);
    				LendNationPersonalInformation.personalInformation(SSN, AppURL);
    			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
    			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
    				LendNationLoanDecision.ilpdl_loandecision(SSN, AppURL);	  				  		
    				LendNationLoggin.ilpdl_loancapture(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
    				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
    				       				  				        
    				LendNationLoggin.il_pdl_cashatstore_esignature(SSN, AppURL);
    				    				
    				QCCSR_PAM.PAMLogin_with_455(SSN, AppURL);
    				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
    		
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Online_ILPDL_DC_CashAtStore_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Online_ILPDL_DC_CashAtStore_Txn_Testdata Transaction Failed ");			
   		
   		}
    	}
     
     
     //======================================= ON LINE IL PDL // SSN = 993838219-993838220 Acct No = 0055-0056================================================ 
     //sometimes we are getting error in Sign Contract page "An Application Error Has Occurred"
   	// Receive Type as : "ACH" and Repayment Method  as  : "Debit Card" 
       
      @Test(priority = 4, groups = "Ratikanta_Online_ILPDL")
       	public static void QC_Online_ILPDL_DC_ACH_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_ILPDL_DC_ReceiveType As ACH"),  					  		    
     	   			"Lend Nation Login-->Registration-->Generate Online IL PDL Loan With DC-->Loan Approved-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Loan Orgination Completed");
     	   			String FileName = "QC_Online_ILPDL_DC_ACH_Txn_Testdata.xls";
     			
     			TestData = new ExcelNew(System.getProperty("user.dir")
       					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

     			
     			int lastrow = TestData.getLastRow("Start");
     			String sheetName = "Start";
     			// int lastrow=TestData.getLastRow("Borrower");
     			System.out.println(lastrow);
     			for (int row = 2; row <= lastrow; row++) {

     				String RunFlag = TestData.getCellData(sheetName, "Run", row);
     				// System.out.println(RunFlag);
     				if (RunFlag.equals("Y")) {
     					
     				String SSN = TestData.getCellData(sheetName, "SSN", row);
     				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
     				System.out.println(AppURL); 							 				
     				
     				LendNationRegistration.registration(SSN, AppURL);
     				LendNationPersonalInformation.personalInformation(SSN, AppURL);
     			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
     			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
     				LendNationLoanDecision.ilpdl_loandecision(SSN, AppURL);	  				  		
     				LendNationLoggin.ilpdl_loancapture(SSN, AppURL);
     				
     				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
     				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
     				
     				LendNationLoggin.ilpdl_dc_ach_esignature(SSN, AppURL);
     				       				  				        
     				    		
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Online_ILPDL_DC_ACH_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Online_ILPDL_DC_ACH_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
    
    
    
    
  //=======================================  ON LINE TX PDL // SSN = 993838221-993838222 Acct No = 0057-0058================================================ 
    
  	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
      
     @Test(priority = 1, groups = "Ratikanta_Online_TXPDL")
      	public static void QC_Online_TXPDL_ACH_Txn_Testdata() throws Exception {
   	  
    	  try {
    		 test = reports.startTest(("QC_Online_TXPDL_ACH_ReceiveType As ACH"),  					  		    
    	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store) -->Complete Loan in 2997 Store");
    	   			String FileName = "QC_Online_TXPDL_ACH_Txn_Testdata.xls";
    			
    			TestData = new ExcelNew(System.getProperty("user.dir")
      					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

    			
    			int lastrow = TestData.getLastRow("Start");
    			String sheetName = "Start";
    			// int lastrow=TestData.getLastRow("Borrower");
    			System.out.println(lastrow);
    			for (int row = 2; row <= lastrow; row++) {

    				String RunFlag = TestData.getCellData(sheetName, "Run", row);
    				// System.out.println(RunFlag);
    				if (RunFlag.equals("Y")) {
    					
    				String SSN = TestData.getCellData(sheetName, "SSN", row);
    				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
    				System.out.println(AppURL); 							 				
    				
    				LendNationRegistration.registration(SSN, AppURL);
    				LendNationPersonalInformation.personalInformation(SSN, AppURL);
    			    LendNationFinancialInformation.txpdlfinancialInformation(SSN, AppURL);
    			    LendNationRepaymentInformation.txpdlrepaymentInformation(SSN, AppURL);			    
    				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
    			    LendNationSignContract.txpdl_ach_signContract(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin(SSN, AppURL);
    				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
    				          				
    		
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Online_TXPDL_ACH_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Online_TXPDL_ACH_Txn_Testdata Transaction Failed ");			
   		
   		}
    	}
     
     
   //=======================================  ON LINE TX PDL // SSN = 993838223-993838224 Acct No = 0059-0060================================================ 
     
   	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
       
      @Test(priority = 2, groups = "Ratikanta_Online_TXPDL")
       	public static void QC_Online_TXPDL_ACH_DC_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_TXPDL_DC_ReceiveType As ACH"),  					  		    
     	   			"Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store) -->Complete Loan in 2997 Store");
     	   			String FileName = "QC_Online_TXPDL_ACH_DC_Txn_Testdata.xls";
     			
     			TestData = new ExcelNew(System.getProperty("user.dir")
       					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

     			
     			int lastrow = TestData.getLastRow("Start");
     			String sheetName = "Start";
     			// int lastrow=TestData.getLastRow("Borrower");
     			System.out.println(lastrow);
     			for (int row = 2; row <= lastrow; row++) {

     				String RunFlag = TestData.getCellData(sheetName, "Run", row);
     				// System.out.println(RunFlag);
     				if (RunFlag.equals("Y")) {
     					
     				String SSN = TestData.getCellData(sheetName, "SSN", row);
     				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
     				System.out.println(AppURL); 							 				
     				
     				LendNationRegistration.registration(SSN, AppURL);
     				LendNationPersonalInformation.personalInformation(SSN, AppURL);
     			    LendNationFinancialInformation.txpdlfinancialInformation(SSN, AppURL);
     			    LendNationRepaymentInformation.txpdlrepaymentInformation(SSN, AppURL);			    
     				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
     			    LendNationSignContract.txpdl_ach_dc_signContract(SSN, AppURL);
     				
     				QCCSR_PAM.PAMLogin(SSN, AppURL);
     				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
     				          				
     		
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Online_TXPDL_ACH_DC_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Online_TXPDL_ACH_DC_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
   
      
   
   //=======================================  ON LINE LA PDL // SSN = 993838231-993838232 Acct No = 0060-0061================================================ 
     
 	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
     
    @Test(priority = 1, groups = "Ratikanta_Online_LAPDL")
     	public static void QC_Sprint_Online_LAPDL_ACH_Txn_Testdata() throws Exception {
  	  
   	  try {
   		 test = reports.startTest(("QC_Online_LAPDL_ACH_ReceiveType As ACH"),  					  		    
   	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
   	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 							 				
   				
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
   			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
   			    
   			    QCCSR_PAM.PAMLogin(SSN, AppURL);
				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
   				          				
   			   					
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
    
    
  //=======================================  ON LINE LA PDL // SSN = 993838233-993838234 Acct No = 0062-0063================================================ 
    
   	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
       
      @Test(priority = 2, groups = "Ratikanta_Online_LAPDL")
       	public static void QC_Sprint_Online_LAPDL_ACH_DC_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_LAPDL_DC_ReceiveType As ACH"),  					  		    
     	   			"Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
     	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_DC_Txn_Testdata.xls";
     			
     			TestData = new ExcelNew(System.getProperty("user.dir")
       					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

     			
     			int lastrow = TestData.getLastRow("Start");
     			String sheetName = "Start";
     			// int lastrow=TestData.getLastRow("Borrower");
     			System.out.println(lastrow);
     			for (int row = 2; row <= lastrow; row++) {

     				String RunFlag = TestData.getCellData(sheetName, "Run", row);
     				// System.out.println(RunFlag);
     				if (RunFlag.equals("Y")) {
     					
     				String SSN = TestData.getCellData(sheetName, "SSN", row);
     				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
     				System.out.println(AppURL); 							 				
     				
     				LendNationRegistration.registration(SSN, AppURL);
     				LendNationPersonalInformation.personalInformation(SSN, AppURL);
     			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
     			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
     				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
     			    LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
     			    
     			    QCCSR_PAM.PAMLogin(SSN, AppURL);
  				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
     				          				
     			   					
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_DC_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_DC_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
      
      
    //=======================================  ON LINE NV PDL // SSN = 993838235-993838236 Acct No = 0064-0065================================================ 
      
   	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
       
      @Test(priority = 1, groups = "Ratikanta_Online_NVPDL")
       	public static void QC_Online_NVPDL_ACH_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_NVPDL_ACH_ReceiveType As ACH"),  					  		    
     	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
     	   			String FileName = "QC_Online_NVPDL_ACH_Txn_Testdata.xls";
     			
     			TestData = new ExcelNew(System.getProperty("user.dir")
       					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

     			
     			int lastrow = TestData.getLastRow("Start");
     			String sheetName = "Start";
     			// int lastrow=TestData.getLastRow("Borrower");
     			System.out.println(lastrow);
     			for (int row = 2; row <= lastrow; row++) {

     				String RunFlag = TestData.getCellData(sheetName, "Run", row);
     				// System.out.println(RunFlag);
     				if (RunFlag.equals("Y")) {
     					
     				String SSN = TestData.getCellData(sheetName, "SSN", row);
     				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
     				System.out.println(AppURL); 							 				
     				
     				LendNationRegistration.registration(SSN, AppURL);
     				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
     			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
     			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
     				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
     			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
     			    
     			    QCCSR_PAM.PAMLogin(SSN, AppURL);
  				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
     				          				
     			   					
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
      
      
    //=======================================  ON LINE NV PDL // SSN = 993838237-993838238 Acct No = 0066-0067================================================ 
      
     	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
         
        @Test(priority = 2, groups = "Ratikanta_Online_NVPDL")
        
         	public static void QC_Online_NVPDL_ACH_DC_Txn_Testdata() throws Exception {
      	  
       	  try {
       		 test = reports.startTest(("QC_Online_NVPDL_DC_ReceiveType As ACH"),  					  		    
       	   			"Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
       	   			String FileName = "QC_Online_NVPDL_ACH_DC_Txn_Testdata.xls";
       			
       			TestData = new ExcelNew(System.getProperty("user.dir")
         					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

       			
       			int lastrow = TestData.getLastRow("Start");
       			String sheetName = "Start";
       			// int lastrow=TestData.getLastRow("Borrower");
       			System.out.println(lastrow);
       			for (int row = 2; row <= lastrow; row++) {

       				String RunFlag = TestData.getCellData(sheetName, "Run", row);
       				// System.out.println(RunFlag);
       				if (RunFlag.equals("Y")) {
       					
       				String SSN = TestData.getCellData(sheetName, "SSN", row);
       				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
       				System.out.println(AppURL); 							 				
       				
       				LendNationRegistration.registration(SSN, AppURL);
       				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
       			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
       			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
       				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
       				LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
       			    
       			    QCCSR_PAM.PAMLogin(SSN, AppURL);
    				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
       				          				
       			   					
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_DC_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_DC_Txn_Testdata Transaction Failed ");			
      		
      		}
       	}
        
      //=======================================  ON LINE ID PDL // SSN = 993838239-993838240 Acct No = 0068-0069================================================ 
        
       	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
           
          @Test(priority = 1, groups = "Ratikanta_Online_IDPDL")
           	public static void QC_Online_IDPDL_ACH_Txn_Testdata() throws Exception {
        	  
         	  try {
         		 test = reports.startTest(("QC_Online_IDPDL_ACH_ReceiveType As ACH"),  					  		    
         	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
         	   			String FileName = "QC_Online_IDPDL_ACH_Txn_Testdata.xls";
         			
         			TestData = new ExcelNew(System.getProperty("user.dir")
           					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

         			
         			int lastrow = TestData.getLastRow("Start");
         			String sheetName = "Start";
         			// int lastrow=TestData.getLastRow("Borrower");
         			System.out.println(lastrow);
         			for (int row = 2; row <= lastrow; row++) {

         				String RunFlag = TestData.getCellData(sheetName, "Run", row);
         				// System.out.println(RunFlag);
         				if (RunFlag.equals("Y")) {
         					
         				String SSN = TestData.getCellData(sheetName, "SSN", row);
         				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
         				System.out.println(AppURL); 							 				
         				
         				LendNationRegistration.registration(SSN, AppURL);
         				LendNationPersonalInformation.id_personalInformation(SSN, AppURL);
         			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
         			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
         				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
         			    LendNationSignContract.idpdl_ach_signContract(SSN, AppURL);
         			    
         			    QCCSR_PAM.PAMLogin(SSN, AppURL);
      				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
         				          				
         			   					
           }
           }
           }
           
         	 catch (Exception e) {
        			System.out.println("under catch of Test" + e);
        			String screenshotPath = getScreenhot(driver, "QC_Online_IDPDL_ACH_Txn_Testdata");
        			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
        			test.log(LogStatus.FAIL, "QC_Online_IDPDL_ACH_Txn_Testdata Transaction Failed ");			
        		
        		}
         	}
          
          
        //=======================================  ON LINE ID PDL // SSN = 993838241-993838242 Acct No = 0070-0071================================================ 
          
         	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
             
            @Test(priority = 2, groups = "Ratikanta_Online_IDPDL")
             	public static void QC_Online_IDPDL_DC_ACH_Txn_Testdata() throws Exception {
          	  
           	  try {
           		 test = reports.startTest(("QC_Online_IDPDL_DC_ACH_ReceiveType As ACH"),  					  		    
           	   			"Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
           	   			String FileName = "QC_Online_IDPDL_DC_ACH_Txn_Testdata.xls";
           			
           			TestData = new ExcelNew(System.getProperty("user.dir")
             					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

           			
           			int lastrow = TestData.getLastRow("Start");
           			String sheetName = "Start";
           			// int lastrow=TestData.getLastRow("Borrower");
           			System.out.println(lastrow);
           			for (int row = 2; row <= lastrow; row++) {

           				String RunFlag = TestData.getCellData(sheetName, "Run", row);
           				// System.out.println(RunFlag);
           				if (RunFlag.equals("Y")) {
           					
           				String SSN = TestData.getCellData(sheetName, "SSN", row);
           				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
           				System.out.println(AppURL); 							 				
           				
           				LendNationRegistration.registration(SSN, AppURL);
           				LendNationPersonalInformation.id_personalInformation(SSN, AppURL);
           			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
           			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
           				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
           				LendNationSignContract.idpdl_dc_signContract(SSN, AppURL);
           			    
           			    QCCSR_PAM.PAMLogin(SSN, AppURL);
        				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
           				          				
           			   					
             }
             }
             }
             
           	 catch (Exception e) {
          			System.out.println("under catch of Test" + e);
          			String screenshotPath = getScreenhot(driver, "QC_Online_IDPDL_DC_ACH_Txn_Testdata");
          			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
          			test.log(LogStatus.FAIL, "QC_Online_IDPDL_DC_ACH_Txn_Testdata Transaction Failed ");			
          		
          		}
           	}
            
            
            
       //=======================================  ON LINE ID PDL // SSN = 993838243-993838244 Acct No = 0072-0073================================================     
            
       // Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
            
          @Test(priority = 3, groups = "Ratikanta_Online_IDPDL")
             	public static void QC_Online_IDPDL_ACH_CashAtStore_Txn_Testdata() throws Exception {
          	  
           	  try {
           		 test = reports.startTest(("QC_Online_IDPDL_ACH_ReceiveType As CashAtStore"),  					  		    
           	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 752 Store");
           	   			String FileName = "QC_Online_IDPDL_ACH_CashAtStore_Txn_Testdata.xls";
           			
           			TestData = new ExcelNew(System.getProperty("user.dir")
             					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

           			
           			int lastrow = TestData.getLastRow("Start");
           			String sheetName = "Start";
           			// int lastrow=TestData.getLastRow("Borrower");
           			System.out.println(lastrow);
           			for (int row = 2; row <= lastrow; row++) {

           				String RunFlag = TestData.getCellData(sheetName, "Run", row);
           				// System.out.println(RunFlag);
           				if (RunFlag.equals("Y")) {
           					
           				String SSN = TestData.getCellData(sheetName, "SSN", row);
           				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
           				System.out.println(AppURL); 							 				
           				
           				LendNationRegistration.registration(SSN, AppURL);
           				LendNationPersonalInformation.id_personalInformation(SSN, AppURL);
           			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
           			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
           				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);
           				LendNationSignContract.idpdl_ach_signContract(SSN, AppURL);
           				      
           				
           				QCCSR_PAM.CashAtStore(SSN, AppURL);
          				
          				QCCSR_PAM.PAMLogin(SSN, AppURL);
          				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);

                      
             }
             }
             }
             
           	 catch (Exception e) {
          			System.out.println("under catch of Test" + e);
          			String screenshotPath = getScreenhot(driver, "QC_Online_IDPDL_ACH_CashAtStore_Txn_Testdata");
          			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
          			test.log(LogStatus.FAIL, "QC_Online_IDPDL_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
          		
          		}
           	}
          
          
       //=======================================  ON LINE ID PDL // SSN = 993838245-993838246 Acct No = 0074-0075================================================     
          
       // Receive Type as : "Cash At Store" and Repayment Method  as  : "DEBIT CARD" 
               
        @Test(priority = 4, groups = "Ratikanta_Online_IDPDL")
             public static void QC_Online_IDPDL_DC_CashAtStore_Txn_Testdata() throws Exception {
             	  
              	  try {
              		 test = reports.startTest(("QC_Online_IDPDL_DC_ReceiveType As CashAtStore"),  					  		    
              	   			"Lend Nation Login->Generate Online PDL Loan With DebitCard-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 752 Store");
              	   			String FileName = "QC_Online_IDPDL_DC_CashAtStore_Txn_Testdata.xls";
              			
              			TestData = new ExcelNew(System.getProperty("user.dir")
                					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

              			
              			int lastrow = TestData.getLastRow("Start");
              			String sheetName = "Start";
              			// int lastrow=TestData.getLastRow("Borrower");
              			System.out.println(lastrow);
              			for (int row = 2; row <= lastrow; row++) {

              				String RunFlag = TestData.getCellData(sheetName, "Run", row);
              				// System.out.println(RunFlag);
              				if (RunFlag.equals("Y")) {
              					
              				String SSN = TestData.getCellData(sheetName, "SSN", row);
              				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
              				System.out.println(AppURL); 							 				
              				
              				LendNationRegistration.registration(SSN, AppURL);
              				LendNationPersonalInformation.id_personalInformation(SSN, AppURL);
              			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
              			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
              				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);
              				LendNationSignContract.idpdl_dc_cashatstore_signContract(SSN, AppURL);
              				      
              				
              				QCCSR_PAM.CashAtStore(SSN, AppURL);
             				
             				QCCSR_PAM.PAMLogin(SSN, AppURL);
             				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);

                         
                }
                }
                }
                
              	 catch (Exception e) {
             			System.out.println("under catch of Test" + e);
             			String screenshotPath = getScreenhot(driver, "QC_Online_IDPDL_DC_CashAtStore_Txn_Testdata");
             			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
             			test.log(LogStatus.FAIL, "QC_Online_IDPDL_DC_CashAtStore_Txn_Testdata Transaction Failed ");			
             		
             		}
              	}
        
        
//=======================================  ON LINE UT PDL // SSN = 993838247-993838248 Acct No = 0076-0077================================================ 
        //There is no Payday Loan, only Installment Loan
       	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
           
          @Test(priority = 1, groups = "Ratikanta_Online_UTPDL_1")
           	public static void QC_Online_UTPDL_ACH_Txn_Testdata() throws Exception {
        	  
         	  try {
         		 test = reports.startTest(("QC_Online_UTPDL_ACH_ReceiveType As ACH"),  					  		    
         	   			"Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store");
         	   			String FileName = "QC_Online_UTPDL_ACH_Txn_Testdata.xls";
         			
         			TestData = new ExcelNew(System.getProperty("user.dir")
           					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

         			
         			int lastrow = TestData.getLastRow("Start");
         			String sheetName = "Start";
         			// int lastrow=TestData.getLastRow("Borrower");
         			System.out.println(lastrow);
         			for (int row = 2; row <= lastrow; row++) {

         				String RunFlag = TestData.getCellData(sheetName, "Run", row);
         				// System.out.println(RunFlag);
         				if (RunFlag.equals("Y")) {
         					
         				String SSN = TestData.getCellData(sheetName, "SSN", row);
         				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
         				System.out.println(AppURL); 							 				
         				
         				LendNationRegistration.registration(SSN, AppURL);
         				LendNationPersonalInformation.id_personalInformation(SSN, AppURL);
         			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
         			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
         				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
         			    LendNationSignContract.idpdl_ach_signContract(SSN, AppURL);
         			    
         			    QCCSR_PAM.PAMLogin(SSN, AppURL);
      				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
         				          				
         			   					
           }
           }
           }
           
         	 catch (Exception e) {
        			System.out.println("under catch of Test" + e);
        			String screenshotPath = getScreenhot(driver, "QC_Online_UTPDL_ACH_Txn_Testdata");
        			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
        			test.log(LogStatus.FAIL, "QC_Online_UTPDL_ACH_Txn_Testdata Transaction Failed ");			
        		
        		}
         	}
      
      
      
      
   
     

  //#################################################################################################################### 
 //=======================================  ON LINE KS LOC // SSN = 9938382011-993838212 Acct No = 0047-0048================================================ 
   	 

@Test(priority = 1, groups = "Ratikanta_Online_KSLOC_1")
	public static void QC_KSLOC_Default_PartialPaymentOnline_Txn_Testdata() throws Exception {
  
	  try {
		 test = reports.startTest(("QC_KSLOC_Default_PartialPaymentOnline"),  					  		    
	   			"Borrower Registration-->SLOC NewLoan-->Agestore-->Default-->Partial Payment In Online Portal");
	   			String FileName = "QC_KSLOC_Default_PartialPaymentOnline_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {
					
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
				System.out.println(AppURL); 							 				
	
		//====================================================================================================
				RQCCSRLoginLogout.login(SSN, AppURL);
				RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
				RQCCSRLoginLogout.logout(SSN, AppURL);
				
				RQCCSRLoginLogout.login(SSN, AppURL);					
				RQCCSRNewLoan.newLoan(SSN, AppURL);
				RQCCSRLoginLogout.logout(SSN, AppURL);
				
				RQCCSRLoginLogout.login(SSN, AppURL);						      
				RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				
				RQCCSRLoginLogout.login(SSN, AppURL);
				RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
				
				LendNationLoggin.sloc_resgitration(SSN, AppURL);
				
				LendNationLoggin.sloc_payment(SSN, AppURL);
				
				
	   //=================================================================================================
					
}
}
}

	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_KSLOC_Default_PartialPaymentOnline_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_KSLOC_Default_PartialPaymentOnline_Txn_Testdata Transaction Failed ");			
		
		}
	}

  

//#####################################  Refinance Scenarios Start  ###########################

//=======================================  ON LINE NV PDL // SSN = 993838235-993838236 Acct No = 0064-0065================================================ 

	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
   
  @Test(priority = 1, groups = "Ratikanta_Online_NVPDL_Refinance_1")
   	public static void QC_Online_NVPDL_ACH_Refinance_Txn_Testdata() throws Exception {
	  
 	  try {
 		 test = reports.startTest(("QC_Online_NVPDL_ACH_Refinance_ReceiveType As ACH"),  					  		    
 	   			"Set the Store date(2023,2997) to current date->Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Refinance");
 	   			String FileName = "QC_Online_NVPDL_ACH_Refinance_Txn_Testdata.xls";
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			// int lastrow=TestData.getLastRow("Borrower");
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				// System.out.println(RunFlag);
 				if (RunFlag.equals("Y")) {
 					
 				String SSN = TestData.getCellData(sheetName, "SSN", row);
 				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
 				System.out.println(AppURL); 
 				
 				OnlineStore_DB_Date_Setup.nv_pdl_datesetup(SSN, AppURL);
 				
 				LendNationRegistration.registration(SSN, AppURL);
 				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
 			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
 			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
 				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
 			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
 			    
 			    QCCSR_PAM.PAMLogin(SSN, AppURL);
				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);							
				
				OnlineStore_DB_Date_Setup.accuraldate();
 				
				OnlineStore_DB_Date_Setup.nv_strdate();
				
 				LendNationLoggin.nv_pdl_refinance(SSN, AppURL);
 				
				        //QCCSR_PAM.agestore(SSN, AppURL);
				
				
			
 				          				
 			   					
   }
   }
   }
   
 	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_Refinance_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_Refinance_Txn_Testdata Transaction Failed ");			
		
		}
 	}
  
  
//=======================================  ON LINE NV PDL // SSN = 993838237-993838238 Acct No = 0066-0067================================================ 
  
 	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
     
    @Test(priority = 2, groups = "Ratikanta_Online_NVPDL_Refinance")
    
     	public static void QC_Online_NVPDL_ACH_DC_Refinance_Txn_Testdata() throws Exception {
  	  
   	  try {
   		 test = reports.startTest(("QC_Online_NVPDL_DC_Refinance_ReceiveType As ACH"),  					  		    
   	   			"Set the Store date(2023,2997) to current date->Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Refinance");
   	   			String FileName = "QC_Online_NVPDL_ACH_DC_Refinance_Txn_Testdata.xls";
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
     					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			// int lastrow=TestData.getLastRow("Borrower");
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				// System.out.println(RunFlag);
   				if (RunFlag.equals("Y")) {
   					
   				String SSN = TestData.getCellData(sheetName, "SSN", row);
   				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
   				System.out.println(AppURL); 
   				
   				OnlineStore_DB_Date_Setup.nv_pdl_datesetup(SSN, AppURL);
   				Thread.sleep(5000);
   				LendNationRegistration.registration(SSN, AppURL);
   				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
   			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
   			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
   				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
   				LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
   			    
   			    QCCSR_PAM.PAMLogin(SSN, AppURL);
				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
				
                OnlineStore_DB_Date_Setup.accuraldate();
                Thread.sleep(5000);
				OnlineStore_DB_Date_Setup.nv_strdate();
				Thread.sleep(5000);
 				LendNationLoggin.nv_pdl_refinance(SSN, AppURL);
   				          				
   			   					
     }
     }
     }
     
   	 catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_DC_Refinance_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_DC_Refinance_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
    
    
  //=======================================  ON LINE LA PDL // SSN = 993838231-993838232 Acct No = 0060-0061================================================ 
    
   	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
       
      @Test(priority = 1, groups = "Ratikanta_Online_LAPDL_Refinance")
       	public static void QC_Sprint_Online_LAPDL_ACH_Refinance_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_LAPDL_ACH_Refinance_ReceiveType As ACH"),  					  		    
     				"Set the Store date(2019,2997) to current date->Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Refinance");
     	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_Refinance_Txn_Testdata.xls";
     			
     			TestData = new ExcelNew(System.getProperty("user.dir")
       					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

     			
     			int lastrow = TestData.getLastRow("Start");
     			String sheetName = "Start";
     			// int lastrow=TestData.getLastRow("Borrower");
     			System.out.println(lastrow);
     			for (int row = 2; row <= lastrow; row++) {

     				String RunFlag = TestData.getCellData(sheetName, "Run", row);
     				// System.out.println(RunFlag);
     				if (RunFlag.equals("Y")) {
     					
     				String SSN = TestData.getCellData(sheetName, "SSN", row);
     				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
     				System.out.println(AppURL); 
     				
     				OnlineStore_DB_Date_Setup.la_pdl_datesetup(SSN, AppURL);
       				Thread.sleep(5000);    				
     				LendNationRegistration.registration(SSN, AppURL);
     				LendNationPersonalInformation.personalInformation(SSN, AppURL);
     			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
     			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
     				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
     			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
     			    
     			    QCCSR_PAM.PAMLogin(SSN, AppURL);
  				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
  				    
  				    OnlineStore_DB_Date_Setup.accuraldate();
                    Thread.sleep(5000);
  				    OnlineStore_DB_Date_Setup.la_strdate();
  				    Thread.sleep(5000);
   				    LendNationLoggin.nv_pdl_refinance(SSN, AppURL);
     				          				
     			   					
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_Refinance_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_Refinance_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
      
      
    //=======================================  ON LINE LA PDL // SSN = 993838233-993838234 Acct No = 0062-0063================================================ 
      
     	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
         
       @Test(priority = 2, groups = "Ratikanta_Online_LAPDL_Refinance_1")
         public static void QC_Sprint_Online_LAPDL_ACH_DC_Refinance_Txn_Testdata() throws Exception {
      	  
       	  try {
       		 test = reports.startTest(("QC_Online_LAPDL_DC_Refinance_ReceiveType As ACH"),  					  		    
       				"Set the Store date(2019,2997) to current date->Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Refinance");
       	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_DC_Refinance_Txn_Testdata.xls";
       			
       			TestData = new ExcelNew(System.getProperty("user.dir")
         					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

       			
       			int lastrow = TestData.getLastRow("Start");
       			String sheetName = "Start";
       			// int lastrow=TestData.getLastRow("Borrower");
       			System.out.println(lastrow);
       			for (int row = 2; row <= lastrow; row++) {

       				String RunFlag = TestData.getCellData(sheetName, "Run", row);
       				// System.out.println(RunFlag);
       				if (RunFlag.equals("Y")) {
       					
       				String SSN = TestData.getCellData(sheetName, "SSN", row);
       				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
       				System.out.println(AppURL); 
       				
       				OnlineStore_DB_Date_Setup.la_pdl_datesetup(SSN, AppURL);
       				Thread.sleep(5000);
       				
       				LendNationRegistration.registration(SSN, AppURL);
       				LendNationPersonalInformation.personalInformation(SSN, AppURL);
       			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
       			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
       				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
       			    LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
       			    
       			    QCCSR_PAM.PAMLogin(SSN, AppURL);
    				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
    				
    				OnlineStore_DB_Date_Setup.accuraldate();
                    Thread.sleep(5000);
  				    OnlineStore_DB_Date_Setup.la_strdate();
  				    Thread.sleep(5000);
   				    LendNationLoggin.nv_pdl_refinance(SSN, AppURL);
       				          				
       			   					
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_DC_Refinance_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_DC_Refinance_Txn_Testdata Transaction Failed ");			
      		
      		}
       	}

       
       
       
     //#####################################  Payment Scenarios Start  ###########################

     //=======================================  ON LINE NV PDL // SSN = 993838240-993838241 Acct No = 0070-0071================================================ 

     	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
        
       @Test(priority = 1, groups = "Ratikanta_Online_NVPDL_Payment")
        	public static void QC_Online_NVPDL_ACH_Payment_Txn_Testdata() throws Exception {
     	  
      	  try {
      		 test = reports.startTest(("QC_Online_NVPDL_ACH_Payment_ReceiveType As ACH"),  					  		    
      	   			"Set the Store date(2023,2997) to current date->Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Payment");
      	   			String FileName = "QC_Online_NVPDL_ACH_Payment_Txn_Testdata.xls";
      			
      			TestData = new ExcelNew(System.getProperty("user.dir")
        					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

      			
      			int lastrow = TestData.getLastRow("Start");
      			String sheetName = "Start";
      			// int lastrow=TestData.getLastRow("Borrower");
      			System.out.println(lastrow);
      			for (int row = 2; row <= lastrow; row++) {

      				String RunFlag = TestData.getCellData(sheetName, "Run", row);
      				// System.out.println(RunFlag);
      				if (RunFlag.equals("Y")) {
      					
      				String SSN = TestData.getCellData(sheetName, "SSN", row);
      				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
      				System.out.println(AppURL); 
      				
      				OnlineStore_DB_Date_Setup.nv_pdl_datesetup(SSN, AppURL);
      				
      				LendNationRegistration.registration(SSN, AppURL);
      				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
      			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
      			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
      				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
      			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
      			    
      			    QCCSR_PAM.PAMLogin(SSN, AppURL);
     				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);							
     				
     				OnlineStore_DB_Date_Setup.accuraldate();
      				
     				OnlineStore_DB_Date_Setup.nv_strdate();
     				
     				OnlineStore_DB_Date_Setup.nv_pdl_datesetup_to_accrualdate(SSN, AppURL);
     				
      				LendNationLoggin.pdl_payment(SSN, AppURL);
      				
     				        //QCCSR_PAM.agestore(SSN, AppURL);
     				
     				
     			
      				          				
      			   					
        }
        }
        }
        
      	 catch (Exception e) {
     			System.out.println("under catch of Test" + e);
     			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_Payment_Txn_Testdata");
     			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
     			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_Payment_Txn_Testdata Transaction Failed ");			
     		
     		}
      	}
       
       
     //=======================================  ON LINE NV PDL // SSN = 993838242-993838243 Acct No = 0072-0073================================================ 
       
      	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
          
        @Test(priority = 2, groups = "Ratikanta_Online_NVPDL_Payment")
         
          	public static void QC_Online_NVPDL_ACH_DC_Payment_Txn_Testdata() throws Exception {
       	  
        	  try {
        		 test = reports.startTest(("QC_Online_NVPDL_DC_Payment_ReceiveType As ACH"),  					  		    
        	   			"Set the Store date(2023,2997) to current date->Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Payment");
        	   			String FileName = "QC_Online_NVPDL_ACH_DC_Payment_Txn_Testdata.xls";
        			
        			TestData = new ExcelNew(System.getProperty("user.dir")
          					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

        			
        			int lastrow = TestData.getLastRow("Start");
        			String sheetName = "Start";
        			// int lastrow=TestData.getLastRow("Borrower");
        			System.out.println(lastrow);
        			for (int row = 2; row <= lastrow; row++) {

        				String RunFlag = TestData.getCellData(sheetName, "Run", row);
        				// System.out.println(RunFlag);
        				if (RunFlag.equals("Y")) {
        					
        				String SSN = TestData.getCellData(sheetName, "SSN", row);
        				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
        				System.out.println(AppURL); 
        				
        				OnlineStore_DB_Date_Setup.nv_pdl_datesetup(SSN, AppURL);
        				Thread.sleep(5000);
        				LendNationRegistration.registration(SSN, AppURL);
        				LendNationPersonalInformation.nv_personalInformation(SSN, AppURL);
        			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
        			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
        				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
        				LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
        			    
        			    QCCSR_PAM.PAMLogin(SSN, AppURL);
     				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
     				
                        OnlineStore_DB_Date_Setup.accuraldate();
                        Thread.sleep(5000);
     				    OnlineStore_DB_Date_Setup.nv_strdate();
     				    Thread.sleep(5000);
     				    OnlineStore_DB_Date_Setup.nv_pdl_datesetup_to_accrualdate(SSN, AppURL);
     				   
     				    LendNationLoggin.pdl_dc_payment(SSN, AppURL);
        				          				
        			   					
          }
          }
          }
          
        	 catch (Exception e) {
       			System.out.println("under catch of Test" + e);
       			String screenshotPath = getScreenhot(driver, "QC_Online_NVPDL_ACH_DC_Payment_Txn_Testdata");
       			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
       			test.log(LogStatus.FAIL, "QC_Online_NVPDL_ACH_DC_Payment_Txn_Testdata Transaction Failed ");			
       		
       		}
        	}
         
         
       //=======================================  ON LINE LA PDL // SSN = 993838244-993838245 Acct No = 0074-0075================================================ 
         
        	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
            
           @Test(priority = 1, groups = "Ratikanta_Online_LAPDL_Payment")
            	public static void QC_Sprint_Online_LAPDL_ACH_Payment_Txn_Testdata() throws Exception {
         	  
          	  try {
          		 test = reports.startTest(("QC_Online_LAPDL_ACH_Payment_ReceiveType As ACH"),  					  		    
          				"Set the Store date(2019,2997) to current date->Lend Nation Login->Generate Online PDL Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Payment");
          	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_Payment_Txn_Testdata.xls";
          			
          			TestData = new ExcelNew(System.getProperty("user.dir")
            					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

          			
          			int lastrow = TestData.getLastRow("Start");
          			String sheetName = "Start";
          			// int lastrow=TestData.getLastRow("Borrower");
          			System.out.println(lastrow);
          			for (int row = 2; row <= lastrow; row++) {

          				String RunFlag = TestData.getCellData(sheetName, "Run", row);
          				// System.out.println(RunFlag);
          				if (RunFlag.equals("Y")) {
          					
          				String SSN = TestData.getCellData(sheetName, "SSN", row);
          				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
          				System.out.println(AppURL); 
          				
          				OnlineStore_DB_Date_Setup.la_pdl_datesetup(SSN, AppURL);
            			Thread.sleep(5000);    				
          				LendNationRegistration.registration(SSN, AppURL);
          				LendNationPersonalInformation.personalInformation(SSN, AppURL);
          			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
          			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
          				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
          			    LendNationSignContract.lapdl_ach_signContract(SSN, AppURL);
          			    
          			    QCCSR_PAM.PAMLogin(SSN, AppURL);
       				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
       				    
       				    OnlineStore_DB_Date_Setup.accuraldate();
                        Thread.sleep(5000);
       				    OnlineStore_DB_Date_Setup.la_strdate();
       				    Thread.sleep(5000);
       				    OnlineStore_DB_Date_Setup.la_pdl_datesetup_to_accrualdate(SSN, AppURL);
      				
       				    LendNationLoggin.pdl_payment(SSN, AppURL);
          				          				
          			   					
            }
            }
            }
            
          	 catch (Exception e) {
         			System.out.println("under catch of Test" + e);
         			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_Payment_Txn_Testdata");
         			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
         			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_Payment_Txn_Testdata Transaction Failed ");			
         		
         		}
          	}
           
           
         //=======================================  ON LINE LA PDL // SSN = 993838246-993838247 Acct No = 0076-0077================================================ 
           
          	// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
              
            @Test(priority = 2, groups = "Ratikanta_Online_LAPDL_Payment")
              public static void QC_Sprint_Online_LAPDL_ACH_DC_Payment_Txn_Testdata() throws Exception {
           	  
            	  try {
            		 test = reports.startTest(("QC_Online_LAPDL_DC_Payment_ReceiveType As ACH"),  					  		    
            				"Set the Store date(2019,2997) to current date->Lend Nation Login->Generate Online PDL Loan With Debit Card-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Payment");
            	   			String FileName = "QC_Sprint_Online_LAPDL_ACH_DC_Payment_Txn_Testdata.xls";
            			
            			TestData = new ExcelNew(System.getProperty("user.dir")
              					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

            			
            			int lastrow = TestData.getLastRow("Start");
            			String sheetName = "Start";
            			// int lastrow=TestData.getLastRow("Borrower");
            			System.out.println(lastrow);
            			for (int row = 2; row <= lastrow; row++) {

            				String RunFlag = TestData.getCellData(sheetName, "Run", row);
            				// System.out.println(RunFlag);
            				if (RunFlag.equals("Y")) {
            					
            				String SSN = TestData.getCellData(sheetName, "SSN", row);
            				String ReceiveType = TestData.getCellData(sheetName, "ReceiveType", row);
            				System.out.println(AppURL); 
            				
            				OnlineStore_DB_Date_Setup.la_pdl_datesetup(SSN, AppURL);
            				Thread.sleep(5000);
            				
            				LendNationRegistration.registration(SSN, AppURL);
            				LendNationPersonalInformation.personalInformation(SSN, AppURL);
            			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
            			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
            				LendNationLoanDecision.pdl_loandecision(SSN, AppURL);			    			            
            			    LendNationSignContract.lapdl_dc_signContract(SSN, AppURL);
            			    
            			    QCCSR_PAM.PAMLogin(SSN, AppURL);
         				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
         				
         				    OnlineStore_DB_Date_Setup.accuraldate();
                            Thread.sleep(5000);
       				        OnlineStore_DB_Date_Setup.la_strdate();
       				        Thread.sleep(5000);
       				        OnlineStore_DB_Date_Setup.la_pdl_datesetup_to_accrualdate(SSN, AppURL);
       				        
       				        LendNationLoggin.pdl_dc_payment(SSN, AppURL);
            				          				
            			   					
              }
              }
              }
              
            	 catch (Exception e) {
           			System.out.println("under catch of Test" + e);
           			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_LAPDL_ACH_DC_Payment_Txn_Testdata");
           			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
           			test.log(LogStatus.FAIL, "QC_Sprint_Online_LAPDL_ACH_DC_Payment_Txn_Testdata Transaction Failed ");			
           		
           		}
            	}

   
			

//============================================================================================================
	


	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			BufferedReader Vreader;

			

			try {
				Rreader = new BufferedReader(

						new FileReader("C:/Qc_Batch_WildFly/QC_Online_PDL/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(Rreader);
				Rreader.close();
				csr_url = prop.getProperty("CSR_URL");
				csrloginpage = prop.getProperty("Login_Page");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				DBUserName = prop.getProperty("DB_UserName");
				DBPassword = prop.getProperty("DB_Password");
				AdminUserName= prop.getProperty("admin_userid");
				AdminPassword= prop.getProperty("admin_password");
				
				String Rfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);	

			//BufferedReader reader;
			String propertyFilePath=("user.dir")+"/Objects.properties";
		
		
		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /IM iexplore.exe /F");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the IE process process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/PDL/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		// System.out.println(locator);
		// return locator;

	}

}
