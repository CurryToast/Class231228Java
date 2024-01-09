package object.day8;

import object.day7.Diamond;

/*
 * 모든 자바 클래스의 부모는 Object 타입
 */

public class B14ObjectTest {
    public static void main(String[] args) {
        Object ob1 = new String("Hello Java~");
        Object ob2 = new Diamond();
        Object ob3 = 3; // int형 변수가 Integer 객체로 변경 => Object로 참조
        // 기본형 타입은 Wrapper 클래스로, 객체로 변경되서 Object로 업캐스팅
        //                      ㄴ Byte, Character, Short, Integer, Long, Float, Double

        // Object  클래스의 메소드 - 모든 자바 클래스가 상속받고 있습니다.

        System.out.println("getClass는 클래스의 타입 정보를 리턴합니다. ");
        // getName은 클래스 타입 정보 중 클래스 이름 리턴
        System.out.println("\tob1.getClass = " + ob1.getClass().getName());
        System.out.println("\tob2.getClass = " + ob2.getClass().getName());
        System.out.println("\tob3.getClass = " + ob3.getClass().getName());
        System.out.println();

        System.out.println("hashCode는 객체의 참조 값(식별 값)을 리턴합니다. ");
        System.out.println("\tob1.hashCode = " + ob1.hashCode() + ", " + Integer.toHexString(ob1.hashCode()));
        System.out.println("\tob2.hashCode = " + ob2.hashCode() + ", " + Integer.toHexString(ob2.hashCode()));
        System.out.println("\tob3.hashCode = " + ob3.hashCode() + ", " + Integer.toHexString(ob3.hashCode()));
        System.out.println();

        System.out.println("toString 확인");
        System.out.println("\tob1.toString = " + ob1.toString()); // String은 toString 재정의
        System.out.println("\tob1 = " + ob1); // toString 메소드는 생략하고 쓸 수 있습니다.
        System.out.println("\tob2.toString = " + ob2.toString()); // Object toString의 기본값 출력
        System.out.println("\tob2 = " + ob2);
        System.out.println("\tob3.toString = " + ob3.toString()); // Integer는 toString 재정의
        System.out.println("\tob3 = " + ob3);
    }
}
