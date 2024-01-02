package basic.day3;

public class A16MAXMinValueTest {
    public static void main(String[] args) {
        int n1 = 15, n2 = 12, n3 = 17;
        int max, min;

        System.out.println(String.format("n1 = %d, n2 = %d, n3 = %d", n1, n2, n3));

        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }

        if (max < n3) {
            max = n3;
        }

        if (min > n3) {
            min = n3;
        }

        System.out.println(String.format("최대값은 %d, 최소값은 %d", max, min));
    }
}
