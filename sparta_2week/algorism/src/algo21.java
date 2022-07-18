import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class algo21 {

    public static void main(String[] args) {
        String s = "hello world";
        String result = solution(s);
      System.out.println(result);
    }

    public static String solution(String s) {
        String answer = "";

        String[] words = s.split("");

        int count = 0;

        for (int i=0; i<words.length; i++) {
            if(words[i].equals(" ")){
                count = 0;
            }else {
                count++;
            }

            if(count % 2 == 0) {
                answer += words[i].toLowerCase();
            }else {
                answer += words[i].toUpperCase();
            }
        }
        return answer;
    }

}


// 처음 "hello world" 라는 단어를 split으로 짤라서 "hello" 와 "world"로 분리한 후 각각 포문을 다시돌려 "h,e,l,l,o" 와 "w, o, r, l, d" 와같이 스플릿으로 짤라주었다.
// 이렇게 했을때 테스트점수 70점정도 받을 수 있었고 뭐가 문제일까 생각해보다가 이중포문이 돌며 생기는 문제일수도 생각해서 for문을 하나만 쓸 방법을 생각해봤는데 그냥 단순히 "hello world"를 "h,e,l,l,o, ,w,o,r,l,d" 와같이 한번만 짤라서 if문을 통해 조건을 걸어주니 잘 실행되는걸 볼 수있었다.
// 이중for문 돌렸을때 안돼는 이유는 아직도 모르겠다
// toUpperCase와 toLowerCase는 string이 대상일떄와 char 대상일때 사용법이 조금 달랐다.
// String의 경우 변화를 원하는 변수 x에 x.toLowerCase(); 와 같이 사용할 수 있지만 char는 Character.toLowerCase(x); 와 같이 사용해야 했다.