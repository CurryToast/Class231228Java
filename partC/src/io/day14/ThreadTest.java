package io.day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest {

    public static void main(String[] args) {
        // 실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        // 0.2초마다 1번씩 . 출력하기 => 쓰레드로 만듭니다.
        // 1) Thread 클래스 상속받기       2) Runnable 인터페이스 구현하기

        // 쓰레드가 할 일을 인터페이스 활용하여 정의합니다. => 익명 클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() { // 쓰레드가 할 일을 여기에 작성하세요.
                boolean run = true;
                while (run) {
                    System.out.print(".");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) { // 인터럽트 발생 시
                        run = false;
                    }
                }
            }
        };

        // 쓰레드 생성하기
        Thread thread = new Thread(runnable);

        // 쓰레드 실행하기
        thread.start();

        copyByByteTimeCount(thread);
    }

    public static void copyByByte() {
        int b, count = 0;

        try (
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\image.jpg");
            FileOutputStream fos = new FileOutputStream("imageCopy.jpg");
        ) {
            while((b=fis.read()) != -1){
                fos.write(b);
                count++;
            }
        } catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }

        System.out.println(String.format("\n복사한 파일 크기 : %,d 바이트", count));
    }

    public static void copyByByteTimeCount(Thread thread) {
        long start = System.nanoTime();

        copyByByte();

        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns", (end - start)));

        // 쓰레드 종료를 위해 인터럽트 발생시키기
        thread.interrupt();
    }

}
