public class algo25 {
    public static void main(String[] args) {
        long n = 9;
        long result = solution(n);
        System.out.println(result);
    }

    public static long solution(long n) {
        long answer = 0;

        for(long i=1; i<=n; i++) {
            if(i*i == n) {
                answer = (i+1)*(i+1);
                break;
            }else{
                answer = -1;
            }
        }
        return answer;
    }

}
