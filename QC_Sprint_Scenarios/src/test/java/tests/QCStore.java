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
	public static String AdminUserName;
	public static String AdminPassword;
	
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
	
	
	//================================  RATIKANTA  Sprint Scenarios  ====================================================
	
	
	
	//************************************  Requirment 564  ****************************************
	
	//============================= Store Used : 1259 (05/02/2018) =================================
	
	
	@Test(priority = 1, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_151_1_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_151_1"),															    
				"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Got to Adjust Interest Button-->Verify Adjust Interest Button Available");
				
				
				String FileName = "QC_Sprint_B20_151_1_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						/*RProcTest.proc();						
						Thread.sleep(2000);*/								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDefault.defaultchk(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_verification(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);					
							
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_1_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "QC_Sprint_B20_151_1 Transaction Failed ");			
			
			}
		}
	@Test(priority = 2, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_151_2_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_151_2"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Click On AdjustInterest Button-->Update adjust interest amount-->Verify adjust interest amount in History Screen");
				
				
				String FileName = "QC_Sprint_B20_151_2_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						/*RProcTest.proc();						
						Thread.sleep(2000);*/								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDefault.defaultchk(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_verification(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);	
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QC_Adjust_Interest_Amount_HistoryVerification.adjamount_verfication(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
							
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_2_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "QC_Sprint_B20_151_2 Transaction Failed ");			
			
			}
		}
	
	@Test(priority = 3, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_151_3_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_151_3"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Click On AdjustInterest Button-->Update adjust interest amount-->Login Central Store_2997-->Verify adjust interest amount in History Screen");
				
				
				String FileName = "QC_Sprint_B20_151_3_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						/*RProcTest.proc();						
						Thread.sleep(2000);*/								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDefault.defaultchk(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_verification(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);	
						
						CentralStore_Login_Logout.login(SSN, AppURL);
						QC_Adjust_Interest_Amount_HistoryVerification.adjamount_verfication(SSN, AppURL);
						CentralStore_Login_Logout.logout(SSN, AppURL);
							
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_3_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "QC_Sprint_B20_151_3 Transaction Failed ");			
			
			}
		}
	
	@Test(priority = 4, groups = "Ratikanta_Sprint1_REQ_564")

		public static void QC_Sprint_B20_151_4_Txn_Testdata() throws Exception {
				try {
					test = reports.startTest(("QC_Sprint1_B20_151_4"),															    
					"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button Available-->Increase Adjust Interest Amount-->Go To Central Store History To Verify Adjust Amount Increased Or Not");
					
					
					String FileName = "QC_Sprint_B20_151_4_Txn_Testdata.xls";
					                 
					
					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					
					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						
						if (RunFlag.equals("Y")) {
							
							String AppURL = TestData.getCellData(sheetName, "AppURL", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(csr_url);	
							
							/*RProcTest.proc();						
							Thread.sleep(2000);*/								

							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);				
							QCCSRNewLoan.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);							      
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDefault.defaultchk(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);						
							QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);	
							
							CentralStore_Login_Logout.login(SSN, AppURL);
							QC_Adjust_Interest_Amount_HistoryVerification.increased_adjamount_verfication(SSN, AppURL);
							CentralStore_Login_Logout.logout(SSN, AppURL);			
								
						}
					}
				}

				catch (Exception e) {
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_4_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.FAIL, "QC_Sprint_B20_151_4 Transaction Failed ");			
				
				}
			}
	@Test(priority = 5, groups = "Ratikanta_Sprint1_REQ_564")

		public static void QC_Sprint_B20_151_5_Txn_Testdata() throws Exception {
				try {
					test = reports.startTest(("QC_Sprint1_B20_151_5"),															    
					"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button Available-->Increase Adjust Interest Amount-->Go To Store History To Verify Adjust Amount Increased Or Not");
					
					
					String FileName = "QC_Sprint_B20_151_5_Txn_Testdata.xls";
					                 
					
					TestData = new ExcelNew(System.getProperty("user.dir")
							+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

					
					int lastrow = TestData.getLastRow("Start");
					String sheetName = "Start";
					
					System.out.println(lastrow);
					for (int row = 2; row <= lastrow; row++) {

						String RunFlag = TestData.getCellData(sheetName, "Run", row);
						
						if (RunFlag.equals("Y")) {
							
							String AppURL = TestData.getCellData(sheetName, "AppURL", row);
							String SSN = TestData.getCellData(sheetName, "SSN", row);

							System.out.println(csr_url);	
							
							/*RProcTest.proc();						
							Thread.sleep(2000);*/								

							QCCSRLoginLogout.login(SSN, AppURL);
							QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);				
							QCCSRNewLoan.newLoan(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);							      
							QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);
							QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
							
							QCCSRLoginLogout.login(SSN, AppURL);
							QCDefault.defaultchk(SSN, AppURL);	
							
							QCCSRLoginLogout.login(SSN, AppURL);						
							QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);	
							
							QCCSRLoginLogout.login(SSN, AppURL);
							QC_Adjust_Interest_Amount_HistoryVerification.increased_adjamount_verfication(SSN, AppURL);
							QCCSRLoginLogout.logout(SSN, AppURL);		
								
						}
					}
				}

				catch (Exception e) {
					System.out.println("under catch of Test" + e);
					String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_5_Txn");
					test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
					test.log(LogStatus.FAIL, "QC_Sprint_B20_151_5 Transaction Failed ");			
				
				}
			}
	
	@Test(priority = 6, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_151_6_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_151_6"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button Available-->Decrease Adjust Interest Amount-->Go To Central Store History To Verify Adjust Amount Decreased Or Not");
						
						
						String FileName = "QC_Sprint_B20_151_6_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);						
								QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_decreased(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);	
								
								CentralStore_Login_Logout.login(SSN, AppURL);
								QC_Adjust_Interest_Amount_HistoryVerification.increased_adjamount_verfication(SSN, AppURL);
								CentralStore_Login_Logout.logout(SSN, AppURL);			
									
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_6_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_151_6 Transaction Failed ");			
					
					}
				}
			
		@Test(priority = 7, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_151_7_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_151_7"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button Available-->Decrease Adjust Interest Amount-->Go To Store History To Verify Adjust Amount Decreased Or Not");
						
						
						String FileName = "QC_Sprint_B20_151_7_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);						
								
								QCCSRLoginLogout.login(SSN, AppURL);						
								QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_decreased(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);	
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QC_Adjust_Interest_Amount_HistoryVerification.increased_adjamount_verfication(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);			
									
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_151_7_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_151_7 Transaction Failed ");			
					
					}
				}
			
		@Test(priority = 8, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_152_1_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_152_1"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->In Store Verify Adjust Interest Void Button Available Or Not");
						
						
						String FileName = "QC_Sprint_B20_152_1_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);						
								QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_1_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_152_1 Transaction Failed ");			
					
					}
				}
			
		@Test(priority = 9, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_152_2_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_152_2"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->In Central Store(2997) Verify Adjust Interest Void Button Available Or Not");
						
						
						String FileName = "QC_Sprint_B20_152_2_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);
																
								CentralStore_Login_Logout.login(SSN, AppURL);
								QC_Sprint_AdjustInterest_CentralStore.CentralStore_Void_verification(SSN, AppURL);
								CentralStore_Login_Logout.logout(SSN, AppURL);
								
								
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_2_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_152_2 Transaction Failed ");			
					
					}
				}


	@Test(priority = 10, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_152_3_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_152_3"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Adjust Interest-->Verify Adjust Interest Void Button Should be Available");
						
						
						String FileName = "QC_Sprint_B20_152_3_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);	
								
								QCCSRLoginLogout.login(SSN, AppURL);						
								QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);	
															
									
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_3_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_152_3 Transaction Failed ");			
					
					}
				}
			
	@Test(priority = 11, groups = "Ratikanta_Sprint1_REQ_564")

			public static void QC_Sprint_B20_152_4_Txn_Testdata() throws Exception {
					try {
						test = reports.startTest(("QC_Sprint1_B20_152_4"),															    
						"Borrower Registration-->Loan-->Default->Collection-->Select Product-->Search For the Customer-->Adjust Interest In Central Store(2997)-->Verify Adjust Interest Void Button Should be Available in Central Store");
						
						
						String FileName = "QC_Sprint_B20_152_4_Txn_Testdata.xls";
						                 
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						String sheetName = "Start";
						
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);
							
							if (RunFlag.equals("Y")) {
								
								String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(csr_url);	
								
								/*RProcTest.proc();						
								Thread.sleep(2000);*/								

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);				
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);							      
								QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCDefault.defaultchk(SSN, AppURL);									
								
								CentralStore_Login_Logout.login(SSN, AppURL);
								QC_Sprint_AdjustInterest_CentralStore.central_store_adjustinterest_amount_increased(SSN, AppURL);
								CentralStore_Login_Logout.logout(SSN, AppURL);
															
									
							}
						}
					}

					catch (Exception e) {
						System.out.println("under catch of Test" + e);
						String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_152_4_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "QC_Sprint_B20_152_4 Transaction Failed ");			
					
					}
				}
	     //========================= Secured LOC (KS Title) =============================
	
	@Test(priority = 12, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_153_1_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_153_1"),															    
				"Borrower Registration-->KS TitleLoan(Secured LOC)-->Default->-->PartialPayment-->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button is Disable");
				
				
				String FileName = "QC_Sprint_B20_153_1_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						/*RProcTest.proc();						
						Thread.sleep(2000);*/								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCDefault.defaultchk(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);	
						QCCSRPartial_DefaultPayment.partialdefaultpayment(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
							
							
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_1_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "QC_Sprint_B20_153_1 Transaction Failed ");			
			
			}
		}	
	
	
	
	    //========================= Title Loan (NV TLP) =============================	
	       //===============  Store Used = 734 , Start Date = 05/01/2019 =============================
	
	@Test(priority = 13, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_153_2_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_153_2"),															    
				"Borrower Registration-->Title Loan-->Default->-->PartialPayment-->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button is Disable");
				
				
				String FileName = "QC_Sprint_B20_153_2_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						QCCSRLoginLogout.adminLogin(SSN, SSN);						
						RAdminStoreDate.nvpdl_toStartdate(SSN, AppURL);															
						QCCSRLoginLogout.Adminlogout(SSN, AppURL);	
												
						QCProc.nvpdl_proc();
						Thread.sleep(3000);						
						QCProc.nvtlp_proc();
						
						Thread.sleep(2000);								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.NV_TLP_ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL);
					
						QCCSRLoginLogout.login(SSN, AppURL);	
						QCCSRPartial_DefaultPayment.tlppartialdefaultpayment(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjust_interest_Void_verification(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_2_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.FAIL, "QC_Sprint_B20_153_2 Transaction Failed ");			
			
			}
		}	
	
	//========================= Installment Loan (MO ILP) =============================	
    //===============  Store Used = 3236 , Start Date = 05/02/2018 =============================

