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
	public static String Loan_Date;
	public static String Proc_Date;
	
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
	
	//public static String Tran_Nbr;

    
 //=======================================  ON LINE MO ILP  ================================================ 
	    //=======================================  ON LINE MO ILP // SSN = 993838213-993838214 Acct No = 0049-0050 ================================================ 
	   
		// Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
     
   @Test(priority = 1, groups = "Ratikanta_Online_MOILP")
     public static void QC_Sprint_Online_MOILP_ACH_CashAtStore_Txn_Testdata() throws Exception {
    
   	  try {
   		 test = reports.startTest(("QC_Online_MOILP_ACH_ReceiveType As CashAtStore"),  					  		    
   	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 118 Store");
   	   			String FileName = "QC_Sprint_Online_MOILP_ACH_CashAtStore_Txn_Testdata.xls";
   			
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
   				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
   			    LendNationSignContract.ilp_cashatstore_signContract(SSN, AppURL);
   				          				  				 
   				
   				if(ReceiveType.equalsIgnoreCase("Cash At Store"))
  			    {		  				
  				QCCSR_PAM.CashAtStore(SSN, AppURL);
  				
  				QCCSR_PAM.PAMLogin_CashAtStore(SSN, AppURL);
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
  			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOILP_ACH_CashAtStore_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOILP_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
  		
  		}
   	}
     
     
 //=======================================  ON LINE MO ILP  ================================================ 
   	     //=======================================  ON LINE MO ILP // SSN = 993838215-993838216 Acct No = 0051-0052 ================================================ 
   	   
   		 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
        
     @Test(priority = 2, groups = "Ratikanta_Online_MOILP")
        public static void QC_Sprint_Online_MOILP_ACH_Txn_Testdata() throws Exception {
       
      	  try {
      		 test = reports.startTest(("QC_Online_MOILP_ACH_ReceiveType As ACH"),  					  		    
      	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
      	   			String FileName = "QC_Sprint_Online_MOILP_ACH_Txn_Testdata.xls";
      			
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
      				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
      			    LendNationSignContract.moilp_ach_signContract(SSN, AppURL);
      				          				  				 
      				
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
     			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOILP_ACH_Txn_Testdata");
     			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
     			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOILP_ACH_Txn_Testdata Transaction Failed ");			
     		
     		}
      	}
        
 //=======================================  ON LINE MO ILP  ================================================ 
      	   //=======================================  ON LINE MO ILP // SSN = 993838217-993838218 Acct No = 0053-0054 ================================================ 
      	   
          // Receive Type as : "ACH" and Repayment Method  as  : "Debit Card"  
           
     @Test(priority = 3, groups = "Ratikanta_Online_MOILP")
           public static void QC_Sprint_Online_MOILP_DC_ACH_Txn_Testdata() throws Exception {
           
         	  try {
         		 test = reports.startTest(("QC_Online_MOILP_DC_ReceiveType As ACH"),  					  		    
         	   			"Lend Nation Login->Generate Online ILP Loan With DC-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
         	   			String FileName = "QC_Sprint_Online_MOILP_DC_ACH_Txn_Testdata.xls";
         			
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
         				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
         			    LendNationSignContract.ilp_dc_ACH_signContract(SSN, AppURL);
         				          				  				 
         				
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
        			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOILP_DC_ACH_Txn_Testdata");
        			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
        			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOILP_DC_ACH_Txn_Testdata Transaction Failed ");			
        		
        		}
         	}
           
 //=======================================  ON LINE MO ILP  ================================================ 
        //=======================================  ON LINE MO ILP // SSN = 993838219-993838220 Acct No = 0055-0056 ================================================ 
        	   
        // Receive Type as : "Cash At Store" and Repayment Method  as  : "Debit Card"   
             
    @Test(priority = 4, groups = "Ratikanta_Online_MOILP")
             public static void QC_Sprint_Online_MOILP_DC_ACH_CashAtStore_Txn_Testdata() throws Exception {
            
           	  try {
           		 test = reports.startTest(("QC_Online_MOILP_DC_ReceiveType As CashAtStore"),  					  		    
           	   			"Lend Nation Login->Generate Online ILP Loan With DC-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 118 Store");
           	   			String FileName = "QC_Sprint_Online_MOILP_DC_ACH_CashAtStore_Txn_Testdata.xls";
           			
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
           				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
           			    LendNationSignContract.ilp_dc_CashatStore_signContract(SSN, AppURL);
           				          				  				 
           				           					
           			if(ReceiveType.equalsIgnoreCase("Cash At Store"))
          			    {		  				
          				QCCSR_PAM.CashAtStore(SSN, AppURL);
          				
          				QCCSR_PAM.PAMLogin_CashAtStore(SSN, AppURL);
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
          			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_MOILP_DC_ACH_CashAtStore_Txn_Testdata");
          			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
          			test.log(LogStatus.FAIL, "QC_Sprint_Online_MOILP_DC_ACH_CashAtStore_Txn Transaction Failed ");			
          		
          		}
           	}
        
        
     
     
 //=======================================  ON LINE WI ILP  ================================================ 
            
  	 //=======================================  ON LINE WI ILP // SSN = 993838221-993838222 Acct No = 0057-0058 ================================================ 
  	   
         // Receive Type as : "ACH" and Repayment Method  as  : "ACH"   
      
   @Test(priority = 1, groups = "Ratikanta_Online_WIILP")
      
      public static void QC_Sprint_Online_WIILP_ACH_Txn_Testdata() throws Exception {
     
    	  try {
    		 test = reports.startTest(("QC_Online_WIILP_ACH_ReceiveType As ACH"),  					  		    
    	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->Approve Loan-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Loan Generated");
    	   			String FileName = "QC_Sprint_Online_WIILP_ACH_Txn_Testdata.xls";
    			
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
    				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	            				
       				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
       			       
       				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
       				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
       				
    				LendNationLoggin.esignature(SSN, AppURL);
    				
    				
    			
    				
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_WIILP_ACH_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Sprint_Online_WIILP_ACH_Txn Failed ");			
   		
   		}
    	}
   
 //=======================================  ON LINE WI ILP  ================================================ 
      
   	     //=======================================  ON LINE WI ILP // SSN = 993838223-993838224 Acct No = 0059-0060 ================================================ 
   	   
         // Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH"   
       
    @Test(priority = 2, groups = "Ratikanta_Online_WIILP")
       
       public static void QC_Sprint_Online_WIILP_ACH_CashAtStore_Txn_Testdata() throws Exception {
    	  
     	  try {
     		 test = reports.startTest(("QC_Online_WIILP_ACH_ReceiveType As CashAtStore"),  					  		    
     	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->Loan Approved-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Complete Loan in 252 Store");
     	   			String FileName = "QC_Sprint_Online_WIILP_ACH_CashAtStore_Txn_Testdata.xls";
     			
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
     				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);
     				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
     				
     				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
       				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
       				  				        
    				LendNationLoggin.wi_ilp_cashatstore_esignature(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin_with_252(SSN, AppURL);
 				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);   
			     				     				
     				
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_WIILP_ACH_CashAtStore_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Sprint_Online_WIILP_ACH_CashAtStore_Txn Failed ");			
    		
    		}
     	}
       
 //=======================================  ON LINE WI ILP  ================================================ 
       
     	 //=======================================  ON LINE WI ILP // SSN = 993838225-993838226 Acct No = 0061-0062 ================================================ 
     	   
        // Receive Type as : "ACH" and Repayment Method  as  : "Debit Card"   
       
   @Test(priority = 3, groups = "Ratikanta_Online_WIILP")
         
         public static void QC_Sprint_Online_WIILP_DC_ACH_Txn_Testdata() throws Exception {
         
       	  try {
       		 test = reports.startTest(("QC_Online_WIILP_DebitCard_ReceiveType As ACH"),  					  		    
       	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With DC-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Loan Generated");
       	   			String FileName = "QC_Sprint_Online_WIILP_DC_ACH_Txn_Testdata.xls";
       			
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
       				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	
       				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
       			       
       				QCCSR_PAM.PAMLogin(SSN, AppURL);
       				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
       				
       				        //LendNationLoggin.wi_dc_ach_esignature(SSN, AppURL);
       				
       				
       				
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_WIILP_DC_ACH_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Sprint_Online_WIILP_DC_ACH_Txn Failed ");			
      		
      		}
       	}
         
       //=======================================  ON LINE WI ILP  ================================================ 
         
     	 //=======================================  ON LINE WI ILP // SSN = 993838227-993838228 Acct No = 0063-0064 ================================================ 
     	   
        // Receive Type as : "Cash At Store" and Repayment Method  as  : "Debit Card"   
       
     @Test(priority = 4, groups = "Ratikanta_Online_WIILP")
         
         public static void QC_Sprint_Online_WIILP_DC_ACH_CashAtStore_Txn_Testdata() throws Exception {
         
       	  try {
       		 test = reports.startTest(("QC_Online_WIILP_DebitCard_ReceiveType As CashAtStore"),  					  		    
       	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Complete Loan in 252 Store");
       	   			String FileName = "QC_Sprint_Online_WIILP_DC_ACH_CashAtStore_Txn_Testdata.xls";
       			
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
       				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	  				
       			       
       				
       				if(ReceiveType.equalsIgnoreCase("Cash At Store"))
       			    {		  				
     					QCCSR_PAM.PAMLogin(SSN, AppURL);
         				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
         				
         				LendNationLoggin.wi_ilp_dc_cashatstore_esignature(SSN, AppURL);
       				
       				    QCCSR_PAM.PAMLogin_with_252(SSN, AppURL);
     				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
       			    }
       			
       			else{
       				    QCCSR_PAM.PAMLogin(SSN, AppURL);
       				    QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
       				
       				    LendNationLoggin.wi_dc_ach_esignature(SSN, AppURL);
       				
       			    }
       				
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_WIILP_DC_ACH_CashAtStore_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Sprint_Online_WIILP_DC_ACH_CashAtStore_Txn Failed ");			
      		
      		}
       	}
         
 //=======================================  ON LINE WI ILP  ================================================ 
         
     	 //=======================================  ON LINE WI ILP // SSN = 993838229-993838230 Acct No = 0065-0066 ================================================ 
     	   
        // Receive Type as : "Instant Funding With DC" and Repayment Method  as  : "Debit Card"   
       
   @Test(priority = 5, groups = "Ratikanta_Online_WIILP")
         
         public static void QC_Sprint_Online_WIILP_DC_InstatnFundingWithDC_Txn_Testdata() throws Exception {
         
       	  try {
       		 test = reports.startTest(("QC_Online_WIILP_DebitCard_ReceiveType As Instant Funding With DC"),  					  		    
       	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With DC-->ESign Process In PAM (2997 Store)-->Login To Lendnation To Complete E-Signature-->Loan Generated");
       	   			String FileName = "QC_Sprint_Online_WIILP_DC_InstatnFundingWithDC_Txn_Testdata.xls";
       			
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
       				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	  				
       			       
       				QCCSR_PAM.PAMLogin(SSN, AppURL);
       				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
       				
       				LendNationLoggin.wi_dc_ach_esignature(SSN, AppURL);
       				
       				
       				
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_WIILP_DC_InstatnFundingWithDC_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Sprint_Online_WIILP_DC_InstatnFundingWithDC_Txn Failed ");			
      		
      		}
       	}

   
 
//============================================================================================================
   
           //======================================= Sprint 5 Scenarios Started Here =======================================
   
          //=======================================  ON LINE MO ILP  ================================================ 
         //=======================================  SSN = 993838231-993838232 Acct No = 0067-0068 ================================================ 
  
        // Receive Type/Funding Method as : "ACH/Electronic" and Repayment Method  as  : "ACH" 
   
   @Test(priority = 1, groups = "Ratikanta_Sprint5_REQ_868_MOILP")
      public static void QC_Sprint5_B20_389_01_Online_MOILP_ACH_AsFunding_Txn_Testdata() throws Exception {
     
    	  try {
    		 test = reports.startTest(("QC_Online_Sprint_5_B20-389_01"),  					  		    
    	   			"Lend Nation Registration->PersonalInformation-->Funding Method as : ACH/Electronics And Zip Code more than 75 miles-->Loan Decision-->Verify : Application should not display the  in-store offer");
    	   			String FileName = "QC_Sprint5_B20_389_01_Online_MOILP_ACH_AsFunding_Txn_Testdata.xls";
    			
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
    				LendNationLoanDecision.moilp_loandecision_storeoffer_unavailable_validation(SSN, AppURL);			    			            
    			   
    		
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Sprint5_B20_389_01_Online_MOILP_ACH_AsFunding_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Sprint5_B20_389_01_Online_MOILP_ACH_AsFunding_Txn_Testdata Transaction Failed ");			
   		
   		}
    	}
   
         //=======================================  ON LINE MO ILP  ================================================ 
   
         //=======================================  SSN = 993838233-993838234 Acct No = 0069-0070 ================================================ 
  
	     // Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 

   @Test(priority = 2, groups = "Ratikanta_Sprint5_REQ_868_MOILP")
   public static void QC_Sprint5_B20_389_02_Online_MOILP_ACH_CashAtStore_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_Sprint_5_B20-389_02"),  					  		    
	   			"Lend Nation Registration->PersonalInformation-->Zip Code Less than 75 miles-->Loan Decision-->Verify : Application should display the  in-store offer");
	   			String FileName = "QC_Sprint5_B20_389_02_Online_MOILP_ACH_CashAtStore_Txn_Testdata.xls";
			
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
			    LendNationLoanDecision.moilp_loandecision_storeoffer_available_validation(SSN, AppURL);			    			            
			    
}
}
}

	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint5_B20_389_02_Online_MOILP_ACH_CashAtStore_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint5_B20_389_02_Online_MOILP_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
		
		}
	}
   
           //=======================================  ON LINE MO ILP Sprint================================================ 
        
          //=======================================  SSN = 993838235-993838236 Acct No = 0071-0072 ================================================ 

          //  Repayment Method  as  : "ACH" 

    @Test(priority = 3, groups = "Ratikanta_Sprint5_REQ_868_MOILP")
     public static void QC_Sprint5_B20_420_01_Online_MOILP_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_Sprint_5_B20-420_01"),  					  		    
	   			"Lend Nation Registration->PersonalInformation-->Zip Code More than 75 miles-->Financial Information-->Application should not display Cash at Store option in the Funding Method Drop Down");
	   			String FileName = "QC_Sprint5_B20_420_01_Online_MOILP_Txn_Testdata.xls";
			
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
			    LendNationFinancialInformation.financialInformation_cashatstore_notallowed(SSN, AppURL);
		
}
}
}

	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint5_B20_420_01_Online_MOILP_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint5_B20_420_01_Online_MOILP_Txn_Testdata Transaction Failed ");			
		
		}
	}
    
             //=======================================  ON LINE MO ILP  ================================================ 
    
             //=======================================  SSN = 993838237-993838238 Acct No = 0073-0074 ================================================ 

             //  Repayment Method  as  : "ACH" 

     @Test(priority = 4, groups = "Ratikanta_Sprint5_REQ_868_MOILP_1")
       public static void QC_Sprint5_B20_420_02_Online_MOILP_Txn_Testdata() throws Exception {

            try {
	        test = reports.startTest(("QC_Online_Sprint_5_B20-420_02"),  					  		    
 			"Lend Nation Registration->PersonalInformation-->Zip Code Less than 75 miles-->Financial Information-->Application should display and Allow Cash at Store option in the Funding Method Drop Down");
 			String FileName = "QC_Sprint5_B20_420_02_Online_MOILP_Txn_Testdata.xls";
		
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
		    LendNationFinancialInformation.financialInformation_cashatstore_allowed(SSN, AppURL);
	
}
}
}

