import java.util.Arrays;
import java.util.Collections;

public class algo23 {

    public static void main(String[] args) {
        long n = 1234514656;
        int[] result = solution(n);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(long n) {

        int count = 0;

        String number = Long.toString(n);
        String[] result = number.split(""); // 짜르기!

        int[] answer = new int[result.length]; // 배열크기 선언


        for(String s : result) {  // 향상포문. result값들 돌면서 s에 대입
            int x = Integer.parseInt(s); // s값들을 int로 바꿔주고 x에 넣기
            answer[result.length-1-count] = x; // 배열의 마지막부터 차례대로 x값 대입하기.
            count++; //for문 한번 돌때마다 카운트 +1씩 증가.
        }

        return answer;
    }
}
