public class algo17 {

    public static void main(String[] args) {
        String a = "123a";
        String c = "ab3456";
        boolean b = solution(a);
        System.out.println("b = " + b);
    }

    public static boolean solution(String s) {
        boolean answer = true;

        if(s.length()==4 || s.length()==6 ) {
            for (int i=0; i<s.length(); i++) {
                if(s.charAt(i)>57) {
                    answer = false;
                    break;
                }
            }
        }else {
            answer = false;
        }
        return answer;
    }
}
