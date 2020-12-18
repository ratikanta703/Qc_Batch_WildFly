package tests;

import static org.testng.Assert.assertFalse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.MarkupHelper;
/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCCSRConversion extends QCStore {
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static String ESign_CheckNbr;
	public static String ESign_Password;
	public static String ESign_Checks;
	public static String CouponNbr;
	public static String ChkgAcctNbr;
	public static String AllowPromotion;
	public static String ESign_Preference;
	public static String ESign_CourtesyCallConsent;
	public static String ESign_DisbType;
	public static String ESign_LoanAmt;
	public static String ESign_CollateralType;
	public static String stateProductType;
	public static String stateProduct;
	public static String StoreID;
	public static String NewVIN;
	public static String VehicleType;
	public static String NewLoan_Term;
	public static String NewLoan_ProductName;
	public static String ProductType;
	public static String Password;
	public static String UserName;
	public static String ProductID;
	public static String last4cheknum;
	public static String InsuranceExpiryDate0[] = null;
	public static String InsuranceExpiryDate3;
	public static String InsuranceExpiryDate2;
	public static String InsuranceExpiryDate1;
	public static String PolicyNumber;

	public static String InsuranceCompany;
	public static String PhoneNbr3;
	public static String PhoneNbr2;
	public static String PhoneNbr1;
	public static String PhoneNbr;
	public static String InsuranceCoverage;
	public static String LicensePlateExp;
	public static String LicensePlateNumber;
	public static String ExteriorColor;
	public static String AppraisalValue;
	public static String InsuranceExpiryDate;
	public static String TitleNumber;
	public static int rnum;
	public static int cnum;
	public static String product_name;
	public static int count;
	public static List<WebElement> rows;
	public static String No_of_checks;
	public static String cardType;
	public static String cardNumber;
	public static String cardEx_month;
	public static String cardEx_Year;
	public static String cvv;
	public static String CardHolderName;
	public static String VIN;
	public static String Miles;
	public static String VehicleGrade;
	public static String relamount;
	public static String CC_Issuer_Name;
	
	public static void ilp_default_pdl_return_conversion(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();												                             
						test.log(LogStatus.PASS, "Clicked on   Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(10000);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();						
						test.log(LogStatus.PASS, "Clicked on PDL Loan Checkbox");
						Thread.sleep(500);
						test.log(LogStatus.PASS, "ILP Loan Checkbox already selected by default");
						Thread.sleep(500);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(8000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("ILP")) {
									ILP();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}

	public static void pdltoilpconversion(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();												                             
						test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(10000);
						
						test.log(LogStatus.PASS, "PDL Loan Checkbox already selected by default");
						Thread.sleep(500);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(8000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("ILP")) {
									ILP();

								}
								if (ProductID.equals("PDL_ILP")) {
									PDL_ILP();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}
	public static void toilpconversion(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();
						
						                             
						test.log(LogStatus.PASS, "Clicked on  ILP Loan Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(10000);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on PDL Loan Checkbox");
						Thread.sleep(500);
						test.log(LogStatus.PASS, "ILP Loan Checkbox already selected by default");
						Thread.sleep(500);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(8000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("ILP")) {
									ILP();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}
	
	public static void twopdlloantoilpconversion(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[13]/input")).click();											                             
						test.log(LogStatus.PASS, "Clicked on  ILP Loan Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(10000);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();	
						Thread.sleep(500);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[5]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on Both PDL Loan Checkbox");
						Thread.sleep(500);
						test.log(LogStatus.PASS, "ILP Loan Checkbox already selected by default");
						Thread.sleep(500);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(8000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("ILP")) {
									ILP();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}

	public static void oneilponepdlconversion(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
						InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
						InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
						InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
						No_of_checks = TestData.getCellData(sheetName, "No_of_checks", row);
						CC_Issuer_Name = TestData.getCellData(sheetName, "CC_Issuer_Name", row);

						cardType = TestData.getCellData(sheetName, "Card Type ", row);
						cardNumber = TestData.getCellData(sheetName, "Debit Card No", row);
						cardEx_month = TestData.getCellData(sheetName, "Expiry Month", row);
						cardEx_Year = TestData.getCellData(sheetName, "Expiry Year", row);
						cvv = TestData.getCellData(sheetName, "CVV", row);
						CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);

						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "New Loan initiation has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[8]/td[13]/input")).click();											                             
						test.log(LogStatus.PASS, "Clicked on  ILP Loan Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(8000);		                              
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[5]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Clicked on PDL Loan Checkbox");
						Thread.sleep(500);
						test.log(LogStatus.PASS, "ILP Loan Checkbox already selected by default");
						Thread.sleep(500);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(10000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[1]
								// System.out.println("current row num "+count);
								// System.out.println(" rows num "+
								// rows.size());

								if (ProductID.equals("ILP")) {
									ILP();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}
	
	
	public static void conversionwithallchecked(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		
			
			try {
				
				int lastrow = TestData.getLastRow("Conversion");
				String sheetName = "Conversion";

				for (int row = 2; row <= lastrow; row++) {
					String RegSSN = TestData.getCellData(sheetName, "SSN", row);
					if (SSN.equals(RegSSN)) {
						State = TestData.getCellData(sheetName, "StateID", row);
						ProductID = TestData.getCellData(sheetName, "ProductID", row);
						System.out.println(ProductID);
						UserName = TestData.getCellData(sheetName, "UserName", row);
						Password = TestData.getCellData(sheetName, "Password", row);
						ProductType = TestData.getCellData(sheetName, "ProductType", row);
						NewLoan_ProductName = TestData.getCellData(sheetName, "NewLoan_ProductName", row);
						NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
						NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
						VIN = TestData.getCellData(sheetName, "VIN", row);
						Miles = TestData.getCellData(sheetName, "Miles", row);
						// System.out.println(Term);
						// String StoreId =
						// TestData.getCellData(sheetName,"StoreID",row);
						StoreID = TestData.getCellData(sheetName, "StoreID", row);
						String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
						String TxnType = TestData.getCellData(sheetName, "TxnType", row);
						stateProduct = State + " " + ProductID;
						stateProductType = State + " " + ProductType;
						ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
						System.out.println(ESign_CollateralType);
						ESign_LoanAmt = TestData.getCellData(sheetName, "ESign_LoanAmt", row);
						// ChkgAcctNbr =
						// TestData.getCellData(sheetName,"ChkgAcctNbr",row);
						ESign_DisbType = TestData.getCellData(sheetName, "ESign_DisbType", row);
						
						ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
						AllowPromotion = TestData.getCellData(sheetName, "AllowPromotion", row);
						CouponNbr = TestData.getCellData(sheetName, "CouponNbr", row);
						ESign_Preference = TestData.getCellData(sheetName, "ESign_Preference", row);
						ESign_Checks = TestData.getCellData(sheetName, "ESign_Checks", row);
						ESign_Password = TestData.getCellData(sheetName, "ESign_Password", row);
						ESign_CheckNbr = TestData.getCellData(sheetName, "ESign_CheckNbr", row);
						// last4cheknum=
						// ChkgAcctNbr.substring(ChkgAcctNbr.length() - 4);
						last4cheknum = TestData.getCellData(sheetName, "ChkgAcctNbr", row);

						SSN1 = SSN.substring(0, 3);
						SSN2 = SSN.substring(3, 5);
						SSN3 = SSN.substring(5, 9);
						TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
						AppraisalValue = TestData.getCellData(sheetName, "Appraisal Value", row);
						ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
						LicensePlateNumber = TestData.getCellData(sheetName, "License Plate Number", row);

						VehicleGrade = TestData.getCellData(sheetName, "Vehicle Grade", row);
						LicensePlateExp = TestData.getCellData(sheetName, "License Plate Expiry", row);
						InsuranceCoverage = TestData.getCellData(sheetName, "Insurance Coverage", row);
						PhoneNbr = TestData.getCellData(sheetName, "Phone Nbr", row);
						PhoneNbr1 = PhoneNbr.substring(0, 3);
						PhoneNbr2 = PhoneNbr.substring(3, 6);
						PhoneNbr3 = PhoneNbr.substring(6, 10);
						InsuranceCompany = TestData.getCellData(sheetName, "Insurance Company", row);
						InsuranceExpiryDate = TestData.getCellData(sheetName, "Insurance Expiry Date", row);
						PolicyNumber = TestData.getCellData(sheetName, "Policy Number", row);
						
						Thread.sleep(3000);
						// test.log(LogStatus.INFO,
						// MarkupHelper.createLabel("New Loan initiation has
						// started", ExtentColor.BLUE));
						test.log(LogStatus.INFO, "Conversion has started");

						driver.switchTo().frame("topFrame");
						driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
						test.log(LogStatus.PASS, "Clicked on Loan Transactions");

						Thread.sleep(4000);

						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");

						driver.findElement(By.cssSelector("li[id='911101']")).click();
						test.log(LogStatus.PASS, "Clicked on Transactions");
						driver.switchTo().frame("main");
						driver.findElement(By.name("ssn1")).sendKeys(SSN1);
						test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
						driver.findElement(By.name("ssn2")).sendKeys(SSN2);
						test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
						driver.findElement(By.name("ssn3")).sendKeys(SSN3);
						test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
						Thread.sleep(400);
						driver.findElement(By.name("submit1")).click();
						test.log(LogStatus.PASS, "Clicked on submit Button");
						Thread.sleep(4000);
						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");

						Thread.sleep(4000);
						driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button under search results");
						Thread.sleep(4000);

						for (String winHandle : driver.getWindowHandles()) {
							driver.switchTo().window(winHandle);
						}
						driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						driver.switchTo().frame("main");
						
						//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();
						                             
						test.log(LogStatus.PASS, "Clicked on  Go button under Loans section");
						Thread.sleep(4000);
	                   				
						driver.findElement(By.name("transactionList")).sendKeys(TxnType);
						test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
						Thread.sleep(5000);
						driver.findElement(By.xpath("//*[@id='go_Button']")).click();
						test.log(LogStatus.PASS, "Clicked on Go button");
						Thread.sleep(10000);
						driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/input")).click();
						test.log(LogStatus.PASS, "Both the Check box Selected");
						Thread.sleep(1000);
						driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
						test.log(LogStatus.PASS, "Clicked on Continue Button");
						
						Thread.sleep(8000);
							if (driver.findElement(By.id("LoanButtonId")).isEnabled()) {

								WebElement htmltable = driver.findElement(By.xpath(
										"//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table"));
								// *[@id="riskViewBdy"]/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table

								rows = htmltable.findElements(By.tagName("tr"));

								count = 0;
								count = driver
										.findElements(By
												.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"))
										.size();
								

								if (ProductID.equals("ILP2")) {
									ILP2();

								}

							}

						}

						break;
					}

				//}
				break;
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// test.log(LogStatus.FAIL, MarkupHelper.createLabel("New Loan
			
				test.log(LogStatus.INFO, "Exception occured " + e.toString().substring(0, 250));
				test.log(LogStatus.FAIL, "New Loan is failed");
				Assert.assertTrue(false);
				//test.log(LogStatus.INFO, "New Loan process is initiated again due to Application sync issue");
				//driver.get("http://192.168.2.203/cc/login/index.jsp");
				break;

			}

		}
		/*if (i == 3) {
			test.log(LogStatus.FAIL, "New Loan is failed");
			Assert.assertTrue(false);
			// throw new ArithmeticException("sample");

		}*/
	}
	public static void ILP2() throws InterruptedException {
		test.log(LogStatus.PASS, "getting product name ");
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 
		int n=rows.size();
		for(int i=2;i<=n;i++){
			String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			test.log(LogStatus.PASS, "getting product name "+Pname);

			if(Pname.equals(ProductType))
			{
				if(NewLoan_Term.equals("Term1"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
				else if(NewLoan_Term.equals("Term2"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
			}
			else{
				continue;
			}

			driver.findElement(By.id("LoanButtonId")).click();
			test.log(LogStatus.PASS, "Clicked on new loan button ");
			 Thread.sleep(8000);
				
				try{							
					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
					driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();					                             
					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
					
				}
				catch(Exception e){
					//normal flow
				}
				Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			Thread.sleep(500);
			
			
			driver.findElement(By.name("qualify")).click();
			test.log(LogStatus.PASS, "Clicked on Qualify");
			Thread.sleep(15000);
			
			
			
			String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
			test.log(LogStatus.PASS, "getting request loan amount "+paymentamount);
			//--------------------------------------------------------------------------------------------------------------	

			if(ESign_CollateralType.equalsIgnoreCase("ACH")){
				Thread.sleep(1000);
				/*driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on Qualify");
				Thread.sleep(20000);*/
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
				test.log(LogStatus.PASS, "Select Tender Type as Cash");
				Thread.sleep(1000);
				
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
				test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
				Thread.sleep(1000);
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				Thread.sleep(1000);
				if(ESign_DisbType.equalsIgnoreCase("Cash")){
					Thread.sleep(1000);
					
			// For Disb Amount(Some times it is missing from screen)

		//==============================================================================
					/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
				
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);*/
	      //============================================================================
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
										
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
					test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
					Thread.sleep(8000);
					
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.

								} catch (Exception e) {

							}

								break;
							}

						}
				}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				Thread.sleep(5000);
				
	//====================================================================
				Thread.sleep(1000);

				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
									
								
				if(ESign_CourtesyCallConsent.equals("Yes"))
					Thread.sleep(800);
				{
					if(ESign_Preference.equals("Call"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("Mail"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
					}
					if(ESign_Preference.equals("SMS"))
					{
						driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

						try {
							Alert alert = driver.switchTo().alert();
							alert.dismiss();
							//if alert present, accept and move on.

						}
						catch (NoAlertPresentException e) {
							//do what you normally would if you didn't have the alert.
						}
					}

				}
 //========================================================================
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
					
				}
				//driver.findElement(By.name("finishLoan")).click();
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();
				//test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
			}

			//--------------------------------------------------------------------------------------------------------

			if(ESign_CollateralType.equalsIgnoreCase("Debit Card")){


				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);



					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	
					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();
									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}


						}
	}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	

					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");

								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();
									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {

								}
								break;
							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);
				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
					
				}
				//driver.findElement(By.name("finishLoan")).click();
				//test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
			}
			//-----------------------------------------------------------------------------------------------------------------------------------	
			if(ESign_CollateralType.equalsIgnoreCase("Check")){
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")||ESign_DisbType.equalsIgnoreCase("check")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						
					{
						Thread.sleep(800);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					else{
						test.log(LogStatus.PASS, "Esign preference selected as NO ");
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

								} catch (Exception e) {
								}
								break;
							}
					}
					}
					else
					{
						test.log(LogStatus.PASS, "Allow promotions not selected");
					}
				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				test.log(LogStatus.INFO, "Performing  check transactions");
				int chkno=987654;

				String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
				int instamntsno=Integer.parseInt(instamnts)+1;
				for(int j=2;j<=instamntsno;j++){
					chkno=chkno+1;
					String str1 = Integer.toString(chkno); 
					driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

					test.log(LogStatus.PASS, "Check number enterd as "+chkno);

				}
			driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				
				if(ESign_DisbType.equalsIgnoreCase("Check")){
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);
				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
					
				}
				
				//driver.findElement(By.name("finishLoan")).click();
				//test.log(LogStatus.PASS, "click on Finish Conversion Loan button ");
				
			}


			//------------------------------------------------------------------------------------------------------------		
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.
			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			//String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
			
			//String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
			//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
			//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();
		
			//test.log(LogStatus.PASS, "confirm text is : "+confirm_text1);
			
			driver.findElement(By.name("OKBut")).click();

			test.log(LogStatus.PASS, "click on Yes button ");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			if(driver.findElement(By.name("ok")).isDisplayed())
			{
				Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Conversion Loan Completed Successfully ");
				test.log(LogStatus.INFO, "**********************************************************************************");
				//driver.findElement(By.name("ok")).click();
			}
			else
			{
				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
			}
			break;
		}
	}
	
	public static void ilptotlpbyselectingilpconversion(String SSN, String AppURL) throws InterruptedException
	{
	
		//try {
			
			int lastrow = TestData.getLastRow("Conversion");
			String sheetName = "Conversion";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String DisbType = TestData.getCellData(sheetName, "DisbType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
					String VIN = TestData.getCellData(sheetName, "VIN", row);
					String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
					String Miles = TestData.getCellData(sheetName, "Miles", row);
					String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
					String TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
					String VehicleMake = TestData.getCellData(sheetName, "VehicleMake", row);
					String VehicleModel = TestData.getCellData(sheetName, "VehicleModel", row);
					String VehicleYear = TestData.getCellData(sheetName, "VehicleYear", row);
					String License_Plate_Number = TestData.getCellData(sheetName, "License_Plate_Number", row);
					String ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
					String VehicleGrade = TestData.getCellData(sheetName, "VehicleGrade", row);
					String InsuranceCoverage = TestData.getCellData(sheetName, "InsuranceCoverage", row);
					String InsuranceCompany = TestData.getCellData(sheetName, "InsuranceCompany", row);
					String PolicyNumber = TestData.getCellData(sheetName, "PolicyNumber", row);
					String InsuranceExpiryDate = TestData.getCellData(sheetName, "InsuranceExpiryDate", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
					String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
					String CardType = TestData.getCellData(sheetName, "CardType", row);
					String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
					String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
					String Expyear = TestData.getCellData(sheetName, "Expyear", row);
					String CVV = TestData.getCellData(sheetName, "CVV", row);
					String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
					
					
					
					
					
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "TLP Conversion  Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					
					test.log(LogStatus.PASS, "Click on submit Button");
					Thread.sleep(2000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					Thread.sleep(8000);

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();
					  //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();                              
					          
					  test.log(LogStatus.PASS, "Clicked on  Go button under Loans section");
					Thread.sleep(5000);
                   				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(10000);
					       //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[7]/td[1]/input")).click();
					Thread.sleep(5000);
					
					
					driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Continue Button");
					
					Thread.sleep(8000);
					 
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("vehicleType_dd"))));
					driver.findElement(By.name("vehicleType_dd")).sendKeys(VehicleType);
					test.log(LogStatus.PASS, "Vehicle Type is :" +VehicleType);
					Thread.sleep(1000);
					driver.findElement(By.name("existingVin")).sendKeys(VIN);
					test.log(LogStatus.PASS, "VIN Type is :" +VIN);
					Thread.sleep(1000);
					driver.findElement(By.name("newVinNbr")).sendKeys(NewVIN);
					test.log(LogStatus.PASS, "New VIN nbr is :" +NewVIN);
					Thread.sleep(1000);
					driver.findElement(By.name("miles")).sendKeys(Miles);
					test.log(LogStatus.PASS, "Miles entered is :" +Miles);
					Thread.sleep(1000);
					driver.findElement(By.name("bbHit_Button")).click();
					test.log(LogStatus.PASS, "Clicked on HitBlackBook Button");
					Thread.sleep(30000);
					wait.until(ExpectedConditions.elementToBeClickable(By.name("button2")));
	//==============================================================================================
					test.log(LogStatus.PASS, "getting product name ");
					Thread.sleep(1000);
					List<WebElement> rows = driver.findElements(
							By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));

					int n = rows.size();

					for (int i = 2; i <= n; i++) {

						String Pname = driver.findElement(
								By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i
										+ "]/td[2]"))
								.getText();

						test.log(LogStatus.PASS, "getting product name " + Pname);
						Thread.sleep(1000);
						if (Pname.equals(ProductType))

						{

							if (NewLoan_Term.equals("Term1"))

							{

								driver.findElement(By
										.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
												+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
								test.log(LogStatus.PASS, "Clicked on Conversion");
								Thread.sleep(10000);
								
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='titleNumber']")));
								driver.findElement(By.xpath("//*[@id='titleNumber']")).clear();
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@id='titleNumber']")).sendKeys(TitleNumber);
								test.log(LogStatus.PASS, "title number is :" +TitleNumber);
								Thread.sleep(3000);
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
								test.log(LogStatus.PASS, "Clicked on Update");
								wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.vehicleMake")));
								Thread.sleep(3000);
								//driver.findElement(By.name("requestBean.vehicleMake")).clear();
								driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
								test.log(LogStatus.PASS, "Vehicle Make is :" +VehicleMake);
								Thread.sleep(5000);
								//driver.findElement(By.name("requestBean.vehicleModel")).clear();
								driver.findElement(By.name("requestBean.vehicleModel")).sendKeys(VehicleModel);
								test.log(LogStatus.PASS, "Vehicle Model is :" +VehicleModel);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.vehicleYear")).clear();
								driver.findElement(By.name("requestBean.vehicleYear")).sendKeys(VehicleYear);
								test.log(LogStatus.PASS, "Vehicle Year is :" +VehicleYear);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.licensePltNbr")).clear();
								driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(License_Plate_Number);
								test.log(LogStatus.PASS, "License number is :" +License_Plate_Number);
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
								test.log(LogStatus.PASS, "Exterior Color is :" +ExteriorColor);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.vehicleGrade")).clear();
								driver.findElement(By.name("requestBean.vehicleGrade")).sendKeys(VehicleGrade);
								test.log(LogStatus.PASS, "Vehicle grade is :" +VehicleGrade);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.coverageType")).clear();
								driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
								test.log(LogStatus.PASS, "Insurance is :" +InsuranceCoverage);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.companyName")).clear();
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Insurance Company is :" +InsuranceCompany);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.polocyNbr")).clear();
								driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								test.log(LogStatus.PASS, "Policy Number is :" +PolicyNumber);
								Thread.sleep(1000);
								
								PhoneNbr  = TestData.getCellData(sheetName, "PhoneNbr", row);
								PhoneNbr1 = PhoneNbr.substring(0, 3);
								PhoneNbr2 = PhoneNbr.substring(3, 6);
								PhoneNbr3 = PhoneNbr.substring(6, 10);
								//driver.findElement(By.name("iPhoneNbr1")).clear();
								driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
								test.log(LogStatus.PASS, "Entereted phone number field 1 as  " + PhoneNbr1);
								Thread.sleep(1000);
								driver.findElement(By.name("iPhoneNbr2")).clear();
								driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
								test.log(LogStatus.PASS, "Entereted phone number field 2 as  " + PhoneNbr2);
								Thread.sleep(1000);
								driver.findElement(By.name("iPhoneNbr3")).clear();
								driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
								test.log(LogStatus.PASS, "Entereted phone number field 3 as  " + PhoneNbr3);
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.companyName")).clear();
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Entered Insurance company as " + InsuranceCompany);
								Thread.sleep(1000);
								InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
								InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
								InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
								InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry1")).clear();
								driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);									
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 1 as  " + InsuranceExpiryDate1);
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry2")).clear();
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 2 as  " + InsuranceExpiryDate2);
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry3")).clear();
								driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 3 as  " + InsuranceExpiryDate3);
								//driver.findElement(By.name("requestBean.polocyNbr")).clear();
								//driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								//test.log(LogStatus.PASS, "Entered policy number as " + PolicyNumber);
								Thread.sleep(6000);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
								driver.findElement(By.name("button2")).click();
								Thread.sleep(1000);
								driver.findElement(By.name("button2")).click();
								//driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).clear();
								test.log(LogStatus.PASS, "Clicked on update button ");
								Thread.sleep(5000);

								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
								driver.findElement(By.name("process")).click();

								test.log(LogStatus.PASS, "click on process Loan button ");							
								Thread.sleep(8000);
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
                                driver.findElement(By.name("qualify")).click();
                                test.log(LogStatus.PASS, "Clicked on Qualify button ");
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.tenderTypeFirst")));
                                Thread.sleep(8000);
                                driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                                String PaymentAmt = driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
    							test.log(LogStatus.PASS, "PaymentAmt is :" + PaymentAmt);
    							Thread.sleep(1000);
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(PaymentAmt);
    							test.log(LogStatus.PASS, "TenderAmt is :" + PaymentAmt);
    							Thread.sleep(5000);
    							
    							 if (ESign_CollateralType.equals("DEBIT CARD")) {
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(1000);
    	    						 //driver.findElement(By.name("cardNmbr")).sendKeys(Selectcard);
    	    						 driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys(Selectcard);

    	    							test.log(LogStatus.PASS, "Select card as : " + "Selectcard");
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(CardNbr);

    	    							test.log(LogStatus.PASS, "Card number is :" + CardNbr);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(CardType);

    	    							test.log(LogStatus.PASS, "Enterd card Type : " + CardType);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(Expmonth);

    	    							test.log(LogStatus.PASS, "Enterd Expiry month " + Expmonth);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(Expyear);
    	    							Thread.sleep(1000);
    	    							test.log(LogStatus.PASS, "Enterd Expiry year " + Expyear);

    	    							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(CVV);

    	    							test.log(LogStatus.PASS, "Enterd CVV " + CVV);

    	    							driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

    	    							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
    	    						 
    	    							/*
    	    							 * driver.findElement(By .xpath(
    	    							 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
    	    							 * )) .click();
    	    							 */
    	    							driver.findElement(
    	    									By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

    	    							test.log(LogStatus.PASS, "Clicked on add card button ");

    	    							Thread.sleep(30000);
    	    							wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.courtesyCallFlag")));
    	    							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
    	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);
    	    							Thread.sleep(8000);
    								 
    							 }
    							 else{
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(1000);
    	    					//===================== For Disb Type & Disb Amount =====================
    	    						 /*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
    	    						 test.log(LogStatus.PASS, "Disb type selected :Cash ");
    	    						 Thread.sleep(1000);
    	    						 String Disbamount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
    	    						 test.log(LogStatus.PASS, "Disb amount is : "+Disbamount);
    	    						 Thread.sleep(1000);
    	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Disbamount);
    	    						 test.log(LogStatus.PASS, "Disb amount Entered as: "+Disbamount);
    	    						 Thread.sleep(1000);*/
    	    						 driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
 	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);   
 	    							Thread.sleep(8000);
    							//=========================================================================	 
    							 }
    								    							     							 
    							 Thread.sleep(5000);
    							driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
    							test.log(LogStatus.PASS, "Pin Entered :"+PIN);
    							driver.findElement(By.name("finishLoan")).click();
    							test.log(LogStatus.PASS, "Clicked on Finish Conversion");
    							Thread.sleep(30000);
    							wait.until(ExpectedConditions.elementToBeClickable(By.name("OKBut")));
    							driver.findElement(By.name("OKBut")).click();
    							test.log(LogStatus.PASS, "Clicked on Yes");
    							Thread.sleep(1000);
    							test.log(LogStatus.PASS, "Conversion Completed Successfully");
    							driver.close();
    							
    							
    							
    							
    							
								
							}

			

					break;
				}
			}

		}
	}
		

	}
	
	
	public static void ilptotlpconversion(String SSN, String AppURL) throws InterruptedException
	{
	
		//try {
			
			int lastrow = TestData.getLastRow("Conversion");
			String sheetName = "Conversion";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String DisbType = TestData.getCellData(sheetName, "DisbType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
					String VIN = TestData.getCellData(sheetName, "VIN", row);
					String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
					String Miles = TestData.getCellData(sheetName, "Miles", row);
					String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
					String TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
					String VehicleMake = TestData.getCellData(sheetName, "VehicleMake", row);
					String VehicleModel = TestData.getCellData(sheetName, "VehicleModel", row);
					String VehicleYear = TestData.getCellData(sheetName, "VehicleYear", row);
					String License_Plate_Number = TestData.getCellData(sheetName, "License_Plate_Number", row);
					String ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
					String VehicleGrade = TestData.getCellData(sheetName, "VehicleGrade", row);
					String InsuranceCoverage = TestData.getCellData(sheetName, "InsuranceCoverage", row);
					String InsuranceCompany = TestData.getCellData(sheetName, "InsuranceCompany", row);
					String PolicyNumber = TestData.getCellData(sheetName, "PolicyNumber", row);
					String InsuranceExpiryDate = TestData.getCellData(sheetName, "InsuranceExpiryDate", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
					String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
					String CardType = TestData.getCellData(sheetName, "CardType", row);
					String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
					String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
					String Expyear = TestData.getCellData(sheetName, "Expyear", row);
					String CVV = TestData.getCellData(sheetName, "CVV", row);
					String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
					
					
					
					
					
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "TLP Conversion  Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					
					test.log(LogStatus.PASS, "Click on submit Button");
					Thread.sleep(2000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					Thread.sleep(8000);

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();
					  //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[7]/td[13]/input")).click();                              
					                               
					  test.log(LogStatus.PASS, "Clicked on  Go button under Loans section");
					Thread.sleep(5000);
                   				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(10000);
					       //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[7]/td[1]/input")).click();
					Thread.sleep(5000);
					
					
					driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Continue Button");
					
					Thread.sleep(8000);
					 
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("vehicleType_dd"))));
					driver.findElement(By.name("vehicleType_dd")).sendKeys(VehicleType);
					test.log(LogStatus.PASS, "Vehicle Type is :" +VehicleType);
					Thread.sleep(1000);
					driver.findElement(By.name("existingVin")).sendKeys(VIN);
					test.log(LogStatus.PASS, "VIN Type is :" +VIN);
					Thread.sleep(1000);
					driver.findElement(By.name("newVinNbr")).sendKeys(NewVIN);
					test.log(LogStatus.PASS, "New VIN nbr is :" +NewVIN);
					Thread.sleep(1000);
					driver.findElement(By.name("miles")).sendKeys(Miles);
					test.log(LogStatus.PASS, "Miles entered is :" +Miles);
					Thread.sleep(1000);
					driver.findElement(By.name("bbHit_Button")).click();
					test.log(LogStatus.PASS, "Clicked on HitBlackBook Button");
					Thread.sleep(30000);
					//wait.until(ExpectedConditions.elementToBeClickable(By.name("button2")));
	//==============================================================================================
					driver.findElement(By.name("requestBean.collateralType")).sendKeys(ESign_CollateralType);
					//driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
					test.log(LogStatus.PASS, "Colatetal Type is Selected As :"+ESign_CollateralType);
					Thread.sleep(15000);
					test.log(LogStatus.PASS, "getting product name ");
					Thread.sleep(1000);
					List<WebElement> rows = driver.findElements(
							By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr"));

					int n = rows.size();

					for (int i = 2; i <= n; i++) {

						String Pname = driver.findElement(
								By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr[" + i
										+ "]/td[2]"))
								.getText();

						test.log(LogStatus.PASS, "getting product name " + Pname);
						Thread.sleep(1000);
						if (Pname.equals(ProductType))

						{

							if (NewLoan_Term.equals("Term1"))

							{
                                Thread.sleep(500);
								
								/*driver.findElement(By.name("requestBean.collateralType")).sendKeys(ESign_CollateralType);
								//driver.findElement(By.name("advanceRequestBean.paymentCollateralType")).sendKeys(ESign_CollateralType);
								test.log(LogStatus.PASS, "Colatetal Type is Selected As :"+ESign_CollateralType);
								Thread.sleep(15000);*/

								driver.findElement(By
										.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["
												+ i + "]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();

								test.log(LogStatus.PASS, "Selected check box as " + NewLoan_Term);
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@id='LoanButtonId']")).click();
								test.log(LogStatus.PASS, "Clicked on Conversion");
								Thread.sleep(10000);
								
								wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='titleNumber']")));
								driver.findElement(By.xpath("//*[@id='titleNumber']")).clear();
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@id='titleNumber']")).sendKeys(TitleNumber);
								test.log(LogStatus.PASS, "title number is :" +TitleNumber);
								Thread.sleep(3000);
								driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table[2]/tbody/tr[4]/td/input")).click();
								test.log(LogStatus.PASS, "Clicked on Update");
								wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.vehicleMake")));
								Thread.sleep(3000);
								//driver.findElement(By.name("requestBean.vehicleMake")).clear();
								driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
								test.log(LogStatus.PASS, "Vehicle Make is :" +VehicleMake);
								Thread.sleep(5000);
								//driver.findElement(By.name("requestBean.vehicleModel")).clear();
								driver.findElement(By.name("requestBean.vehicleModel")).sendKeys(VehicleModel);
								test.log(LogStatus.PASS, "Vehicle Model is :" +VehicleModel);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.vehicleYear")).clear();
								driver.findElement(By.name("requestBean.vehicleYear")).sendKeys(VehicleYear);
								test.log(LogStatus.PASS, "Vehicle Year is :" +VehicleYear);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.licensePltNbr")).clear();
								driver.findElement(By.name("requestBean.licensePltNbr")).sendKeys(License_Plate_Number);
								test.log(LogStatus.PASS, "License number is :" +License_Plate_Number);
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.extClr")).sendKeys(ExteriorColor);
								test.log(LogStatus.PASS, "Exterior Color is :" +ExteriorColor);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.vehicleGrade")).clear();
								driver.findElement(By.name("requestBean.vehicleGrade")).sendKeys(VehicleGrade);
								test.log(LogStatus.PASS, "Vehicle grade is :" +VehicleGrade);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.coverageType")).clear();
								driver.findElement(By.name("requestBean.coverageType")).sendKeys(InsuranceCoverage);
								test.log(LogStatus.PASS, "Insurance is :" +InsuranceCoverage);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.companyName")).clear();
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Insurance Company is :" +InsuranceCompany);
								Thread.sleep(1000);
								//driver.findElement(By.name("requestBean.polocyNbr")).clear();
								driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								test.log(LogStatus.PASS, "Policy Number is :" +PolicyNumber);
								Thread.sleep(1000);
								
								PhoneNbr  = TestData.getCellData(sheetName, "PhoneNbr", row);
								PhoneNbr1 = PhoneNbr.substring(0, 3);
								PhoneNbr2 = PhoneNbr.substring(3, 6);
								PhoneNbr3 = PhoneNbr.substring(6, 10);
								//driver.findElement(By.name("iPhoneNbr1")).clear();
								driver.findElement(By.name("iPhoneNbr1")).sendKeys(PhoneNbr1);
								test.log(LogStatus.PASS, "Entereted phone number field 1 as  " + PhoneNbr1);
								Thread.sleep(1000);
								driver.findElement(By.name("iPhoneNbr2")).clear();
								driver.findElement(By.name("iPhoneNbr2")).sendKeys(PhoneNbr2);
								test.log(LogStatus.PASS, "Entereted phone number field 2 as  " + PhoneNbr2);
								Thread.sleep(1000);
								driver.findElement(By.name("iPhoneNbr3")).clear();
								driver.findElement(By.name("iPhoneNbr3")).sendKeys(PhoneNbr3);
								test.log(LogStatus.PASS, "Entereted phone number field 3 as  " + PhoneNbr3);
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.companyName")).clear();
								Thread.sleep(1000);
								driver.findElement(By.name("requestBean.companyName")).sendKeys(InsuranceCompany);
								test.log(LogStatus.PASS, "Entered Insurance company as " + InsuranceCompany);
								Thread.sleep(1000);
								InsuranceExpiryDate0 = InsuranceExpiryDate.split("/");
								InsuranceExpiryDate1 = InsuranceExpiryDate0[0];
								InsuranceExpiryDate2 = InsuranceExpiryDate0[1];
								InsuranceExpiryDate3 = InsuranceExpiryDate0[2];
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry1")).clear();
								driver.findElement(By.name("iexpiry1")).sendKeys(InsuranceExpiryDate1);									
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 1 as  " + InsuranceExpiryDate1);
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry2")).clear();
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry2")).sendKeys(InsuranceExpiryDate2);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 2 as  " + InsuranceExpiryDate2);
								Thread.sleep(1000);
								driver.findElement(By.name("iexpiry3")).clear();
								driver.findElement(By.name("iexpiry3")).sendKeys(InsuranceExpiryDate3);
								
								test.log(LogStatus.PASS, "Entereted Insurance expiry date field 3 as  " + InsuranceExpiryDate3);
								driver.findElement(By.name("requestBean.vehicleMake")).sendKeys(VehicleMake);
								//driver.findElement(By.name("requestBean.polocyNbr")).clear();
								//driver.findElement(By.name("requestBean.polocyNbr")).sendKeys(PolicyNumber);
								//test.log(LogStatus.PASS, "Entered policy number as " + PolicyNumber);
								Thread.sleep(6000);
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("button2")));
								driver.findElement(By.name("button2")).click();
								Thread.sleep(1000);
								driver.findElement(By.name("button2")).click();
								//driver.findElement(By.xpath("//*[@id='vehicleInformation']/td/table/tbody/tr[10]/td/input")).clear();
								test.log(LogStatus.PASS, "Clicked on update button ");
								Thread.sleep(5000);

								wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("process")));
								driver.findElement(By.name("process")).click();

								test.log(LogStatus.PASS, "click on process Loan button ");							
								Thread.sleep(10000);
								try{							
                					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
                					//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();					                             
                					driver.findElement(By.xpath("//input[@value='Yes' and @type='submit']")).click();
                					test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
                				}
                				catch(Exception e){
                					//normal flow
                				}
								Thread.sleep(5000);
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("qualify")));
                                driver.findElement(By.name("qualify")).click();
                                test.log(LogStatus.PASS, "Clicked on Qualify button ");
                                wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.tenderTypeFirst")));
                                                               
                                driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys(TenderType);
                                String PaymentAmt = driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
    							test.log(LogStatus.PASS, "PaymentAmt is :" + PaymentAmt);
    							Thread.sleep(1000);
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
    							driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(PaymentAmt);
    							test.log(LogStatus.PASS, "TenderAmt is :" + PaymentAmt);
    							Thread.sleep(5000);
    							
    							 if (ESign_CollateralType.equals("DEBIT CARD")) {
    								 driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(1000);
    	    						 //driver.findElement(By.name("cardNmbr")).sendKeys(Selectcard);
    	    						 driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys(Selectcard);

    	    							test.log(LogStatus.PASS, "Select card as : " + "Selectcard");
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(CardNbr);

    	    							test.log(LogStatus.PASS, "Card number is :" + CardNbr);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='cardType']/select")).sendKeys(CardType);

    	    							test.log(LogStatus.PASS, "Enterd card Type : " + CardType);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(Expmonth);

    	    							test.log(LogStatus.PASS, "Enterd Expiry month " + Expmonth);
    	    							Thread.sleep(1000);
    	    							driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(Expyear);
    	    							Thread.sleep(1000);
    	    							test.log(LogStatus.PASS, "Enterd Expiry year " + Expyear);

    	    							driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(CVV);

    	    							test.log(LogStatus.PASS, "Enterd CVV " + CVV);

    	    							driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

    	    							test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);
    	    						 
    	    							/*
    	    							 * driver.findElement(By .xpath(
    	    							 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
    	    							 * )) .click();
    	    							 */
    	    							driver.findElement(
    	    									By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

    	    							test.log(LogStatus.PASS, "Clicked on add card button ");

    	    							Thread.sleep(30000);
    	    							wait.until(ExpectedConditions.elementToBeClickable(By.name("requestBean.siilBean.courtesyCallFlag")));
    	    							driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
    	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);
    	    							Thread.sleep(8000);
    								 
    							 }
    							 else{
    								 //driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
    	    						 //test.log(LogStatus.PASS, "collateralType is :" + ESign_CollateralType);
    	    						 Thread.sleep(1000);
    	    					//===================== For Disb Type & Disb Amount =====================
    	    						 /*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
    	    						 test.log(LogStatus.PASS, "Disb type selected :Cash ");
    	    						 Thread.sleep(1000);
    	    						 String Disbamount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
    	    						 test.log(LogStatus.PASS, "Disb amount is : "+Disbamount);
    	    						 Thread.sleep(1000);
    	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Disbamount);
    	    						 test.log(LogStatus.PASS, "Disb amount Entered as: "+Disbamount);
    	    						 Thread.sleep(1000);*/
    	    						 driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
 	    							test.log(LogStatus.PASS, "Courtesy call selected : "+ESign_CourtesyCallConsent);   
 	    							Thread.sleep(8000);
    							//=========================================================================	 
    							 }
    								    							     							 
    							 Thread.sleep(5000);
    							driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
    							test.log(LogStatus.PASS, "Pin Entered :"+PIN);
    							
    							try {
    							 driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys("Cash");
	    						 test.log(LogStatus.PASS, "Disb type selected :Cash ");
	    						 Thread.sleep(1000);
	    						 String Disbamount=driver.findElement(By.id("refinanceLoanAmt")).getAttribute("value");
	    						 test.log(LogStatus.PASS, "Disb amount is : "+Disbamount);
	    						 Thread.sleep(1000);
	    						 driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(Disbamount);
	    						 test.log(LogStatus.PASS, "Disb amount Entered as: "+Disbamount);
	    						 Thread.sleep(1000);
	    						 driver.findElement(By.name("finishLoan")).click();
	    						 test.log(LogStatus.PASS, "Clicked on Finish Conversion");
    							}
    							catch (Exception e) {
    								driver.findElement(By.name("finishLoan")).click();
        							test.log(LogStatus.PASS, "Clicked on Finish Conversion");
    							}
    							
    							
    							
    							Thread.sleep(25000);
    							
    							wait.until(ExpectedConditions.elementToBeClickable(By.name("OKBut")));
    							driver.findElement(By.name("OKBut")).click();
    							test.log(LogStatus.PASS, "Clicked on Yes");
    							Thread.sleep(1000);
    							test.log(LogStatus.PASS, "Conversion Completed Successfully");
    							test.log(LogStatus.PASS, "Logout from CSR Successfully");
    							
    							test.log(LogStatus.INFO, "******************************************************** ");
    							driver.close();
    							
    							
    							
    							
    							
								
							}

			

					break;
				}
			}

		}
	}
		

	}
	

	
	public static void pdlloanconversion(String SSN, String AppURL) throws InterruptedException
	{
	
		//try {
			
			int lastrow = TestData.getLastRow("Conversion");
			String sheetName = "Conversion";

			for (int row = 2; row <= lastrow; row++) {

				
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String UserName = TestData.getCellData(sheetName, "UserName", row);
					String Password = TestData.getCellData(sheetName, "Password", row);
					String PIN = TestData.getCellData(sheetName, "PIN", row);
					
					String StateID = TestData.getCellData(sheetName, "StateID", row);
					String ProductID = TestData.getCellData(sheetName, "ProductID", row);
					String ProductType = TestData.getCellData(sheetName, "ProductType", row);
					String TxnType = TestData.getCellData(sheetName, "TxnType", row);
					String DisbType = TestData.getCellData(sheetName, "DisbType", row);
					String TenderType = TestData.getCellData(sheetName, "TenderType", row);
					String VehicleType = TestData.getCellData(sheetName, "VehicleType", row);
					String VIN = TestData.getCellData(sheetName, "VIN", row);
					String NewVIN = TestData.getCellData(sheetName, "NewVIN", row);
					String Miles = TestData.getCellData(sheetName, "Miles", row);
					String NewLoan_Term = TestData.getCellData(sheetName, "NewLoan_Term", row);
					String TitleNumber = TestData.getCellData(sheetName, "TitleNumber", row);
					String VehicleMake = TestData.getCellData(sheetName, "VehicleMake", row);
					String VehicleModel = TestData.getCellData(sheetName, "VehicleModel", row);
					String VehicleYear = TestData.getCellData(sheetName, "VehicleYear", row);
					String License_Plate_Number = TestData.getCellData(sheetName, "License_Plate_Number", row);
					String ExteriorColor = TestData.getCellData(sheetName, "ExteriorColor", row);
					String VehicleGrade = TestData.getCellData(sheetName, "VehicleGrade", row);
					String InsuranceCoverage = TestData.getCellData(sheetName, "InsuranceCoverage", row);
					String InsuranceCompany = TestData.getCellData(sheetName, "InsuranceCompany", row);
					String PolicyNumber = TestData.getCellData(sheetName, "PolicyNumber", row);
					String InsuranceExpiryDate = TestData.getCellData(sheetName, "InsuranceExpiryDate", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					String ESign_CourtesyCallConsent = TestData.getCellData(sheetName, "ESign_CourtesyCallConsent", row);
					String Selectcard = TestData.getCellData(sheetName, "Selectcard", row);
					String CardType = TestData.getCellData(sheetName, "CardType", row);
					String CardNbr = TestData.getCellData(sheetName, "CardNbr", row);
					String Expmonth = TestData.getCellData(sheetName, "Expmonth", row);
					String Expyear = TestData.getCellData(sheetName, "Expyear", row);
					String CVV = TestData.getCellData(sheetName, "CVV", row);
					String CardHolderName = TestData.getCellData(sheetName, "CardHolderName", row);
					
					
					
					
					
					
					DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3, 5);
					String SSN3 = SSN.substring(5, 9);

					Thread.sleep(4000);
					
					test.log(LogStatus.INFO, "TLP Conversion  Started");
					driver.switchTo().defaultContent();

					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
					driver.switchTo().frame("topFrame");
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
					Thread.sleep(4000);
					driver.findElement(By.cssSelector("li[id='910000']")).click();

					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					Thread.sleep(4000);

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transactions");
					driver.switchTo().frame("main");
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
					driver.findElement(By.name("ssn2")).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
					driver.findElement(By.name("ssn3")).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
					driver.findElement(By.name("submit1")).click();
					test.log(LogStatus.PASS, "Click on submit Button");
					Thread.sleep(4000);
					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					Thread.sleep(4000);
					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button under search results");
					Thread.sleep(8000);

					for (String winHandle : driver.getWindowHandles()) {
						driver.switchTo().window(winHandle);
					}
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					
					//driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					test.log(LogStatus.PASS, "Clicked on PDL Loan Go button under Loans section");
					Thread.sleep(5000);
                   				
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" + TxnType);
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id='go_Button']")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(10000);
					       //driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[7]/td[1]/input")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//input[@value='Continue' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on Continue Button");
					
					Thread.sleep(8000);
					
					 
					
	//==============================================================================================
					if(driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).isDisplayed());
					{
					String LoanEligibility_text=driver.findElement(By.xpath("//*[@id='errMsg']/ul/li")).getText();
					
					
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Eligibility message displayed as :  " +LoanEligibility_text);
					
				
					
						
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					 driver.switchTo().frame("topFrame");
				     System.out.println("Enterd into top frame");
				     driver.findElement(locator(prop.getProperty(("csr_logout_link")))).click();
			     test.log(LogStatus.PASS, "Clicked On logout Button");
			     System.out.println("clicked on logout");
					//driver.close();
					
					try { 
						Alert alert = driver.switchTo().alert();
						alert.dismiss();
						Thread.sleep(800);
						driver.close();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					
					//break;
			

		}
					
				break;		
				}
				else{
					test.log(LogStatus.FAIL, "In Loan Decissioning Screen Deny Option is not displaying ");
					break;
				}
	}
		

	}

	
	
	public static void PDL_ILP() throws InterruptedException {
		test.log(LogStatus.PASS, "getting product name ");
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 
		int n=rows.size();
		for(int i=2;i<=n;i++){
			String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			test.log(LogStatus.PASS, "getting product name "+Pname);

			if(Pname.equals(ProductType))
			{
				if(NewLoan_Term.equals("Term1"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
				else if(NewLoan_Term.equals("Term2"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
			}
			else{
				continue;
			}
			if(driver.findElement(By.id("LoanButtonId")).isEnabled())
		 	{
			
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Condition Satisfied :allow the customer to consolidate the Loan  ");	
			  

		 	}
			else
			{
			test.log(LogStatus.FAIL, "Condition is not satisfied ");
			

			}
			driver.findElement(By.id("LoanButtonId")).click();
			test.log(LogStatus.PASS, "Clicked on Conversion button ");
            Thread.sleep(8000);
			
			try{							
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();					                             
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				
			}
			catch(Exception e){
				//normal flow
			}
			Thread.sleep(3000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			driver.findElement(By.name("qualify")).click();
			test.log(LogStatus.PASS, "Clicked on Qualify");
			Thread.sleep(15000);
			
			
			
			/*String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
			test.log(LogStatus.PASS, "getting request loan amount "+paymentamount);*/
			//--------------------------------------------------------------------------------------------------------------	

			if(ESign_CollateralType.equalsIgnoreCase("ACH")){
				Thread.sleep(1000);
				/*driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on Qualify");
				Thread.sleep(20000);*/
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
				test.log(LogStatus.PASS, "Select Tender Type as Cash");
				Thread.sleep(1000);
				String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "getting request loan amount "+paymentamount);
				
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
				test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
				Thread.sleep(500);
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				Thread.sleep(500);
				
		//Some times Disb Type and Disb amount is missing in screen
				
		//=====================================================================
				/*String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
				test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
				Thread.sleep(500);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);		
				Thread.sleep(500);
				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
				Thread.sleep(1000);*/
	 //=============================================================================	
				
				if(ESign_DisbType.equalsIgnoreCase("Cash")){
					
		// ============== For Disb Amount(Some times it is missing from screen)==============
					Thread.sleep(500);
					
					/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);*/
					
					
			//====================================================================
					/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					
			// For Disb Amount(Some times it is missing from screen)
					
					
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on Qualify");
					Thread.sleep(20000);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select Tender Type as Cash");
					Thread.sleep(1000);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
					test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
					Thread.sleep(8000);*/
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.

								} catch (Exception e) {

							}

								break;
							}

						}
				}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);								
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
					
				}
				
				
			}

			//--------------------------------------------------------------------------------------------------------

			if(ESign_CollateralType.equalsIgnoreCase("Debit Card")){


				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);



					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	
					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();
									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}


						}
	}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	

					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");

								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();
									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {

								}
								break;
							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);
				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();			
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
					
				}
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
			}
			//-----------------------------------------------------------------------------------------------------------------------------------	
			if(ESign_CollateralType.equalsIgnoreCase("Check")){
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")||ESign_DisbType.equalsIgnoreCase("check")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						
					{
						Thread.sleep(800);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					else{
						test.log(LogStatus.PASS, "Esign preference selected as NO ");
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

								} catch (Exception e) {
								}
								break;
							}
					}
					}
					else
					{
						test.log(LogStatus.PASS, "Allow promotions not selected");
					}
				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				test.log(LogStatus.INFO, "Performing  check transactions");
				int chkno=987654;

				String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
				int instamntsno=Integer.parseInt(instamnts)+1;
				for(int j=2;j<=instamntsno;j++){
					chkno=chkno+1;
					String str1 = Integer.toString(chkno); 
					driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

					test.log(LogStatus.PASS, "Check number enterd as "+chkno);

				}
			driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				
				if(ESign_DisbType.equalsIgnoreCase("Check")){
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				
		//======================
				Thread.sleep(500);
				try {
				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
				test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
				
				Thread.sleep(1000);
				String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
				test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
				Thread.sleep(1000);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
				test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
				Thread.sleep(1000);
				}
		//=======================
				catch (Exception e) {
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Conversion Loan button ");
				}
				
			}


			//------------------------------------------------------------------------------------------------------------		
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.
			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			//String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
			
			//String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
			//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
			//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();
		
			//test.log(LogStatus.PASS, "confirm text is : "+confirm_text1);
			
			driver.findElement(By.name("OKBut")).click();

			test.log(LogStatus.PASS, "click on Yes button ");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			if(driver.findElement(By.name("ok")).isDisplayed())
			{
				Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> ILP Conversion Loan Completed Successfully ");
				test.log(LogStatus.INFO, "**********************************************************************************");
				//driver.findElement(By.name("ok")).click();
			}
			else
			{
				test.log(LogStatus.FAIL, "Conversion Loan is not Completed Successfully ");
			}
			break;
		}
	}	
	
	public static void ILP() throws InterruptedException {
		test.log(LogStatus.PASS, "getting product name ");
		List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr")); 
		int n=rows.size();
		for(int i=2;i<=n;i++){
			String Pname=driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[2]")).getText();
			test.log(LogStatus.PASS, "getting product name "+Pname);

			if(Pname.equals(ProductType))
			{
				if(NewLoan_Term.equals("Term1"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[5]/table/tbody/tr/td[2]/table[1]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
				else if(NewLoan_Term.equals("Term2"))
				{
					driver.findElement(By.xpath("//*[@id='riskViewBdy']/table[3]/tbody/tr[1]/td/table/tbody/tr[3]/td/table/tbody/tr["+rnum+"]/td[5]/table/tbody/tr/td[2]/table[2]/tbody/tr[1]/td/b/input")).click();
					test.log(LogStatus.PASS, "Selected check box as "+NewLoan_Term);
				}
			}
			else{
				continue;
			}
			if(driver.findElement(By.id("LoanButtonId")).isEnabled())
		 	{
			
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Condition Satisfied :allow the customer to consolidate both ILP & PDL loans to ILP Loan  ");	
			  

		 	}
			else
			{
			test.log(LogStatus.FAIL, "Condition is not satisfied ");
			

			}
			driver.findElement(By.id("LoanButtonId")).click();
			test.log(LogStatus.PASS, "Clicked on Conversion button ");
			Thread.sleep(8000);
			
			try{							
				//driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[2]")).click();
				driver.findElement(By.xpath("//*[@id='documentForm']/table/tbody/tr[4]/td/input[1]")).click();					                             
				test.log(LogStatus.PASS, "Clicked Yes on cashOut popup");
				
			}
			catch(Exception e){
				//normal flow
			}
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			driver.findElement(By.name("qualify")).click();
			test.log(LogStatus.PASS, "Clicked on Qualify");
			Thread.sleep(15000);
			
			
			
			/*String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
			test.log(LogStatus.PASS, "getting request loan amount "+paymentamount);*/
			//--------------------------------------------------------------------------------------------------------------	

			if(ESign_CollateralType.equalsIgnoreCase("ACH")){
				Thread.sleep(1000);
				/*driver.findElement(By.name("qualify")).click();
				test.log(LogStatus.PASS, "Clicked on Qualify");
				Thread.sleep(20000);*/
				
				driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
				test.log(LogStatus.PASS, "Select Tender Type as Cash");
				Thread.sleep(1000);
				String paymentamount=driver.findElement(By.name("requestBean.siilBean.paymentAmt")).getAttribute("value");
				test.log(LogStatus.PASS, "getting request loan amount "+paymentamount);
				
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
				test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
				Thread.sleep(1000);
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);
				Thread.sleep(1000);
	
				
				if(ESign_DisbType.equalsIgnoreCase("Cash")){
					//Thread.sleep(1000);


					/*driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(1000);
					
			// For Disb Amount(Some times it is missing from screen)
					
					
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					driver.findElement(By.name("qualify")).click();
					test.log(LogStatus.PASS, "Clicked on Qualify");
					Thread.sleep(20000);
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Select Tender Type as Cash");
					Thread.sleep(1000);
					
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).clear();
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(paymentamount);
					test.log(LogStatus.PASS, "tender amount entered as "+paymentamount);
					Thread.sleep(8000);*/
					Thread.sleep(1000);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.

								} catch (Exception e) {

							}

								break;
							}

						}
				}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				//driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				Thread.sleep(800);
				try {
					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);
					Thread.sleep(800);
					String disbamount=driver.findElement(By.xpath("//*[@id='refinanceLoanAmt']")).getAttribute("value");
					test.log(LogStatus.PASS, "getting disb amount as "+disbamount);
					Thread.sleep(800);
					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(disbamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+disbamount);
					Thread.sleep(800);

				}
				catch (Exception e) {
					driver.findElement(By.name("finishLoan")).click();					
					test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
				}
				
				
				
			}

			//--------------------------------------------------------------------------------------------------------

			if(ESign_CollateralType.equalsIgnoreCase("Debit Card")){


				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);



					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);
					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	
					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					if (AllowPromotion.equals("Yes")) {


						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);


						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();
									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {


								}

								break;

							}


						}
	}

				}

				else if(ESign_DisbType.equalsIgnoreCase("Check")){

					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");
					test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

					driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);
					test.log(LogStatus.PASS, "Card number is :" + cardNumber);

					driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);
					test.log(LogStatus.PASS, "Enterd card Type  : " + cardType);

					driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);
					test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);
					test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

					driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);
					test.log(LogStatus.PASS, "Enterd CVV " + cvv);
					driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);
					test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

					driver.findElement(By.xpath("//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]")).click();
					test.log(LogStatus.PASS, "Clicked on add card button ");	

					Thread.sleep(30000);
					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						Thread.sleep(800);
					{
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");

								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();

									alert.accept();
									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

									// if alert present, accept and move on.


								} catch (Exception e) {

								}
								break;
							}
						}

					}
					driver.switchTo().defaultContent();

					driver.switchTo().frame("mainFrame");

					driver.switchTo().frame("main");
					driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
					test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

					driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
					test.log(LogStatus.PASS, "check box selected ");

					driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Enterd amount is "+relamount);

				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Conversion  Loan button ");
			}
			//-----------------------------------------------------------------------------------------------------------------------------------	
			if(ESign_CollateralType.equalsIgnoreCase("Check")){
				driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);
				test.log(LogStatus.PASS, "Collateral Type is enterted as "+ESign_CollateralType);

				if(ESign_DisbType.equalsIgnoreCase("Cash")||ESign_DisbType.equalsIgnoreCase("check")){


					driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);
					test.log(LogStatus.PASS, "Disb Type is enterted as "+ESign_DisbType);

					driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);
					test.log(LogStatus.PASS, "Disb Amt is enterted as "+relamount);

					driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);
					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_CourtesyCallConsent);
					Thread.sleep(8000);
					if(ESign_CourtesyCallConsent.equals("Yes"))
						
					{
						Thread.sleep(800);
						if(ESign_Preference.equals("Call"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("Mail"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);
						}
						else if(ESign_Preference.equals("SMS"))
						{
							driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();
							test.log(LogStatus.PASS, "Courtesy Call Consent is selected as "+ESign_Preference);

							try {
								Alert alert = driver.switchTo().alert();
								alert.dismiss();
								//if alert present, accept and move on.

							}
							catch (NoAlertPresentException e) {
								//do what you normally would if you didn't have the alert.
							}
						}

					}
					else{
						test.log(LogStatus.PASS, "Esign preference selected as NO ");
					}
					if (AllowPromotion.equals("Yes")) {

						String main_window = driver.getWindowHandle();

						driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);

						test.log(LogStatus.PASS, "Promotion button is clicked ");

						Thread.sleep(10000);

						for (String winHandle1 : driver.getWindowHandles()) {

							if (!main_window.equalsIgnoreCase(winHandle1)) {

								Thread.sleep(5000);

								driver.switchTo().window(winHandle1);

								Thread.sleep(5000);

								driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();

								test.log(LogStatus.PASS, "Promotion radio button is selected ");

								driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();

								test.log(LogStatus.PASS, "OK button is clicked ");


								driver.switchTo().window(main_window);

								try {

									Alert alert = driver.switchTo().alert();

									String almsg = alert.getText();


									alert.accept();

									test.log(LogStatus.PASS, "Alert handled " + almsg);

									test.log(LogStatus.PASS, "Alert accepted");

									Thread.sleep(5000);

									driver.switchTo().window(main_window);

									driver.switchTo().defaultContent();

									driver.switchTo().frame("mainFrame");

									driver.switchTo().frame("main");

								} catch (Exception e) {
								}
								break;
							}
					}
					}
					else
					{
						test.log(LogStatus.PASS, "Allow promotions not selected");
					}
				}
				driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				test.log(LogStatus.INFO, "Performing  check transactions");
				int chkno=987654;

				String instamnts=driver.findElement(By.name("requestBean.siilBean.nbrOfInst")).getAttribute("value");
				int instamntsno=Integer.parseInt(instamnts)+1;
				for(int j=2;j<=instamntsno;j++){
					chkno=chkno+1;
					String str1 = Integer.toString(chkno); 
					driver.findElement(By.xpath("//*[@id='checkNbrs"+(j-2)+"']")).sendKeys(str1);

					test.log(LogStatus.PASS, "Check number enterd as "+chkno);

				}
			driver.switchTo().defaultContent();

				driver.switchTo().frame("mainFrame");

				driver.switchTo().frame("main");
				
				if(ESign_DisbType.equalsIgnoreCase("Check")){
				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);
				test.log(LogStatus.PASS, "Number of checks selected as "+No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();
				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);
				test.log(LogStatus.PASS, "Enterd amount is "+relamount);
				}
				driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);
				test.log(LogStatus.PASS, "ESign_Checks is selected as "+ESign_Password);
				
				driver.findElement(By.name("finishLoan")).click();
				test.log(LogStatus.PASS, "click on Finish Conversion Loan button ");
				
			}


			//------------------------------------------------------------------------------------------------------------		
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//if alert present, accept and move on.
			}
			catch (NoAlertPresentException e) {
				//do what you normally would if you didn't have the alert.
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			
			String confirm_text1=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[1]")).getText();
			
			//String confirm_text2=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[2]")).getText();
			//String confirm_text3=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[2]/td[1]/b[3]")).getText();
			//String confirm_text4=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[3]/td/b")).getText();
		
			test.log(LogStatus.PASS, "confirm text is : "+confirm_text1);
			
			driver.findElement(By.name("OKBut")).click();

			test.log(LogStatus.PASS, "click on Yes button ");

			driver.switchTo().defaultContent();
			driver.switchTo().frame("mainFrame");
			driver.switchTo().frame("main");
			if(driver.findElement(By.name("ok")).isDisplayed())
			{
				Thread.sleep(5000);
				driver.findElement(By.name("ok")).click();
				
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> ILP Conversion Loan Completed Successfully ");
				test.log(LogStatus.INFO, "**********************************************************************************");
				//driver.findElement(By.name("ok")).click();
			}
			else
			{
				test.log(LogStatus.FAIL, "New Loan is not Completed Successfully ");
			}
			break;
		}
	}

	public static void ILP_ACH_Collateral() throws InterruptedException

	{

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{

				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

						// if alert present, accept and move on.

					}

					catch (NoAlertPresentException e) {

						// do what you normally would if you didn't have
						// the alert.

					}

				}

			}

			if (AllowPromotion.equals("Yes"))

			{

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}

			}
		}

			else if (ESign_DisbType.equalsIgnoreCase("Check")) {

				driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

				test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

				driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

				test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);
				driver.findElement(By.name("vehicleKey")).sendKeys("NO");

				test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
				Thread.sleep(2000);

				driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag"))
						.sendKeys(ESign_CourtesyCallConsent);

				test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

				if (ESign_CourtesyCallConsent.equals("Yes"))

				{

					if (ESign_Preference.equals("Call"))

					{

						driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					}

					if (ESign_Preference.equals("Mail"))

					{

						driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					}

					if (ESign_Preference.equals("SMS"))

					{

						driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

						test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					}

				}

				if (AllowPromotion.equals("Yes"))

				{

					String main_window = driver.getWindowHandle();
					driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
					test.log(LogStatus.PASS, "Promotion button is clicked ");
					Thread.sleep(10000);

					for (String winHandle1 : driver.getWindowHandles()) {
						if (!main_window.equalsIgnoreCase(winHandle1)) {
							Thread.sleep(5000);
							driver.switchTo().window(winHandle1);
							Thread.sleep(5000);
							driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
							test.log(LogStatus.PASS, "Promotion radio button is selected ");
							driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();
							test.log(LogStatus.PASS, "OK button is clicked ");

							driver.switchTo().window(main_window);
							try {
								Alert alert = driver.switchTo().alert();
								String almsg = alert.getText();

								alert.accept();
								test.log(LogStatus.PASS, "Alert handled " + almsg);
								test.log(LogStatus.PASS, "Alert accepted");
								Thread.sleep(5000);
								driver.switchTo().window(main_window);
								driver.switchTo().defaultContent();
								driver.switchTo().frame("mainFrame");
								driver.switchTo().frame("main");
								// if alert present, accept and move on.

							} catch (Exception e) {

							}
							break;
						}

					}

				}

				driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

				test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

				test.log(LogStatus.PASS, "Enterd amount is " + relamount);

			

			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

			// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[10]/td/input")).sendKeys(ESign_Password);

			test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

			driver.findElement(By.name("finishLoan")).click();

			// driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr[12]/td/table/tbody/tr[1]/td[5]/input")).click();

			test.log(LogStatus.PASS, "click on Finish Conversion Loan button ");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				// if alert present, accept and move on.

			} catch (NoAlertPresentException e) {
				// do what you normally would if you didn't have the alert.
			}
		}
	
	}
	

	public static void ILP_DEBITCARD_Collateral() throws InterruptedException {

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");
			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

			test.log(LogStatus.PASS, "Card number is :" + cardNumber);

			driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

			test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

			driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

			test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

			test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

			test.log(LogStatus.PASS, "Enterd CVV " + cvv);

			driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

			test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

			/*
			 * driver.findElement(By .xpath(
			 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
			 * )) .click();
			 */
			driver.findElement(
					By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

			test.log(LogStatus.PASS, "Clicked on add card button ");

			Thread.sleep(30000);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{

				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

						// if alert present, accept and move on.

					}

					catch (NoAlertPresentException e) {

						// do what you normally would if you didn't have
						// the alert.

					}

				}

			}

			if (AllowPromotion.equals("Yes"))

			{
				String main_window = driver.getWindowHandle();
				driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}

			}

		}

		else if (ESign_DisbType.equalsIgnoreCase("Check")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");

			driver.findElement(By.xpath("//*[@id='cardsList']/select")).sendKeys("NEW CARD");

			test.log(LogStatus.PASS, "Select card as : " + "NEW CARD");

			driver.findElement(By.xpath("//*[@id='ccnumber']")).sendKeys(cardNumber);

			test.log(LogStatus.PASS, "Card number is :" + cardNumber);

			driver.findElement(By.xpath("//*[@id='cardType2']/select")).sendKeys(cardType);

			test.log(LogStatus.PASS, "Enterd card Type : " + cardType);

			driver.findElement(By.xpath("//*[@id='expmonth']")).sendKeys(cardEx_month);

			test.log(LogStatus.PASS, "Enterd Expiry month " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='expyear']")).sendKeys(cardEx_Year);

			test.log(LogStatus.PASS, "Enterd Expiry year " + cardEx_month);

			driver.findElement(By.xpath("//*[@id='cvvnumber']")).sendKeys(cvv);

			test.log(LogStatus.PASS, "Enterd CVV " + cvv);

			driver.findElement(By.xpath("//*[@id='ccname']")).sendKeys(CardHolderName);

			test.log(LogStatus.PASS, "Card holder name is " + CardHolderName);

			/*
			 * driver.findElement(By .xpath(
			 * "//*[@id='errorMessage']/form[1]/table/tbody/tr[4]/td/table[1]/tbody/tr[23]/td[2]/div/input[3]"
			 * )) .click();
			 */
			driver.findElement(
					By.xpath("//input[@class='sortbuttons' and @onclick='this.disabled=true;addCard(this);']")).click();

			test.log(LogStatus.PASS, "Clicked on add card button ");

			Thread.sleep(30000);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{

				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

			}

			if (AllowPromotion.equals("Yes"))

			{

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}
				}
				}
				Thread.sleep(5000);
				driver.findElement(By.name("requestBean.siilBean.checkopt")).sendKeys(No_of_checks);

				test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

				driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

				test.log(LogStatus.PASS, "check box selected ");

				driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

				test.log(LogStatus.PASS, "Enterd amount is " + relamount);

			}

			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

			test.log(LogStatus.PASS, "Password entered as " + ESign_Password);

			driver.findElement(By.name("finishLoan")).click();

			test.log(LogStatus.PASS, "Clicked on Finish Conversion Loan button ");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				// if alert present, accept and move on.

			} catch (NoAlertPresentException e) {
				// do what you normally would if you didn't have the alert.
			}
		}

	

	public static void ILP_check() throws InterruptedException {

		driver.findElement(By.name("collateralType")).sendKeys(ESign_CollateralType);

		test.log(LogStatus.PASS, "Collateral Type is enterted as " + ESign_CollateralType);

		if (ESign_DisbType.equalsIgnoreCase("Cash") || ESign_DisbType.equalsIgnoreCase("Check")) {

			driver.findElement(By.name("requestBean.siilBean.disbType")).sendKeys(ESign_DisbType);

			test.log(LogStatus.PASS, "Disb Type is enterted as " + ESign_DisbType);
			driver.findElement(By.name("vehicleKey")).sendKeys("NO");

			test.log(LogStatus.PASS, "Vehicle Key selected as NO ");

			driver.findElement(By.name("requestBean.siilBean.disbAmtFirst")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Disb Amt is enterted as " + relamount);

			driver.findElement(By.name("requestBean.siilBean.courtesyCallFlag")).sendKeys(ESign_CourtesyCallConsent);

			test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_CourtesyCallConsent);

			if (ESign_CourtesyCallConsent.equals("Yes"))

			{

				if (ESign_Preference.equals("Call"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceCall']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				else if (ESign_Preference.equals("Mail"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceMail']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

				}

				else if (ESign_Preference.equals("SMS"))

				{

					driver.findElement(By.xpath("//*[@id='preferenceSms']")).click();

					test.log(LogStatus.PASS, "Courtesy Call Consent is selected as " + ESign_Preference);

					try {

						Alert alert = driver.switchTo().alert();

						alert.dismiss();

					}

					catch (NoAlertPresentException e) {

					}

				}

			}

			else {

				test.log(LogStatus.PASS, "Esign preference selected as NO ");

			}

			if (AllowPromotion.equals("Yes"))

			{

				String main_window = driver.getWindowHandle();
				driver.findElement(locator(prop.getProperty("csr_new_loan_promotions_btn"))).sendKeys(Keys.ENTER);
				test.log(LogStatus.PASS, "Promotion button is clicked ");
				Thread.sleep(10000);

				for (String winHandle1 : driver.getWindowHandles()) {
					if (!main_window.equalsIgnoreCase(winHandle1)) {
						Thread.sleep(5000);
						driver.switchTo().window(winHandle1);
						Thread.sleep(5000);
						driver.findElement(locator(prop.getProperty("csr_new_loan_promotion_radio_btn"))).click();
						test.log(LogStatus.PASS, "Promotion radio button is selected ");
						driver.findElement(locator(prop.getProperty("csr_new_loan_promo_ok_btn"))).click();
						test.log(LogStatus.PASS, "OK button is clicked ");

						driver.switchTo().window(main_window);
						try {
							Alert alert = driver.switchTo().alert();
							String almsg = alert.getText();

							alert.accept();
							test.log(LogStatus.PASS, "Alert handled " + almsg);
							test.log(LogStatus.PASS, "Alert accepted");
							Thread.sleep(5000);
							driver.switchTo().window(main_window);
							driver.switchTo().defaultContent();
							driver.switchTo().frame("mainFrame");
							driver.switchTo().frame("main");
							// if alert present, accept and move on.

						} catch (Exception e) {

						}
						break;
					}

				}

			}
			driver.findElement(By.id("checkCount")).sendKeys(No_of_checks);

			test.log(LogStatus.PASS, "Number of checks selected as " + No_of_checks);

			driver.findElement(By.name("requestBean.siilBean.isCustCheck1")).click();

			test.log(LogStatus.PASS, "check box selected ");

			driver.findElement(By.name("requestBean.siilBean.checkAmt1")).sendKeys(relamount);

			test.log(LogStatus.PASS, "Enterd amount is " + relamount);
			/*
			 * driver.findElement(By.name("requestBean.siilBean.checkopt")).
			 * sendKeys(No_of_checks); test.log(LogStatus.PASS,
			 * "Entered number of checks as " + No_of_checks);
			 * 
			 * driver.findElement(By.name("requestBean.siilBean.payeeName1")).
			 * sendKeys(CC_Issuer_Name); test.log(LogStatus.PASS,
			 * "Entered payee Name as " + CC_Issuer_Name);
			 * driver.findElement(By.name("requestBean.siilBean.checkAmt1")).
			 * sendKeys(CC_Issuer_Name); test.log(LogStatus.PASS,
			 * "Entered payee Name as " + CC_Issuer_Name);
			 */

			driver.findElement(By.name("requestBean.password")).sendKeys(ESign_Password);

			test.log(LogStatus.PASS, "ESign_Checks is selected as " + ESign_Password);

			driver.findElement(By.name("finishLoan")).click();

			test.log(LogStatus.PASS, "click on Finish Conversio Loan button ");
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				// if alert present, accept and move on.

			} catch (NoAlertPresentException e) {
				// do what you normally would if you didn't have the alert.
			}
		}
	}
}