catch (Exception e) {
		System.out.println("under catch of Test" + e);
		String screenshotPath = getScreenhot(driver, "QC_Sprint5_B20_420_02_Online_MOILP_Txn_Testdata");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "QC_Sprint5_B20_420_02_Online_MOILP_Txn_Testdata Transaction Failed ");			
	
	}
}
        
         //======================================= Sprint-6 Scenarios- ON LINE OK ILP  ================================================ 
	     
         //===================================== SSN = 993838241-993838242 Acct No = 0077-0078 ================================================ 
  // Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
     
     @Test(priority = 1, groups = "Ratikanta_Online_OKILP")
       public static void QC_Sprint6_Online_OKILP_ACH_CashAtStore_Txn_Testdata() throws Exception {
      
     	  try {
     		 test = reports.startTest(("QC_Online_OKILP_ACH_ReceiveType As CashAtStore"),  					  		    
     	   			"Lend Nation Login->Generate Online OKILP Loan With ACH-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 118 Store");
     	   			String FileName = "QC_Sprint6_Online_OKILP_ACH_CashAtStore_Txn_Testdata.xls";
     			
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
     				LendNationLoanDecision.okilp_loandecision(SSN, AppURL);
     				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
     			               
     				
     				QCCSR_PAM.CashAtStore_OKILP(SSN, AppURL);
     					
    				LendNationLoggin.OKILP_esignature(SSN, AppURL);
    				
     				                 //QCCSR_PAM.PAMLogin(SSN, AppURL);
  				                    //QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
     				          				  				 
     				
     				/*if(ReceiveType.equalsIgnoreCase("Cash At Store"))
    			    {		  				
    				QCCSR_PAM.CashAtStore(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin(SSN, AppURL);
  				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
    			    }
    			
    			else{
    				            //QCCSR_PAM.PAMLogin(SSN, AppURL);
    				            //QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
    				QCCSR_PAM.PAMLogin(SSN, AppURL);
		               
    				QCCSR_PAM.PAMScreen_WIILPEsign(SSN, AppURL, loan_number);        				
    				        	
    				LendNationLoggin.esignature(SSN, AppURL);
    				
    			    }*/
   	
       }
       }
       }
       
     	 catch (Exception e) {
    			System.out.println("under catch of Test" + e);
    			String screenshotPath = getScreenhot(driver, "QC_Sprint6_Online_OKILP_ACH_CashAtStore_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Sprint6_Online_OKILP_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}  
       
       //===================================== SSN = 993838243-993838244 Acct No = 0079-0080 ================================================ 
       
       // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
      
   @Test(priority = 2, groups = "Ratikanta_Online_OKILP")
      public static void QC_Sprint6_Online_OKILP_ACH_Txn_Testdata() throws Exception {
     
    	  try {
    		 test = reports.startTest(("QC_Online_OKILP_ACH_ReceiveType As ACH"),  					  		    
    	   			"Lend Nation Login->Generate Online OK ILP Loan With ACH-->Esignature Loan In PAM (2997 Store)-->Complete E Signature in Lendnation Portal");
    	   			String FileName = "QC_Sprint6_Online_OKILP_ACH_Txn_Testdata.xls";
    			
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
    			    LendNationLoanDecision.okilp_loandecision(SSN, AppURL);
     				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
    				
    				QCCSR_PAM.PAMLogin(SSN, AppURL);
    				QCCSR_PAM.PAM_OKILP_ACH_ESign(SSN, AppURL, loan_number);
     			              
    				LendNationLoggin.OKILP_ACH_esignature(SSN, AppURL);
    				          				  				 
    				
		    		/*if(ReceiveType.equalsIgnoreCase("Cash At Store"))
		   			    {		  				
		   				QCCSR_PAM.CashAtStore(SSN, AppURL);
		   				
		   				QCCSR_PAM.PAMLogin(SSN, AppURL);
		 			     QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
		   			    }
		   			
		   			else{
		   				QCCSR_PAM.PAMLogin(SSN, AppURL);
		   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
		   				
		   			    }*/
  	
      }
      }
      }
      
    	 catch (Exception e) {
   			System.out.println("under catch of Test" + e);
   			String screenshotPath = getScreenhot(driver, "QC_Sprint6_Online_OKILP_ACH_Txn_Testdata");
   			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
   			test.log(LogStatus.FAIL, "QC_Sprint6_Online_OKILP_ACH_Txn_Testdata Transaction Failed ");			
   		
   		}
    	}
      
 //#######################################  Sprint-7 - REQ_868 - ILP Scenarios  ######################################
      
          //===================================== SSN = 993838260-993838261 Acct No = 0095-0096 ================================================ 
      
         // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
      
    @Test(priority = 1, groups = "Ratikanta_Sprint7_REQ_868_ILP")
         public static void QC_Sprint7_Online_TS_B20_744_01_MOILP_Txn_Testdata() throws Exception {
        
       	  try {
       		 test = reports.startTest(("Online_MOILP_Sprint7_TS_B20_744_01"),  					  		    
       	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Login PAM-->Validation after Negotiate Loan");
       	   			String FileName = "QC_Sprint7_Online_TS_B20_744_01_MOILP_Txn_Testdata.xls";
       			
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
       				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
       			    LendNationSignContract.signContract(SSN, AppURL);
       				          				  				 
       				
       				if(ReceiveType.equalsIgnoreCase("Cash At Store"))
      			    {		  				
      				QCCSR_PAM.CashAtStore(SSN, AppURL);
      				
      				QCCSR_PAM.PAMLogin(SSN, AppURL);
    				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
      			    }
      			
      			else{
      				QCCSR_PAM.PAMLogin(SSN, AppURL);
      				QCCSR_PAM.PAMScreen_Validation(SSN, AppURL, loan_number);
      				
      			    }
     	
         }
         }
         }
         
       	 catch (Exception e) {
      			System.out.println("under catch of Test" + e);
      			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_01_MOILP_Txn_Testdata");
      			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
      			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_01_MOILP_Txn_Testdata Transaction Failed ");			
      		
      		}
       	}
		
          //===================================== SSN = 993838262-993838263 Acct No = 0097-0098 ================================================ 
      
          // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
         
    @Test(priority = 2, groups = "Ratikanta_Sprint7_REQ_868_ILP")
            public static void QC_Sprint7_Online_TS_B20_744_03_MOILP_Txn_Testdata() throws Exception {
           
          	  try {
          		 test = reports.startTest(("Online_MOILP_Sprint7_TS_B20_744_03"),  					  		    
          	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Login PAM-->Validation after Negotiate Loan-->Login Lendnation To Complete ESign");
          	   			String FileName = "QC_Sprint7_Online_TS_B20_744_03_MOILP_Txn_Testdata.xls";
          			
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
          				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
          			    LendNationSignContract.signContract(SSN, AppURL);
          				          				  				 
          				
          				if(ReceiveType.equalsIgnoreCase("Cash At Store"))
         			    {		  				
         				QCCSR_PAM.CashAtStore(SSN, AppURL);
         				
         				QCCSR_PAM.PAMLogin(SSN, AppURL);
       				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
         			    }
         			
         			else{
         				
         				QCCSR_PAM.PAMLogin(SSN, AppURL);
         				QCCSR_PAM.PAMScreen_Esign(SSN, AppURL, loan_number);        				
        				
        				LendNationLoggin.esignature(SSN, AppURL);
         				
         			    }
        	
            }
            }
            }
            
          	 catch (Exception e) {
         			System.out.println("under catch of Test" + e);
         			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_03_MOILP_Txn_Testdata");
         			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
         			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_03_MOILP_Txn_Testdata Transaction Failed ");			
         		
         		}
          	}
      
            //===================================== SSN = 993838264-993838265 Acct No = 0099-0100 ================================================ 
            
            // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
               
     @Test(priority = 3, groups = "Ratikanta_Sprint7_REQ_868_ILP")
                  public static void QC_Sprint7_Online_TS_B20_744_04_MOILP_Txn_Testdata() throws Exception {
                 
                	  try {
                		 test = reports.startTest(("Online_MOILP_Sprint7_TS_B20_744_04"),  					  		    
                	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Login PAM-->Validation after Negotiate Loan-->Login Lendnation To Complete ESign-->Verification In PAM");
                	   			String FileName = "QC_Sprint7_Online_TS_B20_744_04_MOILP_Txn_Testdata.xls";
                			
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
                				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
                			    LendNationSignContract.signContract(SSN, AppURL);
                				          				  				 
                				
                		if(ReceiveType.equalsIgnoreCase("Cash At Store"))
               			    {		  				
               				QCCSR_PAM.CashAtStore(SSN, AppURL);
               				
               				QCCSR_PAM.PAMLogin(SSN, AppURL);
             				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
               			    }
               			
               			else{
               				
               				QCCSR_PAM.PAMLogin(SSN, AppURL);
               				QCCSR_PAM.PAMScreen_Esign(SSN, AppURL, loan_number);        				
              				
              				LendNationLoggin.esignature_moilp(SSN, AppURL);
               				
               			    }
                			QCCSR_PAM.PAMLogin(SSN, AppURL);
                  			QCCSR_PAM.PAMScreen_Validation_AfterEsign(SSN, AppURL, loan_number);
                			   
                  }
                  }
                  }
                  
                	 catch (Exception e) {
               			System.out.println("under catch of Test" + e);
               			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_04_MOILP_Txn_Testdata");
               			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
               			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_04_MOILP_Txn_Testdata Transaction Failed ");			
               		
               		}
                	}
                  
               //===================================== SSN = 993838266-993838267 Acct No = 0101-0102 ================================================ 
                  
               // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
                     
       @Test(priority = 4 , groups = "Ratikanta_Sprint7_REQ_868_ILP")
            public static void QC_Sprint7_Online_TS_B20_744_05_MOILP_Txn_Testdata() throws Exception {
                       
                      	  try {
                      		 test = reports.startTest(("Online_MOILP_Sprint7_TS_B20_744_05"),  					  		    
                      	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Login PAM-->Validation after Negotiate Loan-->Login Lendnation To Complete ESign-->Verify Application Status Is On Pending Approval");
                      	   			String FileName = "QC_Sprint7_Online_TS_B20_744_05_MOILP_Txn_Testdata.xls";
                      			
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
                      				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
                      			    LendNationSignContract.signContract(SSN, AppURL);
                      				          				  				 
                      				
                      		if(ReceiveType.equalsIgnoreCase("Cash At Store"))
                     			    {		  				
                     				QCCSR_PAM.CashAtStore(SSN, AppURL);
                     				
                     				QCCSR_PAM.PAMLogin(SSN, AppURL);
                   				    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
                     			    }
                     			
                     			else{
                     				
                     				QCCSR_PAM.PAMLogin(SSN, AppURL);
                     				QCCSR_PAM.PAMScreen_Esign(SSN, AppURL, loan_number);        				
                    				
                    				LendNationLoggin.esignature_moilp(SSN, AppURL);
                     				
                     			    }
                      			    QCCSR_PAM.PAMLogin(SSN, AppURL);
                        			QCCSR_PAM.PAMScreen_ApplicationStatus_validation(SSN, AppURL, loan_number);
                      			   
                        }
                        }
                        }
                        
                      	 catch (Exception e) {
                     			System.out.println("under catch of Test" + e);
                     			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_05_MOILP_Txn_Testdata");
                     			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
                     			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_05_MOILP_Txn_Testdata Transaction Failed ");			
                     		
                     		}
                      	}
            
			      	  
            
         
        
         	 //===================================== SSN = 993838268-993838269 Acct No = 0103-0104 ================================================ 
         	   
             // Receive Type as : "ACH" and Repayment Method  as  : "ACH"   
             
        @Test(priority = 6, groups = "Ratikanta_Sprint7_REQ_868_ILP")
             
             public static void QC_Sprint7_Online_TS_B20_744_14_WIILP_Txn_Testdata() throws Exception {
            
           	  try {
           		 test = reports.startTest(("Online_WIILP_Sprint7_TS_B20_744_14_744_15_3Tier"),  					  		    
           	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->-->Login PAM-->Validation after Negotiate Loan");
           	   			String FileName = "QC_Sprint7_Online_TS_B20_744_14_WIILP_Txn_Testdata.xls";
           			
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
           				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	            				
           				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
           			       
           				QCCSR_PAM.PAMLogin(SSN, AppURL);
           				                //QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
           				QCCSR_PAM.PAMScreen_Validation(SSN, AppURL, loan_number);
           				
           				               //LendNationLoggin.esignature(SSN, AppURL);
           				
             }
             }
             }
             
           	 catch (Exception e) {
          			System.out.println("under catch of Test" + e);
          			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_14_WIILP_Txn_Testdata");
          			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
          			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_14_WIILP_Txn_Testdata Failed ");			
          		
          		}
           	}
             
           //===================================== SSN = 993838270-993838271 Acct No = 0105-0106 ================================================ 
       	   
             // Receive Type as : "ACH" and Repayment Method  as  : "ACH"   
             
		             //@Test(priority = 7, groups = "Ratikanta_Sprint7_REQ_868_ILP")
		             
		             public static void QC_Sprint7_Online_TS_B20_744_16_WIILP_Txn_Testdata() throws Exception {
		            
		           	  try {
		           		 test = reports.startTest(("Online_WIILP_Sprint7_TS_B20_744_16_3Tier"),  					  		    
		           	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->Login PAM-->Validation after Negotiate Loan-->Login Lendnation To Complete ESign");
		           	   			String FileName = "QC_Sprint7_Online_TS_B20_744_16_WIILP_Txn_Testdata.xls";
		           			
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
		           				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	            				
		           				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
		           			       
		           				QCCSR_PAM.PAMLogin(SSN, AppURL);
		           				               
		                        QCCSR_PAM.PAMScreen_WIILPEsign(SSN, AppURL, loan_number);        				
		        				
		        				LendNationLoggin.esignature(SSN, AppURL);
		           				
		             }
		             }
		             }
		             
		           	 catch (Exception e) {
		          			System.out.println("under catch of Test" + e);
		          			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_16_WIILP_Txn_Testdata");
		          			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		          			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_16_WIILP_Txn_Testdata Failed ");			
		          		
		          		}
		           	}
        
      //===================================== SSN = 993838272-993838273 Acct No = 0107-0108 ================================================ 
    	   
        // Receive Type as : "ACH" and Repayment Method  as  : "ACH"   
        
   @Test(priority = 8, groups = "Ratikanta_Sprint7_REQ_868_ILP")
        
        public static void QC_Sprint7_Online_TS_B20_744_18_WIILP_Txn_Testdata() throws Exception {
       
      	  try {
      		 test = reports.startTest(("Online_WIILP_Sprint7_TS_B20_744_18_3Tier"),  					  		    
      	   			"Lend Nation Login-->Registration-->Generate Online WI ILP Loan With ACH-->-->Login PAM-->Validation after Negotiate Loan-->Login Lendnation To Complete ESign-->Verification In PAM");
      	   			String FileName = "QC_Sprint7_Online_TS_B20_744_18_WIILP_Txn_Testdata.xls";
      			
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
      				LendNationLoanDecision.wiilp_loandecision(SSN, AppURL);	            				
      				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
      			       
      				QCCSR_PAM.PAMLogin(SSN, AppURL);
      				QCCSR_PAM.PAMScreen_ApplicationStatus_validation(SSN, AppURL, loan_number);                
                   
      				
        }
        }
        }
        
      	 catch (Exception e) {
     			System.out.println("under catch of Test" + e);
     			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_18_WIILP_Txn_Testdata");
     			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
     			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_18_WIILP_Txn_Testdata Failed ");			
     		
     		}
      	}
        
      //=======================================  ON LINE MO ILP Refinance(InProg)  ================================================ 
  	     //=======================================  ON LINE MO ILP // SSN = 993838274-993838275 Acct No = 0109-0110 ================================================ 
  	   
  		 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
       
    @Test(priority = 9, groups = "Ratikanta_Sprint7_REQ_868_ILP_1")
        public static void QC_Sprint7_Online_TS_B20_744_08_MOILP_Txn_Testdata() throws Exception {
      
     	  try {
     		 test = reports.startTest(("QC_Online_MOILP_ACH_ReceiveType As ACH"),  					  		    
     	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
     	   			String FileName = "QC_Sprint7_Online_TS_B20_744_08_MOILP_Txn_Testdata.xls";
     			
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
     				LendNationLoanDecision.moilp_loandecision(SSN, AppURL);			    			            
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
    			String screenshotPath = getScreenhot(driver, "QC_Sprint7_Online_TS_B20_744_08_MOILP_Txn_Testdata");
    			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
    			test.log(LogStatus.FAIL, "QC_Sprint7_Online_TS_B20_744_08_MOILP_Txn_Testdata Transaction Failed ");			
    		
    		}
     	}
    
    
  //=======================================  ON LINE IL ILP  ================================================ 
  //=======================================  ON LINE IL ILP // SSN = 993838280-993838281 Acct No = 0111-0112 ================================================ 
   
	// Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 
 
     @Test(priority = 1, groups = "Ratikanta_Online_ILILP")
     public static void QC_Sprint_Online_ILILP_ACH_CashAtStore_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_ILILP_ACH_ReceiveType As CashAtStore"),  					  		    
	   			"Lend Nation Login->Generate Online IL ILP Loan With CashAtStore-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 455 Store");
	   			String FileName = "QC_Sprint_Online_ILILP_ACH_CashAtStore_Txn_Testdata.xls";
			
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
 				LendNationLoanDecision.ililp_loandecision(SSN, AppURL);
 				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
 				
 				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
   				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
   				  				        
				LendNationLoggin.il_ilp_cashatstore_esignature(SSN, AppURL);
				
				QCCSR_PAM.PAMLogin_with_455(SSN, AppURL);
   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
				
 }
 }
 }
 
	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_ILILP_ACH_CashAtStore_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_Online_ILILP_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
		
		}
	}

