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
	public static Properties Rprop;
	public static Properties Aprop;
	public static Properties Vprop;
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
	public static String CouponNumber;
	public static String DBUserName;
	public static String DBPassword;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String LOCamount;
	public static String Statementdate;
	public static String loan_nbr;
	public static String key;
	public static String NextDueDate;
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
	
	
	

	
	
//================================  RATIKANTA  Accounting Scenarios  ====================================================

	             // ----------------TX PDL  Accounting Scenarios Starts ----------------
	
	             // =========== Store Used For Texas is 1031 Start Date=12/05/2019 =================
	

    @Test(priority = 1, groups = "Ratikanta_TXPDL_Accounting")
     
     public static void QC_Accounting_Deposit_Return_NSFPayment_WithoutWaive_Void_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("TXPDL_Deposit_Return_NSFPayment(Without Waive)_Void"),

						
			    "CSR Login->Borrower Registration-->NewLoan-->DueDate-->Check Deposit-->Return-->NSFPayment(Without Waive)-->Void");
				String FileName = "QC_Accounting_Deposit_Return_NSFPayment_WithoutWaive_Void_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
						

						System.out.println(AppURL);
						QCCSRLoginLogout.adminLogin(SSN, SSN);						
						RAdminStoreDate.txpdl_toStartdate(SSN, AppURL);															
						RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);
						RProcTest.txpdl_proc();						
						
						Thread.sleep(2000);	
					

						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);						
						RQCCSRLoginLogout.logout(SSN, AppURL);												
						
						RQCCSRLoginLogout.login(SSN, AppURL);						      
						RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCDepositDropdown.depositDropDown(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
												
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						         //RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCNSFPayment.nsfpayment_withoutwave(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCVoid.qcVoid(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Accounting_Deposit_Return_NSFPayment_WithoutWaive_Void_Txn");
				
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				
				

			}
		}	
 
    @Test(priority = 2, groups = "Ratikanta_TXPDL_Accounting")
     
     public static void QC_Accounting_Deposit_Return_NSFPayment_WithWaive_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("TXPDL_Deposit_Return_NSFPayment(With Waive)"),

						
			    
				"CSR Login->Borrower Registration-->NewLoan-->DueDate-->Check Deposit-->Return-->NSF Payment-->Void-->Again Validate NSFPayment With Waive(Shouldn't Allow Payment)");
				String FileName = "QC_Accounting_Deposit_Return_NSFPayment_WithWaive_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);
					
						System.out.println(AppURL);										
						
						Thread.sleep(2000);	
					
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);						 
						RQCCSRNewLoan.newLoan(SSN, AppURL);	
						RQCCSRLoginLogout.logout(SSN, AppURL);												
						
						RQCCSRLoginLogout.login(SSN, AppURL);						      
						RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCDepositDropdown.depositDropDown(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRInternalTransfer.internaltransfer(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
												
						RQCCSRReturnPosting.returnposting(SSN, AppURL);
						         //RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCNSFPayment.nsfpayment_withoutwave(SSN, AppURL);					
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCVoid.qcVoid(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCNSFPayment.nsfpayment_withwave(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
																						
						/*RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory1.history(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);*/
						

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Accounting_Deposit_Return_NSFPayment_WithWaive_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
				
			
			}
		}
     
 @Test(priority = 3, groups = "Ratikanta_TXPDL_Accounting")
     
     public static void QC_Accounting_TexasPDL_Loan_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("TXPDL_NewLoan_ValidateDB"),

						
			    
				"CSR Login->Borrower Registration-->NewLoan-->Validate Value From Data Base");
				String FileName = "TXPDL_TexasPDL_Loan_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);						
						RQCCSRLoginLogout.logout(SSN, AppURL);												
						
						RQCCSRLoginLogout.login(SSN, AppURL);						      
						RQCValidation.validation(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);					

					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Accounting_TexasPDL_Loan_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.ERROR, "Unable to start scenarios ");
						
			}
		}
 
                       // ----------------MO PDL  Accounting Scenarios Starts ----------------
	
                      // =========== Store Used For MO PDL is 590 Start Date=05/01/2019 =================
     
 @Test(priority = 4, groups = "Ratikanta_MOPDL_Accounting")
 
 public static void QC_Accounting_Deposit_Return_NSFPayment_WithWaive1_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("MOPDL_Loan_DCDeposit_Return_Redeposit_Return"),

					
		    
			"CSR Login->Borrower Registration-->NewLoan-->DueDate-->DC Deposit-->Return-->Redeposit-->Return");
			String FileName = "QC_PDL_Loan_DCDeposit_Return_Redeposit_Return_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);						
					RAdminStoreDate.mopdl_toStartdate(SSN, AppURL);															
					RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);
					RProcTest.mopdl_proc();
					Thread.sleep(2000);	
				
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DC_Deposit.dc_depositDropDown(SSN, AppURL);					
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQC_DC_DBReturn.dcreturn_proc();					
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DCReturn_Validation.dbreturn_validation(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
															
					RQC_DC_DBReturn.redepositDC(SSN);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_DC_Redeposit.csrredepositDC(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
		

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_DCDeposit_Return_Redeposit_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
					
		}
	}
 
 @Test(priority = 5, groups = "Ratikanta_MOPDL_Accounting")
 
 public static void QC_PDL_Loan_DCDeposit_Return_NSFPayment_Less_Redeposit_Return_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("MOPDL_Loan_DCDeposit_Return_NSF Payment_Less_Redeposit_Return"),

					
		    
			"CSR Login->Borrower Registration-->NewLoan-->DueDate-->DC Deposit-->Return-->NSF Payment-->Redeposit-->Return");
			String FileName = "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Less_Redeposit_Return_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
				
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DC_Deposit.dc_depositDropDown(SSN, AppURL);					
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQC_DC_DBReturn.dcreturn_proc();					
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DCReturn_Validation.dbreturn_validation(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCNSFPayment.nsfpayment_less(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
															
					RQC_DC_DBReturn.redepositDC(SSN);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_DC_Redeposit.csrredepositDC(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);	

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Less_Redeposit_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
					
		}
	}
 
