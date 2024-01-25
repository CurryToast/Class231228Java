package koreait.solution;

// 객체의 구성 요소 : 인스턴스 필드와 인스턴스 메소드
// 클래스 구성 요소 : 객체의 구성 요소 + static 메소드와 필드
// 클래스는 객체가 만들어지는 인스턴스 요소를 정의하는 상위 개념
public class Bike extends Product {
    // 4
    private int speed;

    // 3
    public Bike(int price, String prdName, int speed) {
        //super(); // 자식 클래스는 부모 생성자를 반드시 호출한다. super는 생략 가능

        // price와 prdName은 protected 필드이므로 자식은 직접 접근 가능합니다.
        this.price = price;
        this.prdName = prdName;
        this.speed = speed;
    }

    // 8
    // 추상클래스를 상속받았으므로 반드시 추상메소드를 구현(재정의)해야 합니다.
    public String sell(Object object) {
        return String.format("[%s]행사 - %d %% 인하", this.prdName, object);
    }

    // 4
    public int getSpeed() {
        return speed;
    }

    // 4
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 5
    // getter, setter, ride 메소드 : 인스턴스 필드를 대상으로 처리 기능을 갖습니다 => 인스턴스 메소드
    public String ride() {
        // this는 생략 가능하나, speed가 객체의 필드 변수라는 것을 가독성 있게 해줍니다.
        return "당신은 이것을 시속 " + this.speed + "km로 탈 수 있습니다.";
    }

    // 10
    // Product에서 재정의한 toString을 다시 자식클래스에서 재정의합니다.
    @Override
    public String toString() {
        return "Bike [" + super.toString() + ", speed=" + speed + "]";
    }
}

class Electronics extends Product {
    // 6
    private double kwh;

    // 3
    public Electronics(int price, String prdName) {
        this.price = price;
        this.prdName = prdName;
    }

    // 9
    public String sell(Object object) {
        return String.format("[%s] 증정 - %s", this.prdName, object);
    }

    // 6
    public double getKwh() {
        return kwh;
    }

    // 6
    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    // 7
    public double power() {
        return this.kwh * 24;
    }

    // 10
    @Override
    public String toString() {
        return "Electronics [" + super.toString() + ", kwh = " + kwh + "]";
    }
}
