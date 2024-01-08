package object.test;

import object.day7.Diamond;

public class B11DiamondTest {
    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 너비 : " + diamond.getWidth());
        System.out.println("다이아몬드 높이 : " + diamond.getHeight());
        System.out.println("다이아몬드 넓이 : " + diamond.calculateArea());
        diamond.print();

        // diamond.round = 314; // B11DiamondTest는 상속받은 자식클래스가 아님
        // diamond.etc = "test"; // Shape과 같은 패키지가 아님
        diamond.setRound(100); // setRound 메소드가 public이어서 실행 가능
    }
}
