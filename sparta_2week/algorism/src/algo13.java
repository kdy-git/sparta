//2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class algo13 {

    public static void main(String[] args) throws Exception {

        int a = 5;
        int b = 24;
        String c = solution(a, b);
        String d = solution2(a, b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

    }

    public static String solution(int a, int b) throws Exception {
        String answer = "";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2016-"+a+"-"+b);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int day = cal.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;

        }

        return answer;
    }

    public static String solution2(int a, int b) {
        String answer = "";

        int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] MM ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int Adate = 0;
        for(int i = 0 ; i< a-1; i++){
            Adate += c[i]; // a=5일시 1월부터 4월까지 날짜 모두더하기
        }
        Adate += b-1; // 1월1일부터 시작이니 선택한 날짜 b에 -1해서 추가로 더해줌
        answer = MM[Adate %7]; // 7로나눈 나머지로 배열의 요일값 가져옴

        return answer;
    }
}