@Test(priority = 6, groups = "Ratikanta_MOPDL_Accounting")
 
 public static void QC_PDL_Loan_DCDeposit_Return_NSFPayment_Full_Redeposit_Return_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("MOPDL_Loan_DCDeposit_Return_NSF Payment_Full_Redeposit_Return"),

					
		    
			"CSR Login->Borrower Registration-->NewLoan-->DueDate-->DC Deposit-->Return-->Full NSF Payment-->Redeposit-->Return");
			String FileName = "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Full_Redeposit_Return_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
				
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DC_Deposit.dc_depositDropDown(SSN, AppURL);					
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQC_DC_DBReturn.dcreturn_proc();					
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DCReturn_Validation.dbreturn_validation(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCNSFPayment.nsfpayment_morethanearnfee(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
															
					RQC_DC_DBReturn.redepositDC(SSN);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_DC_Redeposit.csrredepositDC(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
		

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_DCDeposit_Return_NSFPayment_Full_Redeposit_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
					
		}
	}

@Test(priority = 7, groups = "Ratikanta_MOPDL_Accounting")

public static void QC_PDL_Loan_BuyBack_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("MOPDL_Loan_AgestoreGrace days_BuyBack_DB Validation"),

					
		    
			"CSR Login->Borrower Registration-->NewLoan-->GraceDays-->BuyBack-->Validate DB For Apportion Amount");
			String FileName = "QC_PDL_Loan_BuyBack_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
				
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					PDLBuyBack.buyback(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RDBValidation.apportionvalidation();
			
		

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_BuyBack_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
					
		}
	}



                  // ----------------LA PDL  Accounting Scenarios Starts ----------------

                // =========== Store Used For LA PDL is 354 Start Date=05/01/2019 =================
 
@Test(priority = 8, groups = "Ratikanta_LAPDL_Accounting")

