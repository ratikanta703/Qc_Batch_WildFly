package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleTypes;

//public class RProcTest {
public class RProcTest extends QCStore{

	public static void proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
						            	            		
  
			
			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code From Bo_Master Where Ssn IN  ( select ssn from QTP_SSN_TS_LOC_TWO ))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN (select ssn from QTP_SSN_TS_LOC_TWO) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO) )");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
			resultSet = stmt.executeQuery("Delete  From   st_il_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_MINPAY WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO)))))");   
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_STATEMENT WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO)))))");         
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_APPORTIONS WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO)))))");
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_RCPT WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO)))))");
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_DISB WHERE LC_TRAN_CODE IN  ( SELECT T.LC_TRAN_CODE FROM ST_LC_TRANS T WHERE T.LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO)))))");          
			resultSet = stmt.executeQuery("DELETE FROM    ST_LC_TRANS WHERE LC_CODE IN ((SELECT LC_CODE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))))");
		    resultSet = stmt.executeQuery("DELETE  From   st_lc_master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");       
			resultSet = stmt.executeQuery("Delete  From   bo_card_details Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");           
			resultSet = stmt.executeQuery("Delete  From   REPAY_DEPOSIT_SCHEDULE Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
		    resultSet = stmt.executeQuery("Delete  From   REPAY_DATA_LOG Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Master Where Bo_Code In (Select Bo_Code   From Bo_Master Where Ssn IN  (select ssn from QTP_SSN_TS_LOC_TWO))");                    
			resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('02-MAY-2018','dd-mon-yy') and st_code in (523)");
			resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('02-MAY-2018','dd-mon-yy') and st_code in (523)");
			resultSet = stmt.executeQuery("Delete from    REPO_COMPANY");
			
			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	
	public static void nvpdl_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
						            	            		
  
			
			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (734))");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (734))");        
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_RCPT A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (734)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_DISB A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (734)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_APPORTIONS A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (734)))");		 
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_Trans WHERE loan_code IN (SELECT loan_code  From  st_lo_master Where st_code IN (734))");            
		    resultSet = stmt.executeQuery("Delete  From   st_lo_master where st_code in (734)");
			resultSet = stmt.executeQuery("Delete  From   Bo_Master Where BO_ST_CODE  in (734)");         
            resultSet = stmt.executeQuery("delete from    bank_ach_staging Where st_code in (734)");             
            resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (734)");
            resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (734)");            

			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	
	public static void nvtlp_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
						            	            		
  
            
            resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_comm_log WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  ST_ti_master Where st_code=734)");
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_co_master WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  ST_ti_master Where st_code=734)");
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_TitleTracking_Log WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  ST_ti_master Where st_code=734)");
            resultSet = stmt.executeQuery("DELETE FROM    st_TI_RCPT A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code=734))");
            resultSet = stmt.executeQuery("DELETE FROM    st_TI_DISB A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code=734))");
            resultSet = stmt.executeQuery("DELETE FROM    st_TI_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code=734))");
            resultSet = stmt.executeQuery("DELETE FROM    st_TI_disB A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code=734))");		 
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_disb_check_log A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_ti_trans Where iloan_code In (Select iloan_code From st_ti_Master Where st_code in (734)))");		 
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_Trans WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  ST_ti_master Where st_code=734)");
            resultSet = stmt.executeQuery("DELETE FROM    st_ti_schedule WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  ST_ti_master Where st_code=734)");            
            resultSet = stmt.executeQuery("Delete  From   st_ti_master where st_code in (734)");
            resultSet = stmt.executeQuery("Delete  From   Bo_Master Where BO_ST_CODE  in (734)");           
            resultSet = stmt.executeQuery("delete from    bank_ach_staging where st_code in (734)");
            resultSet = stmt.executeQuery("Delete  From   BO_VEHICLES Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   TP_BLACKBOOK_VALUES");
            resultSet = stmt.executeQuery("Delete  From   TP_BLACKBOOK_REQUEST_LOG");
            resultSet = stmt.executeQuery("Delete  From   TP_BLACKBOOK_Response_LOG");
            resultSet = stmt.executeQuery("Delete from    ST_TI_REQUEST_STAGING");
            resultSet = stmt.executeQuery("Delete  From   REPAY_DEPOSIT_SCHEDULE Where Bo_Code In (Select Bo_Code   From Bo_Master Where bo_st_code=734)");
            resultSet = stmt.executeQuery("Delete  From   REPAY_DATA_LOG Where Bo_Code In (Select Bo_Code   From Bo_Master  Where bo_st_code=734)");
            
          
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void txpdl_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {

			
			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (1031))");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (1031))");        
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_RCPT A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (1031)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_DISB A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (1031)))");
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_APPORTIONS A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (1031)))");		 
			resultSet = stmt.executeQuery("DELETE FROM    st_lo_Trans WHERE loan_code IN (SELECT loan_code  From  st_lo_master Where st_code IN (1031))");          
			resultSet = stmt.executeQuery("Delete From    st_lo_master where st_code in (1031)");
			resultSet = stmt.executeQuery("Delete From    Bo_Master Where BO_ST_CODE  in (1031)");
			resultSet = stmt.executeQuery("Delete from    St_lc_trans Where st_code in(1031)");
			resultSet = stmt.executeQuery("delete from    bank_ach_staging Where st_code in (1031)");
			resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('05-DEC-2019','dd-mon-yy') and st_code in (1031)");
		    resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('05-DEC-2019','dd-mon-yy') and st_code in (1031)");
			
			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	
	public static void mopdl_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {

			
		    resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (590))");
		    resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (590))");        
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_RCPT A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (590)))");
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_DISB A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (590)))");
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_APPORTIONS A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (590)))");		 
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_Trans WHERE loan_code IN (SELECT loan_code  From  st_lo_master Where st_code IN (590))");            
		    resultSet = stmt.executeQuery("Delete  From   st_lo_master where st_code in (590)");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Master Where BO_ST_CODE  in (590)");           
		    resultSet = stmt.executeQuery("delete from    bank_ach_staging Where st_code in (590)");
		    resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (590)");
		    resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (590)");  
		    
			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void ilp_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {

			
			resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code in (3236))");
			resultSet = stmt.executeQuery("Delete  From   BO_BK_MASTER");
			resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code in (3236))");
       
		   resultSet = stmt.executeQuery("DELETE FROM    st_il_RCPT A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (3236)))");
		   resultSet = stmt.executeQuery("DELETE FROM    st_il_DISB A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (3236)))");
		   resultSet = stmt.executeQuery("DELETE FROM    st_il_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where st_code in (3236)))");
		   resultSet = stmt.executeQuery("DELETE FROM    st_il_Trans WHERE iLOAN_CODE IN (SELECT iLOAN_CODE  From  st_il_master Where st_code in (3236))");          
		   resultSet = stmt.executeQuery("Delete  From   st_il_master where st_code in (3236)");
		   resultSet = stmt.executeQuery("Delete  From   Bo_Master Where bo_st_code in (3236)");             
		   resultSet = stmt.executeQuery("Delete from  bank_ach_staging where st_code in (3236)");
		   resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('07-DEC-2018','dd-mon-yy') and st_code in (3236)");
		   resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('07-DEC-2018','dd-mon-yy') and st_code in (3236)");
			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}
	public static void lapdl_proc() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Statement stmt = null;

		ResultSet resultSet = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("before conn");
		// Open a connection
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					" QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					 DBPassword);
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					" QcAUTOjaN3020");*/

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		System.out.println("after conn");
		try {
  		    
		    
		    resultSet = stmt.executeQuery("Delete  From   Bo_Phone Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Other_Info Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Income Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Address Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Bank_Acnt Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Reference Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Notes Where Bo_Code In (Select Bo_Code  From Bo_Master Where bo_st_code IN (354))");
		    resultSet = stmt.executeQuery("Delete  From   ACH_STAGING Where Bo_Code In (Select Bo_Code From Bo_Master Where bo_st_code IN (354))");        
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_RCPT A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (354)))");
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_DISB A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (354)))");
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_APPORTIONS A WHERE A.LOAN_TRAN_CODE IN (SELECT LOAN_TRAN_CODE  From  st_lo_trans Where loan_code In (Select loan_code From st_lo_Master Where st_code IN (354)))");		 
		    resultSet = stmt.executeQuery("DELETE FROM    st_lo_Trans WHERE loan_code IN (SELECT loan_code  From  st_lo_master Where st_code IN (354))");            
		    resultSet = stmt.executeQuery("Delete  From   st_lo_master where st_code in (354)");
		    resultSet = stmt.executeQuery("Delete  From   Bo_Master Where BO_ST_CODE  in (354)");  
		    resultSet = stmt.executeQuery("delete from    bank_ach_staging Where st_code in (354)");
		    resultSet = stmt.executeQuery("Delete FROM    st_daily_summary where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (354)");
		    resultSet = stmt.executeQuery("Delete FROM    ca_closing_history where trunc(business_date)>TO_DATE('01-MAY-2019','dd-mon-yy') and st_code in (354)");      
			
			resultSet = stmt.executeQuery("Commit");
			
			Thread.sleep(8000);

			 while (resultSet .next())
			{
				System.out.println(
						/*resultSet .getString(1) + "  " +
									 * resultSet.getString(2) + "  " +
									 * resultSet.getString(3) + "  " +
									 * resultSet.getString(4) + "  " +
									 * resultSet.getString(5)
									 */);
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
		} catch (Exception e2) {

			System.out.println(" console" + e2);
			e2.printStackTrace();
		}

	}

}
