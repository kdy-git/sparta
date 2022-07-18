public class algo15 {

    public static void main(String[] args) throws Exception {

        int[] a = {-3, -1, 0, -2};
        int[] b = {1,0,-1, -2};
        int c = solution(a, b);
        System.out.println("c = " + c);

    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i<a.length; i++) {
           answer += a[i]*b[i];
        }
        return answer;
    }

}
