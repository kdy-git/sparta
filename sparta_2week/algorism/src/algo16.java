public class algo16 {

    public static void main(String[] args) {
        String a = "pPoooyY";
        String b = "Pyy";
        solution(a);
    }

    static boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        int count2 = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i)=='P' ) {
                count++;
            }else if(s.charAt(i) == 'y' || s.charAt(i)=='Y' ) {
                count2++;
            }
            if(count==count2) {
                answer=true;
            }else {
                answer=false;
            }
        }

        return answer;
    }
}
