package object.day6;

import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {
        MyClass4 my = new MyClass4();
        System.out.println("기본 생성자");
        System.out.println("\tmy field2 = " + my.getField2());

        MyClass4 my1 = new MyClass4(999);
        System.out.println("인자 1개 생성자");
        System.out.println("\tmy1 field2 = " + my1.getField2());

        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("인자 1개 생성자");
        System.out.println("\tmy2 field1 = " + my2.getField1());

        MyClass4 my3 = new MyClass4("HI", 100);
        System.out.println("인자 2개 생성자");
        System.out.println(String.format("\tmy3 field1 = %s, field2 = %d", my3.getField1(), my3.getField2()));

        double[] field3 = {1.2, 2.3, 3.4, 4.5};
        MyClass4 my4 = new MyClass4("Bye", 777, field3);
        System.out.println("인자 3개 생성자");
        System.out.println(String.format("\tmy4 field1 = %s, field2 = %d, field3 = %s", my4.getField1(), my4.getField2(), Arrays.toString(my4.getField3())));

        // 기본 생성자와 Setter가 없는 클래스 객체 생성
        MyClass5 my5 = new MyClass5("My Class 5", 31415, new double[3]);
        System.out.println("MyClass5 객체 확인");
        System.out.println("\tfield1 = " + my5.getField1());
        System.out.println("\tfield2 = " + my5.getField2());
        System.out.println("\tfield3 = " + Arrays.toString(my5.getField3()));

        // 생성자를 직접 정의하지 않은 클래스는 기본 생성자만 사용 가능합니다. e.g. MyClass3
        //      - 기본 생성자는 생략된 상태입니다.
        // 생성자를 직접 정의한 클래스는 직접 정의한 생성자만 사용 가능합니다. e.g. MyClass5
        //      - 따라서 생성자를 직접 정의할 때, 기본 생성자를 사용하고 싶다면 기본 생성자도 직접 정의해야 합니다. e.g. MyClass4
    }
}
