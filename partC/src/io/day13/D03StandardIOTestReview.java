package io.day13;

import java.io.IOException;

public class D03StandardIOTestReview {

    public static void main(String[] args) {
        int b;
        System.out.println("입력하세요. ↓ ");
        //표준입출력은 모든 글자가 2바이트.=> 윈도우 터미널 인코딩 방식
        try {
            b=System.in.read();
            System.out.println(Integer.toHexString(b));

            b=System.in.read();
            System.out.println(Integer.toHexString(b));


            b=System.in.read();
            System.out.println(Integer.toHexString(b));


            b=System.in.read();
            System.out.println(Integer.toHexString(b));

            b=System.in.read();
            System.out.println(Integer.toHexString(b));


            b=System.in.read();
            System.out.println(Integer.toHexString(b));
        } catch(IOException e){
            System.out.println("예외 : " + e.getMessage());
        }

    }
}