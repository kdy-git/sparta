public class algo12 {
    public static void main(String[] args) {

        int a = 3;
        int b = 20;
        int c = 4;
        long e = solution(a, b, c);
        System.out.println(e);

    }

    public static long solution(int price, int money, int count) {
        long answer = -1;

//        int result = ((count * (count+1))/2)*price;
        long result = (((long) count * (count+1))/2)*price;

        if (result <= money) {
            answer = 0;
        }else {
            answer = result - money;
        }

        return answer;
    }
}
