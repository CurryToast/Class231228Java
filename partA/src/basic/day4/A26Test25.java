package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        // A25 클래스에서 만든 메소드를 사용할 수 있습니다.
        int result = A25MySampleMethod.sumMToN(10, 13);
        System.out.println(result);

        // 메소드가 private로 정의되면 다른 클래스에서 사용할 수 없습니다.
        // A25MySampleMethod.checkScore(10);

        Scanner sc = new Scanner(System.in);
        System.out.print("시작값 >>> ");
        int start = sc.nextInt();
        System.out.print("끝값 >>> ");
        int end = sc.nextInt();

        System.out.println(String.format("%d부터 %d까지의 정수들의 합은 %d.", start, end, A25MySampleMethod.sumMToN(start, end)));
    }
}