@Test(priority = 14, groups = "Ratikanta_Sprint1_REQ_564")

public static void QC_Sprint_B20_153_3_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint1_B20_153_3"),															    
			"Borrower Registration-->Installment Loan-->Default->-->PartialPayment-->Collection-->Select Product-->Search For the Customer-->Verify Adjust Interest Void Button is Disable");
			
			
			String FileName = "QC_Sprint_B20_153_3_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(csr_url);	
					
					QCCSRLoginLogout.adminLogin(SSN, SSN);						
					RAdminStoreDate.moilp_toStartdate(SSN, AppURL);															
					QCCSRLoginLogout.Adminlogout(SSN, AppURL);	
											
					QCProc.ilp_proc();
					Thread.sleep(3000);															

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);				
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);				
					
					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_3_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_B20_153_3 Transaction Failed ");			
		
		}
	}
     //========================= Secured LOC (KS Title) =============================	

									  /*@Test(priority = 15, groups = "Ratikanta_Sprint1_REQ_564_1")
									
									  public static void QC_Sprint_B20_153_4_Txn_Testdata() throws Exception {
											try {
												test = reports.startTest(("QC_Sprint1_B20_153_4"),															    
												"Borrower Registration-->KS TitleLoan(Secured LOC)-->Default-->Adjust Interest-->Refinance-->RefinanceVoid-->Partial Payment-->Verify Adjust Interest Void Button Should be Disable");
												
												
												String FileName = "QC_Sprint_B20_153_4_Txn_Testdata.xls";
												                 
												
												TestData = new ExcelNew(System.getProperty("user.dir")
														+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
									
												
												int lastrow = TestData.getLastRow("Start");
												String sheetName = "Start";
												
												System.out.println(lastrow);
												for (int row = 2; row <= lastrow; row++) {
									
													String RunFlag = TestData.getCellData(sheetName, "Run", row);
													
													if (RunFlag.equals("Y")) {
														
														String AppURL = TestData.getCellData(sheetName, "AppURL", row);
														String SSN = TestData.getCellData(sheetName, "SSN", row);
									
														System.out.println(csr_url);	
														
														RProcTest.proc();						
														Thread.sleep(2000);								
									
														QCCSRLoginLogout.login(SSN, AppURL);
														QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
														QCCSRLoginLogout.logout(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);				
														QCCSRNewLoan.newLoan(SSN, AppURL);
														QCCSRLoginLogout.logout(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);							      
														QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);
														QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);
														QCDefault.defaultchk(SSN, AppURL);	
														
														QCCSRLoginLogout.login(SSN, AppURL);						
														QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
														QCCSRLoginLogout.logout(SSN, AppURL);	
														
														QCCSRLoginLogout.login(SSN, AppURL);										
														QCCSR_Refinance.SecuredLocStepSame(SSN, AppURL);
														QCCSRLoginLogout.logout(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);					
														QCCSR_Void.qcVoid(SSN, AppURL);
														QCCSRLoginLogout.logout(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);	
														QCCSRPartial_DefaultPayment.partialdefaultpayment(SSN, AppURL);
														
														QCCSRLoginLogout.login(SSN, AppURL);						
														QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
														QCCSRLoginLogout.logout(SSN, AppURL);
														
														
															
													}
												}
											}
									
											catch (Exception e) {
												System.out.println("under catch of Test" + e);
												String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_4_Txn");
												test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
												test.log(LogStatus.FAIL, "QC_Sprint_B20_153_4 Transaction Failed ");			
											
											}
										}*/	
  
             //========================= Title Loan (NV TLP) =============================
	
   @Test(priority = 16, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_153_5_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint1_B20_153_5"),															    
			"Borrower Registration-->Title Loan-->Default-->Adjust Interest-->Refinance-->RefinanceVoid-->Partial Payment-->Verify Adjust Interest Void Button Should be Disable");
			
			
			String FileName = "QC_Sprint_B20_153_5_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(csr_url);	
					
					/*RProcTest.proc();						
					Thread.sleep(2000);*/								

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);				
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.NV_TLP_ageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjustinterest_amount_increased(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);										
					QCCSR_Refinance.tlpStepSame(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);					
					QCCSR_Void.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				
					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.tlppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				
					
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_5_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_B20_153_5 Transaction Failed ");			
		
		}
	}	
	
   //========================= Installment (MO ILP) =============================	

   @Test(priority = 17, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_153_6_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_153_6"),															    
 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->Conversion To TLP-->ConversionVoid-->Partial Payment With Old Loan-->Verify Adjust Interest Void Button Should be Disable");
 			
 			
 			String FileName = "QC_Sprint_B20_153_6_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					RProcTest.ilp_proc();						
 					Thread.sleep(2000);								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);		
					
					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);	
 					
 					QCCSRLoginLogout.login(SSN, AppURL);										
 					QCCSRConversion.ilptotlpconversion(SSN, AppURL); 										
 					
 					QCCSRLoginLogout.login(SSN, AppURL);					
 					QCCSR_Void.Conv_Ilp_Void(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
	
 					
 					
 						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_6_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_153_6 Transaction Failed ");			
 		
 		}
 	}	
   
   //========================= Title Loan (NV TLP) =============================
   
   @Test(priority = 18, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_1_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint1_B20_154_1"),															    
			"Borrower Registration-->Title Loan-->Default-->Adjust Interest-->Partial Payment-->Payment Void-->Verify Adjust Interest Void Button Should be Enable");
			
			
			String FileName = "QC_Sprint_B20_154_1_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(csr_url);	
					
					/*RProcTest.proc();						
					Thread.sleep(2000);*/								

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);				
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.NV_TLP_ageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjustinterest_amount_increased(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.tlppartialdefaultpayment(SSN, AppURL);
									
					QCCSRLoginLogout.login(SSN, AppURL);					
					QCCSR_Void.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);									
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.Defaulttlp_adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);									
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_1_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_1 Transaction Failed ");			
		
		}
	}	

 //========================= Installment (MO ILP) =============================	

   @Test(priority = 19, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_2_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_2"),															    
 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->Partial Payment-->Void-->Verify Adjust Interest Void Button Should be Enable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_2_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);					
 					QCCSR_Void.qcVoid(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
					QC_Sprint_Adjust_Interestbutton_Verification.Defaultilp_adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
										
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_2_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_2 Transaction Failed ");			
 		
 		}
 	}	
   
   @Test(priority = 20, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_7_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_7"),															    
 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->WriteOff-->Verify Adjust Interest Void Button Should be Disable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_7_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 														
 					QCCSRLoginLogout.login(SSN, AppURL);
					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
										
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_7_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_7 Transaction Failed ");			
 		
 		}
 	}	
   
