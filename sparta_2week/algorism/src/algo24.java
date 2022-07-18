import java.util.Arrays;
import java.util.Collections;

public class algo24 {
    public static long solution(long n) {
        long answer = 0;

        String str = Long.toString(n);
        String[] str_arr = str.split("");
        Arrays.sort(str_arr, Collections.reverseOrder()); // 배열 str_arr 내림차순으로 정렬. 오름차순은 Array.sort(str_arr);

        String str2 = String.join("", str_arr);
        answer = Long.parseLong(str2);

        return answer;
    }
}

// String.join은 배열에 들어있는 문자열을 이어붙여주는 기능을 가졌다. str_arr 앞에 "" 공백을 넣어놨는데 여기에 ", "와 같이 콤마를 찍어주면 값 사이에 콤마로 구분되어 출력된다고 함
