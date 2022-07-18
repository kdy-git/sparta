public class algo8 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double result = solution(arr);
        System.out.println("result = " + result);
    }

    public static double solution(int[] arr) {
        double answer = 0;
        double sum = 0;

            for (int i=0; i<arr.length; i++) {
                sum += arr[i];
                answer = sum/arr.length;
            }

        return answer;
    }
}