//=======================================  ON LINE IL ILP  ================================================ 
//=======================================  ON LINE IL ILP // SSN = 993838282-993838283 Acct No = 0113-0114 ================================================ 
 
	// Receive Type as : "ACH" and Repayment Method  as  : "ACH" 

		@Test(priority = 2, groups = "Ratikanta_Online_ILILP")
		public static void QC_Sprint_Online_ILILP_ACH_Txn_Testdata() throws Exception {

	     try {
		 test = reports.startTest(("QC_Online_ILILP_ACH_ReceiveType As ACH"),  					  		    
	   			"Lend Nation Login->Generate Online IL ILP Loan With ACH-->ESign Process In PAM (2997 Store) For ACH-->Login Lendnation To Complete Esign And Loan Orgination");
	   			String FileName = "QC_Sprint_Online_ILILP_ACH_Txn_Testdata.xls";
			
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
				LendNationLoanDecision.ililp_loandecision(SSN, AppURL);
				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
				
				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
 				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
 				  				        
 				LendNationLoggin.ililp_esignature(SSN, AppURL);
				
}
}
}

	 catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_ILILP_ACH_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_Online_ILILP_ACH_Txn_Testdata Transaction Failed ");			
		
		}
	}
		
		//=======================================  ON LINE IL ILP  ================================================ 
		//=======================================  ON LINE IL ILP // SSN = 993838284-993838285 Acct No = 0115-0116 ================================================ 
		   
		// Receive Type as : "Cash At Store" and Repayment Method  as  : "DEBIT CARD" 
		 
		@Test(priority = 3, groups = "Ratikanta_Online_ILILP")
		 public static void QC_Sprint_Online_ILILP_DC_CashAtStore_Txn_Testdata() throws Exception {

			  try {
				 test = reports.startTest(("QC_Online_ILILP_DC_ReceiveType As CashAtStore"),  					  		    
			   			"Lend Nation Login->Generate Online IL ILP Loan With DC-->Approve Loan In PAM (2997 Store) For Cash At Store-->Complete Loan in 455 Store");
			   			String FileName = "QC_Sprint_Online_ILILP_DC_CashAtStore_Txn_Testdata.xls";
					
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
		 				LendNationLoanDecision.ililp_loandecision(SSN, AppURL);
		 				LendNationLoggin.wiilp_loancapture(SSN, AppURL);
		 				
		 				QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
		   				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
		   				  				        
						LendNationLoggin.il_ilp_dc_esignature(SSN, AppURL);
						
						QCCSR_PAM.PAMLogin_with_455(SSN, AppURL);
		   				QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
						
		 }
		 }
		 }
		 
			 catch (Exception e) {
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_ILILP_DC_CashAtStore_Txn_Testdata");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.FAIL, "QC_Sprint_Online_ILILP_DC_CashAtStore_Txn_Testdata Transaction Failed ");			
				
				}
			}
		
		//=======================================  ON LINE IL ILP  ================================================ 
		//=======================================  ON LINE IL ILP // SSN = 993838284-993838285 Acct No = 0115-0116 ================================================ 
		 
		// Receive Type as : "ACH" and Repayment Method  as  : "Debit Card" 

		 @Test(priority = 4, groups = "Ratikanta_Online_ILILP")
		  public static void QC_Sprint_Online_ILILP_DC_ACH_Txn_Testdata() throws Exception {

			     try {
				 test = reports.startTest(("QC_Online_ILILP_ACH_ReceiveType As ACH"),  					  		    
			   			"Lend Nation Login->Generate Online IL ILP Loan With DC-->ESign Process In PAM (2997 Store) For ACH-->Login Lendnation To Complete Esign And Loan Orgination");
			   			String FileName = "QC_Sprint_Online_ILILP_DC_ACH_Txn_Testdata.xls";
					
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
						LendNationLoanDecision.ililp_loandecision(SSN, AppURL);
						LendNationLoggin.wiilp_loancapture(SSN, AppURL);
						
						QCCSR_PAM.PAMLogin(SSN, AppURL);       				                                 
		 				QCCSR_PAM.PAM_ACH_ESign(SSN, AppURL, loan_number);
		 				  				         				
		 			    LendNationLoggin.il_ilp_dc_esignature(SSN, AppURL);
						
		}
		}
		}

			 catch (Exception e) {
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_Sprint_Online_ILILP_DC_ACH_Txn_Testdata");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.FAIL, "QC_Sprint_Online_ILILP_DC_ACH_Txn_Testdata Transaction Failed ");			
				
				}
			}
		 
		 
		//=======================================  ON LINE NM ILP  ================================================ 
   	     //=======================================  ON LINE NM ILP // SSN = 993838286-993838287 Acct No = 0117-0118 ================================================ 
   	   
   		 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 
        
     @Test(priority = 1, groups = "Ratikanta_Online_NMILP")
        public static void QC_Online_NMILP_ACH_Txn_Testdata() throws Exception {
       
      	  try {
      		 test = reports.startTest(("QC_Online_NMILP_ACH_ReceiveType As ACH"),  					  		    
      	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
      	   			String FileName = "QC_Online_NMILP_ACH_Txn_Testdata.xls";
      			
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
      				LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			            
      			    LendNationSignContract.nmilp_ach_signContract(SSN, AppURL);
      				          				  				 
      				
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
     			String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_ACH_Txn_Testdata");
     			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
     			test.log(LogStatus.FAIL, "QC_Online_NMILP_ACH_Txn_Testdata Transaction Failed ");			
     		
     		}
      	}
     
   //=======================================  ON LINE NM ILP  ================================================ 
	     //=======================================  ON LINE NM ILP // SSN = 993838288-993838289 Acct No = 0119-0120 ================================================ 
	   
		 // Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 
    
 @Test(priority = 2, groups = "Ratikanta_Online_NMILP")
    public static void QC_Online_NMILP_DC_ACH_Txn_Testdata() throws Exception {
   
  	  try {
  		 test = reports.startTest(("QC_Online_NMILP_DC_ReceiveType As ACH"),  					  		    
  	   			"Lend Nation Login->Generate Online ILP Loan With DC-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
  	   			String FileName = "QC_Online_NMILP_DC_ACH_Txn_Testdata.xls";
  			
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
  				LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			              			          
  				LendNationSignContract.nmilp_dc_ACH_signContract(SSN, AppURL);
  				          				  				 
  				
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
 			String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_DC_ACH_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Online_NMILP_DC_ACH_Txn_Testdata Transaction Failed ");			
 		
 		}
  	}
 
 
//=======================================  ON LINE UT ILP  ================================================ 
    //=======================================  ON LINE UT ILP // SSN = 993838288-993838289 Acct No = 0119-0120 ================================================ 
  
	 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 

@Test(priority = 1, groups = "Ratikanta_Online_UTILP")
public static void QC_Online_UTILP_ACH_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_UTILP_ACH_ReceiveType As ACH"),  					  		    
	   			"Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
	   			String FileName = "QC_Online_UTILP_ACH_Txn_Testdata.xls";
			
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
				LendNationLoanDecision.utilp_loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.nmilp_ach_signContract(SSN, AppURL);
				          				  				 
				
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
			String screenshotPath = getScreenhot(driver, "QC_Online_UTILP_ACH_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Online_UTILP_ACH_Txn_Testdata Transaction Failed ");			
		
		}
	}

