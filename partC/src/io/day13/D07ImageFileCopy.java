package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        copyByByteTimeCount();
        copyByByteArrayTimeCount();
        copyByBufferTimeCount();
    }

    public static void copyByByte() {
        int b, count = 0;

        try (
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\image.jpg");
            FileOutputStream fos = new FileOutputStream("imageCopy.jpg");
        ) {
            while((b=fis.read()) != -1){ // 1바이트 씩 복사하기(파일fis에서 파일fos 로)
                fos.write(b);
                count++;
            }
        } catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }

        System.out.println(String.format("복사한 파일 크기 : %,d 바이트", count));
    }
    // count : 2,595,514
    // 소요시간 : 3,925,119,700 ns

    public static void copyByByteArray() {
        int b, count = 0;
        byte[] buffer = new byte[1024]; // 바이트 배열을 이용해서 1024바이트씩 입출력

        // try의 () 안에 close 해야 할 자원(리소스, 파일 입출력 스트림)을 선언하면 finally 없이 자동으로 close 합니다.
        // 이때 자원은 AutoCloseable 인터페이스 구현체여야 합니다.
        try (
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\image.jpg");
            FileOutputStream fos = new FileOutputStream("imagesCopy.png")
        ) {
            while((b=fis.read(buffer, 0, buffer.length)) != -1){ // read(배열이름, 시작위치, 최대길이) : 리턴값 b는 실제로 읽어온 바이트 수
                // 실제 길이가 1024바이트가 안될 수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할 수 있음
                fos.write(buffer, 0, b); // write(배열이름, 시작위치, 출력길이)
                count += b;
            }
        } catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }

        System.out.println(String.format("복사한 파일 크기 : %,d 바이트", count));
    }
    // 복사한 파일 크기 : 2,595,514 바이트
    // 소요시간 : 5,803,900 ns

    public static void copyByByteTimeCount() {
        long start = System.nanoTime(); // 시스템에서 시간측정할 수 있는 메소드 : 나노세컨드 10억분의 1, 밀리세컨드 1000분의 1

        copyByByte();

        long end = System.nanoTime();
        System.out.println(String.format("copyByByte 소요시간 : %,d ns", (end - start)));
    }

    public static void copyByByteArrayTimeCount() {
        long start = System.nanoTime();

        copyByByteArray();

        long end = System.nanoTime();
        System.out.println(String.format("copyByByteArray 소요시간 : %,d ns", (end - start)));
    }

    public static void copyByBuffer() {
        int b, count = 0;
        byte[] buffer = new byte[1024]; // => 버퍼에서 사용. (버퍼 입출력 스트림)

        try (
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\image.jpg");
            FileOutputStream fos = new FileOutputStream("imagesBufferCopy.png");
            BufferedInputStream bis = new BufferedInputStream(fis); // 보조 버퍼 입력스트림
            BufferedOutputStream bos = new BufferedOutputStream(fos); // 보조 버퍼 출력스트림
        ) {
            while((b=bis.read(buffer, 0, buffer.length)) != -1){
                bos.write(buffer, 0, b);
                count += b;
            }
        } catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }

        System.out.println(String.format("복사한 파일 크기 : %,d 바이트", count));
    }
    // 복사한 파일 크기 : 2,595,514 바이트
    // 소요시간 : 2,105,600 ns

    public static void copyByBufferTimeCount() {
        long start = System.nanoTime();

        copyByBuffer();

        long end = System.nanoTime();
        System.out.println(String.format("copyByBuffer 소요시간 : %,d ns", (end - start)));
    }

}
