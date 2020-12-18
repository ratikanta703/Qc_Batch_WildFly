package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class RDBValidation extends QCStore{
	public static String TOTAL_DUE;
	public static String ACTION_TYPE;
	public static String REPAY_SEQ_NUM;
	public static String TRANSACTION_TYPE;
	public static String BO_CHECK_AMT;
	public static String DEFAULT_ACH_AMT;
	public static String apportion_id;
	public static String apportion_amt;
	

	public static void dbvalidation() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					"QcAUTOjaN3020");*/
			test.log(LogStatus.PASS, "Connecting to DB To Validate Total Due Amount ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}
		stmt = conn.createStatement();
		//loan_nbr="10863916";		
		try {
		resultSet = stmt.executeQuery("select total_due,BO_CHECK_AMT,DEFAULT_ACH_AMT from  st_lo_master where loan_code='"+loan_number+"'");

			 test.log(LogStatus.PASS, "Executing the query to validate Total Due");

			while (resultSet .next())
			{
				
				System.out.println(resultSet .getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3) + "  ");
			 System.out.println(resultSet .getString(1));
				TOTAL_DUE = resultSet .getString(1);
				BO_CHECK_AMT = resultSet .getString(2);
				DEFAULT_ACH_AMT = resultSet .getString(3);
				System.out.println(TOTAL_DUE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Total Due is :" +TOTAL_DUE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> BO Check Amount is :" +BO_CHECK_AMT);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Default ACH Amount is :" +DEFAULT_ACH_AMT);
				
		} 
			 
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
	
	public static void tlpvoiddbvalidation() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		 //System.out.println("before conn");
		// Open a connection
		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					"QcAUTOjaN3020");*/
			test.log(LogStatus.PASS, "Connecting to DB To Validate Total Due Amount ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11168355";
		//System.out.println("after conn");
		try {
				
			resultSet = stmt.executeQuery("select ACTION_TYPE,TRANSACTION_TYPE from  repay_data_log where loan_code="+loan_number+"");

			 test.log(LogStatus.PASS, "Executing the query to validate Payment Plan Payment is Posted or Not");

			while (resultSet .next())
				
			{
				
				System.out.println(resultSet .getString(1) + "  " + resultSet.getString(2) + "  ");
			 System.out.println(resultSet .getString(1));
			 ACTION_TYPE = resultSet .getString(1);
			 //REPAY_SEQ_NUM = resultSet .getString(2);
			 TRANSACTION_TYPE = resultSet .getString(2);
				System.out.println(TOTAL_DUE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Action Type is :" +ACTION_TYPE);
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Repay Sequency Number is :" +REPAY_SEQ_NUM);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Transaction Type is :" +TRANSACTION_TYPE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Plan Payment is Posted in DB");				
				
		} 
			 
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

	public static void tlpdbvalidation() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					"QcAUTOjaN3020");*/
			test.log(LogStatus.PASS, "Connecting to DB To Validate Total Due Amount ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11168371";
		//System.out.println("after conn");
		try {

			resultSet = stmt.executeQuery("select ACTION_TYPE,TRANSACTION_TYPE from  repay_data_log where loan_code="+loan_number+"");

			 test.log(LogStatus.PASS, "Executing the query to validate Payment Plan Payment is Posted or Not");
			
			while (resultSet .next())
				
			{
				
			 System.out.println(resultSet .getString(1) + "  " + resultSet.getString(2) + "  ");
			 System.out.println(resultSet .getString(1));
			 ACTION_TYPE = resultSet .getString(1);
			 //REPAY_SEQ_NUM = resultSet .getString(2);
			 TRANSACTION_TYPE = resultSet .getString(2);
				System.out.println(TOTAL_DUE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Action Type is :" +ACTION_TYPE);
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Repay Sequency Number is :" +REPAY_SEQ_NUM);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Transaction Type is :" +TRANSACTION_TYPE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Plan Payment is Posted in DB");
				 //App_BoCode = "2520717";
				
		} 
			 
			System.out.println("after query");
			 //test.log(LogStatus.INFO, "There is no Record to display");
			//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Plan Payment is not Posted in DB");

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
			test.log(LogStatus.INFO, "There is no Record to display");
			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void ilpvoid_validation() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					"QcAUTOjaN3020");*/
			test.log(LogStatus.PASS, "Connecting to DB To Validate Total Due Amount ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_number="11168994";
		try {
					 			 						
			resultSet = stmt.executeQuery("select IS_VOIDED from  ilp_rcpt_detail where loan_code="+loan_number+"");

			 test.log(LogStatus.PASS, "Executing the query to Check Void Payment is Posted or Not");
		
			while (resultSet .next())
				
			{
				
			 System.out.println(resultSet .getString(1) + "  " + resultSet.getString(2) + "  ");
			 System.out.println(resultSet .getString(1));
			 ACTION_TYPE = resultSet .getString(1);
			 //REPAY_SEQ_NUM = resultSet .getString(2);
			 TRANSACTION_TYPE = resultSet .getString(2);
				System.out.println(TOTAL_DUE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Action Type is :" +ACTION_TYPE);
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Repay Sequency Number is :" +REPAY_SEQ_NUM);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Transaction Type is :" +TRANSACTION_TYPE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> Payment Plan Payment is Posted in DB");
				 //App_BoCode = "2520717";
				
		} 
			 
			System.out.println("after query");
			 //test.log(LogStatus.INFO, "There is no Record to display");
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Void Payment is not Posted in DB as per the Scenario");

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
			test.log(LogStatus.INFO, "There is no Record to display");
			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void apportionvalidation() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		// Object of Statement. It is used to create a Statement to execute the
		// query
		Statement stmt = null;

		// Object of ResultSet => 'It maintains a cursor that points to the
		// current row in the result set'
		ResultSet resultSet = null;
		List<String> rowValues = new ArrayList();
		List<String> rowValues2 = new ArrayList();
		int total_sum[] = null;
		String stotal[] = new String [20];
		//String stotal[] = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started For Apportion******");
		 //System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);					
			test.log(LogStatus.PASS, "Connecting to DB To Validate Verification Fee ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_nbr="11169064";
	
		try {
			
			  resultSet = stmt.executeQuery("select apportion_id,apportion_amt  from St_Lo_Apportions where loan_tran_code in (select loan_tran_code from st_lo_trans where loan_code="+loan_nbr+")");			                                 
			  test.log(LogStatus.PASS, "Executing the query to validate Verification Fee");

			while (resultSet .next())
			{
				//System.out.println(resultSet .getString(1));
	
				 apportion_id = resultSet .getString(1);
				 apportion_amt = resultSet .getString(2);
								 			
				System.out.println(apportion_id);
				System.out.println(apportion_amt);
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial> VERIFICATION FEE is :" +VERIFICATION_FEE);
				//test.log(LogStatus.PASS, "<FONT color=green style=Arial> In Verification Fee Column the Value is Null");
				if(apportion_id.equalsIgnoreCase("F") || apportion_id.equalsIgnoreCase("RF")){
				//if (str != null && !str.isEmpty()) {
					System.out.println("Apportion ID is :"+apportion_id);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Apportion ID is :" +apportion_id);
					System.out.println("Apportion Amount is :"+apportion_amt);
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> Apportion Amount is :" +apportion_amt);
					
					}
				   /*else if(apportion_id.equalsIgnoreCase("RF")){
					System.out.println("Apportion ID is :"+apportion_id);
					}*/
				
		} 			 
			
			test.log(LogStatus.PASS, "<FONT color=green style=Arial>In Apportion F and FR amount is accurate" );
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

	
	
}

