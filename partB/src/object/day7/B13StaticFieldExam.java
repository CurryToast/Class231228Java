package object.day7;

import object.test.Square;

// 대표적인 자바 클래스 static 필드 확인해보기

public class B13StaticFieldExam {
    public static void main(String[] args) {
        // Wrapper 클래스 : 기본 자료형을 클래스 타입, 즉 객체로 다룰 수 있게 해줍니다.
        // Integer
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);
        System.out.println("Integer.BYTES = " + Integer.BYTES);

        // Long
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.SIZE = " + Long.SIZE);
        System.out.println("Long.BYTES = " + Long.BYTES);

        // Double
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.SIZE = " + Double.SIZE);
        System.out.println("Double.BYTES = " + Double.BYTES);

        // Character
        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
        System.out.println("Character.MAX_VALUE = " + (int)Character.MAX_VALUE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println("Character.MIN_VALUE = " + (int)Character.MIN_VALUE);
        System.out.println("Character.SIZE = " + Character.SIZE);
        System.out.println("Character.BYTES = " + Character.BYTES);

        System.out.println("Shape.MAX_WIDTH = " + Shape.MAX_WIDTH);
        System.out.println("Triangle.MAX_WIDTH = " + Triangle.MAX_WIDTH);
        System.out.println("Diamond.MAX_WIDTH = " + Diamond.MAX_WIDTH);
        System.out.println("Square.MAX_WIDTH = " + Square.MAX_WIDTH);
    }
}

/*
 * 위의 모든 필드들은 public static final
 * public: 모두에게 공개
 * static: 객체 없이 클래스 이름으로 사용할 수 있는 정적인 필드 => 메모리 공유 영역에 모여서 저장됨
 * final
 *   ㄴ필드 : 값을 변경할 수 없음
 *   ㄴ메소드 : 재정의(오버라이드)할 수 없음
 *   ㄴfinal은 다른 것들보다는 대부분 static과 같이 씀
 *   ㄴ영원히 고정되는 값에 대해 기호를 부여하는 '상수'의 개념 => '상수'는 상속의 의미가 없음
 *   ㄴ모두 대문자로 사용하도록 약속되어 있음
 */