//=======================================  ON LINE UT ILP // SSN = 993838290-993838291 Acct No = 0121-0122 ================================================ 

// Receive Type as : "Cash At Store" and Repayment Method  as  : "ACH" 

@Test(priority = 2, groups = "Ratikanta_Online_UTILP")
public static void QC_Online_UTILP_ACH_CashAtStore_Txn_Testdata() throws Exception {

 try {
	 test = reports.startTest(("QC_Online_UTILP_ACH_ReceiveType As CashAtStore"),  					  		    
  			"Lend Nation Login->Generate Online ILP Loan With Cash At Store-->Approve Loan In PAM (2997 Store)For Cash At Store-->Complete Loan in 700 Store");
	        
	     String FileName = "QC_Online_UTILP_ACH_CashAtStore_Txn_Testdata.xls";
		
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
			LendNationLoanDecision.utilp_loandecision(SSN, AppURL);			    			            
			LendNationSignContract.ilp_cashatstore_signContract(SSN, AppURL);
	  				 
				
		    if(ReceiveType.equalsIgnoreCase("Cash At Store"))
			 {		  				
	        QCCSR_PAM.CashAtStore(SSN, AppURL);
				
			QCCSR_PAM.PAMLogin_CashAtStore(SSN, AppURL);
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
		String screenshotPath = getScreenhot(driver, "QC_Online_UTILP_ACH_CashAtStore_Txn_Testdata");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "QC_Online_UTILP_ACH_CashAtStore_Txn_Testdata Transaction Failed ");			
	
	}
}


