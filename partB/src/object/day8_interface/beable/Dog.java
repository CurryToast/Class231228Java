package object.day8_interface.beable;

public class Dog implements Runnable {

    @Override
    public String run(int speed) {
        return "아마도 강아지는 " + speed + " km/h로 달립니다. 최고 속도는 1000km/h.";
    }

    @Override
    public String beAble() {
        return "멍멍!";
    }
    
}
