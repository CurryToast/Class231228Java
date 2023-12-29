package basic.day2;

public class A08PreViewTest {
    public static void main(String[] args) {
        char start = 'A';

        // 반복문 while
        while(start <= 'Z') {
            System.out.print(start++);
        }

        System.out.println();

        while (start > 'A') {
            System.out.print(--start);
        }
    }
}