//========================= Title Loan (NV TLP) =============================
   
   @Test(priority = 21, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_8_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint1_B20_154_8"),															    
			"Borrower Registration-->Title Loan-->Default-->Adjust Interest-->WriteOff-->Verify Adjust Interest Void Button Should be Disable");
			
			
			String FileName = "QC_Sprint_B20_154_8_Txn_Testdata.xls";
			                 
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(csr_url);	
					
					/*RProcTest.proc();						
					Thread.sleep(2000);*/								

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);				
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.NV_TLP_ageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjustinterest_amount_increased(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_WriteOff.tlpwriteoff(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 																																
					QCCSRLoginLogout.login(SSN, AppURL);						
					QC_Sprint_Adjust_Interestbutton_Verification.tlp_adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);									
						
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_8_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_8 Transaction Failed ");			
		
		}
	}	
   
 //========================= UnSecured LOC (KS LOC) =============================	

   @Test(priority = 22, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_9_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_9"),															    
 			"Borrower Registration-->KS LOC(UnSecured LOC)-->Default-->Adjust Interest-->WriteOff-->Verify Adjust Interest Void Button Should be Disable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_9_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);	*/						

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
 					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
 										
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);	
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_WriteOff.locwriteoff(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 										
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_9_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_9 Transaction Failed ");			
 		
 		}
 	}	
 //========================= Secured LOC (KS Title) =============================	

   @Test(priority = 23, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_10_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_10"),															    
 			"Borrower Registration-->KS TitleLoan(Secured LOC)-->Default-->Adjust Interest-->WriteOff-->Verify Adjust Interest Void Button Should be Disable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_10_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
 					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
 					 					
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);	
 										
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_WriteOff.locwriteoff(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					
 						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_10_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_10 Transaction Failed ");			
 		
 		}
 	}	
   
 //========================= Installment (MO ILP) =============================	

   @Test(priority = 24, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_11_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_11"),															    
 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->Refinance-->Void-->Partial Payment-->Verify Adjust Interest Void Button Should be Disable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_11_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);		
					
					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);	
 					
 					QCCSRLoginLogout.login(SSN, AppURL);										
 					QCCSR_Refinance.ilpStepSame(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					
 					QCCSRLoginLogout.login(SSN, AppURL);					
 					QCCSR_Void.Ref_Ilp_Void(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
	
 					
 					
 						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_11_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_11 Transaction Failed ");			
 		
 		}
 	}	  
   
   //========================= Secured LOC (KS Title) =============================	

   @Test(priority = 25, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_13_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_13"),															    
 			"Borrower Registration-->KS TitleLoan(Secured LOC)-->Default-->Adjust Interest-->Verify Adjust Interest Void Button Should be Enable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_13_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
 					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);	
 					
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);											
 						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_13_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_13 Transaction Failed ");			
 		
 		}
 	}	
   
 //============================== UnSecured LOC  =====================================	

   @Test(priority = 26, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_14_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_14"),															    
 			"Borrower Registration-->ULOC Loan-->Default-->Adjust Interest-->Verify Adjust Interest Void Button Should be Enable");
 			
 			
 			String FileName = "QC_Sprint_B20_154_14_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
 					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);	
 					
 					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);											
 						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_14_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_14 Transaction Failed ");			
 		
 		}
 	}	
   
   @Test(priority = 27, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_15_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_15"),															    
 			"Borrower Registration-->ULOC Loan-->Default-->Adjust Interest-->Verify Adjust Interest Void Button Should be Enable At Central Store(2997)");
 			
 			
 			String FileName = "QC_Sprint_B20_154_15_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
 					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);	
 					
 					CentralStore_Login_Logout.login(SSN, AppURL);						
 					QC_Sprint_AdjustInterest_CentralStore.Centralstore_adjustinterest_Void_verification(SSN, AppURL);
 					CentralStore_Login_Logout.logout(SSN, AppURL);
  						
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_153_15_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_15 Transaction Failed ");			
 		
 		}
 	}	
   @Test(priority = 28, groups = "Ratikanta_Sprint1_REQ_564")

	public static void QC_Sprint_B20_154_16_Txn_Testdata() throws Exception {
			try {
				test = reports.startTest(("QC_Sprint1_B20_154_16"),															    
				
						"Borrower Registration-->ULOC Loan-->Default-->Payment-->Verify Adjust Interest Void Button Should Not be Enable At Central Store(2997)");
				
				String FileName = "QC_Sprint_B20_154_16_Txn_Testdata.xls";
				                 
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				String sheetName = "Start";
				
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);
					
					if (RunFlag.equals("Y")) {
						
						String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(csr_url);	
						
						/*RProcTest.proc();						
						Thread.sleep(2000);*/								

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);				
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.manualdefault(SSN, AppURL);
												
						QCCSRLoginLogout.login(SSN, AppURL);	
						QCCSRPartial_DefaultPayment.partialdefaultpayment(SSN, AppURL);
												
						CentralStore_Login_Logout.login(SSN, AppURL);												
						QC_Sprint_AdjustInterest_CentralStore.CentralStore_Void_verification(SSN, AppURL);
						CentralStore_Login_Logout.logout(SSN, AppURL);
							
					}
				}
			}

			catch (Exception e) {
				System.out.println("under catch of Test" + e);
				String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_16_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
				test.log(LogStatus.INFO, "QC_Sprint_B20_154_16 Transaction Failed ");			
			
			}
		}
   
  
	
	//========================= Installment (MO ILP) =============================	

	   @Test(priority = 29, groups = "Ratikanta_Sprint1_REQ_564")

	   public static void QC_Sprint_B20_154_17_Txn_Testdata() throws Exception {
	 		try {
	 			test = reports.startTest(("QC_Sprint1_B20_154_17"),															    
	 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->Refinance-->Void-->Partial Payment-->Verify Adjust Interest Void Button Should be Disable");
	 			
	 			
	 			String FileName = "QC_Sprint_B20_154_17_Txn_Testdata.xls";
	 			                 
	 			
	 			TestData = new ExcelNew(System.getProperty("user.dir")
	 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

	 			
	 			int lastrow = TestData.getLastRow("Start");
	 			String sheetName = "Start";
	 			
	 			System.out.println(lastrow);
	 			for (int row = 2; row <= lastrow; row++) {

	 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
	 				
	 				if (RunFlag.equals("Y")) {
	 					
	 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
	 					String SSN = TestData.getCellData(sheetName, "SSN", row);

	 					System.out.println(csr_url);	
	 					
	 					/*RProcTest.proc();						
	 					Thread.sleep(2000);*/								

	 					QCCSRLoginLogout.login(SSN, AppURL);
	 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
	 					QCCSRLoginLogout.logout(SSN, AppURL);
	 					
	 					QCCSRLoginLogout.login(SSN, AppURL);				
	 					QCCSRNewLoan.newLoan(SSN, AppURL);
	 					QCCSRLoginLogout.logout(SSN, AppURL);
	 					
	 					QCCSRLoginLogout.login(SSN, AppURL);							      
						QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);		
						
						QCCSRLoginLogout.login(SSN, AppURL);						
	 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
	 					QCCSRLoginLogout.logout(SSN, AppURL);	
	 					
	 					QCCSRLoginLogout.login(SSN, AppURL);										
	 					QCCSR_Refinance.ilpStepSame(SSN, AppURL);
	 					QCCSRLoginLogout.logout(SSN, AppURL);
	 					
	 					
	 					QCCSRLoginLogout.login(SSN, AppURL);					
	 					QCCSR_Void.Ref_Ilp_Void(SSN, AppURL);
	 					QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);	
						QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
						
								/*QCCSRLoginLogout.login(SSN, AppURL);
								QC_Sprint_Adjust_Interestbutton_Verification.adjust_interest_Void_verification(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);*/
						
						CentralStore_Login_Logout.login(SSN, AppURL);												
						QC_Sprint_AdjustInterest_CentralStore.CentralStore_Void_verification(SSN, AppURL);
						CentralStore_Login_Logout.logout(SSN, AppURL);
		
	 					
	 					
	 						
	 				}
	 			}
	 		}

	 		catch (Exception e) {
	 			System.out.println("under catch of Test" + e);
	 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_17_Txn");
	 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
	 			test.log(LogStatus.FAIL, "QC_Sprint_B20_154_17 Transaction Failed ");			
	 		
	 		}
	 	}	  
 //========================= Installment (MO ILP) =============================	

   @Test(priority = 30, groups = "Ratikanta_Sprint1_REQ_564")

   public static void QC_Sprint_B20_154_18_Txn_Testdata() throws Exception {
 		try {
 			test = reports.startTest(("QC_Sprint1_B20_154_18"),															    
 			"Borrower Registration-->Installment Loan-->Default-->Adjust Interest-->Partial Payment-->Void-->Verify Adjust Interest Void Button Should be Enable in Central Store(2997)");
 			
 			
 			String FileName = "QC_Sprint_B20_154_18_Txn_Testdata.xls";
 			                 
 			
 			TestData = new ExcelNew(System.getProperty("user.dir")
 					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

 			
 			int lastrow = TestData.getLastRow("Start");
 			String sheetName = "Start";
 			
 			System.out.println(lastrow);
 			for (int row = 2; row <= lastrow; row++) {

 				String RunFlag = TestData.getCellData(sheetName, "Run", row);
 				
 				if (RunFlag.equals("Y")) {
 					
 					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
 					String SSN = TestData.getCellData(sheetName, "SSN", row);

 					System.out.println(csr_url);	
 					
 					/*RProcTest.proc();						
 					Thread.sleep(2000);*/								

 					QCCSRLoginLogout.login(SSN, AppURL);
 					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);											
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);				
 					QCCSRNewLoan.newLoan(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
					QCAgeStoreDueDate.ilpageStoreDueDate(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);						
 					QC_Sprint_Adjust_Interestbutton_Verification.adjustinterest_amount_increased(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);	
					QCCSRPartial_DefaultPayment.ilppartialdefaultpayment(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);					
 					QCCSR_Void.qcVoid(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL); 				
					
					CentralStore_Login_Logout.login(SSN, AppURL);												
					QC_Sprint_AdjustInterest_CentralStore.CentralStore_Void_Enable_verification(SSN, AppURL);				
					CentralStore_Login_Logout.logout(SSN, AppURL);
										
 				}
 			}
 		}

 		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_154_18_Txn");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.INFO, "QC_Sprint_B20_154_18 Transaction Failed ");			
 		
 		}
 	}	
  
   //****************************************************************************************************************************************************************
   //=======================================  Sprint REQ-572  ================================================
 //=======================================  LA PDL (354) SSN Start = 202021045 ================================================
 //=======================================  Start Date = 05/01/2019  ================================================
   
   
  @Test(priority = 31, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_178_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_178_1"),

   					
   		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Verify FDD Details in Courtesy call Screen");
   			String FileName = "QC_Sprint_B20_178_1_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
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
					RAdminStoreDate.mopdl_toStartdate(SSN, AppURL);															
					QCCSRLoginLogout.Adminlogout(SSN, AppURL);
					QCProc.mopdl_proc();
					Thread.sleep(2000);	*/
   					
   					QCCSRLoginLogout.adminLogin(SSN, SSN);						
					RAdminStoreDate.lapdl_toStartdate(SSN, AppURL);															
					QCCSRLoginLogout.Adminlogout(SSN, AppURL);
					RProcTest.lapdl_proc();
					Thread.sleep(2000);
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL); 					
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_verification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_178_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_178_1_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
 //=======================================  MO ILP (590) SSN Start = 202021049 ================================================
   
   @Test(priority = 32, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_178_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_178_2"),

   					
   		    
   			"CSR Login->Borrower Registration-->Installment NewLoan-->Courtesy Call-->Future Deposit Date-->Verify FDD Details in Courtesy call Screen");
   			String FileName = "QC_Sprint_B20_178_2_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
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
					QCCSRLoginLogout.Adminlogout(SSN, AppURL);
					QCProc.mopdl_proc();
					Thread.sleep(2000);
											
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_verification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_178_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_178_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
 //=======================================  MO TLP (590) SSN Start = 202021053 ================================================
   
   @Test(priority = 33, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_178_3_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_178_3"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->Courtesy Call-->Future Deposit Date-->Verify FDD Details in Courtesy call Screen");
   			String FileName = "QC_Sprint_B20_178_3_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
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
								RAdminStoreDate.mopdl_toStartdate(SSN, AppURL);															
								QCCSRLoginLogout.Adminlogout(SSN, AppURL);
								QCProc.mopdl_proc();
								Thread.sleep(2000);	*/
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_verification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_178_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_178_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
 
 //=======================================  MO ILP (590) SSN Start = 202021057 ================================================
   
   @Test(priority = 34, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_178_5_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_178_5"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Verify FDD Details in Courtesy call Screen Of Central Store(2997)");
   			String FileName = "QC_Sprint_B20_178_5_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCProc.mopdl_proc();
					Thread.sleep(2000);  					
			   				
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  								
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);  					   					 				    
   				 
		   					/*CentralStore_Login_Logout.login(SSN, AppURL);					
							QCCSR_FDD_Verification.centralstore_fdd_verification(SSN, AppURL); 	
							CentralStore_Login_Logout.logout(SSN, AppURL);*/   					  					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_178_5_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_178_5_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021061 ================================================
   // Issue : Not taking more than 4 FDD deposits, we need 10 FDD to complete scenario, Not getting Scroll Bar after flow change(4 FDD-->Cancel-->FDD-->Cancel-->continue up to 10 records)
   
                //@Test(priority = 35, groups = "Ratikanta_Sprint1_REQ_572")

                 public static void QC_Sprint_B20_178_6_Txn_Testdata() throws Exception {
   		            try {
   			test = reports.startTest(("QC_Sprint1_B20_178_6"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->10 Times Future Deposit Date-->Verify FDD Details in Courtesy call Screen Of Central Store(2997)");
   			String FileName = "QC_Sprint_B20_178_6_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					// For 10 times FDD Deposit
   					
   				 /*for(int i=0; i<=9; i++){ 
   				    System.out.println("Value Of Variable i is " +i); 
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);
   				   }	
   					CentralStore_Login_Logout.login(SSN, AppURL);	
   					//Update central_fdd_ver class once issue resolved
					QCCSR_FDD_Verification.centralstore_fdd_verification(SSN, AppURL); 	
					CentralStore_Login_Logout.logout(SSN, AppURL); */  					  					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_178_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_178_6_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
  
 //=======================================  MO PDL (590) SSN Start = 202021065 ================================================
   
   @Test(priority = 36, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_179_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_179_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Collection Screen");
   			String FileName = "QC_Sprint_B20_179_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_collectionverification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_179_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_179_1_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
  
 //=======================================  MO ILP (590) SSN Start = 202021069 ================================================
   
   @Test(priority = 37, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_179_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_179_2"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Collection Screen");
   			String FileName = "QC_Sprint_B20_179_2_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);  					  										
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_collectionverification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					  								  					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_179_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_179_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO TLP (590) SSN Start = 202021073 ================================================
                
   		            //@Test(priority = 38, groups = "Ratikanta_Sprint1_REQ_572")

   		            public static void QC_Sprint_B20_179_3_Txn_Testdata() throws Exception {
   		           try {
   			test = reports.startTest(("QC_Sprint1_B20_179_3"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Collection Screen");
   			String FileName = "QC_Sprint_B20_179_3_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);  								   					
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					  					  				
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL);  					  										
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_tlpcollectionverification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_179_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_179_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021077 ================================================
   
   @Test(priority = 39, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_179_6_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_179_6"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Collection Screen For Central Store(2997)");
   			String FileName = "QC_Sprint_B20_179_6_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCProc.mopdl_proc();
   					Thread.sleep(2000);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					 					
			   					/*CentralStore_Login_Logout.login(SSN, AppURL);
			   					QCCSR_FDD_Verification.fdd_centralstore_collectionverification(SSN, AppURL); 	
								CentralStore_Login_Logout.logout(SSN, AppURL);*/

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_179_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_179_6_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021081 ================================================
   
   @Test(priority = 40, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_180_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_180_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Transaction History Screen");
   			String FileName = "QC_Sprint_B20_180_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					 					
					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_FDD_Verification.fdd_historyscreen_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_180_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_180_1_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021085 ================================================
   
   @Test(priority = 41, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_180_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_180_2"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in History Screen");
   			String FileName = "QC_Sprint_B20_180_2_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.ilp_manualdefault(SSN, AppURL);   					  										
   					 					
					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_FDD_Verification.fdd_historyscreen_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					  								  					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_180_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_180_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
 //=======================================  MO TLP (590) SSN Start = 202021089 ================================================
   
   @Test(priority = 42, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_180_3_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_180_3"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in History Screen");
   			String FileName = "QC_Sprint_B20_180_3_Txn_Testdata.xls";
   			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);  								   					
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					  					  				
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.nvtlp_manualdefault(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_FDD_Verification.fdd_historyscreen_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_180_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_180_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021093 ================================================
   
   @Test(priority = 43, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_180_6_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_180_6"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details in Transaction History Screen Of Central Store (2997)");
   			String FileName = "QC_Sprint_B20_180_6_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					
   					CentralStore_Login_Logout.login(SSN, AppURL);  					 	
   					QCCSR_FDD_Verification.fdd_centralstore_historyscreen_verfication(SSN, AppURL); 
   					CentralStore_Login_Logout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_180_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_180_6_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021097 ================================================
   
   @Test(priority = 44, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_181_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_181_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details (Date Created, Installment Number, Orginal Duedate, FDD, Amount, Created By)in Collection Screen");
   			String FileName = "QC_Sprint_B20_181_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_collection_allvalue_verification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_181_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_181_1_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021101 ================================================
   
  @Test(priority = 45, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_181_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_181_2"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Verify FDD Details (Date Created, Installment Number, Orginal Duedate, FDD, Amount, Created By)in History Screen");
   			String FileName = "QC_Sprint_B20_181_2_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);  					  										
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_historyscreen_all_value_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  					

   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_181_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_181_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021105 ================================================
   
   @Test(priority = 46, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_181_3_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_181_3"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Verify FDD Details (Date Created, Installment Number, Orginal Duedate, FDD, Amount, Created By)in Courtesy Call Screen");
   			String FileName = "QC_Sprint_B20_181_3_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_courtesycall_allvalues_verification(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);				
					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_181_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_181_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021109 ================================================
   
   @Test(priority = 47, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_181_7_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_181_7"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Default-->Central Store(2997) Login-->Verify FDD Details (Date Created, Installment Number, Orginal Duedate, FDD, Amount, Created By)in Central Store Payment History Screen");
   			String FileName = "QC_Sprint_B20_181_7_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);  
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
   					
					CentralStore_Login_Logout.login(SSN, AppURL);						      
   					QC_CentralStore.centralstore_paymentscreen_history_fddverification(SSN, AppURL); 					
   					  					
   				}
   			}
   		}

   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_181_7_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_181_7_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
//=======================================  MO PDL (590) SSN Start = 202021113 ================================================
   
   @Test(priority = 48, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_182_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_182_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_182_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_182_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_182_1_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021117 ================================================
   
   @Test(priority = 49, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_182_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_182_2"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_182_2_Txn_Testdata.xls";
   			                  			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					

   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  								  					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_182_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_182_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
 //=======================================  MO TLP (590) SSN Start = 202021121 ================================================
   
   			//@Test(priority = 50, groups = "Ratikanta_Sprint1_REQ_572")

   			public static void QC_Sprint_B20_182_3_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_182_3"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_182_3_Txn_Testdata.xls";  			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL); 
   					
   					QCProc.mopdl_proc();
   					Thread.sleep(2000);
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					  					  				
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_182_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_182_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021125 ================================================
   
   @Test(priority = 51, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_182_6_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_182_6"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Central Store(2997),Verify Future deposit date Field should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_182_6_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
										
   					CentralStore_Login_Logout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_datefield_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					CentralStore_Login_Logout.logout(SSN, AppURL);     					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_182_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_182_6_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021129 ================================================
   
   @Test(priority = 52, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_183_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_183_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date field  should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_183_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_datefield_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);    					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_183_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_183_1_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021133 ================================================
   
   @Test(priority = 53, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_183_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_183_2"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date field  should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_183_2_Txn_Testdata.xls";
   			                  			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					

   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_datefield_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  								  					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_183_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_183_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO TLP (590) SSN Start = 202021137 ================================================
   
   		//@Test(priority = 54, groups = "Ratikanta_Sprint1_REQ_572")

   			public static void QC_Sprint_B20_183_3_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_183_3"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->-->Courtesy Call-->Future Deposit Date-->Verify Future deposit date field  should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_183_3_Txn_Testdata.xls";  			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL); 
   					
   					QCProc.mopdl_proc();
   					Thread.sleep(2000);
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					  					  				
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_datefield_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL); 
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_183_3_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_183_3_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021141 ================================================
   
   @Test(priority = 55, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_183_6_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_183_6"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Central Store(2997),Verify Future deposit date should be displayed in Loan Account Status section  in customer transaction History screen");
   			String FileName = "QC_Sprint_B20_183_6_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);   					   					
										
   					CentralStore_Login_Logout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					CentralStore_Login_Logout.logout(SSN, AppURL);     					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_183_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_183_6_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO PDL (590) SSN Start = 202021145 ================================================
   
   @Test(priority = 56, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_184_1_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_184_1"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Age the Store to FDD Date+Gracedays-->Verify Future deposit date  should be Blank in History's Loan Account Status section screen");
   			String FileName = "QC_Sprint_B20_184_1_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);  
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCAgeStoreDueDate.fdddate_ageStoreGraceDays(SSN, AppURL);
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_empty_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL); 					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_184_1_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_184_1_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021149 ================================================
   
   @Test(priority = 57, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_184_2_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_184_2"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Age the Store to FDD Date+Gracedays-->Verify Future deposit date  should be Blank in History's Loan Account Status section screen");
   			String FileName = "QC_Sprint_B20_184_2_Txn_Testdata.xls";
   			                  			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					

   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCAgeStoreDueDate.fdddate_ageStoreGraceDays(SSN, AppURL);
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_empty_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  								  					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_184_2_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_184_2_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  LA PDL (354) SSN Start = 202021153 ================================================
   
   @Test(priority = 58, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_184_4_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_184_4"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Courtesy Call-->Future Deposit Date-->Cancel FDD-->Verify Future deposit date should be Blank in History's Loan Account Status section Screen");
   			String FileName = "QC_Sprint_B20_184_4_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_future_deposit_date(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.pdl_cancel_future_deposit_date(SSN, AppURL);
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_empty_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL); 					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_184_4_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_184_4_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO ILP (590) SSN Start = 202021157 ================================================
   
   @Test(priority = 59, groups = "Ratikanta_Sprint1_REQ_572")

   public static void QC_Sprint_B20_184_5_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_184_5"),
  					  		    
   			"CSR Login->Borrower Registration-->ILP NewLoan-->Courtesy Call-->Future Deposit Date-->Cancel FDD-->Verify Future deposit date should be Blank in History's Loan Account Status section Screen");
   			String FileName = "QC_Sprint_B20_184_5_Txn_Testdata.xls";
   			                  			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL);   					   					

   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_cancel_future_deposit_date(SSN, AppURL);
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_empty_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  					  								  					
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_184_5_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_184_5_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
//=======================================  MO TLP (590) SSN Start = 202021161 ================================================
  
   			//@Test(priority = 60, groups = "Ratikanta_Sprint1_REQ_572")

   			public static void QC_Sprint_B20_184_6_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint1_B20_184_6"),  					  		    
   			"CSR Login->Borrower Registration-->TLP NewLoan-->-->Courtesy Call-->Future Deposit Date-->Cancel FDD-->Verify Future deposit date should be Blank in History's Loan Account Status section Screen");
   			String FileName = "QC_Sprint_B20_184_6_Txn_Testdata.xls";  			                 
   			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL); 
   					
   					QCProc.mopdl_proc();
   					Thread.sleep(2000);
												
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_future_deposit_date(SSN, AppURL); 					
   					  					  				
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QC_FDD.ilp_cancel_future_deposit_date(SSN, AppURL);
										
   					QCCSRLoginLogout.login(SSN, AppURL);							      
   					QCCSR_FDD_Verification.fdd_date_empty_historyscreen_loanacctsection_verfication(SSN, AppURL); 					
   					QCCSRLoginLogout.logout(SSN, AppURL);  
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint_B20_184_6_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint_B20_184_6_Txn_Testdata Transaction Failed ");			
 		
 		}
   	}
   
   
   //****************************************************************************************************************************************************************
   
   //=======================================  Sprint-2 REQ-601_MOPDL  ================================================
   

