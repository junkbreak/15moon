package test;

import java.util.Calendar;

public class Test {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//���� �⵵, ��, ��
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		
		 
		//���� (��,��,��)
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		 
		
			System.out.println();
	}
	

}
