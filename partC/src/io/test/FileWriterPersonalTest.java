package io.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterPersonalTest {
    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        try {
            File note = new File("C:\\Users\\Administrator\\Downloads\\note.txt");
            fw = new FileWriter(note, true);
            while (true) {
                System.out.print("파일에 입력할 내용 (종료: end) >>> ");
                String input = System.console().readLine();
                if (input.equals("end")) {
                    fw.flush();
                    fw.close();
                    break;
                }

                fw.write(input + "\n");
                fw.flush();
            }
        } catch (IOException e) {
            System.out.println("파일 라이터 예외 : " + e.getMessage());
        } finally {
            fw.close();
        }
    }
}
