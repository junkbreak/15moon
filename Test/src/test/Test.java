package test;

import java.util.Calendar;

public class Test {
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		//현재 년도, 월, 일
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		
		 
		//현재 (시,분,초)
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		 
		
			System.out.println();
	}
	

}
