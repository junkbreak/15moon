package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
 
 
public class Text {
	
		//달력 함수 호출
		Calendar cal = Calendar.getInstance();
	 
		//현재 년도, 월, 일
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		
		 
		//현재 (시,분,초)
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		
		//이번달의 마지막을 표시함 for문중 마지막날을 넘기면 month를 +1 하게됨
		int lastday = getNumberOfDaysInMonth(year,month);
		
	public String moon() {
			
			String smonth = "0";
			String sdate = "0";
			String lunAge = "";
			String lunAge2 = "";
			String urlPath = "";
			String pageContents = "";
			String b = "";
			int idx = 0;
			int idx2 = 0;
			BufferedReader buff = null;
			StringBuilder contents = null;
			
			//url을 담을 변수가 String형이기 때문에 int형의 오늘 날짜를 String으로 변환합니다.
			//변환하는 이유
			//java의 날짜형식 - 1일,2일,3일... 
			//url주소의 날짜형식 - 01일,02일,03일...
			if(month<10) {
				smonth = smonth+String.valueOf(month);
			}else {
				smonth = String.valueOf(month);
			}
				//15일앞을 찍어내기위한 반복문
				for(int i=0; i<16; i++) {
					date = date +1;
					System.out.println(i+"번째 금일 날짜 : "+date);
					//반복문이 1번 실행되면 날짜를 바꿔주는 반복문을 실행함
					if(date<10){
						sdate = "0";
						sdate = sdate+String.valueOf(date);
					}else {
						sdate = String.valueOf(date);
					}
					//이달의 마지막 달이 넘으면 다음달로 넘어가고 날짜를 1일로 초기화함
					if(lastday<date) {
						date = 1;
						month = month+1;
						if(month<10) {
							smonth = "0";
							smonth = smonth+String.valueOf(month);
						}else {
							smonth = String.valueOf(month);
						}
					}
					
					//url을 호출하고 변환하여 변수에 담는 과정
					urlPath = "http://apis.data.go.kr/B090041/openapi/service/LunPhInfoService/getLunPhInfo?solYear="+year+"&solMonth="+smonth+"&solDay="+sdate+"&serviceKey=WjughaThdULfdkECwUvSg3aMD0iR1nDXxzk2DUSTi4Gqj%2FtaV5GPsoHLVInvNg5ZdUZx0awqPAoVinLy%2B5xcjA%3D%3D";
			        pageContents = "";
			        contents = new StringBuilder();
			 
			        try{
			 
			            URL url = new URL(urlPath);
			            URLConnection con = (URLConnection)url.openConnection();
			            InputStreamReader reader = new InputStreamReader (con.getInputStream(), "utf-8");
			 
			            buff = new BufferedReader(reader);
			 
			            while((pageContents = buff.readLine())!=null){
			                //System.out.println(pageContents);             
			                contents.append(pageContents);
			                contents.append("\r\n");
			            }
			 
			            buff.close();
			 
			            
			 
			        }catch(Exception e){
			            e.printStackTrace();
			        }
			        b = contents.toString();
			        
			        
			        
			        //월령데이터만을 추출하기위한 구문
			        idx = b.indexOf("<lunAge>");  // <lunAge> 앞부분을 추출
			        idx2 = b.indexOf("</lunAge>"); // </lunAge> 앞부분을 추출
			        lunAge = b.substring(idx+8, idx2);//<lunAge>월령</lunAge>의 "월령"부분을 lunAge에 넣음
			        System.out.println("웹페이지 출력 : "+b);
			        System.out.println(i+"번째 월령 : "+lunAge);
					lunAge2 = lunAge2+lunAge+" ";
			        System.out.println(i+"번째 월령 모음 : "+lunAge2+"\n");
				}
			
			
			
			return lunAge2;
	 
	    }
	
		//해당 년도가 윤년인지 판별
		public static boolean isLeapYear(int year) {
	        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	    }
		//달의 마지막 일을 구함
		private static int getNumberOfDaysInMonth(int year,int month) {
			 
	        if (month == 4 || month == 6 || month == 9 || month == 11) {
	            return 30;
	        } else if (month == 2 && isLeapYear(year) == true) {
	            return 29;
	        } else if (month == 2 && isLeapYear(year) == false) {
	            return 28;
	        } else {
	            return 31;
	        }
	    }
	public void main(String moon) {
    // TODO Auto-generated method stub
		moon = moon();
   
	}
}
 