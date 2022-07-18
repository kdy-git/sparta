package project_2week_test;

public class Bus {

    public Bus() {}

    public Bus(int busNum) {
        this.busNum = busNum;
    }

    int busNum;
    int price;
    int passenger;


    public void takeBus(int price, int passenger) {
        this.passenger = passenger;
        this.price = price * passenger;
    }


}