public static void QC_LAPDL_DCDeposit_Return_Redeposit_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("LAPDL_Loan_DCDeposit_Return_Redeposit_Return"),

					
		    
			"CSR Login->Borrower Registration-->NewLoan-->DueDate-->DC Deposit-->Return-->Redeposit-->Return");
			String FileName = "QC_LAPDL_DCDeposit_Return_Redeposit_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
                    System.out.println(AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);						
					RAdminStoreDate.lapdl_toStartdate(SSN, AppURL);															
					RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);
					RProcTest.lapdl_proc();
					Thread.sleep(2000);	
				
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);						
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DC_Deposit.dc_depositDropDown(SSN, AppURL);					
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					RQC_DC_DBReturn.dcreturn_proc();					
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQC_DCReturn_Validation.dbreturn_validation(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
															
					RQC_DC_DBReturn.redepositDC(SSN);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_DC_Redeposit.csrredepositDC(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
		

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_DCDeposit_Return_Redeposit_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
					
		}
	}







    //===============================  ILP Accounting Scenarios Starts  ===================================
     
    //================================  Store Used 3236  ===================================================
     
 @Test(priority = 9, groups = "Ratikanta_ILP_Accounting")
     
     public static void QC_Payment_Payment2_BuyBack_ChargeBack_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("MOILP_Payment_Payment2_BuyBack_ChargeBack"),
									    
				"CSR Login->Borrower Registration-->NewLoan-->DueDate-->Payment1-->Grace Days-->Payment2-->Grace Days-->BuyBack-->ChargeBack-->Verification Fee Validation In DB & History");
				String FileName = "QC_Payment_Payment2_BuyBack_ChargeBack_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);		
						
						RProcTest.ilp_proc();
						Thread.sleep(2000);

						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRNewLoan.newLoan(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);						      
						RQCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment1(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment2(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCPayment.payment3(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						
						RQCCSRLoginLogout.login(SSN, AppURL);						
						RQCChargeBack.chargeback(SSN, AppURL);
						          
						RQCChargebackQuery.proc();
						
						RQCCSRLoginLogout.login(SSN, AppURL);
						RQCCSRHistory.historyverificationfee(SSN, AppURL);
						RQCCSRLoginLogout.logout(SSN, AppURL);
						

					}
				}
			}

			catch (Exception e) {
				//System.out.println("under catch of Test" + e);
				//String screenshotPath = getScreenhot(driver, "QC_Payment_Payment2_BuyBack_ChargeBack_Txn");
				//test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "Transaction Failed ");
				
			
			}
		}	
 
 @Test(priority = 10, groups = "Ratikanta_ILP_Accounting")
 
 public static void QC_Default_Refinance_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("MOILP_DefaultLoan_Refinance_Void"),
								    
			"CSR Login->Borrower Registration-->NewLoan-->Age the Store to make a Loan Default-->Refinance-->Void-->Validate DB For Void Posting");
			String FileName = "QC_Default_Refinance_Void_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault.sdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
										        					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefault_Refinance.refinance(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCVoid.qcVoid(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RDBValidation.ilpvoid_validation();
					

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Default_Refinance_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.ERROR, "Unable to start scenarios ");
			
		
		}
	}	
 

 
 
  
//----------------NV PDL & NV TLP  Accounting Scenarios Starts ----------------
	
  // =========== Store Used For NV PDL & NV TLP is 734 Start Date=05/01/2019 =================


@Test(priority = 11, groups = "Ratikanta_NVPDL_Accounting")

