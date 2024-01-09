package object.day8_interface;

public class B16MyClassAMain {
    public static void main(String[] args) {
        // 구현 클래스로 객체 생성
        MyClassA myA = new MyClassA();
        myA.methodA();
        // 업캐스팅 가능합니다.
        InterfaceA ifa = new MyClassA();
        ifa.methodA();
        // 다운캐스팅 가능합니다.
        MyClassA temp = (MyClassA)ifa;
        temp.methodA();
    }
}
