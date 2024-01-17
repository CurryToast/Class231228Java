package io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class D10FileWriter {
    public static void main(String[] args) {
        writeByBuffer();
        // writeByPrintWriter();
    }

    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count = 0;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for(int i=0;i<10;i++) {
                // bufferedWriter.append("안녕하세요"+i+"\r\n"); // 기존 파일 뒤에 추가하기 => 단 FileWriter(filePath, true) 시에만
                bufferedWriter.write("안녕하세요"+i+"\r\n"); // 기존 파일에 덮어쓰기
                count++;
            }

        } catch (Exception e) { }

        System.out.println("저장한 라인수 : " + count);
    }

    public static void writeByPrintWriter(){
        String filePath = "단어장3.txt";
        int count = 0;
        File file = new File(filePath);

        // print,println 메소드 사용할 수 있음.
        try(PrintWriter pw = new PrintWriter(file,Charset.forName("UTF-8"))) {
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                pw.print("안녕하세요"+i+"\r\n");
                count++;
            }
        } catch (Exception e) { }

        System.out.println("저장한 라인수 : " + count);
    }
}
