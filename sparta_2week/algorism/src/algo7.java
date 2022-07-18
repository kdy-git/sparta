public class algo7 {

    public static void main(String[] args) {

        int[] a = {4,7,12};
        boolean[] b = {true, false, true};
        int c = solution(a, b);
        System.out.println("c = " + c);

    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++) {
            if(signs[i] == true) {
                answer += absolutes[i];
            }else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

}
