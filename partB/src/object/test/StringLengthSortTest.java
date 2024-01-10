package object.test;

import java.util.Arrays;
import java.util.Scanner;

public class StringLengthSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] messages = new String[10];
        for (int i = 0; i < messages.length; i++) {
            messages[i] = sc.nextLine();
        }

        System.out.println("정렬 전 배열 : " + Arrays.toString(messages));
        for(int i = 0; i < messages.length - 1; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (messages[i].length() < messages[j].length()) {
                    String temp;
                    temp = messages[j];
                    messages[j] = messages[i];
                    messages[i] = temp;
                }
            }
        }

        System.out.println("정렬 후 배열 : " + Arrays.toString(messages));
    }
}