//###############################################################################################################################################

 //=======================================  MO PDL (120) SSN Start = 020202013 ================================================
 
//start date : 05/01/2018 ============= Proc Table :PRC_QTP_SSN_TS_PDL_120 ===============
   
   @Test(priority = 62, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_098_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_098"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Partial Payment-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
   			String FileName = "QC_Sprint2_QF_601_TS_098_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);  
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.partialpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   					QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);  									
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_098_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_098_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
//=======================================  MO PDL (120) SSN Start = 020202017 ================================================
   
   @Test(priority = 63, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_102_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_102"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Full Payment-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
   			String FileName = "QC_Sprint2_QF_601_TS_102_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);  
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.fullpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   					QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);  									
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_102_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_102_Txn_Testdata Transaction Failed ");					
 		}
   	}
   



   
//=======================================  MO PDL (120) SSN Start = 020202037 ================================================
   
   
   @Test(priority = 64, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_122_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_122"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->Change CC_INFO_KEY-->Run 1238 Schduler-->Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
   			String FileName = "QC_Sprint2_QF_601_TS_122_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                    
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.scheduler_1238_run();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.partialpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                             	  					   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);								
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_122_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_122_Txn_Testdata Transaction Failed ");					
 		}
   	}
   
 
 //=======================================  MO PDL (120) SSN Start = 020202053 ================================================
    
   @Test(priority = 65, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_126_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_126"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->Change CC_INFO_KEY-->Run 1238 Schduler-->Full Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
   			String FileName = "QC_Sprint2_QF_601_TS_126_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                    
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.scheduler_1238_run();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fullpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                             	  					   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);								
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_126_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_126_Txn_Testdata Transaction Failed ");					
 		}
   	}
  
 //=======================================  MO PDL (120) SSN Start = 020202069 ================================================
   
   @Test(priority = 66, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_170_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_170"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin Portal");
   			String FileName = "QC_Sprint2_QF_601_TS_170_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);                                 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fullpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                             	  					   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL); 								
   				}
   			}
   		}
   		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_170_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_170_Txn_Testdata Transaction Failed ");					
  		}
   	}
   
