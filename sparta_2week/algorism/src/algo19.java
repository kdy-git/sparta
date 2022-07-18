public class algo19 {

    public static String solution(int n) {
        String answer = "";
        String sb = "수박".repeat(n);

        String a = sb.substring(0,n);

        answer = a;

        return answer;
    }
}
