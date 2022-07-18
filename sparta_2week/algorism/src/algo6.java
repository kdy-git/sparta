import java.util.ArrayList;
import java.util.List;

public class algo6 {

    public static int solution(int[] numbers) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++) {
            list.add(numbers[i]);
            list.get(i);

        }
        for(int j=0; j<10; j++) {
            if(list.contains(j)) {

            }else {
                System.out.println("j = " + j);
                answer += j;
            }
        }


        return answer;
    }
}