//=======================================  ON LINE UT ILP // SSN = 993838292-993838293 Acct No = 0123-0124 ================================================ 

	 // Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 

@Test(priority = 3, groups = "Ratikanta_Online_UTILP")
public static void QC_Online_UTILP_DC_ACH_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_UTILP_DC_ACH_ReceiveType As ACH"),  					  		    
	   			"Lend Nation Login->Generate Online ILP Loan With DEBIT CARD-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM");
	   			String FileName = "QC_Online_UTILP_DC_ACH_Txn_Testdata.xls";
			
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
				LendNationLoanDecision.utilp_loandecision(SSN, AppURL);			    			            
				LendNationSignContract.utilp_dc_ACH_signContract(SSN, AppURL);
				          				  				 
				
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
			String screenshotPath = getScreenhot(driver, "QC_Online_UTILP_DC_ACH_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Online_UTILP_DC_ACH_Txn_Testdata Transaction Failed ");			
		
		}
	}


//=======================================  ON LINE UT ILP // SSN = 993838294-993838295 Acct No = 0125-0126 ================================================ 

//Receive Type as : "Cash At Store" and Repayment Method  as  : "DEBIT CARD" 

@Test(priority = 4, groups = "Ratikanta_Online_UTILP")
public static void QC_Online_UTILP_DC_CashAtStore_Txn_Testdata() throws Exception {

try {
	 test = reports.startTest(("QC_Online_UTILP_DC_ReceiveType As CashAtStore"),  					  		    
			"Lend Nation Login->Generate Online ILP Loan With DC and Cash At Store-->Approve Loan In PAM (2997 Store)For Cash At Store-->Complete Loan in 700 Store");
	        
	     String FileName = "QC_Online_UTILP_DC_CashAtStore_Txn_Testdata.xls";
		
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
			LendNationLoanDecision.utilp_loandecision(SSN, AppURL);			    			            
			LendNationSignContract.ilp_dc_CashatStore_signContract(SSN, AppURL);
	  				 
				
		    if(ReceiveType.equalsIgnoreCase("Cash At Store"))
			 {		  				
	        QCCSR_PAM.CashAtStore(SSN, AppURL);
				
			QCCSR_PAM.PAMLogin_CashAtStore(SSN, AppURL);
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
		String screenshotPath = getScreenhot(driver, "QC_Online_UTILP_DC_CashAtStore_Txn_Testdata");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "QC_Online_UTILP_DC_CashAtStore_Txn_Testdata Transaction Failed ");			
	
	}
}