//=======================================  MO PDL (120) SSN Start = 020202145 ================================================
   
   @Test(priority = 67, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
   
   public static void QC_Sprint2_QF_601_TS_171_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_171"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Menu By Changing To Store 120");
   			String FileName = "QC_Sprint2_QF_601_TS_171_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);                                 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fullpayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                             	  					   					
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
   				    QCCSRLoginLogout.logout(SSN, AppURL);
   					  				
   				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_menu(SSN, AppURL);					
					CentralStore_Login_Logout.logout(SSN, AppURL);
								
   				}
   			}
   		}
   		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_171_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_171_Txn_Testdata Transaction Failed ");					
  		}
   	}
    
  //=======================================  MO PDL (120) SSN Start = 020202073 ================================================
   
  @Test(priority = 68, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_172_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_172"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_172_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);                                 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fullpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                            	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  					QCCentralStore.check_clear_dropdown(SSN, AppURL);
  					CentralStore_Login_Logout.logout(SSN, AppURL);								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_172_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_172_Txn_Testdata Transaction Failed ");					
  		}
  	}
   
  //=======================================  MO PDL (120) SSN Start = 020202077 ================================================

  @Test(priority = 69, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_174_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_174"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Partial DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin Portal");
  			String FileName = "QC_Sprint2_QF_601_TS_174_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                      
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
                  
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.partialdefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                           	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL); 								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_174_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_174_Txn_Testdata Transaction Failed ");					
  		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202141 ================================================

  @Test(priority = 70, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_175_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_175"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Partial DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_175_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                      
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
                  
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.partialdefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                           	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  				    
  				    CentralStore_Login_Logout.login(SSN, AppURL);
 					QCCentralStore.check_clear_menu(SSN, AppURL);					
					CentralStore_Login_Logout.logout(SSN, AppURL);
  					  				
  				    								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_175_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_175_Txn_Testdata Transaction Failed ");					
  		}
  	}

  //=======================================  MO PDL (120) SSN Start = 020202081 ================================================

  @Test(priority = 71, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_176_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_176"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Partial DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_176_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
                
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.partialdefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                         	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  					QCCentralStore.check_clear_dropdown(SSN, AppURL);
  					CentralStore_Login_Logout.logout(SSN, AppURL);								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_174_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_174_Txn_Testdata Transaction Failed ");					
  		}
  	}


  //=======================================  MO PDL (120) SSN Start = 020202085 ================================================

  @Test(priority = 72, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_178_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_178"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Full DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin Portal");
  			String FileName = "QC_Sprint2_QF_601_TS_178_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
                
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fulldefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                         	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL); 								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_178_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_178_Txn_Testdata Transaction Failed ");					
  		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202149 ================================================

  @Test(priority = 73, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_179_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_179"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Full DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_179_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
                
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fulldefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                         	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);					
  				    CentralStore_Login_Logout.logout(SSN, AppURL); 								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_179_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_179_Txn_Testdata Transaction Failed ");					
  		}
  	}

  //=======================================  MO PDL (120) SSN Start = 020202089 ================================================

  @Test(priority = 74, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_180_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_180"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->Full DefaultPayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_180_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                  
                    QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
              
                    QCCSRLoginLogout.login(SSN, AppURL);                   
                    QCCSR_Payment.fulldefaultpayment(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
                                                                                                       	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  					QCCentralStore.check_clear_dropdown(SSN, AppURL);
  					CentralStore_Login_Logout.logout(SSN, AppURL);								
  				}
  			}
  		}
  		catch (Exception e) {
  			System.out.println("under catch of Test" + e);
  			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_180_Txn_Testdata");
  			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
  			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_180_Txn_Testdata Transaction Failed ");					
  		}
  	}

