import java.util.Scanner;

public class algo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String star = "*";

        for(int j=1; j<=b; j++) {
            for(int i=1; i<=a; i++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
