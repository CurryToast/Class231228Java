package object.test;

import java.util.Arrays;
import java.util.Scanner;

public class StringDescendingSortTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message;

        System.out.print("문자열(영문) 입력 >>> ");
        message = sc.nextLine();
        Character[] messageArray = new Character[message.length()];
        for (int i = 0; i < message.length(); i++) {
            messageArray[i] = message.charAt(i);
        }

        Arrays.sort(messageArray, (c1, c2) -> {
            return c2.compareTo(c1);
        });

        for (Character c : messageArray) {
            System.out.print(c);
        }

        sc.close();
    }
}
