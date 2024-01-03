package basic.day4;

// 변수의 사용 위치에 따라 변수 사용 범위가 결정됩니다.

public class A21variableArea {
    int number = 999; // 1. 클래스 범위에서 사용 가능한 변수
    static int number2 = 99999;

    public static void main(String[] args) {
        int a = 23; // 2. main 메소드 범위에서 사용 가능한 변수

        for(int i = 0; i < 10; i++) { // 3. 선언된 블럭 안에서만 사용 가능한 변수
            System.out.println("i = " + i);
        }

        while (a == 23) {
            int count; // 3. 선언된 블럭 안에서만 사용 가능한 변수
            System.out.println("a = " + a);
            count = 100;
            System.out.println("count = " + count);
            // 종료 조건이 없으면 무한 반복(loop)
            a++;
        }

        System.out.println("a = " + a);
        // 이 지점에서 i, count는 알 수 없는 변수
        // System.out.println("i = " + i);
        // System.out.println("count = " + count);

        // main 메소드는 static 메소드입니다. static은 static 변수만 사용할 수 있습니다.
        // System.out.println("number = " + number); // number는 static 변수가 아니므로 static 메소드인 main에서 사용할 수 없습니다.
        System.out.println("number2 = " + number2);
    }
}
