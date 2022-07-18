package project_2week_test;

import java.util.Scanner;

public class publicTransport {

    static boolean status = true;

    public static void main(String[] args) {
        bus();
    }

    static void bus() {

        project_2week_test.Bus bus = new project_2week_test.Bus();
        project_2week_test.Bus bus100 = new project_2week_test.Bus(100);
        project_2week_test.Bus bus200 = new project_2week_test.Bus(200);

        System.out.println("버스1 = " + bus100);
        System.out.println("버스2 = " + bus200);
        System.out.println("-----------------------");

        Scanner sc = new Scanner(System.in);

        System.out.print("탑승할 승객 수 : ");
        int passenger_num = sc.nextInt();
        int max_passenger = 30;
        int oil = 100;


        if (max_passenger < passenger_num) {
            System.out.println("최대 승객 수 초과");
            return;
        } else {
            bus.takeBus(1000, passenger_num);
            System.out.println("탑승 승객수 = " + passenger_num);
            System.out.println("잔여 승객수 = " + (max_passenger - passenger_num));
            System.out.println("요금 확인 = " + bus.price);
            status = false;
        }

        System.out.println("-----------------------");
        System.out.print("사용한 기름 : ");
        int used_oil = sc.nextInt();
        oil = oil - used_oil;
        System.out.println("현재 주유량 = " + oil);
        System.out.println("-----------------------");

        if (status) {
            System.out.println("운행상태 : 운행중");
            System.out.println("현재 주유량 = " + oil);
        } else {
            System.out.println("운행상태 : 차고지행");
            oil = oil + 10;
            System.out.println("현재 주유량 = " + oil);
            status = true;
            System.out.println("-----------------------");

            System.out.print("탑승할 승객 수 : ");
            int passenger_num_2 = sc.nextInt();
            if (max_passenger < passenger_num_2) {
                System.out.println("최대 승객 수 초과");
                System.out.print("탑승할 승객 수 : ");
                int passenger_num_3 = sc.nextInt();

                bus.takeBus(1000, passenger_num_3);
                System.out.println("탑승 승객수 = " + passenger_num_3);
                System.out.println("잔여 승객수 = " + (max_passenger - passenger_num_3));
                System.out.println("요금 확인 = " + bus.price);
                status = false;

                System.out.print("사용된 기름 :");
                int used_oil_2 = sc.nextInt();
                oil = oil - used_oil_2;
                System.out.println("현재 주유량 :" + oil);
                if (!status) System.out.println("차고지행");
                if (oil < 10) {
                    System.out.println("주유 필요");
                }

            } else {
                bus.takeBus(1000, passenger_num_2);
                System.out.println("탑승 승객수 = " + passenger_num_2);
                System.out.println("잔여 승객수 = " + (max_passenger - passenger_num_2));
                System.out.println("요금 확인 = " + bus.price);
                status = false;

                System.out.print("사용된 기름 :");
                int used_oil_2 = sc.nextInt();
                oil = oil - used_oil_2;
                System.out.println("현재 주유량 :" + oil);
                if (!status) System.out.println("차고지행");
                if (oil < 10) {
                    System.out.println("주유 필요");
                }
            }
        }
    }
}
