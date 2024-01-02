package basic.day3;

public class A14MAXValueTest {
    public static void main(String[] args) {
        int n1 = 10, n2 = 12, n3 = 17;
        int max;

        System.out.println(String.format("n1 = %d, n2 = %d, n3 = %d", n1, n2, n3));

        // if문
        // if (n1 > n2) {
        //     max = n1;
        // } else {
        //     max = n2;
        // }

        // if (max < n3) {
        //     max = n3;
        // }

        // 3항 연산자
        max = (n1 > n2) ? n1 : n2;
        System.out.println(String.format("최대값은 %d", ((max < n3) ? n3 : max)));
    }
}
