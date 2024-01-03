package basic.day4;

// 구글드라이브 과제 폴더에 업로드
public class A25MySampleMethod {
    public static void main(String[] args) {
        int m = 3, n = 8, score = checkScore(10);

        System.out.println(String.format("점수: %d점.", score));
        System.out.println(String.format("sum1ToN(%d) : %d", n, sum1ToN(n)));
        System.out.println(String.format("multiply1ToN(%d) : %d", n, multiply1ToN(n)));
        System.out.println(String.format("sumMToN(%d, %d) : %d", m, n, sumMToN(m, n)));
        System.out.println(String.format("multiplyMToN(%d, %d) : %d", m, n, multiplyMToN(m, n)));
        System.out.println(String.format("multiplyNof2(%d) : %d", n, multiplyNof2(n)));
        System.out.println(String.format("multiplyNofM(%d, %d) : %d", m, n, multiplyNofM(m, n)));
        printGuGuDan(9, 9);
    }

    // 메소드가 private로 정의되면 다른 클래스에서 사용할 수 없습니다. => A26Test25.java에서 확인
    private static int checkScore(int n) {
        return n * 10;
    }

    // A22 1~5번을 각각 메소드로 정의해보기
    // 메소드 안에서 출력문 만들지 않기
    // 1. sum1ToN, 2. multiply1ToN 3. sumMToN, 4. multiplyMToN 5. multiplyNof2

    // 1부터 n까지의 합
    public static int sum1ToN(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    // 1부터 n까지의 곱
    public static long multiply1ToN(int n) {
        long result = 1L;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // m부터 n까지의 합
    public static int sumMToN(int m, int n) {
        int sum = 0;
        for(int i = m; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    // m부터 n까지의 곱
    public static long multiplyMToN(int m, int n) {
        long result = 1L;
        for(int i = m; i <= n; i++) {
            result *= i;
        }

        return result;
    }

    // 2의 n승
    public static long multiplyNof2(int n) {
        long result = 1L;
        for(int i = 1; i <= n; i++) {
            result *= 2;
        }

        return result;
    }

    // m의 n승
    public static long multiplyNofM(int m, int n) {
        long result = 1L;
        for(int i = 1; i <= n; i++) {
            result *= m;
        }

        return result;
    }

    // 구구단 출력 메소드
    public static void printGuGuDan(int d, int n) { // d: 단 수, n: 곱하는 수
        System.out.println("구구단");
        for(int i = 1; i <= n; i++) { // 곱하는 수
            for(int j = 1; j <= d; j++) { // 단 수
                System.out.print(String.format("%d x %d = %02d\t", j, i, i * j));
            }
            System.out.println();
        }
    }
}
