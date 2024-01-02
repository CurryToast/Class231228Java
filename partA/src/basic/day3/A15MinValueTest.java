package basic.day3;

public class A15MinValueTest {
    public static void main(String[] args) {
        int n1 = 19, n2 = 12, n3 = 17;
        int min;

        System.out.println(String.format("n1 = %d, n2 = %d, n3 = %d", n1, n2, n3));

        // if 문
        // if (n1 > n2) {
        //     min = n2;
        // } else {
        //     min = n1;
        // }

        // if (min > n3) {
        //     min = n3;
        // }

        // 3항 연산자
        min = (n1 > n2) ? n2 : n1;
        System.out.println(String.format("최소값은 %d", ((min < n3) ? min : n3)));
    }
}
