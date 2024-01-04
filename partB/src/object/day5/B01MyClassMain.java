package object.day5;

import java.util.Arrays;

public class B01MyClassMain {
    public static void main(String[] args) {
        // 정의된 클래스 MyClass1으로 객체를 만듭니다.
        // new 연산으로 MyClass1 객체를 저장할 메모리 확보
        MyClass1 my1 = new MyClass1(); // MyClass1() => 생성자 메소드 (무조건 클래스 이름과 동일).
        System.out.println("my1의 초기 해시코드 값 : " + my1.hashCode());

        System.out.println("my1.field1 : " + my1.field1); // String
        System.out.println("my1.field2 : " + my1.field2); // int
        System.out.println("my1.field3 : " + my1.field3); // double

        my1.field1 = "HI";
        my1.field2 = 999;
        my1.field3 = new double[5];

        System.out.println("필드 값 변경 후 my1의 해시코드 값 : " + my1.hashCode());

        System.out.println("my1.field1 : " + my1.field1);
        System.out.println("my1.field2 : " + my1.field2);
        System.out.println("my1.field3 : " + Arrays.toString(my1.field3));

        MyClass1 my2 = new MyClass1();
        System.out.println("\nmy2의 초기 해시코드 값 : " + my2.hashCode());

        my2.field1 = "점심 먹으러 갑시다.";
        my2.field2 = 12345;
        my2.field3 = new double[]{34.12, 24.99, 28.3};

        System.out.println("필드 값 변경 후 my2의 해시코드 값 : " + my2.hashCode());

        System.out.println("my2.field1 : " + my2.field1);
        System.out.println("my2.field2 : " + my2.field2);
        System.out.println("my2.field3 : " + Arrays.toString(my2.field3));
    }
}
