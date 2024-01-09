package object.day8_interface;

public class B17MyClassBMain {
    public static void main(String[] args) {
        // 구현 클래스로 객체 생성
        MyClassB myB = new MyClassB();
        myB.methodA();
        System.out.println("myB.methodB(0): " + myB.methodB(0));
        System.out.println("myB.methodX(): " + myB.methodX());

        // 업캐스팅 가능합니다.
        InterfaceA ifa = new MyClassB();
        InterfaceX ifx = new MyClassB();
        ifa.methodA();
        // ifa.methodX(); // 다른 인터페이스의 추상 메소드이므로 실행 불가능
        // ifx.methodA(); // 다른 인터페이스의 추상 메소드이므로 실행 불가능
        System.out.println("ifx.methodX() : " + ifx.methodX());

        // 다운캐스팅 가능합니다.
        MyClassB tmp = (MyClassB)ifa;
        MyClassB temp = (MyClassB)ifx;
        tmp.methodA();
        System.out.println("tmp.methodX() : " + tmp.methodX());
        temp.methodA();
        System.out.println("temp.methodX() : " + temp.methodX());
    }
}
