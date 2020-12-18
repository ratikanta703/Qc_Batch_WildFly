package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.relevantcodes.extentreports.LogStatus;

public class test1 {

	public static void main(String[] args) {
		
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		
		 Date date = new Date();

		
		 String date1= dateFormat.format(date);

		
		 System.out.println("Current date  is " +date1);
		
		        
          String curr_date = date1;
		
          String store_date[]=curr_date.split("-");
			String business_date=store_date[1].trim();
			System.out.println(business_date.toUpperCase()); 
			String ddate=business_date.toUpperCase();
			
			//=====================
			
			//====================
			 //System.out.println();
			 
			int n = 3;		
			String s = ddate;
			System.out.println(s.substring(0,n));
			
			ArrayList<String> list = new ArrayList<>();
		    String Proc_Date=store_date[0]+""+"-"+s.substring(0,n)+"-"+store_date[2];	      
		    System.out.println(Proc_Date);
		
		
	}	
}