//=======================================  MO PDL (120) SSN Start = 020202005 ================================================ 
  @Test(priority = 75, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
 
  public static void QC_Sprint2_QF_601_TS_182_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_182"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->BuyBack-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
  			String FileName = "QC_Sprint2_QF_601_TS_182_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);                  
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_BuyBack.buyback_chkcash(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  					QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);  									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_182_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_182_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202153 ================================================ 
  @Test(priority = 76, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
 
  public static void QC_Sprint2_QF_601_TS_183_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_183"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->BuyBack-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_183_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);                  
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_BuyBack.buyback_chkcash(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);
  				    CentralStore_Login_Logout.logout(SSN, AppURL);  									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_183_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_183_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202157 ================================================ 
  @Test(priority = 77, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
 
  public static void QC_Sprint2_QF_601_TS_184_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_184"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->BuyBack-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_184_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);                  
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSR_BuyBack.buyback_chkcash(SSN, AppURL);
  					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  				    
  				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL); 
  					  				
  				   									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_184_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_184_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202093 ================================================

  @Test(priority = 78, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_186_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_186"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Partial PrePayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
			String FileName = "QC_Sprint2_QF_601_TS_186_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					QCProc.mopdl_120_proc();
					Thread.sleep(3000);
					  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_partial_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
					QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_186_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_186_Txn_Testdata Transaction Failed ");					
		}
	}
  
//=======================================  MO PDL (120) SSN Start = 020202093 ================================================

  @Test(priority = 79, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_187_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_187"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Partial PrePayment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
			String FileName = "QC_Sprint2_QF_601_TS_187_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					/*QCProc.mopdl_120_proc();
					Thread.sleep(3000);*/
					  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_partial_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
				    CentralStore_Login_Logout.login(SSN, AppURL);
				    QCCentralStore.check_clear_menu(SSN, AppURL);
				    CentralStore_Login_Logout.logout(SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_187_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_187_Txn_Testdata Transaction Failed ");					
		}
	}
  
//=======================================  MO PDL (120) SSN Start = 020202097 ================================================

  @Test(priority = 80, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_188_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_188"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Partial PrePayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
			String FileName = "QC_Sprint2_QF_601_TS_188_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_partial_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_188_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_188_Txn_Testdata Transaction Failed ");					
		}
	}

