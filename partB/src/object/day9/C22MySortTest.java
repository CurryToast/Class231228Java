package object.day9;

import java.util.Arrays;

// 순차정렬 알고리즘 구현하기
public class C22MySortTest {
    public static void main(String[] args) {
        int[] numbers = {67, 34, 65, 89, 54};
        System.out.println("오름차순");
        System.out.println("\t초기 numbers = " + Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int temp;
                if (numbers[i] > numbers[j]) {
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println("\t정렬 후 numbers = " + Arrays.toString(numbers) + "\n");

        System.out.println("내림차순");
        System.out.println("\t초기 numbers = " + Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int temp;
                if (numbers[i] < numbers[j]) {
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println("\t정렬 후 numbers = " + Arrays.toString(numbers));
    }
}
