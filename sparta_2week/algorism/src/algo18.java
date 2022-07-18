public class algo18 {

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        String result = solution(seoul);
        System.out.println(result);
    }

    public static String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }
}


// 문자열 비교는 equals 이용
// for문 돌리고 김서방을 찾았을때 break 걸지 않으면 이미 찾은 상태여도 끝까지 배열이 돌기 떄문에 걸어주는게 좋다.
