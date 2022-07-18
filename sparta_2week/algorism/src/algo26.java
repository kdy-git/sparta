import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class algo26 {

    public static void main(String[] args) {
        int[] arr = {10};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] arr) {

        int[] answer = {};

        int min = arr[0];

        List<Integer> list = new ArrayList<>(); // 배열값 arraylist 담아 배열의 마지막값 remove하면 되겠다고 생각했다. -->> ?? 문제를 잘못봤네 가장 작은수 제거였다니.. 마지막값 제거인줄 알았다 ㅠ

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int x : list) {
            min = Math.min(min, x);

        }
        for (int i = 0; i < list.size(); i++) {
            if (min == list.get(i)) {
                int a = i;
                list.remove(a);
            }
        }
        if (!list.isEmpty()) {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        } else {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

}


//        List<Integer> list = new ArrayList<>(); // 배열값 arraylist 담아 배열의 마지막값 remove하면 되겠다고 생각했다. -->> ?? 문제를 잘못봤네 가장 작은수 제거였다니.. 마지막값 제거인줄 알았다 ㅠ
//        if(!list.isEmpty()) {
//            answer = new int[arr.length-1];  --> 문제 잘못읽고 푼 코드들..
//            for(int y : list) {
//                answer[count] = y;
//                count++;
//            }
//        }else {
//            answer = new int[1];
//            answer[0] = -1;
//        }
