
package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;
//import tests.QCStore;


public class OnlineStore_DB_Date_Setup extends QCStore {
	
//public static ExtentTest test;
public static String db_BoCode;
public static String App_BoCode;
public static String st_date;
public static String str_date;
public static String accr_date;



public static void nm_ilp_datesetup(String SSN,String AppURL) throws ClassNotFoundException, SQLException, ParseException

{
			
	// Object of Connection from the Database
			Connection conn = null;
			
	// Object of Statement. It is used to create a Statement to execute the query
		    Statement stmt = null;
		    
    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
			ResultSet resultSet = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			test.log(LogStatus.INFO,"**** Connecting to DB to set the Store date to current date ****");
			test.log(LogStatus.INFO, "******************************************************");
    // Open a connection
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCREL2_AUTOM_07212019", "QCREL2_AUTOM_07212019");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,DBPassword);
			System.out.println("Connecting to DB");
			test.log(LogStatus.PASS, "Connected to DB Successfully");
		
		
			stmt = conn.createStatement();
			      //Proc_Date="02-AUG-19";
			
		//=========================== For Capturing Current Date ==============================================
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date = new Date();
			
			String date1= dateFormat.format(date);
			
			System.out.println("Current date  is " +date1);
	         curr_date = date1;
	         
	         //%%%%%%%%%%%%%%%%%%%%%%
			
	         //%%%%%%%%%%%%%%%%%%%%
	        
	      
		//=================================================================================
			resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+curr_date+"' where ST_DATE_ID='PRO' and st_code in (2997,2024)");
			                               
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Current date is  :" +curr_date);
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Store Date is Set to :" +curr_date);
			test.log(LogStatus.INFO, "********************** Now Login to Lend Nation For Loan Orgination *********************** ");
			
			while (resultSet .next()) 
			
			
			
			
	// Closing Connection		
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
				break;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}


public static void nm_ilp_datesetup_to_accrualdate(String SSN,String AppURL) throws ClassNotFoundException, SQLException, ParseException