//####################### NM ILP Refinance Started ###########################

//=======================================  ON LINE NM ILP  ================================================ 
   //=======================================  ON LINE NM ILP // SSN = 993838286-993838287 Acct No = 0117-0118 ================================================ 
 
	 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 

@Test(priority = 1, groups = "Ratikanta_Online_NMILP_Refinance_1")
public static void QC_Online_NMILP_ACH_Refinance_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_NMILP_ACH_Refinance_ReceiveType As ACH"),  					  		    
	   			
		 "Set the Store date(2024,2997) to current date->Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Refinance");
		 String FileName = "QC_Online_NMILP_ACH_Refinance_Txn_Testdata.xls";
		 
			
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
				
				OnlineStore_DB_Date_Setup.nm_ilp_datesetup(SSN, AppURL);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.nmilp_ach_signContract(SSN, AppURL);				          				  				 		
		
			    QCCSR_PAM.PAMLogin(SSN, AppURL);
			    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
			    
			    OnlineStore_DB_Date_Setup.accuraldate();

			    OnlineStore_DB_Date_Setup.nm_strdate();
			    			    			    
			    
			    LendNationLoggin.nm_ilp_refinance(SSN, AppURL);
			
		  

}
}
}

	 catch (Exception e) {
		System.out.println("under catch of Test" + e);
		String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_ACH_Refinance_Txn_Testdata");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "QC_Online_NMILP_ACH_Refinance_Txn_Testdata Transaction Failed ");			
	
	}
	}

