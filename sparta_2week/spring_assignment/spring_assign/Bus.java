package spring_assign;
import java.util.Scanner;

public class Bus {
    static int maxPassenger = 30;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Transport ts = new Transport();
        Transport busNum1 = new Transport(100);
        Transport busNum2 = new Transport(200);

        System.out.println("BUS1 : " + busNum1);
        System.out.println("BUS2 : " + busNum2);  // 참조변수가 다르니 다른버스(?)
        System.out.println("------------------------------------");

        while (true) {
            System.out.print("탑승할 승객 수 : ");
            ts.passenger = sc.nextInt();
            System.out.println("-----------------");

            if(ts.passenger <= maxPassenger) {
                System.out.println(ts.busStatus(true));
                System.out.println("-----------------");
                System.out.println("탑승 승객 수 : " + ts.passenger);
                System.out.println("잔여 승객 수 : " + ts.remainPassenger(maxPassenger, ts.passenger));
                System.out.println("요금 확인 : " + ts.busPrice(1000, ts.passenger));
                System.out.println("-----------------");

                System.out.print("사용된 오일의 양 : ");
                ts.used_oil = sc.nextInt();
                int remain_oil = ts.oil - ts.used_oil;
                System.out.println("남은 주유량 : " + remain_oil);
                System.out.println("-----------------");

                if(ts.drivePossible(ts.oil, ts.used_oil)) {
                    System.out.println(ts.busStatus(false));
                    System.out.println("★주유 필요★");
                    break;
                }

                System.out.println(ts.busStatus(false));
                ts.oil = remain_oil + 10;
                System.out.println("남은 주유량 : " + ts.oil);
            } else {

                System.out.println("★최대 승객 수 초과★");
            }
            System.out.println("-----------------");
        }
    }

}
