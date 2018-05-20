package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
 
 
public class Text {
	
		//�޷� �Լ� ȣ��
		Calendar cal = Calendar.getInstance();
	 
		//���� �⵵, ��, ��
		int year = cal.get ( cal.YEAR );
		int month = cal.get ( cal.MONTH ) + 1 ;
		int date = cal.get ( cal.DATE ) ;
		
		 
		//���� (��,��,��)
		int hour = cal.get ( cal.HOUR_OF_DAY ) ;
		
		//�̹����� �������� ǥ���� for���� ���������� �ѱ�� month�� +1 �ϰԵ�
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
			
			//url�� ���� ������ String���̱� ������ int���� ���� ��¥�� String���� ��ȯ�մϴ�.
			//��ȯ�ϴ� ����
			//java�� ��¥���� - 1��,2��,3��... 
			//url�ּ��� ��¥���� - 01��,02��,03��...
			if(month<10) {
				smonth = smonth+String.valueOf(month);
			}else {
				smonth = String.valueOf(month);
			}
				//15�Ͼ��� �������� �ݺ���
				for(int i=0; i<16; i++) {
					date = date +1;
					System.out.println(i+"��° ���� ��¥ : "+date);
					//�ݺ����� 1�� ����Ǹ� ��¥�� �ٲ��ִ� �ݺ����� ������
					if(date<10){
						sdate = "0";
						sdate = sdate+String.valueOf(date);
					}else {
						sdate = String.valueOf(date);
					}
					//�̴��� ������ ���� ������ �����޷� �Ѿ�� ��¥�� 1�Ϸ� �ʱ�ȭ��
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
					
					//url�� ȣ���ϰ� ��ȯ�Ͽ� ������ ��� ����
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
			        
			        
			        
			        //���ɵ����͸��� �����ϱ����� ����
			        idx = b.indexOf("<lunAge>");  // <lunAge> �պκ��� ����
			        idx2 = b.indexOf("</lunAge>"); // </lunAge> �պκ��� ����
			        lunAge = b.substring(idx+8, idx2);//<lunAge>����</lunAge>�� "����"�κ��� lunAge�� ����
			        System.out.println("�������� ��� : "+b);
			        System.out.println(i+"��° ���� : "+lunAge);
					lunAge2 = lunAge2+lunAge+" ";
			        System.out.println(i+"��° ���� ���� : "+lunAge2+"\n");
				}
			
			
			
			return lunAge2;
	 
	    }
	
		//�ش� �⵵�� �������� �Ǻ�
		public static boolean isLeapYear(int year) {
	        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
	    }
		//���� ������ ���� ����
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
 