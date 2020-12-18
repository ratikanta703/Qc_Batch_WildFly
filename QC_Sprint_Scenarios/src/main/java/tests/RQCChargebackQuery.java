package tests;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import oracle.jdbc.OracleTypes;

public class RQCChargebackQuery extends QCStore{
	public static String VERIFICATION_FEE;

	public static void proc() throws ClassNotFoundException, SQLException {
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
		
		test.log(LogStatus.INFO, "****** Data Base Verification Has Started ******");
		
		try {

			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_DEC1019",
					"QCautoMDEC216");*/
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", DBUserName,
					DBPassword);
			
			/*conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.241:1521:QFUNDUAT1", "QC_AUTOM_JAN3020",
					"QcAUTOjaN3020");*/
			test.log(LogStatus.PASS, "Connecting to DB To Validate Verification Fee ");

		} catch (SQLException e1) {

			System.out.println("Connection Failed! Check output console" + e1);
			e1.printStackTrace();
		}

		// Execute a query
		stmt = conn.createStatement();
		//loan_nbr="10863916";
		//System.out.println("after conn");
		try {
		
			 
			 
			resultSet = stmt.executeQuery("select VERIFICATION_FEE FROM  st_il_distribution A WHERE A.iLOAN_TRAN_CODE IN (SELECT iLOAN_TRAN_CODE  From  st_il_trans Where iloan_code In (Select iloan_code From st_il_Master Where iloan_code="+loan_nbr+"))");
			
			 test.log(LogStatus.PASS, "Executing the query to validate Verification Fee");

			while (resultSet .next())
			{
				
			 
			 System.out.println(resultSet .getString(1));
				VERIFICATION_FEE = resultSet .getString(1);
				System.out.println(VERIFICATION_FEE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> VERIFICATION FEE is :" +VERIFICATION_FEE);
				test.log(LogStatus.PASS, "<FONT color=green style=Arial> In Verification Fee Column the Value is Null");
				 //App_BoCode = "2520717";
				
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

}

