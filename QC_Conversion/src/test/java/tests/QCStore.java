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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
	
	
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String business_date;
	public static String csr_url;
	public static String appdate;
	public static String csrloginpage;
	public static String AppURL;
	public static String AdminURL;
	
	public static String AdminUserName;
	public static String AdminPassword;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;

	public static String NextDueDate;



	//=================  Ratikanta Updated Conversion scenarios ======================
	
	//=================  Store = 590, Start Date : 05/01/2019 ======================
	
	@Test(priority = 1, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata() throws Exception {
		
		try {
			test = reports.startTest(("QC_1ILP_Loan_1PDL_Loan_Trying_To_Apply_Conversion(BySelecting_ILPLoan)_Void_Validate the Loan Status and History"),
					"Login->Borrower Registration-->1ILP New Loan-->1PDL New Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_ILPLoan)-->Void-->Validate Loan Status(Old and New)");
			String FileName = "QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan2(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRConversion.toilpconversion(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRVoid.cvoid(SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRStatusValidation.loanstatus(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
										
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.toilphistory(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
			
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn ");

		}
	}
	
	@Test(priority = 2, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata() throws Exception {
		
		try {
			test = reports.startTest(("QC_1ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion(BySelecting_ILPLoan)_Void_Validate the Loan Status and History"),
					"Login->Borrower Registration-->1ILP New Loan-->2PDL New Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_ILPLoan)-->Void-->Validate Loan Status(Old and New)");
			String FileName = "QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan2(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan2(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRConversion.twopdlloantoilpconversion(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRVoid.cvoid(SSN, SSN);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRStatusValidation.twopdlloanstatus(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
										
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.twopdlloantoilphistory(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
			
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn ");

		}
	}	
	
	@Test(priority = 3, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILPDefault_Loan_PDLReturn_Loan_Trying_To_Apply_Conversion_BySelecting_BothLoan_Txn_Testdata() throws Exception {
			
			try {
				test = reports.startTest(("QC_1ILP_DefaultLoan_1PDL_ReturnLoan_Trying_To_Apply_Conversion(BySelecting_BothLoan)_Void_Validate the Loan Status and History"),
						"Login->Borrower Registration-->1ILP Defaulted Loan-->PDL Return Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_BothLoan)-->Void-->Validate Loan Status(Old and New)");
				String FileName = "QC_ILPDefault_Loan_PDLReturn_Loan_Trying_To_Apply_Conversion_BySelecting_BothLoan_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				
				String sheetName = "Start";
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {

						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRDefault.sdefault(SSN, AppURL);												
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRDefaultVerify.defaultverify(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSR_Deposit.deposit(SSN, AppURL);
																
						QCCSRReturnPosting.returnposting(SSN, AppURL);
																		
						QCAdminACHReturn.achreturn(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						
						QCCSRConversion.ilp_default_pdl_return_conversion(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRVoid.cvoid(SSN, SSN);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRStatusValidation.loanstatus(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.toilphistory(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
				
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILPDefault_Loan_PDLReturn_Loan_Trying_To_Apply_Conversion_BySelecting_BothLoan_Txn_Testdata");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILPDefault_Loan_PDLReturn_Loan_Trying_To_Apply_Conversion_BySelecting_BothLoan_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILPDefault_Loan_PDLReturn_Loan_Trying_To_Apply_Conversion_BySelecting_BothLoan_Txn ");

			}
		}	
	
	@Test(priority = 4, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_PDL_Loan_Trying_To_Apply_Conversion_Txn() throws Exception {
		
		try {
			test = reports.startTest(("QC_PDL_Loan_Trying_To_Apply_Conversion"),
					"Login->Borrower Registration-->New Loan-->Age the Store to Grace days-->Conversion");
			String FileName = "QC_PDL_Loan_Trying_To_Apply_Conversion_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_PDL_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRConversion.pdltoilpconversion(SSN, AppURL);
     				QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.pdltoilphistory(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_PDL_Loan_Trying_To_Apply_Conversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_PDL_Loan_Trying_To_Apply_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_PDL_Loan_Trying_To_Apply_Conversion_Txn ");

		}
	}
	
	@Test(priority = 5, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILP_Loan_Trying_To_Apply_Conversion_Txn() throws Exception {
		
		try {
			test = reports.startTest(("QC_ILP_Loan_Trying_To_Apply_Conversion"),
					"Login->Borrower Registration-->New Loan-->Age the Store to Grace days-->Conversion");
			String FileName = "QC_ILP_Loan_Trying_To_Apply_Conversion_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRConversion.ilptotlpconversion(SSN, AppURL);					
					
								/*QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRHistory.ilptotlphistoryconversion(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);*/
					
					
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_ILP_Loan_Trying_To_Apply_Conversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_Trying_To_Apply_Conversion_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_Trying_To_Apply_Conversion_Txn ");

		}
	}
	
	@Test(priority = 6, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_PDLLoan_Txn_Testdata() throws Exception {
		
		try {
			test = reports.startTest(("QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_PDLLoan"),
					"Login->Borrower Registration-->ILP New Loan-->PDL New Loan-->Age the Store to Grace days-->Conversion BySelecting PDLLoan");
			String FileName = "QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_PDLLoan_Txn_Testdata.xls";
			
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

			
			int lastrow = TestData.getLastRow("Start");
			
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan2(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRConversion.pdlloanconversion(SSN, AppURL);					
				
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_ILP_Loan_Trying_To_Apply_Conversion_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_PDLLoan_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_BySelecting_PDLLoan_Txn ");

		}
	}
	
	@Test(priority = 7, enabled = true, groups = "Ratikanta_Conversion")

	public static void QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_Txn_Testdata() throws Exception {
			
			try {
				test = reports.startTest(("QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion"),
						"Login->Borrower Registration-->ILP New Loan-->PDL New Loan-->Age the Store to Grace days-->Conversion By Selecting Both The Loans");
				String FileName = "QC_ILP_Loan_PDL_Loan_Trying_To_Apply_Conversion_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				
				String sheetName = "Start";
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {

						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);						  
						QCCSRConversion.conversionwithallchecked(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
												
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.ilp_pdl_history(SSN, SSN);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Loan_Trying_To_Apply_Conversion_Txn");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_Trying_To_Apply_Conversion_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_Trying_To_Apply_Conversion_Txn ");

			}
		}	
	
//=========================== Need to check in Local Reg 2.191 server=======================================
	
	//@Test(priority = 8, enabled = true, groups = "Ratikanta_Conversion")

	  public static void QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoanand1PDLLoan_Txn_Testdata() throws Exception {
			
			try {
				test = reports.startTest(("QC_1ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion(BySelecting_ILPLoan and 1 PDL Loan)_Void_Validate the Loan Status and History"),
						"Login->Borrower Registration-->1ILP New Loan-->2PDL New Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_ILPLoan and 1 PDL Loan)-->Void-->Validate Loan Status(Old and New)");
				String FileName = "QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoanand1PDLLoan_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				
				String sheetName = "Start";
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {

						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
				//Issue :no Cross loan error message is not displaying--->Need To Check In 2.191
						
						/*QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRConversion.twopdlloantoilpconversion(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRVoid.cvoid(SSN, SSN);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRStatusValidation.oneilponepdlconversion(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
											
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.twopdlloantoilphistory(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);*/
						
				
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoanand1PDLLoan_Txn_Testdata");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoanand1PDLLoan_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_ILP_Loan_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoanand1PDLLoan_Txn ");

			}
		}	
	
 //@Test(priority = 9, enabled = true, groups = "Ratikanta_Conversion")

		public static void QC_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata() throws Exception {
					
					try {
						test = reports.startTest(("QC_2PDL_Loan_Trying_To_Apply_Conversion(BySelecting_ILPLoan)_Void_Validate the Loan Status and History"),
								"Login->Borrower Registration-->1ILP New Loan-->2PDL New Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_ILPLoan)-->Void-->Validate Loan Status(Old and New)");
						String FileName = "QC_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata.xls";
						
						TestData = new ExcelNew(System.getProperty("user.dir")
								+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

						
						int lastrow = TestData.getLastRow("Start");
						
						String sheetName = "Start";
						System.out.println(lastrow);
						for (int row = 2; row <= lastrow; row++) {

							String RunFlag = TestData.getCellData(sheetName, "Run", row);

							if (RunFlag.equals("Y")) {

								//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
								String SSN = TestData.getCellData(sheetName, "SSN", row);

								System.out.println(AppURL);

								QCCSRLoginLogout.login(SSN, AppURL);
								QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRNewLoan.newLoan(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRNewLoan.newLoan2(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);																
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRConversion.pdlloanconversion(SSN, AppURL);
								
								
						//Issue :no Cross loan error message is not displaying--->Need To Check In 2.191	
								
								/*QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRConversion.twopdlloantoilpconversion(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);
								
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRVoid.cvoid(SSN, SSN);
																												
								QCCSRLoginLogout.login(SSN, AppURL);
								QCCSRHistory.twopdlloantoilphistory(SSN, AppURL);
								QCCSRLoginLogout.logout(SSN, AppURL);*/
								
						
							}
						}
					}

					catch (Exception e) {
						System.out.println("QC_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn_Testdata");
						// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
						// start scenario 1 " , ExtentColor.RED));
						String screenshotPath = getScreenhot(driver, "QC_2PDL_Loan_Trying_To_Apply_Conversion_BySelecting_ILPLoan_Txn");
						test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

						test.log(LogStatus.ERROR, "In Loan Decissioning Screen Deny Option is not displaying");

					}
				}	
	
		//@Test(priority = 10, enabled = true, groups = "Ratikanta_Conversion")

		public static void QC_2ILP_Loan_Trying_To_Apply_Conversion_BySelecting_BothILPLoan_Txn_Testdata() throws Exception {
			
			try {
				test = reports.startTest(("QC_2ILP_Loan_Trying_To_Apply_Conversion(BySelecting_Both ILPLoan)_Void_Validate the Loan Status and History"),
						"Login->Borrower Registration-->2ILP New Loan-->Age the Store to Grace days-->Apply Conversion(BySelecting_ILPLoan)-->Void-->Validate Loan Status(Old and New)");
				String FileName = "QC_2ILP_Loan_Trying_To_Apply_Conversion_BySelecting_BothILPLoan_Txn_Testdata.xls";
				
				TestData = new ExcelNew(System.getProperty("user.dir")
						+ prop.getProperty("QC_Store_ILP_NewLoan_Test_data_sheet_path") + FileName);

				
				int lastrow = TestData.getLastRow("Start");
				
				String sheetName = "Start";
				System.out.println(lastrow);
				for (int row = 2; row <= lastrow; row++) {

					String RunFlag = TestData.getCellData(sheetName, "Run", row);

					if (RunFlag.equals("Y")) {

						//String AppURL = TestData.getCellData(sheetName, "AppURL", row);
						String SSN = TestData.getCellData(sheetName, "SSN", row);

						System.out.println(AppURL);

						QCCSRLoginLogout.login(SSN, AppURL);
						QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						  //QCCSRNewLoan.newLoan(SSN, AppURL);
						QCCSRNewLoan2.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRNewLoan.newLoan2(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);																
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRConversion.pdlloanconversion(SSN, AppURL);
						
						//QCCSRConversion.ilptotlpconversion(SSN, AppURL);
						
						
				//Issue :no Cross loan error message is not displaying	
						
						/*QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRConversion.twopdlloantoilpconversion(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);
						
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRVoid.cvoid(SSN, SSN);
																										
						QCCSRLoginLogout.login(SSN, AppURL);
						QCCSRHistory.twopdlloantoilphistory(SSN, AppURL);
						QCCSRLoginLogout.logout(SSN, AppURL);*/
						
				
					}
				}
			}

			catch (Exception e) {
				System.out.println("QC_2ILP_Loan_Trying_To_Apply_Conversion_BySelecting_BothILPLoan_Txn_Testdata");
				// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
				// start scenario 1 " , ExtentColor.RED));
				String screenshotPath = getScreenhot(driver, "QC_2ILP_Loan_Trying_To_Apply_Conversion_BySelecting_BothILPLoan_Txn");
				test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

				test.log(LogStatus.ERROR, "Unable to start scenario QC_2ILP_Loan_Trying_To_Apply_Conversion_BySelecting_BothILPLoan_Txn_Testdata");

			}
		}	
	
	
	
//================================================================================================	
	@BeforeClass(alwaysRun = true)
	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			
			try {
				reader = new BufferedReader(
						new FileReader("C:/Qc_Batch_WildFly/QC_Conversion/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				
				csr_url = prop.getProperty("CSR_URL");
				csrloginpage = prop.getProperty("Login_Page");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				AdminUserName= prop.getProperty("admin_userid");
				AdminPassword= prop.getProperty("admin_password");
				
				String Rfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";
				
				

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") +Rfilename,
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

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/FailedTestsScreenshots/"
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

	// @AfterMethod(alwaysRun=true)

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
		// System.out.println("startign of switch case");
		// System.out.println(obj);
		/*
		 * switch(loctype) { case "id": locator=By.id(locname); break; case
		 * "name": locator=By.name(locname); break; case "linkText":
		 * locator=By.linkText(locname); break; case "xpath":
		 * locator=By.xpath(locname); case "cssSelector":
		 * locator=By.cssSelector(locname); break; }
		 */

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
