package spring_assign;
import java.util.Scanner;

public class texi {
    static Scanner sc = new Scanner(System.in);
    static int maxPassenger = 4;
    static int bgr_price = 3000;
    static int today_money = 0;
    static int speed = 0;
    static int speed2 = 0;


    public static void main(String[] args) {
        Transport ts = new Transport();
        Transport texiNum1 = new Transport(1);
        Transport texiNum2 = new Transport(2);

        System.out.println("-----------------------------------------");
        System.out.println("TEXI1 = " + texiNum1);
        System.out.println("TEXI2 = " + texiNum2);
        System.out.println("주유량 = " + ts.oil);
        System.out.println(ts.texiStatus(0));
        System.out.println("-----------------------------------------");

        while (true) {
            System.out.print("탑승할 승객 수 = ");
            ts.passenger = sc.nextInt();

            if(ts.passenger <= maxPassenger) {
                System.out.print("목적지 = ");
                ts.destination = sc.next();
                System.out.print("목적지까지 거리 = ");
                ts.distance = sc.nextInt();

                System.out.println("(현재속도 = " + speed +"km/h)");
                System.out.print("올릴/내릴 속도 입력 = ");
                ts.speed = sc.nextInt();

                while (true) {
                    if(ts.speed <= 0) {
                        System.out.println(ts.speed + "km 로는 운행할 수 없습니다");
                        System.out.println("-----------------");
                        System.out.println("(현재속도 = " + speed +"km/h)");
                        System.out.print("올릴/내릴 속도 입력 = ");
                        ts.speed = sc.nextInt();
                        System.out.println("-----------------");

                        if(ts.speed> 0) {
                            System.out.println("현재속도 = " + ts.speed +"km/h");
                            System.out.println("-----------------");
                            break;
                        }
                    }else {
                        System.out.println("-----------------");
                        System.out.println("현재속도 = " + ts.speed +"km");
                        System.out.println("-----------------");
                        break;
                    }
                }
                speed += ts.speed;
                speed2 += ts.speed;

                System.out.println("탑승 승객 수 = " + ts.passenger);
                System.out.println("잔여 승객 수 = " + ts.remainPassenger(maxPassenger, ts.passenger));
                System.out.println("기본 요금 확인 = " + bgr_price);
                System.out.println("목적지 = " + ts.destination);
                System.out.println("목적지까지 거리 = " + ts.distance + "km");
                System.out.println("지불할 요금 = " + ts.texiPrice(ts.distance)+"원");
                System.out.println(ts.texiStatus(1));
                System.out.println("-----------------");
                System.out.print("올릴/내릴 속도 입력 = ");
                ts.speed = sc.nextInt();
                speed += ts.speed;

                while (true) {
                    if(speed <= 0) {
                        System.out.println(speed + "km 로는 운행할 수 없습니다");
                        System.out.println("-----------------");
                        System.out.println("(현재속도 = " + speed2 +"km/h)");
                        System.out.print("올릴/내릴 속도 입력 = ");
                        ts.speed = sc.nextInt();
                        System.out.println("-----------------");

                        speed2 += ts.speed;

                        if(speed2 > 0) {
                            System.out.println("현재속도 = " + speed2 +"km");
                            System.out.println("-----------------");
                            break;
                        }
                    }else {
                        System.out.println("-----------------");
                        System.out.println("현재속도 = " + speed +"km");
                        System.out.println("-----------------");
                        break;
                    }

                }
                System.out.print("사용된 오일의 양 = ");
                ts.used_oil = sc.nextInt();
                while (ts.used_oil <= 0) {
                    System.out.println("0또는 음수를 입력할 수 없습니다.");
                    System.out.println("-----------------");
                    System.out.print("사용된 오일의 양 = ");
                    ts.used_oil = sc.nextInt();
                    if(ts.used_oil > 0) {
                        break;
                    }
                }
                int remain_oil = ts.oil - ts.used_oil;
                System.out.println("남은 주유량 = " + remain_oil);
                today_money += ts.price;
                ts.speed = 0;
                speed = 0;
                System.out.println("누적 요금 = " + today_money+"원");
                ts.oil = remain_oil;
                System.out.println("-----------------");

                if(ts.oil <= 0) {
                    System.out.println("주유량 = " + remain_oil);
                    System.out.println(ts.texiStatus(2));
                    System.out.println("★주유 필요★");
                    System.out.println("누적 요금 = " + today_money+"원");
                    break;
                }
            }else {
                System.out.println("★최대 승객 수 초과★");
                System.out.println("-----------------");
            }
        }
    }
}