//=======================================  ON LINE NM ILP  ================================================ 
//=======================================  ON LINE NM ILP // SSN = 993838288-993838289 Acct No = 0119-0120 ================================================ 

// Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 

@Test(priority = 2, groups = "Ratikanta_Online_NMILP_Refinance")
public static void QC_Online_NMILP_DC_ACH_Refinance_Txn_Testdata() throws Exception {

try {
	 test = reports.startTest(("QC_Online_NMILP_DC_Refinance_ReceiveType As ACH"),  					  		    
			"Set the Store date(2024,2997) to current date->Lend Nation Login->Generate Online ILP Loan With DC-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM->Capture Accrual Date->Capture ST Date->Refinance");
			String FileName = "QC_Online_NMILP_DC_ACH_Refinance_Txn_Testdata.xls";
		
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
			
			OnlineStore_DB_Date_Setup.nm_ilp_datesetup(SSN, AppURL);
			
			LendNationRegistration.registration(SSN, AppURL);
			LendNationPersonalInformation.personalInformation(SSN, AppURL);
		    LendNationFinancialInformation.financialInformation(SSN, AppURL);
		    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
			LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			              			          
			LendNationSignContract.nmilp_dc_ACH_signContract(SSN, AppURL);
			          				  				 
			
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
			OnlineStore_DB_Date_Setup.accuraldate();

		    OnlineStore_DB_Date_Setup.nm_strdate();
		    
		    LendNationLoggin.nm_ilp_refinance(SSN, AppURL);

}
}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_DC_ACH_Refinance_Txn_Testdata");
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.FAIL, "QC_Online_NMILP_DC_ACH_Refinance_Txn_Testdata Transaction Failed ");			

}
}






