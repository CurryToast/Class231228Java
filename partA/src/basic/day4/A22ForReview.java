package basic.day4;

public class A22ForReview {
    public static void main(String[] args) {
        int m = 5, n = 10, sum = 0;
        long result = 1; // 곱셈의 결과를 저장할 변수. int 타입은 -2147483648 ~ +2147483647. 그래서 큰 값이 나올 경우를 생각해서 long 타입으로 선언

        // 1. 1부터 정수 n까지 더하기
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(String.format("1부터 %d까지의 정수들의 합은 %,d.", n, sum));

        // 2. 1부터 정수 n까지 곱하기
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(String.format("1부터 %d까지의 정수들의 곱은 %,d.", n, result));

        // 3. 시작값 정수 m부터부터 끝값 n까지 더하기
        sum = 0;
        for (int i = m; i <= n; i++) {
            sum += i;
        }
        System.out.println(String.format("%d부터 %d까지의 정수들의 합은 %,d.", m, n, sum));

        // 4. 시작값 정수 m부터부터 끝값 n까지 곱하기
        result = 1;
        for (int i = m; i <= n; i++) {
            result *= i;
        }
        System.out.println(String.format("%d부터 %d까지의 정수들의 곱은 %,d.", m, n, result));

        // 5. 2의 n승 구하기
        result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 2;
        }
        System.out.println(String.format("2의 %d승은 %,d.", n, result));
    }
}