public static void QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentStore_Txn_Testdata() throws Exception {
try {
	test = reports.startTest(("NVPDL_Deposit_Return_EPP_EPPPayment_Deposit_Return_ReturnPaymentStore"),

			
 "CSR Login->Borrower Registration-->NVNewLoan-->DueDate-->Deposit-->Return-->EPP-->EPPPayment-->DueDate-->Deposit-->Return-->Return Payment through Store");
	String FileName = "QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentStore_Txn_Testdata.xls";
	                 
	
	TestData = new ExcelNew(System.getProperty("user.dir")
			+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	
	int lastrow = TestData.getLastRow("Start");
	String sheetName = "Start";
	
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {

		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
		if (RunFlag.equals("Y")) {
			
			String AppURL = TestData.getCellData(sheetName, "AppURL", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);

			System.out.println(AppURL);
			
			QCCSRLoginLogout.adminLogin(SSN, SSN);						
			RAdminStoreDate.nvpdl_toStartdate(SSN, AppURL);															
			RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);			
			RProcTest.nvpdl_proc();
			Thread.sleep(2000);
						
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSRNewLoan.newLoan(SSN, AppURL);						
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDepositDropdown.nvpdldeposit(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RBusinessDateCapture.businessdate(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
						
			RQCCSRReturnPosting.returnposting(SSN, AppURL);
			
			RQCAdminACHReturn.achreturn(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSREPP.epp(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCEPPPayment.epppayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDepositDropdown.nvpdldeposit(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RBusinessDateCapture.businessdate(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
						
			RQCCSRReturnPosting.returnposting(SSN, AppURL);
			
			RQCAdminACHReturn.achreturn(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			RQCCSRACHPayment.achpayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			RQCCSRNVPDLHistory.history(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			

		}
	}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentStore_Txn");
	
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.ERROR, "Unable to start scenarios ");
	
	

}
}	

@Test(priority = 12, groups = "Ratikanta_NVPDL_Accounting")

public static void QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentFullStore_Txn_Testdata() throws Exception {
try {
	test = reports.startTest(("NVPDL_Deposit_Return_EPP_EPPPayment_Deposit_Return_ReturnPaymentFullStore"),

			
 "CSR Login->Borrower Registration-->NVNewLoan-->DueDate-->Deposit-->Return-->EPP-->EPPPayment-->DueDate-->Deposit-->Return-->Return Payment Full through Store");
	String FileName = "QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentFullStore_Txn_Testdata.xls";
	                 
	
	TestData = new ExcelNew(System.getProperty("user.dir")
			+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	
	int lastrow = TestData.getLastRow("Start");
	String sheetName = "Start";
	
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {

		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
		if (RunFlag.equals("Y")) {
			
			String AppURL = TestData.getCellData(sheetName, "AppURL", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);

			System.out.println(AppURL);
						
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSRNewLoan.newLoan(SSN, AppURL);						
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDepositDropdown.nvpdldeposit(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RBusinessDateCapture.businessdate(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
						
			RQCCSRReturnPosting.returnposting(SSN, AppURL);
			
			RQCAdminACHReturn.achreturn(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSREPP.epp(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCEPPPayment.epppayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDepositDropdown.nvpdldeposit(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RBusinessDateCapture.businessdate(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
						
			RQCCSRReturnPosting.returnposting(SSN, AppURL);
			
			RQCAdminACHReturn.achreturn(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			RQCCSRACHPayment.fullachpayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			RQCCSRNVPDLHistory.history(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			

		}
	}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_NVPDL_Deposit_Return_Payment_Deposit_Return_ReturnPaymentFullStore_Txn");
	
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.ERROR, "Unable to start scenarios ");
	
	

}
}	

@Test(priority = 13, groups = "Ratikanta_NVTLP_Accounting")

public static void QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Txn_Testdata() throws Exception {
try {
	test = reports.startTest(("NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC"),

			
 "CSR Login->Borrower Registration-->NVNewLoanWithNOC-->Age Store to More than 2 Month-->Default-->Return-->EPP-->EPPPayment-->DB Validation For Payment Plan Posted or Not-->Application Validation for Payment Plan");
	String FileName = "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Txn_Testdata.xls";
	                 
	
	TestData = new ExcelNew(System.getProperty("user.dir")
			+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	
	int lastrow = TestData.getLastRow("Start");
	String sheetName = "Start";
	
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {

		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
		if (RunFlag.equals("Y")) {
			
			String AppURL = TestData.getCellData(sheetName, "AppURL", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);

			System.out.println(AppURL);	
			/*QCCSRLoginLogout.adminLogin(SSN, SSN);						
			RAdminStoreDate.nvtlp_toStartdate(SSN, AppURL);															
			RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);*/
			RProcTest.nvpdl_proc();
			Thread.sleep(3000);
			RProcTest.nvtlp_proc();
			
			Thread.sleep(2000);	
						
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSRNewLoan.newLoan(SSN, AppURL);						
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDefault.tlpdefaultchk(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSREPP.epp(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCEPPPayment.dcepppayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RDBValidation.tlpdbvalidation();
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			QCCSRPaymentPlanValidation.paymentplanvalidation(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
							
		}
	}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Txn");
	
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.ERROR, "Unable to start scenarios ");
	
	

}
}	

@Test(priority = 14, groups = "Ratikanta_NVTLP_Accounting")

public static void QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Void_Txn_Testdata() throws Exception {
try {
	test = reports.startTest(("NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Void"),

			
 "CSR Login->Borrower Registration-->NVNewLoanWithNOC-->Age Store to More than 2 Month-->Default-->Return-->EPP-->EPPPayment-->Void-->DB Validation For Payment Plan Posted or Not-->Application Validation for Payment Plan");
	String FileName = "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Void_Txn_Testdata.xls";
	                 
	
	TestData = new ExcelNew(System.getProperty("user.dir")
			+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	
	int lastrow = TestData.getLastRow("Start");
	String sheetName = "Start";
	
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {

		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
		if (RunFlag.equals("Y")) {
			
			String AppURL = TestData.getCellData(sheetName, "AppURL", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);

			System.out.println(AppURL);
			/*QCCSRLoginLogout.adminLogin(SSN, SSN);						
			RAdminStoreDate.nvtlp_toStartdate(SSN, AppURL);															
			RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);*/
			RProcTest.nvpdl_proc();
			Thread.sleep(3000);
			RProcTest.nvtlp_proc();
			
			Thread.sleep(2000);	
						
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSRNewLoan.newLoan(SSN, AppURL);						
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDefault.tlpdefaultchk(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSREPP.epp(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCEPPPayment.dcepppayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCVoid.tlpVoid(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RDBValidation.tlpdbvalidation();
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			QCCSRPaymentPlanValidation.paymentplanvalidation(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
							
		}
	}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_Void_Txn");
	
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.ERROR, "Unable to start scenarios ");		
}
}	

//==========================  LOC Accounting Scenarios Start  ================================

//============================= Store Used = 1258 Start Date : 05/02/2018 ===============================================


@Test(priority = 15, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_Default_Refinance_StepSame_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_Default_Refinance_StepSame"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->DueDate-->Grace Days-->Due Date-->Grace Days-->Default-->Refinance-->StepSame");
			String FileName = "QC_LOC_SignatureLoan_Default_Refinance_StepSame_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

                    System.out.println(AppURL);
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);						
					RAdminStoreDate.ksloc_toStartdate(SSN, AppURL);															
					RQCCSRLoginLogout.Adminlogout(driver, SSN, AppURL);				
					RProcTest.proc();
					Thread.sleep(2000);


					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
				//=========================================================	
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
				//=============================================================	
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCRefinance.StepSame(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
							/*RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/
										
				}
			}
		}

		catch (Exception e) {
			//System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Default_Refinance_StepSame_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_Default_Refinance_StepSame Transaction Failed ");
			
		
		}
	}	

@Test(priority = 16, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_Default_Refinance_StepSame_WaiveFee_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_Default_Refinance_StepSame_WaiveFee"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 Statements-->Default-->Refinance-->StepSame-->WaiveFee");
			
			String FileName = "QC_LOC_SignatureLoan_Default_Refinance_StepSame_WaiveFee_Txn_Testdata.xls";
			                 		
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
			//=======================================================================		
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			//=======================================================================
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCRefinance.StepSame_WaiveFee(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
															
							/*RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/
										
				}
			}
		}

		catch (Exception e) {
			//System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Default_Refinance_StepSame_WaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_Default_Refinance_StepSame_WaiveFee Transaction Failed ");
			
		
		}
	}	
  

@Test(priority = 17, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 statements-->WaiveFee-->Default-->Refinance");
			String FileName = "QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCWaiveFee.WaiveFee(SSN, AppURL);
		//===========================================================================																
					/*RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);*/
		//===========================================================================
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCRefinance.normalrefinance(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
							/*RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/									

				}
			}
		}

		catch (Exception e) {
			//System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_WaiveFeeFull_Default_Refinance Transaction Failed ");
			
		
		}
	}	 
   
@Test(priority = 18, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 statements-->WaiveFee Partial-->Default-->Refinance");
			String FileName = "QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);


					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCWaiveFee.WaiveFee_Partial(SSN, AppURL);
					
		//============================================================================																	
					/*RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);*/
		//============================================================================
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCRefinance.normalrefinance(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
							/*RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/
										
				}
			}
		}

		catch (Exception e) {
			//System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_WaiveFeePartial_Default_Refinance Transaction Failed ");
			
		
		}
	}	 

@Test(priority = 19, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_Default_Refinance_StepUp_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_Default_Refinance_StepUp"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 Statements-->Default-->Refinance-->StepUp");
			String FileName = "QC_LOC_SignatureLoan_Default_Refinance_StepUp_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
			//==================================================================		
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			//====================================================================
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
										
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCRefinance.StepUp(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
							/*RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/										

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Default_Refinance_StepUp_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_Default_Refinance_StepUp Transaction Failed ");					
		}
	}

//========= Exclude Priority=6 scenario ============

/*@Test(priority = 6, groups = "Ratikanta_LOC_Accounting")

public static void QC_LOC_SignatureLoan_Default_Refinance_StepUp_WaiveFeeTxn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_Default_Refinance(WaiveFee)_StepUp"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 Statements-->Default-->Refinance(WaiveFee)-->StepUp");
			String FileName = "QC_LOC_SignatureLoan_Default_Refinance_StepUp_WaiveFeeTxn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);										
					RQCRefinance.StepUp_WaiveFee(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOCHistory.lochistory(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
										
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Default_Refinance_StepUp_WaiveFee_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.INFO, "QC_LOC_SignatureLoan_Default_Refinance_StepUp_WaiveFee Transaction Failed ");			
		
		}
	}*/


//#################### Repo Scenario Start Date : 03/06/2019 #####################

@Test(priority = 20, groups = "Ratikanta_LOC_Accounting_1")

public static void QC_LOC_Default_Repo_Refinance_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("KSLOC_TitleLoan_Default_Repo"),
								    
			"CSR Login->Borrower Registration-->KS TitleNewLoan-->Default-->Send Repo Request-->Approve-->Out For Repo-->Check Repo is Available in dropdown List");
			String FileName = "QC_LOC_Default_Repo_Refinance_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					
					RProcTest.proc();
					
					Thread.sleep(2000);								

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
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RAdmin_Repo.repo(driver, SSN, AppURL);
					
					RAdmin_RepoApproval.repoapproval(driver, SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RAdmin_OutForRepo.outforrepo(driver, SSN, AppURL);
					           		
					RAdmin_Repo_Validation.repovalidation(driver, SSN, AppURL);
					          
							/*RQCCSRLoginLogout.login(SSN, AppURL);										
							RQCRefinance.SecuredLocStepSame(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);
							
							RQCCSRLoginLogout.login(SSN, AppURL);
							RQCCSR_LOCHistory.lochistory(SSN, AppURL);
							RQCCSRLoginLogout.logout(SSN, AppURL);*/
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_Loan_Default_Repo_Refinance Transaction Failed ");			
		
		}
	}

@Test(priority = 21, groups = "Ratikanta_LOC_Accounting_1")

public static void QC_LOC_Payment_Default_Repo_Refinance_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("KSLOC_TitleLoan_Payment_Default_Repo_Refinance"),
								    
			"CSR Login->Borrower Registration-->KS TitleNewLoan-->Payment-->Default-->Send Repo Request-->Approve-->Out For Repo-->Check Repo is Available in dropdown List-->Refinance");
			String FileName = "QC_LOC_Payment_Default_Repo_Refinance_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);							
					RProcTest.proc();
					
					Thread.sleep(2000);					

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);					
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRPayment.payment(SSN, AppURL);
										
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RAdmin_Repo.repo(driver, SSN, AppURL);
					
					RAdmin_RepoApproval.repoapproval(driver, SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RAdmin_OutForRepo.outforrepo(driver, SSN, AppURL);
					
					RAdmin_Repo_Validation.repovalidation(driver, SSN, AppURL);
															           					
					RQCCSRLoginLogout.login(SSN, AppURL);										
					RQCRefinance.SecuredLocStepSame(SSN, AppURL);
					        //RQCRefinance.lessthansecuredlocamount(SSN, AppURL);				
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOCHistory.lochistory(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);					
	
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_Default_Repo_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_Loan_Payment_Default_Repo_Refinance Transaction Failed ");
			
		
		}
	}

@Test(priority = 22, groups = "Ratikanta_LOC_Accounting_1")

public static void QC_LOC_Payment_Default_Repo_RefinanceWithDisb_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("KSLOC_TitleLoan_Payment_Default_Repo_RefinanceWithDisb"),
								    
			"CSR Login->Borrower Registration-->KS TitleNewLoan-->Payment-->Default-->Send Repo Request-->Approve-->Out For Repo-->Check Repo is Available in dropdown List-->RefinanceWithDisb");
			String FileName = "QC_LOC_Payment_Default_Repo_RefinanceWithDisb_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);							
					RProcTest.proc();
					
					Thread.sleep(2000);								

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);					
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRPayment.payment(SSN, AppURL);
										
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RAdmin_Repo.repo(driver, SSN, AppURL);
					
					RAdmin_RepoApproval.repoapproval(driver, SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RAdmin_OutForRepo.outforrepo(driver, SSN, AppURL);
					
					RAdmin_Repo_Validation.repovalidation(driver, SSN, AppURL);
															           					
					RQCCSRLoginLogout.login(SSN, AppURL);															
				    RQCRefinance.lessthansecuredlocamount(SSN, AppURL);				
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOCHistory.lochistory(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_Default_Repo_RefinanceWithDisb_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_Loan_Payment_Default_Repo_RefinanceWithDisb Transaction Failed ");			
		
		}
	}

@Test(priority = 23, groups = "Ratikanta_LOC_Accounting_1")

public static void QC_LOC_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("KSLOC_TitleLoan_Payment_Default_DefaultPaymentLess Than Due Amount_Repo_RefinanceWithDisb"),
								    
			"CSR Login->Borrower Registration-->KS TitleNewLoan-->Payment-->Default-->DefaultPaymentLess Than Due Amount-->Send Repo Request-->Approve-->Out For Repo-->Check Repo is Available in dropdown List-->RefinanceWithDisb");
			String FileName = "QC_LOC_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);							
					RProcTest.proc();
					
					Thread.sleep(2000);									

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);					
					RQCCSRNewLoan.newLoan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRPayment.payment(SSN, AppURL);
										
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCDefault.defaultchk(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
															
					RAdmin_Repo.repo(driver, SSN, AppURL);
					
					RAdmin_RepoApproval.repoapproval(driver, SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RBusinessDateCapture.businessdate(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RAdmin_OutForRepo.outforrepo(driver, SSN, AppURL);
					
					RAdmin_Repo_Validation.repovalidation(driver, SSN, AppURL);
															           					
					RQCCSRLoginLogout.login(SSN, AppURL);															
				            //RQCRefinance.refinanceshouldnttallow(SSN, AppURL);	
				    RQCRefinance.withdisb_StepSame(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					/*RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSR_LOCHistory.lochistory(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);*/
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_Loan_Payment_Default_DefaultPayment_Repo_RefinanceWithDisb Transaction Failed ");			
		
		}
	}

@Test(priority = 24, groups = "Ratikanta_LOC_Accounting_1")

public static void QC_LOC_SignatureLoan_Runtwostatements_WaiveFee_CheckWaiveFeein2997Store_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_LOC_SignatureLoan_Run Two Statements_WaiveFee_Check Post WaiveFee in 2997 Store"),
								    
			"CSR Login->Borrower Registration-->NewLoan(Signature)-->Run 2 statements-->WaiveFee-->PostWaiveFee in 2997");
			String FileName = "QC_LOC_SignatureLoan_Runtwostatements_WaiveFee_CheckWaiveFeein2997Store_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);						      
					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					
					RQCCSRLoginLogout.login(SSN, AppURL);
					RQCWaiveFee.WaiveFee(SSN, AppURL); 																								
										
					QCCSRPaymentPlanValidation.waivefeevalidation(SSN, AppURL);
					RQCCSRLoginLogout.logout(SSN, AppURL);									

				}
			}
		}

		catch (Exception e) {
			//System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_LOC_SignatureLoan_Runtwostatements_WaiveFee_CheckWaiveFeein2997Store_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_LOC_SignatureLoan_Runtwostatements_WaiveFee_CheckWaiveFeein2997Store Transaction Failed ");
			
		
		}
	}	 

//======== This scenario(Priority 15) will work only when we have payment plan posted in DB, because NSF Posting(DC Return) is not possible without record.=====


//@Test(priority = 15, groups = "Ratikanta_NVTLP_Accounting")

public static void QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_NSFPosting_Txn_Testdata() throws Exception {
try {
	test = reports.startTest(("NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_NSF Posting"),

			
 "CSR Login->Borrower Registration-->NVNewLoanWithNOC-->Age Store to More than 2 Month-->Default-->Return-->EPP-->EPPPayment-->NSF Posting(DC Return)-->DB Validation For Payment Plan Posted or Not-->Application Validation for Payment Plan");
	String FileName = "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_NSFPosting_Txn_Testdata.xls";
	                 
	
	TestData = new ExcelNew(System.getProperty("user.dir")
			+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	
	int lastrow = TestData.getLastRow("Start");
	String sheetName = "Start";
	
	System.out.println(lastrow);
	for (int row = 2; row <= lastrow; row++) {

		String RunFlag = TestData.getCellData(sheetName, "Run", row);
		
		if (RunFlag.equals("Y")) {
			
			String AppURL = TestData.getCellData(sheetName, "AppURL", row);
			String SSN = TestData.getCellData(sheetName, "SSN", row);

			System.out.println(AppURL);
						
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSRNewLoan.newLoan(SSN, AppURL);						
			RQCCSRLoginLogout.logout(SSN, AppURL);	
			
			RQCCSRLoginLogout.login(SSN, AppURL);						      
			RQCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCDefault.tlpdefaultchk(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCCSREPP.epp(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQCEPPPayment.dcepppayment(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RBusinessDateCapture.businessdate(SSN, AppURL);
			QCCSRLoginLogout.logout(SSN, AppURL);
			
			RQC_DC_DBReturn.dcreturn_proc();					
			
			RQCCSRLoginLogout.login(SSN, AppURL);
			RQC_DCReturn_Validation.dbreturn_validation(SSN, AppURL);
			QCCSRLoginLogout.logout(SSN, AppURL);
										
			RDBValidation.tlpdbvalidation();
			
			RQCCSRLoginLogout.login(SSN, AppURL);			
			QCCSRPaymentPlanValidation.paymentplanvalidation(SSN, AppURL);
			RQCCSRLoginLogout.logout(SSN, AppURL);
		
			
		
		}
	}
}

catch (Exception e) {
	System.out.println("under catch of Test" + e);
	String screenshotPath = getScreenhot(driver, "QC_NVTLP_LoanWithNOC_Default_EPP_PaymentWithDC_NSFPosting_Txn");
	
	test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	test.log(LogStatus.ERROR, "Unable to start scenarios ");
	
	

}
}	
 
 //=============================================================================   
  //@Test(priority = 11, groups = "Ratikanta_LOC_Accounting")
  
  public static void QC_LOC_SignatureLoan_Default_Refinance_StepDown_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_LOC_SignatureLoan_Default_Refinance_StepDown"),
 								    
 			"CSR Login->Borrower Registration-->NewLoan(Signature)-->DueDate-->Grace Days-->Due Date-->Grace Days-->Default-->Refinance-->StepDown");
 			String FileName = "QC_LOC_SignatureLoan_Default_Refinance_StepDown_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(AppURL);
 					
 					/*QCCSRLoginLogout.adminLogin(SSN, SSN);						
 					RAdminStoreDate.toStartdate_SemiMonthly(SSN, AppURL);										
 					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
 					RProcTest.proc();
 					Thread.sleep(8000);*/

 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
 					RQCCSRLoginLogout.logout(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCCSRSignatureLoan.signatureloan(SSN, AppURL);
 					RQCCSRLoginLogout.logout(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);						      
 					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);						      
 					RQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCDefault.defaultchk(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCRefinance.StepDown(SSN, AppURL);
 					RQCCSRLoginLogout.logout(SSN, AppURL);
 					
 					RQCCSRLoginLogout.login(SSN, AppURL);
 					RQCCSR_LOCHistory.lochistory(SSN, AppURL);
 					RQCCSRLoginLogout.logout(SSN, AppURL);
 					
 					

 				}
 			}
 		}

 		catch (Exception e) {
 			//System.out.println("under catch of Test" + e);
 			//String screenshotPath = getScreenhot(driver, "QC_Payment_Payment2_BuyBack_ChargeBack_Txn");
 			//test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.INFO, "QC_LOC_SignatureLoan_Default_Refinance_StepDown Transaction Failed ");
 			
 		
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

						new FileReader("C:/Qc_Batch_WildFly/QC_Accounting_Scenarios/src/test/java/tests/RObjects.properties"));

				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				csr_url = Rprop.getProperty("CSR_URL");
				csrloginpage = Rprop.getProperty("Login_Page");
				AdminURL = Rprop.getProperty("ADMIN_CSR_URL");
				DBUserName = Rprop.getProperty("DB_UserName");
				DBPassword = Rprop.getProperty("DB_Password");
				CouponNumber = Rprop.getProperty("Coupon_Nbr");
				AdminUserName= Rprop.getProperty("admin_userid");
				AdminPassword= Rprop.getProperty("admin_password");
				
				
				
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

		

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");

		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			//Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process PDL scenarios");
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