//####################### NM ILP Payment Started ###########################

//=======================================  ON LINE NM ILP  ================================================ 
 //=======================================  ON LINE NM ILP // SSN = 993838290-993838291 Acct No = 0121-0122 ================================================ 

	 // Receive Type as : "ACH" and Repayment Method  as  : "ACH" 

@Test(priority = 1, groups = "Ratikanta_Online_NMILP_Payment")
public static void QC_Online_NMILP_ACH_Payment_Txn_Testdata() throws Exception {

	  try {
		 test = reports.startTest(("QC_Online_NMILP_ACH_Payment_ReceiveType As ACH"),  					  		    
	   			
		 "Set the Store date(2024,2997) to current date->Lend Nation Login->Generate Online ILP Loan With ACH-->Approve Loan In PAM (2997 Store)-->Complete Loan in 2997 Store->Capture Accrual Date->Capture ST Date->Payment");
		 String FileName = "QC_Online_NMILP_ACH_Payment_Txn_Testdata.xls";
		 
			
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
				
				OnlineStore_DB_Date_Setup.nm_ilp_datesetup(SSN, AppURL);
				
				LendNationRegistration.registration(SSN, AppURL);
				LendNationPersonalInformation.personalInformation(SSN, AppURL);
			    LendNationFinancialInformation.financialInformation(SSN, AppURL);
			    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
				LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			            
			    LendNationSignContract.nmilp_ach_signContract(SSN, AppURL);				          				  				 		
		
			    QCCSR_PAM.PAMLogin(SSN, AppURL);
			    QCCSR_PAM.PAM_ACH(SSN, AppURL, loan_number);
			    
			    OnlineStore_DB_Date_Setup.accuraldate();

			    OnlineStore_DB_Date_Setup.nm_strdate();
			    
			    OnlineStore_DB_Date_Setup.nm_ilp_datesetup_to_accrualdate(SSN, AppURL);
			    
			    LendNationLoggin.nm_ilp_ach_payment(SSN, AppURL);
			
		  

}
}
}

	 catch (Exception e) {
		System.out.println("under catch of Test" + e);
		String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_ACH_Payment_Txn_Testdata");
		test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
		test.log(LogStatus.FAIL, "QC_Online_NMILP_ACH_Payment_Txn_Testdata Transaction Failed ");			
	
	}
	}

//=======================================  ON LINE NM ILP  ================================================ 
//=======================================  ON LINE NM ILP // SSN = 993838292-993838293 Acct No = 0123-0124 ================================================ 

//Receive Type as : "ACH" and Repayment Method  as  : "DEBIT CARD" 

@Test(priority = 2, groups = "Ratikanta_Online_NMILP_Payment_1")
public static void QC_Online_NMILP_DC_ACH_Payment_Txn_Testdata() throws Exception {

try {
	 test = reports.startTest(("QC_Online_NMILP_DC_Payment_ReceiveType As ACH"),  					  		    
			"Set the Store date(2024,2997) to current date->Lend Nation Login->Generate Online ILP Loan With DC-->Approve Loan In PAM (2997 Store)-->Complete Loan in PAM->Capture Accrual Date->Capture ST Date->Payment");
			String FileName = "QC_Online_NMILP_DC_ACH_Payment_Txn_Testdata.xls";
		
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
			
			OnlineStore_DB_Date_Setup.nm_ilp_datesetup(SSN, AppURL);
			
			LendNationRegistration.registration(SSN, AppURL);
			LendNationPersonalInformation.personalInformation(SSN, AppURL);
		    LendNationFinancialInformation.financialInformation(SSN, AppURL);
		    LendNationRepaymentInformation.repaymentInformation(SSN, AppURL);			    
			LendNationLoanDecision.nmilp_loandecision(SSN, AppURL);			    			              			          
			LendNationSignContract.nmilp_dc_ACH_signContract(SSN, AppURL);
			          				  				 
			
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
			OnlineStore_DB_Date_Setup.accuraldate();

		    OnlineStore_DB_Date_Setup.nm_strdate();
		    
		    OnlineStore_DB_Date_Setup.nm_ilp_datesetup_to_accrualdate(SSN, AppURL);
		    
		    LendNationLoggin.nm_ilp_dc_payment(SSN, AppURL);

}
}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_Online_NMILP_DC_ACH_Payment_Txn_Testdata");
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.FAIL, "QC_Online_NMILP_DC_ACH_Payment_Txn_Testdata Transaction Failed ");			

}
}


		


     
    

//============================================================================================================================
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

						new FileReader("C:/Qc_Batch_WildFly/QC_Online_ILP/src/test/java/tests/Objects.properties"));

				prop = new Properties();
				prop.load(Rreader);
				Rreader.close();
				csr_url = prop.getProperty("CSR_URL");
				csrloginpage = prop.getProperty("Login_Page");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				DBUserName = prop.getProperty("DB_UserName");
				DBPassword = prop.getProperty("DB_Password");
				
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

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/ILP/FailedTestsScreenshots/"
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
