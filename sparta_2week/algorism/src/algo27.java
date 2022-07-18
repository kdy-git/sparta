public class algo27 {

    public static void main(String[] args) {
        int num = 626331;
        int result = solution(num);
        System.out.println(result);
    }

    public static int solution(long num) {
        // int면 488이라는 숫자가 나와 오류가 뜨는데 long으로 하면 -1이 된다.
        // 예상해보자면 계산을 하다가 중간에 num에 대입되는 값이 int 허용범위를 초과해 최대범위 수에서 더 이상 늘어나지 않는것이다.
        // 그래서 488번째에 1을 출력할 수 있는건가?.. 잘모르겠다 다른사람 푼거보면 int로 푼것도 있는데 좀 더 생각해봐야 할 거 같다.
        int answer = 0;

        if(num != 1) {
            for(int i=0; i<501; i++) {
                if(num%2==0) {
                    num = num/2;
                    if(num == 1) {
                        answer = i+1;
                        break;
                    }
                }else {
                    num = 3*num + 1;
                    if(num == 1) {
                        answer = i+1;
                        break;
                    }
                }
                if(i==500) {
                    answer = -1;
                }
            }
        }
        return answer;
    }
}
