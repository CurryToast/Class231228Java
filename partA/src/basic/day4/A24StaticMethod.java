package basic.day4;

public class A24StaticMethod {
    /*
     * 메소드를 만드는 목적
     *  - 특정 처리 기능을 main에서 따로 분리하기
     *  - 한번 만들어진 메소드를 여러 번 필요할 때 사용하기 위해
     */

    public static void main(String[] args) {
        // 메소드 호출. 이름과 형식이 맞는 메소드를 찾아서 실행합니다.
        argumentTest();
        argumentTest(999);
        argumentTest(100, 333);
        // argumentTest("100", 333);

        System.out.println("resultIntTest()의 리턴값: " + resultIntTest());
        System.out.println("resultIntTest(1)의 리턴값: " + resultIntTest(1));
        System.out.println("resultIntTest(4, 5)의 리턴값: " + resultIntTest(4, 5));
        System.out.println("resultBooleanTest()의 리턴값: " + resultBooleanTest());
        System.out.println("resultBooleanTest(2)의 리턴값: " + resultBooleanTest(2));
        System.out.println("resultBooleanTest(4, 5)의 리턴값: " + resultBooleanTest(4, 5));
        System.out.println("resultStringTest()의 리턴값: " + resultStringTest());
        System.out.println("resultStringTest(\"Hello11\")의 리턴값: " + resultStringTest("Hello11"));
        System.out.println("resultCharTest()의 리턴값: " + resultCharTest());

        System.out.println("add(1, 2, 3)의 리턴 값: " + add(1, 2, 3));
        System.out.println(("add(1.1, 2.2, 3.3)의 리턴 값: " + add(1.1, 2.2, 3.3)));
    }

    // 1) 인자가 없는 메소드
    public static void argumentTest() {
        System.out.println("인자가 없는 메소드입니다.");
    }

    // 2) 인자가 1개인 메소드
    public static void argumentTest(int i) {
        System.out.println(String.format("인자가 1개 정수 %d 입니다.", i));
    }

    // 3) 인자가 2개인 메소드
    public static void argumentTest(int i, int j) {
        System.out.println(String.format("인자가 2개 정수 i = %d, j = %d 입니다.\ni + j = %d.", i, j, (i + j)));
    }

    // 4) 리턴값이 int인 메소드
    public static int resultIntTest() {
        return 999;
    }
    public static int resultIntTest(int a) {
        return a * 9;
    }
    public static int resultIntTest(int a, int b) {
        return a + b;
    }

    // 5) 리턴값이 boolean인 메소드
    public static boolean resultBooleanTest() {
        return false;
    }
    public static boolean resultBooleanTest(int n) {
        return (n > 0);
    }
    public static boolean resultBooleanTest(int n, int m) {
        return (n == m);
    }

    // 6) 리턴값이 String인 메소드
    public static String resultStringTest() {
        return "Hello";
    }
    public static String resultStringTest(String message) {
        int upperCount = 0, lowerCount = 0, numberCount = 0, symbolCount = 0;

        for (int i = 0; i < message.length(); i++) {
            char item = message.charAt(i);

            if (item >= 48 && item <= 57) { // 숫자일때
                numberCount++;
            } else if (item >= 65 && item <= 90) { // 대문자일때
                upperCount++;
            } else if (item >= 97 && item <= 122) { // 소문자일때
                lowerCount++;
            } else { // 기호일때
                symbolCount++;
            }
        }

        return String.format("문자열: %s,  문자 종류: 대문자 %d개, 소문자 %d개, 숫자 %d개, 기호 %d개", message, upperCount, lowerCount, numberCount, symbolCount);
    }

    // 7) 리턴값이 char인 메소드
    public static char resultCharTest() {
        return 'A';
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static double add(double a, double b, double c) {
        return a + b + c;
    }
}
