package object.test;

import java.util.Arrays;

public class RandomArraySum {
    public static void main(String[] args) {
        int size = 5, sum = 0;
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        double average;

        for (int i = 0; i < size; i++) {
            arr1[i] = (int)(Math.random()*99) + 1;
            arr2[i] = (int)(Math.random()*99) + 1;

            sum += Math.max(arr1[i], arr2[i]);
        }

        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("arr2 : " + Arrays.toString(arr2));

        average = (double)sum / size;
        System.out.println("average : " + average);
    }
}
