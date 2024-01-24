// 작성자 : 임현범

package koreait.test;

public class Bike extends Product {
    private int speed;

    public Bike (String prdName, int price, int speed) {
        super(prdName, price);
        this.speed = speed;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    public String ride() {
        return String.format("당신은 이것을 시속 %dkm로 탈 수 있습니다.", this.speed);
    }


    @Override
    public String sell(Object arg) {
        return String.format("[%s] 행사 - %d %% 인하", this.prdName, arg);
    }


    @Override
    public String toString() {
        return String.format("Bike %s [price = %d, speed = %d]", this.prdName, this.price, this.speed);
    }
    
}

class Electronics extends Product {
    private double kwh;

    public Electronics(String prdName, int price) {
        super(prdName, price);
    }


    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }


    public double power() {
        return this.kwh * 24;
    }


    @Override
    public String sell(Object arg) {
        return String.format("[%s] 증정 - %s", this.prdName, arg);
    }


    @Override
    public String toString() {
        return String.format("Electronics %s [price = %d, kwh = %f]", this.prdName, this.price, this.kwh);
    }

}