{
			
	// Object of Connection from the Database
			Connection conn = null;
			
	// Object of Statement. It is used to create a Statement to execute the query
		    Statement stmt = null;
		    
    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
			ResultSet resultSet = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			test.log(LogStatus.INFO,"**** Connecting to DB to set the Store date to accrual date ****");
			test.log(LogStatus.INFO, "******************************************************");
    // Open a connection
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCREL2_AUTOM_07212019", "QCREL2_AUTOM_07212019");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,DBPassword);
			System.out.println("Connecting to DB");
			test.log(LogStatus.PASS, "Connected to DB Successfully");
		
		
			stmt = conn.createStatement();
			      //Proc_Date="02-AUG-19";
			
		//=========================== For Capturing Current Date ==============================================
			/*DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
			Date date = new Date();
			
			String date1= dateFormat.format(date);
			
			System.out.println("Current date  is " +date1);
	         curr_date = date1;*/
	         
	         //%%%%%%%%%%%%%%%%%%%%%%
			
	         //%%%%%%%%%%%%%%%%%%%%
	        
	      
		//=================================================================================
			resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+accrual_date+"' where ST_DATE_ID='PRO' and st_code in (2997,2024)");
			                               
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Current date is  :" +curr_date);
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Store Date is Set to Accrual date :" +accrual_date);
			test.log(LogStatus.INFO, "********************** Now Login to Lend Nation For Payment *********************** ");
			
			while (resultSet .next()) 
			
			
			
			
	// Closing Connection		
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
				break;
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}

	public static void nv_pdl_datesetup(String SSN,String AppURL) throws ClassNotFoundException, SQLException, ParseException
 
	{
				
		// Object of Connection from the Database
				Connection conn = null;
				
		// Object of Statement. It is used to create a Statement to execute the query
			    Statement stmt = null;
			    
	    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
				ResultSet resultSet = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				test.log(LogStatus.INFO,"**** Connecting to DB to set the Store date to current date ****");
				test.log(LogStatus.INFO, "******************************************************");
	    // Open a connection
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCREL2_AUTOM_07212019", "QCREL2_AUTOM_07212019");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,DBPassword);
				System.out.println("Connecting to DB");
				test.log(LogStatus.PASS, "Connected to DB Successfully");
			
			
				stmt = conn.createStatement();
				      //Proc_Date="02-AUG-19";
				
			//=========================== For Capturing Current Date ==============================================
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				Date date = new Date();
				
				String date1= dateFormat.format(date);
				
				System.out.println("Current date  is " +date1);
		         curr_date = date1;
		         
		         //%%%%%%%%%%%%%%%%%%%%%%
				
		         //%%%%%%%%%%%%%%%%%%%%
		        
		      
			//=================================================================================
				resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+curr_date+"' where ST_DATE_ID='PRO' and st_code in (2997,2023)");
				                               
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Current date is  :" +curr_date);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Store Date is Set to :" +curr_date);
				test.log(LogStatus.INFO, "********************** Now Login to Lend Nation For Loan Orgination *********************** ");
				
				while (resultSet .next()) 
				
				
				
				
		// Closing Connection		
				
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (Exception e) {
					}
					break;
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
				}
				
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
					}
				}
			}
	
	public static void la_pdl_datesetup(String SSN,String AppURL) throws ClassNotFoundException, SQLException, ParseException
	 
	{
				
		// Object of Connection from the Database
				Connection conn = null;
				
		// Object of Statement. It is used to create a Statement to execute the query
			    Statement stmt = null;
			    
	    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
				ResultSet resultSet = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				test.log(LogStatus.INFO,"**** Connecting to DB to set the Store date to current date ****");
				test.log(LogStatus.INFO, "******************************************************");
	    // Open a connection
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QCREL2_AUTOM_07212019", "QCREL2_AUTOM_07212019");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,DBPassword);
				System.out.println("Connecting to DB");
				test.log(LogStatus.PASS, "Connected to DB Successfully");
			
			
				stmt = conn.createStatement();
				      //Proc_Date="02-AUG-19";
				
			//=========================== For Capturing Current Date ==============================================
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				Date date = new Date();
				
				String date1= dateFormat.format(date);
				
				System.out.println("Current date  is " +date1);
		         curr_date = date1;
		         
		         //%%%%%%%%%%%%%%%%%%%%%%
				
		         //%%%%%%%%%%%%%%%%%%%%
		        
		      
			//=================================================================================
				resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+curr_date+"' where ST_DATE_ID='PRO' and st_code in (2997,2019)");
				                               
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Current date is  :" +curr_date);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Store Date is Set to :" +curr_date);
				test.log(LogStatus.INFO, "********************** Now Login to Lend Nation For Loan Orgination *********************** ");
				
				while (resultSet .next()) 
				
				
				
				
		// Closing Connection		
				
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (Exception e) {
					}
					break;
				}
				
				if (stmt != null) {
					try {
						stmt.close();
					} catch (Exception e) {
					}
				}
				
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
					}
				}
			}
	
	
	public static void accuraldate() throws ClassNotFoundException, SQLException 
	{
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Accrual Date Capturing Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);					
			test.log(LogStatus.PASS, "Connecting to DB To Get Accrual Date ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11572800";
	
		try {
			
			  //resultSet = stmt.executeQuery("select apportion_id,apportion_amt  from St_Lo_Apportions where loan_tran_code in (select loan_tran_code from st_lo_trans where loan_code="+loan_nbr+")");			                                 
			resultSet = stmt.executeQuery("select accrual_date from bo_in_app_queue where app_no="+loan_number+" ");
			  
			  test.log(LogStatus.PASS, "Executing the query to get accrual date");
			 

			while (resultSet .next())
			{
				
				//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	//############################################################################
				accr_date = resultSet .getString(1);
				System.out.println(accr_date);
		
				String store_date[]=accr_date.split(" ");
				
				String business_date=store_date[0].trim();
				System.out.println(business_date);
				
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
				accrual_date = sdf2.format(sdf1.parse(business_date));
				System.out.println(accrual_date); 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
				
	//################################################################################
				
		} 			 
			
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
			System.out.println("after query");
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		
		catch (Exception e2) {

			System.out.println(" console" + e2);
			
			e2.printStackTrace();
		}

	}
	
	public static void nm_strdate() throws ClassNotFoundException, SQLException 
	{
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** St Date Capturing Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);					
			test.log(LogStatus.PASS, "Connecting to DB To Get St Date ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11572800";
	
		try {
			
			  //resultSet = stmt.executeQuery("select apportion_id,apportion_amt  from St_Lo_Apportions where loan_tran_code in (select loan_tran_code from st_lo_trans where loan_code="+loan_nbr+")");			                                 
			   //resultSet = stmt.executeQuery("select accrual_date from bo_in_app_queue where app_no="+loan_number+" ");
			
			resultSet = stmt.executeQuery("select st_date from ca_ss_store_date where st_code in (2024,2997)and ST_DATE_ID='PRO' ");
			  
			  test.log(LogStatus.PASS, "Executing the query to get St date");
			 

			while (resultSet .next())
			{
				
				//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	//############################################################################
				str_date = resultSet .getString(1);
				System.out.println(str_date);
		
				String store_date[]=str_date.split(" ");
				
				String business_date=store_date[0].trim();
				System.out.println(business_date);
				
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
				sstore_date = sdf2.format(sdf1.parse(business_date));
				System.out.println(sstore_date); 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>St date is :"+sstore_date );
				    //String accrual_date = "09-11-2020";
				if (accrual_date.trim().equalsIgnoreCase(sstore_date.trim())) {
					test.log(LogStatus.INFO, "<FONT color=green style=Arial>Accrual Date is Same as ST_Date:" +sstore_date);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
										
					Thread.sleep(5000);
					
			}
				
				else {
					test.log(LogStatus.INFO, "<FONT color=green style=Arial>Accrual Date is Not Same as ST_Date:" +sstore_date);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
					test.log(LogStatus.PASS, "<FONT color=green style=Arial>St date is :"+sstore_date );
					
				break;
				}
				
				
	//################################################################################
				
		} 			 
			
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
			System.out.println("after query");
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		
		catch (Exception e2) {

			System.out.println(" console" + e2);
			
			e2.printStackTrace();
		}

	}
	

	
	public static void nv_strdate() throws ClassNotFoundException, SQLException 
	{
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** St Date Capturing Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);					
			test.log(LogStatus.PASS, "Connecting to DB To Get St Date ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11572800";
	
		try {
			
			  //resultSet = stmt.executeQuery("select apportion_id,apportion_amt  from St_Lo_Apportions where loan_tran_code in (select loan_tran_code from st_lo_trans where loan_code="+loan_nbr+")");			                                 
			   //resultSet = stmt.executeQuery("select accrual_date from bo_in_app_queue where app_no="+loan_number+" ");
			
			resultSet = stmt.executeQuery("select st_date from ca_ss_store_date where st_code in (2023,2997)and ST_DATE_ID='PRO' ");
			  
			  test.log(LogStatus.PASS, "Executing the query to get St date");
			 

			while (resultSet .next())
			{
				
				//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	//############################################################################
				str_date = resultSet .getString(1);
				System.out.println(str_date);
		
				String store_date[]=str_date.split(" ");
				
				String business_date=store_date[0].trim();
				System.out.println(business_date);
				
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
				sstore_date = sdf2.format(sdf1.parse(business_date));
				System.out.println(sstore_date); 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>St date is :"+sstore_date );
				
	//################################################################################
				
		} 			 
			
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
			System.out.println("after query");
			
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		
		catch (Exception e2) {

			System.out.println(" console" + e2);
			
			e2.printStackTrace();
		}

	}
	
	public static void la_strdate() throws ClassNotFoundException, SQLException 
	{
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** St Date Capturing Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);					
			test.log(LogStatus.PASS, "Connecting to DB To Get St Date ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11572800";
	
		try {
			
			 
			resultSet = stmt.executeQuery("select st_date from ca_ss_store_date where st_code in (2019,2997)and ST_DATE_ID='PRO' ");
			  
			  test.log(LogStatus.PASS, "Executing the query to get St date");
			 

			while (resultSet .next())
			{
				
				Thread.sleep(1000);
				str_date = resultSet .getString(1);
				System.out.println(str_date);
		
				String store_date[]=str_date.split(" ");
				
				String business_date=store_date[0].trim();
				System.out.println(business_date);
				
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
				sstore_date = sdf2.format(sdf1.parse(business_date));
				System.out.println(sstore_date); 
				test.log(LogStatus.PASS, "<FONT color=green style=Arial>St date is :"+sstore_date );
				Thread.sleep(1000);
		} 			 
			
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial>Accrual date is :"+accrual_date );
			System.out.println("after query");
			Thread.sleep(1000);
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		} 
		
		catch (Exception e2) {

			System.out.println(" console" + e2);
			
			e2.printStackTrace();
		}

	}
	

	
	public static void agestore() throws ClassNotFoundException, SQLException 
	{
		
			
			// Object of Connection from the Database
					Connection conn = null;
					
			// Object of Statement. It is used to create a Statement to execute the query
				    Statement stmt = null;
				    
		    // Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
					ResultSet resultSet = null;
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					test.log(LogStatus.INFO,"Connecting to DB and AgeStore has started");
					test.log(LogStatus.INFO, "******************************************************");
		    // Open a connection
					conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
							 DBPassword);
					
					System.out.println("Connecting to DB");
					test.log(LogStatus.PASS, "Connecting to DB Successfully");
					//System.out.println();
				
					stmt = conn.createStatement();
					      //Proc_Date="02-AUG-19";
					
					resultSet = stmt.executeQuery("update ca_ss_store_date set st_date= '"+accrual_date+"' where ST_DATE_ID='PRO' and st_code in (2023)");
					                               
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> After Age the Store the Date is  :" +accrual_date);
					while (resultSet .next()) 
					
					
					
					
			// Closing Connection		
					
					if (resultSet != null) {
						try {
							resultSet.close();
						} catch (Exception e) {
						}
						break;
					}
					
					if (stmt != null) {
						try {
							stmt.close();
						} catch (Exception e) {
						}
					}
					
					if (conn != null) {
						try {
							conn.close();
						} catch (Exception e) {
						}
					}
				}
	

}