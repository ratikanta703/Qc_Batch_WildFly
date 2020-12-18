package tests;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
		String store_date[]=Str_date.split(":");
		String pname=store_date[1].trim();
		pname=Character.toString(pname.charAt(1))+Character.toString(pname.charAt(2))+Character.toString(pname.charAt(3))+Character.toString(pname.charAt(4))
		      +Character.toString(pname.charAt(5))+Character.toString(pname.charAt(6))+Character.toString(pname.charAt(7))+Character.toString(pname.charAt(8))
		      +Character.toString(pname.charAt(9))+Character.toString(pname.charAt(10));
		String business_date = pname;*/
		
		
		String str1="MO Installment Loan - Qfund Old";
		String store2[]=str1.split(" ");
		String pname=store2[1].trim();
		String store3=Character.toString(pname.charAt(0))+Character.toString(pname.charAt(1))+Character.toString(pname.charAt(2))+Character.toString(pname.charAt(3))
	      +Character.toString(pname.charAt(4))+Character.toString(pname.charAt(5))+Character.toString(pname.charAt(6))+Character.toString(pname.charAt(7))
	      +Character.toString(pname.charAt(8))+Character.toString(pname.charAt(9))+Character.toString(pname.charAt(10));
		System.out.println(pname);
		

	}

}
