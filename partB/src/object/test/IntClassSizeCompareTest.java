package object.test;

import java.util.Arrays;
import java.util.Scanner;

public class IntClassSizeCompareTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntClassSizeCompare[] arr = new IntClassSizeCompare[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("정수 입력 >>> ");
            arr[i] = new IntClassSizeCompare(i, Integer.parseInt(sc.nextLine()));
        }

        System.out.print("정렬 전 배열 : ");
        for (IntClassSizeCompare item : arr) {
            System.out.print(item.toString());
        }
        System.out.println();

        Arrays.sort(arr);

        System.out.print("정렬 전 배열 : ");
        for (IntClassSizeCompare item : arr) {
            System.out.print(item.toString());
        }
    }
}
