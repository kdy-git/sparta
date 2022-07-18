public class algo28 {

    public static void main(String[] args) {
        int x = 11;
        boolean result = solution(x);
        System.out.println(result);
    }
    public static boolean solution(int x) {
        boolean answer;
        int result = 0;
        int a = x;
        int y;

        int length = Integer.toString(x).length(); // 몇자리수인지 확인

        for(int i=0; i<length; i++) {
            y = a%10;
            result += y;
            a = a/10;
        }
        if(x % result == 0) {
             answer = true;
        }else {
             answer = false;
        }
        return  answer;
    }
}
