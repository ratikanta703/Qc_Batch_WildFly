package tests;

import java.util.Arrays;

import org.openqa.selenium.By;

public class testing {

	public static void main(String[] args) {
		//String loan_num="Loan 12345";

	       /* String[] arrOfStr = loan_num.split("Loan "); 
	  
	        for (String loannumber : arrOfStr) 
	            System.out.println(loannumber); 
	        
		  String strr=
		  System.out.println(strr); */
	       
		
		//String Date1=store_date[1].trim();
		String loan_num="Loan 12345";
		loan_num=Character.toString(loan_num.charAt(5))+
				Character.toString(loan_num.charAt(6))+
				Character.toString(loan_num.charAt(7))+
				Character.toString(loan_num.charAt(8))+
				Character.toString(loan_num.charAt(9)).trim();
		  

	}

}
