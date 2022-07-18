public class algo10 {

    public static void main(String[] args) {
        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        int[][] result = solution(arr1, arr2);
        System.out.println("result = " + result);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
            return answer;
    }
}


// answer 의 배열크기를 지정해주지않으니 Index 0 out of bounds for length 0 이라는 에러 발생.
// 배열의 크기를 각각 지정해주니 정상 작동함