//=======================================  MO PDL (120) SSN Start = 020202101 ================================================

  @Test(priority = 81, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_190_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_190"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Full PrePayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
			String FileName = "QC_Sprint2_QF_601_TS_190_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_full_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
					QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_190_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_190_Txn_Testdata Transaction Failed ");					
		}
	}
  
//=======================================  MO PDL (120) SSN Start = 020202165 ================================================

  @Test(priority = 82, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_191_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_191"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Full PrePayment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
			String FileName = "QC_Sprint2_QF_601_TS_191_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_full_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
				    CentralStore_Login_Logout.login(SSN, AppURL);
				    QCCentralStore.check_clear_menu(SSN, AppURL);
				    CentralStore_Login_Logout.logout(SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_191_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_191_Txn_Testdata Transaction Failed ");					
		}
	}
   
//=======================================  MO PDL (120) SSN Start = 020202105 ================================================

  @Test(priority = 83, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

  public static void QC_Sprint2_QF_601_TS_192_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_192"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->DueDate-->Deposit-->GraceDays-->Full PrePayment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
			String FileName = "QC_Sprint2_QF_601_TS_192_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL); 
					
					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
					
                    QCCSRLoginLogout.login(SSN, AppURL);
 					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
 					QCCSRLoginLogout.logout(SSN, AppURL);
 					
 					QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.ageStoreGraceDays(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.ach_full_prepayment(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
					                   
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
					  				
				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL); 									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_192_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_192_Txn_Testdata Transaction Failed ");					
		}
	}

//=======================================  MO PDL (120) SSN Start = 020202109 ================================================
    
  @Test(priority = 84, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_194_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_194"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
  			String FileName = "QC_Sprint2_QF_601_TS_194_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					QCProc.mopdl_120_proc();
					Thread.sleep(3000);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achpartialpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_194_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_194_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202169 ================================================
  
  @Test(priority = 85, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_195_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_195"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_195_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					QCProc.mopdl_120_proc();
					Thread.sleep(3000);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achpartialpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);
  				    CentralStore_Login_Logout.logout(SSN, AppURL);									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_195_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_195_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202113 ================================================
  
  @Test(priority = 86, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_196_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_196"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_196_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					QCProc.mopdl_120_proc();
					Thread.sleep(3000);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achpartialpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  				    
  				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL);					  				
  				   								
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_196_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_196_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202117 ================================================
  
  @Test(priority = 87, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_198_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_198"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Full Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
  			String FileName = "QC_Sprint2_QF_601_TS_198_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					/*QCProc.mopdl_120_proc();
					Thread.sleep(3000);*/
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achfullpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_198_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_198_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202173 ================================================
  
  @Test(priority = 88, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_199_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_199"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Full Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_199_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					/*QCProc.mopdl_120_proc();
					Thread.sleep(3000);*/
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achfullpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);
  				    CentralStore_Login_Logout.logout(SSN, AppURL);									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_199_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_199_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202121 ================================================
  
  @Test(priority = 89, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_200_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_200"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->ACH Deposit-->ACH Return-->ACH Full Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_200_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					
  					/*QCProc.mopdl_120_proc();
					Thread.sleep(3000);*/
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Deposit.mopdldepositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);					
					//Return
					QCCSR_ACHReturn.achreturn(SSN, AppURL);					 					  					
  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_Payment.achfullpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  				    
  				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL);					  				
  				   								
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_200_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_200_Txn_Testdata Transaction Failed ");					
		}
  	}
  
  
//=======================================  MO PDL (120) SSN Start = 020202125 ================================================
  
  @Test(priority = 90, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_202_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_202"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Partial NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
  			String FileName = "QC_Sprint2_QF_601_TS_202_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.partial_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_202_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_202_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202177 ================================================
  
  @Test(priority = 91, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_203_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_203"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Partial NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_203_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.partial_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
				    QCCentralStore.check_clear_menu(SSN, AppURL);
				    CentralStore_Login_Logout.logout(SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_203_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_203_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202129 ================================================
  
  @Test(priority = 92, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_204_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_204"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Partial NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_204_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.partial_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_204_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_204_Txn_Testdata Transaction Failed ");					
		}
  	}
  
  
//=======================================  MO PDL (120) SSN Start = 020202133 ================================================
  
  @Test(priority = 93, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_206_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_206"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Full NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin");
  			String FileName = "QC_Sprint2_QF_601_TS_206_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.full_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_206_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_206_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202181 ================================================
  
  @Test(priority = 94, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_207_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_207"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Full NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_207_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.full_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);
  				    CentralStore_Login_Logout.logout(SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_207_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_207_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202137 ================================================
  
  @Test(priority = 95, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_208_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_208"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan With DC-->Due Date-->DC Deposit-->Change CC_INFO_KEY-->Full NSF Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_208_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Deposit.dc_depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                   
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_CaptureDate_LoanNumber.date_loan_capture(SSN, AppURL);
                   
                    QC_CCINFO_KEY_CHANGE_DC_RETURN.change_cc_info_key();
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QC_DC_Return_Validation.dc_dbreturn_validation(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);                  
                    QCCSR_Payment.full_nsfpayment(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
                                                              	  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL);							
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_208_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_208_Txn_Testdata Transaction Failed ");					
		}
  	}
//=======================================  MO PDL (120) SSN Start = 020202041 ================================================
  
  @Test(priority = 96, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_210_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_210"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin Portal");
  			String FileName = "QC_Sprint2_QF_601_TS_210_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_partialpayment(SSN, AppURL);               
  					QCCSRLoginLogout.logout(SSN, AppURL);							
  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);  									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_210_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_210_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202085 ================================================
  
  
  @Test(priority = 97, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_211_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_211"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
  			String FileName = "QC_Sprint2_QF_601_TS_211_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_partialpayment(SSN, AppURL);               
  					QCCSRLoginLogout.logout(SSN, AppURL);							
  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    CentralStore_Login_Logout.login(SSN, AppURL);
  				    QCCentralStore.check_clear_menu(SSN, AppURL);
  				    CentralStore_Login_Logout.logout(SSN, AppURL); 									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_211_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_211_Txn_Testdata Transaction Failed ");					
		}
  	}
  
  
