public class algo20 {
    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"leo", "eden"};
        String result = solution(participant, completion);
        System.out.println(result);

    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        String dupl = "";


        // 동명이인이 있는지, 있다면 몇명있는지 확인하는 코드
        for(int i=0; i < participant.length; i++) {
            for(int j=0; j<participant.length; j++) {
                if(participant[i].equals(participant[j])) {
                    count++;
                }
            }
            if(count >= 2) {
                dupl = participant[i];
                break;
            }else {
                count = 0; // count 0으로 해주지않으면 다음 싸이클 돌릴때 1혹은 2부터 시작할 수 있음. 2가되면 중복에 걸리기때문에 0으로 초기화시켜줘야함
            }
        }
        // 동명이인이 모두 완주했을 경우 완주하지 못한사람 찾기 + 모두 완주하지 못했다면 무조건 answer는 동명이인중 한명
        for(int i=0; i<completion.length; i++) {
            if(completion[i].equals(dupl)) {
                count2++;
            }

        }
        if(count==count2) {
            for(int i=0; i<participant.length; i++) {
                for(int j=0; j<completion.length; j++) {
                    if(!participant[i].equals(completion[j])) {
                        count3++;
                    }
                }
                if(count3 == completion.length) {
                    answer = participant[i];
                    break;
                }else {
                    count3 = 0;
                }
            }
        }else {
            answer = dupl;
        }

        return answer;
    }
}
