public class algo22 {

    public static void main(String[] args) {
        int n = 123;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int answer = 0;

        String number = Integer.toString(n);

        String[] arr = number.split("");

        for(String s : arr)  {
             answer += Integer.parseInt(s);
        }

        return answer;
    }
}

// 이건 팀원이 나머지를 이용하는 방법을 써서 푸는걸 봤기때문에 나는 단어를 분리해서 풀어봤다
// Enhanced for문을 처음 사용해봤음. 적응될때까지 계속 사용해볼 생각
// Integer class의 parse와 toString 이용하니 타입변환이 쉬웠다