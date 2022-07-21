package spring_assign;

import java.util.Scanner;

public class Transport {

    Scanner sc = new Scanner(System.in);

    int transNum;
    int speed = 0;
    int price;
    int passenger;
    int oil = 100;
    int used_oil;
    String destination;
    int distance;

    public Transport() {
    }

    public Transport(int transNum) {
        this.transNum = transNum;
    }

    public int busPrice(int price, int passenger) {
        this.price = price * passenger;
        return this.price;
    }

    public int texiPrice(int distance) {

        this.price = 3000 + 1000 * (distance - 1);

        return this.price;
    }

    public boolean drivePossible(int oil, int used_oil) {
        if (oil - used_oil < 10) {
            return true;
        } else {
            return false;
        }
    }

    public int remainPassenger(int maxPassenger, int passenger) {
        return maxPassenger - passenger;
    }

    public String busStatus(boolean status) {
        if (status) {
            return "상태 = 운행중";
        } else {
            return "상태 = 차고지행";
        }
    }
    public String texiStatus(int status) {
        if (status == 0) {
            return "상태 = 일반";
        } else if (status == 1) {
            return "상태 = 운행중";
        } else {
            return "상태 = 운행불가";
        }
    }



}