//=======================================  MO PDL (120) SSN Start = 020202045 ================================================
  
  
  @Test(priority = 98, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_212_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_212"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Partial Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Transaction Dropdown");
  			String FileName = "QC_Sprint2_QF_601_TS_212_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_partialpayment(SSN, AppURL);               
  					QCCSRLoginLogout.logout(SSN, AppURL);							
  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
		   		    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL); 									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_212_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_212_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202061 ================================================
  
  @Test(priority = 99, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
  public static void QC_Sprint2_QF_601_TS_214_Txn_Testdata() throws Exception {
  		try {
  			test = reports.startTest(("QC_Sprint2_QF_601_TS_214"), 		    
  			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Full Payment With Check-->Internal Transfer-->CMG Deposit-->Check Clear In Admin Portal");
  			String FileName = "QC_Sprint2_QF_601_TS_214_Txn_Testdata.xls";   			                    			
  			TestData = new ExcelNew(System.getProperty("user.dir")
  					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
  			
  			int lastrow = TestData.getLastRow("Start");
  			String sheetName = "Start";
  			
  			System.out.println(lastrow);
  			for (int row = 2; row <= lastrow; row++) {

  				String RunFlag = TestData.getCellData(sheetName, "Run", row);
  				
  				if (RunFlag.equals("Y")) {
  					
  					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
  					String SSN = TestData.getCellData(sheetName, "SSN", row);
  				
  					System.out.println(AppURL);
  					  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
  					QCCSRLoginLogout.logout(SSN, AppURL); 	
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
  					QCCSRNewLoan.newLoan(SSN, AppURL);						
  					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
  					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                   
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
  					
  					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_fullpayment(SSN, AppURL);               
  					QCCSRLoginLogout.logout(SSN, AppURL);							
  					   					
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
  				   				    
  				    QCCSRLoginLogout.login(SSN, AppURL);
  				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
  				    QCCSRLoginLogout.logout(SSN, AppURL);
  					  				
  				    QCCSR_Check_Clear.checkclear_adminmenu(driver, SSN, AppURL);  									
  				}
  			}
  		}
  		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_214_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_214_Txn_Testdata Transaction Failed ");					
		}
  	}
  
//=======================================  MO PDL (120) SSN Start = 020202189 ================================================


@Test(priority = 100, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

public static void QC_Sprint2_QF_601_TS_215_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_215"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Full Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Menu By Changing To Store 120");
			String FileName = "QC_Sprint2_QF_601_TS_215_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                 
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_fullpayment(SSN, AppURL);               
					QCCSRLoginLogout.logout(SSN, AppURL);							
					   					
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
				    
				    CentralStore_Login_Logout.login(SSN, AppURL);
				    QCCentralStore.check_clear_menu(SSN, AppURL);
				    CentralStore_Login_Logout.logout(SSN, AppURL);
					  									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_215_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_215_Txn_Testdata Transaction Failed ");					
		}
	}

  
  
//=======================================  MO PDL (120) SSN Start = 020202065 ================================================


@Test(priority = 101, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")

public static void QC_Sprint2_QF_601_TS_216_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_Sprint2_QF_601_TS_216"), 		    
			"CSR Login->Borrower Registration-->PDL NewLoan-->Due Date-->Default-->WriteOff-->WO Recovery with Full Payment With Check-->Internal Transfer-->CMG Deposit-->Clear In Central Store(2997) Transaction Dropdown");
			String FileName = "QC_Sprint2_QF_601_TS_216_Txn_Testdata.xls";   			                    			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			
			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
					
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				
					System.out.println(AppURL);
					  					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
					QCCSRLoginLogout.logout(SSN, AppURL); 	
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);						
					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL);
                                 
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_LOC_ManualDefault.pdlmanualdefault(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSR_WriteOff.ilpwriteoff(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSR_Payment.writeoff_recovery_fullpayment(SSN, AppURL);               
					QCCSRLoginLogout.logout(SSN, AppURL);							
					   					
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
				   				    
				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
				    
				    CentralStore_Login_Logout.login(SSN, AppURL);
					QCCentralStore.check_clear_dropdown(SSN, AppURL);
					CentralStore_Login_Logout.logout(SSN, AppURL);
					  									
				}
			}
		}
		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_216_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_216_Txn_Testdata Transaction Failed ");					
		}
	}

  

 //=======================================  MO PDL (120) SSN Start = 020202009 ================================================
   
   
   @Test(priority = 102, groups = "Ratikanta_Sprint2_REQ_601_MOPDL")
  
   public static void QC_Sprint2_QF_601_TS_226_Txn_Testdata() throws Exception {
   		try {
   			test = reports.startTest(("QC_Sprint2_QF_601_TS_226"), 		    
   			"CSR Login->Borrower Registration-->PDL NewLoan With Check-->Check Deposit-->Internal Transfer-->CMG Deposit-->Check Return In Admin-->Redeposit With RCK-->ACH Process-->Clear In Admin Bulk");
   			String FileName = "QC_Sprint2_QF_601_TS_226_Txn_Testdata.xls";   			                    			
   			TestData = new ExcelNew(System.getProperty("user.dir")
   					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
   			
   			int lastrow = TestData.getLastRow("Start");
   			String sheetName = "Start";
   			
   			System.out.println(lastrow);
   			for (int row = 2; row <= lastrow; row++) {

   				String RunFlag = TestData.getCellData(sheetName, "Run", row);
   				
   				if (RunFlag.equals("Y")) {
   					
   					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
   					String SSN = TestData.getCellData(sheetName, "SSN", row);
   				
   					System.out.println(AppURL);
   					  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);	
   					QCCSRLoginLogout.logout(SSN, AppURL); 	
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSRNewLoan.newLoan(SSN, AppURL);						
   					QCCSRLoginLogout.logout(SSN, AppURL);   					  			
   					
                    QCCSRLoginLogout.login(SSN, AppURL);							      
                    QCAgeStoreDueDate.pdlageStoreDueDate(SSN, AppURL); 
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
                    QCCSRDeposit.depositDropDown(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   				    QCCSRInternalTransfer.internaltransfer(SSN, AppURL);
   				    
   				    QCCSRLoginLogout.login(SSN, AppURL);
				    QCCSRCashMgmtDeposit.cashmgmtdeposit(SSN, AppURL);
				    QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSR_CheckReturn.checkreturn_adminmenu(driver, SSN, AppURL);
   					  					                  					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_Check_Redeposit.check_redeposit(SSN, AppURL);
   					QCCSRLoginLogout.logout(SSN, AppURL);
   					
   					QCCSRLoginLogout.login(SSN, AppURL);
   					QCCSR_CaptureDate_LoanNumber.businessdate(SSN, AppURL);
   					
   					QCCSRACH_Processing_NACHA.achprocess_nacha(SSN, AppURL);
   					
   					QCCSRACH_Clear.achclear_adminmenu(driver, SSN, AppURL);
   					
   				   				    				      					  																		
   				}
   			}
   		}
   		catch (Exception e) {
 			System.out.println("under catch of Test" + e);
 			String screenshotPath = getScreenhot(driver, "QC_Sprint2_QF_601_TS_226_Txn_Testdata");
 			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
 			test.log(LogStatus.FAIL, "QC_Sprint2_QF_601_TS_226_Txn_Testdata Transaction Failed ");					
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

						new FileReader("C:/Qc_Batch_WildFly/QC_Sprint_Scenarios/src/test/java/tests/Objects.properties"));

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
			/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 5000);*/	

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
